package example.ydzemidovich.messenger.security;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private ServletContext context;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        String authUsername = authentication.getName();
        log.info("Logged user: {}", authUsername);
        Cookie cookie = new Cookie("username", authUsername);
        response.addCookie(cookie);
        response.sendRedirect(context.getContextPath() + "/index.html");
    }

    @Autowired
    public void setContext(ServletContext context) {
        this.context = context;
    }
}
