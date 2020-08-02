package br.jaguar.eventslisteners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuKits implements Listener{
	
	@EventHandler
	public void inventario(PlayerInteractEvent e) {
		
		if (e.getItem().getType() == Material.COMPASS && e.getAction() == Action.RIGHT_CLICK_AIR) {
				Inventory inventario = Bukkit.createInventory(null, 54, "§6Kits");
				ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
				item.addEnchantment(Enchantment.DAMAGE_ALL, 4);
				ItemMeta itemMeta = item.getItemMeta();
				itemMeta.setDisplayName("§8Guerreiro");
				ArrayList<String> lore = new ArrayList<>(); 
				lore.add("§cKit guerreiro");
				itemMeta.setLore(lore);
				item.setItemMeta(itemMeta);
				ItemStack arco = new ItemStack(Material.BOW);
				arco.addEnchantment(Enchantment.ARROW_INFINITE, 1);
				arco.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
				ItemMeta metaArco = arco.getItemMeta();
				metaArco.setDisplayName("§8Arqueiro");
				ArrayList<String> loreArco = new ArrayList<>();
				loreArco.add("§cKit Arqueiro");
				metaArco.setLore(loreArco);
				arco.setItemMeta(metaArco);
				inventario.setItem(6, arco);
				inventario.setItem(5, item);
				e.getPlayer().openInventory(inventario);
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		e.setJoinMessage("§3§a "+e.getPlayer().getName() + " Entrou");
		e.getPlayer().sendMessage("§8Digite /kits para ver todos os kits possíveis!");
	}
	
	
	@EventHandler
	public void handleClickInventory(InventoryClickEvent e) {
		if (!e.getInventory().getName().equalsIgnoreCase("§6Kits")) return;
		
		if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
			Player p = (Player)e.getWhoClicked();
			p.getInventory().clear();
			ItemStack espada = new ItemStack(Material.DIAMOND_SWORD,1);
			espada.addEnchantment(Enchantment.DAMAGE_ALL, 5);
			p.getInventory().addItem(espada);
			p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
			p.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
			p.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
			p.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
			p.setFoodLevel(20);
			p.setHealth(20.0D);
			p.closeInventory();
		} 
		else if (e.getCurrentItem().getType() == Material.BOW) {
			Player p = (Player)e.getWhoClicked();
			p.getInventory().clear();
			p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET, 1));
			p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
			p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
			p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS, 1));
			ItemStack arcoBolado = new ItemStack(Material.BOW, 1);
			arcoBolado.addEnchantment(Enchantment.ARROW_INFINITE,1);
			p.getInventory().addItem(arcoBolado);
			p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
			p.setFoodLevel(20);
			p.setHealth(20.0D);
			p.closeInventory();
		}
		
		e.setCancelled(true);
	}
	
	
}
