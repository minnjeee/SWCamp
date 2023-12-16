# 람다 = 1줄짜리 쓰고 버리는 함수
# 함수를 만들 때 이름도 없고 그냥 한줄짜리 만들어서 쓰고 버리는 함수
# lamda 매개변수들 : 처리코드
'''
def add(x, y):
    return x + y

add = lambda x,y: x+y
'''
add = lambda x,y: x+y #return 구문 생략
print(add(4,5))
# 일반함수들은 메모리를 항상 차지하고 있음
# 람다는 메모리를 항상 차지할 필요 없음(잠깐 쓰고 버리는 것)


nums = [4,23,2,11,15,41,7,9,12]
evenList = [] # 짝수
oddList = [] # 홀수

for i in range(0, len(nums)):
    if nums[i]%2 == 0:
        evenList.append(nums[i])
    else:
        oddList.append(nums[i])

print( evenList )
print( oddList )

# filter(함수, list타입) : 함수를 두번째 매개변수로 전달된 리스트에 요소마다 한번씩 호출
                    # : 첫번째인자로 전달되는 함수는 매개변수가 하나고, 반환값이 True/False
                    #   True인 것만 보내줌
def even(x):
    if x%2 == 0 :
        return True
    else:
        return False
evenList = []
evenList = list(filter(even, nums))
print( evenList )
# even 함수는 자주 쓰이지 않는다 굳이 함수로 선언해야할까!!
# lambda를 써보자
evenList =[]
evenList = list(filter(lambda x: x%2==0, nums))
print( evenList )

# h로 시작하는 문자열 가져오기
wordList = ['school','person','lunch','desk','hospital','house']
hList = []
hList = list(filter(lambda w: w.startswith('h'), wordList))
print( hList )