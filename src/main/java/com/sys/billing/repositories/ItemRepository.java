package com.sys.billing.repositories;

import com.sys.billing.models.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Items, Integer> {
    Items findItemsByItemId(UUID uuid);
}
