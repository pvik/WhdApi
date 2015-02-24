
package com.whd.autogen.session;

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
    "sessionKey",
    "instanceId",
    "currentTechId"
})
public class Session {

    @JsonProperty("type")
    private String type;
    @JsonProperty("sessionKey")
    private String sessionKey;
    @JsonProperty("instanceId")
    private Integer instanceId;
    @JsonProperty("currentTechId")
    private Integer currentTechId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The sessionKey
     */
    @JsonProperty("sessionKey")
    public String getSessionKey() {
        return sessionKey;
    }

    /**
     * 
     * @param sessionKey
     *     The sessionKey
     */
    @JsonProperty("sessionKey")
    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    /**
     * 
     * @return
     *     The instanceId
     */
    @JsonProperty("instanceId")
    public Integer getInstanceId() {
        return instanceId;
    }

    /**
     * 
     * @param instanceId
     *     The instanceId
     */
    @JsonProperty("instanceId")
    public void setInstanceId(Integer instanceId) {
        this.instanceId = instanceId;
    }

    /**
     * 
     * @return
     *     The currentTechId
     */
    @JsonProperty("currentTechId")
    public Integer getCurrentTechId() {
        return currentTechId;
    }

    /**
     * 
     * @param currentTechId
     *     The currentTechId
     */
    @JsonProperty("currentTechId")
    public void setCurrentTechId(Integer currentTechId) {
        this.currentTechId = currentTechId;
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
        return new HashCodeBuilder().append(type).append(sessionKey).append(instanceId).append(currentTechId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Session) == false) {
            return false;
        }
        Session rhs = ((Session) other);
        return new EqualsBuilder().append(type, rhs.type).append(sessionKey, rhs.sessionKey).append(instanceId, rhs.instanceId).append(currentTechId, rhs.currentTechId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
