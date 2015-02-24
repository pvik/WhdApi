
package com.whd.autogen.ticket;

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
    "type",
    "definitionId",
    "restValue"
})
public class TicketCustomField {

    //@JsonProperty("id")
    //private Integer id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("definitionId")
    private Integer definitionId;
    @JsonProperty("restValue")
    private String restValue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The id
     */
//    @JsonProperty("id")
//    public Integer getId() {
//        return id;
//    }
//
//    /**
//     * 
//     * @param id
//     *     The id
//     */
//    @JsonProperty("id")
//    public void setId(Integer id) {
//        this.id = id;
//    }

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
     *     The definitionId
     */
    @JsonProperty("definitionId")
    public Integer getDefinitionId() {
        return definitionId;
    }

    /**
     * 
     * @param definitionId
     *     The definitionId
     */
    @JsonProperty("definitionId")
    public void setDefinitionId(Integer definitionId) {
        this.definitionId = definitionId;
    }

    /**
     * 
     * @return
     *     The restValue
     */
    @JsonProperty("restValue")
    public String getRestValue() {
        return restValue;
    }

    /**
     * 
     * @param restValue
     *     The restValue
     */
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
        return new HashCodeBuilder()
                //.append(id)
                .append(type).append(definitionId).append(restValue).append(additionalProperties).toHashCode();
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
        return new EqualsBuilder()
                //.append(id, rhs.id)
                .append(type, rhs.type).append(definitionId, rhs.definitionId).append(restValue, rhs.restValue).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
