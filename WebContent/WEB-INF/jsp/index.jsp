<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Spring Landing Page</title>
  </head>
  <body>
    <h2>Spring Landing Page</h2>
    <p>test</p>
    <form:form method="get" action="/ssmDemo/redirect">
    <table>
      <tr>
        <td>
          <input type="submit" value="页面重定向"/>
        </td>
      </tr>
    </table>
   </form:form>
  </body>
</html>