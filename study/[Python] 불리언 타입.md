# [Python] 불리언 타입

**불리언 타입(boolean types) : bool**

불리언 타입이란 논리값인 참과 거짓 중 한 가지만을 가질 수 있는 데이터 타입을 의미한다.

<aside>
💡 파이썬에서는 True와 False가 예약어로 미리 지정되어 있기 때문에 첫 문자를 항상 대문자로 사용해야만 한다.

</aside>

C를 비롯한 대부분의 프로그래밍 언어에서 1은 ‘참’을 의미하고 0은 ‘거짓’을 의미한다. 
파이썬에서는 이에 더해 데이터의 참과 거짓을 다음과 같이 판단하고 있다.

```python
print(bool(1))        # True
print(bool(0))        # False  

print(bool(None))     # False
print(bool([]))       # False
print(bool(()))       # False
print(bool({}))       # False
print(bool([1,2,3]))  # True  

print(bool(""))       # False
print(bool("python")) # True
```

문자열이나 리스트, 튜플, 딕서녀리 등이 비어있으면 거짓으로 인식되며, 
비어있지 않으면 참으로 인식된다.

<aside>
💡 bool() 함수는 인수로 전달된 데이터의 참과 거짓을 판단하여 반환한다.

</aside>

---

**비교 연산자(relational operator)**

비교 연산자는 피연산자 사이의 상대적인 크기를 판단하는 연산자로, 왼쪽의 피연산자와 오른쪽의 피연산자를 서로 비교하여 어느쪽이 더 큰지, 작은지, 또는 같은지를 판단한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/c2f4f9fb-575d-47f9-913e-ff4f7c5bbfb1/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230112%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230112T230438Z&X-Amz-Expires=86400&X-Amz-Signature=cb38292643afb568e90b8cb3a7466b487318f4f0e1ca1b6afbe3421d33614155&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

비교연산자를 연산한 결과는 언제나 불리언 타입으로 반환되므로, 
True나 False 중 하나의 값이 반환된다.

---

**논리 연산자(logical operator)**

논리 연산자는 주어진 논리식을 판단하며, 참과 거짓을 결정하는 연산자다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/e489e536-93c5-4300-b96f-93c7ece7b262/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230112%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230112T230453Z&X-Amz-Expires=86400&X-Amz-Signature=212b153f427de1555eb58a94c056bc8ddd9555103a1183725350de366b7bff66&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

파이썬에서 or 연산자는 첫 번째 논리식 결과과 False일 때만 두 번째 논리식을 검사한다. 
이것은 첫 번째 논리식의 결과가 True이면 두 번째 논리식을 검사하지 않고도 결과과 True임을 바로 알 수 있기 때문이다.

또한 and 연산자는 첫 번째 논리식의 결과가 True일 때만 두 번째 논리식을 검사한다. 
첫 번째 논리식의 결과과 False이면 두 번째 논리식의 결과와 상관없이 언제나 결과는 False이기 
때문이다.

다음은 논리 연산자의 모든 결과를 나타내는 진리표(turth table)이다.
<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/ccd7576a-1aed-4b48-a6d2-560645a2fffd/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230112%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230112T230507Z&X-Amz-Expires=86400&X-Amz-Signature=82591df953769881fca46374731a5db7cd7c243b7a3ff2e7f8c42c83ac1f4225&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/Python-173d2b202a8047ccae67943f30ed17fb
<br>
👉🏻 출처 : [http://www.tcpschool.com/python2018/python_datatype_boolean](http://www.tcpschool.com/python2018/python_datatype_boolean)
