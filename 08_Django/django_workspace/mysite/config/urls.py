"""
URL configuration for config project.

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/4.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path, include #

# pybo 패키지로부터 views.py 로딩
from pybo import views #

# list타입, path라이브러리는 url과 파일을 연결
# http://127.0.0.1:8000/pybo
# /pybo ===> pybo디렉토리의 urls.py 파일을 호출한다
# from board import views as boardViews # 다른이름으로 가져오자

urlpatterns = [
    path('admin/', admin.site.urls),
    path('pybo/', include('pybo.urls')), #
    # path('board/', boardViews.index)
    path('getstudy/', include('getstudy.urls')),
    path('person/', include('person.urls')),
]

