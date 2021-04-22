package qc.speque;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class MontUtils {
	private static Map<Player, EntityType> mont = new HashMap<Player, EntityType>();
	
	public static void createMont(Player p, EntityType enti) {
		if(getMont().containsKey(p)) {
			removeMont(p);
		}
		World w = Bukkit.getWorld(p.getWorld().toString());
		Location loc = p.getLocation();
		w.spawnEntity(loc, enti);
	}
	public static void removeMont(Player p) {
		mont.remove(p);
		World w = Bukkit.getWorld(p.getWorld().toString());
		for(Entity entity : w.getEntities()) {
			if(getMont().containsKey(p)) {
				entity.remove();
			}
		}
	}
	public static Map<Player, EntityType> getMont() {
		return mont;
	}

}
