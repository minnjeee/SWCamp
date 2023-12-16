# 기본값 : 함수의 매개변수에 기본값을 할당하면 함수를 여러가지 방법으로 다양하게 호출할 수 있다

def myfunc(a=1, b=2, c=3):
    return a+b+c

print(myfunc()) # 1 + 2 + 3
print(myfunc(10)) # 10 + 2 + 3
print(myfunc(10,20)) # 10 + 20 + 3
print(myfunc(10,20,30)) # 10+ 20 + 30
print(myfunc(b=100)) # 1 + 100 + 3
print(myfunc(c=100, b=200)) # 1 + 200 + 100
# 변수를 지정해주지 않으면 앞에서 하나씩 할당
# 변수 지정 시 순서 상관 x