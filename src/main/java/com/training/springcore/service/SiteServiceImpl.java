package com.training.springcore.service;

import com.training.springcore.model.Site;

public class SiteServiceImpl implements SiteService {

    private CaptorService captorService = new CaptorServiceImpl();

    public SiteServiceImpl(CaptorService captoreService) {
        System.out.println("Init SiteServiceImpl :" + this);
        this.captorService = captoreService;
    }

    @Override
    public Site findById(String siteId) {
        System.out.println("Appel findById SiteService Impl :" + this);
        if (siteId == null) {
            return null;
        }

        Site site = new Site("Florange");
        site.setId(siteId);
        site.setCaptors(captorService.findBySite(siteId));
        return site;
    }
}
