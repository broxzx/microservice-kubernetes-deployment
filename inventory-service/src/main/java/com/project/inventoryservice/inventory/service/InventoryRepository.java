package com.project.inventoryservice.inventory.service;

import com.project.inventoryservice.inventory.data.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepository extends MongoRepository<Inventory, String> {
}
