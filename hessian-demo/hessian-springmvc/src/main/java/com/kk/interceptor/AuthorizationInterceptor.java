package com.kk.interceptor;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    private Log logger = LogFactory.getLog(AuthorizationInterceptor.class);

    private void noAuth(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(401);
        PrintWriter serviceId1 = response.getWriter();
        response.setContentType("text/html");
        serviceId1.println("<h1>Hessian Auth Error</h1>");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String authorization = request.getHeader("Authorization");
            if (authorization == null) {
                noAuth(request, response);
                return false;
            }
            System.out.println(authorization);
            if (authorization.startsWith("Basic ")) {
                authorization = authorization.substring(6);
            }
            String[] array = new String(Base64.decodeBase64(authorization), "UTF-8").split(":");
            System.out.println(Arrays.asList(array));
//            if (check array) {
//                response.setStatus(401);
//                return false;
//            }
            return true;
        } catch (Exception e) {
            logger.error("authorized failed : {}", e);
            return false;
        }
    }
}
