package indi.wwq.mickey.filters;


import indi.wwq.mickey.controller.IndexController;
import indi.wwq.mickey.pojo.GpUser;
import indi.wwq.mickey.service.GpUserService;
import indi.wwq.mickey.service.impl.GpPlayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * <p>设置过滤器,若存在对应cookie,则自动登录</p>
 * @author wg
 */
@WebFilter(urlPatterns = "/*", filterName = "loginFilter")
public class LoginFilter implements Filter {
    boolean pass;
    final GpUserService userService;
    public LoginFilter(GpUserService userService) {
        this.userService = userService;
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
         pass = false;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(!pass) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                String password = "";
                GpUser gpUser = null;
                for (Cookie cookie : cookies) {
                    if ("mickeyUserId".equals(cookie.getName())) {
                        String id = cookie.getValue();
                        gpUser = userService.selectByPrimaryKey(id);
                    }
                    if ("mickeyPassword".equals(cookie.getName())) {
                        password = cookie.getValue();
                    }
                }
                if (gpUser != null && gpUser.getPassword().equals(password)) {
                    IndexController.gpUser = gpUser;
                }
            }
            pass = true;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
