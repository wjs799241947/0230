<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--

通过 Ajax 技术改进【省市区下拉框三级联动】效果：

1. 获取到的数据，是纯数据，而非整个 html 页面。

2. 获取到数据后的显示过程中，是没有页面的刷新。发生变动的，只是整个页面的局部。

3. 在【发请求-等数据】期间整个页面仍然是可用的。

-->

<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript">
      window.onload = function () {
        $.ajax({
          url: '${pageContext.request.contextPath}/province.do',
          dataType: 'json',
          success: function (data) {
            const province = $('#province');
            province.empty();
            province.append($('<option value="0">请选择</option>'));

            for (let i = 0; i < data.length; i++) {
              let option_html = '<option value="' + data[i].number + '">' + data[i].name + '</option>';
              province.append($(option_html));
            }
          }
        });
      };

      function province_change_handler(event) {
        const area = $('#area');
        area.empty();
        area.append($('<option value="0">请选择</option>'));

        const params = {
          province: event.target.value
        };

        $.ajax({
          url: '${pageContext.request.contextPath}/city.do',
          data: params,
          dataType: 'json',
          success: function (data) {
            const city = $('#city');
            city.empty();
            city.append($('<option value="0">请选择</option>'));

            for (let i = 0; i < data.length; i++) {
              let option_html = '<option value="' + data[i].number + '">' + data[i].name + '</option>';
              city.append($(option_html));
            }
          }
        });
      }

      function city_change_chandler(event) {
        const params = {
          city: event.target.value
        };

        $.ajax({
          url: '${pageContext.request.contextPath}/area.do',
          data: params,
          dataType: 'json',
          success: function (data) {
            const area = $('#area');
            area.empty();
            area.append($('<option value="0">请选择</option>'));

            for (let i = 0; i < data.length; i++) {
              let option_html = '<option value="' + data[i].number + '">' + data[i].name + '</option>';
              area.append($(option_html));
            }
          }
        });
      }
    </script>
</head>
<body>
<p>
    <label> 省:
        <select id="province" name="province" onchange="province_change_handler(event);">
            <option value="0">请选择</option>
        </select>
    </label>
</p>

<p>
    <label> 市:
        <select id="city" name="city" onchange="city_change_chandler(event);">
            <option value="0">请选择</option>
        </select>
    </label>
</p>

<p>
    <label> 区:
        <select id="area" name="area">
            <option value="0">请选择</option>
        </select>
    </label>
</p>
</body>
</html>
