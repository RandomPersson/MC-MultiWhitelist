package pl.org.mensa.rp.mc.MultiWhitelist;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerCommandEvent;

public class ServerCommandListener implements Listener {
	public static boolean enabled = false;
	private MultiWhitelistPlugin plugin;
	
	private List<String> list;
	
	public ServerCommandListener(MultiWhitelistPlugin plugin) {
		this.plugin = plugin;
		list = new ArrayList<String>(10);
	}
	
	@EventHandler
	public void onCommandPreProcess(ServerCommandEvent e) {
		if (e.getSender() instanceof Player) {
			return;
		}
		
		if (!enabled) {
			return;
		}
		
		e.setCancelled(true);
		
		if (e.getCommand().startsWith("$register ")) {
			
		}
		
		if (e.getCommand().endsWith(";")) {
			if (e.getCommand().length() > 1) {
				addToList(e.getCommand());
			}
			
			enabled = false;
			System.out.println("&aWhitelist mode disabled.".replaceAll("&", "§"));
			
			actuallyWhitelist();
			reset();
			
			return;
		}
		
		addToList(e.getCommand());
	}
	
	private void addToList(String player) {
		list.add(player.replaceAll("(\\$register\\s*|<|>|'|\"|\\!|@|#|\\$|%|\\^|&|\\*|;|\\\\|/)", ""));
	}
	
	private void reset() {
		list.clear();
	}
	
	private void actuallyWhitelist() {
		for (String player : list) {
			System.out.println(("&7Whitelisting &e" + player + "&7...").replaceAll("&", "§"));
			plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "whitelist add " + player);
		}
	}
}
