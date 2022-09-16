# [****JSON] 타입_숫자, 문자열****

### 타입(dataType)

JSON에서는 데이터의 값으로 사용할 수 있는 다양한 타입을 제공하고 있다. 
JSON에서 제공하는 기본 타입은 다음과 같다.

1. 숫자(number)
2. 문자열(string)
3. 불리언(boolean)
4. 객체(object)
5. 배열(array)
6. null

### 숫자(number)

JSON에서 나타낼 수 있는 숫자의 종류는 다음과 같다.

1. 정수(integer) : 부호를 가지는 소수 부분이 없는 수
2. 실수(fraction) : 소수 부분을 가지는 수
3. 지수(exponent) : 매우 큰 수나 매우 작은 수를 표현할 때 e표기법을 사용하여 표기 (5.8e+2)

<aside>
💡 JSON에서는 8진수나 16진수 등을 표현하는 방법은 제공하지 않는다.

</aside>

### 문자열(string)

JSON에서 문자열이란 일련의 연속된 문자의 집합을 의미한다. 
이러한 문자열은 큰따옴표 안에 유니코드 문자들의 나열로 구성된다.

JSON에서 역슬래시 문자는 특정 문자와 함께 사용되어 이스케이프 시퀀스로 사용된다. 
따라서 JSON 문자열에서는 역슬래시와 큰따옴표를 바로 사용할 수 없으며, 
이스케이프 시퀀스로 표현하여야 한다.

```jsx
{
	"name": "식빵"
}
```

<aside>
💡 자바스크립트에서는 문자열을 표현할 때 큰따옴표와 작은따옴표를 모두 사용할 수 있지만,
JSON에서는 오직 큰따옴표만을 사용할 수 있다.

</aside>

### 이스케이프 시퀀스

문자열이 화면이 출력될 때 사용하게 될 특수한 문자를 위해 만들어졌다. 
이러한 이스케이프 시퀀스는 역슬래시와 특정 문자와의 조합으로 사용할 수 있다.

JSON에서 사용할 수 있는 이스케이프 시퀀스는 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/0020cae6-88cc-46dd-9b63-674b37798eda/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220916%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220916T041931Z&X-Amz-Expires=86400&X-Amz-Signature=a8891948a3958b0bf64db163f652e2f14610e77caeb356221ee5152111432ae0&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

다음 예제는 JSON 문자열에서 큰따옴표를 표현하기 위해 이스케이프 시퀀스를 사용하는 예제이다.

```jsx
{
	"comment": "안녕하세요, \"식빵\" 입니다."
}
```

JSON 파서(parser)는 우선 JSON 데이터를 모두 읽어들인다. 
위의 예쩨처럼 큰따옴표를 이스케이프 시퀀스(\”)로 표현하지 않았다면, 
식빵이라는 문자열 앞에 있는 큰따옴표에서 문자열이 모두 끝났다고 인식할 것이다. 
따라서 JSON 파서는 오류를 발생시킬 것이다.

이처럼 문자열 내에서 큰따옴표나 역슬래시를 표현하기 위해서는 반드시 이스케이프 시퀀스를 
사용하여 JSON 파서에 해당 따옴표는 문자열을 끝내는 따옴표가 아니라는 사실을 알려주어야만 
한다.
<br><br>
👉 노션 : https://www.notion.so/tgmary09/JSON-_-9f754e9f999347df88cb1c17dfa4b8ca
<br>
👉 출처 : [http://www.tcpschool.com/json/json_datatype_numeric](http://www.tcpschool.com/json/json_datatype_numeric)
<br>
👉 출처 : [http://www.tcpschool.com/json/json_datatype_string](http://www.tcpschool.com/json/json_datatype_string)
