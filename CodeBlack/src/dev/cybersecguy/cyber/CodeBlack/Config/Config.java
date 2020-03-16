package dev.cybersecguy.cyber.CodeBlack.Config;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import dev.cybersecguy.cyber.CodeBlack.CodeBlack;

public class Config {
	public CodeBlack plugin;

	String[] args;

	public Config(CodeBlack instance) {
		plugin = instance;
	}
	
	public static void loadCfg(CodeBlack plugin) {
		File cfgFile = new File(plugin._datafolder, "config.yml");
		FileConfiguration cfg = new YamlConfiguration();

		try {
			cfg.load(cfgFile);
		} catch (Exception e) {
		}
		
		CodeBlack.debugMode = cfg.getBoolean("Debug");
		CodeBlack.pluginName = cfg.getString("Plugin Name");
		
		if (cfg.getString("Plugin Name") == null) {
			CodeBlack.prefix = ChatColor.translateAlternateColorCodes('&', cfg.getString("Prefix"));
		} else {
			CodeBlack.prefix = ChatColor.translateAlternateColorCodes('&', cfg.getString("Prefix").replaceAll("%name%", CodeBlack.pluginName));
		}
		
		CodeBlack.permNode = cfg.getString("Perm Node");
		CodeBlack.noPerm = cfg.getString("No Permission Notice");
	}
}
