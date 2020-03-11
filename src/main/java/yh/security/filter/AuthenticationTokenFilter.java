package yh.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import yh.common.Result;
import yh.common.StatusCode;
import yh.user.service.UserService;
import yh.util.JwtTokenUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Component
public class AuthenticationTokenFilter extends OncePerRequestFilter {

	@Autowired
	UserService userService;
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
		String requestHeader = request.getHeader("Authorization");
		if (requestHeader == null || "".equals(requestHeader)) {
			chain.doFilter(request, response);
			return;
		}
		if (!requestHeader.startsWith("Bearer ")) {
			writeResponse(response, "令牌格式不正确");
			return;
		}

		String authToken = requestHeader.substring(7);
		String username = JwtTokenUtils.getUsernameFromToken(authToken);
		if (username == null) {
			writeResponse(response, "令牌不正确");
			return;
		}
		if (SecurityContextHolder.getContext().getAuthentication() == null) {
			//可以改成从token中获取用户角色和权限信息,不用去数据库中查询,但角色和权限信息不能及时更新
			//在每次登录时重新查询,放入token中可以解决
			//UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			//token在http中有被盗用的风险,放在请求头中降低一点风险(待完成)
			if (JwtTokenUtils.isTokenExpired(authToken)) {
				writeResponse(response, "令牌已过期");
				return;
			} else {
				List<SimpleGrantedAuthority> authorities = JwtTokenUtils.getAuthoritiesFromToken(authToken);
				System.out.println("用户角色和权限:" + authorities);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		chain.doFilter(request, response);
	}

	public void writeResponse(HttpServletResponse response, String message) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		PrintWriter out = response.getWriter();
		Result result = new Result(false, StatusCode.ERROR, message);
		out.write(objectMapper.writeValueAsString(result));
		out.flush();
		out.close();
	}

}
