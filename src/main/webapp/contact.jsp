<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Data.ContactData" %>
<%@ page import="java.util.List" %>
<%@include file="includes/header.jsp"%>
<table border="2px solid">
    <thead>
    <th>S.N</th>
    <th>Name</th>
    <th>email</th>
    <th>Address</th>
    <th>Phoneno</th>
    <th>Mobno</th>
    </thead>

    <c:if test="${requestScope.contacts != null}">
        <%
            List<ContactData> contacts = (List<ContactData>) request.getAttribute("contacts");
            for (ContactData contact : contacts){
                System.out.println(contacts);
            }
        %>
    </c:if>


    <c:forEach items="${requestScope.contacts}" var="contact" varStatus="i">
        <tr>
            <td><c:out value="${i.index+ 1}"></c:out> </td>
            <td><c:out value="${contact.getName()}"></c:out> </td>
            <td><c:out value="${contact.getEmail()}"></c:out> </td>
            <td><c:out value="${contact.getAddress()}"></c:out> </td>
            <td><c:out value="${contact.getPhoneno()}"></c:out> </td>
            <td><c:out value="${contact.getMobno()}"></c:out> </td>
           <td>
               <a href="/contact/edit?id=${contact.getId()}"> Edit</a>
               <a href="delete?id=$(i.id)">Delete</a>
           </td>

        </tr>
    </c:forEach>
</table>

<form method="post" action="/contact/add">
    <h1>Add Contact</h1>
    <br>Name:<input type="text" name="name"><br>
    <br>Email:<input type="email" name="email"><br>
    <br>Address:<input type="text" name="address"><br>
    <br>phone no:<input type="number" name="phoneno"><br>
    <br>Mobile no:<input type="number" name="mobno"><br>


    <input type="submit" value="Save">



<%@include file="includes/footer.jsp"%>
