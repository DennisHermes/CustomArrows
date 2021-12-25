package me.goodgamer123.CustomArrows;

import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class ShootBowEvent implements Listener {

	@EventHandler
	public void onShootBowEvent(EntityShootBowEvent e) {
		if (e.getProjectile() instanceof Arrow) {
			Arrow arrow = (Arrow) e.getProjectile();
			if (arrow.getShooter() instanceof Player) {
				Player p = (Player) arrow.getShooter();
				if (e.getConsumable().getItemMeta().hasCustomModelData()) {
					if (e.getConsumable().getItemMeta().getCustomModelData() == 100) {
						Entity arrow0 = p.getWorld().spawnEntity(p.getLocation().add(0, 1, 0), EntityType.ARROW);
						Entity arrow1 = p.getWorld().spawnEntity(p.getLocation().add(0, 1, 0), EntityType.ARROW);
						Entity arrow2 = p.getWorld().spawnEntity(p.getLocation().add(0, 1, 0), EntityType.ARROW);
						Entity arrow3 = p.getWorld().spawnEntity(p.getLocation().add(0, 1, 0), EntityType.ARROW);
						double muliply = e.getProjectile().getVelocity().length();
						arrow0.setVelocity(p.getLocation().getDirection().clone().rotateAroundY(0.2).multiply(muliply));
						arrow1.setVelocity(p.getLocation().getDirection().clone().rotateAroundY(-0.2).multiply(muliply));
						arrow2.setVelocity(p.getLocation().getDirection().clone().rotateAroundY(0.4).multiply(muliply));
						arrow3.setVelocity(p.getLocation().getDirection().clone().rotateAroundY(-0.4).multiply(muliply));
					} else if (e.getConsumable().getItemMeta().getCustomModelData() == 400) {
						arrow.remove();
						Entity newArrow = p.getWorld().spawnEntity(p.getLocation().add(0, 1, 0), EntityType.ARROW);
						newArrow.setGravity(false);
						newArrow.setVelocity(p.getLocation().getDirection().multiply(7.5D));
						p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDER_PEARL_THROW, 10, 1);
						new BukkitRunnable() { 
							@Override
							public void run() {
								p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SHULKER_TELEPORT, 10, 1);
							}
						}.runTaskLater(MainClass.getPlugin(MainClass.class), 5);
					} else if (e.getConsumable().getItemMeta().getCustomModelData() == 600) {
						new BukkitRunnable() { 
							@Override
							public void run() {
								p.getInventory().addItem(Arrows.infinity_arrow);
								p.getWorld().playSound(p.getLocation(), Sound.ITEM_CHORUS_FRUIT_TELEPORT, 10, 1);
							}
						}.runTaskLater(MainClass.getPlugin(MainClass.class), 40);
					}
				ArrowHitEvent.lastShotArrow.put(p, e.getConsumable().getItemMeta().getCustomModelData());
				} else ArrowHitEvent.lastShotArrow.put(p, 0);
			}
		}
	}
	
}
