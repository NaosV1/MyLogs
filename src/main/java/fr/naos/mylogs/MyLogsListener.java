package fr.naos.mylogs;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;

import java.awt.*;
import java.io.IOException;

import static fr.naos.mylogs.cData.*;

public class MyLogsListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerLoginEvent event) {
        if (!playerJoin) return;
        Player player = event.getPlayer();
        DiscordWebhook webhook = new DiscordWebhook(cData.webhook);
        webhook.setAvatarUrl(logo);
        webhook.setUsername("MyLogs [ " + serverName + " ]");
        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setTitle(playerJoinTitle.replace("%player%", player.getName()))
                .setColor(Color.GREEN)
                .setFooter("By Naos", null)
                .setThumbnail("https://cdn.discordapp.com/attachments/1089189019256111234/1103240597973782583/7431-the-connection-is-excellent.png")

        );
        try {
            webhook.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        if (!playerLeave) return;
        DiscordWebhook webhook = new DiscordWebhook(cData.webhook);
        webhook.setAvatarUrl(logo);
        webhook.setUsername("MyLogs [ " + serverName + " ]");
        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setTitle(playerLeaveTitle.replace("%player%", event.getPlayer().getName()))
                .setColor(Color.RED)
                .setFooter("By Naos", null)
                .setThumbnail("https://cdn.discordapp.com/attachments/1089189019256111234/1103240584711372841/4554_google_dinosaur.png")
        );
        try {
            webhook.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if (!playerChat) return;
        DiscordWebhook webhook = new DiscordWebhook(cData.webhook);
        webhook.setAvatarUrl(logo);
        webhook.setUsername("MyLogs [ " + serverName + " ]");
        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setTitle(playerChatTitle.replace("%player%", event.getPlayer().getName()))
                .setDescription(playerChatDesc.replace("%message%", event.getMessage()))
                .setColor(Color.CYAN)
                .setFooter("By Naos", null)
                .setThumbnail("https://cdn.discordapp.com/attachments/1089189019256111234/1103239521258180628/1960-speechbubble-okay.png")


        );
        try {
            webhook.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        if (!playerCommand) return;
        String message = event.getMessage();
        String command = message.split(" ")[0];
        if (command.equals("/login")
                || command.equals("/register")
                || command.equals("/changepassword")
                || command.equals("/reg")
                || command.equals("/l")
                || command.equals("/log")
                || command.equals("/changepw")) return;

        if (blacklist_player_command.contains(command)) return;

        DiscordWebhook webhook = new DiscordWebhook(cData.webhook);
        webhook.setAvatarUrl(logo);
        webhook.setUsername("MyLogs [ " + serverName + " ]");
        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setTitle(playerCommandTitle.replace("%player%", event.getPlayer().getName()))
                .setDescription(playerCommandDesc.replace("%command%", event.getMessage()))
                .setColor(Color.BLUE)
                .setThumbnail("https://cdn.discordapp.com/attachments/1089189019256111234/1103240866488918046/3107-maintains-commands.png")
                .setFooter("By Naos", null)

        );
        try {
            webhook.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        if (!playerDeath) return;
        DiscordWebhook webhook = new DiscordWebhook(cData.webhook);
        webhook.setAvatarUrl(logo);
        webhook.setUsername("MyLogs [ " + serverName + " ]");
        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setTitle(playerDeathTitle.replace("%player%", event.getEntity().getName()))
                .setDescription(playerDethDesc.replace("%reason%", event.getDeathMessage()))
                .setColor(Color.GRAY)
                .setFooter("By Naos", null)
                .setThumbnail("https://cdn.discordapp.com/attachments/1089189019256111234/1103241051906527272/6534-ghostathletic.png")

        );
        try {
            webhook.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @EventHandler
    public void onKick(PlayerKickEvent event) {
        if (!playerKick) return;
        DiscordWebhook webhook = new DiscordWebhook(cData.webhook);
        webhook.setAvatarUrl(logo);
        webhook.setUsername("MyLogs [ " + serverName + " ]");
        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setTitle(playerKickTitle.replace("%player%", event.getPlayer().getName()))
                .setDescription(playerKickDesc.replace("%player%", event.getPlayer().getName()).replace("%reason%", event.getReason()))
                .setColor(java.awt.Color.RED)
                .setFooter("By Naos", null)
                .setThumbnail("https://cdn.discordapp.com/attachments/1089189019256111234/1103241294593146901/6648_squid_kick.png")

        );
        try {
            webhook.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @EventHandler
    public void onTeleport(PlayerKickEvent event) {
        if (!playerTeleport) return;
        DiscordWebhook webhook = new DiscordWebhook(cData.webhook);
        webhook.setAvatarUrl(logo);
        webhook.setUsername("MyLogs [ " + serverName + " ]");
        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setTitle(playerTeleportTitle.replace("%player%", event.getPlayer().getName()))
                .setColor(Color.MAGENTA)
                .setFooter("By Naos", null)
                .setThumbnail("https://cdn.discordapp.com/attachments/1089189019256111234/1103241761675018261/6088-business-okayge.png")
        );
        try {
            webhook.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
