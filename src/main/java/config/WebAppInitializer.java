package config;

import javax.servlet.Filter;

import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
@Order(2)
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {	
		return new Class[]{DataSourceConfig.class,JpaConfig.class,ServiceConfig.class};
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {	
		return new Class[]{WebMvcConfig.class};
	}
	@Override
	protected String[] getServletMappings() {	
		return new String[]{"/"};
	}
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] {characterEncodingFilter};
	}
}