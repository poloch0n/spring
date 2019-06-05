package com.training.springcore;

import com.training.springcore.bigcorp.ObjectFactory;
import com.training.springcore.service.SiteService;
import com.training.springcore.service.SiteServiceImpl;

public class BigCorpApplication {

    public static void main (String[] args){
        BigCorpApplication application = new BigCorpApplication();
        application.run();
    }

    public void run(){
        System.out.println("Application startup");
        ObjectFactory objectFactory = new ObjectFactory();

        System.out.println(objectFactory.createSiteService().findById("siteA"));
    }
}
