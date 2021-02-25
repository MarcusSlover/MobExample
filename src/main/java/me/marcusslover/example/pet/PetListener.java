package me.marcusslover.example.pet;

import me.marcusslover.example.utils.Utils;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetEvent;

public class PetListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        Entity entity = e.getEntity();
        if (PetManager.entities.contains(entity.getEntityId())) {
            e.setCancelled(true);

            if (e instanceof EntityDamageByEntityEvent) {
                EntityDamageByEntityEvent event = (EntityDamageByEntityEvent) e;
                if (event.getDamager() instanceof Player) {
                    Player damager = (Player) event.getDamager();
                    damager.sendMessage(Utils.toColor("&cYou cannot damage pets!"));
                    damager.playSound(damager.getLocation(), Sound.ENTITY_BAT_HURT, 1.0f, 2.0f);
                }
            }
        }
    }

    @EventHandler
    public void onTarget(EntityTargetEvent e) {
        Entity entity = e.getEntity();
        if (PetManager.entities.contains(entity.getEntityId())) {
            e.setCancelled(true);
        }
    }
}
