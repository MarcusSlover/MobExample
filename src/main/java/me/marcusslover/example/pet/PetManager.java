package me.marcusslover.example.pet;

import me.marcusslover.example.utils.IManager;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.*;

public class PetManager implements IManager<Pet> {

    private final Map<UUID, ActivePet> activePets = new HashMap<>();
    private final List<Pet> pets = new ArrayList<>();
    static List<Integer> entities = new ArrayList<>();

    private static PetManager instance;

    public static PetManager getInstance() {
        return instance;
    }

    public PetManager() {
        instance = this;
    }

    @Override
    public void initialize() {
        this.register(new Pet("slime", EntityType.SLIME));
        this.register(new Pet("villager", EntityType.VILLAGER));
    }

    @Override
    public void register(Pet pet) {
        this.pets.add(pet);
    }

    @Override
    public List<Pet> getAll() {
        return this.pets;
    }

    public void spawnPet(Player player, Pet foundPet) {
        UUID uniqueId = player.getUniqueId();
        ActivePet activePet = this.activePets.getOrDefault(uniqueId, null);
        if (activePet != null) {
            // Despawn
            activePet.destroy();
        }
        // Spawn
        activePet = new ActivePet(player, foundPet);
        activePet.spawn();
        this.activePets.put(uniqueId, activePet);
    }

    public Map<UUID, ActivePet> getActivePets() {
        return activePets;
    }
}
