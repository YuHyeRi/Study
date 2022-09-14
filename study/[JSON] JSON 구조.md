# [****JSON] JSON 구조****

### **JSON 구조**

JSON은 자바스크립트의 객체 표기법으로 파생된 부분 집합이다. 
따라서 JSON 데이터는 다음과 같은 자바스크립트 객체 표기법에 따른 구조로 구성된다.

1. JSON 데이터는 이름과 값의 쌍으로 이루어진다.
2. JSON 데이터는 쉼표(,)로 나열된다.
3. 객체느느 중괄호({})로 둘러쌓아 표현한다.
4. 배열은 대괄호([])로 둘러쌓아 표현한다.

### JSON 데이터

JSON 데이터는 이름과 값의 쌍으로 구성된다. 
이러한 JSON 데이터는 데이터 이름, 콜론(:), 값의 순서로 구성된다.

<aside>
💡 “데이터이름”: 값

</aside>

다음 예제는 데이터의 이름이 “name”이고 값은 “식빵”이라는 문자열을 갖는 JSON 데이터의 
예제이다.

<aside>
💡 “name”: “식빵”

</aside>

데이터의 이름도 문자열이므로 항상 큰따옴표(””)와 함께 입력해야 한다.
데이터의 값으로는 다음과 같은 타입이 올 수 있다.

1. 숫자(number)
2. 문자열(string)
3. 불리언(boolean)
4. 객체(object)
5. 배열(array)
6. NULL

JSON 데이터의 타입에 대한 더 자세한 사항은 JSON 타입 수업에서 확인할 수 있다.

[JSON 타입 수업 확인 =>](http://www.tcpschool.com/json/json_datatype_numeric)

### JSON 객체

JSON 객체는 중괄호({})로 둘러쌓아 표현한다. 
또한, JSON 객체는 쉼표(,)를 사용하여 여러 프로퍼티를 포함할 수 있다.

```jsx
{
	"name": "식빵",
	"family": "웰시코기",
	"age": 1,
	"weight": 2.14
}
```

JSON 객체를 그림으로 나타내면 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/2ac189d9-14b7-4834-baf2-d716e938d4ca/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220914%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220914T150047Z&X-Amz-Expires=86400&X-Amz-Signature=c622c4a7a904fde24fbe416348e102424f4697b9183ea1c9e1e7c24ea0bc55b7&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

JSON 객체에 대한 더 자세한 사항은 JSON 객체 수업에서 확인할 수 있다.

[JSON 객체 수업 확인 =>](http://www.tcpschool.com/json/json_datatype_object)

### JSON 배열

JSON 배열은 대괄호([])로 둘러쌓아 표현한다. 
또한 JSON 배열은 쉼표(,)를 사용하여 여러 JSON 데이터를 포함할 수 있다.

다음 예제는 배열의 이름이 “dog”이고, 3개의 JSON 객체를 요소르 가지는 JSON 배열의 예제이다.

```jsx
"dog": [
    {"name": "식빵", "family": "웰시코기", "age": 1, "weight": 2.14},
    {"name": "콩콩", "family": "포메라니안", "age": 3, "weight": 2.5},
    {"name": "젤리", "family": "푸들", "age": 7, "weight": 3.1}
]
```

JSON 배열을 그림으로 나타내면 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/26122396-65f1-4b08-9d95-f68a65db3afa/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220914%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220914T150105Z&X-Amz-Expires=86400&X-Amz-Signature=b709f388cca72ca5566dadd1ae5f043ff285ad6812b249d73d805957658159df&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">
<br><br>
👉 노션 : https://www.notion.so/tgmary09/JSON-JSON-27898a6be7b64d5fa9abfa3208906b6b
<br>
👉 출처 : [http://www.tcpschool.com/json/json_basic_structure](http://www.tcpschool.com/json/json_basic_structure)
