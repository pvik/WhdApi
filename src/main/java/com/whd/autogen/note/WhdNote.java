
package com.whd.autogen.note;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "noteText",
    "jobticket",
    "workTime",
    "isHidden",
    "isSolution",
    "billingRate",
    "statusTypeId",
    "emailClient",
    "emailTech",
    "emailTechGroupLevel",
    "emailGroupManager",
    "emailCc",
    "emailBcc",
    "ccAddressesForTech",
    "bccAddresses"
})
public class WhdNote {

    @JsonProperty("noteText")
    private String noteText;
    @JsonProperty("jobticket")
    private Jobticket jobticket;
    @JsonProperty("workTime")
    private String workTime;
    @JsonProperty("isHidden")
    private Boolean isHidden;
    @JsonProperty("isSolution")
    private Boolean isSolution;
    @JsonProperty("billingRate")
    private BillingRate billingRate;
    @JsonProperty("statusTypeId")
    private Integer statusTypeId;
    @JsonProperty("emailClient")
    private Boolean emailClient;
    @JsonProperty("emailTech")
    private Boolean emailTech;
    @JsonProperty("emailTechGroupLevel")
    private Boolean emailTechGroupLevel;
    @JsonProperty("emailGroupManager")
    private Boolean emailGroupManager;
    @JsonProperty("emailCc")
    private Boolean emailCc;
    @JsonProperty("emailBcc")
    private Boolean emailBcc;
    @JsonProperty("ccAddressesForTech")
    private String ccAddressesForTech;
    @JsonProperty("bccAddresses")
    private String bccAddresses;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The noteText
     */
    @JsonProperty("noteText")
    public String getNoteText() {
        return noteText;
    }

    /**
     * 
     * @param noteText
     *     The noteText
     */
    @JsonProperty("noteText")
    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public WhdNote withNoteText(String noteText) {
        this.noteText = noteText;
        return this;
    }

    /**
     * 
     * @return
     *     The jobticket
     */
    @JsonProperty("jobticket")
    public Jobticket getJobticket() {
        return jobticket;
    }

    /**
     * 
     * @param jobticket
     *     The jobticket
     */
    @JsonProperty("jobticket")
    public void setJobticket(Jobticket jobticket) {
        this.jobticket = jobticket;
    }

    public WhdNote withJobticket(Jobticket jobticket) {
        this.jobticket = jobticket;
        return this;
    }

    /**
     * 
     * @return
     *     The workTime
     */
    @JsonProperty("workTime")
    public String getWorkTime() {
        return workTime;
    }

    /**
     * 
     * @param workTime
     *     The workTime
     */
    @JsonProperty("workTime")
    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public WhdNote withWorkTime(String workTime) {
        this.workTime = workTime;
        return this;
    }

    /**
     * 
     * @return
     *     The isHidden
     */
    @JsonProperty("isHidden")
    public Boolean getIsHidden() {
        return isHidden;
    }

    /**
     * 
     * @param isHidden
     *     The isHidden
     */
    @JsonProperty("isHidden")
    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    public WhdNote withIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
        return this;
    }

    /**
     * 
     * @return
     *     The isSolution
     */
    @JsonProperty("isSolution")
    public Boolean getIsSolution() {
        return isSolution;
    }

    /**
     * 
     * @param isSolution
     *     The isSolution
     */
    @JsonProperty("isSolution")
    public void setIsSolution(Boolean isSolution) {
        this.isSolution = isSolution;
    }

    public WhdNote withIsSolution(Boolean isSolution) {
        this.isSolution = isSolution;
        return this;
    }

    /**
     * 
     * @return
     *     The billingRate
     */
    @JsonProperty("billingRate")
    public BillingRate getBillingRate() {
        return billingRate;
    }

    /**
     * 
     * @param billingRate
     *     The billingRate
     */
    @JsonProperty("billingRate")
    public void setBillingRate(BillingRate billingRate) {
        this.billingRate = billingRate;
    }

    public WhdNote withBillingRate(BillingRate billingRate) {
        this.billingRate = billingRate;
        return this;
    }

    /**
     * 
     * @return
     *     The statusTypeId
     */
    @JsonProperty("statusTypeId")
    public Integer getStatusTypeId() {
        return statusTypeId;
    }

    /**
     * 
     * @param statusTypeId
     *     The statusTypeId
     */
    @JsonProperty("statusTypeId")
    public void setStatusTypeId(Integer statusTypeId) {
        this.statusTypeId = statusTypeId;
    }

    public WhdNote withStatusTypeId(Integer statusTypeId) {
        this.statusTypeId = statusTypeId;
        return this;
    }

    /**
     * 
     * @return
     *     The emailClient
     */
    @JsonProperty("emailClient")
    public Boolean getEmailClient() {
        return emailClient;
    }

    /**
     * 
     * @param emailClient
     *     The emailClient
     */
    @JsonProperty("emailClient")
    public void setEmailClient(Boolean emailClient) {
        this.emailClient = emailClient;
    }

    public WhdNote withEmailClient(Boolean emailClient) {
        this.emailClient = emailClient;
        return this;
    }

    /**
     * 
     * @return
     *     The emailTech
     */
    @JsonProperty("emailTech")
    public Boolean getEmailTech() {
        return emailTech;
    }

    /**
     * 
     * @param emailTech
     *     The emailTech
     */
    @JsonProperty("emailTech")
    public void setEmailTech(Boolean emailTech) {
        this.emailTech = emailTech;
    }

    public WhdNote withEmailTech(Boolean emailTech) {
        this.emailTech = emailTech;
        return this;
    }

    /**
     * 
     * @return
     *     The emailTechGroupLevel
     */
    @JsonProperty("emailTechGroupLevel")
    public Boolean getEmailTechGroupLevel() {
        return emailTechGroupLevel;
    }

    /**
     * 
     * @param emailTechGroupLevel
     *     The emailTechGroupLevel
     */
    @JsonProperty("emailTechGroupLevel")
    public void setEmailTechGroupLevel(Boolean emailTechGroupLevel) {
        this.emailTechGroupLevel = emailTechGroupLevel;
    }

    public WhdNote withEmailTechGroupLevel(Boolean emailTechGroupLevel) {
        this.emailTechGroupLevel = emailTechGroupLevel;
        return this;
    }

    /**
     * 
     * @return
     *     The emailGroupManager
     */
    @JsonProperty("emailGroupManager")
    public Boolean getEmailGroupManager() {
        return emailGroupManager;
    }

    /**
     * 
     * @param emailGroupManager
     *     The emailGroupManager
     */
    @JsonProperty("emailGroupManager")
    public void setEmailGroupManager(Boolean emailGroupManager) {
        this.emailGroupManager = emailGroupManager;
    }

    public WhdNote withEmailGroupManager(Boolean emailGroupManager) {
        this.emailGroupManager = emailGroupManager;
        return this;
    }

    /**
     * 
     * @return
     *     The emailCc
     */
    @JsonProperty("emailCc")
    public Boolean getEmailCc() {
        return emailCc;
    }

    /**
     * 
     * @param emailCc
     *     The emailCc
     */
    @JsonProperty("emailCc")
    public void setEmailCc(Boolean emailCc) {
        this.emailCc = emailCc;
    }

    public WhdNote withEmailCc(Boolean emailCc) {
        this.emailCc = emailCc;
        return this;
    }

    /**
     * 
     * @return
     *     The emailBcc
     */
    @JsonProperty("emailBcc")
    public Boolean getEmailBcc() {
        return emailBcc;
    }

    /**
     * 
     * @param emailBcc
     *     The emailBcc
     */
    @JsonProperty("emailBcc")
    public void setEmailBcc(Boolean emailBcc) {
        this.emailBcc = emailBcc;
    }

    public WhdNote withEmailBcc(Boolean emailBcc) {
        this.emailBcc = emailBcc;
        return this;
    }

    /**
     * 
     * @return
     *     The ccAddressesForTech
     */
    @JsonProperty("ccAddressesForTech")
    public String getCcAddressesForTech() {
        return ccAddressesForTech;
    }

    /**
     * 
     * @param ccAddressesForTech
     *     The ccAddressesForTech
     */
    @JsonProperty("ccAddressesForTech")
    public void setCcAddressesForTech(String ccAddressesForTech) {
        this.ccAddressesForTech = ccAddressesForTech;
    }

    public WhdNote withCcAddressesForTech(String ccAddressesForTech) {
        this.ccAddressesForTech = ccAddressesForTech;
        return this;
    }

    /**
     * 
     * @return
     *     The bccAddresses
     */
    @JsonProperty("bccAddresses")
    public String getBccAddresses() {
        return bccAddresses;
    }

    /**
     * 
     * @param bccAddresses
     *     The bccAddresses
     */
    @JsonProperty("bccAddresses")
    public void setBccAddresses(String bccAddresses) {
        this.bccAddresses = bccAddresses;
    }

    public WhdNote withBccAddresses(String bccAddresses) {
        this.bccAddresses = bccAddresses;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public WhdNote withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(noteText).append(jobticket).append(workTime).append(isHidden).append(isSolution).append(billingRate).append(statusTypeId).append(emailClient).append(emailTech).append(emailTechGroupLevel).append(emailGroupManager).append(emailCc).append(emailBcc).append(ccAddressesForTech).append(bccAddresses).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WhdNote) == false) {
            return false;
        }
        WhdNote rhs = ((WhdNote) other);
        return new EqualsBuilder().append(noteText, rhs.noteText).append(jobticket, rhs.jobticket).append(workTime, rhs.workTime).append(isHidden, rhs.isHidden).append(isSolution, rhs.isSolution).append(billingRate, rhs.billingRate).append(statusTypeId, rhs.statusTypeId).append(emailClient, rhs.emailClient).append(emailTech, rhs.emailTech).append(emailTechGroupLevel, rhs.emailTechGroupLevel).append(emailGroupManager, rhs.emailGroupManager).append(emailCc, rhs.emailCc).append(emailBcc, rhs.emailBcc).append(ccAddressesForTech, rhs.ccAddressesForTech).append(bccAddresses, rhs.bccAddresses).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
