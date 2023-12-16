from django.shortcuts import render

# Create your views here.
from board.models import Board # 모델을 import

# ORM 방식 - 테이블이 복잡해지면 사용 불편
def list(request):
    # Board모델class 안에 objects 요소 (부모클래스에 존재)
    # boardList = Board.objects.all()
    boardList = Board.objects.order_by('-id') # id기준으로 내림차순
    return render(request, "board/board_list.html", {'boardList':boardList})

# 직접 쿼리 실행 방식
from django.db import connection 
    # settings.py 에서 지정한 디비 연결자를 가져옴
from common.CommonUtil import dictfetchall, CommonPage
def list2(request, pg):
    cursor = connection.cursor()
        # cursor객체 : db에 데이터 읽고 쓰기 담당
    # sql = 'select * from board_board order by id desc'
    # 전체 데이터 건수를 알아야 페이징이 가능하다
    # pg = 1
    sql = "select count(*) from board_board"
    cursor.execute(sql)
    totalCnt = int(cursor.fetchone()[0])
    cp = CommonPage(totalCnt, pg, 10)

    sql = f"""
        select A.id, A.title, A.writer, A.contents, to_char(A.wdate,'yyyy-mm-dd') wdate, A.hit, num
        from(
            select id, title, writer, contents, wdate, hit,
                row_number() over(order by id desc) num,
                ceil(row_number() over(order by id desc)/10)-1 pg
            from board_board) A
        where A.pg = {pg}
    """
    cursor.execute(sql)
    # data = cursor.fetchall()
    # print(data)
    boardList = dictfetchall(cursor)
    print(cp)

    return render(request, "board/board_list.html", {'boardList':boardList, 'commonPage':cp})