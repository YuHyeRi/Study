# Java -02

### Q. Array와 List의 차이는?

***🟣 Array***

- 선언시 배열 크기 지정이 필요하다. (ex. String list - new String[7]; )
- 객체를 넣을 때 index 번호르르 정의해야 한다.
- 다차원 저장이 가능하다.
- 선언시 메모리가 할당된다.
- 기본 데이터 타입(Primitive Type), 오브젝트(Object) 할당이 가능하다.
- 접근이 빠르다 (→ index 번호로 random access를 하기 때문에)

***🟣 List***

- 사이즈 지정을 하지 않아도 동적으로 변화한다.
- 그냥 넣어도 된다. (ex. list.add(’book’); )
- 다차원 저장이 불가능하다.
- 오브젝트(Object)만 할당 가능하다.
- 추가 및 삭제가 빠르다 (→ pointer로 Sequential access를 하기 때문에)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a9039ea8-4ae4-4de2-b91e-ff2c9b3c99f8/Untitled.png)

### Q. String, StringBuffer, StringBuilder의 차이는?

- **String**은 값을 변화시킬 때, Heap에 ***새로운 메모리를 사용하고 참조되는 메모리 주소만 바꿔줌***
- **StringBuffer, StringBuilder**는 Stack에 값을 저장하므로 값이 변화할 때 값을 바꿔 씀
    
    → StringBuffer는 Thread-safe로 멀티스레드 환경에서 안전하다.
    
    → StringBuilder는 StringBuffer보다 빠르다.
    

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/fb9e4eec-c081-4446-a255-961c5cf5cb23/Untitled.png)

### Q. 기본 접근제어자(default)와 protect 접근 제어자의 차이는?

클래스에서 접근제어자를 지정하지 않고 메소드나 변수를 선언했을 때에는 접근제어자가 기본적으로 default 형이 된다. ***default*** 멤버는 같은 패키지 안의 다른 패키지 클래스에서 볼 수 있지만, 해당 멤버 패키지 이외의 클래스에서는 볼 수 없다.

protected는 default와 동일하지만, ***protected*** 클래스를 상속한 클래스는 패키지 밖에서도 볼 수 있다는 것이 차이점이다.

### Q. 해쉬맵과 해쉬테이블의 차이는?

🟣 ***HashMap***

- 메소드 동기화를 지원하지 않는다.
- Thread-safe가 아니다.
- Iterator를 사용한다.
- 하나의 Null key와 여러개의 Null value를 허용한다.
- 성능이 비교적 빠르다.

🟣 ***HashTable***

- 메소드 동기화를 지원한다.
- Thread-safe 이다.
- Enumerator를 사용한다.
- Null을 허용하지 않는다.
- 성능이 비교적 느리다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/665edf44-86be-4083-8a60-636da5ce7e29/Untitled.png)

(*정렬 순서를 유지하고 싶을 경우에는 키값이 트리구조 기반인 TreeMap / 노드가 포인터값을 포함하는 LikedHashMap도 사용을 고려할 수 있다. 다만 이 경우에는 get() 으로 호출시 시간복잡도가 O(logn), O(n)으로 호출 속도가 저하되는 것이 단점이다. 해쉬맵은 키를 해쉬값으로 호출함으로 O(1)이다.)

### Q. 해쉬셋과 트리셋의 차이는?

***🟣 HashSet***

- 넣은 순서대로 저장 순서를 유지하지 않는다.
- null 객체를 저장할 수 있다.
- 검색 성능이 비교적 빠르다.
- 동일 타입 오브젝트 저장 허용한다.
- 비교 오퍼레이션 시, equals 메소드 사용한다.

🟣 ***TreeSet***

- 넣은 순서대로 저장 순서를 유지하지 않는다. (→ 오름차순 정렬)
- null 객체를 저장할 수 없다.
- 검색 성능이 비교적 느리다.
- 동일한 타입의 오브젝트 저장 불가하다. (ClassCastException 발생)
- 비교 오퍼레이션시 comparedTo 메소드 사용한다.

***🟡 결론*** 

중복, 순서 관계 없는 데이터 집합이 필요하다면 → ***HashSet***

정렬이 필요한 데이터 집합이 필요하다면 →  ***TreeSet***

순서를 보장하는 데이터 집합이 필요하다면 → ***HashLinkedSet***

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/89f05b7f-a4b3-4492-af3e-02d830fd5430/Untitled.png)

### Q. 자바 컬렉션이란?

***🟣 정의***

: 객체를 저장하도록 설계된 프레임워크이다. 검색, 정렬(소트), 조작, 삽입, 삭제 등의 오퍼레이션을 수행할 수 있는 객체 집합을 컬렉션이라고 한다. 컬렉션은 자바 인터페이스로 구현되는데, 자료구조 중 list와 set는 컬렉션 인터페이스를 상속하여 정의하고, map은 구조상의 차이로 별도로 정의된다.

***🟣 정렬***

Ordered : 컬렉션에 추가된 순서대로 저장되는 컬렉션

Sorted : 객체 속성에 따라 내부적으로 정렬함

***🟣 분류***

 ***1. List -리스트***

- 삽입 순서가 의미를 가진다.
- 중복을 허용한다.
- ITERATION가 빠르다
1. ***Set -세트***
- 고유한 값을 가지는 자료구조로 중복을 허용하지 않는다.
- 인덱스를 사용하지 않으므로 저장순서가 보장되지 않는다. (→ 검색시 iterator 메소드로 데이터를 불러와야 한다.)
1. ***Map -맵***
- 분별자(Key)가 고유한 값을 가지는 자료구조로, Key는 중복되어서는 안 된다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ca52b954-7923-4d06-87a5-dd05b11c4aa3/Untitled.png)

### Q. 예외(Exception)란?

***🟣 정의***

: 예외란 실행 중에 발생할 수 있는 개발자가 구현한 로직에서 발생하는 문제를 말한다. (* 로직과 관계없는 문제는 오류로 정의한다.) 런타임 중에 문제가 발생하면 메소드는 예외를 던져 문제 발생을 알린다. 예외처리가 안되면 task가 완료되기 전에 실행은 멈춰버리게 되지만, 예외 처리를 하면 플로우는 계속될 수 있다.

***🟣 예외 처리를 해서 얻을 수 있는 이점***

1. 실행을 멈추지 않고 진행하게 할 수 있다.
2. 개발자가 문제를 확인할 수 있다.

***🟣 종류***

1. ***체크 예외 (Check Exception)***
- 컴파일 단계에서 확인되는 예외들이다.
- 반드시 명시적으로 처리해야 한다.
- 로직상 예외 발생 가능성이 있는 상황들을 표현한다. 대표적으로 IOException, SQLException, ClassNotFoundException 이 있다.
- 주로 JVM 외부와 통신 시에 발생하는 예외들이다.
1. ***언체크 예외(Uncheck Exception)***
- 실행 단계에서 확인 되는 예외들이다.
- 명시적인 처리를 강제하지 않는다.
- RuntimeException 클래스의 하위 클래스들이 모두 여기에 속한다. 여기에 속하지 않으면 체크 예외이다.

### Q. 예외 처리 방법은?

1. ***[복구형] Try / Catch 블록***

→ 예외 발생 가능성 있는 코드를 try 문으로 감싸고, 발생시에 처리는 catch에서 받아서 한다. 즉, try-catch 블록을 사용하면 ***해당 메소드에서 예외를 처리하게 된다.***

1. ***[회피형] throw 키워드 선언***

→ 메소드 끝단에 throws Exception을 선언하여 처리한다. 예외 발생 시, ***메소드를 호출한 코드로 예외를 되돌려 보내서 처리***하게 하는 방식이다.

1. ***[전환형] catch에서 다른 예외를 던지는 것***

→ 호출 측에서 ***에러의 타입을 명확하게 인지할 수 있도록 예외를 던져주는*** 것이다.

### Q. 파이널(Final) 키워드에 대하여

1. ***변수*** : 변수가 일단 fianl로 선언되면 변수의 값은 덮어 씌워질 수 없다.
2. ***메소드*** : final 메소드는 오버라이드 될 수 없다.
3. ***클래스*** : 클래스가 final로 선언되면 상속될 수 없다.
4. ***생성자*** : 생성자는 final이 될 수 없다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5717a0f2-645f-466c-9eff-cd37238f5a20/Untitled.png)

👉 노션 : https://www.notion.so/Java-02-e094ede4b21a430fad9384db3517806d
👉 출처 : [https://gem1n1.tistory.com/46?category=784306](https://gem1n1.tistory.com/46?category=784306)
