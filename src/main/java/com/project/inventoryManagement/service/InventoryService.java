package com.project.inventoryManagement.service;

import com.project.inventoryManagement.exception.InvalidItemDataException;
import com.project.inventoryManagement.exception.ItemNotFoundException;
import com.project.inventoryManagement.model.InventoryItem;
import com.project.inventoryManagement.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<InventoryItem> getAllItems() {
        return inventoryRepository.findAll();
    }

    public Optional<InventoryItem> getItemById(Long id) {
        return inventoryRepository.findById(id);
    }

    public InventoryItem addItem(InventoryItem item) {
        if (item.getName() == null || item.getName().isEmpty()) {
            throw new InvalidItemDataException("Item name cannot be empty");
        }
        return inventoryRepository.save(item);
    }

    public InventoryItem updateItem(Long id, InventoryItem updatedItem) {
        if (!inventoryRepository.existsById(id)) {
            throw new ItemNotFoundException("Item with ID " + id + " not found");
        }
            updatedItem.setId(id);
            return inventoryRepository.save(updatedItem);
    }

    public void deleteItem(Long id) {
        inventoryRepository.deleteById(id);
    }
}
