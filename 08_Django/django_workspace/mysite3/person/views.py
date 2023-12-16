from django.shortcuts import render
from django.http import HttpResponse

# Create your views here.

#list -> dict을 넣어서 데이터를 작성해보기
personList = [
    {'id':0, 'name':'김민지', 'phone':'010-2900-4039'},
    {'id':1, 'name':'김은지', 'phone':'010-4055-4039'},
    {'id':2, 'name':'박준영', 'phone':'010-9171-6138'},
]

def index(request):
    return HttpResponse("<h1>Person</h1>")

def list(request):
    #html과 연동 -> render사용
    data = {'dataList':personList}
    return render(request, 'person/person_list.html', data)

def write(request):
    return render(request, 'person/person_write.html')

from django.shortcuts import redirect

def save(request):
    name = request.POST.get('name')
    phone = request.POST.get('phone')
    personList.append({'name':name, 'phone':phone})
    # 등록 후 list 페이지로 이동
    # 보통 게시글 등록 후 list페이지로 이동하는 데, 직접 함수를 호출하지 못한다
    # 브라우저에서 정보를 보낸 것처럼 해야 한다.
    #  내부적으로 처리할 것이 많아서 직접 함수를 호출하지 않고 redirect 객체를 통해서 호출해야 한다
    return redirect('person:list')

# view/<int:id> 일 때는 함수의 매개변수로 옴
# get -> request.GET.get('form태그의 name속성')
# post -> request.POST.get('form태그의 name속성')
def view(request, id):
    if id < 0 or id > len(personList):
        return HttpResponse('데이터 없음')
    # html파일과 결합하려면 render함수 사용
    return render(request, 'person/person_view.html', {'data':personList[id]})