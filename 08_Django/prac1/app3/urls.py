# proj/app2/urls.py
from django.urls import path
from . import views

app_name = 'app3' # 앱 이름 등록

urlpatterns = [

    ################# 3. 직접 쿼리 실행 방식 #################
    path('books/<int:pg>', views.queryList, name='query-list'),
 	path('books/<int:pk>/', views.queryDetail, name='query-detail'),
 	path('books/create/', views.queryCreate, name='query-create'),
 	path('books/<int:pk>/update/', views.queryUpdate, name='query-update'),
 	path('books/<int:pk>/delete/', views.queryDelete, name='query-delete'),
    
	# 다른 URL 패턴과 뷰를 추가할 수 있음
]