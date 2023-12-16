from django.contrib import admin
from django.urls import path

app_name = 'study' # 등록

from . import views # views : 화면에 보여지는 걸 담당
# redirect(app_name:name속성값)
# 목록화면, 등록화면, 상세화면
# urlpatterns = [
#     path('list', views.list, name = 'list'), # 목록화면 이동
#     path('write', views.write), # 등록화면 이동
#     path('save', views.save), #등록
#     path('view/<int:id>', views.view) # 상세화면 이동
# ]

# html파일명 _list, _detail
from study.views import StudyList, StudyDetail
urlpatterns = [
    path("list", StudyList.as_view()),
    path("detail/<int:pk>", StudyDetail.as_view())
]