
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
    "fileName",
    "sizeString",
    "uploadDateUtc"
})
public class Attachment implements Serializable
{

    @JsonProperty("id")
    private Object id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("fileName")
    private String fileName;
    @JsonProperty("sizeString")
    private String sizeString;
    @JsonProperty("uploadDateUtc")
    private String uploadDateUtc;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 1288964902021687108L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Attachment() {
    }

    /**
     * 
     * @param fileName
     * @param uploadDateUtc
     * @param id
     * @param type
     * @param sizeString
     */
    public Attachment(Object id, String type, String fileName, String sizeString, String uploadDateUtc) {
        super();
        this.id = id;
        this.type = type;
        this.fileName = fileName;
        this.sizeString = sizeString;
        this.uploadDateUtc = uploadDateUtc;
    }

    @JsonProperty("id")
    public Object getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Object id) {
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

    @JsonProperty("fileName")
    public String getFileName() {
        return fileName;
    }

    @JsonProperty("fileName")
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @JsonProperty("sizeString")
    public String getSizeString() {
        return sizeString;
    }

    @JsonProperty("sizeString")
    public void setSizeString(String sizeString) {
        this.sizeString = sizeString;
    }

    @JsonProperty("uploadDateUtc")
    public String getUploadDateUtc() {
        return uploadDateUtc;
    }

    @JsonProperty("uploadDateUtc")
    public void setUploadDateUtc(String uploadDateUtc) {
        this.uploadDateUtc = uploadDateUtc;
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
        return new HashCodeBuilder().append(id).append(type).append(fileName).append(sizeString).append(uploadDateUtc).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Attachment) == false) {
            return false;
        }
        Attachment rhs = ((Attachment) other);
        return new EqualsBuilder().append(id, rhs.id).append(type, rhs.type).append(fileName, rhs.fileName).append(sizeString, rhs.sizeString).append(uploadDateUtc, rhs.uploadDateUtc).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
