/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Followup;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author dashrath chauhan
 */
@Embeddable
public class FollowupDetailsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "inquiry_id")
    private String inquiryId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "counter")
    private int counter;

    public FollowupDetailsPK() {
    }

    public FollowupDetailsPK(String inquiryId, int counter) {
        this.inquiryId = inquiryId;
        this.counter = counter;
    }

    public String getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(String inquiryId) {
        this.inquiryId = inquiryId;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inquiryId != null ? inquiryId.hashCode() : 0);
        hash += (int) counter;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FollowupDetailsPK)) {
            return false;
        }
        FollowupDetailsPK other = (FollowupDetailsPK) object;
        if ((this.inquiryId == null && other.inquiryId != null) || (this.inquiryId != null && !this.inquiryId.equals(other.inquiryId))) {
            return false;
        }
        if (this.counter != other.counter) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Followup.FollowupDetailsPK[ inquiryId=" + inquiryId + ", counter=" + counter + " ]";
    }
    
}
