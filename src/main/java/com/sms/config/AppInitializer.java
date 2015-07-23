package com.sms.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
/**
 * This class is responsible for 
 * web application initialization related configuration .
 * @author Dilaj
 *
 */
public class AppInitializer implements WebApplicationInitializer {
	
	private static final String DISPATCHER = "dispatcher";
	private static final String URL_SLASH = "/";
	
	/**
	 * configures the servlet mapping for the web application initialization. 
	 */
	@Override
	public void onStartup(ServletContext servletContext)throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfiguration.class);
		ctx.setServletContext(servletContext);
		Dynamic dynamic = servletContext.addServlet(DISPATCHER,new DispatcherServlet(ctx));
		dynamic.addMapping(URL_SLASH);
		dynamic.setLoadOnStartup(1);
	}
	
}
