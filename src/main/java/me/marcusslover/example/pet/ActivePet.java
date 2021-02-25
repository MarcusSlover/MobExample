package me.marcusslover.example.pet;

import me.marcusslover.example.MobExample;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class ActivePet implements Runnable {
    private final Player player;
    private final Pet pet;
    private Entity entity = null;
    private int taskId = -1;

    ActivePet(Player player, Pet pet) {

        this.player = player;
        this.pet = pet;
    }

    @Override
    public void run() {
        Location location = player.getLocation();
        Location location1 = entity.getLocation();

        if (location.distance(location1) >= 7) {
            entity.teleport(location);
        }
    }

    public void destroy() {
        PetManager.entities.remove((Object) entity.getEntityId());
        entity.remove();
        Bukkit.getScheduler().cancelTask(taskId);
    }

    public void spawn() {
        EntityType entityType = pet.getEntityType();
        Location location = player.getLocation();
        World world = location.getWorld();

        this.entity = world.spawnEntity(location, entityType);
        PetManager.entities.add(entity.getEntityId());

        BukkitTask bukkitTask = Bukkit.getScheduler().runTaskTimer(MobExample.getInstance(), this, 0L, 10L);
        this.taskId = bukkitTask.getTaskId();
    }

    public Entity getEntity() {
        return entity;
    }
}
