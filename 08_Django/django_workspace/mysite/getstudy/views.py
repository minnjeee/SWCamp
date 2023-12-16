from django.shortcuts import render
from django.http import HttpResponse

# Create your views here.

def add(request):
    x = int(request.GET.get('x'))
    y = int(request.GET.get('y'))
    response = HttpResponse(f"{x} + {y} = {x+y}")
    return response

def sub(request, x, y):
    response = HttpResponse(f"{x} - {y} = {x-y}")
    return response

def gugu(request):
    d = int(request.GET.get('dan'))
    result = f"{d}단<br>"
    for i in range(1, 10):
        result += f"{d} X {i} = {d*i}<br>"
    res = HttpResponse(result)
    return res 

def gugu2(request, dan):
    result = f"{dan}단<br>"
    for i in range(1,10):
        result += f"{dan} x {i} = {dan*i}<br>"
    res = HttpResponse(result)
    return res