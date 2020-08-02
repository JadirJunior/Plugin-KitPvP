package br.jaguar.eventslisteners;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.projectiles.ProjectileSource;

public class BowEvent implements Listener{

	
	@EventHandler
	public void onSendBow(ProjectileHitEvent e) {
		Projectile flecha = e.getEntity();
		ProjectileSource sender = flecha.getShooter();
		if (flecha instanceof Arrow && sender instanceof Player) {
			flecha.getWorld().createExplosion(flecha.getLocation(), 4);
		}
		
	}
}
