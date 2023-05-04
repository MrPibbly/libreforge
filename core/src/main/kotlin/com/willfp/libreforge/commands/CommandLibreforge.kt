package com.willfp.libreforge.commands

import com.willfp.eco.core.EcoPlugin
import com.willfp.eco.core.command.impl.PluginCommand
import org.bukkit.command.CommandSender

class CommandLibreforge(
    plugin: EcoPlugin
) : PluginCommand(
    plugin,
    "libreforge",
    "libreforge.command.libreforge",
    false
) {
    init {
        this.addSubcommand(CommandReloadExtensions(plugin))
    }

    override fun onExecute(sender: CommandSender, args: MutableList<String>) {
        sender.sendMessage(plugin.langYml.getMessage("invalid-command"))
    }
}