/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermodel.service;

import Followup.FollowUp;
import Inquiry.Inquiry;
import Inquiry.InquiryDetails;
import Inquiry.service.InquiryDetailsFacadeREST;
import Inquiry.service.InquiryFacadeREST;
import static Inquiry.service.InquiryFacadeREST.randomAlphaNumeric;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.swing.table.DefaultTableModel;
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
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import usermodel.Users;

/**
 *
 * @author dashrath chauhan
 */
@Stateless
@Path("usermodel.users")
public class UsersFacadeREST extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "HIRestAppPU")
    private EntityManager em;
    //private EntityManager em = Persistence.createEntityManagerFactory("HIRestAppPU").createEntityManager();

    public UsersFacadeREST() {
        super(Users.class);
    }
    @EJB
    private InquiryFacadeREST inquiryFacadeREST;
    
    @EJB
    private InquiryDetailsFacadeREST inquiryDetailsFacadeREST;

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Users entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Users entity) {
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
    public Users find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Users> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Users> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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

    //create user
    @POST
    @Path("createNewUser")
    @Produces("text/plain")
    @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
    public String createNewUser(@FormParam("userName") String userName,
            @FormParam("password") String password, @FormParam("email") String email,
            @FormParam("admin") String admin) {
        String output = "";
        int ad = 0;
        if (admin.contentEquals("Admin")) {
            ad = 1;
        } else {
            ad = 0;
        }
        Users user = new Users();
        user.setName(userName);
        user.setEmail(email);
        user.setPassword(password);
        user.setIsAdmin(ad);
        create(user);
        output = user.getName() + " created...";
        return userName + " " + password + " " + email;
    }

    //delete user
    @DELETE
    @Path("deleteUser/{userName}")
    @Produces("text/plain")
    public String deleteInquiry(@PathParam("userName") String userName) {
        String output = "";
        try {
            Users user = findBy("findByName", userName).get(0);
            remove(user);
            output = user.getName() + " deleted...";
        } catch (Exception e) {
            output = "Invalid user...";
        }
        return output;
    }

    @GET
    @Path("by/{namedQuery}/{attrValue}")
    @Produces({"application/xml", "application/json"})
    public List<Users> findBy(@PathParam("namedQuery") String query, @PathParam("attrValue") String values) {
        String[] valueString = values.split(",");
        List<Object> valueList = new ArrayList<>();
        switch (query) {
            case "findByName":
                valueList.add(valueString[0]);
                break;
            case "findByEmail":
                valueList.add(valueString[0]);
                break;

        }
        return super.findBy("Users." + query, valueList);
    }

    //retrieve all users
    @GET
    @Path("getAllUsers")
    @Produces({"application/xml", "application/json"})
    public List<Users> getAllUsers() {
        List<Users> users = findAll();
        return users;
    }

    @POST
    @Path("login")
    @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
    @Produces("text/plain")
    public String login(@FormParam("email") String email, @FormParam("password") String password) {
        String output = "";
        List<Users> users = findBy("findByEmail", email);
        for (int i = 0; i < users.size(); i++) {
            if (password.contentEquals(users.get(i).getPassword())) {
                output = email + "," + password + "," + users.get(i).getIsAdmin();
                break;
            } else {
                output = "";
            }
        }
        System.out.println("output" + output);
        return output;
    }

    //retrieve all users
    @PUT
    @Path("getInvoice")
    @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
    @Produces({"text/plain"})
    public String getInvoice(@FormParam("inquiryId") String inquiryId, @FormParam("applicationCharges") String applicationCharges,
            @FormParam("processCharges") String processCharges) {
        String output = "";
        try {
            int totalAmount = Integer.parseInt(applicationCharges) + Integer.parseInt(processCharges);
            DefaultTableModel tableModel;
            Inquiry inquiry = inquiryFacadeREST.find(inquiryId);
            JasperPrint jasperPrint = null;
            
            String[] columnNames = {"ID", "Name", "Description", "Charges"};
            String[][] data = {
                {inquiry.getId(), inquiry.getFirstName()+" "+inquiry.getLastName(), "Application Fee", "Rs "+applicationCharges},
                {" ", " ", "Process Charges", "Rs "+processCharges}
            };
            tableModel = new DefaultTableModel(data, columnNames);     
            String home = System.getProperty("user.home");
            JasperCompileManager.compileReportToFile(home+"\\Documents\\NetBeansProjects\\HIRestApp\\web\\Reports\\invoice1.jrxml");
            jasperPrint = JasperFillManager.fillReport(home+"\\Documents\\NetBeansProjects\\HIRestApp\\web\\Reports\\invoice1.jasper", new HashMap(),
                    new JRTableModelDataSource(tableModel));
            JasperExportManager.exportReportToPdfFile(jasperPrint, home+"/Downloads/" + inquiryId + "_Invoice.pdf");
            output += "Invoice generated.";
            
        } catch (JRException ex) {
            Logger.getLogger(UsersFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
    //basic report
    @PUT
    @Path("basicReport")
    @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
    @Produces({"text/plain"})
    public String getInvoice(@FormParam("inquiryId") String inquiryId) {
        String output = "";
        try {
            
            DefaultTableModel tableModel;
            Inquiry inquiry = inquiryFacadeREST.find(inquiryId);
            JasperPrint jasperPrint = null;
            
            String[] columnNames = {"ID", "Name", "Mobile No", "Email Id", "Country Preferences", "Inquiry Source", "Gender", "Date Created"};
            String[][] data = {
                {   inquiry.getId(), inquiry.getFirstName()+" "+inquiry.getLastName(),
                    inquiry.getMobile(), inquiry.getEmailId(), 
                    inquiry.getCountry(), inquiry.getInquirySource(),
                    inquiry.getGender(), inquiry.getDateTime().toString(),
                }
            };
            tableModel = new DefaultTableModel(data, columnNames);
            String home = System.getProperty("user.home");
            JasperCompileManager.compileReportToFile(home+"\\Documents\\NetBeansProjects\\HIRestApp\\web\\Reports\\basicReport.jrxml");
            jasperPrint = JasperFillManager.fillReport(home+"\\Documents\\NetBeansProjects\\HIRestApp\\web\\Reports\\basicReport.jasper", new HashMap(),
                    new JRTableModelDataSource(tableModel));
            JasperExportManager.exportReportToPdfFile(jasperPrint, home+"/Downloads/" + inquiryId + "_Basic_Report.pdf");
            output += "Report generated.";
            
        } catch (JRException ex) {
            Logger.getLogger(UsersFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
    //basic report
    @PUT
    @Path("briefReport")
    @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
    @Produces({"text/plain"})
    public String briefReport(@FormParam("dateFrom") String dateFrom, @FormParam("dateTo") String dateTo) {
        String output = "";
        //String[] valueString = date.split(",");       
        List<Inquiry> inquries = inquiryFacadeREST.findBy("findByDateBetween", dateFrom+","+dateTo);
        List<Map<String,?>> dataSource = new ArrayList<Map<String,?>>();
        try {
           
            JasperPrint jasperPrint = null;
            for(int i=0; i<inquries.size(); i++){
                //System.out.println(inquries.get(i).getFirstName()+" "+inquries.get(i).getLastName());
                Map<String,Object> m = new HashMap<String,Object>();
                m.put("id", inquries.get(i).getId());
                m.put("name", inquries.get(i).getFirstName()+" "+inquries.get(i).getLastName());
                m.put("country", inquries.get(i).getCountry());
                m.put("mobile", inquries.get(i).getMobile());
                m.put("date", inquries.get(i).getDateTime().toString());
                dataSource.add(m);
                System.out.println(dataSource.get(i).values());
            }
            JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);
            String home = System.getProperty("user.home");
            JasperReport jreport = JasperCompileManager.compileReport(home+"\\Documents\\NetBeansProjects\\HIRestApp\\web\\Reports\\briefReport.jrxml");
            jasperPrint = JasperFillManager.fillReport(jreport, null, jrDataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, home+"/Downloads/Brief_Report.pdf");
            output += "Report generated.";
            
        } catch (JRException ex) {
            Logger.getLogger(UsersFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
    
    //basic report
    @PUT
    @Path("inquiryReportById")
    @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
    @Produces({"text/plain"})
    public String inquiryReportById(@FormParam("inquiryId") String inquiryId) {
        String output = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Inquiry inquryBasic = inquiryFacadeREST.find(inquiryId);
        InquiryDetails inquryDetailed = inquiryDetailsFacadeREST.find(inquiryId);
        List<Map<String,?>> dataSource = new ArrayList<Map<String,?>>();
        try {
            JasperPrint jasperPrint = null;
                //System.out.println(inquries.get(i).getFirstName()+" "+inquries.get(i).getLastName());
                Map<String,Object> m = new HashMap<String,Object>();
                m.put("COLUMN_0",inquryBasic.getId());
                m.put("COLUMN_1",inquryBasic.getFirstName()+" "+inquryBasic.getLastName());
                m.put("COLUMN_2",inquryBasic.getMobile());
                m.put("COLUMN_3",inquryBasic.getEmailId());
                m.put("COLUMN_4",inquryBasic.getCountry());
                m.put("COLUMN_5",inquryBasic.getInquirySource());
                m.put("COLUMN_6",inquryBasic.getGender());
                m.put("COLUMN_7",dateFormat.format(inquryBasic.getDateTime()).toString());
                m.put("COLUMN_8",inquryDetailed.getFormType());
                m.put("COLUMN_9",inquryDetailed.getAssigned());
                m.put("COLUMN_10",inquryDetailed.getAssignedTo());
                m.put("COLUMN_11",inquryDetailed.getAdd1() + " " + inquryDetailed.getAdd2());
                m.put("COLUMN_12",inquryDetailed.getCity());
                m.put("COLUMN_13",inquryDetailed.getPincode());
                m.put("COLUMN_14",inquryDetailed.getState());
                m.put("COLUMN_15",inquryDetailed.getPassportNo());
                m.put("COLUMN_16",inquryDetailed.getAddPassport1());
                m.put("COLUMN_17",inquryDetailed.getAddPassport2());
                m.put("DATA1",inquryDetailed.getPer10());
                m.put("DATA2",inquryDetailed.getPassyear10());
                m.put("DATA3",inquryDetailed.getPer12());
                m.put("DATA4",inquryDetailed.getPassyear12());
                m.put("DATA5",inquryDetailed.getStream12());
                m.put("DATA6",inquryDetailed.getPerDip());
                m.put("DATA7",inquryDetailed.getPassyearDip());
                m.put("DATA8",inquryDetailed.getNameDip());
                m.put("DATA9",inquryDetailed.getAwardDip());
                m.put("DATA10",inquryDetailed.getDurationDip());
                m.put("DATA11",inquryDetailed.getPerBach());
                m.put("DATA12",inquryDetailed.getPassyearBach());
                m.put("DATA13",inquryDetailed.getNameBach());
                m.put("DATA14",inquryDetailed.getClgBach());
                m.put("DATA15",inquryDetailed.getDurationBach());
                m.put("DATA16",inquryDetailed.getPerDip());
                m.put("DATA17",inquryDetailed.getPassyearPgDip());
                m.put("DATA18",inquryDetailed.getNamePgDip());
                m.put("DATA19",inquryDetailed.getAwardPgDip());
                m.put("DATA20",inquryDetailed.getDurationPgDip());
                m.put("DATA21",inquryDetailed.getPerMasters());
                m.put("DATA22",inquryDetailed.getPassyearMasters());
                m.put("DATA23",inquryDetailed.getNameMasters());
                m.put("DATA24",inquryDetailed.getClgMasters());
                m.put("DATA25",inquryDetailed.getDurationMasters());
                m.put("DATA26",inquryDetailed.getBacklogsBach());
                m.put("DATA27",inquryDetailed.getBacklogsMasters());
                m.put("INFO1",inquryDetailed.getToeflScore());
                m.put("INFO2",inquryDetailed.getToeflMockScore());
                m.put("INFO3",dateFormat.format(inquryDetailed.getToeflDate()).toString());
                m.put("INFO4",inquryDetailed.getIeltsScore());
                m.put("INFO5",inquryDetailed.getIeltsMockScore());
                m.put("INFO6",dateFormat.format(inquryDetailed.getIeltsDate()).toString());
                m.put("INFO7",inquryDetailed.getGreScore());
                m.put("INFO8",inquryDetailed.getGreMockScore());
                m.put("INFO9",dateFormat.format(inquryDetailed.getGreDate()).toString());
                m.put("INFO10",inquryDetailed.getGmatScore());
                m.put("INFO11",inquryDetailed.getGmatMockScore());
                m.put("INFO12",dateFormat.format(inquryDetailed.getGmatDate()).toString());
                m.put("INFO13",inquryDetailed.getSatScore());
                m.put("INFO14",inquryDetailed.getSatMockScore());
                m.put("INFO15",dateFormat.format(inquryDetailed.getSatDate()).toString());
                m.put("INFO16",inquryDetailed.getNote());
                dataSource.add(m);
            JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);
            String home = System.getProperty("user.home");
            JasperReport jreport = JasperCompileManager.compileReport(home+"\\Documents\\NetBeansProjects\\HIRestApp\\web\\Reports\\inquiryReport.jrxml");
            jasperPrint = JasperFillManager.fillReport(jreport, null, jrDataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, home+"/Downloads/"+inquiryId+"_Inqury_Report.pdf");
            output += "Report generated.";
            
        } catch (JRException ex) {
            Logger.getLogger(UsersFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
    //followup report
    @PUT
    @Path("folowUpReport")
    @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
    @Produces({"text/plain"})
    public String folowUpReport(@FormParam("date") String date) {
        String output = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        List<FollowUp> inquries = inquiryFacadeREST.todaysApplicationsFollowUps(date);
        System.out.println(inquries.get(0).getInquiryId());
        System.out.println(inquries.get(1).getInquiryId());
        List<Map<String,?>> dataSource = new ArrayList<Map<String,?>>();
        try {
            JasperPrint jasperPrint = null;
            
            for(int i=0; i<inquries.size(); i++){
                Map<String,Object> m = new HashMap<String,Object>();
                m.put("COLUMN_0", inquries.get(i).getInquiryId());
                m.put("COLUMN_1", inquries.get(i).getFirstName()+" "+inquries.get(i).getLastName());
                m.put("COLUMN_2", inquries.get(i).getMobile());
                m.put("COLUMN_3", dateFormat.format(inquries.get(i).getLastFollowupDate()).toString());
                m.put("COLUMN_4", inquries.get(i).getDescription());
                dataSource.add(m);
            }
            
            JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);
            String home = System.getProperty("user.home");
            JasperReport jreport = JasperCompileManager.compileReport(home+"\\Documents\\NetBeansProjects\\HIRestApp\\web\\Reports\\followUp_Report.jrxml");
            jasperPrint = JasperFillManager.fillReport(jreport, null, jrDataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, home+"/Downloads/"+date+"_FollowUp_Report.pdf");
            output += "Report generated.";
            
        } catch (JRException ex) {
            Logger.getLogger(UsersFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
}
    
