/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the PrisceMagica Mod.
 *
 * PrisceMagica is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 *
 * File Created @ [6 Aug 2013, 20:59:29 (GMT)]
 */
package vazkii.priscemagica;

import vazkii.priscemagica.core.handler.ConfigHandler;
import vazkii.priscemagica.core.handler.GuiHandler;
import vazkii.priscemagica.core.handler.LocalizationHandler;
import vazkii.priscemagica.core.proxy.CommonProxy;
import vazkii.priscemagica.item.ModItems;
import vazkii.priscemagica.lib.LibMisc;
import vazkii.priscemagica.spell.ModSpells;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = LibMisc.MOD_ID, name = LibMisc.MOD_NAME, version = LibMisc.VERSION)
@NetworkMod(clientSideRequired = true, channels = { LibMisc.CHANNEL })
public class PrisceMagica {

	@SidedProxy(serverSide = LibMisc.COMMON_PROXY, clientSide = LibMisc.CLIENT_PROXY)
	public static CommonProxy proxy;

	@Instance(LibMisc.MOD_ID)
	public static PrisceMagica instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		instance = this;

		ConfigHandler.loadConfig(event.getSuggestedConfigurationFile());
		ModItems.initItems();
		ModSpells.registerSpells();

		proxy.registerClientHandlers();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		LocalizationHandler.loadLocalizations();

		proxy.registerTileEntities();
		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
		
		ConfigHandler.loadSpellConfig();
	}
}