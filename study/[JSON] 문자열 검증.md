# [****JSON] 문자열 검증****

### 문자열 검증

type 키워드 값을 string으로 명시하면 해당 JSON 데이터가 유니코드 문자열인지를 검사해준다.

```jsx
{
    "type": "string"
}
```

위의 예제에서 “제이슨”, “JSON”, “123” 등의 문자열은 검증을 통과한다.
하지만 1, 3.14와 같은 숫자나 true와 같은 불리언 등은 검증을 통과하지 못한다.

### 문자열 길이 검증

minLength와 maxLength 키워드를 사용하여 해당 문자열의 길이가 유효한지를 검사할 수 있다.
이때 minLength와 maxLength 키워드의 값은 0을 포함한 양수만을 사용할 수 있다.

다음 예제는 해당 문자열의 길이가 1보다 크고 4보다 작은지를 검사하는 예제이다.

```jsx
{
    "type": "string",
    "minLength": 1,
    "maxLength": 4
}
```

### 정규 표현식 검증⭐⭐

pattern 키워드를 사용하여 해당 문자열이 명시된 정규 표현식과 일치하는지를 검사할 수 있다. 
정규 표현식은 문자열에서 특정한 규칙을 가지는 문자열의 집합을 찾아내기 위한 검색 패턴이다. 
이러한 검색 패턴은 모든 종류의 문자열 검색이나 교체 등의 작업에서 사용될 수 있다.

JSON에서는 자바스크립트에서 사용할 수 있는 정규 표현식 문법을 모두 사용할 수 있다. 

JSON 정규 표현식에서 주로 사용되는 패턴 문자는 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/b914a4ab-190e-44d0-9322-3a72fb18cc9d/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220921%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220921T085526Z&X-Amz-Expires=86400&X-Amz-Signature=12972f4ed5de0fe07870129dcae63ff2eb014007bb7d72ee884c249e4651e02c&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

정규 표현식에 대한 더 자세한 사항은 자바스크립트 정규 표현식 수업에서 확인할 수 있다.

[자바스크립트 정규 표현식 수업 확인 =>](http://www.tcpschool.com/javascript/js_regularExpression_concept)

다음 예제는 정규 표현식을 이용하여 해당 데이터가 1개 이상의 영문 소문자를 가지는 
문자열인지를 검사한다.

```jsx
{
    "type": "string",
    "pattern": "[a-z]+"
}
```

<br><br>
👉 노션 : https://www.notion.so/tgmary09/JSON-64a6e4b957fa4d3d82bb0d535e5d3d31
<br>
👉 출처 : [http://www.tcpschool.com/json/json_schema_string](http://www.tcpschool.com/json/json_schema_string)
