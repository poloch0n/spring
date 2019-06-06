package com.training.springcore.service;

import com.training.springcore.model.Site;
import com.training.springcore.service.measure.SimulatedMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


@Service
@Lazy
public class SiteServiceImpl implements SiteService {

    private CaptorService captorService;
    private ResourceLoader resourceLoader;

    public SiteServiceImpl(){

    }

    @Autowired
    public SiteServiceImpl(CaptorService captoreService, ResourceLoader resourceLoader) {
        System.out.println("Init SiteServiceImpl :" + this);
        this.captorService = captoreService;
        this.resourceLoader = resourceLoader;
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

    @Override
    public void readFile(String path){
        Resource resource = this.resourceLoader.getResource(path);
        try (InputStream stream = resource.getInputStream()) {
            Scanner scanner = new Scanner(stream).useDelimiter("\\n");
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
