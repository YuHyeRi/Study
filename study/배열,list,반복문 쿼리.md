# 배열 / list / 반복문 쿼리

## **[MyBatis] 배열파라미터 list사용하는 쿼리, 반복문 쿼리**

boardType 변수는 String[] 타입

String[] 타입을 map에 넣었다.

```jsx
String[] boardType; // checkbox 선택지를 가져올 배열타입의 변수 생성
boardType = request.getParameterValues("boardType"); // checkbox 선택지 가져오기
map.put("boardType", boardType);
```

이 map을 파라미터로 받아서 select 쿼리를 하려고 한다.

```jsx
<select id="boardTypeList" parameterType="hashmap" resultMap="boardVo">
	select 
				board_type,
				board_num,
				board_title,
				board_comment,
				total_cnt
	from (select
							board_type,
							board_num,
							board_title,
							board_comment,
							row_number() over(order by board_num desc) as rownum,
							count(*) over() as total_cnt
				from board
				<if test="boardType != null">
				where 
				<foreach collection="boardType" item="arr" separator="or">
					board_type = #{arr}
				</foreach>
				</if>	
				)
	where rownum between 1 and 10
</select>
```

### <foreach collection=“boardType” item=”arr” separator=”or”>

- **collection : 전달받은 인자 (→ List or Array 형태만 가능)**
- **item : 전달받은 인자 값의 alias명**
- open : 구문이 시작될 때 삽입할 문자열
- close : 구문이 종료될 때 삽입할 문자열
- separator : 반복되는 사이에 출력할 문자열
- index : 반복되는 구문 번호로 0부터 순차적으로 증가

#### 👻 노션링크 : https://www.notion.so/list-b67cea8124024df89635a450dc87cd8a
