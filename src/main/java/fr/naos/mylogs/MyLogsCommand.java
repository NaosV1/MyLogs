package fr.naos.mylogs;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MyLogsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args.length == 0) sender.sendMessage(cData.help);
        else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                MyLogs.getInstance().reloadConfig();
                cData.load();
                sender.sendMessage(cData.reload);
            }
        }
        return false;
    }
}
