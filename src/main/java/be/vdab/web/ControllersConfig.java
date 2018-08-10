package be.vdab.web;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan
@EnableWebMvc
public class ControllersConfig implements WebMvcConfigurer {
	@Bean
	InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/JSP/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("/images/");
		registry.addResourceHandler("/styles/**").addResourceLocations("/styles/");
		registry.addResourceHandler("/scripts/**").addResourceLocations("/scripts/");
	}
	
	@Bean
	MessageSource messageSource() {
		ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
		source.setBasename("classpath:teksten");
		source.setFallbackToSystemLocale(false);
		return source;
	}
	
	@Bean
	LocalValidatorFactoryBean validatorFactory() {
		LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
		factory.setValidationMessageSource(messageSource());
		return factory;
	}
	
	@Override
	public Validator getValidator() {
		return new SpringValidatorAdapter(validatorFactory().getValidator());
	}
	
}
