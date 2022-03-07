# onsubmit return false

### 🧠 HTML : onsubmit return false 란?

```html
<form action="search" name="searchForm" onsubmit="return false">
	<input type="submit" name="submit" value="전송" />
</form>
```

위의 form이 있다고 가정할 때, onsubmit에 return false라면 action이 실행되지 ❌

```html
<form action-"search" name="searchForm" onsubmit="return chkSum();">
	<input type="submit" name="submit" value="전송" />
</form>
```

위의 form에서는 onsubmit에 chkSum() 함수가 정상적으로 완료되면 action이 실행 ⭕

그러나, chkSum() 함수가 제대로 완료되지 않고 return false 값을 받는다면 action이 실행되지 ❌

👉 노션 링크 : https://www.notion.so/onsubmit-return-false-a7e0e6c5b2824647b68b8426a947626a
