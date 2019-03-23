/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inquiry.service;

import java.util.Set;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

/**
 *
 * @author dashrath chauhan
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        resources.add(MultiPartFeature.class);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Followup.service.FollowUpFacadeREST.class);
        resources.add(Followup.service.FollowupDetailsFacadeREST.class);
        resources.add(Inquiry.service.DocumentSetFacadeREST.class);
        resources.add(Inquiry.service.DocumentsFacadeREST.class);
        resources.add(Inquiry.service.InquiryDetailsFacadeREST.class);
        resources.add(Inquiry.service.InquiryFacadeREST.class);
        resources.add(usermodel.service.UsersFacadeREST.class);
    }
    
}
