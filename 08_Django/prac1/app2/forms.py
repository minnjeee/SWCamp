# 앱명/forms.py
from django import forms
from .models import Song

class SongForm(forms.ModelForm):
    class Meta:
        model = Song
        fields = ['title', 'singer', 'score'] # 폼에서 사용할 모델 클래스의 속성명
        labels = {'title':'노래 제목', 'singer':'가수', 'score':'별점'} # 폼에서 각 속성을 표시할 문자열