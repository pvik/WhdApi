
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
    "email",
    "firstName",
    "lastName",
    "notes",
    "phone",
    "phone2",
    "department",
    "location",
    "room",
    "companyName",
    "username"
})
public class ClientReporter implements Serializable
{

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("email")
    private String email;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("notes")
    private String notes;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("phone2")
    private String phone2;
    @JsonProperty("department")
    private String department;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("room")
    private String room;
    @JsonProperty("companyName")
    private String companyName;
    @JsonProperty("username")
    private String username;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 5554412102378027933L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClientReporter() {
    }

    /**
     * 
     * @param lastName
     * @param notes
     * @param companyName
     * @param phone2
     * @param type
     * @param room
     * @param firstName
     * @param phone
     * @param location
     * @param id
     * @param department
     * @param email
     * @param username
     */
    public ClientReporter(Integer id, String type, String email, String firstName, String lastName, String notes, String phone, String phone2, String department, Location location, String room, String companyName, String username) {
        super();
        this.id = id;
        this.type = type;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.notes = notes;
        this.phone = phone;
        this.phone2 = phone2;
        this.department = department;
        this.location = location;
        this.room = room;
        this.companyName = companyName;
        this.username = username;
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

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("notes")
    public String getNotes() {
        return notes;
    }

    @JsonProperty("notes")
    public void setNotes(String notes) {
        this.notes = notes;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("phone2")
    public String getPhone2() {
        return phone2;
    }

    @JsonProperty("phone2")
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    @JsonProperty("department")
    public String getDepartment() {
        return department;
    }

    @JsonProperty("department")
    public void setDepartment(String department) {
        this.department = department;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("room")
    public String getRoom() {
        return room;
    }

    @JsonProperty("room")
    public void setRoom(String room) {
        this.room = room;
    }

    @JsonProperty("companyName")
    public String getCompanyName() {
        return companyName;
    }

    @JsonProperty("companyName")
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
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
        return new HashCodeBuilder().append(id).append(type).append(email).append(firstName).append(lastName).append(notes).append(phone).append(phone2).append(department).append(location).append(room).append(companyName).append(username).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ClientReporter) == false) {
            return false;
        }
        ClientReporter rhs = ((ClientReporter) other);
        return new EqualsBuilder().append(id, rhs.id).append(type, rhs.type).append(email, rhs.email).append(firstName, rhs.firstName).append(lastName, rhs.lastName).append(notes, rhs.notes).append(phone, rhs.phone).append(phone2, rhs.phone2).append(department, rhs.department).append(location, rhs.location).append(room, rhs.room).append(companyName, rhs.companyName).append(username, rhs.username).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
