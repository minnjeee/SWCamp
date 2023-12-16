from django.shortcuts import render, redirect
from django.http import HttpResponse

personList = [
    {'id':0, 'name':'김민지', 'phone':'010-2900-4039'},
    {'id':1, 'name':'김은지', 'phone':'010-4055-4039'},
    {'id':2, 'name':'박준영', 'phone':'010-9171-6138'},
]

def index(request):
    return HttpResponse("<h1>Person</h1>")

def list(request):
    data = {'dataList':personList}
    return render(request, 'person/person_list.html', data) # html과 연동 -> render사용

def write(request):
    return render(request, 'person/person_write.html')

def save(request):
    name = request.POST.get('name')
    phone = request.POST.get('phone')
    personList.append({'name':name, 'phone':phone})
    return redirect('person:list')