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

import model.Disease;
import model.DiseaseService;
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
                    sc.getRequestDispatcher("/jsp/dashboard.jsp").forward(req, res);
                } catch (Exception e) {
                }
                break;
            case "/diseases":
                DiseaseService ds = new DiseaseService();
                List<Disease> diseases = ds.list();
                req.setAttribute("diseases", diseases);
                try {
                    sc.getRequestDispatcher("/jsp/diseases_list.jsp").forward(req, res);
                } catch (Exception e) {
                }
                break;
            case "/new-diseases":
                try {
                    sc.getRequestDispatcher("/jsp/new_disease.jsp").forward(req, res);
                } catch (Exception e) {
                }
                break;
            default:
                try {
                    sc.getRequestDispatcher("/jsp/not_found.jsp").forward(req, res);
                } catch (Exception e) {
                }
        }
    }

    @Override
    public void doPost(HttpServletRequest req,
                       HttpServletResponse res) {
        String path = req.getServletPath();
        ServletContext sc = req.getServletContext();
        switch (path) {
            case "/new-diseases":
                try {
                    DiseaseService ds = new DiseaseService();

                    String name = req.getParameter("name");
                    String symptoms = req.getParameter("symptoms");
                    ds.create(name, symptoms);
                    res.sendRedirect("/lab-eng-web/diseases");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                try {
                    sc.getRequestDispatcher("/jsp/not_found.jsp").forward(req, res);
                } catch (Exception e) {
                }
        }
    }
}