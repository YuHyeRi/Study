# input type=โsubmitโ VS โbuttonโ

### ๐ฃ button ํ๊ทธ์ type ์์ฑ

- type=โ**submit**โ โ ํผ์ ์ ์ถํ๋ ์ด๋ฒคํธ ๋ฐ์
- type=โ**reset**โ โ ํผ ์์ ์์ฑ๋ ๋ด์ฉ์ ์ด๊ธฐํ ์ํด
- type=โ**button**โ โ ๊ทธ ์์ฒด๋ก๋ ์ด๋ฒคํธ๊ฐ ์๊ณ , click ์ด๋ฒคํธ์ ์ฐ๊ฒฐ์์ผ ์๋ฐ์คํฌ๋ฆฝํธ๋ฅผ ํ์ฉํจ

```jsx
<button type="button">ํด๋ฆญ</button>

var btn = document.querySelector("button");
btn.addEventListener("click", function() {
	alert("ํ์คํธ ์ค์๋๋ค.");
})
```

button ํ๊ทธ์ type ๊ฐ๋ค์ ์ดํด๋ณด๋ button์ form์์ ํ์ฉํ๋ผ๊ณ  ๋ง๋  ํ๊ทธ๋ผ๋ ๊ฒ์ ์ง์ํ  ์ ์๋ค.



### ๐ฃ button VS input

***(โ button ํ๊ทธ๊ฐ ๋์์ธ ๋ฉด์์ ๋ ์์ ๋กญ๋ค.)***

button ํ๊ทธ์ input ํ๊ทธ์ ๊ฐ์ฅ ํฐ ์ฐจ์ด์ ์

**button** โ ์ค์ค๋ก ๋ซ์ง ์๋ ํ๊ทธ

**input** โ ์ค์ค๋ก ๋ซ๋ ํ๊ทธ

๋ฐ๋ผ์ **button**์ ํ์ ํ๊ทธ๋ค์ ์ถ๊ฐํ  ์ ์์ง๋ง **input**์ ๊ทธ๋ด ์ ์๋ค.

๊ฐ๋ น, form์ ์ ์ถ ๋ฒํผ์ ์ด๋ฏธ์ง๋ฅผ ์ฝ์ํ๊ณ  ์ถ๋ค๋ฉด

**button** โ button ํ๊ทธ์ ์์์ผ๋ก img ํ๊ทธ๋ฅผ ๋ฃ์ด์ค๋ค

**input** โ css์ background-image๋ฅผ ์ฌ์ฉํด์ผ ํ๋ค.

***(* ์ฐธ๊ณ ๋ก ์ด๋ฏธ์ง๋ img ํ๊ทธ๋ฅผ ์ฌ์ฉํ๋ ๊ฒ์ด ๊ฒ์์์ง ์ต์ ํ ๋ฑ์ ๋์์ด ๋๋ค.)***

****input ํ๊ทธ์ button ํ๊ทธ์ ์ด๋ฏธ์ง ์ฝ์ ๋ฐฉ๋ฒ์ ์ฐจ์ด***

```html
<button type="button">
	<img src="์ด๋ฏธ์ง์ฃผ์.png">
</button>

<input type="button" />

< !-- css --! >
input {
	width: 200px; height: 200px;
	background-image: url(์ด๋ฏธ์ง์ฃผ์.png);
	background-size: 100% 100%
}
```

๐ ๋ธ์ : https://www.notion.so/input-type-submit-VS-button-083bfe98be304be5babeac3ed14c2ea7

๐ ์ฐธ๊ณ  : [https://cocoder16.tistory.com/18](https://cocoder16.tistory.com/18)
