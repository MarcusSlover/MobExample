package me.marcusslover.example.command;

import me.marcusslover.example.pet.Pet;
import me.marcusslover.example.pet.PetManager;
import me.marcusslover.example.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PetCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 1) {
                String petName = args[0];
                Pet foundPet = null;

                for (Pet pet : PetManager.getInstance().getAll()) {
                    if (pet.getName().equalsIgnoreCase(petName)) {
                        foundPet = pet;
                        break;
                    }
                }
                // Pet found.
                if (foundPet != null) {
                    PetManager.getInstance().spawnPet(player, foundPet);
                } else {
                    player.sendMessage(Utils.toColor("&cPet with this name doesn't exist!"));
                }
            } else {
                player.sendMessage(Utils.toColor("&cCorrect usage: /pet <name>!"));
            }

        }
        return true;
    }
}
