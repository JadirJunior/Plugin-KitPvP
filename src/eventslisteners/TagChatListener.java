package br.jaguar.eventslisteners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import br.jaguar.util.Configs;
import net.md_5.bungee.api.ChatColor;


public class TagChatListener implements Listener{

	
	@EventHandler
	public void onChatMessage(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		 if (Configs.getStringList("tag.admin").contains(p.getName())) {
			e.setFormat(ChatColor.RED + "[ADMIN]"+ ChatColor.BOLD +p.getName() + ">> §f" + e.getMessage());
		} else if (Configs.getStringList("tag.membro").contains(p.getName())) {
			e.setFormat(ChatColor.GRAY + p.getName() + ": "+ ChatColor.DARK_GRAY + e.getMessage());
		} else if (Configs.getStringList("tag.viplus").contains(p.getName())) {
			e.setFormat(ChatColor.YELLOW + p.getName() + "> "+ ChatColor.DARK_GRAY + e.getMessage());
		} else if (Configs.getStringList("tag.mod").contains(p.getName())) {
			e.setFormat(ChatColor.WHITE + p.getName().toUpperCase() + "> §0" + e.getMessage());
		} 
	}
	
}
