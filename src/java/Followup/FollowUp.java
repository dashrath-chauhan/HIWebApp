/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Followup;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dashrath chauhan
 */
@Entity
@Table(name = "follow_up")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FollowUp.findAll", query = "SELECT f FROM FollowUp f")
    , @NamedQuery(name = "FollowUp.findByInquiryId", query = "SELECT f FROM FollowUp f WHERE f.inquiryId = :inquiryId")
    , @NamedQuery(name = "FollowUp.removeByInquiryId", query = "DELETE FROM FollowUp f WHERE f.inquiryId = :inquiryId")
    , @NamedQuery(name = "FollowUp.findByEmail", query = "SELECT f FROM FollowUp f WHERE f.email = :email")
    , @NamedQuery(name = "FollowUp.findByFirstName", query = "SELECT f FROM FollowUp f WHERE f.firstName = :firstName")
    , @NamedQuery(name = "FollowUp.findByLastName", query = "SELECT f FROM FollowUp f WHERE f.lastName = :lastName")
    , @NamedQuery(name = "FollowUp.findByLeadType", query = "SELECT f FROM FollowUp f WHERE f.leadType = :leadType")
    , @NamedQuery(name = "FollowUp.findByType", query = "SELECT f FROM FollowUp f WHERE f.type = :type")
    , @NamedQuery(name = "FollowUp.findByStrength", query = "SELECT f FROM FollowUp f WHERE f.strength = :strength")
    , @NamedQuery(name = "FollowUp.findByStatus", query = "SELECT f FROM FollowUp f WHERE f.status = :status")
    , @NamedQuery(name = "FollowUp.findByLastFollowupDate", query = "SELECT f FROM FollowUp f WHERE f.lastFollowupDate = :lastFollowupDate")
    , @NamedQuery(name = "FollowUp.findByNextFollowupDate", query = "SELECT f FROM FollowUp f WHERE f.nextFollowupDate = :nextFollowupDate")
    , @NamedQuery(name = "FollowUp.findByMobile", query = "SELECT f FROM FollowUp f WHERE f.mobile = :mobile")
    , @NamedQuery(name = "FollowUp.findByConvertedOn", query = "SELECT f FROM FollowUp f WHERE f.convertedOn = :convertedOn")
    , @NamedQuery(name = "FollowUp.findByConvertedBy", query = "SELECT f FROM FollowUp f WHERE f.convertedBy = :convertedBy")})
public class FollowUp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "inquiry_id")
    private String inquiryId;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 32)
    @Column(name = "email")
    private String email;
    @Size(max = 16)
    @Column(name = "firstName")
    private String firstName;
    @Size(max = 16)
    @Column(name = "lastName")
    private String lastName;
    @Size(max = 8)
    @Column(name = "leadType")
    private String leadType;
    @Size(max = 32)
    @Column(name = "type")
    private String type;
    @Size(max = 32)
    @Column(name = "strength")
    private String strength;
    @Size(max = 32)
    @Column(name = "status")
    private String status;
    @Column(name = "last_followup_date")
    @Temporal(TemporalType.DATE)
    private Date lastFollowupDate;
    @Column(name = "next_followup_date")
    @Temporal(TemporalType.DATE)
    private Date nextFollowupDate;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Size(max = 16)
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "converted_on")
    @Temporal(TemporalType.DATE)
    private Date convertedOn;
    @Size(max = 32)
    @Column(name = "converted_by")
    private String convertedBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "followUp")
    private Collection<FollowupDetails> followupDetailsCollection;

    public FollowUp() {
    }

    public FollowUp(String inquiryId) {
        this.inquiryId = inquiryId;
    }

    public String getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(String inquiryId) {
        this.inquiryId = inquiryId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getLeadType() {
        return leadType;
    }

    public void setLeadType(String leadType) {
        this.leadType = leadType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastFollowupDate() {
        return lastFollowupDate;
    }

    public void setLastFollowupDate(Date lastFollowupDate) {
        this.lastFollowupDate = lastFollowupDate;
    }

    public Date getNextFollowupDate() {
        return nextFollowupDate;
    }

    public void setNextFollowupDate(Date nextFollowupDate) {
        this.nextFollowupDate = nextFollowupDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getConvertedOn() {
        return convertedOn;
    }

    public void setConvertedOn(Date convertedOn) {
        this.convertedOn = convertedOn;
    }

    public String getConvertedBy() {
        return convertedBy;
    }

    public void setConvertedBy(String convertedBy) {
        this.convertedBy = convertedBy;
    }

    @XmlTransient
    public Collection<FollowupDetails> getFollowupDetailsCollection() {
        return followupDetailsCollection;
    }

    public void setFollowupDetailsCollection(Collection<FollowupDetails> followupDetailsCollection) {
        this.followupDetailsCollection = followupDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inquiryId != null ? inquiryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FollowUp)) {
            return false;
        }
        FollowUp other = (FollowUp) object;
        if ((this.inquiryId == null && other.inquiryId != null) || (this.inquiryId != null && !this.inquiryId.equals(other.inquiryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Followup.FollowUp[ inquiryId=" + inquiryId + " ]";
    }
    
}
