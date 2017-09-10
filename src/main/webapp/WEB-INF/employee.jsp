<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <title>社員情報</title>
  </head>
  <body>
    <div class="container">
      <fieldset>
        <legend>社員一覧</legend>
        <table class="table table-striped">
          <thead>
            <tr>
              <td>#</td>
              <td>名前</td>
              <td> </td>
            </tr>
          </thead>
          <tbody>
            <c:forEach  items="${emps}" var="emp">
              <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>
                  <form method="post" action="${request.contextPath}/delete">
                    <input type="hidden" value="${emp.id}" name="employee-id" />
                    <button class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></button>
                  </form>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </fieldset>
      <fieldset>
        <legend>社員登録</legend>
        <form method="post" action="${request.contextPath}">
          <div class="form-group">
            <input type="text" name="employee-name" class="form-control" />
          </div>
          <button class="btn btn-primary">追加</button>
        </form>
      </fieldset>
    </div>
  </body>
</html>