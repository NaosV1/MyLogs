package fr.naos.mylogs;

import org.bukkit.ChatColor;

import java.util.List;

public class cData {

    public static String lang;
    public static String prefix;
    public static String webhook;
    public static String serverName;
    public static String logo;
    public static String logo_up;
    public static String logo_down;
    public static String enabled;
    public static String enabled_message;
    public static String disabled;
    public static String disabled_message;
    public static boolean start;
    public static boolean stop;
    public static boolean playerJoin;
    public static boolean playerLeave;
    public static boolean playerChat;
    public static boolean playerCommand;
    public static boolean playerDeath;
    public static boolean playerKick;
    public static boolean playerTeleport;
    public static String playerJoinTitle;
    public static String playerJoinDesc;
    public static String playerLeaveTitle;
    public static String playerChatTitle;
    public static String playerChatDesc;
    public static String playerCommandTitle;
    public static String playerCommandDesc;
    public static String playerDeathTitle;
    public static String playerDethDesc;
    public static String playerKickTitle;
    public static String playerKickDesc;
    public static String playerTeleportTitle;
    public static String help;
    public static String reload;
    public static List<String> blacklist_player_command;

    public static void load() {
        lang = MyLogs.getInstance().getConfig().getString("lang");
        prefix = MyLogs.getInstance().getConfig().getString("prefix");
        prefix = ChatColor.translateAlternateColorCodes('&', prefix);
        webhook = MyLogs.getInstance().getConfig().getString("webhook");
        serverName = MyLogs.getInstance().getConfig().getString("server_name");
        logo = "https://cdn.discordapp.com/attachments/1089189019256111234/1089189108485734612/MyLogs.png";
        logo_up = "https://cdn.discordapp.com/attachments/1089189019256111234/1089201382168473620/7725_arrow_up.png";
        logo_down = "https://cdn.discordapp.com/attachments/1089189019256111234/1089201618697846854/2841_arrow_down.png";
        start = MyLogs.getInstance().getConfig().getBoolean("logs.start");
        stop = MyLogs.getInstance().getConfig().getBoolean("logs.stop");
        playerJoin = MyLogs.getInstance().getConfig().getBoolean("logs.player_join");
        playerLeave = MyLogs.getInstance().getConfig().getBoolean("logs.player_leave");
        playerChat = MyLogs.getInstance().getConfig().getBoolean("logs.player_chat");
        playerCommand = MyLogs.getInstance().getConfig().getBoolean("logs.player_command");
        playerDeath = MyLogs.getInstance().getConfig().getBoolean("logs.player_death");
        playerKick = MyLogs.getInstance().getConfig().getBoolean("logs.player_kick");
        playerTeleport = MyLogs.getInstance().getConfig().getBoolean("logs.player_teleport");
        blacklist_player_command = MyLogs.getInstance().getConfig().getStringList("logs.blacklist_player_command");

        if (lang.equalsIgnoreCase("fr")) {
            reload = prefix + "§aConfiguration rechargée !";
            help = prefix + "§fPage d'Aide :\n§7- §b/mylogs §ehelp §7- §fAffiche cette page\n§7- §b/mylogs §ereload §7- §fRecharger le plugin";
            enabled = "<:MyLogs:1089197501292232785> Le serveur %server% est allumé !";
            enabled_message = "Vous recevrez toutes les logs dans ce salon !";
            disabled = "<:MyLogs:1089197501292232785> Le serveur %server% s'est éteint !";
            disabled_message = "Vous ne recevrez plus d'information sur le serveur %server% !";
            playerJoinTitle = "%player% a rejoint le serveur !";
            playerJoinDesc = "Il a rejoint via l'ip %ip% !";
            playerLeaveTitle = "%player% a quitté le serveur !";
            playerChatTitle = "%player% a envoyé un message !";
            playerChatDesc = "%message%";
            playerCommandTitle = "%player% a utilisé une commande !";
            playerCommandDesc = "%command%";
            playerDeathTitle = "%player% est mort !";
            playerDethDesc = "Raison : %reason%";
            playerKickTitle = "%player% a été kick !";
            playerKickDesc = "Raison : %reason%";
            playerTeleportTitle = "%player% s'est téléporté !";
        } else {
            reload = prefix + "§aConfiguration reloaded !";
            help = prefix + "§fHelp page :\n§7- §b/mylogs §ehelp §7- §fShow this page\n§7- §b/mylogs §ereload §7- §fReload the plugin";
            enabled = "<:MyLogs:1089197501292232785> The server %server% is enabled !";
            disabled = "<:MyLogs:1089197501292232785> The server %server% is now off !";
            enabled_message = "You will recieve all logs in this channel";
            disabled_message = "You won't recieve any information about %server% !";
            playerJoinTitle = "%player% has joined the server !";
            playerJoinDesc = "He joined via the ip %ip% !";
            playerLeaveTitle = "%player% has left the server !";
            playerChatTitle = "%player% has sent a message !";
            playerChatDesc = "%message%";
            playerCommandTitle = "%player% has used a command !";
            playerCommandDesc = "%command%";
            playerDeathTitle = "%player% has died !";
            playerDethDesc = "Reason : %reason%";
            playerKickTitle = "%player% has been kicked !";
            playerKickDesc = "Reason : %reason%";
            playerTeleportTitle = "%player% has teleported !";
        }
    }

}
