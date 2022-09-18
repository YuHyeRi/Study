# [****JSON] JSON스키마****

### **JSON 스키마(schema)**

JSON은 좀 더 쉽게 데이터를 교환하고 저장하기 위하여 만들어진 데이터 교환 표준이다. 
이 때 JSON 데이터를 전송받는 측에서는 전송받은 데이터가 적법한 형식의 데이터인지를 확인할 
방법이 필요하다. 따라서 적법한 JSON 데이터의 형식을 기술한 문서를 JSON스키마라고 한다.

JSON 스키마에 대한 더 자세한 사항은 다음 링크를 참고하면 된다.

[http://json-schema.org =>](http://json-schema.org/)

### **JSON 스키마 검증(validation)**

JSON 스키마는 다음과 같은 세 가지 검증 과정을 거친다.

1. 데이터의 타입이 정확한가?
2. 필수로 받아와야 하는 데이터가 포함되어 있는가?
3. 데이터가 원하는 범위 안에 있는가?

JSON 스키마에서는 위와 같은 검증 기준을 모두 키워드(keyword)를 이용하여 직접 명시할 수 있다.

### **검증 키워드(validation keywords)**

JSON 스키마에서는 검증 기준을 명시하기 위해 여러 키워드를 사용할 수 있다. 
이러한 키워드를 사용하여 데이터에 여러 가지 조건을 걸어둘 수 있다.

JSON 스키마에서 사용할 수 있는 대표적인 검증 키워드는 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/db6d0f0c-90c2-40fc-a619-275e68607bc7/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220918%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220918T155521Z&X-Amz-Expires=86400&X-Amz-Signature=e2d4c8353c141abaafdc5dc366f0d3413569598ceaed06fa932c7034e111566d&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

 또한, 스키마에 대한 정보를 나타내는 메타 데이터(metadata) 키워드는 다음과 같다.

1. title
2. description
3. default

다음 예제는 검증 키워드와 메타 데이터 키워드를 이용한 JSON 스키마 예제이다.

```jsx
{
    "title": "강아지 스키마",
    "description": "이 스키마는 강아지에 관한 데이터를 검증하기 위해 작성된 스키마임.",
    "type": "object",
    "properties": {
        "name": {"type": "string"},
        "family": {"type": "string"},
        "age": {"type": "integer"},
        "weight": {"type": "number"},
        "owner": {
            "type": "object",
            "properties": {
                "ownerName": {"type": "string"},
                "phone": {"type": "string"}
            }
        }
    }
}
```

type 키워드를 사용하여 유효한 타입으르 명시하면 해당 데이터가 유효한지를 검사할 수 있다. 
이 때 사용할 수 있는 타입에는 JSON의 기본 타입을 모두 사용할 수 있다. 
properties 키워드를 사용하면 해당 객체가 가지는 프로퍼티가 유효한지를 검사할 수 있다.
<br><br>
👉 노션 : https://www.notion.so/tgmary09/JSON-JSON-e029adf5ecad4ef6851891df8354018d
<br>
👉 출처 : [http://www.tcpschool.com/json/json_schema_schema](http://www.tcpschool.com/json/json_schema_schema)
