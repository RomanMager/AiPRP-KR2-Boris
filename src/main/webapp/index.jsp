<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->

    <link crossorigin="anonymous" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" rel="stylesheet">
    <script crossorigin="anonymous"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

    <title>Search for student</title>
</head>
<body>
    <div class="container">
        <form action="${pageContext.request.contextPath}/load" method="post">
            <label for="url-field" title="Remote resource">
                <input type="url" name="url" id="url-field">
            </label>
            <button type="submit">Load</button>
        </form>

        <div>
            <c:if test="${not empty success}">
                <p>Single Img data</p>
                <a href="${tagData}">Link to image</a>
                <hr>

                <c:forEach var="imgLink" items="${imgLinks}">
                    <div>
                        <img src="${imgLink}" alt="" />
                        <hr>
                    </div>
                </c:forEach>
                <%--<p>You can download file here!</p>--%>
                <%--<br>--%>
                <%--&lt;%&ndash;TODO: Change download path&ndash;%&gt;--%>
                <%--<a href="" download="">Download</a>--%>
            </c:if>
        </div>

        <div>
            <c:if test="${not empty error}">
                <p>Smth went wrong</p>
                <p>${error}</p>
            </c:if>
        </div>
    </div>
</body>
</html>
