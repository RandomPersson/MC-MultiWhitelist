package pl.org.mensa.rp.mc.MultiWhitelist;

import org.bukkit.plugin.java.JavaPlugin;

public class MultiWhitelistPlugin extends JavaPlugin {
	@Override
	public void onEnable() {
		this.getCommand("multiwhitelist").setExecutor(new CommandHandler());
		this.getServer().getPluginManager().registerEvents(new ServerCommandListener(this), this);
	}
}
