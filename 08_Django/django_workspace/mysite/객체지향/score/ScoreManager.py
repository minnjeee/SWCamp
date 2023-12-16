# ScoreManager.py

from scoreData import Score #scoreData.py에서 만든 class를 import

class ScoreManager:
    dataList = list() # 데이터를 담아두기 위한 객체
                        # 생성자에서 개체 만들어도 되고 여기다 만들어도 된다.

    def __init__(self):
        self.dataList.append(Score('A',90,80,70))
        self.dataList.append(Score('B',80,80,70))
        self.dataList.append(Score('C',70,70,70))

    def append(self): # 데이터를 추가한다
        data = Score() # 추가할 객체 만들고
        data.name = input('이름 : ') # 키보드로 데이터를 입력받고
        data.kor = int(input('국어 : ')) # 연산을 해야 하므로 입력받아 int함수를 이용해
        data.eng = int(input('영어 : ')) # 데이터형을 str -> int 로 전환해야 함
        data.mat = int(input('수학 : '))
        data.process() # 총점, 평균, 등급 구하기
        self.dataList.append(data) # 목록에 추가해야 계속 유지된다.

    def output(self):
        for data in self.dataList:
            print(data.toString())

    def search(self):
        name = input('찾을 이름 : ')
        resultList = list(filter(lambda score: score.name==name, self.dataList))
        for data in resultList:
            print(data.toString())

    def modify(self):
        name = input('수정할 이름 : ')
        resultList = list(filter(lambda score: score.name==name, self.dataList))
        if len(resultList) == 0:
            print(name + '을 찾을 수 없습니다')
            return # 여기서 함수 종료 (꿀팁!! 에러일 때 return사용하기)
        # 성공적일 때
        score = resultList[0]
        score.name = input('바꿀 이름 : ')
        score.kor = int(input('국어 : '))
        score.eng = int(input('영어 : '))
        score.mat = int(input('수학 : '))
        score.process()

    def delete(self):
        name = input('삭제할 이름 : ')
        resultList = list(filter(lambda score: score.name==name, self.dataList))
        if len(resultList)==0:
            print(name + '을 찾을 수 없습니다')
            return # 여기서 함수 종료
        self.dataList.remove(resultList[0])

    def sort(self):
        sortList = sorted(self.dataList, key=lambda x:x.total, reverse=True)
        for data in sortList:
            print(data.toString())

    def menuDisplay(self):
        print('1. 전체출력')
        print('2. 추가   ')
        print('3. 검색   ')
        print('4. 수정   ')
        print('5. 삭제   ')
        print('6. 정렬   ')
        print('0. 종료')
    
    def start(self):
        while True: # 무한 루프
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
