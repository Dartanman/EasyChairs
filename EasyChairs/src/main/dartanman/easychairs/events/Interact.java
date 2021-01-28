/**
 * Interact event Listener
 * @author Dartanman (Austin Dart)
 */

package main.dartanman.easychairs.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.material.Stairs;

public class Interact implements Listener{
	
	/**
	 * Listens to interact event and allows the player to "sit" on any stair block.
	 * @param event
	 *   the event to listen to
	 */
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getHand().equals(EquipmentSlot.HAND) &&
				(event.getPlayer().getItemInHand() == null || event.getPlayer().getItemInHand().getType() == Material.AIR)) {
			Player player = event.getPlayer();
			Block block = event.getClickedBlock();
			// checks if the block is a stair block
			if(block.getType().toString().toLowerCase().contains("stair")) {
				
				Stairs stairs = (Stairs)block.getState().getData();
				BlockFace face = stairs.getFacing();
				if(stairs.isInverted()) {
					return;
				}
				Location loc = new Location(block.getWorld(), block.getX() + 0.5, block.getY() - 1.2, block.getZ() + 0.5);
				if(face.equals(BlockFace.NORTH)) {
					loc = new Location(block.getWorld(), block.getX() + 0.5, block.getY() - 1.2, block.getZ() + 0.5, 180, 180);
				}else if(face.equals(BlockFace.EAST)) {
					loc = new Location(block.getWorld(), block.getX() + 0.5, block.getY() - 1.2, block.getZ() + 0.5, 270, 270);
				}else if(face.equals(BlockFace.SOUTH)) {
					loc = new Location(block.getWorld(), block.getX() + 0.5, block.getY() - 1.2, block.getZ() + 0.5);
				}else if(face.equals(BlockFace.WEST)) {
					loc = new Location(block.getWorld(), block.getX() + 0.5, block.getY() - 1.2, block.getZ() + 0.5, 90, 90);
				}else {
					// player did not right-click a normal facing stair (it is upside-down or diagonal)
					// this was an assumption which turned out to be false.
					return;
				}
				// spawns the stand at the location
				ArmorStand stand = (ArmorStand) player.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
				// Invisible
				stand.setVisible(false);
				// Can't fall
				stand.setGravity(false);
				// Put player on the stand
				stand.setPassenger(player);
			}
		}
	}

}
