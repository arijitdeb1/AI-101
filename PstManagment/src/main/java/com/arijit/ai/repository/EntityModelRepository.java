package com.arijit.ai.repository;

import com.arijit.ai.model.EntityModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface EntityModelRepository extends JpaRepository<EntityModel, Integer> {
    EntityModel findByName(String name);

    List<EntityModel> findByItemTypeAndAttributesContaining(String ioi, String category);
}
