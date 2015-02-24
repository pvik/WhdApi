
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
    "date",
    "isSolution",
    "prettyUpdatedString",
    "mobileNoteText",
    "isTechNote",
    "isHidden",
    "attachments"
})
public class Note {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("date")
    private String date;
    @JsonProperty("isSolution")
    private Boolean isSolution;
    @JsonProperty("prettyUpdatedString")
    private String prettyUpdatedString;
    @JsonProperty("mobileNoteText")
    private String mobileNoteText;
    @JsonProperty("isTechNote")
    private Boolean isTechNote;
    @JsonProperty("isHidden")
    private Boolean isHidden;
    @JsonProperty("attachments")
    private List<Attachment> attachments = new ArrayList<Attachment>();
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
     *     The date
     */
    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     The isSolution
     */
    @JsonProperty("isSolution")
    public Boolean getIsSolution() {
        return isSolution;
    }

    /**
     * 
     * @param isSolution
     *     The isSolution
     */
    @JsonProperty("isSolution")
    public void setIsSolution(Boolean isSolution) {
        this.isSolution = isSolution;
    }

    /**
     * 
     * @return
     *     The prettyUpdatedString
     */
    @JsonProperty("prettyUpdatedString")
    public String getPrettyUpdatedString() {
        return prettyUpdatedString;
    }

    /**
     * 
     * @param prettyUpdatedString
     *     The prettyUpdatedString
     */
    @JsonProperty("prettyUpdatedString")
    public void setPrettyUpdatedString(String prettyUpdatedString) {
        this.prettyUpdatedString = prettyUpdatedString;
    }

    /**
     * 
     * @return
     *     The mobileNoteText
     */
    @JsonProperty("mobileNoteText")
    public String getMobileNoteText() {
        return mobileNoteText;
    }

    /**
     * 
     * @param mobileNoteText
     *     The mobileNoteText
     */
    @JsonProperty("mobileNoteText")
    public void setMobileNoteText(String mobileNoteText) {
        this.mobileNoteText = mobileNoteText;
    }

    /**
     * 
     * @return
     *     The isTechNote
     */
    @JsonProperty("isTechNote")
    public Boolean getIsTechNote() {
        return isTechNote;
    }

    /**
     * 
     * @param isTechNote
     *     The isTechNote
     */
    @JsonProperty("isTechNote")
    public void setIsTechNote(Boolean isTechNote) {
        this.isTechNote = isTechNote;
    }

    /**
     * 
     * @return
     *     The isHidden
     */
    @JsonProperty("isHidden")
    public Boolean getIsHidden() {
        return isHidden;
    }

    /**
     * 
     * @param isHidden
     *     The isHidden
     */
    @JsonProperty("isHidden")
    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    /**
     * 
     * @return
     *     The attachments
     */
    @JsonProperty("attachments")
    public List<Attachment> getAttachments() {
        return attachments;
    }

    /**
     * 
     * @param attachments
     *     The attachments
     */
    @JsonProperty("attachments")
    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
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
        return new HashCodeBuilder().append(id).append(type).append(date).append(isSolution).append(prettyUpdatedString).append(mobileNoteText).append(isTechNote).append(isHidden).append(attachments).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Note) == false) {
            return false;
        }
        Note rhs = ((Note) other);
        return new EqualsBuilder().append(id, rhs.id).append(type, rhs.type).append(date, rhs.date).append(isSolution, rhs.isSolution).append(prettyUpdatedString, rhs.prettyUpdatedString).append(mobileNoteText, rhs.mobileNoteText).append(isTechNote, rhs.isTechNote).append(isHidden, rhs.isHidden).append(attachments, rhs.attachments).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
