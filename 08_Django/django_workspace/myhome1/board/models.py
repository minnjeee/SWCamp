from django.db import models

# Create your models here.
# 테이블스키마를 직접 안 만들고 여기서 클래스를 만들고
# migrations - 필요한 쿼리 생성
# migrate를 호출하면 테이블이 생성됨
class Board(models.Model) :
    title = models.CharField('제목', max_length=400)
    writer = models.CharField("작성자", max_length=40)
    contents = models.TextField("내용")
    wdate = models.DateTimeField() # 작성일
    hit = models.IntegerField( ) #조회수
    title = models.CharField()