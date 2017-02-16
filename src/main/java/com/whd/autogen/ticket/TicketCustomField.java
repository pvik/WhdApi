
package com.whd.autogen.ticket;

import java.io.Serializable;
import java.util.HashMap;
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
    "type",
    "definitionId",
    "restValue"
})
public class TicketCustomField implements Serializable
{

    @JsonProperty("type")
    private String type;
    @JsonProperty("definitionId")
    private Integer definitionId;
    @JsonProperty("restValue")
    private String restValue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6867983532954439448L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TicketCustomField() {
    }

    /**
     * 
     * @param restValue
     * @param type
     * @param definitionId
     */
    public TicketCustomField(String type, Integer definitionId, String restValue) {
        super();
        this.type = type;
        this.definitionId = definitionId;
        this.restValue = restValue;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("definitionId")
    public Integer getDefinitionId() {
        return definitionId;
    }

    @JsonProperty("definitionId")
    public void setDefinitionId(Integer definitionId) {
        this.definitionId = definitionId;
    }

    @JsonProperty("restValue")
    public String getRestValue() {
        return restValue;
    }

    @JsonProperty("restValue")
    public void setRestValue(String restValue) {
        this.restValue = restValue;
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
        return new HashCodeBuilder().append(type).append(definitionId).append(restValue).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TicketCustomField) == false) {
            return false;
        }
        TicketCustomField rhs = ((TicketCustomField) other);
        return new EqualsBuilder().append(type, rhs.type).append(definitionId, rhs.definitionId).append(restValue, rhs.restValue).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
