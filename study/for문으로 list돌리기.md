# for문으로 list 돌리기

## ArrayList

### 👧🏻 배열크기 : size();

배열의 크기는 length 속성을 이용하여 얻을 수 있다. 하지만 ArrayList는 **고정된 길이를 가지고 있지 않으므로** length 대신 **size()** 함수를 이용한다.

→ ArrayList 배열명.size();

```jsx
ArrayList cars = new ArrayList();
System.out.printIn(cars.size()); // ArrayList의 크기 출력
```

### 👧🏻 출력 : for문

간단히 항목들을 나열하기 원한다면 배열명으로 충분하다. 그러나 항목번호 등 추가 정보를 출력하고자 할 때는 for문을 사용하는 것이 좋다. 물론 이때 전체 배열의 크기는 size()함수를 사용한다.

```jsx
import java.util.ArrayList;

public class SizeTest {
	public static void main(String[] args) {
		ArrayList<String> fw = new ArrayList<String>();
		fw.add("개나리");
		fw.add("동백꽃");
		fw.add("진달래");

		for(int i=0; i<fw.size(); i++) {
			System.out.printIn(i + "." + fw.get(i));
		}
	}
}

// 0. 개나리
// 1. 동백꽃
// 2. 진달래
```

### 👧🏻 출력 : for each문

배열의 출력을 위해 사용하는 for each문 역시 사용이 가능하다. for each문은 (항목변수 선언 : 배열명) 을 인자로 받는다. for each문은 변수에 항목들이 저장되고 항목 수 만큼 반복되므로 **size() 함수를 사용하지 않아도** 된다.

```jsx
import java.util.ArrayList;

public class EachTest {
	public static void main(String[] args) {
		ArrayList<String> fw = new ArrayList<String>();
		fw.add("개나리");
		fw.add("동백꽃");
		fw.add("진달래");

		int count = 1;           // count 변수 선언
		for(String i : fw) {     // String 변수 선언 : 배열명
			System.out.printIn(count + "." + i);  
			count++;               // count증가   
		}
	}
}

// 1. 개나리
// 2. 동백꽃
// 3. 진달래
```

int count = 1;    // 항목번호를 위한 변수를 선언

String i : fw       // 배열항목과 같은 데이터타입인 String 변수를 선언

count++;          // 항목번호를 증가시킴

System.out.printIn(count + “.” + i);      // 항목변수 i만으로 출력 가능

확실히 배열 등을 출력할 때는 for each문이 편리하다. 그러나 초기값이 없기 때문에 항목번호 등을 나타내고자 할 경우에는 추가로 **숫자를 나타내는 변수를 선언**하고 **증가시키는 작업**을 해주어야 한다.

#### 👉 노션링크 : https://www.notion.so/for-list-59c5187677e147ff9b33896605254d62
