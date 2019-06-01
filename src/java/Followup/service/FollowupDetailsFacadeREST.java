/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Followup.service;

import Followup.FollowUp;
import Followup.FollowupDetails;
import Followup.FollowupDetailsPK;
import Inquiry.service.InquiryDetailsFacadeREST;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author dashrath chauhan
 */
@Stateless
@Path("followup.followupdetails")
public class FollowupDetailsFacadeREST extends AbstractFacade<FollowupDetails> {

    @PersistenceContext(unitName = "HIRestAppPU")
    private EntityManager em;
//    private EntityManager em = Persistence.createEntityManagerFactory("HIRestAppPU").createEntityManager();
    @EJB
    private FollowUpFacadeREST followUpFacadeREST;
    private FollowupDetailsPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;inquiryId=inquiryIdValue;counter=counterValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        Followup.FollowupDetailsPK key = new Followup.FollowupDetailsPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> inquiryId = map.get("inquiryId");
        if (inquiryId != null && !inquiryId.isEmpty()) {
            key.setInquiryId(inquiryId.get(0));
        }
        java.util.List<String> counter = map.get("counter");
        if (counter != null && !counter.isEmpty()) {
            key.setCounter(new java.lang.Integer(counter.get(0)));
        }
        return key;
    }

    public FollowupDetailsFacadeREST() {
        super(FollowupDetails.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(FollowupDetails entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, FollowupDetails entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        Followup.FollowupDetailsPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public FollowupDetails find(@PathParam("id") PathSegment id) {
        Followup.FollowupDetailsPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FollowupDetails> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FollowupDetails> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @POST
    @Path("detailedFollowUp")
    @Produces("text/plain")
    @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
    public String detailedFollowUp(@FormParam("id") String id,
            @FormParam("email") String email,
            @FormParam("nextDate") Date nextDate,
            @FormParam("description") String description) {
        String output = "";
        System.out.println("1");
        List<FollowupDetails> fpd = findBy("findByInquiryId", id);
        int counter = counter = fpd.size() + 1;
        FollowupDetails fpDetails = new FollowupDetails();
        System.out.println("1");
        FollowupDetailsPK fpDetailsPK = new FollowupDetailsPK();
        Date lastDate = new Date();
        try {
            System.out.println("1"+id);
            fpDetailsPK.setInquiryId(id);
            System.out.println("1"+counter);
            fpDetailsPK.setCounter(counter);
            System.out.println("1"+fpDetailsPK);
            fpDetails.setFollowupDetailsPK(fpDetailsPK);
            System.out.println("1"+description);
            fpDetails.setDescription(description);
            System.out.println("1"+email);
            fpDetails.setEmail(email);
            System.out.println("1"+lastDate);
            fpDetails.setLastFollowupDate(lastDate);
            System.out.println("1"+nextDate);
            fpDetails.setNextFollowupDate(nextDate);
            create(fpDetails);
            output = "Followup for Inquiry/Application: "+fpDetails.getFollowupDetailsPK().getInquiryId() + " updated...";
        } catch(Exception e){
            output = e.getLocalizedMessage().toString();
        }
        return output;
    }
    
    @GET
    @Path("by/{namedQuery}/{attrValue}")
    @Produces({"application/xml", "application/json"})
    public List<FollowupDetails> findBy(@PathParam("namedQuery") String query, @PathParam("attrValue") String values) {
        String[] valueString = values.split(",");
        List<Object> valueList = new ArrayList<>();
        switch (query) {
            case "findByInquiryId":
                valueList.add(valueString[0]);
                break;
        }
        System.out.println("2: " + valueList);
        System.out.println("3: " + query);
        return super.findBy("FollowupDetails." + query, valueList);
    }
    
    @GET
    @Path("getAllInquiriesById/{id}")
    @Produces({"application/xml", "application/json"})
    public List<FollowupDetails> getAllInquiriesById(@PathParam("id") String id) {
        List<FollowupDetails> fpDetails = findBy("findByInquiryId", id);
        return fpDetails;
    }
    
    public void removeByInquiryId(FollowupDetails followupDetails) {
        super.remove(followupDetails);
    }
}
