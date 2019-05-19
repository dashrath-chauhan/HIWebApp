/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inquiry.service;

import Followup.service.FollowUpFacadeREST;
import Followup.FollowUp;
import Inquiry.InquiryDetails;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author dashrath chauhan
 */
@Stateless
@Path("inquiry.inquirydetails")
public class InquiryDetailsFacadeREST extends AbstractFacade<InquiryDetails> {

    @PersistenceContext(unitName = "HIRestAppPU")
    private EntityManager em;
//    private EntityManager em = Persistence.createEntityManagerFactory("HIRestAppPU").createEntityManager();

    @EJB
    private FollowUpFacadeREST followUpFacadeREST;
    
    public InquiryDetailsFacadeREST() {
        super(InquiryDetails.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(InquiryDetails entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, InquiryDetails entity) {
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
    public InquiryDetails find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<InquiryDetails> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<InquiryDetails> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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

    //create inquiry
    @PUT
    @Path("addInquiryDetails")
    @Produces("text/plain")
    @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
    public String addInquiryDetails(@FormParam("id") String id,
            @FormParam("formType") String formType, @FormParam("assigned") String assigned,
            @FormParam("assignedTo") String assignedTo, @FormParam("add1") String add1,
            @FormParam("add2") String add2, @FormParam("cityTown") String cityTown,
            @FormParam("state") String state, @FormParam("pin") String pin,
            @FormParam("passport") String passport, @FormParam("passport1") String passport1,
            @FormParam("passport2") String passport2, @FormParam("per10") String per10,
            @FormParam("passYear10") String passYear10, @FormParam("per12") String per12,
            @FormParam("passYear12") String passYear12, @FormParam("stream12") String stream12,
            @FormParam("perDiploma") String perDiploma, @FormParam("passYearDiploma") String passYearDiploma,
            @FormParam("nameDiploma") String nameDiploma, @FormParam("awardingBodyDiploma") String awardingBodyDiploma,
            @FormParam("durationDiploma") String durationDiploma, @FormParam("perBachelor") String perBachelor,
            @FormParam("passYearBachelor") String passYearBachelor, @FormParam("degreeNameBachelor") String degreeNameBachelor,
            @FormParam("collegeBachelor") String collegeBachelor, @FormParam("durationBachelor") String durationBachelor,
            @FormParam("backlogsBachelor") String backlogsBachelor, @FormParam("perPG") String perPG,
            @FormParam("passYearPG") String passYearPG, @FormParam("namePG") String namePG,
            @FormParam("awardingBodyPG") String awardingBodyPG, @FormParam("durationPG") String durationPG,
            @FormParam("perMasters") String perMasters, @FormParam("passYearMasters") String passYearMasters,
            @FormParam("degreeNameMasters") String degreeNameMasters, @FormParam("collegeMasters") String collegeMasters,
            @FormParam("durationMasters") String durationMasters, @FormParam("backlogsMasters") String backlogsMasters,
            @FormParam("scoreTOEFL") String scoreTOEFL, @FormParam("mockTOEFL") String mockTOEFL,
            @FormParam("dateTOEFL") String dateTOEFL, @FormParam("scoreIELTS") String scoreIELTS,
            @FormParam("mockIELTS") String mockIELTS, @FormParam("dateIELTS") String dateIELTS,
            @FormParam("scoreGRE") String scoreGRE, @FormParam("mockGRE") String mockGRE,
            @FormParam("dateGRE") String dateGRE, @FormParam("scoreGMAT") String scoreGMAT,
            @FormParam("specialNote") String specialNote, @FormParam("mockGMAT") String mockGMAT,
            @FormParam("dateGMAT") String dateGMAT, @FormParam("scoreSAT") String scoreSAT,
            @FormParam("mockSAT") String mockSAT, @FormParam("dateSAT") String dateSAT) {
        String output = "";
        InquiryDetails inquiryDetails = new InquiryDetails();
        try {
            System.out.println("a");
            inquiryDetails = find(id);
        } catch (NumberFormatException e) {
            output += e.getMessage();
        }
        
        System.out.println("b");
        inquiryDetails.setAdd1(add1);
        inquiryDetails.setAdd2(add2);
        inquiryDetails.setFormType(formType);
        inquiryDetails.setAssigned(assigned);
        inquiryDetails.setAssignedTo(assignedTo);
        
        System.out.println("c");
        //general
        inquiryDetails.setCity(cityTown);
        inquiryDetails.setState(state);
        inquiryDetails.setPincode(pin);
        inquiryDetails.setPassportNo(passport);
        inquiryDetails.setAddPassport1(passport1);
        inquiryDetails.setAddPassport2(passport2);
        System.out.println("d");
        //academic
        System.out.println("A0");
        inquiryDetails.setPer10(per10);
        System.out.println("A1");
        inquiryDetails.setPassyear10(passYear10);
        System.out.println("B1");
        inquiryDetails.setPer12(per12);
        System.out.println("C1");
        inquiryDetails.setPassyear12(passYear12);
        System.out.println("D1");
        inquiryDetails.setStream12(stream12);
        System.out.println("e1");
        inquiryDetails.setPerDip(perDiploma);
        System.out.println("F1");
        inquiryDetails.setPassyearDip(passYearDiploma);
        System.out.println("G1");
        inquiryDetails.setAwardDip(awardingBodyDiploma);
        System.out.println("H1");
        inquiryDetails.setNameDip(nameDiploma);
        System.out.println("I1");
        inquiryDetails.setDurationDip(durationDiploma);
        System.out.println("J1");
        inquiryDetails.setPerBach(perBachelor);
        System.out.println("J1");
        inquiryDetails.setPassyearBach(passYearBachelor);
        System.out.println("J1");
        inquiryDetails.setClgBach(collegeBachelor);
        System.out.println("J1");
        inquiryDetails.setNameBach(degreeNameBachelor);
        System.out.println("J1");
        inquiryDetails.setDurationBach(durationBachelor);
        System.out.println("J1");
        inquiryDetails.setBacklogsBach(backlogsBachelor);
        System.out.println("J1");
        inquiryDetails.setPerPgDip(perPG);
        System.out.println("J1");
        inquiryDetails.setPassyearPgDip(passYearPG);
        System.out.println("J1");
        inquiryDetails.setAwardPgDip(awardingBodyPG);
        System.out.println("J1");
        inquiryDetails.setNamePgDip(namePG);
        System.out.println("J1");
        inquiryDetails.setDurationPgDip(durationPG);
        System.out.println("J1");
        inquiryDetails.setPerMasters(perMasters);
        System.out.println("J1");
        inquiryDetails.setPassyearMasters(passYearMasters);
        System.out.println("J1");
        inquiryDetails.setClgMasters(collegeMasters);
        System.out.println("J1");
        inquiryDetails.setNameMasters(degreeNameMasters);
        System.out.println("J1");
        inquiryDetails.setDurationMasters(durationMasters);
        System.out.println("J1");
        inquiryDetails.setBacklogsMasters(backlogsMasters);
        System.out.println("e");
        //test
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        inquiryDetails.setIeltsScore(scoreIELTS);
        System.out.println("1");
        inquiryDetails.setIeltsMockScore(mockIELTS);
        System.out.println("2");
        Date IELTSDate = null;
        try {
            IELTSDate = (Date) formatter.parse(dateIELTS);
            inquiryDetails.setIeltsDate(new java.sql.Date(IELTSDate.getTime()));
        } catch (ParseException ex) {
            Logger.getLogger(InquiryDetailsFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        System.out.println("3");
        Date TOEFLDate = null;
        try {
            TOEFLDate = (Date) formatter.parse(dateTOEFL);
            inquiryDetails.setToeflDate(new java.sql.Date(TOEFLDate.getTime()));
        } catch (ParseException ex) {
            Logger.getLogger(InquiryDetailsFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        System.out.println("4");
        inquiryDetails.setToeflMockScore(mockTOEFL);
        System.out.println("5");
        inquiryDetails.setToeflScore(scoreTOEFL);
        System.out.println("6");
        inquiryDetails.setGreMockScore(mockGRE);
        System.out.println("7");
        Date GREDate = null;
        try {
            GREDate = (Date) formatter.parse(dateGRE);
            inquiryDetails.setGreDate(new java.sql.Date(GREDate.getTime()));
        } catch (ParseException ex) {
            Logger.getLogger(InquiryDetailsFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        System.out.println("8");
        inquiryDetails.setGreScore(scoreGRE);
        System.out.println("9");
        inquiryDetails.setSatMockScore(mockSAT);
        System.out.println("10");
        Date SATDate = null;
        try {
            SATDate = (Date) formatter.parse(dateSAT);
            inquiryDetails.setSatDate(new java.sql.Date(SATDate.getTime()));
        } catch (ParseException ex) {
            Logger.getLogger(InquiryDetailsFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        System.out.println("11");
        inquiryDetails.setSatScore(scoreSAT);
        System.out.println("12");
        inquiryDetails.setGmatScore(scoreGMAT);
        System.out.println("13");
        inquiryDetails.setGmatMockScore(mockGMAT);
        System.out.println("14");
        Date GMATDate = null;
        try {
            GMATDate = (Date) formatter.parse(dateGMAT);
            inquiryDetails.setGmatDate(new java.sql.Date(GMATDate.getTime()));
        } catch (ParseException ex) {
            Logger.getLogger(InquiryDetailsFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        System.out.println("15");
        System.out.println("f");
        inquiryDetails.setNote(specialNote);
        System.out.println("g");
        edit(inquiryDetails);
        System.out.println("IN:"+id+":"+assignedTo);
        followUpFacadeREST.updateFollowUp(id, assignedTo);
        System.out.println("h");
        output += "Inqury: " + inquiryDetails.getInquiryId() + " updated...";
        return output;
    }
    
    //get inquiry details by id
    @GET
    @Path("getInquiryById/{inquiryId}")
    @Produces({"application/xml", "application/json", "text/plain"})
    public Response getInquiryById(@PathParam("inquiryId") String inquiryId) {
        String output = "";
        Response.ResponseBuilder responseBuilder = Response.status(200);
        try {
            InquiryDetails inquiry = find(inquiryId);
            if(inquiry != null)
                responseBuilder.type(MediaType.APPLICATION_XML).entity(inquiry);
        } catch (Exception e) {
            output += "Invalid Id...";
            responseBuilder.type(MediaType.TEXT_PLAIN).entity(output);
        }
        return responseBuilder.build();
    }
    
    public void removeByInquiryId(String inquiryId) {
        List<Object> valueList = new ArrayList<>();
        valueList.add(inquiryId);
        super.removeBy("InquiryDetails.removeByInquiryId", inquiryId);
    }
    
    @GET
    @Path("by/{namedQuery}/{attrValue}")
    @Produces({"application/xml", "application/json"})
    public List<InquiryDetails> findBy(@PathParam("namedQuery") String query, @PathParam("attrValue") String values) {
        String[] valueString = values.split(",");
        List<Object> valueList = new ArrayList<>();
        switch (query) {
            case "findByInquiryId":
                valueList.add(valueString[0]);
                break;
        }
        System.out.println("2: " + valueList);
        System.out.println("3: " + query);
        return super.findBy("InquiryDetails." + query, valueList);
    }
}
