# ScoreMain.py

from ScoreManager import ScoreManager

if __name__ == '__main__':
    m = ScoreManager()
    m.start()

# __name__ : 모듈의 이름이 저장되는 변수
# import로 모듈을 가져오면 모듈의 이름이 들어감
# 스크립트 파일을 직접 실행하면 모듈의 이름이 아닌 __main__이 들어감
