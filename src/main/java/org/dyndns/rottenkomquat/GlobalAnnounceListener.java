package org.dyndns.rottenkomquat;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class GlobalAnnounceListener implements Listener {
    @EventHandler
    public void onPostLogin(PostLoginEvent event) 
    {
    	TextComponent msg = new TextComponent(event.getPlayer().getName());
    	msg.setColor(ChatColor.GREEN);
    	TextComponent msg2 = new TextComponent(" has joined the network.");
    	msg2.setColor(ChatColor.YELLOW);
    	msg.addExtra(msg2);
        for (ProxiedPlayer player: ProxyServer.getInstance().getPlayers())
        {
        	player.sendMessage(msg);
        }
    }
    
    @EventHandler
    public void onPlayerDisconnect(PlayerDisconnectEvent event)
    {
    	ProxiedPlayer leaving = event.getPlayer();
    	TextComponent msg = new TextComponent(event.getPlayer().getName());
    	msg.setColor(ChatColor.GREEN);
    	TextComponent msg2 = new TextComponent(" has left the network.");
    	msg2.setColor(ChatColor.YELLOW);
    	msg.addExtra(msg2);
        for (ProxiedPlayer player: ProxyServer.getInstance().getPlayers())
        {
        	if (leaving != player)
        		player.sendMessage(msg);
        }
    }
}