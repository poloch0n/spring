package com.training.springcore.service;

import com.training.springcore.model.Site;

public class SiteServiceImpl implements SiteService {

    private CaptorService captorService;

    public SiteServiceImpl(CaptorService captoreService) {
        this.captorService =  captoreService;
    }

    public CaptorService getCaptorService() {
        return captorService;
    }

    public void setCaptorService(CaptorService captorService) {
        this.captorService = captorService;
    }

    @Override
    public Site findById(String siteId) {
        if (siteId == null) {
            return null;
        }

        Site site = new Site("Florange");
        site.setId(siteId);
        site.setCaptors(captorService.findBySite(siteId));
        return site;
    }
}
