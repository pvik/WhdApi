package com.whd;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.whd.autogen.CustomFieldDefinition;
import com.whd.autogen.LocationDefinition;
import com.whd.autogen.PriorityTypeDefinition;
import com.whd.autogen.RequestTypeDefinition;
import com.whd.autogen.StatusTypeDefinition;
import com.whd.autogen.note.Jobticket;
import com.whd.autogen.note.WhdNote;
import com.whd.autogen.ticket.Location;
import com.whd.autogen.ticket.TicketCustomField;
import com.whd.autogen.ticket.WhdTicket;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WhdApi {
    private static final Logger logger = LoggerFactory.getLogger(WhdApi.class);
    
    public static WhdTicket createUpdateTicket (WhdTicket ticket){
        logger.debug("createUpdateTicket(WhdTicket)");
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public static WhdTicket createTicket (WhdAuth auth, WhdTicket ticket) throws WhdException{
        logger.debug("createTicket(WhdTicket)");
        
        WhdTicket respTicket = null;
        try{
            
            String jsonTicketStream = Util.jsonMapper.writer().without(SerializationFeature.WRAP_ROOT_VALUE).writeValueAsString(ticket);
            
            HttpResponse<String> resp = Unirest.put(auth.getWhdUrl())
                    .header("accept", "application/json")
                    .routeParam("resource_type", "Ticket")
                    .queryString(auth.generateAuthUrlParams())
                    .body(jsonTicketStream)
                    .asString();
            
            Util.processResponseForException(resp);
            
            respTicket = Util.jsonMapper.readValue(resp.getBody(), WhdTicket.class);
        }
        catch(UnirestException e){
            throw new WhdException("Error Creating Ticket: "+e.getMessage(), e);
        }
        catch(IOException e){
            throw Util.processJsonMapperIOException(e);
        }
        return respTicket;
    }
    
    public static void updateTicket (WhdAuth auth, WhdTicket ticket) throws WhdException{
        logger.debug("updateTicket(WhdTicket)");
        
        String ticketId = String.format("%d", ticket.getId());
        
        try{
            String jsonTicketStream = Util.jsonMapper.writer().without(SerializationFeature.WRAP_ROOT_VALUE).writeValueAsString(ticket);
            
            HttpRequestWithBody httpRequest = Unirest.put(auth.getWhdUrl()+"/{ticket_id}")
                    .header("accept", "application/json")
                    .routeParam("resource_type", "Ticket")
                    .routeParam("ticket_id", ticketId)
                    .queryString(auth.generateAuthUrlParams());
            
            HttpResponse<String> resp = httpRequest
                    .body(jsonTicketStream)
                    .asString();
            
            logger.debug("Sending PUT Message to: {}", httpRequest.getUrl());
            
            Util.processResponseForException(resp);
        }
        catch(UnirestException e){
            throw new WhdException("Error Updating Ticket: "+e.getMessage(), e);
        }
        catch(IOException e){
            throw Util.processJsonMapperIOException(e);
        }
    }
    
    public static WhdTicket getTicket(WhdAuth auth, Integer ticketId) throws WhdException{
        try{            
            HttpResponse<String> resp = Unirest.get(auth.getWhdUrl()+"/{ticket_id}")
                    .header("accept", "application/json")
                    .routeParam("resource_type", "Ticket")
                    .routeParam("ticket_id", String.format("%d", ticketId))
                    .queryString(auth.generateAuthUrlParams())
                    .asString();
            
            Util.processResponseForException(resp);
            
            return Util.jsonMapper.readValue(resp.getBody(), WhdTicket.class);
        }
        catch(UnirestException e){
            throw new WhdException("Error getting Ticket: "+e.getMessage(), e);
        }
        catch(IOException e){
            throw Util.processJsonMapperIOException(e);
        }
    }
    
    public static List<WhdTicket> getTickets(WhdAuth auth, String qualifier) throws WhdException{
        List<WhdTicket> tickets = new ArrayList<>();
        try{
            HttpResponse<String> resp = Unirest.get(auth.getWhdUrl())
                    .header("accept", "application/json")
                    .routeParam("resource_type", "Tickets")
                    .queryString(auth.generateAuthUrlParams())
                    .queryString("qualifier", qualifier)
                    .asString();
            
            Util.processResponseForException(resp);
            
            // The Tickets resource returns only partial info about Ticket
            List<WhdTicket> tmpTicketList = Util.jsonMapper.readValue(resp.getBody(),
                    Util.jsonMapper.getTypeFactory().constructCollectionType(List.class, WhdTicket.class));
            
            // Loop through the List and get complete ticket details for each ticket
            for(WhdTicket t : tmpTicketList){
                tickets.add(getTicket(auth, t.getId()));
            }
            
            return tickets;
        }
        catch(UnirestException e){
            throw new WhdException("Error getting Ticket: "+e.getMessage(), e);
        }
        catch(IOException e){
            throw Util.processJsonMapperIOException(e);
        }
    }
    
    /**
     *
     * @param auth
     * @param id - This is attachment id
     * @return
     * @throws WhdException
     */
    public static byte[] getAttachment(WhdAuth auth, Integer id) throws WhdException{
        try{
            HttpResponse<String> resp = Unirest.get(auth.getWhdUrl()+"/{attachment_id}")
                    .header("accept", "application/octet")
                    .routeParam("resource_type", "TicketAttachments")
                    .routeParam("attachment_id", String.format("%d",id))
                    .queryString(auth.generateAuthUrlParams())
                    .asString();
            
            return resp.getBody().getBytes();
        }
        catch(UnirestException e){
            throw new WhdException("Error getting Ticket: "+e.getMessage(), e);
        }
    }
    
    public static void addNote(WhdAuth auth, Integer ticketId, String noteText) throws WhdException{
        try {
            WhdNote note = new WhdNote();
            Jobticket jt = new Jobticket();
            
            jt.setId(ticketId);
            jt.setType("JobTicket");
            
            note.setJobticket(jt);
            note.setNoteText(noteText);
            
            String jsonNoteStream = Util.jsonMapper.writer().without(SerializationFeature.WRAP_ROOT_VALUE).writeValueAsString(note);
            
            HttpResponse<String> resp = Unirest.post(auth.getWhdUrl())
                    .header("accept", "application/json")
                    .routeParam("resource_type", "TechNotes")
                    .queryString(auth.generateAuthUrlParams())
                    .body(jsonNoteStream)
                    .asString();
            
            Util.processResponseForException(resp);
            
            logger.debug("Response for creating Note {}", resp.getBody());
        }
        catch(UnirestException e){
            throw new WhdException("Error getting Ticket: "+e.getMessage(), e);
        }
        catch(IOException e){
            throw Util.processJsonMapperIOException(e);
        }
    }
    
    public static WhdTicket parseCustomFieldList(WhdTicket ticket){
        List<TicketCustomField> customFieldList = ticket.getTicketCustomFields();
        
        if(customFieldList != null){
            for(TicketCustomField customField : customFieldList){
                Integer fieldId = customField.getDefinitionId();
                String val = customField.getRestValue();
                
                try {
                    Method setCustomFieldMethod = WhdTicket.class.getMethod(String.format("setCustomField%d",fieldId), String.class);
                    setCustomFieldMethod.invoke(ticket, val);
                } catch (NoSuchMethodException ex) {
                    logger.error("Unable to find set method for custom field id {}. Skipping custom field.", fieldId);
                } catch (SecurityException ex) {
                    logger.error("Security Manager preventing from getting set method for custom field id {}. \nStackTrace{}", fieldId, getStackTrace(ex));
                }
                catch (IllegalAccessException ex) {
                    logger.error("IllegalAccessException on invoking set method for custom field id {}. \nStackTrace{}", fieldId, getStackTrace(ex));
                }
                catch (InvocationTargetException ex) {
                    logger.error("Exception on invoking set method for custom field id {}. \nStackTrace{}", fieldId, getStackTrace(ex));
                }
            }
        }
        return ticket;
    }
    
    public static WhdTicket populateCustomFieldsList(WhdTicket ticket){
        List<TicketCustomField> customFieldList = ticket.getTicketCustomFields();
        
        if(customFieldList != null){
            customFieldList.clear();
        }
        else{
            customFieldList = new ArrayList<>();
        }
        
        Method[] allWhdTicketMethods = WhdTicket.class.getMethods();
        
        for(Method m : allWhdTicketMethods){
            String methodName = m.getName();
            if (methodName.startsWith("getCustomField")){
                try{
                    Integer fieldId = Integer.parseInt(methodName.split("getCustomField")[1]);
                    
                    TicketCustomField customField = new TicketCustomField();
                    customField.setDefinitionId(fieldId);
                    
                    String customFieldValue = (String) m.invoke(m);
                    
                    customField.setRestValue(customFieldValue);
                    
                    customFieldList.add(customField);
                }
                catch(Exception e){
                    logger.error("Exception getting customField attribute with method: {}\nStackTrace: {}", methodName, getStackTrace(e));
                }
            }
        }
        ticket.setTicketCustomFields(customFieldList);
        
        return ticket;
    }
    
    public static WhdTicket populateLocationObject(WhdTicket ticket){
        if(ticket.getLocationId() != null){
            Location loc = new Location();
            loc.setType("Location");
            loc.setId(ticket.getLocationId());
            ticket.setLocation(loc);
        }
        return ticket;
    }
    
    public static String getCustomField(WhdCustomFields whdCustomFields, WhdTicket ticket, String customFieldName) throws WhdException{
        logger.debug("Getting Custom field for field name: {}", customFieldName);
        try {
            String custFieldId;
            if(whdCustomFields.fieldNameToId.containsKey(customFieldName))
                custFieldId = whdCustomFields.fieldNameToId.get(customFieldName.replace(" ", ""));
            else
                throw new WhdException("Custom Field not present in WHD instance");
            
            logger.debug("Field ID: {}", custFieldId);
            
            Method getCustFieldMethod = WhdTicket.class.getMethod("getCustomField"+custFieldId);
            
            return (String) getCustFieldMethod.invoke(ticket);
            
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            logger.error(getStackTrace(ex));
            throw new WhdException(ex);
        }
    }
    
    public static void setCustomField(WhdCustomFields whdCustomFields, WhdTicket ticket, String customFieldName, String fieldVal) throws WhdException{
        logger.debug("Getting Custom field for field name: {}", customFieldName);
        try {
            String custFieldId;
            if(whdCustomFields.fieldNameToId.containsKey(customFieldName))
                custFieldId = whdCustomFields.fieldNameToId.get(customFieldName.replace(" ", ""));
            else
                throw new WhdException("Custom Field not present in WHD instance");
            
            logger.debug("Field ID: {}", custFieldId);
            
            Method setCustFieldMethod = WhdTicket.class.getMethod("setCustomField"+custFieldId, String.class);
            
            setCustFieldMethod.invoke(ticket, fieldVal);
            
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            logger.error(getStackTrace(ex));
            throw new WhdException(ex);
        }
    }
    
    public static List<RequestTypeDefinition> getRequestTypeDefinitions(WhdAuth auth) throws WhdException{
        List<RequestTypeDefinition> requestTypeDefinitions = null;
        try{  
        HttpResponse<String> resp = Unirest.get(auth.getWhdUrl())
                .header("accept", "application/json")
                .routeParam("resource_type", "RequestTypes")
                .queryString(auth.generateAuthUrlParams())
                .queryString("list", "all")
                .asString();
            
            Util.processResponseForException(resp);
            
              
            requestTypeDefinitions = Util.jsonMapper.readValue(resp.getBody(),
                    Util.jsonMapper.getTypeFactory().constructCollectionType(List.class, RequestTypeDefinition.class));
                        
            logger.debug("Retreived Request Types");
        }
        catch(UnirestException e){
            throw new WhdException("Error getting Request Type Definitions: "+e.getMessage(), e);
        }
        catch(IOException e){
            throw Util.processJsonMapperIOException(e);
        }
        
        return requestTypeDefinitions;
    }
    
    public static List<StatusTypeDefinition> getStatusTypeDefinitions(WhdAuth auth) throws WhdException{
        List<StatusTypeDefinition> defs = null;
        
        try{  
        HttpResponse<String> resp = Unirest.get(auth.getWhdUrl())
                .header("accept", "application/json")
                .routeParam("resource_type", "StatusTypes")
                .queryString(auth.generateAuthUrlParams())
                .queryString("list", "all")
                .asString();
            
            Util.processResponseForException(resp);
            
              
            defs = Util.jsonMapper.readValue(resp.getBody(),
                    Util.jsonMapper.getTypeFactory().constructCollectionType(List.class, StatusTypeDefinition.class));
                        
            logger.debug("Retreived Status Types");
        }
        catch(UnirestException e){
            throw new WhdException("Error getting Request Type Definitions: "+e.getMessage(), e);
        }
        catch(IOException e){
            throw Util.processJsonMapperIOException(e);
        }
        
        return defs;
    }
    
    public static List<PriorityTypeDefinition> getPriorityTypeDefinitions(WhdAuth auth) throws WhdException{
        List<PriorityTypeDefinition> defs = null;
        
        try{  
        HttpResponse<String> resp = Unirest.get(auth.getWhdUrl())
                .header("accept", "application/json")
                .routeParam("resource_type", "PriorityTypes")
                .queryString(auth.generateAuthUrlParams())
                .queryString("list", "all")
                .asString();
            
            Util.processResponseForException(resp);
              
            defs = Util.jsonMapper.readValue(resp.getBody(),
                    Util.jsonMapper.getTypeFactory().constructCollectionType(List.class, PriorityTypeDefinition.class));
                        
            logger.debug("Retreived Priority Types");
        }
        catch(UnirestException e){
            throw new WhdException("Error getting Request Type Definitions: "+e.getMessage(), e);
        }
        catch(IOException e){
            throw Util.processJsonMapperIOException(e);
        }
        
        return defs;
    }
    
    public static List<CustomFieldDefinition> getCustomFieldDefinitions(WhdAuth auth) throws WhdException{
        List<CustomFieldDefinition> defs = null;
        
        try{  
        HttpResponse<String> resp = Unirest.get(auth.getWhdUrl())
                .header("accept", "application/json")
                .routeParam("resource_type", "CustomFieldDefinitions")
                .queryString(auth.generateAuthUrlParams())
                .queryString("list", "all")
                .asString();
            
            Util.processResponseForException(resp);
            
              
            defs = Util.jsonMapper.readValue(resp.getBody(),
                    Util.jsonMapper.getTypeFactory().constructCollectionType(List.class, CustomFieldDefinition.class));
                        
            logger.debug("Retreived Custom Field Definitions");
        }
        catch(UnirestException e){
            throw new WhdException("Error getting Request Type Definitions: "+e.getMessage(), e);
        }
        catch(IOException e){
            throw Util.processJsonMapperIOException(e);
        }
        
        return defs;
    }

    
    // Location related functions
    
    public static void createLocation(LocationDefinition location){
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public static List<LocationDefinition> getLocationList(WhdAuth auth) throws WhdException{
        List<LocationDefinition> defs = null;
        
        try{  
        HttpResponse<String> resp = Unirest.get(auth.getWhdUrl())
                .header("accept", "application/json")
                .routeParam("resource_type", "Locations")
                .queryString(auth.generateAuthUrlParams())
                .queryString("list", "all")
                .asString();
            
            Util.processResponseForException(resp);
            
              
            defs = Util.jsonMapper.readValue(resp.getBody(),
                    Util.jsonMapper.getTypeFactory().constructCollectionType(List.class, LocationDefinition.class));
                        
            logger.debug("Retreived Locations");
        }
        catch(UnirestException e){
            throw new WhdException("Error getting Request Type Definitions: "+e.getMessage(), e);
        }
        catch(IOException e){
            throw Util.processJsonMapperIOException(e);
        }
        return defs;
    }
    
    public static LocationDefinition getLocation(WhdAuth auth, int locationId) throws WhdException{
        LocationDefinition defs = null;
        
        try{  
        HttpResponse<String> resp = Unirest.get(auth.getWhdUrl()+"/{location_id}")
                .header("accept", "application/json")
                .routeParam("resource_type", "Locations")
                .routeParam("location_id", String.format("%d", locationId))
                .queryString(auth.generateAuthUrlParams())
                .queryString("list", "all")
                .asString();
            
            Util.processResponseForException(resp);
                        
            defs = Util.jsonMapper.readValue(resp.getBody(), LocationDefinition.class);;
            
            logger.debug("Retreived Locations");
        }
        catch(UnirestException e){
            throw new WhdException("Error getting Location Definition: "+e.getMessage(), e);
        }
        catch(IOException e){
            throw Util.processJsonMapperIOException(e);
        }
        return defs;
    }
    
    public static List<LocationDefinition> searchLocations(WhdAuth auth, String qualifier, boolean includeDeleted) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public static List<LocationDefinition> searchLocationsIncludeDeleted(WhdAuth auth, String qualifier) {
        return searchLocations(auth, qualifier, true);  
    }
    
    public static List<LocationDefinition> searchLocationsExcludeDeleted(WhdAuth auth, String qualifier) {
        return searchLocations(auth, qualifier, false); 
    }
    
    public static void updateLocation(WhdAuth auth, LocationDefinition location){
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public static void deleteLocation(WhdAuth auth, LocationDefinition location){
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
