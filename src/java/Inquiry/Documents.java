/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inquiry;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dashrath chauhan
 */
@Entity
@Table(name = "documents")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documents.findAll", query = "SELECT d FROM Documents d")
    , @NamedQuery(name = "Documents.findByInquiryId", query = "SELECT d FROM Documents d WHERE d.documentsPK.inquiryId = :inquiryId")
    , @NamedQuery(name = "Documents.findByDocumentName", query = "SELECT d FROM Documents d WHERE d.documentsPK.documentName = :documentName")
    , @NamedQuery(name = "Documents.findByPath", query = "SELECT d FROM Documents d WHERE d.documentsPK.path = :path")})
public class Documents implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocumentsPK documentsPK;

    public Documents() {
    }

    public Documents(DocumentsPK documentsPK) {
        this.documentsPK = documentsPK;
    }

    public Documents(String inquiryId, String documentName, String path) {
        this.documentsPK = new DocumentsPK(inquiryId, documentName, path);
    }

    public DocumentsPK getDocumentsPK() {
        return documentsPK;
    }

    public void setDocumentsPK(DocumentsPK documentsPK) {
        this.documentsPK = documentsPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentsPK != null ? documentsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documents)) {
            return false;
        }
        Documents other = (Documents) object;
        if ((this.documentsPK == null && other.documentsPK != null) || (this.documentsPK != null && !this.documentsPK.equals(other.documentsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inquiry.Documents[ documentsPK=" + documentsPK + " ]";
    }
    
}
