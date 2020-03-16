package yh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import yh.security.filter.AuthenticationTokenFilter;
import yh.security.service.SecurityUserDetailsService;

//安全配置类
@Configuration
@EnableWebSecurity    // 开启Spring Security
@EnableGlobalMethodSecurity(prePostEnabled = true)    // 开启权限注解，如：@PreAuthorize注解
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	SecurityUserDetailsService userDetailsServiceImpl;

	@Autowired
	AuthenticationTokenFilter authenticationTokenFilter;

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 设置自定义的userDetailsService以及密码编码器
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder());
	}

	//authorizeRequests所有security全注解配置实现的开端，表示开始说明需要的权限。authorizeRequests:授权,authenticated:认证
	//需要的权限分两部分，第一部分是拦截的路径，第二部分访问该路径需要的权限。
	//antMatchers表示拦截什么路径，permitAll任何权限都可以访问，直接放行所有。
	//anyRequest()任何的请求，authenticated认证后才能访问
	//.and().csrf().disable();固定写法，表示使csrf拦截失效。
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//禁用CSRF
		http.cors().and().csrf().disable()
				.authorizeRequests()
				// 登录和注册接口
				.antMatchers("/user/login", "/user/adminLogin", "/user/register").permitAll()
				//首页需要的数据
				.antMatchers(HttpMethod.GET, "/course/**", "/subject/**").permitAll()
				// swagger
				.antMatchers("/swagger-ui.html").permitAll()
				.antMatchers("/swagger-resources/**").permitAll()
				.antMatchers("/v2/api-docs").permitAll()
				.antMatchers("/webjars/springfox-swagger-ui/**").permitAll()
				// 其他所有请求需要身份认证
				.anyRequest().authenticated()
				.and()
				// 前后端分离是无状态的，不用session了，直接禁用。
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// token验证过滤器
		http.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
	}

}
