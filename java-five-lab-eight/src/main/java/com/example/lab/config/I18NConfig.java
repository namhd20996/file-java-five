package com.example.lab.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

@Configuration
public class I18NConfig implements WebMvcConfigurer {

    //Bean messageSource sẽ thực hiện khai báo các file properties
    //trong ví dụ này khai báo các file properties nằm ở folder i18n, và thư mục chứa các file properties
    @Bean("messageSource")
    public MessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource ms
                = new ReloadableResourceBundleMessageSource();
        // đường dẫn 2 thư mục để lấy file Language
        ms.setBasenames("classpath:i18n/layout/layout", "classpath:i18n/home/home");
        ms.setDefaultEncoding("UTF-8");
        return ms;
}

    //Method addInterceptors sẽ xác định thay đổi ngôn ngữ hiển thị thông qua param name nào trên trình duyệt.
    // Ví dụ trên URL có param: ?lang=en thì tiếng anh sẽ được hiển thị
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor locale = new LocaleChangeInterceptor();
        locale.setParamName("lang");
        registry.addInterceptor(locale).addPathPatterns("/**");
    }

    //Bean localeResolver sẽ xác định ngôn ngữ hiển thị trên view bằng cách nào, ví dụ thông qua session, qua cookies
    @Bean("localeResolver")
    public LocaleResolver getLocaleResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(new Locale("vi"));
        resolver.setCookieMaxAge(10 * 24 * 60 * 60); // 10 ngày
        resolver.setCookiePath("/");
        return resolver;
    }

}
