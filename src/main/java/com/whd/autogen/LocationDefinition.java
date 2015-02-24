package com.whd.autogen;

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
    "locationName",
    "priorityTypes",
    "defaultPriorityTypeId"
})
public class LocationDefinition {
    
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("locationName")
    private String locationName;
    @JsonProperty("priorityTypes")
    private List<Object> priorityTypes = new ArrayList<Object>();
    @JsonProperty("defaultPriorityTypeId")
    private Integer defaultPriorityTypeId;
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
     * The locationName
     */
    @JsonProperty("locationName")
    public String getLocationName() {
        return locationName;
    }
    
    /**
     *
     * @param locationName
     * The locationName
     */
    @JsonProperty("locationName")
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
    
    /**
     *
     * @return
     * The priorityTypes
     */
    @JsonProperty("priorityTypes")
    public List<Object> getPriorityTypes() {
        return priorityTypes;
    }
    
    /**
     *
     * @param priorityTypes
     * The priorityTypes
     */
    @JsonProperty("priorityTypes")
    public void setPriorityTypes(List<Object> priorityTypes) {
        this.priorityTypes = priorityTypes;
    }
    
    /**
     *
     * @return
     * The defaultPriorityTypeId
     */
    @JsonProperty("defaultPriorityTypeId")
    public Integer getDefaultPriorityTypeId() {
        return defaultPriorityTypeId;
    }
    
    /**
     *
     * @param defaultPriorityTypeId
     * The defaultPriorityTypeId
     */
    @JsonProperty("defaultPriorityTypeId")
    public void setDefaultPriorityTypeId(Integer defaultPriorityTypeId) {
        this.defaultPriorityTypeId = defaultPriorityTypeId;
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
        return new HashCodeBuilder().append(id).append(type).append(locationName).append(priorityTypes).append(defaultPriorityTypeId).append(additionalProperties).toHashCode();
    }
    
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LocationDefinition) == false) {
            return false;
        }
        LocationDefinition rhs = ((LocationDefinition) other);
        return new EqualsBuilder().append(id, rhs.id).append(type, rhs.type).append(locationName, rhs.locationName).append(priorityTypes, rhs.priorityTypes).append(defaultPriorityTypeId, rhs.defaultPriorityTypeId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }
    
}