package com.training.springcore.service;

import com.training.springcore.model.Site;
import com.training.springcore.service.measure.SimulatedMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import static com.training.springcore.model.PowerSource.REAL;
import static com.training.springcore.model.PowerSource.SIMULATED;

@Service
@Lazy
public class SiteServiceImpl implements SiteService {

    private CaptorService captorService;

    public SiteServiceImpl(){

    }

    @Autowired
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
