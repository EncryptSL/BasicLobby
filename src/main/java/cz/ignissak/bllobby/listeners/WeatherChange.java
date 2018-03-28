package cz.ignissak.bllobby.listeners;

import cz.ignissak.bllobby.Core;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherChange implements Listener{

    @EventHandler(priority = EventPriority.HIGHEST)
    public void WeatherChangeEvent(WeatherChangeEvent event) {
        if (!event.toWeatherState()) return;
        if (Core.getInstance().getConfig().getString("weather.disabled-in").contains(event.getWorld().getName())) {
            event.setCancelled(true);
            event.getWorld().setWeatherDuration(0);
            event.getWorld().setThundering(false);
        }
    }
}
