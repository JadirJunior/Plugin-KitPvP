package br.jaguar.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.jaguar.warps.Warps;

public class WarpCommands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) return false;
		Player p = (Player)sender;
		if (command.getName().equalsIgnoreCase("warp")) {
			if (args.length == 0) {
				p.sendMessage("§7§cPara ir à uma warp digite /warps (nome) e para ver nossa lista de warps digite /warps");
				return true;
			} 
			
			if (args.length > 1) {
				p.sendMessage("§7§cComando inválido, digite /warp (nome da warp)");
				return true;
			}
			
			if (Warps.warps.containsKey(args[0])) {
				double localX = Warps.warps.get(args[0]).getX();
				double localY = Warps.warps.get(args[0]).getY();
				double localZ = Warps.warps.get(args[0]).getZ();
				p.teleport(new Location(p.getWorld(),
						localX, 
						localY,
						localZ
						));
			}
			
		}
		
		if (command.getName().equalsIgnoreCase("warps")) {
			if (args.length>0) {
				p.sendMessage("§0Comando inválido, digite apenas /warps ou /warp (local)");
			}
			else {
				p.sendMessage("§4Atualmente nós temos " + Warps.warps.size() + " warps");
				p.sendMessage("Que são: " + Warps.warps.keySet());
			}
		}
		return false;
	}

}
