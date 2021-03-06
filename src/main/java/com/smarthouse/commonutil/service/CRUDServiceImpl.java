package com.smarthouse.commonutil.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class CRUDServiceImpl<Item, Key extends Serializable> implements CRUDService<Item, Key> {

    private final JpaRepository<Item, Key> repository;

    public CRUDServiceImpl(final JpaRepository<Item, Key> repository) {
        this.repository = repository;
    }

    @Override
    public List<Item> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Item> getById(final Key id) {
        return Optional.ofNullable(repository.findOne(id));
    }

    @Override
    public void delete(final Item item) {
        repository.delete(item);
    }

    @Override
    public void deleteById(final Key id) {
        repository.delete(id);
    }

    @Override
    public Item save(final Item item) {
        return repository.saveAndFlush(item);
    }
}
