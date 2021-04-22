package qc.speque;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GadgetUtils {
	
	public static void createItem(Inventory inv, String name, Material mat, Integer i) {
		ItemStack pig = new ItemStack(mat, i);
		ItemMeta pigm = pig.getItemMeta();
		pigm.setDisplayName(name);
		pig.setItemMeta(pigm);
		addIt(inv, pig);
		
	}
	public static void addIt(Inventory inv, ItemStack stack) {
		inv.addItem(stack);
	}

}
