# 👻 REST, RESTful, REST API 👻

## *REST(Representational State Transfer)란, 자원을 이름으로 구분하여 해당 자원의 상태를 주고 받는 모든 것을 의미*

1) *HTTP URI(Uniform Resource Identifier)를 통해 자원(Resource)을 명시하고*

2) *HTTP Method(POST, GET, PUT, DELETE)를 통해*

3)*해당 자원(URI)에 대한 CRUD Operation을 적용하는 것을 의미*

👉 CRUD Operation이란?

   ⇒ CRUD는 대부분의 컴퓨터 소프트웨어가 가지는 기본적인 데이터처리기능을 묶어서 일컫는 말

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/19268334-b378-4cde-bd40-436d0f4a66d7/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220121%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220121T034609Z&X-Amz-Expires=86400&X-Amz-Signature=d15037b3a663a93a8c1193094a317441ddca51545d9c5546ffb1a31d785fcdf8&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

---

## 1. REST의 기본 개념

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/e6f97c3d-328c-4488-ab62-8c40122fcab5/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220121%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220121T034718Z&X-Amz-Expires=86400&X-Amz-Signature=be7ea8b42ddff195f624e9b532d80c6e73d111c03d41676dea5f27063007694c&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

---

## 2. REST 구성 요소

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/9040f2f3-24d2-4856-9f64-169c025bc5dd/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220121%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220121T034734Z&X-Amz-Expires=86400&X-Amz-Signature=38a36af933c34e28447e440b386ae1b893e8f20a0a1d8a921fb536a14577f1e5&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

---

## 3. REST의 장단점

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/aa887a87-0a47-4d72-a558-0a6077ec61ac/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220121%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220121T034750Z&X-Amz-Expires=86400&X-Amz-Signature=78824b4613fe1763ce4759710c9397e64e05603108d64e93c6756f630ccadbbd&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

---

## 4. RESTful

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/f47d7414-7ac3-4358-ab18-10f074b02651/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220121%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220121T034816Z&X-Amz-Expires=86400&X-Amz-Signature=3113ac2971448308c022d378af5d573d548e438934a110daaa8bb49c4b92118e&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

---

## 5. REST API 개념

### *👉 REST API란 REST를 기반으로 만들어진 API를 의미한다.*

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/a78bfe8a-934b-4fa0-bfeb-1ec5ddb93a15/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220121%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220121T034850Z&X-Amz-Expires=86400&X-Amz-Signature=09ede1cffbe5d62ba0e375317de5a23ae7de64a5a1a38ef5f57ee7f7bdd4d415&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

---

## 6. REST API 설계 기본 규칙

**1) URI는 동사보다는 명사를, 대문자보다는 소문자를 사용한다.**

👉 **Bad Example [http://yu9092.com/Running/](http://khj93.com/test/) Good Example  [http://yu9092.com/run/](http://khj93.com/test/)**

**2) 마지막에 슬래시(/)를 포함하지 않는다.**

👉  **Bad Example [http://yu9092.com/test/](http://khj93.com/test/)  Good Example  [http://yu9092.com/test](http://khj93.com/test/)**

**3) 언더바 대신 하이픈을 사용한다.**

👉 **Bad Example [http://yu9092.com/test_blog](http://khj93.com/test/) Good Example  [http://yu9092.com/test-blog](http://khj93.com/test/)** 

**4) 파일확장자는 URI에 포함하지 않는다.**

👉 **Bad Example [http://yu9092.com/photo.jpg](http://khj93.com/test/)  Good Example  [http://yu9092.com/photo](http://khj93.com/test/)** 

**5) 행위를 포함하지 않는다.**

👉 **Bad Example [http://yu9092.com/delete-post/1](http://khj93.com/test/)  Good Example  [http://yu9092.com/post/1](http://khj93.com/test/)** 

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/ee998fcf-beec-41dd-8078-afe7f803e725/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220121%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220121T034909Z&X-Amz-Expires=86400&X-Amz-Signature=63018434b3166fb9ab304f62784b6c91293c1d3d322828d18dfe70ca87aa1d79&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

---

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/cbb54cb0-eaa3-469c-818e-34f8f1526c74/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220121%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220121T034927Z&X-Amz-Expires=86400&X-Amz-Signature=ff38567d364bb060bbb7de65a98179100ac85c2baffa68f87912539dae765888&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

#### 👉 노션링크 : https://www.notion.so/REST-RESTful-REST-API-fbe1e285ca1a4f618064eca91db47a82
