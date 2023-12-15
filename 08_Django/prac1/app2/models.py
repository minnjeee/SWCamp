from django.db import models

# Create your models here.

class Song(models.Model):
    title = models.CharField(max_length=50) # 노래 제목
    singer = models.CharField(max_length=50) # 가수
    date = models.DateTimeField(auto_now = True) # 내가 등록한 날
        # auto_now = True : 수정일자 기준, django model 이 save 될 때마다 현재날짜(date.today()) 로 갱신
        # auto_now_add = True : 생성일자 기준, django model 이 최초 저장(insert) 시에만 현재날짜(date.today()) 를 적용 (insert 시에만 적용)
        # 출처: https://tomining.tistory.com/145 [마이너의 일상:티스토리]
    score = models.IntegerField() # 내가 준 별점

    def __str__(self):
        return self.title