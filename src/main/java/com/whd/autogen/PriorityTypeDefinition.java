package com.whd.autogen;

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
    "id",
    "type",
    "priorityTypeName",
    "dueTimeMinutes",
    "alertReminderMinutes",
    "clientReminderMinutes"
})
public class PriorityTypeDefinition {
    
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("priorityTypeName")
    private String priorityTypeName;
    @JsonProperty("dueTimeMinutes")
    private Integer dueTimeMinutes;
    @JsonProperty("alertReminderMinutes")
    private Integer alertReminderMinutes;
    @JsonProperty("clientReminderMinutes")
    private Integer clientReminderMinutes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    /**
     *
     * @return
     * The id
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }
    
    /**
     *
     * @param id
     * The id
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     *
     * @return
     * The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }
    
    /**
     *
     * @param type
     * The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     *
     * @return
     * The priorityTypeName
     */
    @JsonProperty("priorityTypeName")
    public String getPriorityTypeName() {
        return priorityTypeName;
    }
    
    /**
     *
     * @param priorityTypeName
     * The priorityTypeName
     */
    @JsonProperty("priorityTypeName")
    public void setPriorityTypeName(String priorityTypeName) {
        this.priorityTypeName = priorityTypeName;
    }
    
    /**
     *
     * @return
     * The dueTimeMinutes
     */
    @JsonProperty("dueTimeMinutes")
    public Integer getDueTimeMinutes() {
        return dueTimeMinutes;
    }
    
    /**
     *
     * @param dueTimeMinutes
     * The dueTimeMinutes
     */
    @JsonProperty("dueTimeMinutes")
    public void setDueTimeMinutes(Integer dueTimeMinutes) {
        this.dueTimeMinutes = dueTimeMinutes;
    }
    
    /**
     *
     * @return
     * The alertReminderMinutes
     */
    @JsonProperty("alertReminderMinutes")
    public Integer getAlertReminderMinutes() {
        return alertReminderMinutes;
    }
    
    /**
     *
     * @param alertReminderMinutes
     * The alertReminderMinutes
     */
    @JsonProperty("alertReminderMinutes")
    public void setAlertReminderMinutes(Integer alertReminderMinutes) {
        this.alertReminderMinutes = alertReminderMinutes;
    }
    
    /**
     *
     * @return
     * The clientReminderMinutes
     */
    @JsonProperty("clientReminderMinutes")
    public Integer getClientReminderMinutes() {
        return clientReminderMinutes;
    }
    
    /**
     *
     * @param clientReminderMinutes
     * The clientReminderMinutes
     */
    @JsonProperty("clientReminderMinutes")
    public void setClientReminderMinutes(Integer clientReminderMinutes) {
        this.clientReminderMinutes = clientReminderMinutes;
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
        return new HashCodeBuilder().append(id).append(type).append(priorityTypeName).append(dueTimeMinutes).append(alertReminderMinutes).append(clientReminderMinutes).append(additionalProperties).toHashCode();
    }
    
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PriorityTypeDefinition) == false) {
            return false;
        }
        PriorityTypeDefinition rhs = ((PriorityTypeDefinition) other);
        return new EqualsBuilder().append(id, rhs.id).append(type, rhs.type).append(priorityTypeName, rhs.priorityTypeName).append(dueTimeMinutes, rhs.dueTimeMinutes).append(alertReminderMinutes, rhs.alertReminderMinutes).append(clientReminderMinutes, rhs.clientReminderMinutes).append(additionalProperties, rhs.additionalProperties).isEquals();
    }
    
}