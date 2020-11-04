/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserService;

import java.util.List;

@WebServlet({"*.action", "/"})
public class App extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res) {

        String path = req.getServletPath();
        ServletContext sc = req.getServletContext();
        UserService us = new UserService();
        List<User> users = us.list();
        req.setAttribute("users", users);
        switch (path) {
            case "/":
                try {
                    sc.getRequestDispatcher("/jsp/list.jsp").forward(req, res);
                } catch (Exception e) {
                }
                break;
            default:
                try {
                    sc.getRequestDispatcher("/jsp/nao_encontrado.jsp").forward(req, res);
                } catch (Exception e) {
                }
        }

    }
}