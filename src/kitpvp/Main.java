package br.jaguar.kitpvp;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import br.jaguar.commands.KitsCommand;
import br.jaguar.commands.WarpCommands;
import br.jaguar.eventslisteners.BowEvent;
import br.jaguar.eventslisteners.MenuKits;
import br.jaguar.eventslisteners.Motd;
import br.jaguar.eventslisteners.TagChatListener;
import br.jaguar.util.Configs;
import br.jaguar.warps.Warps;


public class Main extends JavaPlugin implements Listener{

	
	
	
	public static HashMap<String, Location> warps = new HashMap<String, Location>();
	
	private void loadCommands() {
		getCommand("warps").setExecutor(new WarpCommands());
		getCommand("warp").setExecutor(new WarpCommands());
		getCommand("kits").setExecutor(new KitsCommand());
	}
	
	
	@Override
	public void onEnable() {
		Configs.plugin = this;
		saveDefaultConfig();
		ConsoleCommandSender cmd = Bukkit.getConsoleSender();
		cmd.sendMessage("§8Plugin iniciado!");
		cmd.sendMessage(getConfig().getStringList("tag.membro").toString());
		Bukkit.getPluginManager().registerEvents(new MenuKits(), this);
		Bukkit.getPluginManager().registerEvents(new TagChatListener(), this);
		Bukkit.getPluginManager().registerEvents(new Motd(), this);
		Bukkit.getPluginManager().registerEvents(new BowEvent(), this);
		Bukkit.getPluginManager().registerEvents(this, this);
		Warps.loadWarps();
		loadCommands();
	}
	
	@Override
	public void onDisable() {
		ConsoleCommandSender cmd = Bukkit.getConsoleSender();
		cmd.sendMessage("§8Plugin fechado!");
	}
	
	
}
