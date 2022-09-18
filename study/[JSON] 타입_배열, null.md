# [****JSON] 타입_배열, null****

### 배열(array)

JSON에서 배열이란 여러 개의 데이터가 순서를 가지고 나열된 집합을 의미한다. 
이러한 JSON 배열은 대괄호([])로 둘러싸여 있다.

JSON 배열은 쉼표(,)를 사용하여 여러 개의 데이터를 나열할 수 있다.
이 방식은 객체에서 프로퍼티를 나열하는 것과 비슷하지만 
배열은 데이터의 값만을 나열한다는 차이가 있다.

JSON 배열은 JSON에서 제공하는 기본 타입을 모두 저장할 수 있다.

다음 예제는 세 개의 문자열 요소를 가지는 “dog”라는 이름의 JSON 배열 예제이다.

```jsx
{
    "dog": [
        "웰시코기",
        "포메라니안",
        "푸들"
    ]
}
```

JSON에서 배열의 인덱스는 언제나 0부터 시작한다. 
따라서 위의 예제에서 “웰시코기”는 0, “포메라이안”은 1, “푸들”은 2의 인덱스를 가지게 된다.

### 배열과 객체의 차이점

JSON에서 배열과 객체는 여러 데이터를 묶어놓은 집합이라는 점에서 서로 비슷한 타입이다. 
그러나 객체는 프로퍼티의 집합이며, 배열은 데이터의 집합이라는 차이가 있다.

```jsx
{
    "dog": [
        "웰시코기",
        "포메라니안",
        "푸들",
        {
            "ownerName": "홍길동",
            "phone": "01012345678"
        }
    ]
}
```

위의 예제에서 “dog”라는 이름의 JSON 배열은 문자열 뿐만 아니라 객체도 요소로 가지고 있다.

대부분의 프로그래밍 언어에서 배열은 여러 타입의 데이터를 동시에 가질 수 없다. 
**그러나 자바스크립트 기반의 JSON 배열은 여러 타입의 배열 요소를 가질 수 있다.**

### null

JSON에서 null이란 아무런 값도 가지고 있지 않은 빈 값을 의미한다. 
JSON에서 이러한 null 값은 항상 null을 소문자로 표기해서 사용해야 한다.

```jsx
{
    "id": 1,
    "name": null
}
```

### **undefined와 null**

null은 자바스크립트의 undefined 타입과 혼동하기 쉽다. 
더군다나 JSON에서는 undefined 타입을 제공하지 않으므로 더욱 유의해야 한다.

자바스크립트에서 ‘값’ 자체가 없다는 의미의 undefined 값은 초기화되지 않은 변수나 존재하지 
않는 값에 접근할 때 반환한다. 
그러나 JSON에서 null이란 ‘값’을 가지고 있지 않다는 의미를 가지는 하나의 데이터 값이라고 할 수 있다.
<br><br>
👉 노션 : https://www.notion.so/tgmary09/JSON-_-null-eb18e0a690f949b9adb3c8050cddd680
<br>
👉 출처 : [http://www.tcpschool.com/json/json_datatype_array](http://www.tcpschool.com/json/json_datatype_array)
<br>
👉 출처 : [http://www.tcpschool.com/json/json_datatype_null](http://www.tcpschool.com/json/json_datatype_null)
