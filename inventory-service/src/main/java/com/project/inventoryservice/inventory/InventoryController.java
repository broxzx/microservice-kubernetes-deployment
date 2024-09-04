package com.project.inventoryservice.inventory;

import com.project.inventoryservice.inventory.data.Inventory;
import com.project.inventoryservice.inventory.service.InventoryService;
import com.project.inventoryservice.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping("/check")
    public void checkAvailability(@RequestBody Order order) {
        log.info("{}", order);
        inventoryService.checkAvailability(order);
    }

    @PostMapping
    public ResponseEntity<Inventory> createItem(@RequestBody Inventory inventory) {
        return ResponseEntity.ok(inventoryService.createItem(inventory));
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> getAll() {
        return ResponseEntity.ok(inventoryService.getAll());
    }


}
