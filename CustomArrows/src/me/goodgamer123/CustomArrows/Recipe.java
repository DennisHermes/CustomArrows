package me.goodgamer123.CustomArrows;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

public class Recipe {

	static ShapedRecipe bundle_of_arrows_Recipe() {
		
		NamespacedKey key = new NamespacedKey(MainClass.getPlugin(MainClass.class), "bundle_of_arrow");
		ShapedRecipe recipe = new ShapedRecipe(key, Arrows.bundle_of_arrows);
		
		recipe.shape("AAA", "AAA", "AAA");
		recipe.setIngredient('A', Material.ARROW);
		
		return recipe;
	}
	
	static ShapedRecipe diamond_arrow_Recipe() {
		
		NamespacedKey key = new NamespacedKey(MainClass.getPlugin(MainClass.class), "diamond_arrow");
		ShapedRecipe recipe = new ShapedRecipe(key, Arrows.diamond_arrow);
		
		recipe.shape("DDD", "DAD", "DDD");
		recipe.setIngredient('D', Material.DIAMOND);
		recipe.setIngredient('A', Material.ARROW);
		
		return recipe;
	}
	
	static ShapelessRecipe end_crystal_arrow_Recipe() {
		
		NamespacedKey key = new NamespacedKey(MainClass.getPlugin(MainClass.class), "end_crystal_arrow");
		ShapelessRecipe recipe = new ShapelessRecipe(key, Arrows.end_crystal_arrow);
		
		recipe.addIngredient(Material.ARROW);
		recipe.addIngredient(Material.END_CRYSTAL);
		
		return recipe;
	}
	
	static ShapedRecipe fish_arrow_Recipe() {
		
		NamespacedKey key = new NamespacedKey(MainClass.getPlugin(MainClass.class), "fish_arrow");
		ShapedRecipe recipe = new ShapedRecipe(key, Arrows.fish_arrow);
		
		recipe.shape("SCS", "CAC", "SCS");
		recipe.setIngredient('S', Material.SALMON);
		recipe.setIngredient('C', Material.COD);
		recipe.setIngredient('A', Material.ARROW);
		
		return recipe;
	}
	
	static ShapelessRecipe infinity_Recipe() {
		
		NamespacedKey key = new NamespacedKey(MainClass.getPlugin(MainClass.class), "infinity_arrow");
		ShapelessRecipe recipe = new ShapelessRecipe(key, Arrows.infinity_arrow);
		
		recipe.addIngredient(new RecipeChoice.ExactChoice(Arrows.bundle_of_arrows));
		recipe.addIngredient(new RecipeChoice.ExactChoice(Arrows.diamond_arrow));
		recipe.addIngredient(new RecipeChoice.ExactChoice(Arrows.end_crystal_arrow));
		recipe.addIngredient(new RecipeChoice.ExactChoice(Arrows.fish_arrow));
		recipe.addIngredient(Material.DIAMOND_BLOCK);
		
		return recipe;
	}

}
