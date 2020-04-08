package panda.leatherworks.init;

import net.minecraft.block.Block;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import panda.leatherworks.ConfigLeatherWorks;
import panda.leatherworks.LeatherWorks;
import panda.leatherworks.common.item.ItemCraftingLeather;

@EventBusSubscriber
public final class LWItems {
	
	private LWItems(){LeatherWorks.logger.info("Registering Items");}

	public static final ItemArmor.ArmorMaterial DUMMYLEATHER = EnumHelper.addArmorMaterial("leather", "leatherworks:leather", 5, new int[]{0,0,0,0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);

	public static final Item RAWHIDE_COW = simply(new Item(), "rawhide_cow");
	public static final Item RAWHIDE_PIG = simply(new Item(), "rawhide_pig");
	public static final Item RAWHIDE_HORSE = simply(new Item(), "rawhide_horse");
	public static final Item RAWHIDE_WOLF = simply(new Item(), "rawhide_wolf");
	public static final Item RAWHIDE_POLARBEAR = simply(new Item(), "rawhide_polarbear");
	public static final Item RAWHIDE_MOOSHROOM = simply(new Item(), "rawhide_mooshroom");
	public static final Item RAWHIDE_LLAMA =  simply(new Item(), "rawhide_llama");
	public static final Item RAWHIDE_MULE = simply(new Item(), "rawhide_mule");
	public static final Item RAWHIDE_DONKEY = simply(new Item(), "rawhide_donkey");
	
	public static final Item BARK_OAK = simply(new Item(), "bark_oak");
	public static final Item BARK_SPRUCE = simply(new Item(), "bark_spruce");
	public static final Item BARK_BIRCH = simply(new Item(), "bark_birch");
	public static final Item BARK_JUNGLE = simply(new Item(), "bark_jungle");
	public static final Item BARK_ACACIA = simply(new Item(), "bark_acacia");
	public static final Item BARK_DARKOAK = simply(new Item(), "bark_darkoak");

	public static final Item TANNIN_BOTTLE = simply(new Item(), "tannin_bottle");
	public static final Item TANNIN_BALL = simply(new Item(), "tannin_ball");

	public static final Item LEATHER_SCRAPED = simply(new ItemCraftingLeather(), "crafting_leather_scraped");
	public static final Item LEATHER_WASHED = simply(new ItemCraftingLeather(), "crafting_leather_washed");
	public static final Item LEATHER_SOAKED = simply(new ItemCraftingLeather(), "crafting_leather_soaked");

	public static final Item RAWHIDE_DEER = simply(new Item(), "rawhide_deer");
	public static final Item RAWHIDE_BOAR = simply(new Item(), "rawhide_boar");


	private static Item simply(Item item, String name) {
		return item.setRegistryName(LeatherWorks.MODID, name).setTranslationKey(LeatherWorks.MODID + "." + name).setCreativeTab(LeatherWorks.LeatherTab);
	}

	@SubscribeEvent
	public static void register(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();

		registry.register(RAWHIDE_COW);
		registry.register(RAWHIDE_PIG);
		registry.register(RAWHIDE_HORSE);
		registry.register(RAWHIDE_WOLF);
		registry.register(RAWHIDE_POLARBEAR);
		registry.register(RAWHIDE_MOOSHROOM);
		registry.register(RAWHIDE_LLAMA);
		registry.register(RAWHIDE_MULE);
		registry.register(RAWHIDE_DONKEY);
		registry.register(RAWHIDE_DEER);
		registry.register(RAWHIDE_BOAR);
		
		registry.register(LEATHER_SCRAPED);
		registry.register(LEATHER_WASHED);
		registry.register(LEATHER_SOAKED);
		registry.register(BARK_OAK);
		registry.register(BARK_SPRUCE);
		registry.register(BARK_BIRCH);
		registry.register(BARK_JUNGLE);
		registry.register(BARK_ACACIA);
		registry.register(BARK_DARKOAK);
		registry.register(TANNIN_BALL);
		registry.register(TANNIN_BOTTLE);
		
		registerItemBlock(registry, LWBlocks.BARREL_OAK);
		registerItemBlock(registry, LWBlocks.BARREL_SPRUCE);
		registerItemBlock(registry, LWBlocks.BARREL_BIRCH);
		registerItemBlock(registry, LWBlocks.BARREL_JUNGLE);
		registerItemBlock(registry, LWBlocks.BARREL_ACACIA);
		registerItemBlock(registry, LWBlocks.BARREL_DARKOAK);
		
		registerItemBlock(registry, LWBlocks.DEBARKED_LOG_OAK);
		registerItemBlock(registry, LWBlocks.DEBARKED_LOG_ACACIA);
		registerItemBlock(registry, LWBlocks.DEBARKED_LOG_BIRCH);
		registerItemBlock(registry, LWBlocks.DEBARKED_LOG_SPRUCE);
		registerItemBlock(registry, LWBlocks.DEBARKED_LOG_DARKOAK);
		registerItemBlock(registry, LWBlocks.DEBARKED_LOG_JUNGLE);
		registerItemBlock(registry, LWBlocks.BARK_OAK);
		registerItemBlock(registry, LWBlocks.BARK_ACACIA);
		registerItemBlock(registry, LWBlocks.BARK_BIRCH);
		registerItemBlock(registry, LWBlocks.BARK_DARKOAK);
		registerItemBlock(registry, LWBlocks.BARK_JUNGLE);
		registerItemBlock(registry, LWBlocks.BARK_SPRUCE);
		registerItemBlock(registry, LWBlocks.SEALED_BARREL_OAK);
		registerItemBlock(registry, LWBlocks.SEALED_BARREL_SPRUCE);
		registerItemBlock(registry, LWBlocks.SEALED_BARREL_BIRCH);
		registerItemBlock(registry, LWBlocks.SEALED_BARREL_JUNGLE);
		registerItemBlock(registry, LWBlocks.SEALED_BARREL_ACACIA);
		registerItemBlock(registry, LWBlocks.SEALED_BARREL_DARKOAK);
		registerItemBlock(registry, LWBlocks.DRYING_RACK_OAK);
		registerItemBlock(registry, LWBlocks.DRYING_RACK_SPRUCE);
		registerItemBlock(registry, LWBlocks.DRYING_RACK_BIRCH);
		registerItemBlock(registry, LWBlocks.DRYING_RACK_JUNGLE);
		registerItemBlock(registry, LWBlocks.DRYING_RACK_ACACIA);
		registerItemBlock(registry, LWBlocks.DRYING_RACK_DARKOAK);
	}

	private static void registerItemBlock(IForgeRegistry<Item> registry, Block block) {
		registry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}
}
