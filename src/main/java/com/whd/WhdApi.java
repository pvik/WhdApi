package com.whd;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.io.ByteStreams;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.whd.autogen.*;
import com.whd.autogen.note.Jobticket;
import com.whd.autogen.note.WhdNote;
import com.whd.autogen.note.response.WhdNoteResponse;
import com.whd.autogen.ticket.CustomField;
import com.whd.autogen.ticket.Location;
import com.whd.autogen.ticket.TicketCustomField;
import com.whd.autogen.ticket.WhdTicket;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.http.client.CookieStore;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;

public class WhdApi {

    private static final Logger log = LoggerFactory.getLogger(WhdApi.class);

    public static WhdTicket createUpdateTicket(WhdAuth auth, WhdTicket ticket) throws WhdException {
        log.trace("moving ticketCustomFields to customFields");
        if(ticket.getTicketCustomFields() != null && ticket.getTicketCustomFields().size() > 0) {
            ticket.setCustomFields(new ArrayList<>());
            for (TicketCustomField tcf : ticket.getTicketCustomFields()) {
                if(tcf.getRestValue() != null) {
                    CustomField cf = new CustomField();
                    cf.setDefinitionId(tcf.getDefinitionId());
                    cf.setRestValue(tcf.getRestValue());
                    cf.setType(tcf.getType());
                    ticket.getCustomFields().add(cf);
                }
            }
            ticket.setTicketCustomFields(null);
        }

        // remove fields
        ticket.setEnabledStatusTypes(null);
        ticket.setLastUpdated(null);

        log.trace("Ticket: {}", ReflectionToStringBuilder.toString(ticket));

        log.debug("createUpdateTicket(WhdTicket)");
        if (ticket.getId() == null) {
            return createTicket(auth, ticket);
        } else {
            updateTicket(auth, ticket);
            return ticket;
        }
    }

    public static WhdTicket createTicket(WhdAuth auth, WhdTicket ticket) throws WhdException {
        log.debug("createTicket(WhdTicket)");

        WhdTicket respTicket = null;
        try {
            String jsonTicketStream = Util.jsonMapper
                    .writer()
                    .without(SerializationFeature.WRAP_ROOT_VALUE)
                    .writeValueAsString(ticket);

            HttpResponse<String> resp = Unirest.post(auth.getWhdUrl())
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .routeParam("resource_type", "Ticket")
                    .queryString(auth.generateAuthUrlParams())
                    .body(jsonTicketStream)
                    .asString();

            log.trace("response status: {}", resp.getStatusText());
            log.trace("response: {}", resp.getBody());

            Util.processResponseForException(resp);

            respTicket = Util.jsonMapper.readValue(resp.getBody(), WhdTicket.class);
        } catch (UnirestException e) {
            throw new WhdException("Error Creating Ticket: " + e.getMessage(), e);
        } catch (IOException e) {
            throw Util.processJsonMapperIOException(e);
        }
        return respTicket;
    }

    public static void updateTicket(WhdAuth auth, WhdTicket ticket) throws WhdException {
        log.debug("updateTicket(WhdTicket)");

        String ticketId = String.format("%d", ticket.getId());

        try {
            String jsonTicketStream = Util.jsonMapper.writer().without(SerializationFeature.WRAP_ROOT_VALUE).writeValueAsString(ticket);

            log.trace("Json stream: {}", jsonTicketStream);

            HttpRequestWithBody httpRequest = Unirest.put(auth.getWhdUrl() + "/{ticket_id}")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .routeParam("resource_type", "Tickets")
                    .routeParam("ticket_id", ticketId)
                    .queryString(auth.generateAuthUrlParams());

            HttpResponse<String> resp = httpRequest
                    .body(jsonTicketStream)
                    .asString();

            log.debug("Sending PUT Message to: {}", httpRequest.getUrl());

            Util.processResponseForException(resp);
        } catch (UnirestException e) {
            throw new WhdException("Error Updating Ticket: " + e.getMessage(), e);
        } catch (IOException e) {
            throw Util.processJsonMapperIOException(e);
        }
    }

    public static WhdTicket getTicket(WhdAuth auth, Integer ticketId) throws WhdException {
        try {
            HttpResponse<String> resp = Unirest.get(auth.getWhdUrl() + "/{ticket_id}")
                    .header("accept", "application/json")
                    .routeParam("resource_type", "Ticket")
                    .routeParam("ticket_id", String.format("%d", ticketId))
                    .queryString(auth.generateAuthUrlParams())
                    .asString();

            log.trace("response status: {}", resp.getStatusText());
            log.trace("response: {}", resp.getBody());

            Util.processResponseForException(resp);

            return Util.jsonMapper.readValue(resp.getBody(), WhdTicket.class);
        } catch (UnirestException e) {
            throw new WhdException("Error getting Ticket: " + e.getMessage(), e);
        } catch (IOException e) {
            throw Util.processJsonMapperIOException(e);
        }
    }

    public static List<WhdTicket> getTickets(WhdAuth auth, String qualifier) throws WhdException {
        List<WhdTicket> tickets = new ArrayList<>();
        try {
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
            for (WhdTicket t : tmpTicketList) {
                tickets.add(getTicket(auth, t.getId()));
            }

            return tickets;
        } catch (UnirestException e) {
            throw new WhdException("Error getting Ticket: " + e.getMessage(), e);
        } catch (IOException e) {
            throw Util.processJsonMapperIOException(e);
        }
    }

    /**
     * @param auth
     * @param id   - This is attachment id
     * @return
     * @throws WhdException
     */
    public static byte[] getAttachment(WhdAuth auth, Integer id) throws WhdException {
        try {
            HttpResponse<InputStream> resp = Unirest.get(auth.getWhdUrl() + "/{attachment_id}")
                    .header("accept", "application/octet")
                    .routeParam("resource_type", "TicketAttachments")
                    .routeParam("attachment_id", String.format("%d", id))
                    .queryString(auth.generateAuthUrlParams())
                    .asBinary();
                    //.asString();

            return ByteStreams.toByteArray(resp.getBody()); //resp.getBody().getBytes();
        } catch (UnirestException | IOException e) {
            throw new WhdException("Error getting Ticket: " + e.getMessage(), e);
        }
    }

    public static Integer addAttachment(WhdAuth auth, Integer ticketId, String filePath) throws WhdException {
        try {

            CookieStore cookieStore = new org.apache.http.impl.client.BasicCookieStore();
            Unirest.setHttpClient(org.apache.http.impl.client.HttpClients.custom()
                    .setDefaultCookieStore(cookieStore)
                    .build());

            log.debug("whdUrl: {}", auth.getWhdUrl());
            log.debug("authUrlParam: {}", auth.generateAuthUrlParams());

            HttpResponse<String> strResponse = Unirest.get(auth.getWhdUrl())
                    .header("accept", "application/json")
                    .header("Set-Cookie", "http-only")
                    .routeParam("resource_type", "Session")
                    .queryString(auth.generateAuthUrlParams())
                    .asString();

            log.debug("httpResponse headers: {}", strResponse.getHeaders());
            log.debug("httpResponse status: {}", strResponse.getStatus());
            log.debug("httpResponse statusText: {}", strResponse.getStatusText());
            log.debug("httpResponse rawbody: {}", strResponse.getRawBody());
            log.debug("httpResponse body: {}", strResponse.getBody());

            String cookies =  strResponse.getHeaders().get("Set-Cookie").stream()
                    .collect(Collectors.joining("; "));

            HttpResponse<JsonNode> jsonResponse = Unirest.get(auth.getWhdUrl())
                    .header("accept", "application/json")
                    .routeParam("resource_type", "Session")
                    .queryString(auth.generateAuthUrlParams())
                    .asJson();

            String wosid;
            try {
                wosid = jsonResponse.getBody().getObject().getString("sessionKey");
            } catch (JSONException e) {
                throw new WhdException("Unable to upload attachment " +
                        filePath + " to WHD ticket " +
                        ticketId + "\nInvalid REST SessionID received");
            }
            cookies = cookies + "; wosid="+wosid;

            HttpResponse<JsonNode> jsonResponseFileUpload = Unirest.post(auth.getWhdUri()+
                    "/helpdesk/attachment/upload?type=jobTicket&entityId={ticket_id}")
                    .header("accept", "application/json")
                    .header("Cookie", cookies)
                    .header("Connection", "keep-alive")
                    .header("Pragma", "no-cache")
                    .routeParam("ticket_id", ticketId.toString())
                    .field("file", new File(filePath))
                    .asJson();

            log.debug("Response for uploading attachment: {}", jsonResponseFileUpload.getBody());
            //Integer attId = Integer.parseInt(jsonResponseFileUpload.getBody().getObject().getString("id"));
            Integer attId = jsonResponseFileUpload.getBody().getObject().getInt("id");
            log.debug("Attachment ID created: {}", attId);

            return attId;
        } catch (UnirestException e) {
            throw new WhdException("Error uploading attachment to Ticket: " + getStackTrace(e) + "\n"
                    + e.getMessage(), e);
        } catch (Exception e) {
            throw new WhdException("Unknow Exception uploading attachment to Ticket: " + getStackTrace(e) + "\n"
                    + e.getMessage(), e);
        }
    }

    public static Integer addNote(WhdAuth auth, Integer ticketId, String noteText) throws WhdException {
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
                    .header("Content-Type", "application/json")
                    .routeParam("resource_type", "TechNotes")
                    .queryString(auth.generateAuthUrlParams())
                    .body(jsonNoteStream)
                    .asString();

            //Util.jsonMapper.reader().readValue(resp);

            Util.processResponseForException(resp);

            log.debug("Response for creating Note {}", resp.getBody());

            WhdNoteResponse jsonResponse = Util.jsonMapper.readValue(resp.getBody(), WhdNoteResponse.class);

            return jsonResponse.getId();

        } catch (UnirestException e) {
            throw new WhdException("Error getting Ticket: " + e.getMessage(), e);
        } catch (IOException e) {
            throw Util.processJsonMapperIOException(e);
        }
    }

    public static void populateLocationObject(WhdTicket ticket) {
        if (ticket.getLocationId() != null) {
            Location loc = new Location();

            loc.setType("Location");
            loc.setId(ticket.getLocationId());
            ticket.setLocation(loc);
        }
    }

    public static List<RequestTypeDefinition> getRequestTypeDefinitions(WhdAuth auth) throws WhdException {
        List<RequestTypeDefinition> requestTypeDefinitions = null;
        try {
            HttpResponse<String> resp = Unirest.get(auth.getWhdUrl())
                    .header("accept", "application/json")
                    .routeParam("resource_type", "RequestTypes")
                    .queryString(auth.generateAuthUrlParams())
                    .queryString("list", "all")
                    .asString();

            Util.processResponseForException(resp);


            requestTypeDefinitions = Util.jsonMapper.readValue(resp.getBody(),
                    Util.jsonMapper.getTypeFactory().constructCollectionType(List.class, RequestTypeDefinition.class));

            log.debug("Retreived Request Types");
        } catch (UnirestException e) {
            throw new WhdException("Error getting Request Type Definitions: " + e.getMessage(), e);
        } catch (IOException e) {
            throw Util.processJsonMapperIOException(e);
        }

        return requestTypeDefinitions;
    }

    public static List<StatusTypeDefinition> getStatusTypeDefinitions(WhdAuth auth) throws WhdException {
        List<StatusTypeDefinition> defs = null;

        try {
            HttpResponse<String> resp = Unirest.get(auth.getWhdUrl())
                    .header("accept", "application/json")
                    .routeParam("resource_type", "StatusTypes")
                    .queryString(auth.generateAuthUrlParams())
                    .queryString("list", "all")
                    .asString();

            Util.processResponseForException(resp);


            defs = Util.jsonMapper.readValue(resp.getBody(),
                    Util.jsonMapper.getTypeFactory().constructCollectionType(List.class, StatusTypeDefinition.class));

            log.debug("Retreived Status Types");
        } catch (UnirestException e) {
            throw new WhdException("Error getting Request Type Definitions: " + e.getMessage(), e);
        } catch (IOException e) {
            throw Util.processJsonMapperIOException(e);
        }

        return defs;
    }

    public static List<PriorityTypeDefinition> getPriorityTypeDefinitions(WhdAuth auth) throws WhdException {
        List<PriorityTypeDefinition> defs = null;

        try {
            HttpResponse<String> resp = Unirest.get(auth.getWhdUrl())
                    .header("accept", "application/json")
                    .routeParam("resource_type", "PriorityTypes")
                    .queryString(auth.generateAuthUrlParams())
                    .queryString("list", "all")
                    .asString();

            Util.processResponseForException(resp);

            defs = Util.jsonMapper.readValue(resp.getBody(),
                    Util.jsonMapper.getTypeFactory().constructCollectionType(List.class, PriorityTypeDefinition.class));

            log.debug("Retreived Priority Types");
        } catch (UnirestException e) {
            throw new WhdException("Error getting Request Type Definitions: " + e.getMessage(), e);
        } catch (IOException e) {
            throw Util.processJsonMapperIOException(e);
        }

        return defs;
    }

    public static List<CustomFieldDefinition> getCustomFieldDefinitions(WhdAuth auth) throws WhdException {
        List<CustomFieldDefinition> defs = null;

        try {
            HttpResponse<String> resp = Unirest.get(auth.getWhdUrl())
                    .header("accept", "application/json")
                    .routeParam("resource_type", "CustomFieldDefinitions")
                    .queryString(auth.generateAuthUrlParams())
                    .queryString("list", "all")
                    .asString();

            Util.processResponseForException(resp);


            defs = Util.jsonMapper.readValue(resp.getBody(),
                    Util.jsonMapper.getTypeFactory().constructCollectionType(List.class, CustomFieldDefinition.class));

            log.debug("Retreived Custom Field Definitions");
        } catch (UnirestException e) {
            throw new WhdException("Error getting Request Type Definitions: " + e.getMessage(), e);
        } catch (IOException e) {
            throw Util.processJsonMapperIOException(e);
        }

        return defs;
    }


    // Location related functions

    public static LocationDefinition createLocation(WhdAuth auth, LocationDefinition location) throws WhdException {
        log.debug("createLocation(LocationDefinition)");

        LocationDefinition newLoc = null;
        try {
            String jsonTicketStream = Util.jsonMapper.writer().without(SerializationFeature.WRAP_ROOT_VALUE).writeValueAsString(location);

            HttpResponse<String> resp = Unirest.put(auth.getWhdUrl() + "/{ticket_id}")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .routeParam("resource_type", "Locations")
                    .queryString(auth.generateAuthUrlParams())
                    .body(jsonTicketStream)
                    .asString();

            Util.processResponseForException(resp);

            newLoc = Util.jsonMapper.readValue(resp.getBody(), LocationDefinition.class);
        } catch (UnirestException e) {
            throw new WhdException("Error Updating Ticket: " + e.getMessage(), e);
        } catch (IOException e) {
            throw Util.processJsonMapperIOException(e);
        }

        return newLoc;
    }

    public static List<LocationDefinition> getLocationList(WhdAuth auth) throws WhdException {
        List<LocationDefinition> defs = null;

        try {
            Unirest.setTimeouts(30000, 180000);

            HttpResponse<String> resp = Unirest.get(auth.getWhdUrl())
                    .header("accept", "application/json")
                    .routeParam("resource_type", "Locations")
                    .queryString(auth.generateAuthUrlParams())
                    .queryString("list", "all")
                    .asString();

            Util.processResponseForException(resp);

            defs = Util.jsonMapper.readValue(resp.getBody(),
                    Util.jsonMapper.getTypeFactory().constructCollectionType(List.class, LocationDefinition.class));

            log.debug("Retreived Locations");
        } catch (UnirestException e) {
            throw new WhdException("Error Location Type Definitions: " + e.getMessage(), e);
        } catch (IOException e) {
            throw Util.processJsonMapperIOException(e);
        }
        return defs;
    }

    public static LocationDefinition getLocation(WhdAuth auth, int locationId) throws WhdException {
        LocationDefinition defs = null;

        try {
            HttpResponse<String> resp = Unirest.get(auth.getWhdUrl() + "/{location_id}")
                    .header("accept", "application/json")
                    .routeParam("resource_type", "Locations")
                    .routeParam("location_id", String.format("%d", locationId))
                    .queryString(auth.generateAuthUrlParams())
                    .queryString("list", "all")
                    .asString();

            Util.processResponseForException(resp);

            defs = Util.jsonMapper.readValue(resp.getBody(), LocationDefinition.class);
            ;

            log.debug("Retreived Locations");
        } catch (UnirestException e) {
            throw new WhdException("Error getting Location Definition: " + e.getMessage(), e);
        } catch (IOException e) {
            throw Util.processJsonMapperIOException(e);
        }
        return defs;
    }

    public static List<LocationDefinition> searchLocations(WhdAuth auth, String qualifier, int limit, int page) throws WhdException {
        List<LocationDefinition> defs = null;

        try {
            log.trace("Getting locations: {} ", qualifier);
            log.trace("Page: {} | Limit: {}", page, limit);

            HttpResponse<String> resp = Unirest.get(auth.getWhdUrl())
                    .header("accept", "application/json")
                    .routeParam("resource_type", "Locations")
                    .queryString(auth.generateAuthUrlParams())
                    .queryString("qualifier", qualifier)
                    .queryString("limit", limit)
                    .queryString("page", page)
                    .asString();

            Util.processResponseForException(resp);

            defs = Util.jsonMapper.readValue(resp.getBody(),
                    Util.jsonMapper.getTypeFactory().constructCollectionType(List.class, LocationDefinition.class));

            log.trace("Retreived Locations");
        } catch (UnirestException e) {
            throw new WhdException("Error getting Request Type Definitions: " + e.getMessage(), e);
        } catch (IOException e) {
            throw Util.processJsonMapperIOException(e);
        }
        return defs;
    }

    public static List<LocationDefinition> searchLocations(WhdAuth auth, String qualifier) throws WhdException {
        final int LIMIT = 500;

        List<LocationDefinition> locations = new ArrayList<>();

        List<LocationDefinition> locDefs;
        int page = 1;
        do {
            locDefs = searchLocations(auth, qualifier, LIMIT, page);
            locations.addAll(locDefs);
            page++;
        } while (locDefs.size() == LIMIT);

        return locations;
    }

    public static List<LocationDefinition> searchLocations(WhdAuth auth, String qualifier, boolean includeDeleted) throws WhdException {
        if (includeDeleted) {
            qualifier = "(((deleted %3D null) or (deleted %3D 0) or (deleted %3D 1)) and " + qualifier + ")";
        }
        return searchLocations(auth, qualifier);
    }

    public static List<LocationDefinition> searchLocationsIncludeDeleted(WhdAuth auth, String qualifier) throws WhdException {
        return searchLocations(auth, qualifier, true);
    }

    public static List<LocationDefinition> searchLocationsExcludeDeleted(WhdAuth auth, String qualifier) throws WhdException {
        return searchLocations(auth, qualifier, false);
    }

    public static void updateLocation(WhdAuth auth, LocationDefinition location) throws WhdException {
        try {
            String locationId = String.format("%d", location.getId());
            log.debug("updateLocation(<LocationDefinition;id={}>)", locationId);

            String jsonLocationStream = Util.jsonMapper.writer().without(SerializationFeature.WRAP_ROOT_VALUE).writeValueAsString(location);

            HttpResponse<String> resp = Unirest.put(auth.getWhdUrl() + "/{location_id}")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .routeParam("resource_type", "Locations")
                    .routeParam("location_id", locationId)
                    .queryString(auth.generateAuthUrlParams())
                    .body(jsonLocationStream)
                    .asString();

            Util.processResponseForException(resp);
        } catch (UnirestException e) {
            throw new WhdException("Error Creating Ticket: " + e.getMessage(), e);
        } catch (IOException e) {
            throw Util.processJsonMapperIOException(e);
        }
    }

    public static void deleteLocation(WhdAuth auth, LocationDefinition location) throws WhdException {
        try {
            String locationId = String.format("%d", location.getId());
            log.debug("updateLocation(<LocationDefinition;id={}>)", locationId);

            String jsonLocationStream = Util.jsonMapper.writer().without(SerializationFeature.WRAP_ROOT_VALUE).writeValueAsString(location);

            HttpResponse<String> resp = Unirest.delete(auth.getWhdUrl() + "/{location_id}")
                    .header("accept", "application/json")
                    .routeParam("resource_type", "Locations")
                    .routeParam("location_id", locationId)
                    .queryString(auth.generateAuthUrlParams())
                    .asString();

            Util.processResponseForException(resp);

            LocationDefinition loc = Util.jsonMapper.readValue(resp.getBody(), LocationDefinition.class);

            if (!Objects.equals(loc.getId(), location.getId())) {
                throw new WhdException("Did not receive confirmation for Location Deletion from WHD");
            }
        } catch (UnirestException e) {
            throw new WhdException("Error Creating Ticket: " + e.getMessage(), e);
        } catch (IOException e) {
            throw Util.processJsonMapperIOException(e);
        }
    }

}
