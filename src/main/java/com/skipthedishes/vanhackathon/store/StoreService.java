package com.skipthedishes.vanhackathon.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreService {

    private StoreRepository stores;

    @Autowired
    public StoreService(StoreRepository stores) {
        this.stores = stores;
    }

    public Store save(Store store) {
        return stores.save(store);
    }

    public Optional<Store> findById(Long id) {
        return stores.findById(id);
    }


}
