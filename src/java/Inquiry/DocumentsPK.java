/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inquiry;

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
public class DocumentsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
//    @Size(min = 1, max = 8)
    @Column(name = "inquiry_id", length=8)
    private String inquiryId;
    @Basic(optional = false)
    @NotNull
//    @Size(min = 1, max = 64)
    @Column(name = "documentName", length=64)
    private String documentName;
    @Basic(optional = false)
    @NotNull
//    @Size(min = 1, max = 255)
    @Column(name = "path", length=25)
    private String path;

    public DocumentsPK() {
    }

    public DocumentsPK(String inquiryId, String documentName, String path) {
        this.inquiryId = inquiryId;
        this.documentName = documentName;
        this.path = path;
    }

    public String getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(String inquiryId) {
        this.inquiryId = inquiryId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inquiryId != null ? inquiryId.hashCode() : 0);
        hash += (documentName != null ? documentName.hashCode() : 0);
        hash += (path != null ? path.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentsPK)) {
            return false;
        }
        DocumentsPK other = (DocumentsPK) object;
        if ((this.inquiryId == null && other.inquiryId != null) || (this.inquiryId != null && !this.inquiryId.equals(other.inquiryId))) {
            return false;
        }
        if ((this.documentName == null && other.documentName != null) || (this.documentName != null && !this.documentName.equals(other.documentName))) {
            return false;
        }
        if ((this.path == null && other.path != null) || (this.path != null && !this.path.equals(other.path))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inquiry.DocumentsPK[ inquiryId=" + inquiryId + ", documentName=" + documentName + ", path=" + path + " ]";
    }
    
}
