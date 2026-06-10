package hu.erdosgergo.online_auction_api.service;

import hu.erdosgergo.online_auction_api.model.Item;
import hu.erdosgergo.online_auction_api.repository.ItemRepository;
import org.springframework.stereotype.Service;

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
