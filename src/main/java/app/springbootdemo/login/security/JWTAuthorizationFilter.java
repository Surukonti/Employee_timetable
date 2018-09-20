package app.springbootdemo.login.security;

import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import static app.springbootdemo.login.security.SecurityConstants.HEADER_STRING;
import static app.springbootdemo.login.security.SecurityConstants.SECRET;
import static app.springbootdemo.login.security.SecurityConstants.TOKEN_PREFIX;
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {  //responsible for user authorization //BasicAuth to make spring replace it in the filter chain with our custom implementatn
    public JWTAuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {


        String header = req.getHeader(HEADER_STRING);
        if(req.getMethod().equals("OPTIONS"))
        {
            res.setStatus(200); return;
        }

        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }

    UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
}
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING); // getauthntctn..reads jwt from authrizatn header and uses jwt to validate token. if all ok set user in securitycontext and allo request.
        if (token != null) {
            // parse the token.
            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }
}
