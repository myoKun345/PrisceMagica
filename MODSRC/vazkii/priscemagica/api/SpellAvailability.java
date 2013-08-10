/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the PrisceMagica Mod.
 * 
 * PrisceMagica is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [9 Aug 2013, 23:09:56 (GMT)]
 */
package vazkii.priscemagica.api;

import net.minecraft.entity.player.EntityPlayer;

/**
 * An enum representing the various possible availabilities
 * for a spell, set via the config file, used in mapping.
 */
public enum SpellAvailability {

	AVAILABLE,
	NOT_RESEARCHABLE, 
	OP_RESTRICTED,
	DISABLED;
	
	/**
	 * Can the player passed in research this?
	 */
	public boolean allowResearch(EntityPlayer plyer) {
		return false; //TODO
	}
	
	/**
	 * Can the player passed in use this?
	 */
	public boolean allowUsage(EntityPlayer player) {
		return false; // TODO
	}
	
}
