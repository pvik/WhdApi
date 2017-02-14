
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
    "level",
    "levelName",
    "shortLevelName"
})
public class TechGroupLevel implements Serializable
{

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("level")
    private Integer level;
    @JsonProperty("levelName")
    private String levelName;
    @JsonProperty("shortLevelName")
    private String shortLevelName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5209877166600752135L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TechGroupLevel() {
    }

    /**
     * 
     * @param level
     * @param levelName
     * @param shortLevelName
     * @param id
     * @param type
     */
    public TechGroupLevel(Integer id, String type, Integer level, String levelName, String shortLevelName) {
        super();
        this.id = id;
        this.type = type;
        this.level = level;
        this.levelName = levelName;
        this.shortLevelName = shortLevelName;
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

    @JsonProperty("level")
    public Integer getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(Integer level) {
        this.level = level;
    }

    @JsonProperty("levelName")
    public String getLevelName() {
        return levelName;
    }

    @JsonProperty("levelName")
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    @JsonProperty("shortLevelName")
    public String getShortLevelName() {
        return shortLevelName;
    }

    @JsonProperty("shortLevelName")
    public void setShortLevelName(String shortLevelName) {
        this.shortLevelName = shortLevelName;
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
        return new HashCodeBuilder().append(id).append(type).append(level).append(levelName).append(shortLevelName).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TechGroupLevel) == false) {
            return false;
        }
        TechGroupLevel rhs = ((TechGroupLevel) other);
        return new EqualsBuilder().append(id, rhs.id).append(type, rhs.type).append(level, rhs.level).append(levelName, rhs.levelName).append(shortLevelName, rhs.shortLevelName).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
