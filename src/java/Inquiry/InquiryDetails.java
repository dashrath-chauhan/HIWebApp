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
import javax.persistence.Lob;
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
@Table(name = "inquiry_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InquiryDetails.findAll", query = "SELECT i FROM InquiryDetails i")
    , @NamedQuery(name = "InquiryDetails.findByInquiryId", query = "SELECT i FROM InquiryDetails i WHERE i.inquiryId = :inquiryId")
    , @NamedQuery(name = "InquiryDetails.removeByInquiryId", query = "DELETE FROM InquiryDetails i WHERE i.inquiryId = :inquiryId")
    , @NamedQuery(name = "InquiryDetails.findByAdd1", query = "SELECT i FROM InquiryDetails i WHERE i.add1 = :add1")
    , @NamedQuery(name = "InquiryDetails.findByAdd2", query = "SELECT i FROM InquiryDetails i WHERE i.add2 = :add2")
    , @NamedQuery(name = "InquiryDetails.findByCity", query = "SELECT i FROM InquiryDetails i WHERE i.city = :city")
    , @NamedQuery(name = "InquiryDetails.findByPincode", query = "SELECT i FROM InquiryDetails i WHERE i.pincode = :pincode")
    , @NamedQuery(name = "InquiryDetails.findByState", query = "SELECT i FROM InquiryDetails i WHERE i.state = :state")
    , @NamedQuery(name = "InquiryDetails.findByPassportNo", query = "SELECT i FROM InquiryDetails i WHERE i.passportNo = :passportNo")
    , @NamedQuery(name = "InquiryDetails.findByAddPassport1", query = "SELECT i FROM InquiryDetails i WHERE i.addPassport1 = :addPassport1")
    , @NamedQuery(name = "InquiryDetails.findByAddPassport2", query = "SELECT i FROM InquiryDetails i WHERE i.addPassport2 = :addPassport2")
    , @NamedQuery(name = "InquiryDetails.findByPer10", query = "SELECT i FROM InquiryDetails i WHERE i.per10 = :per10")
    , @NamedQuery(name = "InquiryDetails.findByPassyear10", query = "SELECT i FROM InquiryDetails i WHERE i.passyear10 = :passyear10")
    , @NamedQuery(name = "InquiryDetails.findByPer12", query = "SELECT i FROM InquiryDetails i WHERE i.per12 = :per12")
    , @NamedQuery(name = "InquiryDetails.findByPassyear12", query = "SELECT i FROM InquiryDetails i WHERE i.passyear12 = :passyear12")
    , @NamedQuery(name = "InquiryDetails.findByStream12", query = "SELECT i FROM InquiryDetails i WHERE i.stream12 = :stream12")
    , @NamedQuery(name = "InquiryDetails.findByPerDip", query = "SELECT i FROM InquiryDetails i WHERE i.perDip = :perDip")
    , @NamedQuery(name = "InquiryDetails.findByPassyearDip", query = "SELECT i FROM InquiryDetails i WHERE i.passyearDip = :passyearDip")
    , @NamedQuery(name = "InquiryDetails.findByNameDip", query = "SELECT i FROM InquiryDetails i WHERE i.nameDip = :nameDip")
    , @NamedQuery(name = "InquiryDetails.findByAwardDip", query = "SELECT i FROM InquiryDetails i WHERE i.awardDip = :awardDip")
    , @NamedQuery(name = "InquiryDetails.findByDurationDip", query = "SELECT i FROM InquiryDetails i WHERE i.durationDip = :durationDip")
    , @NamedQuery(name = "InquiryDetails.findByPerBach", query = "SELECT i FROM InquiryDetails i WHERE i.perBach = :perBach")
    , @NamedQuery(name = "InquiryDetails.findByPassyearBach", query = "SELECT i FROM InquiryDetails i WHERE i.passyearBach = :passyearBach")
    , @NamedQuery(name = "InquiryDetails.findByNameBach", query = "SELECT i FROM InquiryDetails i WHERE i.nameBach = :nameBach")
    , @NamedQuery(name = "InquiryDetails.findByClgBach", query = "SELECT i FROM InquiryDetails i WHERE i.clgBach = :clgBach")
    , @NamedQuery(name = "InquiryDetails.findByDurationBach", query = "SELECT i FROM InquiryDetails i WHERE i.durationBach = :durationBach")
    , @NamedQuery(name = "InquiryDetails.findByBacklogsBach", query = "SELECT i FROM InquiryDetails i WHERE i.backlogsBach = :backlogsBach")
    , @NamedQuery(name = "InquiryDetails.findByPerPgDip", query = "SELECT i FROM InquiryDetails i WHERE i.perPgDip = :perPgDip")
    , @NamedQuery(name = "InquiryDetails.findByPassyearPgDip", query = "SELECT i FROM InquiryDetails i WHERE i.passyearPgDip = :passyearPgDip")
    , @NamedQuery(name = "InquiryDetails.findByNamePgDip", query = "SELECT i FROM InquiryDetails i WHERE i.namePgDip = :namePgDip")
    , @NamedQuery(name = "InquiryDetails.findByAwardPgDip", query = "SELECT i FROM InquiryDetails i WHERE i.awardPgDip = :awardPgDip")
    , @NamedQuery(name = "InquiryDetails.findByDurationPgDip", query = "SELECT i FROM InquiryDetails i WHERE i.durationPgDip = :durationPgDip")
    , @NamedQuery(name = "InquiryDetails.findByPerMasters", query = "SELECT i FROM InquiryDetails i WHERE i.perMasters = :perMasters")
    , @NamedQuery(name = "InquiryDetails.findByPassyearMasters", query = "SELECT i FROM InquiryDetails i WHERE i.passyearMasters = :passyearMasters")
    , @NamedQuery(name = "InquiryDetails.findByNameMasters", query = "SELECT i FROM InquiryDetails i WHERE i.nameMasters = :nameMasters")
    , @NamedQuery(name = "InquiryDetails.findByClgMasters", query = "SELECT i FROM InquiryDetails i WHERE i.clgMasters = :clgMasters")
    , @NamedQuery(name = "InquiryDetails.findByDurationMasters", query = "SELECT i FROM InquiryDetails i WHERE i.durationMasters = :durationMasters")
    , @NamedQuery(name = "InquiryDetails.findByBacklogsMasters", query = "SELECT i FROM InquiryDetails i WHERE i.backlogsMasters = :backlogsMasters")
    , @NamedQuery(name = "InquiryDetails.findByToeflScore", query = "SELECT i FROM InquiryDetails i WHERE i.toeflScore = :toeflScore")
    , @NamedQuery(name = "InquiryDetails.findByToeflMockScore", query = "SELECT i FROM InquiryDetails i WHERE i.toeflMockScore = :toeflMockScore")
    , @NamedQuery(name = "InquiryDetails.findByToeflDate", query = "SELECT i FROM InquiryDetails i WHERE i.toeflDate = :toeflDate")
    , @NamedQuery(name = "InquiryDetails.findByIeltsScore", query = "SELECT i FROM InquiryDetails i WHERE i.ieltsScore = :ieltsScore")
    , @NamedQuery(name = "InquiryDetails.findByIeltsMockScore", query = "SELECT i FROM InquiryDetails i WHERE i.ieltsMockScore = :ieltsMockScore")
    , @NamedQuery(name = "InquiryDetails.findByIeltsDate", query = "SELECT i FROM InquiryDetails i WHERE i.ieltsDate = :ieltsDate")
    , @NamedQuery(name = "InquiryDetails.findByGreScore", query = "SELECT i FROM InquiryDetails i WHERE i.greScore = :greScore")
    , @NamedQuery(name = "InquiryDetails.findByGreMockScore", query = "SELECT i FROM InquiryDetails i WHERE i.greMockScore = :greMockScore")
    , @NamedQuery(name = "InquiryDetails.findByGreDate", query = "SELECT i FROM InquiryDetails i WHERE i.greDate = :greDate")
    , @NamedQuery(name = "InquiryDetails.findByGmatScore", query = "SELECT i FROM InquiryDetails i WHERE i.gmatScore = :gmatScore")
    , @NamedQuery(name = "InquiryDetails.findByGmatMockScore", query = "SELECT i FROM InquiryDetails i WHERE i.gmatMockScore = :gmatMockScore")
    , @NamedQuery(name = "InquiryDetails.findByGmatDate", query = "SELECT i FROM InquiryDetails i WHERE i.gmatDate = :gmatDate")
    , @NamedQuery(name = "InquiryDetails.findBySatScore", query = "SELECT i FROM InquiryDetails i WHERE i.satScore = :satScore")
    , @NamedQuery(name = "InquiryDetails.findBySatMockScore", query = "SELECT i FROM InquiryDetails i WHERE i.satMockScore = :satMockScore")
    , @NamedQuery(name = "InquiryDetails.findBySatDate", query = "SELECT i FROM InquiryDetails i WHERE i.satDate = :satDate")
    , @NamedQuery(name = "InquiryDetails.findByFormType", query = "SELECT i FROM InquiryDetails i WHERE i.formType = :formType")
    , @NamedQuery(name = "InquiryDetails.findByAssigned", query = "SELECT i FROM InquiryDetails i WHERE i.assigned = :assigned")
    , @NamedQuery(name = "InquiryDetails.findByAssignedTo", query = "SELECT i FROM InquiryDetails i WHERE i.assignedTo = :assignedTo")})
public class InquiryDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 16)
    @Column(name = "inquiry_id", length=16)
    private String inquiryId;
//    @Size(max = 32)
    @Column(name = "add1", length=32)
    private String add1;
//    @Size(max = 32)
    @Column(name = "add2", length=32)
    private String add2;
//    @Size(max = 32)
    @Column(name = "city", length=32)
    private String city;
//    @Size(max = 6)
    @Column(name = "pincode", length=6)
    private String pincode;
//    @Size(max = 16)
    @Column(name = "state", length=16)
    private String state;
//    @Size(max = 16)
    @Column(name = "passport_no", length=16)
    private String passportNo;
//    @Size(max = 16)
    @Column(name = "add_passport1", length=16)
    private String addPassport1;
//    @Size(max = 16)
    @Column(name = "add_passport2", length=16)
    private String addPassport2;
//    @Size(max = 8)
    @Column(name = "per_10", length=8)
    private String per10;
//    @Size(max = 8)
    @Column(name = "passyear_10", length=8)
    private String passyear10;
//    @Size(max = 8)
    @Column(name = "per_12", length=8)
    private String per12;
//    @Size(max = 8)
    @Column(name = "passyear_12", length=8)
    private String passyear12;
//    @Size(max = 16)
    @Column(name = "stream_12", length=16)
    private String stream12;
//    @Size(max = 8)
    @Column(name = "per_dip", length=8)
    private String perDip;
//    @Size(max = 8)
    @Column(name = "passyear_dip", length=8)
    private String passyearDip;
//    @Size(max = 255)
    @Column(name = "name_dip", length=255)
    private String nameDip;
//    @Size(max = 255)
    @Column(name = "award_dip", length=255)
    private String awardDip;
//    @Size(max = 8)
    @Column(name = "duration_dip", length=8)
    private String durationDip;
//    @Size(max = 8)
    @Column(name = "per_bach", length=8)
    private String perBach;
//    @Size(max = 8)
    @Column(name = "passyear_bach", length=8)
    private String passyearBach;
//    @Size(max = 255)
    @Column(name = "name_bach", length=255)
    private String nameBach;
//    @Size(max = 255)
    @Column(name = "clg_bach", length=255)
    private String clgBach;
//    @Size(max = 8)
    @Column(name = "duration_bach", length=8)
    private String durationBach;
//    @Size(max = 8)
    @Column(name = "backlogs_bach", length=8)
    private String backlogsBach;
//    @Size(max = 8)
    @Column(name = "per_pg_dip", length=8)
    private String perPgDip;
//    @Size(max = 8)
    @Column(name = "passyear_pg_dip", length=8)
    private String passyearPgDip;
//    @Size(max = 255)
    @Column(name = "name_pg_dip", length=255)
    private String namePgDip;
//    @Size(max = 255)
    @Column(name = "award_pg_dip", length=255)
    private String awardPgDip;
//    @Size(max = 8)
    @Column(name = "duration_pg_dip", length=8)
    private String durationPgDip;
//    @Size(max = 8)
    @Column(name = "per_masters", length=8)
    private String perMasters;
//    @Size(max = 8)
    @Column(name = "passyear_masters", length=8)
    private String passyearMasters;
//    @Size(max = 255)
    @Column(name = "name_masters", length=255)
    private String nameMasters;
//    @Size(max = 255)
    @Column(name = "clg_masters", length=255)
    private String clgMasters;
//    @Size(max = 8)
    @Column(name = "duration_masters", length=8)
    private String durationMasters;
//    @Size(max = 8)
    @Column(name = "backlogs_masters", length=8)
    private String backlogsMasters;
//    @Size(max = 8)
    @Column(name = "toefl_score", length=8)
    private String toeflScore;
//    @Size(max = 8)
    @Column(name = "toefl_mock_score", length=8)
    private String toeflMockScore;
    @Column(name = "toefl_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date toeflDate;
//    @Size(max = 8)
    @Column(name = "ielts_score", length=8)
    private String ieltsScore;
//    @Size(max = 8)
    @Column(name = "ielts_mock_score", length=8)
    private String ieltsMockScore;
    @Column(name = "ielts_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ieltsDate;
//    @Size(max = 8)
    @Column(name = "gre_score", length=8)
    private String greScore;
//    @Size(max = 8)/
    @Column(name = "gre_mock_score", length=8)
    private String greMockScore;
    @Column(name = "gre_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date greDate;
//    @Size(max = 8)
    @Column(name = "gmat_score", length=8)
    private String gmatScore;
//    @Size(max = 8)
    @Column(name = "gmat_mock_score", length=8)
    private String gmatMockScore;
    @Column(name = "gmat_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gmatDate;
//    @Size(max = 8)
    @Column(name = "sat_score", length=8)
    private String satScore;
//    @Size(max = 8)
    @Column(name = "sat_mock_score", length=8)
    private String satMockScore;
    @Column(name = "sat_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date satDate;
//    @Size(max = 32)
    @Column(name = "form_type", length=32)
    private String formType;
//    @Size(max = 32)
    @Column(name = "assigned", length=32)
    private String assigned;
//    @Size(max = 32)
    @Column(name = "assigned_to", length=32)
    private String assignedTo;
    @Lob
//    @Size(max = 65535)
    @Column(name = "note", length=65535)
    private String note;

    public InquiryDetails() {
    }

    public InquiryDetails(String inquiryId) {
        this.inquiryId = inquiryId;
    }

    public String getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(String inquiryId) {
        this.inquiryId = inquiryId;
    }

    public String getAdd1() {
        return add1;
    }

    public void setAdd1(String add1) {
        this.add1 = add1;
    }

    public String getAdd2() {
        return add2;
    }

    public void setAdd2(String add2) {
        this.add2 = add2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getAddPassport1() {
        return addPassport1;
    }

    public void setAddPassport1(String addPassport1) {
        this.addPassport1 = addPassport1;
    }

    public String getAddPassport2() {
        return addPassport2;
    }

    public void setAddPassport2(String addPassport2) {
        this.addPassport2 = addPassport2;
    }

    public String getPer10() {
        return per10;
    }

    public void setPer10(String per10) {
        this.per10 = per10;
    }

    public String getPassyear10() {
        return passyear10;
    }

    public void setPassyear10(String passyear10) {
        this.passyear10 = passyear10;
    }

    public String getPer12() {
        return per12;
    }

    public void setPer12(String per12) {
        this.per12 = per12;
    }

    public String getPassyear12() {
        return passyear12;
    }

    public void setPassyear12(String passyear12) {
        this.passyear12 = passyear12;
    }

    public String getStream12() {
        return stream12;
    }

    public void setStream12(String stream12) {
        this.stream12 = stream12;
    }

    public String getPerDip() {
        return perDip;
    }

    public void setPerDip(String perDip) {
        this.perDip = perDip;
    }

    public String getPassyearDip() {
        return passyearDip;
    }

    public void setPassyearDip(String passyearDip) {
        this.passyearDip = passyearDip;
    }

    public String getNameDip() {
        return nameDip;
    }

    public void setNameDip(String nameDip) {
        this.nameDip = nameDip;
    }

    public String getAwardDip() {
        return awardDip;
    }

    public void setAwardDip(String awardDip) {
        this.awardDip = awardDip;
    }

    public String getDurationDip() {
        return durationDip;
    }

    public void setDurationDip(String durationDip) {
        this.durationDip = durationDip;
    }

    public String getPerBach() {
        return perBach;
    }

    public void setPerBach(String perBach) {
        this.perBach = perBach;
    }

    public String getPassyearBach() {
        return passyearBach;
    }

    public void setPassyearBach(String passyearBach) {
        this.passyearBach = passyearBach;
    }

    public String getNameBach() {
        return nameBach;
    }

    public void setNameBach(String nameBach) {
        this.nameBach = nameBach;
    }

    public String getClgBach() {
        return clgBach;
    }

    public void setClgBach(String clgBach) {
        this.clgBach = clgBach;
    }

    public String getDurationBach() {
        return durationBach;
    }

    public void setDurationBach(String durationBach) {
        this.durationBach = durationBach;
    }

    public String getBacklogsBach() {
        return backlogsBach;
    }

    public void setBacklogsBach(String backlogsBach) {
        this.backlogsBach = backlogsBach;
    }

    public String getPerPgDip() {
        return perPgDip;
    }

    public void setPerPgDip(String perPgDip) {
        this.perPgDip = perPgDip;
    }

    public String getPassyearPgDip() {
        return passyearPgDip;
    }

    public void setPassyearPgDip(String passyearPgDip) {
        this.passyearPgDip = passyearPgDip;
    }

    public String getNamePgDip() {
        return namePgDip;
    }

    public void setNamePgDip(String namePgDip) {
        this.namePgDip = namePgDip;
    }

    public String getAwardPgDip() {
        return awardPgDip;
    }

    public void setAwardPgDip(String awardPgDip) {
        this.awardPgDip = awardPgDip;
    }

    public String getDurationPgDip() {
        return durationPgDip;
    }

    public void setDurationPgDip(String durationPgDip) {
        this.durationPgDip = durationPgDip;
    }

    public String getPerMasters() {
        return perMasters;
    }

    public void setPerMasters(String perMasters) {
        this.perMasters = perMasters;
    }

    public String getPassyearMasters() {
        return passyearMasters;
    }

    public void setPassyearMasters(String passyearMasters) {
        this.passyearMasters = passyearMasters;
    }

    public String getNameMasters() {
        return nameMasters;
    }

    public void setNameMasters(String nameMasters) {
        this.nameMasters = nameMasters;
    }

    public String getClgMasters() {
        return clgMasters;
    }

    public void setClgMasters(String clgMasters) {
        this.clgMasters = clgMasters;
    }

    public String getDurationMasters() {
        return durationMasters;
    }

    public void setDurationMasters(String durationMasters) {
        this.durationMasters = durationMasters;
    }

    public String getBacklogsMasters() {
        return backlogsMasters;
    }

    public void setBacklogsMasters(String backlogsMasters) {
        this.backlogsMasters = backlogsMasters;
    }

    public String getToeflScore() {
        return toeflScore;
    }

    public void setToeflScore(String toeflScore) {
        this.toeflScore = toeflScore;
    }

    public String getToeflMockScore() {
        return toeflMockScore;
    }

    public void setToeflMockScore(String toeflMockScore) {
        this.toeflMockScore = toeflMockScore;
    }

    public Date getToeflDate() {
        return toeflDate;
    }

    public void setToeflDate(Date toeflDate) {
        this.toeflDate = toeflDate;
    }

    public String getIeltsScore() {
        return ieltsScore;
    }

    public void setIeltsScore(String ieltsScore) {
        this.ieltsScore = ieltsScore;
    }

    public String getIeltsMockScore() {
        return ieltsMockScore;
    }

    public void setIeltsMockScore(String ieltsMockScore) {
        this.ieltsMockScore = ieltsMockScore;
    }

    public Date getIeltsDate() {
        return ieltsDate;
    }

    public void setIeltsDate(Date ieltsDate) {
        this.ieltsDate = ieltsDate;
    }

    public String getGreScore() {
        return greScore;
    }

    public void setGreScore(String greScore) {
        this.greScore = greScore;
    }

    public String getGreMockScore() {
        return greMockScore;
    }

    public void setGreMockScore(String greMockScore) {
        this.greMockScore = greMockScore;
    }

    public Date getGreDate() {
        return greDate;
    }

    public void setGreDate(Date greDate) {
        this.greDate = greDate;
    }

    public String getGmatScore() {
        return gmatScore;
    }

    public void setGmatScore(String gmatScore) {
        this.gmatScore = gmatScore;
    }

    public String getGmatMockScore() {
        return gmatMockScore;
    }

    public void setGmatMockScore(String gmatMockScore) {
        this.gmatMockScore = gmatMockScore;
    }

    public Date getGmatDate() {
        return gmatDate;
    }

    public void setGmatDate(Date gmatDate) {
        this.gmatDate = gmatDate;
    }

    public String getSatScore() {
        return satScore;
    }

    public void setSatScore(String satScore) {
        this.satScore = satScore;
    }

    public String getSatMockScore() {
        return satMockScore;
    }

    public void setSatMockScore(String satMockScore) {
        this.satMockScore = satMockScore;
    }

    public Date getSatDate() {
        return satDate;
    }

    public void setSatDate(Date satDate) {
        this.satDate = satDate;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getAssigned() {
        return assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
        if (!(object instanceof InquiryDetails)) {
            return false;
        }
        InquiryDetails other = (InquiryDetails) object;
        if ((this.inquiryId == null && other.inquiryId != null) || (this.inquiryId != null && !this.inquiryId.equals(other.inquiryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inquiry.InquiryDetails[ inquiryId=" + inquiryId + " ]";
    }
    
}
