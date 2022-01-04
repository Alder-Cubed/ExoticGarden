package io.github.thebusybiscuit.exoticgarden.listeners;

import javax.annotation.Nonnull;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import io.github.thebusybiscuit.exoticgarden.ExoticGarden;
import io.github.thebusybiscuit.slimefun4.api.events.AndroidFarmEvent;
import org.bukkit.inventory.ItemStack;

public class AndroidListener implements Listener {

    public AndroidListener(@Nonnull ExoticGarden plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(ignoreCancelled = true)
    public void onGrow(AndroidFarmEvent e) {
        // Only for the advanced harvesting action
        if (e.isAdvanced() && e.getDrop() == null) {
            // Allow Androids to harvest our plants
            ItemStack[] drops = ExoticGarden.harvestPlant(e.getBlock());
            if (drops != null && drops.length > 0 && drops[0] != null)
                e.setDrop(drops[0]);
        }
    }
}
