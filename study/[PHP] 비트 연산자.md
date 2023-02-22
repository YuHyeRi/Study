# [PHP] 비트 연산자

**비트 연산자(bitwise operator)**

비트 연산자는 논리 연산자와 비슷하지만 비트(bit) 단위로 논리 연산을 수행한다.
또한, 비트 단위로 비트를 왼쪽이나 오른쪽으로 이동시킬 때도 사용한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/6910f445-c3c9-479a-964f-2402a0f41587/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230222%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230222T102202Z&X-Amz-Expires=86400&X-Amz-Signature=7fe99f00fd8770151a57c424b600508a6e1f45e9c0095bf5a62db75e25beeeef&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

다음 그림은 비트 AND 연산자(&)의 동작을 나타낸다.
이처럼 비트 AND 연산자는 대응되는 두 비트가 모두 1일때만 1을 반환하며, 
다른 경우에는 모두 0을 반환한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/a6a837ee-2f3a-46b5-9305-b98786edc9fc/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230222%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230222T102214Z&X-Amz-Expires=86400&X-Amz-Signature=86dd35af1bc4c26097c716b96603bb5167a090ca8f0e2221176e96ec3ba8e0fc&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

다음 그림은 비트 OR 연산자(|)의 동작을 나타낸다.
이처럼 비트 OR 연산자는 대응되는 두 비트 중 하나라도 1이면 1을 반환하며, 
두 비트가 모두 0일때만 0을 반환한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/487a8aec-e107-44d0-a690-d71ba79831f5/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230222%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230222T102231Z&X-Amz-Expires=86400&X-Amz-Signature=7a6a8c6d306d3a81133edda6b5543706a1d0de4a5a9621ccce86b732e50d8733&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

다음 그림은 비트 XOR 연산자(^)의 동작을 나타낸다.
이처럼 비트 XOR 연산자는 대응되는 두 비트가 서로 다르면 1을 반환하고 
서로 같으면 0을 반환한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/efde2479-799f-4291-a76c-4f5ce27af91e/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230222%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230222T102248Z&X-Amz-Expires=86400&X-Amz-Signature=0e253267e5dbe487d396f9762be3bb1255895fe7f9e4a92e91bd96358bf5ea7a&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

다음 그림은 비트 NOT 연산자(~)의 동작을 나타낸다.
이처럼 비트 NOT 연산자는 해당 비트가 1이면 0을 반환하고 0이면 1을 반환한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/4fa0607d-f1c1-42e1-9948-42c0abc0e35d/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230222%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230222T102300Z&X-Amz-Expires=86400&X-Amz-Signature=66716841caa5505e675684ec22ab629b8962f9868c5b8b3a612e46adb402b3f1&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

```php
$num_01 = 15;
$num_02 = 8;

echo "~ 연산자에 의한 결괏값은 ".(~$num_01)."입니다.<br>";    // 1의 보수
① echo "<< 연산자에 의한 결괏값은 ".($num_02<<1)."입니다.<br>"; // 곱하기 
② echo ">> 연산자에 의한 결괏값은 ".($num_02>>1)."입니다.";     // 나누기 22
```

위 예제의 ①번 라인에서는 왼쪽 시프트 연산자(<<)를 사용하여, 
해당 데이터의 모든 비트를 왼쪽으로 1비트씩 이동시키고 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/43fbbdd8-af32-4ede-98df-9812eaa658fa/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230222%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230222T102316Z&X-Amz-Expires=86400&X-Amz-Signature=35eda7a873e1132541082475998c0f66cee6c02c6e77f791ff580f06b0170720&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

그 결과 해당 데이터의 값은 처음 값에 2를 곱한 것과 같아진다.
반대로 ②번 라인에서는 오른쪽 시프트 연산자(>>)를 사용하여, 
해당 데이터의 모든 비트를 오른쪽으로 1비트씩 이동시키고 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/c7eaa044-39dd-4472-b237-ea60d09f2e54/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230222%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230222T102328Z&X-Amz-Expires=86400&X-Amz-Signature=e0f0bbf8e7f5b6074367b8bd0ae2b8c4e8e75a33da87f9f5bd86838f0b3ea7aa&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

그 결과 해당 데이터의 값은 처음 값에 2를 나눈 것과 같아진다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/PHP-48c5a1c386bc4328843ce6130f204bd8?pvs=4
<br>
👉 출처 : [http://www.tcpschool.com/php/php_operator_bitwise](http://www.tcpschool.com/php/php_operator_bitwise)
