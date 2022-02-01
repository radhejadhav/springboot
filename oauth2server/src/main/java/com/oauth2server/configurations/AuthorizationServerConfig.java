package com.oauth2server.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private UserApprovalHandler userApprovalHandler;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient("myAuthServer")
                .secret(passwordEncoder.encode("auth123"))
                .scopes("read")
                .authorizedGrantTypes("password","refresh_token")
                .accessTokenValiditySeconds(54000)
                .refreshTokenValiditySeconds(72000)

                .and()
                .withClient("myAuthServer2")
                .secret(passwordEncoder.encode("auth1234"))
                .scopes("read")
                .authorities("READ_ONLY_CLIENT")
                .authorizedGrantTypes("authorization_code","refresh_token")
                .redirectUris("http://localhost:8080/home");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager)
                .userApprovalHandler(userApprovalHandler)
                .tokenStore(tokenStore);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

        security
                .tokenKeyAccess("permitAll")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }
//
//    @Bean
//    public TokenStore tokenStore(JdbcTemplate jdbcTemplate){
//        return new JdbcTokenStore(Objects.requireNonNull(jdbcTemplate.getDataSource()));
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    public DefaultTokenServices tokenServices(){
//        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
//        defaultTokenServices.setTokenStore(tokenStore(jdbcTemplate));
//        defaultTokenServices.setSupportRefreshToken(true);
//        return  defaultTokenServices;
//    }
}
