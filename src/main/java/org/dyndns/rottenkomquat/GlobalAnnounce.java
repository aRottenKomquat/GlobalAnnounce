package org.dyndns.rottenkomquat;

import net.md_5.bungee.api.plugin.Plugin;

public class GlobalAnnounce extends Plugin {

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerListener(this, new GlobalAnnounceListener());
    }

}