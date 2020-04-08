package panda.leatherworks;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import panda.leatherworks.init.LWItems;

//Modified from
//https://github.com/Shadows-of-Fire/EnderBags/blob/master/src/main/java/gigabit101/EnderBags/config/ConfigEnderBag.java
public class ConfigLeatherWorks {

	public static int leatherDryingTime;
	public static float leatherFailureChance;
	public static boolean allowBatchProcessing;
	public static boolean consumeFlint;
	public static boolean singleBarkItem;
	public static boolean useExternalDebarking;
	
	private ConfigLeatherWorks(){LeatherWorks.logger.info("Loading Config");}
	
	public static void load(Configuration config) {
		config.load();
		
		leatherDryingTime = config.getInt("leatherDryingTime", "general", 9600, 1, 2147483647, "Time in ticks to dry leather. 1 second is 20 ticks. Default is 8 mins");
		leatherFailureChance = config.getFloat("leatherFailureChance", "general", 5f, 0f, 100f, "Percent chance that drying leather will fail and return rotten flesh");

		allowBatchProcessing = config.getBoolean("allowBatchProcessing", "general", true, "If disabled, 1 unit of water or tannin will be required to process each hide.");
		consumeFlint = config.getBoolean("consumeFlint", "general", false, "If enabled, Scraping hides will consume flint");
		singleBarkItem = config.getBoolean("singleBarkItem", "general", false, "If enabled, Leatherworks will only use one bark item");
		useExternalDebarking = config.getBoolean("useExternalDebarking", "general", false, "If enabled, Leatherworks will disable its' debarking features so you can handle it with other mods.");

		if (config.hasChanged()) config.save();

	}
}
