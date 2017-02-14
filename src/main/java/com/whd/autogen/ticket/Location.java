
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
    "address",
    "city",
    "locationName",
    "postalCode",
    "state",
    "priorityTypes",
    "defaultPriorityTypeId"
})
public class Location implements Serializable
{

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("address")
    private String address;
    @JsonProperty("city")
    private String city;
    @JsonProperty("locationName")
    private String locationName;
    @JsonProperty("postalCode")
    private String postalCode;
    @JsonProperty("state")
    private String state;
    @JsonProperty("priorityTypes")
    private List<Object> priorityTypes = new ArrayList<Object>();
    @JsonProperty("defaultPriorityTypeId")
    private Integer defaultPriorityTypeId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -3153781237621026958L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Location() {
    }

    /**
     * 
     * @param address
     * @param locationName
     * @param defaultPriorityTypeId
     * @param city
     * @param postalCode
     * @param id
     * @param state
     * @param priorityTypes
     * @param type
     */
    public Location(Integer id, String type, String address, String city, String locationName, String postalCode, String state, List<Object> priorityTypes, Integer defaultPriorityTypeId) {
        super();
        this.id = id;
        this.type = type;
        this.address = address;
        this.city = city;
        this.locationName = locationName;
        this.postalCode = postalCode;
        this.state = state;
        this.priorityTypes = priorityTypes;
        this.defaultPriorityTypeId = defaultPriorityTypeId;
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

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("locationName")
    public String getLocationName() {
        return locationName;
    }

    @JsonProperty("locationName")
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @JsonProperty("postalCode")
    public String getPostalCode() {
        return postalCode;
    }

    @JsonProperty("postalCode")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("priorityTypes")
    public List<Object> getPriorityTypes() {
        return priorityTypes;
    }

    @JsonProperty("priorityTypes")
    public void setPriorityTypes(List<Object> priorityTypes) {
        this.priorityTypes = priorityTypes;
    }

    @JsonProperty("defaultPriorityTypeId")
    public Integer getDefaultPriorityTypeId() {
        return defaultPriorityTypeId;
    }

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
        return new HashCodeBuilder().append(id).append(type).append(address).append(city).append(locationName).append(postalCode).append(state).append(priorityTypes).append(defaultPriorityTypeId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Location) == false) {
            return false;
        }
        Location rhs = ((Location) other);
        return new EqualsBuilder().append(id, rhs.id).append(type, rhs.type).append(address, rhs.address).append(city, rhs.city).append(locationName, rhs.locationName).append(postalCode, rhs.postalCode).append(state, rhs.state).append(priorityTypes, rhs.priorityTypes).append(defaultPriorityTypeId, rhs.defaultPriorityTypeId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
