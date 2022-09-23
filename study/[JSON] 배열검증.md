# [****JSON] 배열검증****

### 배열 검증

type 키워드의 값을 array로 명시하면 해당 데이터가 배열인지를 검사해준다.

```jsx
{
    "type": "array"
}
```

위의 예제에서 여러 개의 데이터가 순서를 가지고 대괄호로 둘러싸인 배열은 검증을 통과할 것이다. 
그러나 1, 3.14와 같은 숫자나 객체 등은 검증을 통과하지 못한다.

### 배열 요소 검증

items 키워드를 사용하여 해당 배열에 저장된 배열 요소에 대한 검증을 수행할 수 있다. 
items 키워드와 함께 명시된 JSON 스키마로 각 배열 요소의 검증을 수행한다.

다음 예제는 해당 데이터가 배열이면서 각 배열 요소가 모두 정수인지를 검사하는 예제이다.

```jsx
{
    "type": "array",
    "items": {
        "type": "integer"
    }
}
```

위의 예제에서 배열 요소가 모두 정수인 배열이나 배열 요소가 하나도 없는 빈 배열은 검증을 통과할 것이다. 그러나 배열 요소로 정수 외 데이터를 가지는 배열은 검증을 통과하지 못한다.

배열의 각 요소를 서로 다른 JSON 스키마로 검사하고 싶으면 items 키워드와 함께 배열로 스키마를 명시하면 된다. 이 배열은 각 배열 요소를 검사할 JSON 스키마가 저장되어 있다.

다음 예제는 해당 데이터가 배열이면서 각 배열 요소를 서로 다른 JSON 스키마로 검사하는 
예제이다.

```jsx
{
    "type": "array",
    "items": [
        {
            "type": "string",
            "maxLength": 5
        },
        {
            "type": "string"
        },
        {
            "type": "string"
        }
    ]
}
```

위의 예제에서 첫 번째 배열 요소가 5개의 문자를 넘지 않는 문자열이며 두 번째와 세 번째 배열 요소가 문자열인 배열은 검증을 통과할 것이다. 또한 세 개의 유효한 배열 요소 외에 추가로 다른 배열 
요소를 가지고 있는 배열도 검증을 통과할 것이다. 

그러나 additionalItems 키워드의 값을 false로 명시하면, 
추가로 다른 배열 요소를 가지는 배열은 검증을 통과하지 못하게 된다.

```jsx
{
    "type": "array",
    "items": [
        {
            "type": "string",
            "maxLength": 5
        },
        {
            "type": "string"
        },
        {
            "type": "string"
        }
    ],
    "additionalItems": false
}
```

### 배열 길이 검증

minItems와 maxItems 키워드를 사용하여 해당 배열이 가질 수 있는 길이의 최솟값과 최댓값을 
명시할 수 있다.

다음 예제는 해당 데이터가 배열이면서 가지고 있는 배열 요소가 3개부터 10개까지인가를 검사하는 예제이다.

```jsx
{
    "type": "array",
    "minItems": 3,
    "maxItems": 10
}
```

### 중복 값 검증

uniqueItems 키워드를 사용하여 해당 배열에 저장된 배열 요소에 대한 중복값 허용 여부를 명시할 수 있다. uniqueItems 값이 true이면, 배열 요소의 값에 중복값을 허용하지 않을 수 있다.

다음 예제는 해당 데이터가 배열이면서, 
가지고 있는 배열 요소의 값이 중복되지 않는가를 검사하는 예제이다.

```jsx
{
    "type": "array",
    "uniqueItems": true
}
```

<br><br>
👉 노션 : https://www.notion.so/tgmary09/JSON-5eba7faa52df4aef9f86e8c793b64517
<br>
👉 출처 : [http://www.tcpschool.com/json/json_schema_array](http://www.tcpschool.com/json/json_schema_array)
