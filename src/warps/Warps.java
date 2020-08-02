package br.jaguar.warps;

import java.util.HashMap;

import org.bukkit.Location;



public class Warps {

	public static HashMap<String, Location> warps = new HashMap<String, Location>();
	
	
	public static void loadWarps() {
		warps.put("spawn", new Location(null,18.7, 94, 189.6));
	}
}
