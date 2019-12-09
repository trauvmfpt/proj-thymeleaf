package com.fpt.t1708e.photoplatform.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomLoginHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException {
            sendRedirect(httpServletRequest, httpServletResponse, "/");
        }


    private void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
        if(!response.isCommitted()){
            new DefaultRedirectStrategy().sendRedirect(request,response,url);
        }
    }
}
