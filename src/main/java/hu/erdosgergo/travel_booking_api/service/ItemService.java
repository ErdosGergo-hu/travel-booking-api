package hu.erdosgergo.travel_booking_api.service;

import hu.erdosgergo.travel_booking_api.model.Item;
import hu.erdosgergo.travel_booking_api.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item getItem() {
        return itemRepository.findById(1L).orElse(null);
    }

}
