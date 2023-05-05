package fr.naos.mylogs;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

import static fr.naos.mylogs.cData.*;

public final class MyLogs extends JavaPlugin {
    public static MyLogs instance;
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        PluginManager pm = getServer().getPluginManager();
        getCommand("mylogs").setExecutor(new MyLogsCommand());
        Metrics metrics = new Metrics(this, 18054);
        pm.registerEvents(new MyLogsListener(), this);
        cData.load();
        start();
    }

    @Override
    public void onDisable() {
        stop();
    }

    public static MyLogs getInstance() {
        return instance;
    }

    private void stop() {
        if (!stop) return;
        DiscordWebhook webhook = new DiscordWebhook(cData.webhook);
        webhook.setAvatarUrl(logo);
        webhook.setUsername("MyLogs [ " + serverName + " ]");
        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setTitle(disabled.replace("%server%", serverName))
                .setDescription(disabled_message.replace("%server%", serverName))
                .setColor(java.awt.Color.RED)
                .setThumbnail(logo_down)
                .setFooter("By Naos", null)

        );
        try {
            webhook.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void start() {
        if (!start) return;
        DiscordWebhook webhook = new DiscordWebhook(cData.webhook);
        webhook.setAvatarUrl(logo);
        webhook.setUsername("MyLogs [ " + serverName + " ]");
        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setTitle(enabled.replace("%server%", serverName))
                .setDescription(enabled_message)
                .setColor(java.awt.Color.GREEN)
                .setThumbnail(logo_up)
                .setFooter("By Naos", null)
        );
        try {
            webhook.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
