package dev.cybersecguy.cyber.CodeBlack;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import dev.cybersecguy.cyber.CodeBlack.Commands.Commands;
import dev.cybersecguy.cyber.CodeBlack.Config.Config;

public class CodeBlack extends JavaPlugin implements Listener {

	Server _server = null;
	public static JavaPlugin _parent = null;
	public String _datafolder;
	public boolean _isShutdown = false;
	public static Logger log = Logger.getLogger("Minecraft");
	
	public CodeBlack plugin = this;
	
	// === Command Classes === //
	public Commands cmd = new Commands(plugin);

	// === Config Class === //
	public Config conf = new Config(plugin);

	// === Config === //
	public File pluginFolder = getDataFolder();
	public File cfgFile = new File(pluginFolder, "config.yml");
	public FileConfiguration cfg = new YamlConfiguration();
	public static FileConfiguration langData = new YamlConfiguration();
	public static FileConfiguration playerData = new YamlConfiguration();
	
	// === Config Variables === //
	public static boolean debugMode = false;
	public static String pluginName = "CodeBlack";
	public static String prefix = "[CodeBlack] ";
	public static String permNode = "codeblack.admin";
	public static String noPerm = "Unknown command. Type \"/help\" for help.";
	
	// Initialize
	public boolean Initialize(Server server, JavaPlugin parent, String dataFolder) {
		this._server = server;
		CodeBlack._parent = parent;
		this._datafolder = dataFolder;
		getServer().getPluginManager().registerEvents(this, this);
		return true;
	}
	
	// Enable
	@Override
	public void onEnable() {
		log = this.getLogger();
		Initialize(getServer(), this, getDataFolder().getAbsolutePath() + "/");
		saveDefaultConfig();
		Config.loadCfg(plugin);
	}
	
}
