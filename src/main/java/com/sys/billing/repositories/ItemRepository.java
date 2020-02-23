package com.sys.billing.repositories;

import com.sys.billing.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findItemByItemId(UUID uuid);
    Item findItemByItemName(String name);
}
