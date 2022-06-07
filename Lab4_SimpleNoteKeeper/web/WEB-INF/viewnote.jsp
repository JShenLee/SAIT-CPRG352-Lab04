<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Note</title>
    </head>
    <body>
     
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <strong>Title:</strong><p>${note.title}</p>
        <br>
        <strong>Contents:</strong><p>${note.content}</p>
       
        <a href="note?edit">Edit</a>
        
      
    </body>
</html>
