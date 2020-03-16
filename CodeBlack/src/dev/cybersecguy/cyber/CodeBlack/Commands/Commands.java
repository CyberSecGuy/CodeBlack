package dev.cybersecguy.cyber.CodeBlack.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.cybersecguy.cyber.CodeBlack.CodeBlack;

public class Commands {
	public CodeBlack plugin;

	String[] args;

	public Commands(CodeBlack instance) {
		plugin = instance;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
		String commandName = command.getName().toLowerCase();
		if (!(sender instanceof Player)) {
			CodeBlack.log.info("This command must be run in game.");
			return true;
		} else {
			final Player player = (Player) sender;
			if (commandName.equalsIgnoreCase("codeblack")) {
				if (!player.hasPermission(CodeBlack.permNode)) {
					player.sendMessage(CodeBlack.noPerm);
				} else {
					
					// do commands
					
				}
			}
		}

		// End of Command
		return true;
	}
}
