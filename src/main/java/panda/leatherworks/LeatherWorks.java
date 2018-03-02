package panda.leatherworks;

import org.apache.logging.log4j.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import panda.leatherworks.common.GuiHandler;
import panda.leatherworks.common.eventhandler.BucketHandler;
import panda.leatherworks.common.eventhandler.DebarkHandler;
import panda.leatherworks.common.eventhandler.LivingDropsHandler;
import panda.leatherworks.common.tileentity.TileEntityDryingRack;
import panda.leatherworks.init.LWItems;
import panda.leatherworks.init.LWRecipes;
import panda.leatherworks.proxy.CommonProxy;

@Mod(modid = LeatherWorks.MODID, name = LeatherWorks.NAME, version = LeatherWorks.VERSION)
public class LeatherWorks {
	public static final String MODID = "leatherworks";
	public static final String VERSION = "1.62.0";
	public static final String NAME = "Leather Works";
	public static SimpleNetworkWrapper wrapper;
	
	@Mod.Instance(MODID)
	public static LeatherWorks INSTANCE;

	@SidedProxy(clientSide = "panda.leatherworks.proxy.ClientProxy",serverSide = "panda.leatherworks.proxy.ServerProxy")
	public static CommonProxy PROXY;
	public static Logger logger;
	
//Add tanner to village?
	@EventHandler
	public void preinit(FMLPreInitializationEvent event){
		logger = event.getModLog();
		wrapper = NetworkRegistry.INSTANCE.newSimpleChannel(LeatherWorks.MODID);
		PROXY.registerMessageHandlers(wrapper);
		LWRecipes.register();
		
		MinecraftForge.EVENT_BUS.register(new LivingDropsHandler());
		MinecraftForge.EVENT_BUS.register(new BucketHandler());
		MinecraftForge.EVENT_BUS.register(new DebarkHandler());

		NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new GuiHandler());

		GameRegistry.registerTileEntity(TileEntityDryingRack.class, "leatherworks:drying_rack");
	}

	@EventHandler
	public void init(FMLInitializationEvent event){
		PROXY.registerColorHandlers();
	}
	
	public static final CreativeTabs LeatherTab = new CreativeTabs(LeatherWorks.MODID) {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(LWItems.RAWHIDE_COW);
		}
	};
	
}