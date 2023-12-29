package com.stackroute.filter;

import io.jsonwebtoken.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.filter.GenericFilterBean;


import java.io.IOException;

/* This class implements the custom filter by extending org.springframework.web.filter.GenericFilterBean.
 * Override the doFilter method with ServletRequest, ServletResponse and FilterChain.
 * This is used to authorize the API access for the application.
 */
public class JwtUserFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        final String authHeader = request.getHeader("authorization");

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(request, response);
        } else {
            /*
             * Check if authHeader is null or does not start with "Bearer " then throw Exception
             */
            if(authHeader == null || (!authHeader.startsWith("Bearer"))){
                throw new ServletException("Jwt token is missing");
            }
            /*
             * Extract token from authHeader
             */
            String jwtToken = authHeader.substring(7);
            /*
             * Obtain Claims by parsing the token with the signing key value "secret"
             */

            /*
             * Extract role from Claims and check if it is "user" or "admin" and then allow only USER Role
             */

            /*
             * Set Claims object obtained in previous step with key "claims" as request attribute
             */
            try {
                JwtParser jwtParser= (JwtParser) Jwts.parser().setSigningKey("secret");
                Jwt jwtObj = jwtParser.parse(jwtToken);
                Claims claimsObj = (Claims) jwtObj.getBody();
                if (claimsObj.get("role") == "user"){
                    HttpSession session = request.getSession();
                    session.setAttribute("claims",claimsObj.getSubject());
                    request.setAttribute("user","passed");
                }
            } catch (MalformedJwtException e){
                throw new ServletException("Illegal modification in Token");
            }
            /*
             * Set user id passed as request parameter with key "user" as request attribute
             */

            filterChain.doFilter(request, response);
        }
    }
}

