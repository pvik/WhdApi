package com.whd.autogen;

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
    "label",
    "optionsString",
    "displayStyleStorableValue",
    "visible",
    "editable",
    "required"
})
public class CustomFieldDefinition {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("label")
    private String label;
    @JsonProperty("optionsString")
    private String optionsString;
    @JsonProperty("displayStyleStorableValue")
    private Integer displayStyleStorableValue;
    @JsonProperty("visible")
    private Boolean visible;
    @JsonProperty("editable")
    private Boolean editable;
    @JsonProperty("required")
    private Boolean required;
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
     *     The label
     */
    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    /**
     * 
     * @param label
     *     The label
     */
    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 
     * @return
     *     The optionsString
     */
    @JsonProperty("optionsString")
    public String getOptionsString() {
        return optionsString;
    }

    /**
     * 
     * @param optionsString
     *     The optionsString
     */
    @JsonProperty("optionsString")
    public void setOptionsString(String optionsString) {
        this.optionsString = optionsString;
    }

    /**
     * 
     * @return
     *     The displayStyleStorableValue
     */
    @JsonProperty("displayStyleStorableValue")
    public Integer getDisplayStyleStorableValue() {
        return displayStyleStorableValue;
    }

    /**
     * 
     * @param displayStyleStorableValue
     *     The displayStyleStorableValue
     */
    @JsonProperty("displayStyleStorableValue")
    public void setDisplayStyleStorableValue(Integer displayStyleStorableValue) {
        this.displayStyleStorableValue = displayStyleStorableValue;
    }

    /**
     * 
     * @return
     *     The visible
     */
    @JsonProperty("visible")
    public Boolean getVisible() {
        return visible;
    }

    /**
     * 
     * @param visible
     *     The visible
     */
    @JsonProperty("visible")
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    /**
     * 
     * @return
     *     The editable
     */
    @JsonProperty("editable")
    public Boolean getEditable() {
        return editable;
    }

    /**
     * 
     * @param editable
     *     The editable
     */
    @JsonProperty("editable")
    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    /**
     * 
     * @return
     *     The required
     */
    @JsonProperty("required")
    public Boolean getRequired() {
        return required;
    }

    /**
     * 
     * @param required
     *     The required
     */
    @JsonProperty("required")
    public void setRequired(Boolean required) {
        this.required = required;
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
        return new HashCodeBuilder().append(id).append(type).append(label).append(optionsString).append(displayStyleStorableValue).append(visible).append(editable).append(required).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomFieldDefinition) == false) {
            return false;
        }
        CustomFieldDefinition rhs = ((CustomFieldDefinition) other);
        return new EqualsBuilder().append(id, rhs.id).append(type, rhs.type).append(label, rhs.label).append(optionsString, rhs.optionsString).append(displayStyleStorableValue, rhs.displayStyleStorableValue).append(visible, rhs.visible).append(editable, rhs.editable).append(required, rhs.required).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

   
}
