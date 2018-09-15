package ins.platform.aggpay.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import ins.platform.aggpay.auth.component.mobile.MobileSecurityConfigurer;
import ins.platform.aggpay.common.bean.config.FilterIgnorePropertiesConfig;

/**
 * @author lengleng
 * @date 2018/3/10
 */
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER - 1)
@Configuration
@EnableWebSecurity
public class SecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    @Autowired
    private FilterIgnorePropertiesConfig filterIgnorePropertiesConfig;
    @Autowired
    private MobileSecurityConfigurer mobileSecurityConfigurer;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry =
                http.formLogin().loginPage("/authentication/require")
                        .loginProcessingUrl("/authentication/form")
                        .and()
                        .authorizeRequests();
        System.out.println( filterIgnorePropertiesConfig.getUrls());

        filterIgnorePropertiesConfig.getUrls().forEach(url -> registry.antMatchers(url).permitAll());
        registry.anyRequest().authenticated()
                .and()
                .csrf().disable();
        http.apply(mobileSecurityConfigurer);
    }
}
