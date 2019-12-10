package com.fpt.t1708e.photoplatform.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CustomLoginHandler implements AuthenticationSuccessHandler {

    @Autowired
    ObjectFactory<HttpSession> httpSessionFactory;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException {
        HttpSession session = httpSessionFactory.getObject();
        String test = session.getAttribute("previousUrl").toString();
        if(test.contains("register")){
            sendRedirect(httpServletRequest, httpServletResponse, "/");
        }
        sendRedirect(httpServletRequest, httpServletResponse, session.getAttribute("previousUrl").toString());
        }


    private void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
        if(!response.isCommitted()){
            new DefaultRedirectStrategy().sendRedirect(request,response,url);
        }
    }
}
