################# 3. 직접 쿼리 실행 방식 #################
from django.shortcuts import render, redirect
from django.db import connection
from common.CommonUtil import dictfetchall, CommonPage

def queryList(request, pg):
    cursor = connection.cursor()
        # cursor객체 : db에 데이터 읽고 쓰기 담당
    # sql = 'select * from app3_book order by id desc'
    # 전체 데이터 건수를 알아야 페이징이 가능하다
    # pg = 1
    sql = "SELECT count(*) FROM app3_book"
    cursor.execute(sql)
    totalCnt = int(cursor.fetchone()[0]) # 전체 데이터 개수
    cp = CommonPage(totalCnt, pg, 10)

    sql = f"""
        SELECT A.id, A.title, A.author, A.review, strftime('%Y-%m-%d', A.date) AS wdate, num
        FROM (
            SELECT id, title, author, date, review,
                row_number() OVER (ORDER BY id DESC) AS num,
                CAST((row_number() OVER (ORDER BY id DESC) - 1) / 10 AS INTEGER) AS pg
            FROM app3_book
        ) AS A
        WHERE A.pg = {pg}
        """
    cursor.execute(sql)
    # data = cursor.fetchall()
    # print(data)
    dataList = dictfetchall(cursor)
    print(cp)

    return render(request, "app3/book_list.html", {'books':dataList, 'commonPage':cp})

def queryDetail(request, pk):
    with connection.cursor() as cursor:
        cursor.execute(f"SELECT * FROM app3_book WHERE id={pk}")
        data = dictfetchall(cursor)
    return render(request, 'app3/book_detail.html', {'book': data[0]})
     
def queryCreate(request):
    if request.method == 'POST':
        title = request.POST.get('title')
        author = request.POST.get('author')
        review = request.POST.get('review')

        with connection.cursor() as cursor:
            cursor.execute("INSERT INTO app3_book (title, author, review, date) VALUES (%s, %s, %s, datetime('now','localtime'))", [title, author, review])
     
        return redirect('app3:query-list')
    
    else:
        success_url = '/app3/books/create/'
        return render(request, 'app3/book_create.html', {'success_url':success_url})

def queryUpdate(request, pk):
    if request.method == 'POST':
        title = request.POST.get('title')
        author = request.POST.get('author')
        review = request.POST.get('review')
        with connection.cursor() as cursor:
            cursor.execute("UPDATE app3_book SET title = %s, author = %s, review = %s WHERE id = %s", [title,author,review, pk])
    
        return redirect('app3:query-detail', pk=pk)
    
    else:
        with connection.cursor() as cursor:
            cursor.execute(f"SELECT * FROM app3_book WHERE id={pk}")
            data = dictfetchall(cursor)
        success_url = f'/app3/books/{pk}/update/'
        return render(request, 'app3/book_update.html', {'book':data[0], 'success_url':success_url})

def queryDelete(request, pk):
    if request.method == 'POST':
        with connection.cursor() as cursor:
            cursor.execute("DELETE FROM app3_book WHERE id = %s", [pk])
        return redirect('app3:query-list')
    success_url = f'/app3/books/{pk}/delete/'
    return render(request, 'app3/book_confirm_delete.html', {'success_url':success_url})