package tkachgeek.inertiatransfer;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.spigotmc.event.entity.EntityDismountEvent;

public final class InertiaTransfer extends JavaPlugin implements Listener {
  
  @Override
  public void onEnable() {
    Bukkit.getPluginManager().registerEvents(this, this);
  }
  
  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }
  
  @EventHandler
  void onHurry(EntityDismountEvent event) {
    Bukkit.getScheduler().runTask(this, () -> {
      event.getEntity().setVelocity(event.getDismounted().getVelocity());
    });
  }
}

