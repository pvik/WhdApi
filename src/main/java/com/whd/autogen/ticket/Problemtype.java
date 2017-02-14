
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
    "detailDisplayName"
})
public class Problemtype implements Serializable
{

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("detailDisplayName")
    private String detailDisplayName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 4023755094072321068L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Problemtype() {
    }

    /**
     * 
     * @param id
     * @param type
     * @param detailDisplayName
     */
    public Problemtype(Integer id, String type, String detailDisplayName) {
        super();
        this.id = id;
        this.type = type;
        this.detailDisplayName = detailDisplayName;
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

    @JsonProperty("detailDisplayName")
    public String getDetailDisplayName() {
        return detailDisplayName;
    }

    @JsonProperty("detailDisplayName")
    public void setDetailDisplayName(String detailDisplayName) {
        this.detailDisplayName = detailDisplayName;
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
        return new HashCodeBuilder().append(id).append(type).append(detailDisplayName).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Problemtype) == false) {
            return false;
        }
        Problemtype rhs = ((Problemtype) other);
        return new EqualsBuilder().append(id, rhs.id).append(type, rhs.type).append(detailDisplayName, rhs.detailDisplayName).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
