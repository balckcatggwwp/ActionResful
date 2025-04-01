package tw.blackcat.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/mycss/**").addResourceLocations("/WEB-INF/resources/css/");
		//registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/resources/images/");
	}
   
}
