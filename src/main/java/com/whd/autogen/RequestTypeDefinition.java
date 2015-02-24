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
"parentId",
"problemTypeName",
"approvalProcess",
"isLeafChild",
"hasTechGroup",
"autoAssignType",
"priorityTypeId",
"techGroupName",
"sendClientEmailBoolean",
"sendTechEmailBoolean",
"sendLevelTechEmailBoolean",
"sendGroupMgrEmailBoolean"
})
public class RequestTypeDefinition {

@JsonProperty("id")
private Integer id;
@JsonProperty("type")
private String type;
@JsonProperty("parentId")
private Integer parentId;
@JsonProperty("problemTypeName")
private String problemTypeName;
@JsonProperty("approvalProcess")
private Object approvalProcess;
@JsonProperty("isLeafChild")
private Boolean isLeafChild;
@JsonProperty("hasTechGroup")
private Boolean hasTechGroup;
@JsonProperty("autoAssignType")
private String autoAssignType;
@JsonProperty("priorityTypeId")
private Integer priorityTypeId;
@JsonProperty("techGroupName")
private String techGroupName;
@JsonProperty("sendClientEmailBoolean")
private Boolean sendClientEmailBoolean;
@JsonProperty("sendTechEmailBoolean")
private Boolean sendTechEmailBoolean;
@JsonProperty("sendLevelTechEmailBoolean")
private Boolean sendLevelTechEmailBoolean;
@JsonProperty("sendGroupMgrEmailBoolean")
private Boolean sendGroupMgrEmailBoolean;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The id
*/
@JsonProperty("id")
public Integer getId() {
return id;
}

/**
* 
* @param id
* The id
*/
@JsonProperty("id")
public void setId(Integer id) {
this.id = id;
}

public RequestTypeDefinition withId(Integer id) {
this.id = id;
return this;
}

/**
* 
* @return
* The type
*/
@JsonProperty("type")
public String getType() {
return type;
}

/**
* 
* @param type
* The type
*/
@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

public RequestTypeDefinition withType(String type) {
this.type = type;
return this;
}

/**
* 
* @return
* The parentId
*/
@JsonProperty("parentId")
public Integer getParentId() {
return parentId;
}

/**
* 
* @param parentId
* The parentId
*/
@JsonProperty("parentId")
public void setParentId(Integer parentId) {
this.parentId = parentId;
}

public RequestTypeDefinition withParentId(Integer parentId) {
this.parentId = parentId;
return this;
}

/**
* 
* @return
* The problemTypeName
*/
@JsonProperty("problemTypeName")
public String getProblemTypeName() {
return problemTypeName;
}

/**
* 
* @param problemTypeName
* The problemTypeName
*/
@JsonProperty("problemTypeName")
public void setProblemTypeName(String problemTypeName) {
this.problemTypeName = problemTypeName;
}

public RequestTypeDefinition withProblemTypeName(String problemTypeName) {
this.problemTypeName = problemTypeName;
return this;
}

/**
* 
* @return
* The approvalProcess
*/
@JsonProperty("approvalProcess")
public Object getApprovalProcess() {
return approvalProcess;
}

/**
* 
* @param approvalProcess
* The approvalProcess
*/
@JsonProperty("approvalProcess")
public void setApprovalProcess(Object approvalProcess) {
this.approvalProcess = approvalProcess;
}

public RequestTypeDefinition withApprovalProcess(Object approvalProcess) {
this.approvalProcess = approvalProcess;
return this;
}

/**
* 
* @return
* The isLeafChild
*/
@JsonProperty("isLeafChild")
public Boolean getIsLeafChild() {
return isLeafChild;
}

/**
* 
* @param isLeafChild
* The isLeafChild
*/
@JsonProperty("isLeafChild")
public void setIsLeafChild(Boolean isLeafChild) {
this.isLeafChild = isLeafChild;
}

public RequestTypeDefinition withIsLeafChild(Boolean isLeafChild) {
this.isLeafChild = isLeafChild;
return this;
}

/**
* 
* @return
* The hasTechGroup
*/
@JsonProperty("hasTechGroup")
public Boolean getHasTechGroup() {
return hasTechGroup;
}

/**
* 
* @param hasTechGroup
* The hasTechGroup
*/
@JsonProperty("hasTechGroup")
public void setHasTechGroup(Boolean hasTechGroup) {
this.hasTechGroup = hasTechGroup;
}

public RequestTypeDefinition withHasTechGroup(Boolean hasTechGroup) {
this.hasTechGroup = hasTechGroup;
return this;
}

/**
* 
* @return
* The autoAssignType
*/
@JsonProperty("autoAssignType")
public String getAutoAssignType() {
return autoAssignType;
}

/**
* 
* @param autoAssignType
* The autoAssignType
*/
@JsonProperty("autoAssignType")
public void setAutoAssignType(String autoAssignType) {
this.autoAssignType = autoAssignType;
}

public RequestTypeDefinition withAutoAssignType(String autoAssignType) {
this.autoAssignType = autoAssignType;
return this;
}

/**
* 
* @return
* The priorityTypeId
*/
@JsonProperty("priorityTypeId")
public Integer getPriorityTypeId() {
return priorityTypeId;
}

/**
* 
* @param priorityTypeId
* The priorityTypeId
*/
@JsonProperty("priorityTypeId")
public void setPriorityTypeId(Integer priorityTypeId) {
this.priorityTypeId = priorityTypeId;
}

public RequestTypeDefinition withPriorityTypeId(Integer priorityTypeId) {
this.priorityTypeId = priorityTypeId;
return this;
}

/**
* 
* @return
* The techGroupName
*/
@JsonProperty("techGroupName")
public String getTechGroupName() {
return techGroupName;
}

/**
* 
* @param techGroupName
* The techGroupName
*/
@JsonProperty("techGroupName")
public void setTechGroupName(String techGroupName) {
this.techGroupName = techGroupName;
}

public RequestTypeDefinition withTechGroupName(String techGroupName) {
this.techGroupName = techGroupName;
return this;
}

/**
* 
* @return
* The sendClientEmailBoolean
*/
@JsonProperty("sendClientEmailBoolean")
public Boolean getSendClientEmailBoolean() {
return sendClientEmailBoolean;
}

/**
* 
* @param sendClientEmailBoolean
* The sendClientEmailBoolean
*/
@JsonProperty("sendClientEmailBoolean")
public void setSendClientEmailBoolean(Boolean sendClientEmailBoolean) {
this.sendClientEmailBoolean = sendClientEmailBoolean;
}

public RequestTypeDefinition withSendClientEmailBoolean(Boolean sendClientEmailBoolean) {
this.sendClientEmailBoolean = sendClientEmailBoolean;
return this;
}

/**
* 
* @return
* The sendTechEmailBoolean
*/
@JsonProperty("sendTechEmailBoolean")
public Boolean getSendTechEmailBoolean() {
return sendTechEmailBoolean;
}

/**
* 
* @param sendTechEmailBoolean
* The sendTechEmailBoolean
*/
@JsonProperty("sendTechEmailBoolean")
public void setSendTechEmailBoolean(Boolean sendTechEmailBoolean) {
this.sendTechEmailBoolean = sendTechEmailBoolean;
}

public RequestTypeDefinition withSendTechEmailBoolean(Boolean sendTechEmailBoolean) {
this.sendTechEmailBoolean = sendTechEmailBoolean;
return this;
}

/**
* 
* @return
* The sendLevelTechEmailBoolean
*/
@JsonProperty("sendLevelTechEmailBoolean")
public Boolean getSendLevelTechEmailBoolean() {
return sendLevelTechEmailBoolean;
}

/**
* 
* @param sendLevelTechEmailBoolean
* The sendLevelTechEmailBoolean
*/
@JsonProperty("sendLevelTechEmailBoolean")
public void setSendLevelTechEmailBoolean(Boolean sendLevelTechEmailBoolean) {
this.sendLevelTechEmailBoolean = sendLevelTechEmailBoolean;
}

public RequestTypeDefinition withSendLevelTechEmailBoolean(Boolean sendLevelTechEmailBoolean) {
this.sendLevelTechEmailBoolean = sendLevelTechEmailBoolean;
return this;
}

/**
* 
* @return
* The sendGroupMgrEmailBoolean
*/
@JsonProperty("sendGroupMgrEmailBoolean")
public Boolean getSendGroupMgrEmailBoolean() {
return sendGroupMgrEmailBoolean;
}

/**
* 
* @param sendGroupMgrEmailBoolean
* The sendGroupMgrEmailBoolean
*/
@JsonProperty("sendGroupMgrEmailBoolean")
public void setSendGroupMgrEmailBoolean(Boolean sendGroupMgrEmailBoolean) {
this.sendGroupMgrEmailBoolean = sendGroupMgrEmailBoolean;
}

public RequestTypeDefinition withSendGroupMgrEmailBoolean(Boolean sendGroupMgrEmailBoolean) {
this.sendGroupMgrEmailBoolean = sendGroupMgrEmailBoolean;
return this;
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

public RequestTypeDefinition withAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
return this;
}

@Override
public int hashCode() {
return new HashCodeBuilder().append(id).append(type).append(parentId).append(problemTypeName).append(approvalProcess).append(isLeafChild).append(hasTechGroup).append(autoAssignType).append(priorityTypeId).append(techGroupName).append(sendClientEmailBoolean).append(sendTechEmailBoolean).append(sendLevelTechEmailBoolean).append(sendGroupMgrEmailBoolean).append(additionalProperties).toHashCode();
}

@Override
public boolean equals(Object other) {
if (other == this) {
return true;
}
if ((other instanceof RequestTypeDefinition) == false) {
return false;
}
RequestTypeDefinition rhs = ((RequestTypeDefinition) other);
return new EqualsBuilder().append(id, rhs.id).append(type, rhs.type).append(parentId, rhs.parentId).append(problemTypeName, rhs.problemTypeName).append(approvalProcess, rhs.approvalProcess).append(isLeafChild, rhs.isLeafChild).append(hasTechGroup, rhs.hasTechGroup).append(autoAssignType, rhs.autoAssignType).append(priorityTypeId, rhs.priorityTypeId).append(techGroupName, rhs.techGroupName).append(sendClientEmailBoolean, rhs.sendClientEmailBoolean).append(sendTechEmailBoolean, rhs.sendTechEmailBoolean).append(sendLevelTechEmailBoolean, rhs.sendLevelTechEmailBoolean).append(sendGroupMgrEmailBoolean, rhs.sendGroupMgrEmailBoolean).append(additionalProperties, rhs.additionalProperties).isEquals();
}

}
