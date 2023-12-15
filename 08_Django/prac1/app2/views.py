# app2/views.py

from .models import Song

################# 1. Generic View 방식 #################
from django.views.generic.edit import CreateView, UpdateView, DeleteView
from django.views.generic import ListView, DetailView

# 모델의 데이터 조회
class genericList(ListView):
    model = Song
    template_name = 'song_list.html'
    context_object_name = 'songs' # 기본으로 템플릿에서 사용되는 이름은 object_list
    
class genericDetail(DetailView):
    model = Song
    template_name = 'app2/song_detail.html'
    context_object_name = 'song'
    
# 모델의 데이터 생성
class genericCreate(CreateView):
    model = Song
    fields = ['title', 'singer', 'score']
    success_url = '/app2/songs/' # 성공하면 리스트로 이동
    template_name = 'app2/song_create.html'

	
 # 모델의 데이터 수정
class genericUpdate(UpdateView):
    model = Song
    fields = ['title', 'singer', 'score']
    template_name = 'app2/song_update.html'
    context_object_name = 'song'
    success_url = '/app2/songs/'
 
 # 모델의 데이터 삭제
class genericDelete(DeleteView):
    model = Song
    template_name = 'app2/song_confirm_delete.html'
    context_object_name = 'song'
    success_url = '/app2/songs/'


################# 2. ORM 방식(객체-관계 매핑) #################
from django.shortcuts import render, redirect
from .forms import SongForm

def ormList(request):
    dataList = Song.objects.all() # 모든 요소 가져오기
    return render(request, "app2/song_list.html", {'songs':dataList})

def ormDetail(request, pk):
    data = Song.objects.get(id=pk)
    return render(request, 'app2/song_detail.html', {'song': data})
     
def ormCreate(request):
    ## 1) Form 클래스 사용 안한 경우
    # if request.method == 'POST':
    #     title = request.POST.get('title')
    #     singer = request.POST.get('singer')
    #     score = request.POST.get('score')
    #     song = Song(title=title, singer=singer, score=score)
    #     song.save()
    #     return redirect('app2:orm-list')
    # else:
    #     success_url = '/app2/songs/create/'
    #     return render(request, 'app2/song_create.html', {'success_url':success_url})

    ## 2) Form 클래스 사용 한 경우
    if request.method == 'POST':
        form = SongForm(request.POST)
        if form.is_valid():
            form.save()
            return redirect('app2:orm-list')
    else:
        form = SongForm()
        success_url = '/app2/songs/create/'
        return render(request, 'app2/song_create.html', {'form': form, 'success_url':success_url})

def ormUpdate(request, pk):
    data = Song.objects.get(id=pk)
    ## 1) Form 클래스 사용 안한 경우
    # if request.method == 'POST':
    #     title = request.POST.get('title')
    #     singer = request.POST.get('singer')
    #     score = request.POST.get('score')

    #     data.title = title
    #     data.singer = singer
    #     data.score = score
    #     data.save()
    #     return redirect('app2:orm-detail', pk=pk)
    # else:
    #     success_url = f'/app2/songs/{pk}/update/'
    #     return render(request, 'app2/song_update.html', {'song':data, 'success_url':success_url})
        
    ## 2) Form 클래스 사용 한 경우
    if request.method == 'POST':
        form = SongForm(request.POST, instance=data)
        if form.is_valid():
            form.save()
            return redirect('app2:orm-detail', pk=pk)
    else:
        form = SongForm(instance=data)
        success_url = f'/app2/songs/{pk}/update/'
        return render(request, 'app2/song_update.html', {'form': form, 'song': data, 'success_url':success_url})
        
def ormDelete(request, pk):
    data = Song.objects.get(id=pk)
    if request.method == 'POST':
        data.delete()
        return redirect('app2:orm-list')
    success_url = f'/app2/songs/{pk}/delete/'
    return render(request, 'app2/song_confirm_delete.html', {'song': data, 'success_url':success_url})


################# 3. 직접 쿼리 실행 방식 #################
# from django.shortcuts import render, redirect
from django.db import connection

def dictfetchall(cursor):
    columns = [col[0] for col in cursor.description]
    return [dict(zip(columns, row)) for row in cursor.fetchall()]

def queryList(request):
    with connection.cursor() as cursor:
        cursor.execute("SELECT * FROM app2_song")
        dataList = dictfetchall(cursor)
    return render(request, "app2/song_list.html", {'songs':dataList})

def queryDetail(request, pk):
    with connection.cursor() as cursor:
        cursor.execute(f"SELECT * FROM app2_song WHERE id={pk}")
        data = dictfetchall(cursor)
    return render(request, 'app2/song_detail.html', {'song': data[0]})
     
def queryCreate(request):
    if request.method == 'POST':
        title = request.POST.get('title')
        singer = request.POST.get('singer')
        score = request.POST.get('score')

        with connection.cursor() as cursor:
            cursor.execute("INSERT INTO app2_song (title, singer, score, date) VALUES (%s, %s, %s, datetime('now','localtime'))", [title, singer, score])
     
        return redirect('app2:query-list')
    
    else:
        success_url = '/app2/songs/create/'
        return render(request, 'app2/song_create.html', {'success_url':success_url})

def queryUpdate(request, pk):
    if request.method == 'POST':
        title = request.POST.get('title')
        singer = request.POST.get('singer')
        score = request.POST.get('score')
        with connection.cursor() as cursor:
            cursor.execute("UPDATE app2_song SET title = %s, singer = %s, score = %s WHERE id = %s", [title,singer,score, pk])
    
        return redirect('app2:query-detail', pk=pk)
    
    else:
        with connection.cursor() as cursor:
            cursor.execute(f"SELECT * FROM app2_song WHERE id={pk}")
            data = dictfetchall(cursor)
        success_url = f'/app2/songs/{pk}/update/'
        return render(request, 'app2/song_update.html', {'song':data[0], 'success_url':success_url})

def queryDelete(request, pk):
    if request.method == 'POST':
        with connection.cursor() as cursor:
            cursor.execute("DELETE FROM app2_song WHERE id = %s", [pk])
        return redirect('app2:query-list')
    success_url = f'/app2/songs/{pk}/delete/'
    return render(request, 'app2/song_confirm_delete.html', {'success_url':success_url})