# [****JSON] 기타검증****

### 불리언 검증

type 키워드의 값을 boolean으로 명시하면 해당 데이터가 불리언인지를 검사해준다. 
이 때는 데이터의 값이 true와 false인 경우에만 검증을 통과할 수 있다.

```jsx
{
    "type": "boolean"
}
```

JSON은 불리언 true와 false 대신에 숫자 1과 0을 대신 사용할 수 없으므로,
위의 예쩨에서 숫자 1과 0은 통과할 수 없다.

### null 검증

type 키워드의 값을 null로 명시하면 해당 데이터가 null 인지를 검사해준다.

```jsx
{
    "type": "null"
}
```

위의 예제에서 null 이외의 모든 값은 검증을 통과하지 못한다.

### 열거형 데이터 검증

enum 키워드를 사용하여 해당 데이터가 명시된 배열에 속한 값인지를 검사할 수 있다. 
유효한 enum 값들은 배열을 사용하여 명시하며, 중복값을 가질 수는 없다.

```jsx
{
    "type": "string",
    "enum": ["웰시코기", "포메라니안", "푸들"]
}
```

위의 예제에서 문자열은 “웰시코기”, “포메라이안”, “푸들” 이외의 모든 값은 검증을 통과할 수 없다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/JSON-3385f5fa8193493fa4d6e6e7365ea2f0

👉 출처 : [http://www.tcpschool.com/json/json_schema_etc](http://www.tcpschool.com/json/json_schema_etc)
