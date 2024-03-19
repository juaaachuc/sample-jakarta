package com.example.samplejakarta;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.google.gson.Gson;

@WebServlet("/user-servlet/*")
public class UserServlet extends HttpServlet {
    private Gson _gson = null;

    public UserServlet() {
        _gson = new Gson();
    }

    private void sendAsJson(
            HttpServletResponse response,
            Object obj) throws IOException {

        response.setContentType("application/json");

        String res = _gson.toJson(obj);

        PrintWriter out = response.getWriter();

        out.print(res);
        out.flush();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        try {
            String[] path = request.getPathInfo().split("/");

            for (String element : path) {
                System.out.println(element);
            }

            if (request.getPathInfo().equals("/") || request.getPathInfo() == null) {
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h1>" + "Vista de usuarios" + "</h1>");
                out.println("</body></html>");
                return;
            }

            if (path.length == 2) {
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.printf("<h1>Vista de usuario %s</h1>", path[1]);
                out.println("</body></html>");
                return;
            }

            if (path.length == 3) {
                if (path[2].equals("edit")) {
                    PrintWriter out = response.getWriter();
                    out.println("<html><body>");
                    out.printf("<h1>Vista para editar usuario %s</h1>", path[1]);
                    out.println("</body></html>");
                    return;
                }
            }

            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>404 NOT FOUND!</h1>");
            out.println("</body></html>");
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + "Vista de usuarios" + "</h1>");
            out.println("</body></html>");
            return;
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
