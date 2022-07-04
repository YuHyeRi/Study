# a태그 인수 POST로 보내기

## 🧠 a태그에서 인수를 POST방식으로 보내는 방법

```jsx
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>a태그 form 전송하기</title>
		<script>

		// content, category, index를 인수로 받아 form로 전송하는 함수
		function goPage(content, cate, index = 0) {
			// name이 paging인 태그
			var f = document.paging;

			// form의 하위 태그 값 매개 변수로 대입
			f.content.value = content;
			f.cate.value = cate;
			f.index.value = index;

			// input 태그의 값들을 전송하는 주소
			f.action = "./content.do"

			// 전송방식 : POST
			f.method = "post"
			f.submit();
		};
		</script>
	</head>
	<body>
		<!-- 페이지 전송 폼--!>
		<form name="paging">
			<input type="hidden" name="content" />
			<input type="hidden" name="cate" />
			<input type="hidden" name="index" />
		</form>
		<!-- a태그로 인수 전달 --!>
		<a href="javascript:goPage('look', 'observation', 1);">관람</a>
	</body>
</html>
```

#### 🧠 노션링크 : https://www.notion.so/a-POST-a1f86fafccde4b308caaff339e35583d
