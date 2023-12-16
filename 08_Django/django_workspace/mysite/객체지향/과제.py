# 주급계산

# 이름, 시간당급여액, 근무시간
# 홍길동    20000       30   주급계산 = 600000

class Salary:

    def __init__(self, name='홍길동', hourlySalary = 20000, workingHours=30):
        self.name = name
        self.hourlySalary = hourlySalary
        self.workingHours = workingHours
        self.process() # 값 입력할 때마다 자동 주급계산

    def process(self):
        self.weeklyWage = self.hourlySalary * self.workingHours

    def toString(self):
        return f"{self.name} - 시간당급여액:{self.hourlySalary}원, 근무시간:{self.workingHours}시간 => 주급:{self.weeklyWage}원"
    
# s1 = Salary('김민지',11000,15)
# s1.process()
# print( s1.toString() )




class SalaryManager:
    dataList = list() # 빈 리스트

    def __init__(self): # 기본값으로 4개의 데이터를  빈 리스트에 추가
        self.dataList.append(Salary('김민지',11000,15))
        self.dataList.append(Salary('이호준',18000, 20))
        self.dataList.append(Salary('김윤정',20000,30))
        self.dataList.append(Salary('김동현', 15000, 15))

    def output(self): # 데이터 목록 출력
        for data in self.dataList:
            print(data.toString())

    def append(self): # 데이터 추가
        data = Salary() # 추가할 객체 생성
        data.name = input('이름 : ') # 데이터 입력받기
        data.hourlySalary = int(input('시간당 급여 : '))
        data.workingHours = int(input('근무시간 : '))
        data.process() # 주급계산
        self.dataList.append(data) # 목록에 추가

    def search(self): # 데이터 검색
        name = input('검색할 이름 : ') # 검색할 이름 입력받기
        resultList = list(filter(lambda x: x.name==name, self.dataList)) # 데이터 목록에서 이름일치하는 데이터들의 리스트 생성
        if len(resultList) == 0:
            print(name + '을 찾을 수 없습니다.')
            return
        for data in resultList:
            print(data.toString())

    def modify(self): # 데이터 수정
        name = input('수정할 이름 : ')
        resultList = list(filter (lambda x:x.name==name, self.dataList))
        if len(resultList) == 0:
            print(name + '을 찾을 수 없습니다.')
            return
        data = resultList[0]
        data.name = input('새로운 이름 : ')
        data.hourlySalary = int(input('시간당 급여 : '))
        data.workingHours = int(input('근무시간 : '))
        data.process() # 주급계산

    def delete(self): # 데이터 삭제
        name = input('삭제할 이름 : ')
        resultList = list(filter (lambda x:x.name==name, self.dataList))
        if len(resultList) == 0:
            print(name + '을 찾을 수 없습니다.')
            return
        self.dataList.remove(resultList[0])

    def sort(self): # 데이터를 주급 기준으로 내림차순 정렬
        sortList = sorted(self.dataList, key=lambda x:x.weeklyWage, reverse=True)
        for data in sortList:
            print(data.toString())

    def menuDisplay(self): # 메뉴 보여주기
        print('1 : 목록 출력')
        print('2 : 추가')
        print('3 : 검색')
        print('4 : 수정')
        print('5 : 삭제')
        print('6 : 정렬')
        print('0 : 종료')

    def start(self): # 시작 (메뉴 선택)
        while True:
            self.menuDisplay()
            sel = input('선택 : ')
            if sel == '1':
                self.output()
            elif sel=='2':
                self.append()
            elif sel=='3':
                self.search()
            elif sel =='4':
                self.modify()
            elif sel == '5':
                self.delete()
            elif sel == '6':
                self.sort()
            elif sel =='0':
                return #함수 종료
            

if __name__ == '__main__': # __name__ : 모듈의 이름이 저장되는 변수
                                    # import 하면 모듈의 이름이 저장되고,
                                    # 스크립트 파일을 직접 실행하면 모듈이름이 아닌 __main__이 저장
    m = SalaryManager()
    m.start()