/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inquiry;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dashrath chauhan
 */
@Entity
@Table(name = "document_set")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentSet.findAll", query = "SELECT d FROM DocumentSet d")
    , @NamedQuery(name = "DocumentSet.findById", query = "SELECT d FROM DocumentSet d WHERE d.id = :id")
    , @NamedQuery(name = "DocumentSet.findByInquiryId", query = "SELECT d FROM DocumentSet d WHERE d.inquiryId = :inquiryId")
    , @NamedQuery(name = "DocumentSet.findByInquiryIdAndStatus", query = "SELECT d FROM DocumentSet d WHERE d.inquiryId = :inquiryId and d.status=0")
    , @NamedQuery(name = "DocumentSet.findByDocumentName", query = "SELECT d FROM DocumentSet d WHERE d.documentName = :documentName")
    , @NamedQuery(name = "DocumentSet.findByInquiryIdAndDocumentName", query = "SELECT d FROM DocumentSet d WHERE d.inquiryId = ?1 and d.documentName = ?2")
    , @NamedQuery(name = "DocumentSet.findByStatus", query = "SELECT d FROM DocumentSet d WHERE d.status = :status")})
public class DocumentSet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "inquiry_id")
    private String inquiryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "document_name")
    private String documentName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;

    public DocumentSet() {
    }

    public DocumentSet(Integer id) {
        this.id = id;
    }

    public DocumentSet(Integer id, String inquiryId, String documentName, int status) {
        this.id = id;
        this.inquiryId = inquiryId;
        this.documentName = documentName;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        if (!(object instanceof DocumentSet)) {
            return false;
        }
        DocumentSet other = (DocumentSet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inquiry.DocumentSet[ id=" + id + " ]";
    }
    
}
