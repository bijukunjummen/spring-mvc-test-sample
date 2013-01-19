package mvcsample.spring;

import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.web.PageableArgumentResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletWebArgumentResolverAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesView;


@Configuration
@ComponentScan(basePackages="mvcsample.web", includeFilters=@Filter(type=FilterType.ANNOTATION, value=Controller.class))
public class WebConfig extends WebMvcConfigurationSupport{
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new ServletWebArgumentResolverAdapter(new PageableArgumentResolver()));
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		super.configureDefaultServletHandling(configurer);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource(){
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("WEB-INF/i18n/messages","WEB-INF/i18n/application");
		return messageSource;
	}
	
	@Bean
	public MultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}
	
	@Bean
	public CookieLocaleResolver localeResolver() {
		CookieLocaleResolver cookieLocaleResolver =  new CookieLocaleResolver();
		cookieLocaleResolver.setCookieName("locale");
		return cookieLocaleResolver;
	}
	
	@Bean
	public ViewResolver tilesViewResolver(){
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(TilesView.class);
		return viewResolver;
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer(){
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[]{"/WEB-INF/layouts/layouts.xml", "/WEB-INF/views/**/views.xml"});
		return tilesConfigurer;
	}
	
}
