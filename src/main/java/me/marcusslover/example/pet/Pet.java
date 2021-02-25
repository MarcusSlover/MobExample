package me.marcusslover.example.pet;

import org.bukkit.entity.EntityType;

public class Pet {
    private final String name;
    private final EntityType entityType;

    public Pet(String name, EntityType entityType) {
        this.name = name;
        this.entityType = entityType;
    }

    public String getName() {
        return name;
    }

    public EntityType getEntityType() {
        return entityType;
    }
}
