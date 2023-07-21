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
    "statusTypeName"
})
public class StatusTypeDefinition {
    
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("statusTypeName")
    private String statusTypeName;
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
    
    public StatusTypeDefinition withId(Integer id) {
        this.id = id;
        return this;
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
    
    public StatusTypeDefinition withType(String type) {
        this.type = type;
        return this;
    }
    
    /**
     *
     * @return
     * The statusTypeName
     */
    @JsonProperty("statusTypeName")
    public String getStatusTypeName() {
        return statusTypeName;
    }
    
    /**
     *
     * @param statusTypeName
     * The statusTypeName
     */
    @JsonProperty("statusTypeName")
    public void setStatusTypeName(String statusTypeName) {
        this.statusTypeName = statusTypeName;
    }
    
    public StatusTypeDefinition withStatusTypeName(String statusTypeName) {
        this.statusTypeName = statusTypeName;
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
    
    public StatusTypeDefinition withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(type).append(statusTypeName).append(additionalProperties).toHashCode();
    }
    
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StatusTypeDefinition) == false) {
            return false;
        }
        StatusTypeDefinition rhs = ((StatusTypeDefinition) other);
        return new EqualsBuilder().append(id, rhs.id).append(type, rhs.type).append(statusTypeName, rhs.statusTypeName).append(additionalProperties, rhs.additionalProperties).isEquals();
    }
    
}