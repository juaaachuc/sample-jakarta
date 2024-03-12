package com.example.samplejakarta;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.google.gson.Gson;

@WebServlet(name = "userServlet", value = "/user-servlet")
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

        User user = new User("Juan", "Chuc", "jachucme");
        sendAsJson(response, user);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
