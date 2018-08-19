package com.finereach.test.ipblacklist.controller;

import com.finereach.test.ipblacklist.service.BlacklListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BlackListCustomFilter implements Filter {

    final BlacklListService blacklListService;

    public BlackListCustomFilter( BlacklListService blacklListService) {
        this.blacklListService = blacklListService;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request1 = (HttpServletRequest) request;

        String ip = request.getRemoteAddr();

        if(blacklListService.getIpBlacklist(ip)==null){

            chain.doFilter(request, response);
        }else{

            ((HttpServletResponse) response)
                    .setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }



        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
