/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inquiry;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dashrath chauhan
 */
@Entity
@Table(name = "inquiry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inquiry.findAll", query = "SELECT i FROM Inquiry i")
    , @NamedQuery(name = "Inquiry.findById", query = "SELECT i FROM Inquiry i WHERE i.id = :id")
    , @NamedQuery(name = "Inquiry.findByFirstName", query = "SELECT i FROM Inquiry i WHERE i.firstName = :firstName")
    , @NamedQuery(name = "Inquiry.findByLastName", query = "SELECT i FROM Inquiry i WHERE i.lastName = :lastName")
    , @NamedQuery(name = "Inquiry.findByMiddleName", query = "SELECT i FROM Inquiry i WHERE i.middleName = :middleName")
    , @NamedQuery(name = "Inquiry.findByGender", query = "SELECT i FROM Inquiry i WHERE i.gender = :gender")
    , @NamedQuery(name = "Inquiry.findByMobile", query = "SELECT i FROM Inquiry i WHERE i.mobile = :mobile")
    , @NamedQuery(name = "Inquiry.findByEmailId", query = "SELECT i FROM Inquiry i WHERE i.emailId = :emailId")
    , @NamedQuery(name = "Inquiry.findByInquirySource", query = "SELECT i FROM Inquiry i WHERE i.inquirySource = :inquirySource")
    , @NamedQuery(name = "Inquiry.findByCountry", query = "SELECT i FROM Inquiry i WHERE i.country = :country")
    , @NamedQuery(name = "Inquiry.findByDateTime", query = "SELECT i FROM Inquiry i WHERE i.dateTime = :dateTime")
    , @NamedQuery(name = "Inquiry.findByDateBetween", query = "SELECT i FROM Inquiry i WHERE i.dateTime >= ?1 and i.dateTime <= ?2")
    , @NamedQuery(name = "Inquiry.removeByInquiryId", query = "DELETE FROM Inquiry i WHERE i.id = :id")
    , @NamedQuery(name = "Inquiry.findByIsInquiry", query = "SELECT i FROM Inquiry i WHERE i.isInquiry = :isInquiry")})
public class Inquiry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "id")
    private String id;
    @Size(max = 32)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 32)
    @Column(name = "last_name")
    private String lastName;
    @Size(max = 32)
    @Column(name = "middle_name")
    private String middleName;
    @Size(max = 8)
    @Column(name = "gender")
    private String gender;
    @Size(max = 10)
    @Column(name = "mobile")
    private String mobile;
    @Size(max = 32)
    @Column(name = "emailId")
    private String emailId;
    @Size(max = 64)
    @Column(name = "inquiry_source")
    private String inquirySource;
    @Size(max = 255)
    @Column(name = "country")
    private String country;
    @Column(name = "dateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @Size(max = 2)
    @Column(name = "is_inquiry")
    private String isInquiry;

    public Inquiry() {
    }

    public Inquiry(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getInquirySource() {
        return inquirySource;
    }

    public void setInquirySource(String inquirySource) {
        this.inquirySource = inquirySource;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getIsInquiry() {
        return isInquiry;
    }

    public void setIsInquiry(String isInquiry) {
        this.isInquiry = isInquiry;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inquiry)) {
            return false;
        }
        Inquiry other = (Inquiry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inquiry.Inquiry[ id=" + id + " ]";
    }
    
}
