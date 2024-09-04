package com.project.inventoryservice.inventory.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inventory")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Inventory {

    private String id;

    private String name;

    private int available;

}
