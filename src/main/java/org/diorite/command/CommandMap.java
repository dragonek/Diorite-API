package org.diorite.command;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.diorite.plugin.Plugin;

public interface CommandMap
{
    void registerCommand(PluginCommand command);

    Set<MainCommand> getCommandsFromPlugin(Plugin plugin);

    Set<MainCommand> getCommandsFromPlugin(String plugin);

    Set<MainCommand> getCommands(String str);

    Optional<MainCommand> getCommand(Plugin plugin, String str);

    Optional<MainCommand> getCommand(String str);

    Map<String, MainCommand> getCommandMap();

    void dispatch(CommandSender sender, String args);
}
