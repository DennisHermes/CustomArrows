package me.goodgamer123.CustomArrows;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.ElderGuardian;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.metadata.FixedMetadataValue;

public class ArrowHitEvent implements Listener {
	
	static HashMap<Player, Integer> lastShotArrow = new HashMap<Player, Integer>();
	
	@EventHandler
	public void arrowHitEvent(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Arrow) {
			if (((Arrow) (e.getDamager())).getShooter() instanceof Player) {
				if (lastShotArrow.get(((Arrow) (e.getDamager())).getShooter()) == 200) {
					if (((Damageable) e.getEntity()).getHealth() - e.getDamage() <= 0) {
						Firework fw = (Firework) e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.FIREWORK);
				        FireworkMeta fwm = fw.getFireworkMeta();
				        fw.setMetadata("nodamage", new FixedMetadataValue(MainClass.getPlugin(MainClass.class), true));
				        fwm.setPower(1);
				        fwm.addEffect(FireworkEffect.builder().withColor(Color.AQUA).trail(true).build());
				        fw.setFireworkMeta(fwm);
				        fw.detonate();
				        Random r = new Random();
				        int randomNum = r.nextInt(3);
				        if (randomNum == 0) e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(Material.DIAMOND));
				        else if (randomNum == 1) e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(Material.GOLD_INGOT));
				        else if (randomNum == 2) e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(Material.ENDER_PEARL));
					}
				} else if (lastShotArrow.get(((Arrow) (e.getDamager())).getShooter()) == 500) {
					if (e.getEntity() instanceof Player || e.getEntity() instanceof Wither || e.getEntity() instanceof EnderDragon || e.getEntity() instanceof ElderGuardian) return;
					e.getEntity().remove();
					for (int i = 0; i < 6; i++) {
						Random r = new Random();
				        int randomNum0 = r.nextInt(4);
						if (randomNum0 == 0) e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.COD);
						if (randomNum0 == 1) e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.SALMON);
						if (randomNum0 == 2) e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.TROPICAL_FISH);
						if (randomNum0 == 3) e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.PUFFERFISH);
					}
					e.getEntity().getWorld().spawnParticle(Particle.WATER_SPLASH, e.getEntity().getLocation(), 2000, 0.5F, 0F, 0.5F);
					e.getEntity().getWorld().spawnParticle(Particle.WATER_BUBBLE, e.getEntity().getLocation(), 1000, 0.5F, 0F, 0.5F);
					e.getEntity().getWorld().spawnParticle(Particle.WATER_WAKE, e.getEntity().getLocation(), 500, 0.5F, 0F, 0.5F);
					e.getEntity().getWorld().spawnParticle(Particle.WATER_DROP, e.getEntity().getLocation(), 500, 0F, 0.2F, 0.5F);
				} else if (lastShotArrow.get(((Arrow) (e.getDamager())).getShooter()) == 600) {
					((Damageable) e.getEntity()).damage(2 * e.getDamage());
					e.getEntity().getWorld().spawnParticle(Particle.SPELL_WITCH, e.getEntity().getLocation(), 32, 1.2F, 0F, 1.2F);
					e.getEntity().getWorld().spawnParticle(Particle.FIREWORKS_SPARK, e.getEntity().getLocation(), 16, 0.2F, 0F, 0.2F);
					e.getEntity().getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE, e.getEntity().getLocation(), 32, 0.3F, 0.2F, 0.3F);
					e.getEntity().getWorld().spawnParticle(Particle.CRIT_MAGIC, e.getEntity().getLocation(), 16, 0.3F, 0.2F, 0.3F);
				}
			}
		} else if (e.getDamager() instanceof Firework) {
		    Firework fw = (Firework) e.getDamager();
		    if (fw.hasMetadata("nodamage")) {
		        e.setCancelled(true);
		    }
		}
	}
}
