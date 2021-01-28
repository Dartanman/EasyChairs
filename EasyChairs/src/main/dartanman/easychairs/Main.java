/**
 * JavaPlugin class for the entire EasyChairs plugin
 * @author Dartanman (Austin Dart)
 */

package main.dartanman.easychairs;

import org.bukkit.plugin.java.JavaPlugin;

import main.dartanman.easychairs.events.Dismount;
import main.dartanman.easychairs.events.Interact;

public class Main extends JavaPlugin{
	
	/**
	 * Enables the plugin by registering the two necessary events.
	 */
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Dismount(), this);
		getServer().getPluginManager().registerEvents(new Interact(), this);
	}
	
	public void onDisable() {
		
	}

}
