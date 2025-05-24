package com.cesde.proyecto_integrador.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cesde.proyecto_integrador.model.Item;
import com.cesde.proyecto_integrador.repository.ItemRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/test")

public class ItemController {

 
    ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

@Autowired
private ItemRepository itemRepository;

@GetMapping()
public Item getMethodName() {
Item item = new Item();
    item.setNombre("TV");
    item.setCantidad(2);
    item.setDescripcion("tv  4K");
    return itemRepository.save(item);
}

}
