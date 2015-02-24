
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
    "id",
    "type",
    "level",
    "levelName",
    "shortLevelName"
})
public class TechGroupLevel {

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
     *     The level
     */
    @JsonProperty("level")
    public Integer getLevel() {
        return level;
    }

    /**
     * 
     * @param level
     *     The level
     */
    @JsonProperty("level")
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 
     * @return
     *     The levelName
     */
    @JsonProperty("levelName")
    public String getLevelName() {
        return levelName;
    }

    /**
     * 
     * @param levelName
     *     The levelName
     */
    @JsonProperty("levelName")
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    /**
     * 
     * @return
     *     The shortLevelName
     */
    @JsonProperty("shortLevelName")
    public String getShortLevelName() {
        return shortLevelName;
    }

    /**
     * 
     * @param shortLevelName
     *     The shortLevelName
     */
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
