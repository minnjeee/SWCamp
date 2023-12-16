nums = [1,3,2,4,5,8,10,11,13,19,22,27]

# 짝수만 - 컴프리핸션
#       [변수명 for 변수명 in 반복자]
nums2 = nums # 객체 복사 (얕은 복사, 참조만 복사) 
                # => nums와 nums2는 같은 데이터 공간을 가짐

nums2[0] = 100
print( nums )
print( nums2 ) # 결과가 동일!!
# 변수 공간 = stack    |     데이터 공간 = heap
# 변수는 데이터 공간의 첫번째 요소만 가리킴
# 데이터 공간 내의 각 요소는 다음 요소를 가리킴
# nums2는 nums와 동일하게 같은 첫 번째 요소를 가리킴 => 얕은 복사(soft copy)
# 깊은 복사 : 새로운 변수를 생성하고 요소를 하나하나 옮겨야함

nums3 = [num for num in nums] # 축약을 이용한 깊은 복사
nums3[0] = 1
print('-'*50)
print(nums)
print(nums2)
print(nums3)


print('-'*50)
nums4 = [x*10 for x in nums]
print(nums4)

# [변수명 for 변수명 in 반복자 if 조건식] : 조건식이 True인 값만 보냄

evenList = [x for x in nums if x%2==0]
print( evenList )

oddList = [x for x in nums if x%2==1]
print( oddList )

dataList = [
    {'name':'홍길동', 'age':12},
    {'name':'임꺽정', 'age':11},
    {'name':'장길산', 'age':13},
    {'name':'홍명희', 'age':15},
    {'name':'홍경래', 'age':14}
]
# 나이가 13살 이상인 사람만
age13 = [data for data in dataList if data['age'] >= 13]
print(age13)
# 성이 홍씨인 사람만
nameHong = [data for data in dataList if data['name'][0]=='홍']
resultList = [data for data in dataList if data['name'].startswith('홍')] # 선생님 풀이
print(nameHong)
print(resultList)