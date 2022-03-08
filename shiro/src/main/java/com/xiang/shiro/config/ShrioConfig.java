package com.xiang.shiro.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author longxiang
 * @Description
 * @create 2022/3/6 19:07
 */
@Configuration
public class ShrioConfig {

    @Bean
//    ShiroFilterFactoryBean  subject  步骤3
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("manager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        factoryBean.setSecurityManager(defaultWebSecurityManager);
        return factoryBean;
    }

    @Bean(name = "manager")
//    DefaultWebSecurityManager  步骤2
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean
//  创建realm对象  需要自定义   步骤1
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
