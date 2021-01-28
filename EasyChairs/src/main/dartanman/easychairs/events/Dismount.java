/**
 * Dismount event listener
 * @author Dartanman (Austin Dart)
 */

package main.dartanman.easychairs.events;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityDismountEvent;

public class Dismount implements Listener{
	
	/**
	 * Listens to the Dismount event and deletes the dismounted entity if it is an invisible armorstand.
	 * @param event
	 *   the event to listen to
	 */
	@EventHandler
	public void onDismount(EntityDismountEvent event) {
		Entity dismounted = event.getDismounted();
		if(dismounted.getType().equals(EntityType.ARMOR_STAND)) {
			ArmorStand as = (ArmorStand) dismounted;
			if(!as.isVisible()) {
				as.remove();
			}
		}
	}

}
