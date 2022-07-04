# [Spring Security] ****Authentication의 매커니즘****

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/8967026e-1b62-46bd-ac86-6ddf61c8717a/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220603%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220603T222614Z&X-Amz-Expires=86400&X-Amz-Signature=f21d8f6457a661ee70cfc137954e019643fe942e3f11fc72eaa0d6c39ea9c81a&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

- **Authentication**에는 인증된 결과 뿐만 아니라 *인증을 하기 위한 정보*, *인증을 받기 위한 정보*가 
하나의 객체에 들어있다.
- **AuthenticationProvider**는 입력된 인증을 보고 허가된 인증을 내주는 방식으로 인증 허가를 
판단하며 처리 가능한 Authentication에 대해서 알려주는 support 메서드를 지원한다.
- **Authorities**에는 ‘어디를 갈 수 있는지’, ‘어떤 역할을 할 수 있는지’에 대한 권한 정보로 이를 구현(implement)한 GrantedAuthority에 관한 정보들이 저장되어 있다.

> **인가, 권한(Authorization)**
> 
> - 사용자가 어떤 일을 할 수 있는지 권한 설정을 하는 절차
> - 특정 페이지/리소스에 접근할 수 잇는지 권한을 판단
> - Secured, PrePostAuthorize 어노테이션으로 쉽게 권한을 체크할 수 있다
> - 비즈니스 로직이 복잡한 경우 AOP를 이용해 권한 체크를 해야 한다

- Authentication에 들어가 있는 Token들은 각각의 Filter들을 통해 발행된 Token들이다.
- **Credentials**은 인증을 받기 위해 필요한 정보들 (ex. 비밀번호)
- **Principal**은 인증된 결과에 대한 정보이다. (Credentials을 이용해 인증을 받은 그 결과)
- **Details**은 위의 정보 외에 인증에 관여된 주변 정보들

### ***AuthenticationProvider***

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/66c3a544-b909-4adc-9ece-60699a654c09/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220603%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220603T222523Z&X-Amz-Expires=86400&X-Amz-Signature=7f42a4bf8e3ca4b11a6855b4d4e0144e71e3f257190ed741d0c91366b6f55679&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

- Authentication을 제공하는 것을 Authentication Provider라고 한다.
- Authentication Provider는 credentials이나 Principal이 있는 Authentication을 받아서 인증하고
인증된 결과를 다시 Authentication 객체로 전달하는 역할을 한다.
- 이 때, Authentication Provider는 어떤 인증에 대해 승인을 해줄지 Authentication Manager에게
알려주어야 하기 때문에 support() 메서드를 제공한다.
- Authentication Manager는 인증 대상과 방식이 다양할 수 있어 여러개일 수 있다.

 #### 👉 출처 : [https://velog.io/@seongwon97/Spring-Boot-Authentication의-메커니즘](https://velog.io/@seongwon97/Spring-Boot-Authentication%EC%9D%98-%EB%A9%94%EC%BB%A4%EB%8B%88%EC%A6%98)
 #### 👉 노션 : https://www.notion.so/Spring-Security-Authentication-56efa4d4e7d54bb495922cc21a4b4b47
