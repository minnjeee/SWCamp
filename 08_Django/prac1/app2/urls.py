# proj/app2/urls.py
from django.urls import path
from . import views

app_name = 'app2' # 앱 이름 등록

urlpatterns = [
	# path("'앱명/'다음에 오는 경로", views.함수명, name='url별칭'),
	# path("", views.index, name='index'), # URL이 app2/

    ################# 1. Generic View 방식 #################
    # path('songs/', views.genericList.as_view(), name='generic-list'),
 	# path('songs/<int:pk>/', views.genericDetail.as_view(), name='generic-detail'),
    # path('songs/create/', views.genericCreate.as_view(), name='generic-create'),
    # path('songs/<int:pk>/update/', views.genericUpdate.as_view(), name='generic-update'),
    # path('songs/<int:pk>/delete/', views.genericDelete.as_view(), name='generic-delete'),

    ################# 2. ORM 방식(객체-관계 매핑) #################
    path('songs/', views.ormList, name='orm-list'),
 	path('songs/<int:pk>/', views.ormDetail, name='orm-detail'),
 	path('songs/create/', views.ormCreate, name='orm-create'),
 	path('songs/<int:pk>/update/', views.ormUpdate, name='orm-update'),
 	path('songs/<int:pk>/delete/', views.ormDelete, name='orm-delete'),

    ################# 3. 직접 쿼리 실행 방식 #################
    # path('songs/', views.queryList, name='query-list'),
 	# path('songs/<int:pk>/', views.queryDetail, name='query-detail'),
 	# path('songs/create/', views.queryCreate, name='query-create'),
 	# path('songs/<int:pk>/update/', views.queryUpdate, name='query-update'),
 	# path('songs/<int:pk>/delete/', views.queryDelete, name='query-delete'),
    
	# 다른 URL 패턴과 뷰를 추가할 수 있음
]