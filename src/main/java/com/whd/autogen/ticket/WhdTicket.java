
package com.whd.autogen.ticket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
    "attachments",
    "customField_18",
    "customField_14",
    "customField_15",
    "customField_122",
    "customField_123",
    "customField_23",
    "customField_24",
    "customField_125",
    "customField_121"
})
public class WhdTicket implements Serializable
{

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
    @JsonProperty("customField_18")
    private String customField18;
    @JsonProperty("customField_14")
    private String customField14;
    @JsonProperty("customField_15")
    private String customField15;
    @JsonProperty("customField_122")
    private String customField122;
    @JsonProperty("customField_123")
    private String customField123;
    @JsonProperty("customField_23")
    private String customField23;
    @JsonProperty("customField_24")
    private String customField24;
    @JsonProperty("customField_125")
    private String customField125;
    @JsonProperty("customField_121")
    private String customField121;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -4691383693187563913L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public WhdTicket() {
    }

    /**
     * 
     * @param emailCc
     * @param customField125
     * @param customField122
     * @param notes
     * @param attachments
     * @param customField123
     * @param customField23
     * @param priorityTypeId
     * @param customField24
     * @param subject
     * @param techGroupLevel
     * @param departmentId
     * @param statusTypeId
     * @param problemtype
     * @param needsApproval
     * @param type
     * @param customField121
     * @param displayClient
     * @param enabledStatusTypes
     * @param ticketEditable
     * @param lastUpdated
     * @param reportDateUtc
     * @param locationId
     * @param clientReporter
     * @param levelNumber
     * @param isPublic
     * @param id
     * @param emailBcc
     * @param flaggedByTech
     * @param canEscalate
     * @param customField14
     * @param clientId
     * @param customField15
     * @param ccAddressesForTech
     * @param emailClient
     * @param emailGroupManager
     * @param ticketCustomFields
     * @param bccAddresses
     * @param emailTechGroupLevel
     * @param room
     * @param emailTech
     * @param clientTech
     * @param location
     * @param statustype
     * @param detail
     * @param techId
     * @param customField18
     * @param prioritytype
     */
    public WhdTicket(Integer id, String type, String bccAddresses, String ccAddressesForTech, Integer departmentId, String lastUpdated, Integer locationId, Integer priorityTypeId, String room, Integer statusTypeId, String subject, ClientReporter clientReporter, ClientTech clientTech, Location location, Prioritytype prioritytype, Problemtype problemtype, Statustype statustype, TechGroupLevel techGroupLevel, String detail, String reportDateUtc, String displayClient, Boolean emailClient, Boolean emailTech, Boolean emailTechGroupLevel, Boolean emailGroupManager, Boolean emailCc, Boolean emailBcc, Boolean needsApproval, Boolean ticketEditable, Integer techId, String levelNumber, Integer clientId, Boolean flaggedByTech, Boolean isPublic, Boolean canEscalate, List<Note> notes, List<TicketCustomField> ticketCustomFields, List<Statustype> enabledStatusTypes, List<Attachment> attachments, String customField18, String customField14, String customField15, String customField122, String customField123, String customField23, String customField24, String customField125, String customField121) {
        super();
        this.id = id;
        this.type = type;
        this.bccAddresses = bccAddresses;
        this.ccAddressesForTech = ccAddressesForTech;
        this.departmentId = departmentId;
        this.lastUpdated = lastUpdated;
        this.locationId = locationId;
        this.priorityTypeId = priorityTypeId;
        this.room = room;
        this.statusTypeId = statusTypeId;
        this.subject = subject;
        this.clientReporter = clientReporter;
        this.clientTech = clientTech;
        this.location = location;
        this.prioritytype = prioritytype;
        this.problemtype = problemtype;
        this.statustype = statustype;
        this.techGroupLevel = techGroupLevel;
        this.detail = detail;
        this.reportDateUtc = reportDateUtc;
        this.displayClient = displayClient;
        this.emailClient = emailClient;
        this.emailTech = emailTech;
        this.emailTechGroupLevel = emailTechGroupLevel;
        this.emailGroupManager = emailGroupManager;
        this.emailCc = emailCc;
        this.emailBcc = emailBcc;
        this.needsApproval = needsApproval;
        this.ticketEditable = ticketEditable;
        this.techId = techId;
        this.levelNumber = levelNumber;
        this.clientId = clientId;
        this.flaggedByTech = flaggedByTech;
        this.isPublic = isPublic;
        this.canEscalate = canEscalate;
        this.notes = notes;
        this.ticketCustomFields = ticketCustomFields;
        this.enabledStatusTypes = enabledStatusTypes;
        this.attachments = attachments;
        this.customField18 = customField18;
        this.customField14 = customField14;
        this.customField15 = customField15;
        this.customField122 = customField122;
        this.customField123 = customField123;
        this.customField23 = customField23;
        this.customField24 = customField24;
        this.customField125 = customField125;
        this.customField121 = customField121;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("bccAddresses")
    public String getBccAddresses() {
        return bccAddresses;
    }

    @JsonProperty("bccAddresses")
    public void setBccAddresses(String bccAddresses) {
        this.bccAddresses = bccAddresses;
    }

    @JsonProperty("ccAddressesForTech")
    public String getCcAddressesForTech() {
        return ccAddressesForTech;
    }

    @JsonProperty("ccAddressesForTech")
    public void setCcAddressesForTech(String ccAddressesForTech) {
        this.ccAddressesForTech = ccAddressesForTech;
    }

    @JsonProperty("departmentId")
    public Integer getDepartmentId() {
        return departmentId;
    }

    @JsonProperty("departmentId")
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @JsonProperty("lastUpdated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    @JsonProperty("lastUpdated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @JsonProperty("locationId")
    public Integer getLocationId() {
        return locationId;
    }

    @JsonProperty("locationId")
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    @JsonProperty("priorityTypeId")
    public Integer getPriorityTypeId() {
        return priorityTypeId;
    }

    @JsonProperty("priorityTypeId")
    public void setPriorityTypeId(Integer priorityTypeId) {
        this.priorityTypeId = priorityTypeId;
    }

    @JsonProperty("room")
    public String getRoom() {
        return room;
    }

    @JsonProperty("room")
    public void setRoom(String room) {
        this.room = room;
    }

    @JsonProperty("statusTypeId")
    public Integer getStatusTypeId() {
        return statusTypeId;
    }

    @JsonProperty("statusTypeId")
    public void setStatusTypeId(Integer statusTypeId) {
        this.statusTypeId = statusTypeId;
    }

    @JsonProperty("subject")
    public String getSubject() {
        return subject;
    }

    @JsonProperty("subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @JsonProperty("clientReporter")
    public ClientReporter getClientReporter() {
        return clientReporter;
    }

    @JsonProperty("clientReporter")
    public void setClientReporter(ClientReporter clientReporter) {
        this.clientReporter = clientReporter;
    }

    @JsonProperty("clientTech")
    public ClientTech getClientTech() {
        return clientTech;
    }

    @JsonProperty("clientTech")
    public void setClientTech(ClientTech clientTech) {
        this.clientTech = clientTech;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("prioritytype")
    public Prioritytype getPrioritytype() {
        return prioritytype;
    }

    @JsonProperty("prioritytype")
    public void setPrioritytype(Prioritytype prioritytype) {
        this.prioritytype = prioritytype;
    }

    @JsonProperty("problemtype")
    public Problemtype getProblemtype() {
        return problemtype;
    }

    @JsonProperty("problemtype")
    public void setProblemtype(Problemtype problemtype) {
        this.problemtype = problemtype;
    }

    @JsonProperty("statustype")
    public Statustype getStatustype() {
        return statustype;
    }

    @JsonProperty("statustype")
    public void setStatustype(Statustype statustype) {
        this.statustype = statustype;
    }

    @JsonProperty("techGroupLevel")
    public TechGroupLevel getTechGroupLevel() {
        return techGroupLevel;
    }

    @JsonProperty("techGroupLevel")
    public void setTechGroupLevel(TechGroupLevel techGroupLevel) {
        this.techGroupLevel = techGroupLevel;
    }

    @JsonProperty("detail")
    public String getDetail() {
        return detail;
    }

    @JsonProperty("detail")
    public void setDetail(String detail) {
        this.detail = detail;
    }

    @JsonProperty("reportDateUtc")
    public String getReportDateUtc() {
        return reportDateUtc;
    }

    @JsonProperty("reportDateUtc")
    public void setReportDateUtc(String reportDateUtc) {
        this.reportDateUtc = reportDateUtc;
    }

    @JsonProperty("displayClient")
    public String getDisplayClient() {
        return displayClient;
    }

    @JsonProperty("displayClient")
    public void setDisplayClient(String displayClient) {
        this.displayClient = displayClient;
    }

    @JsonProperty("emailClient")
    public Boolean getEmailClient() {
        return emailClient;
    }

    @JsonProperty("emailClient")
    public void setEmailClient(Boolean emailClient) {
        this.emailClient = emailClient;
    }

    @JsonProperty("emailTech")
    public Boolean getEmailTech() {
        return emailTech;
    }

    @JsonProperty("emailTech")
    public void setEmailTech(Boolean emailTech) {
        this.emailTech = emailTech;
    }

    @JsonProperty("emailTechGroupLevel")
    public Boolean getEmailTechGroupLevel() {
        return emailTechGroupLevel;
    }

    @JsonProperty("emailTechGroupLevel")
    public void setEmailTechGroupLevel(Boolean emailTechGroupLevel) {
        this.emailTechGroupLevel = emailTechGroupLevel;
    }

    @JsonProperty("emailGroupManager")
    public Boolean getEmailGroupManager() {
        return emailGroupManager;
    }

    @JsonProperty("emailGroupManager")
    public void setEmailGroupManager(Boolean emailGroupManager) {
        this.emailGroupManager = emailGroupManager;
    }

    @JsonProperty("emailCc")
    public Boolean getEmailCc() {
        return emailCc;
    }

    @JsonProperty("emailCc")
    public void setEmailCc(Boolean emailCc) {
        this.emailCc = emailCc;
    }

    @JsonProperty("emailBcc")
    public Boolean getEmailBcc() {
        return emailBcc;
    }

    @JsonProperty("emailBcc")
    public void setEmailBcc(Boolean emailBcc) {
        this.emailBcc = emailBcc;
    }

    @JsonProperty("needsApproval")
    public Boolean getNeedsApproval() {
        return needsApproval;
    }

    @JsonProperty("needsApproval")
    public void setNeedsApproval(Boolean needsApproval) {
        this.needsApproval = needsApproval;
    }

    @JsonProperty("ticketEditable")
    public Boolean getTicketEditable() {
        return ticketEditable;
    }

    @JsonProperty("ticketEditable")
    public void setTicketEditable(Boolean ticketEditable) {
        this.ticketEditable = ticketEditable;
    }

    @JsonProperty("techId")
    public Integer getTechId() {
        return techId;
    }

    @JsonProperty("techId")
    public void setTechId(Integer techId) {
        this.techId = techId;
    }

    @JsonProperty("levelNumber")
    public String getLevelNumber() {
        return levelNumber;
    }

    @JsonProperty("levelNumber")
    public void setLevelNumber(String levelNumber) {
        this.levelNumber = levelNumber;
    }

    @JsonProperty("clientId")
    public Integer getClientId() {
        return clientId;
    }

    @JsonProperty("clientId")
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @JsonProperty("flaggedByTech")
    public Boolean getFlaggedByTech() {
        return flaggedByTech;
    }

    @JsonProperty("flaggedByTech")
    public void setFlaggedByTech(Boolean flaggedByTech) {
        this.flaggedByTech = flaggedByTech;
    }

    @JsonProperty("isPublic")
    public Boolean getIsPublic() {
        return isPublic;
    }

    @JsonProperty("isPublic")
    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    @JsonProperty("canEscalate")
    public Boolean getCanEscalate() {
        return canEscalate;
    }

    @JsonProperty("canEscalate")
    public void setCanEscalate(Boolean canEscalate) {
        this.canEscalate = canEscalate;
    }

    @JsonProperty("notes")
    public List<Note> getNotes() {
        return notes;
    }

    @JsonProperty("notes")
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @JsonProperty("ticketCustomFields")
    public List<TicketCustomField> getTicketCustomFields() {
        return ticketCustomFields;
    }

    @JsonProperty("ticketCustomFields")
    public void setTicketCustomFields(List<TicketCustomField> ticketCustomFields) {
        this.ticketCustomFields = ticketCustomFields;
    }

    @JsonProperty("enabledStatusTypes")
    public List<Statustype> getEnabledStatusTypes() {
        return enabledStatusTypes;
    }

    @JsonProperty("enabledStatusTypes")
    public void setEnabledStatusTypes(List<Statustype> enabledStatusTypes) {
        this.enabledStatusTypes = enabledStatusTypes;
    }

    @JsonProperty("attachments")
    public List<Attachment> getAttachments() {
        return attachments;
    }

    @JsonProperty("attachments")
    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    @JsonProperty("customField_18")
    public String getCustomField18() {
        return customField18;
    }

    @JsonProperty("customField_18")
    public void setCustomField18(String customField18) {
        this.customField18 = customField18;
    }

    @JsonProperty("customField_14")
    public String getCustomField14() {
        return customField14;
    }

    @JsonProperty("customField_14")
    public void setCustomField14(String customField14) {
        this.customField14 = customField14;
    }

    @JsonProperty("customField_15")
    public String getCustomField15() {
        return customField15;
    }

    @JsonProperty("customField_15")
    public void setCustomField15(String customField15) {
        this.customField15 = customField15;
    }

    @JsonProperty("customField_122")
    public String getCustomField122() {
        return customField122;
    }

    @JsonProperty("customField_122")
    public void setCustomField122(String customField122) {
        this.customField122 = customField122;
    }

    @JsonProperty("customField_123")
    public String getCustomField123() {
        return customField123;
    }

    @JsonProperty("customField_123")
    public void setCustomField123(String customField123) {
        this.customField123 = customField123;
    }

    @JsonProperty("customField_23")
    public String getCustomField23() {
        return customField23;
    }

    @JsonProperty("customField_23")
    public void setCustomField23(String customField23) {
        this.customField23 = customField23;
    }

    @JsonProperty("customField_24")
    public String getCustomField24() {
        return customField24;
    }

    @JsonProperty("customField_24")
    public void setCustomField24(String customField24) {
        this.customField24 = customField24;
    }

    @JsonProperty("customField_125")
    public String getCustomField125() {
        return customField125;
    }

    @JsonProperty("customField_125")
    public void setCustomField125(String customField125) {
        this.customField125 = customField125;
    }

    @JsonProperty("customField_121")
    public String getCustomField121() {
        return customField121;
    }

    @JsonProperty("customField_121")
    public void setCustomField121(String customField121) {
        this.customField121 = customField121;
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
        return new HashCodeBuilder().append(id).append(type).append(bccAddresses).append(ccAddressesForTech).append(departmentId).append(lastUpdated).append(locationId).append(priorityTypeId).append(room).append(statusTypeId).append(subject).append(clientReporter).append(clientTech).append(location).append(prioritytype).append(problemtype).append(statustype).append(techGroupLevel).append(detail).append(reportDateUtc).append(displayClient).append(emailClient).append(emailTech).append(emailTechGroupLevel).append(emailGroupManager).append(emailCc).append(emailBcc).append(needsApproval).append(ticketEditable).append(techId).append(levelNumber).append(clientId).append(flaggedByTech).append(isPublic).append(canEscalate).append(notes).append(ticketCustomFields).append(enabledStatusTypes).append(attachments).append(customField18).append(customField14).append(customField15).append(customField122).append(customField123).append(customField23).append(customField24).append(customField125).append(customField121).append(additionalProperties).toHashCode();
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
        return new EqualsBuilder().append(id, rhs.id).append(type, rhs.type).append(bccAddresses, rhs.bccAddresses).append(ccAddressesForTech, rhs.ccAddressesForTech).append(departmentId, rhs.departmentId).append(lastUpdated, rhs.lastUpdated).append(locationId, rhs.locationId).append(priorityTypeId, rhs.priorityTypeId).append(room, rhs.room).append(statusTypeId, rhs.statusTypeId).append(subject, rhs.subject).append(clientReporter, rhs.clientReporter).append(clientTech, rhs.clientTech).append(location, rhs.location).append(prioritytype, rhs.prioritytype).append(problemtype, rhs.problemtype).append(statustype, rhs.statustype).append(techGroupLevel, rhs.techGroupLevel).append(detail, rhs.detail).append(reportDateUtc, rhs.reportDateUtc).append(displayClient, rhs.displayClient).append(emailClient, rhs.emailClient).append(emailTech, rhs.emailTech).append(emailTechGroupLevel, rhs.emailTechGroupLevel).append(emailGroupManager, rhs.emailGroupManager).append(emailCc, rhs.emailCc).append(emailBcc, rhs.emailBcc).append(needsApproval, rhs.needsApproval).append(ticketEditable, rhs.ticketEditable).append(techId, rhs.techId).append(levelNumber, rhs.levelNumber).append(clientId, rhs.clientId).append(flaggedByTech, rhs.flaggedByTech).append(isPublic, rhs.isPublic).append(canEscalate, rhs.canEscalate).append(notes, rhs.notes).append(ticketCustomFields, rhs.ticketCustomFields).append(enabledStatusTypes, rhs.enabledStatusTypes).append(attachments, rhs.attachments).append(customField18, rhs.customField18).append(customField14, rhs.customField14).append(customField15, rhs.customField15).append(customField122, rhs.customField122).append(customField123, rhs.customField123).append(customField23, rhs.customField23).append(customField24, rhs.customField24).append(customField125, rhs.customField125).append(customField121, rhs.customField121).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
