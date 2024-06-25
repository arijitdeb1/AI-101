package com.arijit.ai.service;

import com.arijit.ai.model.EntityModel;
import com.arijit.ai.model.PsnIoiDto;
import com.arijit.ai.repository.EntityModelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PsnIoiService {

    private final EntityModelRepository entityModelRepository;


    public void createPsnIoi(PsnIoiDto psnIoiDto) {
        EntityModel entityModel = new EntityModel();
        entityModel.setName(psnIoiDto.getName());
        entityModel.setItemType(psnIoiDto.getType());
        entityModel.setAttributes(psnIoiDto.getAttributes().toString());
        entityModel.setCreatedDt(new Timestamp(System.currentTimeMillis()));
        entityModelRepository.save(entityModel);
    }

    public boolean validatePsnIoiDetails(PsnIoiDto psnIoiDto) {
    // Rule a: PSN and IOI are unique. No duplicate having same PSN and IOI name are allowed.
    EntityModel existingEntity = entityModelRepository.findByName(psnIoiDto.getName());
    if (existingEntity != null) {
        //log the error
        log.info("The name is already used");
        return false; // The name is already used
    }

    // Rule b: Segment, OPH Modality Code is mandatory for a PSN.
    if ("PSN".equals(psnIoiDto.getType())) {
        //also check the value of Segment and OPH Modality Code is not blank or null


        if ("PSN".equals(psnIoiDto.getType())) {
            String segment = psnIoiDto.getAttributes().get("Segment");
            String ophModalityCode = psnIoiDto.getAttributes().get("OPH Modality Code");

            if (segment == null || segment.isBlank() || ophModalityCode == null || ophModalityCode.isBlank()) {
                log.info("The required attributes are not present");
                return false; // The required attributes are not present
            }
        }
    }

    // Rule c: item Min, item Max, Category Min is mandatory for a IOI. Category Max is optional but if blank should be defaulted to 999.
    if ("IOI".equals(psnIoiDto.getType())) {
        if (!psnIoiDto.getAttributes().containsKey("itemMin") || !psnIoiDto.getAttributes().containsKey("itemMax") || !psnIoiDto.getAttributes().containsKey("categoryMin")) {
            log.info("The required attributes are not present");
            return false; // The required attributes are not present
        }
        if (!psnIoiDto.getAttributes().containsKey("categoryMax")) {
            psnIoiDto.getAttributes().put("categoryMax", "999"); // Default the categoryMax to 999 if it's not present
        }
    }

    // Rule e: IOI is unique for a Category.
    if ("IOI".equals(psnIoiDto.getType())) {
        List<EntityModel> existingEntities = entityModelRepository.findByItemTypeAndAttributesContaining("IOI", psnIoiDto.getAttributes().get("Category"));
        if (!existingEntities.isEmpty()) {
            log.info("The IOI is not unique for the Category");
            return false; // The IOI is not unique for the Category
        }
    }

    return true; // All validations passed
}

}
