# [PHP] 산술 연산자

**연산자(operator)**

PHP는 다양한 연산을 위해 많은 종류의 연산자를 제공하고 있다.

---

**산술 연산자(arithmetic operator)**

산술 연산자는 사칙 연산을 다루는 가장 기본적이면서도 많이 사용하는 연산자이다.
산술 연산자는 모두 두 개의 피연산자를 가지는 이항 연산자이며, 
피연산자들의 결합 방향은 왼쪽에서 오른쪽이다.

<aside>
💡 항이란 해당 연산의 실행이 가능하기 위해 필요한 값이나 변수를 의미한다. 따라서 이항 연산자란 해당 연산의 실행을 위해서 두 개의 값이나 변수가 필요한 연산자를 의미한다.

</aside>

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/4400a74e-20fa-48ec-97fb-7cf721cba58b/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230216%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230216T030609Z&X-Amz-Expires=86400&X-Amz-Signature=acc8bc21d4926f751d02ab1a0c7368379e96da4c6b32eac94a9fb4a85a7a737d&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

---

**연산자의 우선순위와 결합 방향**

연산자의 우선순위는 하나의 수식 내에 여러 연산자가 함께 등장할 때 어느 연산자가 먼저 처리될 것인가를 결정한다.
다음 그림은 가장 높은 우선순위를 가지고 있는 괄호 연산자를 사용하여 연산자의 처리 순서를 변경하는 것을 보여준다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/ecf63b68-bcfc-4b7a-b11e-fb1927e73d05/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230216%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230216T030622Z&X-Amz-Expires=86400&X-Amz-Signature=2a863e1608ac71851f02e5619cea5e983adee700649dd435dbfcbd8da7168d9f&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

연산자의 결합 방향은 수식 내에 우선순위가 같은 연산자가 둘 이상 있을 때, 먼저 어느 연산을 수행할 것 인가를 결정한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/17bf9bae-4fc3-4d6e-8cfc-c747af8bc3ef/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230216%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230216T030635Z&X-Amz-Expires=86400&X-Amz-Signature=80e43e15ebc310a5a8ca9f3f37da18ef1a44c3ae169a69ab44fcfc02164e0291&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

---

**PHP 연산자의 우선순위표**

[http://www.tcpschool.com/php/php_operator_arithmetic](http://www.tcpschool.com/php/php_operator_arithmetic)

위의 표에서 나온 순서대로 우선순위가 빠른 연산자가 가장 먼저 실행된다.
또한, 같은 우선순위를 가지는 연산자가 둘 이상 있을 때에는 결합 순서에 따라 실행 순서가 
결정된다.

<aside>
💡 표 내용을 모두 외우기 보다는 필요할 때마다 참조하는 것이 좋다.

</aside>

<br><br>
👉 노션 : https://www.notion.so/tgmary09/PHP-ee0f6788ab43484292c4a81054656474?pvs=4
<br>
👉 출처 : [http://www.tcpschool.com/php/php_operator_arithmetic](http://www.tcpschool.com/php/php_operator_arithmetic)
