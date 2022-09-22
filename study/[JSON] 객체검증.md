# [****JSON] 객체검증****

### 객체 검증

type 키워드의 값을 object로 명시하면 해당 데이터가 객체인지를 검사해준다.

```jsx
{
    "type": "object"
}
```

위의 예제에서 데이터 이름과 값의 쌍인 프로퍼티를 갖는 객체는 검증을 통과할 것이다. 
그러나 “123”과 같은 문자열이나 배열 등은 검증을 통과하지 못한다.

### 프로퍼티 검증

객체의 프로퍼티는 데이터 이름과 값의 쌍으로 구성된다.
properties 키워드를 사용하여 해당 객체가 가지는 프로퍼티가 유효한지를 검사할 수 있다.

```jsx
{
    "type": "object",
    "properties": {
        "name": {"type": "string"},
        "family": {"type": "string"},
        "age": {"type": "integer"},
        "weight": {"type": "number"}
    }
}
```

다음 예제의 JSON 객체는 위의 예제와 같은 검증을 통과할 것이다.

```jsx
{
    "name": "식빵",
    "family": "웰시코기",
    "age": 1,
    "weight": 2.14
}
```

그러나 다음 예제의 JSON 객체는 age와 weight 프로퍼티가 값으로 문자열을 가지므로, 
검증을 통과하지 못한다.

```jsx
{
    "name": "식빵",
    "family": "웰시코기",
    "age": "1",
    "weight": "2.14"
}
```

### 필수 프로퍼티 검증

required 키워드를 사용하여 해당 객체가 반드시 가지고 있어야 하는 필수 프로퍼티를 명시할 수 
있다. 만약 필수 프로퍼티가 하나 이상이라면, 배열을 이용하여 각 필수 프로퍼티의 이름을 나열하면 된다.

다음 예제는 해당 데이터가 객체이면서, 
프로퍼티로 name과 family를 가졌는지를 검사하는 예제이다.

```jsx
{
    "type": "object",
    "properties": {
        "name": {"type": "string"},
        "family": {"type": "string"},
        "age": {"type": "integer"},
        "weight": {"type": "number"}
    },
    "required": ["name", "family"]
}
```

### 프로퍼티의 개수 검증

minProperties와 maxProperties 키워드를 사용하여 해당 객체가 가질 수 있는 프로퍼티 개수의 
최소값과 최댓값을 명시할 수 있다.

다음 예제는 해당 데이터가 객체이면서 프로퍼티를 1개나 2개만 가졌는지를 검사하는 예제이다.

```jsx
{
    "type": "object",
    "minProperties": 1,
    "maxProperties": 2
}
```

<br><br>
👉 노션 : https://www.notion.so/tgmary09/JSON-564fa834b447413b9d27d4558aeed590
<br>
👉 출처 : [http://www.tcpschool.com/json/json_schema_object](http://www.tcpschool.com/json/json_schema_object)
