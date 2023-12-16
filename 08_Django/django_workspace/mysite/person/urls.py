from django.contrib import admin
from django.urls import path

app_name = 'person' # 등록

from . import views # views : 화면에 보여지는 걸 담당
# redirect(app_name:name속성값)
# 목록화면, 등록화면, 상세화면
urlpatterns = [
    path('', views.index),
    path('list', views.list, name="list"),  # name속성 : url 별칭을 list로 지정
    path('write', views.write), 
    path('save', views.save), 
    # path('view/<int:id>', views.view) # 상세화면 이동
]
