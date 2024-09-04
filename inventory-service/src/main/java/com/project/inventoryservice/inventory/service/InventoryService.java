package com.project.inventoryservice.inventory.service;

import com.project.inventoryservice.inventory.data.Inventory;
import com.project.inventoryservice.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public void checkAvailability(Order order) {
        List<String> itemIds = order.getItemIds();
        List<Inventory> itemsToUpdate = new ArrayList<>();

        itemIds
                .forEach(itemId -> {
                    Inventory inventory = inventoryRepository.findById(itemId)
                            .orElseThrow(() -> new RuntimeException("item with id %s is not found"));

                    inventory.setAvailable(inventory.getAvailable() - order.getAmount());
                    itemsToUpdate.add(inventory);
                });

        inventoryRepository.saveAll(itemsToUpdate);
    }

    public Inventory createItem(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public List<Inventory> getAll() {
        return inventoryRepository.findAll();
    }
}
