# scoreData.py
# 클래스 - 한사람분의 데이터 분량
            # 생성자를 통해서 변수 만들고, 연산 함수
# 데이터를 작업할 클래스()
class Score:
    def __init__(self, name='홍길동', kor=0, eng=0, mat=0):
        # self = 나
        self.name = name
        self.kor = kor
        self.eng = eng
        self.mat = mat
        self.process() # 값 입력할 때마다 자동으로 총점 평균 구하기
    
    def process(self): # 총점, 평균, 등급을 구함
        self.total = self.kor + self.eng + self.mat
        self.avg = self.total/3
        if self.avg >= 90:
            self.grade = '수'
        elif self.avg >= 80:
            self.grade = '우'
        elif self.avg >= 70:
            self.grade = '미'
        elif self.avg >= 60:
            self.grade = '양'
        else:
            self.grade = '가'

    def toString(self): # 출력할 때 이 함수 호출해서 - 데이터 하나 분량 출력하기
        return f"{self.name} {self.kor} {self.eng} {self.mat} {self.total} {self.avg} {self.grade}"

print(__name__) # 내장변수 : 이 파일을 직접실행할 때는 __main__
            # 다른 파일에서 이 파일을 import하고 실행하면 scoreData
s1 = Score('홍길동', 90, 90, 100)
s1.process()
print( s1.toString() )