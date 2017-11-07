package com.whd.autogen.note.response;

/**
 * Created by vikramp on 11/6/17.
 */
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
        "date",
        "noteText",
        "jobticket"
})
public class WhdNoteResponse {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("date")
    private String date;
    @JsonProperty("noteText")
    private String noteText;
    @JsonProperty("jobticket")
    private Jobticket jobticket;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public WhdNoteResponse withId(Integer id) {
        this.id = id;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public WhdNoteResponse withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    public WhdNoteResponse withDate(String date) {
        this.date = date;
        return this;
    }

    @JsonProperty("noteText")
    public String getNoteText() {
        return noteText;
    }

    @JsonProperty("noteText")
    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public WhdNoteResponse withNoteText(String noteText) {
        this.noteText = noteText;
        return this;
    }

    @JsonProperty("jobticket")
    public Jobticket getJobticket() {
        return jobticket;
    }

    @JsonProperty("jobticket")
    public void setJobticket(Jobticket jobticket) {
        this.jobticket = jobticket;
    }

    public WhdNoteResponse withJobticket(Jobticket jobticket) {
        this.jobticket = jobticket;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public WhdNoteResponse withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("type", type).append("date", date).append("noteText", noteText).append("jobticket", jobticket).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(noteText).append(additionalProperties).append(jobticket).append(date).append(type).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WhdNoteResponse) == false) {
            return false;
        }
        WhdNoteResponse rhs = ((WhdNoteResponse) other);
        return new EqualsBuilder().append(id, rhs.id).append(noteText, rhs.noteText).append(additionalProperties, rhs.additionalProperties).append(jobticket, rhs.jobticket).append(date, rhs.date).append(type, rhs.type).isEquals();
    }

}