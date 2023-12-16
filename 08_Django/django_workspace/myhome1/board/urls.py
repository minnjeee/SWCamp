
from django.contrib import admin
from django.urls import path


from . import views
from board.views import BoardList, BoardDetail



app_name = 'board'



urlpatterns = [ # .as_view() : html문서에 연결
    path("list", BoardList.as_view(), name=list), # /board/board_list.html
    path("detail/<int:pk>", BoardDetail.as_view()), # /board/board_detail.html
    
    ###################################################
    
    path("write", views.write),
    path("save", views.save),
]
