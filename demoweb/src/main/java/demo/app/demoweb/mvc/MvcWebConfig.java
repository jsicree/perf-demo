package demo.app.demoweb.mvc;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.validation.Validator;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "demo.app.demoweb.mvc.controller" })
@PropertySource({ "classpath:demoweb_config.properties" })
public class MvcWebConfig extends WebMvcConfigurerAdapter {

	private static final String PROPERTY_NAME_CALCULATE_ACTIVE_VERSION = "caclulate.active.version";
	private static final String PROPERTY_NAME_MEMORY_ACTIVE_VERSION = "memory.active.version";

	@Resource
	private Environment environment;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
    }
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource src = new ReloadableResourceBundleMessageSource();
		src.setBasename("classpath:message");
		src.setDefaultEncoding("UTF-8");
		return src;		
	}

	@Bean
	public ContentNegotiationManagerFactoryBean contentNegotiationManager() {
		ContentNegotiationManagerFactoryBean bean = new ContentNegotiationManagerFactoryBean();
		bean.setFavorPathExtension(true);
		bean.setFavorParameter(false);
		bean.setParameterName("mediaType");
		bean.setIgnoreAcceptHeader(true);
		bean.setUseJaf(false);
		bean.setDefaultContentType(MediaType.APPLICATION_JSON);
		
		Properties p = new Properties();
		p.setProperty("json", MediaType.APPLICATION_JSON.toString());
		p.setProperty("xml", MediaType.APPLICATION_XML.toString());
		bean.setMediaTypes(p);
		
		return bean;
	}

	@Bean
	public String calculateActiveVersion() {
		return environment.getProperty(PROPERTY_NAME_CALCULATE_ACTIVE_VERSION);		
	}

	@Bean
	public String memoryActiveVersion() {
		return environment.getProperty(PROPERTY_NAME_MEMORY_ACTIVE_VERSION);		
	}
	
}