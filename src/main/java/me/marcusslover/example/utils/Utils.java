package me.marcusslover.example.utils;

import org.bukkit.ChatColor;

public class Utils {

    public static String toColor(String string) {
        return toColor(new String[] {string})[0];
    }

    public static String[] toColor(String[] args) {
        for (int i = 0, argsLength = args.length; i < argsLength; i++) {
            String arg = args[i];
            args[i] = ChatColor.translateAlternateColorCodes('&', arg);
        }
        return args;
    }
}
