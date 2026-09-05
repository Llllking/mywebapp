<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
    <head>
        <title>hello-html-jsp</title>
    </head>
    <body>
        <p>Welcome ${name}</p>
        <hr>
        <h1>Your todos</h1>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>Is Done?</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.id}</td>
                        <td>${todo.description}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.done}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>