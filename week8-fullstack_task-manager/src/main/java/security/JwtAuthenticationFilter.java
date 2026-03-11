package security;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class JwtAuthenticationFilter extends GenericFilter {

 @Override
 public void doFilter(ServletRequest request, ServletResponse response,
 FilterChain chain) throws IOException, ServletException {

  HttpServletRequest req = (HttpServletRequest) request;

  String token = req.getHeader("Authorization");

  if(token != null){
   // validate token
  }

  chain.doFilter(request,response);
 }
}