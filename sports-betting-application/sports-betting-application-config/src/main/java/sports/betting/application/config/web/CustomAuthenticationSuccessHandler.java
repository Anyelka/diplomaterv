package sports.betting.application.config.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        authorities.forEach(authority -> decideRedirect(httpServletResponse, authority));
    }

    private void decideRedirect(HttpServletResponse httpServletResponse, GrantedAuthority authority) {
        if(authority.getAuthority().equals("ROLE_ADMIN")) {
            try {
                httpServletResponse.sendRedirect("/admin/events");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if(authority.getAuthority().equals("ROLE_PLAYER")) {
            try {
                httpServletResponse.sendRedirect("/player/home");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
