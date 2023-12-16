
from django.contrib import admin
from django.urls import path
from . import views
urlpatterns = [
    path("list/", views.list), # orm 방식
    path("list2/<int:pg>", views.list2), # 직접 쿼리 실행
]
