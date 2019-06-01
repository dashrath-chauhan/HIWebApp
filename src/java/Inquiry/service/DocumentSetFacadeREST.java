/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inquiry.service;

import Followup.FollowUp;
import Followup.service.FollowUpFacadeREST;
import Inquiry.DocumentSet;
import Inquiry.Inquiry;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import usermodel.Users;

/**
 *
 * @author dashrath chauhan
 */
@Stateless
@Path("inquiry.documentset")
public class DocumentSetFacadeREST extends AbstractFacade<DocumentSet> {

    @PersistenceContext(unitName = "HIRestAppPU")
    private EntityManager em;
//    private EntityManager em = Persistence.createEntityManagerFactory("HIRestAppPU").createEntityManager();

    public DocumentSetFacadeREST() {
        super(DocumentSet.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(DocumentSet entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, DocumentSet entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public DocumentSet find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DocumentSet> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DocumentSet> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
    //update inquiry
    @POST
    @Path("prepareDocumentSet")
    @Produces("text/plain")
    @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
    public String prepareDocumentSet(@FormParam("inquiryId") String inquiryId, @FormParam("documents") String documents) {
        String output = "";
        String[] docs = documents.split(",");
        System.out.println(documents);
//        System.out.println(docs);
//        System.out.println(docs.getClass().toString());
        List<DocumentSet> dss = new ArrayList<DocumentSet>();
        dss = findBy("findByInquiryId",inquiryId);
        
        if(dss.size() > 0){
            output = "Document set already exist for "+inquiryId+", Cannot create another document set";
        } else {
                try {
                for(int i=0; i<docs.length; i++){
                    DocumentSet ds = new DocumentSet();
                    ds.setInquiryId(inquiryId);
                    ds.setDocumentName(docs[i]);
                    ds.setStatus(0);
                    create(ds);
                }
                output = "Document set prepared for Inquiry Id: " +inquiryId;
            } catch (Exception e) {
                output = "Failed to prepare set.";
            }
        }
        
        return output;
    }
    
    @GET
    @Path("getDocumentsListById/{inquiryId}")
    @Produces({"application/xml", "application/json"})
    public List<DocumentSet> getDocumentsListById(@PathParam("inquiryId") String inquiryId) {
        List<DocumentSet> ds = findBy("findByInquiryId",inquiryId);
        return ds;
    }
    
    @GET
    @Path("findByInquiryIdAndStatus/{inquiryId}")
    @Produces({"application/xml", "application/json"})
    public List<DocumentSet> findByInquiryIdAndStatus(@PathParam("inquiryId") String inquiryId) {
        List<DocumentSet> ds = findBy("findByInquiryIdAndStatus",inquiryId);
        return ds;
    }
    
    @GET
    @Path("findByInquiryIdAndStatusActive/{inquiryId}")
    @Produces({"application/xml", "application/json"})
    public List<DocumentSet> findByInquiryIdAndStatusActive(@PathParam("inquiryId") String inquiryId) {
        List<DocumentSet> ds = findBy("findByInquiryIdAndStatusActive",inquiryId);
        return ds;
    }
    
    @GET
    @Path("by/{namedQuery}/{attrValue}")
    @Produces({"application/xml", "application/json"})
    public List<DocumentSet> findBy(@PathParam("namedQuery") String query, @PathParam("attrValue") String values) {
        String[] valueString = values.split(",");
        List<Object> valueList = new ArrayList<>();
        switch (query) {
            case "findByInquiryId":
                valueList.add(valueString[0]);
                break;
            case "findByInquiryIdAndStatus":
                valueList.add(valueString[0]);
                break;
                
            case "findByInquiryIdAndStatusActive":
                valueList.add(valueString[0]);
                break;
                
            case "findByInquiryIdAndDocumentName":
                valueList.add(valueString[0]);
                valueList.add(valueString[1]);
                break;
        }
        System.out.println("query"+query);
        return super.findBy("DocumentSet." + query, valueList);
    }
    
    public void editSet(String inquiryId, String documentName) {
        DocumentSet ds = new DocumentSet();
        ds = findBy("findByInquiryIdAndDocumentName",inquiryId+","+documentName).get(0);
        ds.setStatus(1);
        edit(ds);
    }
}
