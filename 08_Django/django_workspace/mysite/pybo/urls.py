from django.contrib import admin
from django.urls import path #

# . : 동일한 폴더에 있는 views라는 파일을 사용
# from pybo import views #
from . import views

# list타입, path라이브러리는 url과 파일을 연결
# http://127.0.0.1:8000/pybo
# /pybo ===> pybo디렉토리의 urls.py 파일을 호출한다
# /pybo -> views.index함수가 호출됨
urlpatterns = [
    path("", views.index), # url이 pybo/인 경우
]