package com.whd;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.whd.autogen.ticket.WhdTicket;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author vikramp
 */
public class WhdApi {
    private static final Logger logger = LoggerFactory.getLogger(WhdApi.class);
    
    public WhdTicket createUpdateTicket (WhdTicket ticket){
        logger.debug("createUpdateTicket(WhdTicket)");
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public WhdTicket createTicket (WhdAuth auth, WhdTicket ticket) throws WhdException{
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
    
    public void updateTicket (WhdAuth auth, WhdTicket ticket) throws WhdException{
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
    
    public WhdTicket getTicket(WhdAuth auth, Integer ticketId) throws WhdException{
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
    
    public List<WhdTicket> getTickets(WhdAuth auth, String qualifier) throws WhdException{
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
    
}
