/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.arvato.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

/**
 *
 * @author CHEW017
 */
@WebServlet(name = "PutServlet")
public class PutServlet extends HttpServlet {

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String jsonStr = IOUtils.toString(req.getInputStream());
        JSONObject jsonObject = new JSONObject(jsonStr);

        if (jsonObject.has("username")) {
            String username = jsonObject.getString("username");
            resp.getWriter().print("Hello " + username + "! You are using HTTP PUT");
        } else {
            resp.getWriter().print("Request body \"username\" is not found");
        }

    }
}
