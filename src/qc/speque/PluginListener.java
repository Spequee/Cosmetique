package qc.speque;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

public class PluginListener implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		ItemStack customCompass = new ItemStack(Material.ENDER_CHEST, 1);
		ItemMeta metaCompass = customCompass.getItemMeta();
		metaCompass.setDisplayName("§eCosmétique");
		customCompass.setItemMeta(metaCompass);
		p.getInventory().setItem(1, customCompass);
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action action = e.getAction();
		if (action.equals(Action.LEFT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_BLOCK)
				|| action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
			if (e.getItem().getItemMeta().getDisplayName().equals("§eCosmétique")) {
				Inventory cos = Bukkit.createInventory(p, 9, "§dCosmetiques");

				ItemStack particules = new ItemStack(Material.REDSTONE, 1);
				ItemMeta particulesm = particules.getItemMeta();
				particulesm.setDisplayName("§4Particules");
				particules.setItemMeta(particulesm);

				ItemStack monture = new ItemStack(Material.DRAGON_EGG, 1);
				ItemMeta monturem = monture.getItemMeta();
				monturem.setDisplayName("§dMontures");
				monture.setItemMeta(monturem);

				ItemStack familier = new ItemStack(Material.DRAGON_EGG, 1);
				ItemMeta familierm = familier.getItemMeta();
				familierm.setDisplayName("§dFamiliers");
				familier.setItemMeta(familierm);

				ItemStack gad = new ItemStack(Material.ENDER_PEARL, 1);
				ItemMeta gadm = gad.getItemMeta();
				gadm.setDisplayName("§dGadgets");
				gad.setItemMeta(gadm);

				cos.setItem(2, particules);
				cos.setItem(3, monture);
				cos.setItem(4, gad);
				cos.setItem(5, familier);
				p.openInventory(cos);
				e.setCancelled(true);
			}
		}

	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		Inventory inv = e.getInventory();
		Integer slot = e.getSlot();
		if (inv.getTitle().equals("§dCosmetiques")) {
			if (slot == 3) {
				Inventory gad = Bukkit.createInventory(p, 54, "§4Gagets");
				
				GadgetUtils.createItem(gad, "Arc de tp" ,Material.BOW, 1);
				GadgetUtils.createItem(gad, "Lance boule de neige" ,Material.WOOD_HOE, 1);
				GadgetUtils.createItem(gad, "Propulseur" ,Material.FEATHER, 1);
				GadgetUtils.createItem(gad, "Ferme les lumières" ,Material.TORCH, 1);
				GadgetUtils.createItem(gad, "Bras de fer" ,Material.WOOD_PLATE, 1);
				p.openInventory(gad);
			}
			if (slot == 2) {
				Inventory particules = Bukkit.createInventory(p, 54, "§4Particules");

				ItemStack sang = new ItemStack(Material.REDSTONE, 1);
				ItemMeta sangm = sang.getItemMeta();
				sangm.setDisplayName("§4Sang");
				sang.setItemMeta(sangm);

				ItemStack piano = new ItemStack(Material.JUKEBOX, 1);
				ItemMeta pianom = piano.getItemMeta();
				pianom.setDisplayName("§4Musique");
				piano.setItemMeta(pianom);

				ItemStack feu = new ItemStack(Material.JUKEBOX, 1);
				ItemMeta feum = feu.getItemMeta();
				feum.setDisplayName("§4Feu");
				feu.setItemMeta(feum);

				ItemStack angry = new ItemStack(Material.POISONOUS_POTATO, 1);
				ItemMeta angrym = angry.getItemMeta();
				angrym.setDisplayName("§4Angry");
				angry.setItemMeta(angrym);

				ItemStack coeur = new ItemStack(Material.RED_ROSE, 1);
				ItemMeta coeurm = coeur.getItemMeta();
				coeurm.setDisplayName("§4Amoureux");
				coeur.setItemMeta(coeurm);

				ItemStack star = new ItemStack(Material.FIREWORK, 1);
				ItemMeta starm = star.getItemMeta();
				starm.setDisplayName("§4Star");
				star.setItemMeta(starm);

				particules.addItem(sang);
				particules.addItem(piano);
				particules.addItem(feu);
				particules.addItem(angry);
				particules.addItem(coeur);
				particules.addItem(star);
				p.openInventory(particules);
				if (slot == 3) {
					Inventory monture = Bukkit.createInventory(p, 54, "§4Montures");
					ItemStack gole = new ItemStack(Material.IRON_BLOCK, 1);
					ItemMeta golem = gole.getItemMeta();
					golem.setDisplayName("§4Golem");
					gole.setItemMeta(golem);
					
					ItemStack dragon = new ItemStack(Material.DRAGON_EGG, 1);
					ItemMeta dragonm = dragon.getItemMeta();
					dragonm.setDisplayName("§4Dragon");
					dragon.setItemMeta(dragonm);

					ItemMetaUtils.createItem(monture, "§4Vache", Material.MONSTER_EGG, 1, (short) 11);
					ItemMetaUtils.createItem(monture, "§4Cochon", Material.MONSTER_EGG, 1, (short) 12);
					ItemMetaUtils.createItem(monture, "§4SpiderMan fils de pute", Material.MONSTER_EGG, 1, (short) 35);
					ItemMetaUtils.createItem(monture, "§4Poulet", Material.MONSTER_EGG, 1, (short) 10);
					ItemMetaUtils.createItem(monture, "§4Mouton", Material.MONSTER_EGG, 1, (short) 13);
					ItemMetaUtils.createItem(monture, "§4Chauve-souris", Material.MONSTER_EGG, 1, (short) 19);
					ItemMetaUtils.createItem(monture, "§4Blaze", Material.MONSTER_EGG, 1, (short) 43);
					ItemMetaUtils.createItem(monture, "§4Slime", Material.MONSTER_EGG, 1, (short) 37);
					monture.addItem(gole);
					monture.addItem(dragon);
					p.openInventory(monture);
				}
			}
			e.setCancelled(true);
		}
		if (inv.getTitle().equals("§4Particules")) {
			if (slot.equals(0)) {
				if (CosUtils.isPar(p)) {
					float red = 255;
					float green = 0;
					float blue = 0;
					Location location = p.getLocation();
					PacketPlayOutWorldParticles particles = new PacketPlayOutWorldParticles(EnumParticle.REDSTONE, true,
							(float) location.getX(), (float) location.getBlockY(), (float) location.getBlockZ(), red,
							green, blue, 0, 0, 255);
					CosUtils.putParticule(p, particles);
				}
			}
			if (slot.equals(1)) {
				if (CosUtils.isPar(p)) {
					float red = 0;
					float green = 0;
					float blue = 0;
					Location location = p.getLocation();
					PacketPlayOutWorldParticles particles = new PacketPlayOutWorldParticles(EnumParticle.NOTE, true,
							(float) location.getX(), (float) location.getBlockY(), (float) location.getBlockZ(), red,
							green, blue, 0, 0, 255);
					CosUtils.putParticule(p, particles);
				}
			}
			if (slot.equals(2)) {
				if (CosUtils.isPar(p)) {
					float red = 255;
					float green = 0;
					float blue = 0;
					Location location = p.getLocation();
					PacketPlayOutWorldParticles particles = new PacketPlayOutWorldParticles(EnumParticle.FLAME, true,
							(float) location.getX(), (float) location.getBlockY(), (float) location.getBlockZ(), red,
							green, blue, 0, 0, 255);
					CosUtils.putParticule(p, particles);
				}
			}
			if (slot.equals(3)) {
				if (CosUtils.isPar(p)) {
					float red = 255;
					float green = 0;
					float blue = 0;
					Location location = p.getLocation();
					PacketPlayOutWorldParticles particles = new PacketPlayOutWorldParticles(EnumParticle.VILLAGER_ANGRY,
							true, (float) location.getX(), (float) location.getBlockY(), (float) location.getBlockZ(),
							red, green, blue, 0, 0, 255);
					CosUtils.putParticule(p, particles);
				}
			}
			if (slot.equals(4)) {
				if (CosUtils.isPar(p)) {
					float red = 255;
					float green = 0;
					float blue = 0;
					Location location = p.getLocation();
					PacketPlayOutWorldParticles particles = new PacketPlayOutWorldParticles(EnumParticle.HEART, true,
							(float) location.getX(), (float) location.getBlockY(), (float) location.getBlockZ(), red,
							green, blue, 0, 0, 255);
					CosUtils.putParticule(p, particles);
				}
			}
			if (slot.equals(5)) {
				if (CosUtils.isPar(p)) {
					float red = 255;
					float green = 255;
					float blue = 0;
					Location location = p.getLocation();
					PacketPlayOutWorldParticles particles = new PacketPlayOutWorldParticles(
							EnumParticle.FIREWORKS_SPARK, true, (float) location.getX(), (float) location.getBlockY(),
							(float) location.getBlockZ(), red, green, blue, 0, 0, 255);
					CosUtils.putParticule(p, particles);
				}
			}
			e.setCancelled(true);
		}
		if (inv.getTitle().equals("§4Montures")) {
			if(slot.equals(0)) {
				EntityType sheep = EntityType.COW;
				MontUtils.createMont(p, sheep);
			}
			if(slot.equals(1)) {
				EntityType sheep = EntityType.PIG;
				MontUtils.createMont(p, sheep);
			}
			if(slot.equals(2)) {
				EntityType sheep = EntityType.SPIDER;
				MontUtils.createMont(p, sheep);
			}
			if(slot.equals(3)) {
				EntityType sheep = EntityType.CHICKEN;
				MontUtils.createMont(p, sheep);
			}
			if(slot.equals(4)) {
				EntityType sheep = EntityType.SHEEP;
				MontUtils.createMont(p, sheep);
			}
			if(slot.equals(5)) {
				EntityType sheep = EntityType.BAT;
				MontUtils.createMont(p, sheep);
			}
			if(slot.equals(6)) {
				EntityType sheep = EntityType.BLAZE;
				MontUtils.createMont(p, sheep);
			}
			if(slot.equals(7)) {
				EntityType sheep = EntityType.SLIME;
				MontUtils.createMont(p, sheep);
			}
			if(slot.equals(8)) {
				EntityType sheep = EntityType.IRON_GOLEM;
				MontUtils.createMont(p, sheep);
			}
			if(slot.equals(9)) {
				EntityType sheep = EntityType.ENDER_DRAGON;
				MontUtils.createMont(p, sheep);
			}
			e.setCancelled(true);

		}
	}
}
