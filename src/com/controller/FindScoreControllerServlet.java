package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FindScoreControllerServlet extends HttpServlet{
    ApplicationContext context = null;
    public void init(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @Override
    public void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException{
        int mid;
        FindScoreService service = null;
        String scoreCard = null;
        RequestDispatcher rd = null;

        mid = Integer.parseInt(rq.getParameter("matchId"));
        service = context.getBean("scoreService",FindScoreService.class);

        //user service class
        scoreCard = service.getScore(mid);
        rq.setAttribute("scoreCard", scoreCard);
        //forward request to result.jsp
        rd = rq.getRequestDispatcher("/view_score.jsp");
        rd.forward(rq,rs);
    }
}
