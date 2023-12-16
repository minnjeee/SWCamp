from django.shortcuts import render
from django.http import HttpResponse
from django.shortcuts import redirect
# Create your views here.
studyList = [
    {'id':0, 'name':'minjee', 'kor':70, 'eng':80, 'mat':100},
    {'id':1, 'name':'eunjee', 'kor':85, 'eng':80, 'mat':100}
]


# def list(request):
#     data = {'studyList':studyList}
#     return render(request, 'study/study_list.html', data)

# def view(request, id):
#     if id<0 or id>=len(studyList):
#         return HttpResponse('데이터가 없습니다')
#     data = {'study':studyList[id]}
#     return render(request, 'study/study_view.html', data)

# 장고프레임워크가 제공한다
from django.views.generic import ListView, DetailView
from study.models import Study
class StudyList(ListView):
    model = Study
    # 테이블 모듈명_모듈명 (study_study) : 테이블에서 데이터를 읽어온다
    # 내부에 object_list라는 변수가 있는데 이 변수에 값을 저장하고
    # templates/study/study_list.html파일을 호출하라

class StudyDetail(DetailView):
    model = Study

def write(request):
    return render(request, 'study/study_write.html')

def save(request):
    name = request.POST.get('name')
    kor = request.POST.get('kor')
    eng = request.POST.get('eng')
    mat = request.POST.get('mat')
    id = len(studyList) # 자동증가되도록
    studyList.append({'id':id, 'name':name, 'kor':kor, 'eng':eng, 'mat':mat})
    return redirect('study:list')