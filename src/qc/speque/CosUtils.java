package qc.speque;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

public class CosUtils {
	private static Map<Player, EnumParticle> par = new HashMap<Player, EnumParticle>();
	
	public static void putParticule(Player p, PacketPlayOutWorldParticles particles) {
		if(isPar(p)) {
			removeParticule(p);
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(particles);
		}
			putParticule(p, particles);
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(particles);
		}
	
	public static boolean isPar(Player p) {
		if(par.containsKey(p)) {
			return true;
		}
		return false;
	}
	public static void removeParticule(Player p) {
		if(isPar(p)) {
			par.remove(p);
		}
	}

}
