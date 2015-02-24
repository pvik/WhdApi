
package com.whd.autogen.ticket;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "id",
    "type",
    "bccAddresses",
    "ccAddressesForTech",
    "departmentId",
    "lastUpdated",
    "locationId",
    "priorityTypeId",
    "room",
    "statusTypeId",
    "subject",
    "clientReporter",
    "clientTech",
    "location",
    "prioritytype",
    "problemtype",
    "statustype",
    "techGroupLevel",
    "detail",
    "reportDateUtc",
    "displayClient",
    "emailClient",
    "emailTech",
    "emailTechGroupLevel",
    "emailGroupManager",
    "emailCc",
    "emailBcc",
    "needsApproval",
    "ticketEditable",
    "techId",
    "levelNumber",
    "clientId",
    "flaggedByTech",
    "isPublic",
    "canEscalate",
    "notes",
    "ticketCustomFields",
    "enabledStatusTypes",
    "attachments"
})
public class WhdTicket {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("bccAddresses")
    private String bccAddresses;
    @JsonProperty("ccAddressesForTech")
    private String ccAddressesForTech;
    @JsonProperty("departmentId")
    private Integer departmentId;
    @JsonProperty("lastUpdated")
    private String lastUpdated;
    @JsonProperty("locationId")
    private Integer locationId;
    @JsonProperty("priorityTypeId")
    private Integer priorityTypeId;
    @JsonProperty("room")
    private String room;
    @JsonProperty("statusTypeId")
    private Integer statusTypeId;
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("clientReporter")
    private ClientReporter clientReporter;
    @JsonProperty("clientTech")
    private ClientTech clientTech;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("prioritytype")
    private Prioritytype prioritytype;
    @JsonProperty("problemtype")
    private Problemtype problemtype;
    @JsonProperty("statustype")
    private Statustype statustype;
    @JsonProperty("techGroupLevel")
    private TechGroupLevel techGroupLevel;
    @JsonProperty("detail")
    private String detail;
    @JsonProperty("reportDateUtc")
    private String reportDateUtc;
    @JsonProperty("displayClient")
    private String displayClient;
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
    @JsonProperty("needsApproval")
    private Boolean needsApproval;
    @JsonProperty("ticketEditable")
    private Boolean ticketEditable;
    @JsonProperty("techId")
    private Integer techId;
    @JsonProperty("levelNumber")
    private String levelNumber;
    @JsonProperty("clientId")
    private Integer clientId;
    @JsonProperty("flaggedByTech")
    private Boolean flaggedByTech;
    @JsonProperty("isPublic")
    private Boolean isPublic;
    @JsonProperty("canEscalate")
    private Boolean canEscalate;
    @JsonProperty("notes")
    private List<Note> notes = new ArrayList<Note>();
    @JsonProperty("ticketCustomFields")
    private List<TicketCustomField> ticketCustomFields = new ArrayList<TicketCustomField>();
    @JsonProperty("enabledStatusTypes")
    private List<Statustype> enabledStatusTypes = new ArrayList<Statustype>();
    @JsonProperty("attachments")
    private List<Attachment> attachments = new ArrayList<Attachment>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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

    /**
     * 
     * @return
     *     The departmentId
     */
    @JsonProperty("departmentId")
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * 
     * @param departmentId
     *     The departmentId
     */
    @JsonProperty("departmentId")
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 
     * @return
     *     The lastUpdated
     */
    @JsonProperty("lastUpdated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * 
     * @param lastUpdated
     *     The lastUpdated
     */
    @JsonProperty("lastUpdated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * 
     * @return
     *     The locationId
     */
    @JsonProperty("locationId")
    public Integer getLocationId() {
        return locationId;
    }

    /**
     * 
     * @param locationId
     *     The locationId
     */
    @JsonProperty("locationId")
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    /**
     * 
     * @return
     *     The priorityTypeId
     */
    @JsonProperty("priorityTypeId")
    public Integer getPriorityTypeId() {
        return priorityTypeId;
    }

    /**
     * 
     * @param priorityTypeId
     *     The priorityTypeId
     */
    @JsonProperty("priorityTypeId")
    public void setPriorityTypeId(Integer priorityTypeId) {
        this.priorityTypeId = priorityTypeId;
    }

    /**
     * 
     * @return
     *     The room
     */
    @JsonProperty("room")
    public String getRoom() {
        return room;
    }

    /**
     * 
     * @param room
     *     The room
     */
    @JsonProperty("room")
    public void setRoom(String room) {
        this.room = room;
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

    /**
     * 
     * @return
     *     The subject
     */
    @JsonProperty("subject")
    public String getSubject() {
        return subject;
    }

    /**
     * 
     * @param subject
     *     The subject
     */
    @JsonProperty("subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * 
     * @return
     *     The clientReporter
     */
    @JsonProperty("clientReporter")
    public ClientReporter getClientReporter() {
        return clientReporter;
    }

    /**
     * 
     * @param clientReporter
     *     The clientReporter
     */
    @JsonProperty("clientReporter")
    public void setClientReporter(ClientReporter clientReporter) {
        this.clientReporter = clientReporter;
    }

    /**
     * 
     * @return
     *     The clientTech
     */
    @JsonProperty("clientTech")
    public ClientTech getClientTech() {
        return clientTech;
    }

    /**
     * 
     * @param clientTech
     *     The clientTech
     */
    @JsonProperty("clientTech")
    public void setClientTech(ClientTech clientTech) {
        this.clientTech = clientTech;
    }

    /**
     * 
     * @return
     *     The location
     */
    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * 
     * @return
     *     The prioritytype
     */
    @JsonProperty("prioritytype")
    public Prioritytype getPrioritytype() {
        return prioritytype;
    }

    /**
     * 
     * @param prioritytype
     *     The prioritytype
     */
    @JsonProperty("prioritytype")
    public void setPrioritytype(Prioritytype prioritytype) {
        this.prioritytype = prioritytype;
    }

    /**
     * 
     * @return
     *     The problemtype
     */
    @JsonProperty("problemtype")
    public Problemtype getProblemtype() {
        return problemtype;
    }

    /**
     * 
     * @param problemtype
     *     The problemtype
     */
    @JsonProperty("problemtype")
    public void setProblemtype(Problemtype problemtype) {
        this.problemtype = problemtype;
    }

    /**
     * 
     * @return
     *     The statustype
     */
    @JsonProperty("statustype")
    public Statustype getStatustype() {
        return statustype;
    }

    /**
     * 
     * @param statustype
     *     The statustype
     */
    @JsonProperty("statustype")
    public void setStatustype(Statustype statustype) {
        this.statustype = statustype;
    }

    /**
     * 
     * @return
     *     The techGroupLevel
     */
    @JsonProperty("techGroupLevel")
    public TechGroupLevel getTechGroupLevel() {
        return techGroupLevel;
    }

    /**
     * 
     * @param techGroupLevel
     *     The techGroupLevel
     */
    @JsonProperty("techGroupLevel")
    public void setTechGroupLevel(TechGroupLevel techGroupLevel) {
        this.techGroupLevel = techGroupLevel;
    }

    /**
     * 
     * @return
     *     The detail
     */
    @JsonProperty("detail")
    public String getDetail() {
        return detail;
    }

    /**
     * 
     * @param detail
     *     The detail
     */
    @JsonProperty("detail")
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * 
     * @return
     *     The reportDateUtc
     */
    @JsonProperty("reportDateUtc")
    public String getReportDateUtc() {
        return reportDateUtc;
    }

    /**
     * 
     * @param reportDateUtc
     *     The reportDateUtc
     */
    @JsonProperty("reportDateUtc")
    public void setReportDateUtc(String reportDateUtc) {
        this.reportDateUtc = reportDateUtc;
    }

    /**
     * 
     * @return
     *     The displayClient
     */
    @JsonProperty("displayClient")
    public String getDisplayClient() {
        return displayClient;
    }

    /**
     * 
     * @param displayClient
     *     The displayClient
     */
    @JsonProperty("displayClient")
    public void setDisplayClient(String displayClient) {
        this.displayClient = displayClient;
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

    /**
     * 
     * @return
     *     The needsApproval
     */
    @JsonProperty("needsApproval")
    public Boolean getNeedsApproval() {
        return needsApproval;
    }

    /**
     * 
     * @param needsApproval
     *     The needsApproval
     */
    @JsonProperty("needsApproval")
    public void setNeedsApproval(Boolean needsApproval) {
        this.needsApproval = needsApproval;
    }

    /**
     * 
     * @return
     *     The ticketEditable
     */
    @JsonProperty("ticketEditable")
    public Boolean getTicketEditable() {
        return ticketEditable;
    }

    /**
     * 
     * @param ticketEditable
     *     The ticketEditable
     */
    @JsonProperty("ticketEditable")
    public void setTicketEditable(Boolean ticketEditable) {
        this.ticketEditable = ticketEditable;
    }

    /**
     * 
     * @return
     *     The techId
     */
    @JsonProperty("techId")
    public Integer getTechId() {
        return techId;
    }

    /**
     * 
     * @param techId
     *     The techId
     */
    @JsonProperty("techId")
    public void setTechId(Integer techId) {
        this.techId = techId;
    }

    /**
     * 
     * @return
     *     The levelNumber
     */
    @JsonProperty("levelNumber")
    public String getLevelNumber() {
        return levelNumber;
    }

    /**
     * 
     * @param levelNumber
     *     The levelNumber
     */
    @JsonProperty("levelNumber")
    public void setLevelNumber(String levelNumber) {
        this.levelNumber = levelNumber;
    }

    /**
     * 
     * @return
     *     The clientId
     */
    @JsonProperty("clientId")
    public Integer getClientId() {
        return clientId;
    }

    /**
     * 
     * @param clientId
     *     The clientId
     */
    @JsonProperty("clientId")
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    /**
     * 
     * @return
     *     The flaggedByTech
     */
    @JsonProperty("flaggedByTech")
    public Boolean getFlaggedByTech() {
        return flaggedByTech;
    }

    /**
     * 
     * @param flaggedByTech
     *     The flaggedByTech
     */
    @JsonProperty("flaggedByTech")
    public void setFlaggedByTech(Boolean flaggedByTech) {
        this.flaggedByTech = flaggedByTech;
    }

    /**
     * 
     * @return
     *     The isPublic
     */
    @JsonProperty("isPublic")
    public Boolean getIsPublic() {
        return isPublic;
    }

    /**
     * 
     * @param isPublic
     *     The isPublic
     */
    @JsonProperty("isPublic")
    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    /**
     * 
     * @return
     *     The canEscalate
     */
    @JsonProperty("canEscalate")
    public Boolean getCanEscalate() {
        return canEscalate;
    }

    /**
     * 
     * @param canEscalate
     *     The canEscalate
     */
    @JsonProperty("canEscalate")
    public void setCanEscalate(Boolean canEscalate) {
        this.canEscalate = canEscalate;
    }

    /**
     * 
     * @return
     *     The notes
     */
    @JsonProperty("notes")
    public List<Note> getNotes() {
        return notes;
    }

    /**
     * 
     * @param notes
     *     The notes
     */
    @JsonProperty("notes")
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    /**
     * 
     * @return
     *     The ticketCustomFields
     */
    @JsonProperty("ticketCustomFields")
    public List<TicketCustomField> getTicketCustomFields() {
        return ticketCustomFields;
    }

    /**
     * 
     * @param ticketCustomFields
     *     The ticketCustomFields
     */
    @JsonProperty("ticketCustomFields")
    public void setTicketCustomFields(List<TicketCustomField> ticketCustomFields) {
        this.ticketCustomFields = ticketCustomFields;
    }

    /**
     * 
     * @return
     *     The enabledStatusTypes
     */
    @JsonProperty("enabledStatusTypes")
    public List<Statustype> getEnabledStatusTypes() {
        return enabledStatusTypes;
    }

    /**
     * 
     * @param enabledStatusTypes
     *     The enabledStatusTypes
     */
    @JsonProperty("enabledStatusTypes")
    public void setEnabledStatusTypes(List<Statustype> enabledStatusTypes) {
        this.enabledStatusTypes = enabledStatusTypes;
    }

    /**
     * 
     * @return
     *     The attachments
     */
    @JsonProperty("attachments")
    public List<Attachment> getAttachments() {
        return attachments;
    }

    /**
     * 
     * @param attachments
     *     The attachments
     */
    @JsonProperty("attachments")
    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
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

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(type).append(bccAddresses).append(ccAddressesForTech).append(departmentId).append(lastUpdated).append(locationId).append(priorityTypeId).append(room).append(statusTypeId).append(subject).append(clientReporter).append(clientTech).append(location).append(prioritytype).append(problemtype).append(statustype).append(techGroupLevel).append(detail).append(reportDateUtc).append(displayClient).append(emailClient).append(emailTech).append(emailTechGroupLevel).append(emailGroupManager).append(emailCc).append(emailBcc).append(needsApproval).append(ticketEditable).append(techId).append(levelNumber).append(clientId).append(flaggedByTech).append(isPublic).append(canEscalate).append(notes).append(ticketCustomFields).append(enabledStatusTypes).append(attachments).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WhdTicket) == false) {
            return false;
        }
        WhdTicket rhs = ((WhdTicket) other);
        return new EqualsBuilder().append(id, rhs.id).append(type, rhs.type).append(bccAddresses, rhs.bccAddresses).append(ccAddressesForTech, rhs.ccAddressesForTech).append(departmentId, rhs.departmentId).append(lastUpdated, rhs.lastUpdated).append(locationId, rhs.locationId).append(priorityTypeId, rhs.priorityTypeId).append(room, rhs.room).append(statusTypeId, rhs.statusTypeId).append(subject, rhs.subject).append(clientReporter, rhs.clientReporter).append(clientTech, rhs.clientTech).append(location, rhs.location).append(prioritytype, rhs.prioritytype).append(problemtype, rhs.problemtype).append(statustype, rhs.statustype).append(techGroupLevel, rhs.techGroupLevel).append(detail, rhs.detail).append(reportDateUtc, rhs.reportDateUtc).append(displayClient, rhs.displayClient).append(emailClient, rhs.emailClient).append(emailTech, rhs.emailTech).append(emailTechGroupLevel, rhs.emailTechGroupLevel).append(emailGroupManager, rhs.emailGroupManager).append(emailCc, rhs.emailCc).append(emailBcc, rhs.emailBcc).append(needsApproval, rhs.needsApproval).append(ticketEditable, rhs.ticketEditable).append(techId, rhs.techId).append(levelNumber, rhs.levelNumber).append(clientId, rhs.clientId).append(flaggedByTech, rhs.flaggedByTech).append(isPublic, rhs.isPublic).append(canEscalate, rhs.canEscalate).append(notes, rhs.notes).append(ticketCustomFields, rhs.ticketCustomFields).append(enabledStatusTypes, rhs.enabledStatusTypes).append(attachments, rhs.attachments).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
