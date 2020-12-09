package com.project.restaurant.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RestaurantConfig   {

//    public RedisSerializer<Object> redisSerializer(){
//        return new GenericJackson2JsonRedisSerializer();
//    }

    // register a Interceptor for backend
    @Configuration
    public class MallWebConfig implements WebMvcConfigurer {

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new RestaurantInterceptor()).addPathPatterns("/**").excludePathPatterns("/login","/signUp","/" );
        }
    }




}
