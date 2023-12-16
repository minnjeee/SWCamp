from django.contrib import admin
from django.urls import path

app_name = 'person' # 등록

from . import views # views : 화면에 보여지는 걸 담당
# redirect(app_name:name속성값)
# 목록화면, 등록화면, 상세화면
urlpatterns = [
    path('', views.index),
    path('list', views.list, name = 'list'), # 목록화면 이동
    path('write', views.write), # 등록화면 이동
    path('save', views.save), #등록
    path('view/<int:id>', views.view) # 상세화면 이동
]
