from django.shortcuts import render

# Create your views here.

from django.views.generic import ListView, DetailView
from board.models import Board

class BoardList(ListView): # 목록 자료 : object_list로 전달
    model = Board

class BoardDetail(DetailView): # 상세 자료 : object로 전달
    model = Board


####################################################################

from django.shortcuts import redirect
from board.forms import BoardForm
from django.utils import timezone

def write(request):
    context = {"form": BoardForm(request.POST)}
    return render(request, "board/board_write.html", context)

def save(request):
    form = BoardForm(request.POST)
    board = form.save(commit=False) # 임시 저장
    board.wdate = timezone.now()
    board.hit = 0
    board.save()
    return redirect("board:list") ##app_name,path(name) 지정하기
