package com.whd;

import com.whd.autogen.CustomFieldDefinition;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author vikramp 
 */
public class WhdCustomFields {
    private static final Logger logger = LoggerFactory.getLogger(WhdCustomFields.class);
        
    public List<CustomFieldDefinition> customFieldDefinitions;
    public Map<String, String> idToFieldName;
    public Map<String, String> fieldNameToId;
    
    public void initializeCustomFields(List<CustomFieldDefinition> custFieldDef){
        
        try{
            customFieldDefinitions = custFieldDef;
            
            if(idToFieldName == null){
                idToFieldName = new HashMap<>();
            }
            else{
                idToFieldName.clear();
            }
            
            if(fieldNameToId == null){
                fieldNameToId = new HashMap<>();
            }
            else{
                fieldNameToId.clear();
            }
            
            logger.debug("Custom Field Definitions: ");
            
            for(CustomFieldDefinition f : customFieldDefinitions){
                idToFieldName.put(String.format("%d", f.getId()), f.getLabel().replace(" ", ""));
                fieldNameToId.put(f.getLabel().replace(" ", ""), String.format("%d", f.getId()));
                
                logger.debug("{} -> {}", f.getId(), f.getLabel());
            }
        }
        catch(Exception e){
            logger.error(getStackTrace(e));
        }
        
    }
}
