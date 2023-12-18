# 앱명/forms.py
from django import forms
from .models import Book

class BookForm(forms.ModelForm):
    class Meta:
        model = Book
        fields = ['title', 'author', 'review'] # 폼에서 사용할 모델 클래스의 속성명
        labels = {'title':'책 제목', 'author':'저자', 'review':'리뷰'} # 폼에서 각 속성을 표시할 문자열