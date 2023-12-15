# proj/app1/views.py
from django.shortcuts import render # html과 연동할 때 사용
from django.shortcuts import redirect # 특정 페이지로 이동할 때 사용
from django.http import HttpResponse  # 요청에 대한 응답할 때 사용

# URL이 'app1/' 인 경우
def index(request):
    return HttpResponse("Hello Django") # 문자열을 브라우저에 출력

############### GET방식 공부 ###############
# URL이 'app1/add?x=1&y=2' 인 경우 (Get방식, 쿼리스트링)
def add(request):
    x = int(request.GET.get('x'))
    y = int(request.GET.get('y'))
    response = HttpResponse(f"{x} + {y} = {x+y}")
    return response
    
# URL이 'app1/sub/3/4' 인 경우 (Get방식, 경로변수)
def sub(request, x, y):
    result = f"{x} - {y} = {x-y}"
    response = HttpResponse(result)
    return response

############### 템플릿 파일 관련 공부 ###############
personList = [
    {'id':0, 'name':'김민지', 'phone':'010-2900-4039'},
    {'id':1, 'name':'김은지', 'phone':'010-4055-4039'},
]
# URL이 'app1/list'인 경우 (render함수, 템플릿 파일 연동)
def list(request):
    data = {'dataList':personList}
    return render(request, 'app1/person_list.html', data) # 탬플릿(html)파일과 연동

# URL이 'app1/write'인 경우 (render함수, 템플릿 파일 연동)
def write(request):
	# 보낼 데이터가 없다면 생략 가능
    return render(request, 'app1/person_write.html') 

# URL이 'app1/save'인 경우 (redirect함수, 특정 페이지로 이동)
def save(request): 
    name = request.POST.get('name')
    phone = request.POST.get('phone')
    personList.append({'name':name, 'phone':phone})
    return redirect('app1:list') # 'app1/list'URL로 이동