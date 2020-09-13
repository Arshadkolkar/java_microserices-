package com.sca.common.config;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

/**
 * 
 * @author subhash
 *
 */
@Configuration
@EnableWebMvc
public class SierraWebMvcConfigurerAdapter implements WebMvcConfigurer {

	public MappingJackson2HttpMessageConverter jacksonJsonMessageConverter() {
		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();

		ObjectMapper mapper = new ObjectMapper();

		// Registering Hibernate5Module to support lazy objects
		mapper.registerModule(new Hibernate5Module());

		// Set DateFormat
		// mapper.setDateFormat(dateFormat);
		// DISABLE WRITE_DATES_AS_TIMESTAMPS
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z"));
		messageConverter.setObjectMapper(mapper);
		return messageConverter;
	}

	/**
	 * 
	 * @return
	 */
	public MappingJackson2XmlHttpMessageConverter jacksonXmlMessageConverter() {
		MappingJackson2XmlHttpMessageConverter messageConverter = new MappingJackson2XmlHttpMessageConverter();

		XmlMapper mapper = new XmlMapper();

		// Registering Hibernate5Module to support lazy objects
		mapper.registerModule(new Hibernate5Module());

		// Set DateFormat
		// mapper.setDateFormat(dateFormat);
		// DISABLE WRITE_DATES_AS_TIMESTAMPS
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z"));
		messageConverter.setObjectMapper(mapper);
		return messageConverter;
	}

//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE")
//				.allowedHeaders("*");
//	}

	/**
	 * 
	 * @param converters
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

		// Here we add our custom-configured HttpMessageConverter
		// To support XML
		converters.add(jacksonXmlMessageConverter());

		// To support JSON
		converters.add(jacksonJsonMessageConverter());

		// To support Resources (File Download)
		converters.add(new ResourceHttpMessageConverter());
//		configureMessageConverters(converters);
	}

	/**
	 * 
	 * @param argumentResolvers
	 */
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {

		PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
		resolver.setOneIndexedParameters(true);
		resolver.setPageParameterName("page-id");
		resolver.setSizeParameterName("limit");
		resolver.setMaxPageSize(Integer.MAX_VALUE);
		argumentResolvers.add(resolver);
//		addArgumentResolvers(argumentResolvers);

	}
}
