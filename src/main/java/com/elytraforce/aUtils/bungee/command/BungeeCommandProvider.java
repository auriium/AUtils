package com.elytraforce.aUtils.bungee.command;

import com.elytraforce.aUtils.bungee.BungeePlugin;
import com.elytraforce.aUtils.core.command.ACommand;
import com.elytraforce.aUtils.core.command.ACommandManager;
import com.elytraforce.aUtils.spigot.SpigotPlugin;
import com.elytraforce.aUtils.spigot.command.SpigotCommandWrapper;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.apache.commons.lang.reflect.FieldUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.plugin.SimplePluginManager;

import java.lang.reflect.Field;

@Singleton
public class BungeeCommandProvider extends ACommandManager {

    @Inject
    private BungeePlugin plugin;

    private SimpleCommandMap commandMap;

    @Inject
    public BungeeCommandProvider(BungeePlugin plugin) {

    }

    @Override
    public void registerCommand(ACommand command) {
        if (this.commands.stream().anyMatch(command1 -> command1.getName().equalsIgnoreCase(command.getName()))) {
            throw new IllegalArgumentException("The commandManager already contains command named " + command.getName());
        }
        if (this.commands.contains(command)) {
            throw new IllegalArgumentException("The commandManager already contains command class " + command.getClass().getName());
        }


        this.commands.add(command);

    }
}
