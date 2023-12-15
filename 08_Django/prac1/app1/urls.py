# proj/app1/urls.py
from django.urls import path
from . import views

# app_name = '앱명'
app_name = 'app1' # 앱 이름 등록

urlpatterns = [
	# path("'앱명/'다음에 오는 경로", views.함수명, name='url별칭'),
	path("", views.index, name='index'), # URL이 app1/
	
    ############### GET방식 공부 ###############
    path("add", views.add), # url이 app1/add 인 경우인 경우
    path("sub/<int:x>/<int:y>", views.sub), # url이 app1/sub/x/y 인 경우
    
    ############### 템플릿 파일 관련 공부 ###############
    path('list', views.list, name = 'list'), # url별칭을 list로 지정
    path('write', views.write),
    path('save', views.save),
    # 다른 URL 패턴과 뷰를 추가할 수 있음
]