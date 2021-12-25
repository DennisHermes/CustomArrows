package me.goodgamer123.CustomArrows;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Arrows {

	static ItemStack bundle_of_arrows = bundle_of_arrows();
	static ItemStack diamond_arrow = diamond_arrow();
	static ItemStack end_crystal_arrow = end_crystal_arrow();
	static ItemStack fish_arrow = fish_arrow();
	static ItemStack infinity_arrow = infinity_arrow();
	
	static private ItemStack bundle_of_arrows() {
		ItemStack arrow = new ItemStack(Material.ARROW);
		ItemMeta arrowMeta = arrow.getItemMeta();
		arrowMeta.setDisplayName(ChatColor.YELLOW + "Bundle of arrows");
		arrowMeta.setCustomModelData(100);
		List<String> arrowLore = new ArrayList<String>();
		arrowLore.add("");
		arrowLore.add(ChatColor.WHITE + "Fires multiple arrows.");
		arrowMeta.setLore(arrowLore);
		arrow.setItemMeta(arrowMeta);
		return arrow;
	}
	
	static private ItemStack diamond_arrow() {
		ItemStack arrow = new ItemStack(Material.ARROW);
		ItemMeta arrowMeta = arrow.getItemMeta();
		arrowMeta.setDisplayName(ChatColor.AQUA + "Diamond arrow");
		arrowMeta.setCustomModelData(200);
		List<String> arrowLore = new ArrayList<String>();
		arrowLore.add("");
		arrowLore.add(ChatColor.WHITE + "Killed mobs will drop");
		arrowLore.add(ChatColor.WHITE + "diamonds, gold and enderpearls.");
		arrowMeta.setLore(arrowLore);
		arrow.setItemMeta(arrowMeta);
		return arrow;
	}
	
	static private ItemStack end_crystal_arrow() {
		ItemStack arrow = new ItemStack(Material.ARROW);
		ItemMeta arrowMeta = arrow.getItemMeta();
		arrowMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "End crystal arrow");
		arrowMeta.setCustomModelData(400);
		List<String> arrowLore = new ArrayList<String>();
		arrowLore.add("");
		arrowLore.add(ChatColor.WHITE + "Super fast and doesn't care");
		arrowLore.add(ChatColor.WHITE + "about gravity.");
		arrowMeta.setLore(arrowLore);
		arrow.setItemMeta(arrowMeta);
		return arrow;
	}
	
	static private ItemStack fish_arrow() {
		ItemStack arrow = new ItemStack(Material.ARROW);
		ItemMeta arrowMeta = arrow.getItemMeta();
		arrowMeta.setDisplayName(ChatColor.YELLOW + "Fish arrow");
		arrowMeta.setCustomModelData(500);
		List<String> arrowLore = new ArrayList<String>();
		arrowLore.add("");
		arrowLore.add(ChatColor.WHITE + "Turns the hit mob into fish.");
		arrowMeta.setLore(arrowLore);
		arrow.setItemMeta(arrowMeta);
		return arrow;
	}
	
	static private ItemStack infinity_arrow() {
		ItemStack arrow = new ItemStack(Material.ARROW);
		ItemMeta arrowMeta = arrow.getItemMeta();
		arrowMeta.setDisplayName("§4I§cn§6f§ei§2n§ai§bt§3y §1a§9r§dr§5o§4w");
		arrowMeta.setCustomModelData(600);
		arrowMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		arrowMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		List<String> arrowLore = new ArrayList<String>();
		arrowLore.add("");
		arrowLore.add(ChatColor.WHITE + "deals triple damage");
		arrowLore.add(ChatColor.WHITE + "and will always return.");
		arrowMeta.setLore(arrowLore);
		arrow.setItemMeta(arrowMeta);
		return arrow;
	}
	
}
