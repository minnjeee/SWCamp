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
from django.urls import path
from django.http import HttpResponse

def index(request):
    response = HttpResponse("<h1>mysite2 start</h1>")
    return response 

#함수들은 매개변수로 request를 가져와야하고 리턴은 response객체이어야 
#한다 
def test1(request):
    response = HttpResponse("<h1>test</h1>")
    return response 

def test2(request):
    response = HttpResponse("<h1>홍길동</h1>")
    return response 

#GET방식 POST방식 
#GET - 2048 byte 이내의 보안을 요하지 않는 간단한 정보 
#POST -  무한정, 보안을 요하는 자료 , 로그온 또는 회원가입 파일업로드

#GET전송방식 
#http://127.0.0.1:8000/add?x=7&y=8
# url /add 
# x라는 정보와 y라는 정보를 서버로 전송한다 
# ? 뒤에가 정보이다. 키1=값1&키2=값2&키3=값3 형태로 보낸다 
def add(request):
    x = int(request.GET.get('x')) #GET 방식 데이터 받아오기 
    y = int(request.GET.get('y'))
    
    response = HttpResponse(f"{x}+{y}={x+y}")
    return response 

#http://127.0.0.1:8000/sub?x=7&y=8
def sub(req):
    x = int(req.GET.get('x')) #GET 방식 데이터 받아오기 
    y = int(req.GET.get('y'))
    
    res = HttpResponse(f"{x}-{y}={x-y}")
    return res 

#GET 업그레이드 - 추천 
#http://127.0.0.1:8000/mul/5/6
#path("mul/<x>/<y>", mul)
def mul(req, x, y):
    x=int(x)
    y=int(y)
    res = HttpResponse(f"{x}*{y}={x*y}")
    return res 

#구구단 
#http://127.0.0.1:8000/gugu1?dan=5
def gugu1(req):
    dan = int(req.GET.get("dan"))
    print(dan)
    result = ""
    for i in range(1, 10):
        result += f"{dan} X {i} = {dan*i}<br/>"

    res = HttpResponse(result)
    return res 

#http://127.0.0.1:8000/gugu2/5
def gugu2(req, dan):
    result = ""
    for i in range(1, 10):
        result += f"{dan} X {i} = {dan*i}<br/>"

    res = HttpResponse(result)
    return res 

#http://127.0.0.1:8000/score/Tom/90/80/100  이름 국어 영어 수학 
# Tom의 총점은 270이고 평균은 90 입니다 
def score(req, name, kor, eng, mat):
    total = kor+eng+mat 
    avg = total/3 
    result = f"{name}의 총점은 {total}이고 평균은 {avg}입니다"
    res = HttpResponse(result)
    return res 

#http://127.0.0.1:8000/logon
def logon(req):
    userid = req.POST.get('userid')
    password = req.POST.get('password')

    res = HttpResponse(f"userid:{userid} password:{password}")
    return res

#다른 앱을 만들어서 연결하는거 아니면 url에 / 없음 
urlpatterns = [
    path("admin/", admin.site.urls),
    path("", index),
    path("test1", test1),  # url 과 함수를 연동한다 
    path("test2", test2),
    path("add",   add),
    path("sub",   sub),  
    path("mul/<x>/<y>", mul) ,
    path("gugu1", gugu1),
    path("gugu2/<int:dan>", gugu2),
    path("score/<name>/<int:kor>/<int:eng>/<int:mat>", score),
    path("logon", logon)
]
 




