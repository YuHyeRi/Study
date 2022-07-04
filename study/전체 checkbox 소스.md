### 소스참고

```jsx
<main>
	<div class="alert alert-light"><h4>회원수 : ${total} 명</h4></div>
		<c:set var="num" value="${pg.total-pg.start+1}"></c:set>
		<form method="post" action="${pageContext.request.contextPath}/admin/authority" name="frm" onsubmit="return chk(this);">
				<table class="table table-hover">
					<tr class="table-secondary">
						<th><input type='checkbox' name='check' value='selectall' onclick='selectAll(this)' /> 번호</th>
						<th>ID</th>
						<th>이름</th>
						<th>가입 날짜</th>
						<th>관심 분야</th>
						<th>모임 권한</th>
						<th>클래스 권한</th> 	
					</tr>
					<c:forEach var="member" items="${auth_listMember}">
					<tr>
						<td><input type="checkbox" value="${member.m_id}" name="m_idArray"> ${num}</td>
						<td>${member.m_id}</td>
						<td>${member.m_name}</td>
						<td>${member.m_regdate}</td>
						<td>${member.m_field}</td>
						<c:choose>
							<c:when test="${member.m_meetingauth eq 'Y' and member.m_masterauth eq 'N'}">
								<td><font style="color: blue">권한 인증 [O]</font></td>
								<td><font style="color: red">권한 요청 ["!"]</font></td>
							</c:when>
							{...}
		</main>
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid px-4">
					<div class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Your Website 2021</div>
						<div> <a href="#">Privacy Policy</a> &middot; <a href="#">Terms&amp; Conditions</a></div>
					</div>
				</div>
			</footer>
		</div>
	</div>
	<script type="text/javascript">
	function chk(form) {
		var arr_form = document.getElementsByName('m_idArray');
		var num = 0;
		for (var i = 0; i < arr_form.length; i++) {
			if (arr_form[i].checked) {
				num++;
			}
		}
		if (!num) {
			alert('번호를 선택해주세요');
			return false;
		}
	}
	function selectAll(selectAll)  {
		  const checkboxes = document.getElementsByName('m_idArray');
		  checkboxes.forEach((checkbox) => {checkbox.checked = selectAll.checked;})
		}
	</script>
```

👉 노션 : https://www.notion.so/checkbox-985904593522423c89b2ba223d8a55c5
