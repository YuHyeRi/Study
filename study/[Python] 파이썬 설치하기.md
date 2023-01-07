# [Python] 파이썬 설치하기

**파이썬 2.X 버전과 3.X 버전의 차이점**

파이썬은 공식적으로 2.X 버전과 3.X 버전의 두 가지 버전으로 나누어 관리되고 있다.

파이썬 2.X 버전과 3.X 버전의 대표적인 차이점은 다음과 같다.

1. 3.X 버전에서는 모든 변수가 객체(object)로 처리됨
2. 2.X 버전에서는 나눗셈의 결과가 int형으로 반환되었으나 3.X 버전에서는 float형으로 반환됨
3. 3.X 버전에서는 print함수를 사용할 때 소괄호(())를 반드시 사용하도록 변경됨
4. 3.X 버전에서는 모든 문자열을 유니코드로 인식함

3.X 버전에서는 위와 같이 2.X버전에 비해 많은 변화가 있지만, 이처럼 두 버전을 각각 유지하는 가장 큰 이유는 바로 라이브러리의 호환성 때문이다.

3.X 버전이 나온 초기에 그때까지 잘 사용해 온 2.X 버전을 기준으로 개발된 다양한 파이썬 라이브
러리들이 3.X 버전과는 호환되지 않았다. 따라서 파이썬 라이브러리를 사용하지 못하는 경우가 많이 발생하였으므로, 많은 파이썬 개발자들이 최신버전인 3.X 버전이 아닌 2.X 버전을 고집하게 된다.
그러나 현재는 가장 많이 사용되는 대부분의 파이썬 라이브러리들이 3.X 버전에서도 동작되도록 
업데이트되었기 때문에 반드시 2.X 버전을 사용해야만 하는 이유가 없어졌다.

<aside>
💡 파이썬 3.X 버전은 2.X 버전으로의 하위호환성을 지원하지 않는다. 즉, 파이썬 2.X 버전으로 작성된 소스 코드를 수정없이 그대로 3.X 버전에서 사용하면 문제가 발생할 가능성이 매우 높다.

</aside>

---

**파이썬 설치하기**

파이썬은 오픈 소스 라이센스를 가지므로, 언제 어디서든 자유롭게 다운로드 하여 사용할 수 있다. 
파이썬의 최신 버전은 파이썬 공식 홈페이지인 www.python.cog에 접속하여 다운로드 받을 수 있다.

1. Downloads 탭을 클릭하여 가장 최신 버전인 Python 3.X를 선택하고 다운로드 한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/a6e935b6-3ed7-4898-8942-92126be9a974/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230107%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230107T054719Z&X-Amz-Expires=86400&X-Amz-Signature=3623ac5bee78c3bf8f8b8038bfae833823a72cfddad5794f3e89fdaf2bd51237&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

2. 다운로드한 설치 파일을 클릭하여 실행한다.
3. Add Python 3.6 to PATH를 체크한 후, Customize installation 버튼을 클릭한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/2df31d92-fcc5-45a0-89cc-f30a69c4427c/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230107%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230107T054733Z&X-Amz-Expires=86400&X-Amz-Signature=532479ba1d9f54a215b73b476e2e1cd6f15b7f134a2edef9ecd1e589a8b77a3d&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

4. Next 버튼을 클릭한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/5adae73f-2f47-48bc-b1ef-605f2e0dada0/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230107%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230107T054748Z&X-Amz-Expires=86400&X-Amz-Signature=248a76239c2c3deddaac8d0c229d145487852d7af8936174326785db3d02a6b8&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

5. 파이썬을 설치할 폴더를 설정하고 Install 버튼을 눌러 설치한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/e80547aa-e663-4205-aaa5-1dc31be71f76/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230107%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230107T054801Z&X-Amz-Expires=86400&X-Amz-Signature=2df185c492f52cb2c791458dafdf449623878c66101c2e58b6435dab61008bae&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

6. 설치 진행이 완료된 후에 Close 버튼을 눌러 설치를 완료한다.
7. 파이썬이 제대로 설치되었는지를 확인하기 위해 윈도우키 + R을 눌러 실행 대화샂아를 연 후 ‘cmd’라는 명령어를 입력하고 확인 버튼을 클릭한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/66d136ec-9262-43b1-8cc7-bb3ea125e4d6/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230107%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230107T054817Z&X-Amz-Expires=86400&X-Amz-Signature=255f7b8ded6339b5715f9c9731bb02802b0fb2cd5b9d63f059bdd9684fdc8d73&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

8. 명령 프롬프트가 실행되면 ‘python’을 입력하여 엔터키를 누른다. 이 때 파이썬이 제대로 설치되었다면 다음 그림고 같이 설치된 파이썬에 대한 버전 정보가 표시된다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/1d21c2ee-f642-4fc8-a09e-dc5eeb24de10/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230107%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230107T054831Z&X-Amz-Expires=86400&X-Amz-Signature=85b356720c4e4a90b5678654f3fb928bfc3e89248a3629c2706a767425484b17&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

---

**파이썬으로 실습하기**

파이썬을 설치하고 나면 다음과 같은 메뉴가 생성되며, 이 중에서 첫 번째 메뉴인 IDLE
(Python 3.6 32-bit)를 클릭한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/45d9bfb8-81c5-49a8-bbaa-9bbf91761618/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230107%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230107T054847Z&X-Amz-Expires=86400&X-Amz-Signature=1ec1b3d55236e129070dbff6b72edb6379c4b20c89f77f15e44b27aa9ec2fc5d&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

그러면 파이썬 코드를 입력하고 바로 실행해 볼 수 있는 파이썬 인터프리터인 파이썬 쉘(python shell) 프로그램이 다음과 같이 실행된다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/6c6b9e69-7162-4385-84ea-1c769df1c4de/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230107%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230107T054900Z&X-Amz-Expires=86400&X-Amz-Signature=e39023f7f0318dd3ae93017659fd235195ab1207559de0029496314b0f1cc8e3&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

파이썬 쉘 프로그램을 종료하기 위해서는 오른쪽 맨 위에 위치한 프로그램 종료 버튼을 누르거나 Ctrl + Z를 눌러도 되며, 프롬프트 상에서 exit 함수를 호출하여 종료할 수도 있다.

<aside>
💡 프롬프트란 인터프리터 상의 ‘>>>’ 기호를 가리키며, 파이썬 인터프리터가 사용자의 입력을 받아들일 준비가 되었다는 것을 사용자에게 알려주기 위해 보여주는 기호이다.

</aside>

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/Python-3dc9172a337f46059ef9c53bd82787ab
<br>
👉🏻 출처 : [http://www.tcpschool.com/python2018/python_intro_install](http://www.tcpschool.com/python2018/python_intro_install)
