package qc.speque;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new PluginListener(), this);
		super.onEnable();
	}
	@Override
	public void onDisable() {
		super.onDisable();
	}
	

}
