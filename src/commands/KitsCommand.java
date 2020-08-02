package br.jaguar.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitsCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {	
			Player p = (Player)sender;
			
			if (command.getName().equalsIgnoreCase("kits")) {
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
				p.openInventory(inventario);
			} 
			
			
		}
		return false;
	}

}
