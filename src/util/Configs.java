package br.jaguar.util;


import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Configs { //Fazer de um jeito decente ksksk
	public static JavaPlugin plugin;
	
	public static FileConfiguration getConfig() {
		return plugin.getConfig();
	}
	
	public static List<String> getStringList(String path) {
		return getConfig().getStringList(path);
	}
}
