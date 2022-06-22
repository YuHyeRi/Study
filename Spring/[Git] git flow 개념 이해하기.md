# [Git] git flow 개념 이해하기
<br>

### *Git Flow란?*

소스코드를 관리하고 출시하기 위한 브랜치 관리 전략 중 하나이다. git flow는 git이 활성화되기 
시작하는 시기에 **Vincent Driessen**가 블로그 글에서 제안한 workflow 디자인을 기반으로 만들어
졌으며 현재는 많은 기업에서 git으로 개발할 때 표준으로 사용하는 개발 전략이다.
<br><br>
#### 💡 브랜치 관리 전략으로는 git flow 전략 외에도 github flow와 gitlab flow전략 등도 있다.
<br><br>
git flow에서 사용하는 브랜치의 종류는 5가지이며 

1. 항상 유지되는 메인 브랜치(Master, Develop)와 
2. 일정 기간 유지되는 보조 브랜치(feature, release, hostfix)로 나뉜다.
- **Master** : 제품으로 출시될 수 있는 브랜치
- **Develop** : 다음 출시 버전을 개발하는 브랜치
- **Feature** : 기능을 개발하는 브랜치
- **Realese** : 이전 출시 버전을 준비하는 브랜치
- **Hostfix** : 출시 버전에서 발생한 버그를 수정하는 브랜치
<br>
전반적인 git flow 전략 소스코드는 다음 이미지와 같이 관리하게 된다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/45691ba3-b91a-4bd3-8f0e-3315b1b56512/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220622%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220622T055052Z&X-Amz-Expires=86400&X-Amz-Signature=7731133822f30fd23ac154e65bacc855a4c7b5f578a4435d24e6697e519d2c55&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">
<br>
관리하는 순서를 정리하자면 다음과 같다.

1. repository를 생성하면 master 브랜치에 위치할 것이다.
2. 개발을 할 때는 develop 브랜치를 만들어 해당 브랜치에서 개발을 한다.
3. develop 브랜치에서도 특정 기능을 개발할 때는 feature 브랜치를 생성하여 개발한다.
4. feature 브랜치 개발이 끝나면 develop 브랜치로 pull request를 보낸다.
5. develop 브랜치의 개발 리더 또는 동료 직원들이 해당 request를 확인하고 문제가 없다면 
merge를 한다.
    1. merge 이후에는 feature 브랜치가 필요가 없으니 삭제 한다.
6. develop 브랜에서 어느정도 개발이 완료된다면 release 브랜치를 생성하여 QA를 진행한다.
    1. release 브랜치에서 발생한 버그들은 release 브랜치에서 수정한다.
7. QA를 통과하여 제품이 출시될 수 있다면 master와 develop 브랜치로 merge 한다.
8. 마지막 master 브랜치에 버전 태그를 추가한다.
<br>

#### 💡 QA (Quality Assurance) : 소프트웨어의 기획 의도나 목적에 따라 올바르게 구동하는가를 테스팅하여 제품의 이슈와 결함을 발견하고 제품의 품질을 높이는 것
<br>

#### 💡 이미 출시되어 master로 관리되고 있는 버전에서 버그가 발생하여 빠르게 수정을 해야하는 상황이 발생한다면 master 브랜치에서 hostfix 브랜치를 생성하고 오류를 수정하고 master와 현재 개발중인 develop 브랜치에 반영을 해준다.
<br>

👉 노션 : https://www.notion.so/Git-git-flow-0ea70154d8964f42a6e86b98d4a44a51
<br>
👉 출처 : [https://velog.io/@seongwon97/Git-Git-Flow-개념-이해하기](https://velog.io/@seongwon97/Git-Git-Flow-%EA%B0%9C%EB%85%90-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0)
