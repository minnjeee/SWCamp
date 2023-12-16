from django.urls import path, include #

from . import views

# list타입, path라이브러리는 url과 파일을 연결
# http://127.0.0.1:8000/pybo
# /pybo ===> pybo디렉토리의 urls.py 파일을 호출한다
# from board import views as boardViews # 다른이름으로 가져오자

urlpatterns = [
    path("add", views.add), # url이 getstudy/add 인 경우
    path("sub/<int:x>/<int:y>", views.sub), # url이 getstudy/sub/x/y 인 경우
    path("gugu", views.gugu), # url이 getstudy/gugu 인 경우
    path("gugu2/<int:dan>", views.gugu2), # url이 getsudy/gugu2/dan 인 경우

]

