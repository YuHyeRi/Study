# 파일업로드 1) MultipartFile

## 👧 MultipartFile 인터페이스 사용하여 파일 업로드 구현하기

파일을 리스트로 여러 개 업로드하면 컨트롤러에서 반을 수 있도록 한다(***다중업로드**)

예제구현 : Spring boot 2.1.8, openJDK 11

### 🌸 FileController

기본적으로 @RequestPart 어노테이션을 이용하여 multipart/form-data 요청을 메소드 인수와 연관시킬 수 있다. (→ @RequestParam을 사용해도 동일)

```jsx
@PostMapping("")
@ResponseStatus(HttpStatus.CREATED)
public List<String> upload(@RequestPart List<MultipartFile> files) throws Exception {
	List<String> list = new ArrayList<>();
	for(MultipartFile file : files) {
		String originalfileName = file.getOriginalFilename();
		File dest = new File("C:/Image/" + originalfileName);
		file.transferTo(dest);
	}
	return list;
}
```

### 🌸 application.yml

<aside>
💡 **😶‍🌫️ 잠깐! yml 이란?**

 → **YAML** (YMAL ain’t markup language)

YAML은 모든 데이터를 리스트, 해쉬, 스칼라 데이터의 조합으로 만들어졌다. 

문법은 상대적으로 이해하기 쉽고, 가독성이 좋도록 디자인되었으며 고급 컴퓨터 언어에 적합하다. 또한 들여쓰기 및 XML의 특수기호를 사용하기 때문에 XML과 거의 비슷하며, YAML과 YML은 HTML HTM과 같은 느낌이라고 보면 된다.

- **장점 : 계층구조로 표현되어 있어 가독성이 좋고, 불필요한 소스의 중복도 제거되며, 들여쓰기, 띄어쓰고 구분하여 보기 편하고 깔끔하다**

출처 : [https://kitty-geno.tistory.com/76](https://kitty-geno.tistory.com/76)

</aside>

**spring.sevlet.multipart.enabled → 멀티파트 업로드 지원여부 (디폴트 : true)**

**spring.sevlet.multipart.file-size-threshold → 파일이 메모리에 기록되는 임계값 (디폴트 : 0B)**

**spring.sevlet.multipart.location → 업로드 된 파일의 임시 저장 공간**

**spring.sevlet.multipart.max-file-size → 파일의 최대 사이즈 (디폴트 : 1MB)**

**spring.sevlet.multipart.max-request-size → 요청의 최대 사이즈 (디폴트 : 10MB)**

```jsx
Spring: 
	servlet:
		multipart:
			file-size-threshold: 1MB
			location: c:/Temp
			max-file-size: 100MB
			max-request-size: 100MB
```

파일의 크기가 **file-size-threshold 값 이하라면** 임시파일을 생성하지 않고, 메모리에서 즉시 파일을 읽어서 생성할 수 있다. 속도는 더 빠르겠지만 쓰레드가 작업을 수행하는 동안 부담되는 부분이기 때문에 충분히 검토가 필요한 설정이다. 파일의 크기가 **file-size-threshold 값을 초과한다면** 파일은 spring.servlet.multipart.loaction 경로에 저장되어 해당 파일을 읽어서 작업을 하도록 되어있다.

location을 설정하지 않으면 System.getProperty(”java.io.tmpdir”); 경로에 저장이 된다. 아래 이미지의 path와 같이 눈으로 보기에도 지저분한 경로가 생성될 수 있다.

요청 처리 후에는 파일이 삭제되도록 되어있지만, 운영하다보면 결국 남아있는 것은 어떤 이유로던 남게 되어 있다. 그럴 경우에는 삭제 처리를 별도로 해야 하기 때문에 작업과 관리가 용이하도록 **경로를 직접 설정해주는 것이 좋다.**


### 👧 파일 뿐 아니라, 일반 필드도 같이 보내야할 경우는?

**→ 클라이언트에서는 form 형태로 요청하고, 서버에서는 @RequestParam을사용하여 매핑한다.**

### 🌸 FileController

```jsx
@PostMapping("")
@ResponseStatus(HttpStatus.CREATED)
public List<String> upload(@RequestPart List<MultipartFile> files,
								@RequestParam String field1,
								@RequestParam String field2,
								@RequestParam String field3,
								@RequestParam String field4) throws Exception {
// todo
}
```


### 🌸 FileController

```jsx
@PostMapping("")
@ResponseStatus(HttpStatus.CREATED)
public List<String> upload(FileVo form) throws Exception {
	// todo
}
```

### 🌸 FileVo

```jsx
@Getter
@Setter
public class FileVo {
	
	private List<MultipartFile> files;
	private String field1;
	private String field2;
	private String field3;
	private String field4;
}
```

#### 👉 노션 : https://www.notion.so/1-MultipartFile-5cb23fea51c64f419a71f191b24ec504
