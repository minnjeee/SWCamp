def dictfetchall(cursor):
    columns = [col[0].lower() for col in cursor.description]
        # cursor의 description에 각 필드 이름 정보(배열)
        # columns에는 ['id','title','contents','writer','wdate','hit']
    #print( cursor.description )
    """
    [('ID', <cx_Oracle.DbType DB_TYPE_NUMBER>, 20, None, 19, 0, 0), ('TITLE', <cx_Oracle.DbType DB_TYPE_NVARCHAR>, 100, 400, None, None, 1), ('WRITER', <cx_Oracle.DbType DB_TYPE_NVARCHAR>, 100, 400, None, None, 1), ('CONTENTS', <cx_Oracle.DbType DB_TYPE_NCLOB>, None, None, None, None, 1), ('WDATE', <cx_Oracle.DbType DB_TYPE_TIMESTAMP>, 23, None, 0, 6, 0), ('HIT', <cx_Oracle.DbType DB_TYPE_NUMBER>, 12, None, 11, 0, 0)]
    """
    return [dict(zip(columns,row)) for row in cursor.fetchall()]
        # row는 [1,'제목1','내용1','작성자1',...]
        # zip함수로 합치면 튜플형태 -> dict적용 : {'id':1, 'title':제목, ...}


# << < 1 2 3 4 5 6 7 8 9 10 > >>
# << : 첫 번째 페이지
# < : 현재 페이지로부터 앞으로 이동할 페이지가 있는지 찾아서 이전페이지
# 1, 2, 3, ..., 10 : 첫번째 그룹
    # 11 ~ 20 : 두번째 그룹
    # 21 ~ 30 : 세번째 그룹     ## 현재 13페이지이면 2번 그룹 (몫을 이용)
# > : 현재페이지로부터 뒤로 이동할 페이지가 있는지 찾아서 다음페이지로
# >> : 마지막 페이지
import math
class CommonPage:
    # 페이징에 필요한 3가지 정보
    # 1. totalCnt : 전체 데이터 개수
    # 2. pageSize : 한 페이지에 데이터를 몇 건씩 보여줄건지
        # 전체 페이지 개수 : totalCnt / pageSize (ex. 232/10 = 23.2 => 올림함수사용하여 24페이지 필요)
    # 3. curPage : 현재 페이지 
    def __init__(self, totalCnt=1, curPage=0, pageSize=10):
        self.curPage = curPage # 파이썬에서 클래스 설계 시 변수를 어디서 만들어야할지 모를 때는 가급적 생성자에서 변수를 만드는 게 낫다
        self.totalCnt = totalCnt
        self.pageSize = pageSize
        self.totalPage = math.ceil(totalCnt/pageSize) - 1
        self.start = (self.curPage//self.pageSize) *10
        self.end = self.start + 10
        if self.end > self.totalPage:
            self.end = self.totalPage + 1

        if self.curPage > 0: # 앞으로 이동가능
            self.isPrev = True
            self.prev_page = self.curPage - 1
        else: # 앞으로 이동 불가능
            self.isPrev = False
            self.prev_page = 0
            
        if self.curPage < self.totalPage: # 뒤로 이동가능
            self.isNext = True
            self.next_page = self.curPage + 1
        else: # 뒤로 이동 불가능
            self.isNext = False
            self.next_page = self.curPage

        self.page_range = range(self.start, self.end)