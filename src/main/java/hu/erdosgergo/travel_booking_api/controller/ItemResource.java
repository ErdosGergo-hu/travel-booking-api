package hu.erdosgergo.travel_booking_api.controller;

import hu.erdosgergo.travel_booking_api.model.Item;
import hu.erdosgergo.travel_booking_api.service.ItemService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ItemResource {

    private final ItemService itemService;

    public ItemResource(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public Item getItem() {
        return itemService.getItem();
    }
}
