package com.project.inventoryManagement.repository;

import com.project.inventoryManagement.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryItem,Long> {

}
