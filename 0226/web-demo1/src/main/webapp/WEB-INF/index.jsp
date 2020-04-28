<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript">
      $(function () {

        // 【省】的下拉菜单被选中某个后，触发下述代码：查询该省下的所有市
        $("#province").change(function () {
          let url = '${pageContext.request.contextPath}/city.do';
          $('#form').attr('action', url);
          $('#form').submit();
        });

        // 【市】的下拉菜单被选中某个后，触发下述代码：查询该市下的所有区
        $("#city").change(function () {
          let url = '${pageContext.request.contextPath}/area.do';
          console.info('url');
          $('#form').attr('action', url);
          $('#form').submit();
        });
      });
    </script>
</head>
<body>
<form id="form" action="">
    <p>
        <label> 省:
            <select id="province" name="province">
                <option value="0">请选择</option>
                <c:forEach items="${requestScope.provinceList}" var="province">
                    <c:if test="${requestScope.provinceNumber == province.number}">
                        <option value="${province.number}" selected>${province.name}</option>
                    </c:if>
                    <c:if test="${requestScope.provinceNumber != province.number}">
                        <option value="${province.number}">${province.name}</option>
                    </c:if>
                </c:forEach>
            </select>
        </label>
    </p>

    <p>
        <label> 市:
            <select id="city" name="city">
                <option value="0">请选择</option>
                <c:forEach items="${requestScope.cityList}" var="city">
                    <c:if test="${requestScope.cityNumber == city.number}">
                        <option value="${city.number}" selected>${city.name}</option>
                    </c:if>
                    <c:if test="${requestScope.cityNumber != city.number}">
                        <option value="${city.number}">${city.name}</option>
                    </c:if>
                </c:forEach>
            </select>
        </label>
    </p>

    <p>
        <label> 区:
            <select id="area" name="area">
                <option value="0">请选择</option>
                <c:forEach items="${requestScope.areaList}" var="area">
                    <option value="${area.number}">${area.name}</option>
                </c:forEach>
            </select>
        </label>
    </p>
</form>
</body>
</html>
