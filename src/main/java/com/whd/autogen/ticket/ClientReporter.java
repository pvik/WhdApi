
package com.whd.autogen.ticket;

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
public class ClientReporter {

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
    private List<Note> notes = new ArrayList<Note>();
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

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

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
     *     The email
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return
     *     The firstName
     */
    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @param firstName
     *     The firstName
     */
    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * @return
     *     The lastName
     */
    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * @param lastName
     *     The lastName
     */
    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 
     * @return
     *     The notes
     */
    @JsonProperty("notes")
    public List<Note> getNotes() {
        return notes;
    }

    /**
     * 
     * @param notes
     *     The notes
     */
    @JsonProperty("notes")
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    /**
     * 
     * @return
     *     The phone
     */
    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    /**
     * 
     * @param phone
     *     The phone
     */
    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 
     * @return
     *     The phone2
     */
    @JsonProperty("phone2")
    public String getPhone2() {
        return phone2;
    }

    /**
     * 
     * @param phone2
     *     The phone2
     */
    @JsonProperty("phone2")
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    /**
     * 
     * @return
     *     The department
     */
    @JsonProperty("department")
    public String getDepartment() {
        return department;
    }

    /**
     * 
     * @param department
     *     The department
     */
    @JsonProperty("department")
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 
     * @return
     *     The location
     */
    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * 
     * @return
     *     The room
     */
    @JsonProperty("room")
    public String getRoom() {
        return room;
    }

    /**
     * 
     * @param room
     *     The room
     */
    @JsonProperty("room")
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * 
     * @return
     *     The companyName
     */
    @JsonProperty("companyName")
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 
     * @param companyName
     *     The companyName
     */
    @JsonProperty("companyName")
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 
     * @return
     *     The username
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *     The username
     */
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
