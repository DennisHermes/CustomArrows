package me.goodgamer123.CustomArrows;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin implements Listener {


	@Override
	public void onEnable() {
		
		getServer().getPluginManager().registerEvents(new ShootBowEvent(), this);
		getServer().getPluginManager().registerEvents(new ArrowHitEvent(), this);
		
		Bukkit.addRecipe(Recipe.bundle_of_arrows_Recipe());
		Bukkit.addRecipe(Recipe.diamond_arrow_Recipe());
		Bukkit.addRecipe(Recipe.end_crystal_arrow_Recipe());
		Bukkit.addRecipe(Recipe.fish_arrow_Recipe());
		Bukkit.addRecipe(Recipe.infinity_Recipe());
		
	}
	
	
	
}


