# onsubmit return false

### ๐ง  HTML : onsubmit return false ๋?

```html
<form action="search" name="searchForm" onsubmit="return false">
	<input type="submit" name="submit" value="์ ์ก" />
</form>
```

์์ form์ด ์๋ค๊ณ  ๊ฐ์ ํ  ๋, onsubmit์ return false๋ผ๋ฉด action์ด ์คํ๋์ง โ

```html
<form action-"search" name="searchForm" onsubmit="return chkSum();">
	<input type="submit" name="submit" value="์ ์ก" />
</form>
```

์์ form์์๋ onsubmit์ chkSum() ํจ์๊ฐ ์ ์์ ์ผ๋ก ์๋ฃ๋๋ฉด action์ด ์คํ โญ

๊ทธ๋ฌ๋, chkSum() ํจ์๊ฐ ์ ๋๋ก ์๋ฃ๋์ง ์๊ณ  return false ๊ฐ์ ๋ฐ๋๋ค๋ฉด action์ด ์คํ๋์ง โ

๐ ๋ธ์ ๋งํฌ : https://www.notion.so/onsubmit-return-false-a7e0e6c5b2824647b68b8426a947626a
