package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
// to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String title = br.readLine();
        String content = br.readLine();

        Note note = new Note(title, content);

        request.setAttribute("title", title);
        request.setAttribute("content", content);
        request.setAttribute("note", note);
        br.close();

        String param = request.getParameter("edit");
        if (param == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
            return; //Stops the code call. VERY IMPORTANT.
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            return; //Stops the code call. VERY IMPORTANT.
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

// to write to a file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));

        pw.println(request.getParameter("title"));
        pw.println(request.getParameter("content"));
        pw.close();
        BufferedReader br;
        br = new BufferedReader(new FileReader(new File(path)));
        String newTitle = br.readLine();
        String newContent = br.readLine();

        Note note = new Note(newTitle, newContent);

        br.close();
        request.setAttribute("note", note);

        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        return; //stop the code call after loading a jsp.
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
