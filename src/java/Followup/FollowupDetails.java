/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Followup;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dashrath chauhan
 */
@Entity
@Table(name = "followup_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FollowupDetails.findAll", query = "SELECT f FROM FollowupDetails f")
    , @NamedQuery(name = "FollowupDetails.findByInquiryId", query = "SELECT f FROM FollowupDetails f WHERE f.followupDetailsPK.inquiryId = :inquiryId")
    , @NamedQuery(name = "FollowupDetails.removeByInquiryId", query = "DELETE FROM FollowupDetails f WHERE f.followupDetailsPK.inquiryId = :inquiryId")
    , @NamedQuery(name = "FollowupDetails.findByCounter", query = "SELECT f FROM FollowupDetails f WHERE f.followupDetailsPK.counter = :counter")
    , @NamedQuery(name = "FollowupDetails.findByEmail", query = "SELECT f FROM FollowupDetails f WHERE f.email = :email")
    , @NamedQuery(name = "FollowupDetails.findByLastFollowupDate", query = "SELECT f FROM FollowupDetails f WHERE f.lastFollowupDate = :lastFollowupDate")
    , @NamedQuery(name = "FollowupDetails.findByNextFollowupDate", query = "SELECT f FROM FollowupDetails f WHERE f.nextFollowupDate = :nextFollowupDate")})
public class FollowupDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FollowupDetailsPK followupDetailsPK;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 64)
    @Column(name = "email")
    private String email;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "last_followup_date")
    @Temporal(TemporalType.DATE)
    private Date lastFollowupDate;
    @Column(name = "next_followup_date")
    @Temporal(TemporalType.DATE)
    private Date nextFollowupDate;
    @JoinColumn(name = "inquiry_id", referencedColumnName = "inquiry_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FollowUp followUp;

    public FollowupDetails() {
    }

    public FollowupDetails(FollowupDetailsPK followupDetailsPK) {
        this.followupDetailsPK = followupDetailsPK;
    }

    public FollowupDetails(String inquiryId, int counter) {
        this.followupDetailsPK = new FollowupDetailsPK(inquiryId, counter);
    }

    public FollowupDetailsPK getFollowupDetailsPK() {
        return followupDetailsPK;
    }

    public void setFollowupDetailsPK(FollowupDetailsPK followupDetailsPK) {
        this.followupDetailsPK = followupDetailsPK;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public FollowUp getFollowUp() {
        return followUp;
    }

    public void setFollowUp(FollowUp followUp) {
        this.followUp = followUp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (followupDetailsPK != null ? followupDetailsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FollowupDetails)) {
            return false;
        }
        FollowupDetails other = (FollowupDetails) object;
        if ((this.followupDetailsPK == null && other.followupDetailsPK != null) || (this.followupDetailsPK != null && !this.followupDetailsPK.equals(other.followupDetailsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Followup.FollowupDetails[ followupDetailsPK=" + followupDetailsPK + " ]";
    }
    
}
