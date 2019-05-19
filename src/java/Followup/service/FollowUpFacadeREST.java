/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Followup.service;

import Followup.FollowUp;
import Inquiry.Inquiry;
import Inquiry.service.InquiryDetailsFacadeREST;
import Inquiry.service.InquiryFacadeREST;
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
import Followup.FollowupDetails;
import Followup.FollowupDetailsPK;
import Inquiry.InquiryDetails;
import java.io.File;

/**
 *
 * @author dashrath chauhan
 */
@Stateless
@Path("followup.followup")
public class FollowUpFacadeREST extends AbstractFacade<FollowUp> {

    
    @EJB
    private FollowupDetailsFacadeREST followupDetailsFacadeREST;
    
    @EJB
    private FollowUpFacadeREST followUpFacadeREST;
    
    @EJB
    private InquiryFacadeREST inquiryFacadeREST;
    
    @EJB
    private InquiryDetailsFacadeREST inquiryDetailsFacadeREST;
    
    @PersistenceContext(unitName = "HIRestAppPU")
    private EntityManager em;
    //private EntityManager em = Persistence.createEntityManagerFactory("HIRestAppPU").createEntityManager();

    public FollowUpFacadeREST() {
        super(FollowUp.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(FollowUp entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, FollowUp entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public FollowUp find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FollowUp> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FollowUp> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    public void updateFollowUp(String id, String email) {
        FollowUp fp = find(id);
        System.out.println("OUT" + id + ":" + email);
        try {
            fp = find(id);
            fp.setEmail(email);
            edit(fp);
        } catch (NumberFormatException e) {
        }
    }

    @GET
    @Path("by/{namedQuery}/{attrValue}")
    @Produces({"application/xml", "application/json"})
    public List<FollowUp> findBy(@PathParam("namedQuery") String query, @PathParam("attrValue") String values) {
        String[] valueString = values.split(",");
        List<Object> valueList = new ArrayList<>();
        switch (query) {
            case "findByInquiryId":
                valueList.add(valueString[0]);
                break;
            case "findByLeadType":
                System.out.println("1: " + valueString[0]);
                valueList.add(valueString[0]);
                break;
            case "findByEmail":
                valueList.add(valueString[0]);
                break;
            case "findByNextFollowupDate":
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    valueList.add(dateFormat.parse(valueString[0]));
                } catch (ParseException ex) {
                    Logger.getLogger(FollowUpFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

        }
        System.out.println("2: " + valueList);
        System.out.println("3: " + query);
        return super.findBy("FollowUp." + query, valueList);
    }

    @POST
    @Path("createFollowUp")
    @Produces("text/plain")
    @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
    public String createFollowUp(@FormParam("id") String id,
            @FormParam("email") String email, @FormParam("type") String type,
            @FormParam("status") String status, @FormParam("strength") String strength,
            @FormParam("description") String description, @FormParam("nextDate") String nextDate) {
        String output = "";
        FollowUp fp = findBy("findByInquiryId", id).get(0);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date GMATDate = null;

        fp.setEmail(email);
        fp.setStatus(status);
        fp.setStrength(strength);
        fp.setType(type);
        fp.setDescription(description);
        if (fp.getConvertedBy() != null) {
            fp.setLeadType("A");
        } else {
            fp.setLeadType("I");
        }
        try {
            GMATDate = (Date) formatter.parse(nextDate);
            fp.setLastFollowupDate(new java.util.Date());
            fp.setNextFollowupDate(GMATDate);
        } catch (ParseException ex) {
            Logger.getLogger(InquiryDetailsFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        edit(fp);
        output = followupDetailsFacadeREST.detailedFollowUp(fp.getInquiryId(),fp.getEmail(),fp.getLastFollowupDate(),fp.getNextFollowupDate(),fp.getDescription());
        output = fp.getInquiryId() + " updated...";
        return output;
    }

    @GET
    @Path("getAllApplications")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FollowUp> getAllApplications() {
        List<FollowUp> applicatins = findBy("findByLeadType", "A");
        System.out.println(applicatins.get(0).getFirstName());
        return applicatins;
    }

    @GET
    @Path("getAllInquries")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FollowUp> getAllInquries() {
        List<FollowUp> inquries = findBy("findByLeadType", "I");
        System.out.println(inquries.get(0).getFirstName());
        return inquries;
    }
    
    @GET
    @Path("getAllHoldInquries")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FollowUp> getAllHoldInquries() {
        List<FollowUp> inquries = findBy("findByLeadType", "H");
        System.out.println(inquries.get(0).getFirstName());
        return inquries;
    }
    
    @PUT
    @Path("deleteInquiry")
    @Produces("text/plain")
    @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
    public String deleteInquiry(@FormParam("inquiryId") String inquiryId){
        String output = "";
        
        Inquiry iq = inquiryFacadeREST.findBy("findById",inquiryId).get(0);
        InquiryDetails iqD = inquiryDetailsFacadeREST.findBy("findByInquiryId", inquiryId).get(0);
        FollowupDetails fpD = followupDetailsFacadeREST.findBy("findByInquiryId", inquiryId).get(0);
        FollowUp fp = followUpFacadeREST.findBy("findByInquiryId", inquiryId).get(0);
        
        try {
            if(iq!= null && iqD != null && fp != null && fpD != null){
                inquiryFacadeREST.removeByInquiryId(iq.getId());
                inquiryDetailsFacadeREST.removeByInquiryId(iqD.getInquiryId());
                followUpFacadeREST.removeByInquiryId(fp.getInquiryId());
                followupDetailsFacadeREST.removeByInquiryId(fpD.getFollowupDetailsPK().getInquiryId());
                output += inquiryId+" deleted...";
            } else {
                output += inquiryId+" cannot delete...";
            }
            
            
        } catch (Exception e) {
            output += "Something went wrong";
        }
        return output;
    }
    
    public void removeByInquiryId(String inquiryId) {
        List<Object> valueList = new ArrayList<>();
        valueList.add(inquiryId);
        super.removeBy("FollowUp.removeByInquiryId", inquiryId);
    }
            
}
