# [****JSON] 타입_불리언, 객체****

### **불리언(boolean)**

JSON에서 불리언 값은 참(true)와 거짓(false)을 표현한다.

일부 다른 프로그래밍 언어에서는 true 값으로 1을, false 값으로 0을 대신 사용할 수 있다.
또한, 대소문자의 구분 없이 True, TRUE, False, FALSE 등을 모두 사용할 수 있는 언어도 존재한다.

그러나 JSON에서 불리언 값은 항상 true와 false를 소문자로 표기해서 사용해야 한다.

```jsx
{
	"name": "식빵",
	"lunch": true
}
```

### 객체(object)

JSON에서 객체란 데이터 이름과 값의 한 쌍으로 구성된 프로퍼티의 정렬되지 않은 집합을 의미한다. 이러한 JSON 객체는 중괄호({})로 둘러싸여 있다.
객체에 저장되는 프로퍼티는 데이터 이름과 값의 한 쌍으로 이루어져 있다. 
JSON 객체는 쉼표를 사용하여 이러한 프로퍼티를 여러 개 가질 수 있다. 
이 때 프로퍼티의 순서는 중요하지 않으며, 데이터의 이름은 문자열로 반드시 큰따옴표를 사용해야 한다. (작은따옴표 X)

```jsx
{
    "name": "식빵",
    "family": "웰시코기",
    "age": 1,
    "weight": 2.14
}
```

### 객체 안의 객체

JSON에서 데이터 이름과 대응되는 값으로 숫자, 문자열, 불리언 뿐만 아니라 또 다른 객체가 올 수도 있다. 만약 데이터의 값이 객체라면 객체 안에 객체가 포함되는 계층 구조가 형성된다.

```jsx
{
    "dog": {
        "name": "식빵",
        "family": "웰시코기",
        "age": 1,
        "weight": 2.14,
        "owner": {
            "ownerName": "홍길동",
            "phone": "01012345678"
        }
    }
}
```

위의 객체에서 가장 상위 계층의 데이터 이름은 “dog”이며, 데이터 값으로 다섯 개의 또 다른 데이터를 가지고 있다. 그 중에서 다섯 번째 데이터인 “owner” 객체는 “ownername”과 “phone”이라는 또 
다른 데이터를 가지고 있다.
<br><br>
👉 노션 : https://www.notion.so/tgmary09/JSON-_-1f22d4c614984642a3acccb7e9a90265
<br>
👉 출처 : [http://www.tcpschool.com/json/json_datatype_boolean](http://www.tcpschool.com/json/json_datatype_boolean)
<br>
👉 출처 : [http://www.tcpschool.com/json/json_datatype_object](http://www.tcpschool.com/json/json_datatype_object)
