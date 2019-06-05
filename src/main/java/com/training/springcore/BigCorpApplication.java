package com.training.springcore;

import com.training.springcore.service.SiteService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BigCorpApplication {

    public static void main (String[] args){
        BigCorpApplication application = new BigCorpApplication();
        application.run();
    }

    public void run(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        System.out.println("Application startup");
        // SiteService siteService = context.getBean(SiteService.class);
        SiteService siteService = (SiteService) context.getBean("siteService");
        System.out.println(siteService.findById("siteA"));
        SiteService siteService2 = (SiteService) context.getBean("siteService");
        System.out.println(siteService2.findById("siteB"));
    }
}
