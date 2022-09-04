<%@page import="java.util.List"%>
<%@page import="ModelVO.EmpresaVO"%>
<%
    HttpSession sesion = request.getSession();
    List<EmpresaVO> empresas = (List<EmpresaVO>) sesion.getAttribute("empresas");

    if (empresas.size() == 0) {
        response.sendRedirect("SignUpEmpresa.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
