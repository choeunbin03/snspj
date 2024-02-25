<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<table>
		<tbody>
			<c:forEach items="${cmntList}" var="cmnt">
				<tr>
					<td><c:out value="${cmntList.rgtrId}" /></td>
					<td><c:out value="${cmntList.rgtrDt}" /></td>
					<td><c:out value="${cmntList.cmntCn}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>