<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post" action="note"> 
        <strong>Title:</strong>
        <input type="text" name="title" value="${note.title}">
        
        
        <br>
        <strong>Contents:</strong>
        <textarea cols="30" rows="10" name="content" >${note.content}</textarea>
        <br>
        <input type="Submit" value="Save">
        
    </form>
        
    </body>
</html>
