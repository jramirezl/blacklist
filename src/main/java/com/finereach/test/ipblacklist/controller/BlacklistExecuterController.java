package com.finereach.test.ipblacklist.controller;


import com.finereach.test.ipblacklist.service.BlacklListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;


import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class BlacklistExecuterController {




    @ModelAttribute
    public void handleRequest(HttpServletRequest request, Model model) {

        String ip = request.getRemoteAddr();
       // System.out.println(ip);
    }


}
