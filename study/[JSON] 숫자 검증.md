# [****JSON] 숫자 검증****

### 정수 검증

type 키워드의 값을 integer로 명시하면 해당 데이터가 정수인지를 검사해준다.

```jsx
{
    "type": "integer"
}
```

위의 예제에서 0, -10, 4 등의 정수는 검증을 통과할 것이다.
그러나 2.132과 같은 실수나 “123”과 같은 문자열 등은 검증을 통과하지 못한다.

### 숫자 검증

type 키워드 값을 number로 명시하면 해당 데이터가 숫자인지를 검사해준다.
이 때 정수 뿐만 아니라 소수부를 가지는 실수까지도 모두 검증을 통과한다.

```jsx
{
    "type": "number"
}
```

위의 예제에서 0, 10, 3.14, -4.56 등의 모든 정수와 실수는 검증을 통과한다.
하지만 "123"과 같은 문자열이나 true와 같은 불리언 등은 검증을 통과하지 못한다.

### 배수 검증

multipleOf 키워드를 사용하여 해당 숫자가 명시된 숫자의 배수인지를 검사할 수 있다. 
다음 예제는 해당 데이터가 숫자이면서 3의 배수인지를 검사하는 예제이다.

```jsx
{
    "type": "number",
    "multipleOf": 3
}
```

위의 예제에서 0, 3, 6, 9 등의 3의 배수인 숫자는 검증을 통과한다.
하지만 10, 20과 같이 3의 배수가 아닌 숫자나 "123"과 같은 문자열 등은 검증을 통과하지 못한다.

### 범위 검증

다음과 같은 키워드를 사용하면 해당 숫자의 유효한 범위를 명시할 수 있다.

1. minimum
2. maximum
3. exclusiveMinimum
4. exclusiveMaximum

minimum과 maximum 키워드를 사용하면 해당 숫자가 가질 수 있는 최솟값과 최댓값을 명시할 수 
있다. 
exclusiveMinimum과 exclusiveMaximum 키워드는 불리언 값을 명시할 수 있다.

만약 exclusiveMinimum 값이 true 이면 해당 숫자가 가질 수 있는 최솟값으로 minimum 키워드로 
명시된 값을 포함하지 않고 검사한다. 하지만 exclusiveMinimum 값이 false이면 최솟값으로 minimum 키워드로 명시된 값까지 포함해서 검사한다. 

exclusiveMaximum 키워드로 해당 숫자가 가질 수 있는 최댓값에 대해 exclusiveMinimum과 같은 
방식으로 동작한다. exclusiveMinimum과 exclusiveMaximum 키워드는 값을 따로 명시하지 않으면 기본값으로 false를 저장한다.

다음 예제는 해당 데이터가 1보다 크거나 같고, 
10보다는 작은 정수 또는 실수인지를 검사하는 예제이다.

```jsx
{
    "type": "number",
    "minimum": 1,
    "maximum": 10,
    "exclusiveMaximum": true
}
```
<br><br>
👉 노션 : https://www.notion.so/tgmary09/JSON-7c223d409b6145de9394ffcbdff3ec44
<br>
👉 출처 : [http://www.tcpschool.com/json/json_schema_numeric](http://www.tcpschool.com/json/json_schema_numeric)
