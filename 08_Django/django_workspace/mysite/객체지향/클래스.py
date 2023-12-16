# 클래스 - 하사람분의 데이터
class Person:
    name = '홍길동' # 파이썬은 그냥 쓰다가 변수의 값을 바꿀 때 새로 만든다
    phone = '010-0000-0000'
    # 클래스 정의할 때 딱 한번 만들어진다.
    # 여기서 list나 dict타입 등 만들면 충돌 발생 가능
    # 생성자는 객체가 생성될 때 자동으로 호출되는 메서드(함수)
    # 생성자는 시스템이 호출 (내가 만들면 시스템이 호출) 
    # __init__ : 생성자 이름, 정해져 있음
    # 파이썬은 파일 안에 함수 이름이 하나이어야 함. 클래스 안에서 동일한 이름의 함수 생성 불가
    # 객체지향언어의 특징 : 추상성, 은닉성, 다형성, 상속성
    # 추상성, 상속성. 최근 경향이 은닉성을 약화시킴
    # 다형성 : 이름이 하나인데 모습이 다르다. print(4) print("a") print(4,5)
        # 다른 프로그래밍 언어는 각각의 print를 만들지만, 파이썬은 print 하나를 같이 사용
        # 파이썬에서는 다형성을 기본값으로 지원.
    
    def __init__(self, name='', phone='', address=''): # 첫번째 매개변수 반드시 self
        self.name = name
        self.phone = phone
        self.address = address
        print('생성자 호출')

    def output(self) : # 클래스안에 있는 함수는 첫번째 매개변수가 self
                       # 객체 자신에 대한 참조
        print(self.name, self.phone, self.address)

# 객체 만들기
p1 = Person()
p1.output()

p1.name = '임꺽정' # 변수 공간이 새로 만들어짐 (메모리 절약해줌)

p2 = Person('임꺽정')
p3 = Person('장길산', '010-0000-0001')
p4 = Person('강감찬', '010-0000-0002','낙성대')

p1.output()
p2.output()
p3.output()
p4.output()


# 객체 배열 만들기
personList = [
    Person('A', '1', '총신대역'),
    Person('B', '2', '낙성대역'),
    Person('C', '3', '신림역'),
    Person('D', '4', '봉천역'),
    Person('E', '5', '서울대입구역')
]

for person in personList:
    person.output()