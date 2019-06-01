/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inquiry.service;

import Followup.service.FollowUpFacadeREST;
import Followup.FollowUp;
import Followup.FollowupDetails;
import Followup.FollowupDetailsPK;
import Followup.service.FollowupDetailsFacadeREST;
import Inquiry.Inquiry;
import Inquiry.InquiryDetails;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
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
import javax.ws.rs.core.Response;
import usermodel.Users;
import usermodel.service.UsersFacadeREST;

/**
 *
 * @author dashrath chauhan
 */
@Stateless
@Path("inquiry.inquiry")
public class InquiryFacadeREST extends AbstractFacade<Inquiry> {

    @EJB
    private InquiryDetailsFacadeREST inquiryDetailsFacadeREST;

    @EJB
    private FollowupDetailsFacadeREST followUpDetailsFacadeREST;

    @EJB
    private FollowUpFacadeREST followUpFacadeREST;

    @EJB
    private UsersFacadeREST usersFacadeREST;

    @PersistenceContext(unitName = "HIRestAppPU")
    private EntityManager em;
    //private EntityManager em = Persistence.createEntityManagerFactory("HIRestAppPU").createEntityManager();

    public InquiryFacadeREST() {
        super(Inquiry.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Inquiry entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Inquiry entity) {
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
    public Inquiry find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Inquiry> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Inquiry> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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

    //retrieve all inquries
    @GET
    @Path("getAllInquiries")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Inquiry> getAllInquiries() {
        List<Inquiry> inquiries = findBy("findByIsInquiry", "Y");
        return inquiries;
    }

    //create inquiry
    @POST
    @Path("createInquiry")
    @Produces("text/plain")
    @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
    public String createInquiry(@FormParam("firstName") String firstName,
            @FormParam("lastName") String lastName, @FormParam("email") String email,
            @FormParam("mobileNo") String mobileNo, @FormParam("inquirySource") String inquirySource,
            @FormParam("countryPreference") String countryPreference, @FormParam("gender") String gender,
            @FormParam("createdBy") String createdBy) {
        String output = "";
        Inquiry inquiry = new Inquiry();
        InquiryDetails inquiryDetails = new InquiryDetails();
        Integer id = generateInquiryId();
        inquiryDetails.setInquiryId(Integer.toString(id));
        System.out.println("Id:" + id);
        inquiry.setId(Integer.toString(id));
        inquiry.setFirstName(firstName);
        inquiry.setLastName(lastName);
        inquiry.setGender(gender);
        inquiry.setMobile(mobileNo);
        inquiry.setEmailId(email);
        inquiry.setInquirySource(inquirySource);
        inquiry.setCountry(countryPreference);
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        inquiry.setDateTime(date);
        inquiry.setIsInquiry("Y");
        create(inquiry);
        System.out.println("inqD" + inquiryDetails + ":" + inquiryDetails.getInquiryId());
        inquiryDetailsFacadeREST.create(inquiryDetails);
        
        FollowUp followup = new FollowUp();
        FollowupDetails fpd = new FollowupDetails();
        FollowupDetailsPK fpdPK = new FollowupDetailsPK();
        followup.setInquiryId(Integer.toString(id));
        followup.setFirstName(firstName);
        followup.setEmail(email);
        followup.setLastName(lastName);
        followup.setLeadType("I");
        followup.setMobile(mobileNo);
        followup.setDescription("Inquiry Created...");
        followup.setLastFollowupDate(new java.util.Date());
        followup.setNextFollowupDate(new java.util.Date());
        followUpFacadeREST.create(followup);
        
        fpdPK.setInquiryId(Integer.toString(id));
        fpdPK.setCounter(1);
        fpd.setFollowupDetailsPK(fpdPK);
        fpd.setEmail(createdBy);
        fpd.setLastFollowupDate(new java.util.Date());
        fpd.setNextFollowupDate(new java.util.Date());
        fpd.setDescription("Inquiry Created...");
        followUpDetailsFacadeREST.create(fpd);
        
        output = "Inquiry Id: " + inquiry.getId() + ", created...";
        return output;
    }

    //update inquiry
    @PUT
    @Path("updateInquiry")
    @Produces("text/plain")
    @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
    public String updateInquiry(@FormParam("firstName") String firstName, @FormParam("id") String id,
            @FormParam("lastName") String lastName, @FormParam("email") String email,
            @FormParam("mobileNo") String mobileNo, @FormParam("inquirySource") String inquirySource,
            @FormParam("countryPreference") String countryPreference, @FormParam("gender") String gender) {
        String output = "";
        try {
            Inquiry inquiry = find(id);
            System.out.println("Id:" + inquiry);
            inquiry.setFirstName(firstName);
            inquiry.setLastName(lastName);
            inquiry.setGender(gender);
            inquiry.setMobile(mobileNo);
            inquiry.setEmailId(email);
            inquiry.setInquirySource(inquirySource);
            inquiry.setCountry(countryPreference);
            java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
            inquiry.setDateTime(date);
            edit(inquiry);
            output = "Inquiry Id: " + inquiry.getId() + ", updated...";
        } catch (Exception e) {
            output = "Failed to update. Invalid Id...";
        }
        return output;
    }

    //delete inquiry
    @DELETE
    @Path("deleteInquiry/{id}")
    @Produces("text/plain")
    public String deleteInquiry(@PathParam("id") String id) {
        String output = "";
        try {
            Inquiry inquiry = find(id);
            remove(inquiry);
            output = "Inquiry Id: " + inquiry.getId() + ", deleted...";
        } catch (Exception e) {
            output = "Invalid Id...";
        }
        return output;
    }

    //get inquiry details by id
    @GET
    @Path("getInquiryById/{id}")
    @Produces({"application/xml", "application/json", "text/plain"})
    public Response getInquiryById(@PathParam("id") String id) {
        String output = "";
        Response.ResponseBuilder responseBuilder = Response.status(200);
        try {
            Inquiry inquiry = find(id);
            if(inquiry != null)
                responseBuilder.type(MediaType.APPLICATION_XML).entity(inquiry);
        } catch (Exception e) {
            output += "Invalid Id...";
            responseBuilder.type(MediaType.TEXT_PLAIN).entity(output);
        }
        return responseBuilder.build();
    }

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    //update inquiry
    @PUT
    @Path("convertToApplication")
    @Produces("text/plain")
    @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
    public String convertToApplication(@FormParam("id") String id, @FormParam("email") String email) {
        String output = "";
        try {
            Inquiry inquiry = find(id);
            FollowUp fp = followUpFacadeREST.find(id);
            System.out.println("Id:" + fp);
            fp.setLeadType("A");
            Users user = usersFacadeREST.findBy("findByEmail", email).get(0);
            fp.setConvertedBy(user.getName());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            System.out.println(dateFormat.format(date));
            fp.setConvertedOn(date);
            fp.setEmail(inquiry.getEmailId());
            inquiry.setIsInquiry("N");
            followUpFacadeREST.edit(fp);
            edit(inquiry);
            output = "Inquiry Id: " + fp.getInquiryId() + ", is converted to Application...";
        } catch (Exception e) {
            output = "Failed to create Application";
        }
        return output;
    }

    //todays follow ups
    @GET
    @Path("todaysInquriesFollowUps/{date}")
    @Produces({"application/xml", "application/json"})
    @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
    public List<FollowUp> todaysInquriesFollowUps(@PathParam("date") String date) {

//        List<FollowUp> fp = followUpFacadeREST.findAll();
//        List<FollowUp> fps = new ArrayList<FollowUp>();
        List<Object> valueList = new ArrayList<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("param: " + date);
        try {
            valueList.add(dateFormat.parse(date));

        } catch (ParseException ex) {
            Logger.getLogger(InquiryFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<FollowUp> fps = followUpFacadeREST.findBy("findByNextFollowupDate", date);
        List<FollowUp> fpss = new ArrayList<FollowUp>();
        for (int i = 0; i < fps.size(); i++) {
            if (fps.get(i).getLeadType().contentEquals("I")) {
                fpss.add(fps.get(i));
                System.out.println(fps.get(i));
            }
        }
        return fpss;
    }
    
    //todays follow ups
    @GET
    @Path("todaysInquriesFollowUps")
    @Produces({"application/xml", "application/json"})
    @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
    public List<FollowUp> todaysInquriesFollowUps() {
        List<FollowUp> fps = followUpFacadeREST.findAll();
        List<FollowUp> fpss = new ArrayList<FollowUp>();
        for (int i = 0; i < fps.size(); i++) {
            if (fps.get(i).getLeadType().contentEquals("I")) {
                fpss.add(fps.get(i));
                System.out.println(fps.get(i));
            }
        }
        return fpss;
    }
    
    //todays follow ups
    @GET
    @Path("todaysApplicationsFollowUps")
    @Produces({"application/xml", "application/json"})
    @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
    public List<FollowUp> todaysApplicationsFollowUps() {
        List<FollowUp> fps = followUpFacadeREST.findAll();
        List<FollowUp> fpss = new ArrayList<FollowUp>();
        for (int i = 0; i < fps.size(); i++) {
            if (fps.get(i).getLeadType().contentEquals("A")) {
                fpss.add(fps.get(i));
                System.out.println(fps.get(i));
            }
        }
        return fpss;
    }

    //todays follow ups
    @GET
    @Path("todaysApplicationsFollowUps/{date}")
    @Produces({"application/xml", "application/json"})
    @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
    public List<FollowUp> todaysApplicationsFollowUps(@PathParam("date") String date) {

//        List<FollowUp> fp = followUpFacadeREST.findAll();
//        List<FollowUp> fps = new ArrayList<FollowUp>();
        List<Object> valueList = new ArrayList<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("param: " + date);
        try {
            valueList.add(dateFormat.parse(date));

        } catch (ParseException ex) {
            Logger.getLogger(InquiryFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<FollowUp> fps = followUpFacadeREST.findBy("findByNextFollowupDate", date);
        List<FollowUp> fpss = new ArrayList<FollowUp>();
        for (int i = 0; i < fps.size(); i++) {
            if (fps.get(i).getLeadType().contentEquals("A")) {
                fpss.add(fps.get(i));
            }
        }
        return fpss;
    }

    @GET
    @Path("by/{namedQuery}/{attrValue}")
    @Produces({"application/xml", "application/json"})
    public List<Inquiry> findBy(@PathParam("namedQuery") String query, @PathParam("attrValue") String values) {
        String[] valueString = values.split(",");
        List<Object> valueList = new ArrayList<>();
        switch (query) {
            case "findByName":
                valueList.add(valueString[0]);
                break;
            case "findByEmail":
                valueList.add(valueString[0]);
                break;
            case "findByIsInquiry":
                valueList.add(valueString[0]);
                break;
            case "findById":
                valueList.add(valueString[0]);
                break;
            case "findByDateBetween":
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                 {
                    try {
                        valueList.add(dateFormat.parse(valueString[0]));
                        valueList.add(dateFormat.parse(valueString[1]));
                    } catch (ParseException ex) {
                        Logger.getLogger(InquiryFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                break;
        }
        return super.findBy("Inquiry." + query, valueList);
    }

    public Integer generateInquiryId() {
        Integer id;
        List<Inquiry> inquiries = findAll();
        List<Integer> ids = new ArrayList<Integer>();
        if (inquiries.size() == 0) {
            id = 1;
        } else {
            for (int i = 0; i < inquiries.size(); i++) {
                ids.add(Integer.parseInt(inquiries.get(i).getId()));
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < ids.size(); i++) {
                if (ids.get(i) > max) {
                    max = ids.get(i);
                }
            }
            id = max + 1;
        }
        return id;
    }
    
    //update inquiry
    @PUT
    @Path("putOnHold")
    @Produces("text/plain")
    @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
    public String putOnHold(@FormParam("inquiryId") String id, @FormParam("email") String email) {
        String output = "";
        try {
            Inquiry inquiry = find(id);
            FollowUp fp = followUpFacadeREST.find(id);
            System.out.println("Id:" + fp);
            fp.setLeadType("H");
            Users user = usersFacadeREST.findBy("findByEmail", email).get(0);
            fp.setConvertedBy(user.getName());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            System.out.println(dateFormat.format(date));
            fp.setConvertedOn(date);
            fp.setEmail(inquiry.getEmailId());
            inquiry.setIsInquiry("IH");
            followUpFacadeREST.edit(fp);
            edit(inquiry);
            output = "Inquiry Id: " + fp.getInquiryId() + ", is on hold for some time...";
        } catch (Exception e) {
            output = "Failed to put On Hold";
        }
        return output;
    }
    
    //update inquiry
    @PUT
    @Path("reInitiate")
    @Produces("text/plain")
    @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
    public String reInitiate(@FormParam("inquiryId") String id, @FormParam("email") String email) {
        String output = "";
        try {
            Inquiry inquiry = find(id);
            FollowUp fp = followUpFacadeREST.find(id);
            System.out.println("Id:" + fp);
            fp.setLeadType("I");
            Users user = usersFacadeREST.findBy("findByEmail", email).get(0);
            fp.setConvertedBy(user.getName());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            System.out.println(dateFormat.format(date));
            fp.setConvertedOn(date);
            fp.setEmail(inquiry.getEmailId());
            inquiry.setIsInquiry("Y");
            followUpFacadeREST.edit(fp);
            edit(inquiry);
            output = "Inquiry Id: " + fp.getInquiryId() + ", is reinitiated as Inquiry...";
        } catch (Exception e) {
            output = "Failed to reinitiate....";
        }
        return output;
    }
    
    public void removeByInquiryId(Inquiry iq) {
        super.remove(iq);
    }
}
