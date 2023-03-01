package com.util;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private String encoding = null;

//    public EncodingFilter() {
//    }

    public void init(FilterConfig fConfig) throws ServletException {
        encoding = fConfig.getInitParameter("pro_encoding");
    }



    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset=UTF-8");
        //让我们的请求继续走，如果 不写程序到这里就会拦截停止
        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}
