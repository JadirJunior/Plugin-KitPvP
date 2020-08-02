package br.jaguar.eventslisteners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;


public class Motd implements Listener{

	@EventHandler
	public void setMotd(ServerListPingEvent e) {
		e.setMaxPlayers(70);
		e.setMotd("§0Kit §4PvP§f: Bem Vindo! " + "\n" + "§fServer De Kit PvP! Entre e Divirta-se!");
	}
}
