package pl.org.mensa.rp.mc.MultiWhitelist;

import javax.annotation.Nonnull;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {
	@Override
	public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command cmd, @Nonnull String alias, @Nonnull String[] args) {
		if (!(sender instanceof Player)) {
			ServerCommandListener.enabled = true;
			sender.sendMessage("&aWhitelist mode enabled. Typed commands will be added to whitelist as players. To stop adding simply type &b;".replaceAll("&", "§"));
		}
		
		return true;
	}
}
