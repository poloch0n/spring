package com.training.springcore.config;

import com.training.springcore.model.ApplicationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.util.Set;

@Configuration
@Profile("!prod")
@PropertySource("classpath:application.properties")
public class BigCorpApplicationDevConfig {

    @Autowired
    private Environment environment;

    private  String name;
    private Integer version ;
    private Set<String> emails ;
    private String webSiteUrl ;

    @Bean
    public ApplicationInfo applicationInfo(Environment environment)  {
        System.out.println(environment);
        System.out.println("DEV");
        name = environment.getProperty("bigcorp.name");
        version = environment.getProperty("bigcorp.version", Integer.class);
        emails = (Set<String>) environment.getProperty("bigcorp.emails", Set.class);
        webSiteUrl = environment.getProperty("bigcorp.webSiteUrl");
        System.out.println(name + " - " + version);
        return new ApplicationInfo(name, version, emails, webSiteUrl);
    }
}
