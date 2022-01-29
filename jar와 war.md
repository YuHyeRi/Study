### - jar와 war (+EAR)


<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/ed3aab10-6d38-476d-bfbe-26a6322c5702/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220129%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220129T014304Z&X-Amz-Expires=86400&X-Amz-Signature=dfbcaab55ca8499593b751197d0043323935e0d6db5273474113d77cf46430d5&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

## 👻 JAR (Java Archive)

.jar 확장자 파일에는 class와 같은 Java 리소스와 속성파일, 라이브러리 및 액세서리 파일이 포함되어 있다. 쉽게 JAVA 어플리케이션이 동작할 수 있도록 **자바 프로젝트를 압축한 파일**로 생각면 된다. 실제로 **JAR파일은 플랫폼에 귀속되는 점만 제외하면 WIN ZIP파일과 동일한 구조**이다.

JAR 파일은 **원하는 구조로 구성이 가능**하며 JDK (Java Development Kit)에 포함하고 있는 **JRE (Java Runtime Environment)만 가지고도 실행이 가능**하다.

## 👻 WAR (Web Application Archive)

.war 확장자 파일은 servlet / jsp 컨테이너에 배치할 수 있는 **웹 어플리케이션(Web Application) 압축 파일 포맷**이다. jsp, servlet, jar, class, xml, html, javaScript 등 Servlet Context 관련 파일들로 패키징 되어있다. war는 웹 응용프로그램을 위한 포맷이기 때문에 **웹 관련 자원만 포함하고 있으며 이를 사용하면 웹 어플리케이션을 쉽게 배포**하고 테스트할 수 있다.

원하는 구성을 할 수 있는 jar 포맷과 달리 war는 WEB-INF 및 META-INF 디렉토리로 **사전정의된 구조를 사용**하며 **war파일을 실행하려면 Tomcat, Weblogic, Websphere 등의 웹 서버(Web) 또는 웹 컨테이너(WAS)가 필요**하다.

**war 파일도 JAVA의 JAR 옵션(java -jar)을 이용해 생성하는 JAR 파일의 일종**으로 웹어플리케이션 전체를 패키징하기 위한 JAR 파일로 생각하면 된다.

## 👻 EAR (Enterprise Archive)

추가적으로 EAR 파일은 JAVA EE(Enterprise Edition) 쓰이는 파일 형식으로 **한 개 이상의 모듈**을 **단일 아카이브로 패키징 하여 어플리케이션 서버에 동시에 일관적으로 올리기 위하여 사용되는 포맷**이다.

👉 노션링크 : https://www.notion.so/jar-war-EAR-dab2f5768c4c4f3c999891842426d578
