package com.sms.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
/**
 * This class configure the web application.
 * spring internalviewresolver is used to resolve index.html
 * view. Jsonview resolver is used for REST API.
 * 
 * @author Dilaj
 *
 */
@Configuration
@ComponentScan("com.sms")
@EnableWebMvc
public class AppConfiguration extends WebMvcConfigurerAdapter {
    
	/**
	 * view and controller for url / mapping. 
	 */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }
    
    /**
     * to resolve index.html
     * @return
     */
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
    	InternalResourceViewResolver res = new InternalResourceViewResolver();
         res.setPrefix("/views/");
         res.setSuffix(".html");
         return res;
    }

    /**
     * enables default servelet handler
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
	/**
	 * Configure ContentNegotiatingViewResolver
	 * 	internal view resolver for .html
	 * 	json view resolver for rest api
	 * @param manager
	 * @return
	 */
    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
        resolvers.add(jsonViewResolver());
        resolvers.add(internalResourceViewResolver());
        resolver.setViewResolvers(resolvers);
        return resolver;
    }
    
    
    
    /**
   * Configure View resolver to provide JSON output using JACKSON library to
   * convert object in JSON format.
   * @return JsonViewResolver
   */
    @Bean
    public ViewResolver jsonViewResolver() {
        return new JsonViewResolver();
    }
}
