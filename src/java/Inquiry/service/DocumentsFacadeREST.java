package Inquiry.service;

import Inquiry.DocumentSet;
import Inquiry.Documents;
import Inquiry.DocumentsPK;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import static java.security.AccessController.getContext;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import static javax.ws.rs.client.Entity.form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.ContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.FormDataParam;
import usermodel.Users;

/**
 *
 * @author dashrath chauhan
 */
@Stateless
@Path("inquiry.documents")
public class DocumentsFacadeREST extends AbstractFacade<Documents> {

    @PersistenceContext(unitName = "HIRestAppPU")
    private EntityManager em;
    //private EntityManager em = Persistence.createEntityManagerFactory("HIRestAppPU").createEntityManager();

    public DocumentsFacadeREST() {
        super(Documents.class);
    }

    @EJB 
    private DocumentSetFacadeREST documentSetFacadeREST;
    
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Documents entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Documents entity) {
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
    public Documents find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Documents> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Documents> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
//    @POST
//    @Path("uploadFile")
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    @Produces(MediaType.TEXT_PLAIN)
//    public String uploadFile(@FormDataParam("file") InputStream uploadedInputStream,
//            @FormDataParam("file") FormDataContentDisposition fileDetails, @FormDataParam("id") String id){
//        
//        saveFile(uploadedInputStream,fileDetails,id);
//        return "File uploaded sccessfully.";
//    }
//    
//    private void saveFile(InputStream uploadedInputStream, FormDataContentDisposition fileDetails, String inquiryId){
//        String uploadFileLocation = "e://Documents/"+inquiryId+"_"+fileDetails.getFileName();
//        try{
//            OutputStream out = new FileOutputStream(new File(uploadFileLocation));
//            int read=0;
//            byte[] bytes = new byte[1024];
//            out = new FileOutputStream(new File(uploadFileLocation));
//            while((read = uploadedInputStream.read(bytes)) != -1){
//                out.write(bytes, 0, read);
//            }
//            out.flush();
//            out.close();
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//    }
    
    public void createDirectory(){
        String path = "e://Documents/";
        File directory = new File(path);
        if (! directory.exists()){
            directory.mkdir();
        }
    }
    
    @POST
    @Path("uploadFile")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String addNew(FormDataMultiPart form, @FormDataParam("inquiryId") String inquiryId,
            @FormDataParam("documentName") String documentName){
        createDirectory();
        FormDataBodyPart filePart = form.getField("file");
        ContentDisposition des = filePart.getContentDisposition();
        String fileName = des.getFileName();
        String output = "";
        String uploadFileLocation = null;
        InputStream input = filePart.getValueAs(InputStream.class);
        Documents documents = new Documents();
        DocumentsPK d = new DocumentsPK();
//        DocumentSet ds = new DocumentSet();
//        ds = documentSetFacadeREST.findBy("findByInquiryId",inquiryId).get(0);
        int len=0;
        int size=0;
       
        
        if(documentName.contentEquals("Passport size photograph")){
            String home = System.getProperty("user.home");
            uploadFileLocation = home+"\\Documents\\NetBeansProjects\\HIRestApp\\web\\images\\"+inquiryId+"_"+fileName;
        } else {
            uploadFileLocation = "e://Documents/"+inquiryId+"_"+fileName;
        }
        System.out.println(uploadFileLocation);
        try(OutputStream out = new FileOutputStream(new File(uploadFileLocation))){
            byte[] buffer = new byte[1024];
            while((len = input.read(buffer)) != -1){
                out.write(buffer, 0, len);
                size += len;
            }
            out.flush();
            d.setInquiryId(inquiryId);
            d.setDocumentName(documentName);
            d.setPath(uploadFileLocation);
            documents.setDocumentsPK(d);
//            ds.setStatus(1);
            create(documents);
            documentSetFacadeREST.editSet(inquiryId,documentName);
//            documentSetFacadeREST.edit(ds);
            output += documentName+" uploaded.";
        } catch (FileNotFoundException ex) {
            output += "Failed to uploaded.";
            Logger.getLogger(DocumentsFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            output += "Failed to uploaded.";
            Logger.getLogger(DocumentsFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return documentName+" uploaded.";
    }
    
    
    //get documents list by id
    @GET
    @Path("getDocumentsList/{id}")
    @Produces({"application/xml", "application/json", "text/plain"})
    public List<Documents> getInquiryById(@PathParam("id") String id) {
        List<Documents> d = findBy("findByInquiryId", id);
        return d;
    }
    
    @GET
    @Path("by/{namedQuery}/{attrValue}")
    @Produces({"application/xml", "application/json"})
    public List<Documents> findBy(@PathParam("namedQuery") String query, @PathParam("attrValue") String values) {
        String[] valueString = values.split(",");
        List<Object> valueList = new ArrayList<>();
        switch (query) {
            case "findByInquiryId":
                valueList.add(valueString[0]);
                break;
            case "findByEmail":
                valueList.add(valueString[0]);
                break;

        }
        return super.findBy("Documents." + query, valueList);
    }
}
