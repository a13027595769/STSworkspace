<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
<title>用户列表</title>
</head>
<body>
	
	<a href="input">添加</a>
	<table border="1" width="800">
		<thead>
			<tr>
				<th width="100px">id</th>
				<th width="100px">name</th>
				<th width="100px">className</th>
				<th width="100px">profession</th>
				<th width="100px">department</th>
				<th width="100px">fujian</th>
				<th width="100px">rudang</th>
				<th width="100px">DO SOME THING</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="u">
				<tr align="center">
					<td>${u.id}</td>
					<td>${u.name}</td>
					<td>${u.className}</td>
					<td>${u.profession}</td>
					<td>${u.department}</td>
					<td><fmt:formatDate value="${u.rudang}" pattern="yyyy-MM-dd"/></td>
					
					<td>${u.fujian}</td>
					<td>
						<a href="/delete?id=${u.id}">删除</a> 
						<a href="/input?id=${u.id}">编辑</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>

<%-- <fmt:formatDate value="${u.birth}" pattern="yyyy-MM-dd"/> --%>
</html>
