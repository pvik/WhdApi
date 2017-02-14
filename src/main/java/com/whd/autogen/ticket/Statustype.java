
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
    "id",
    "type",
    "statusTypeName"
})
public class Statustype implements Serializable
{

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("statusTypeName")
    private String statusTypeName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -4611561229955034674L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Statustype() {
    }

    /**
     * 
     * @param statusTypeName
     * @param id
     * @param type
     */
    public Statustype(Integer id, String type, String statusTypeName) {
        super();
        this.id = id;
        this.type = type;
        this.statusTypeName = statusTypeName;
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

    @JsonProperty("statusTypeName")
    public String getStatusTypeName() {
        return statusTypeName;
    }

    @JsonProperty("statusTypeName")
    public void setStatusTypeName(String statusTypeName) {
        this.statusTypeName = statusTypeName;
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
        return new HashCodeBuilder().append(id).append(type).append(statusTypeName).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Statustype) == false) {
            return false;
        }
        Statustype rhs = ((Statustype) other);
        return new EqualsBuilder().append(id, rhs.id).append(type, rhs.type).append(statusTypeName, rhs.statusTypeName).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
