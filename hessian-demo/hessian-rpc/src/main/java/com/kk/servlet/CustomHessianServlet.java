package com.kk.servlet;

import com.caucho.hessian.server.HessianServlet;
import org.apache.commons.codec.binary.Base64;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * 需要用户名和密码
 * <p/>
 * factory.setUser("xx");
 * factory.setPassword("xx");
 */
public class CustomHessianServlet extends HessianServlet {

    private static final long serialVersionUID = 5652773984778690110L;

    @Override
    public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String auth = httpServletRequest.getHeader("Authorization");
        if (auth == null) {
            noAuth(httpServletRequest, httpServletResponse);
            return;
        }
        System.out.println(auth);
        if (auth.startsWith("Basic ")) {
            auth = auth.substring(6);
        }
        String[] array = new String(Base64.decodeBase64(auth), "UTF-8").split(":");
        System.out.println(Arrays.asList(array));
        String user = array[0];
        String password = array[1];
        super.service(request, response);
    }

    private void noAuth(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(401);
        PrintWriter serviceId1 = response.getWriter();
        response.setContentType("text/html");
        serviceId1.println("<h1>Hessian Auth Error</h1>");
    }
}