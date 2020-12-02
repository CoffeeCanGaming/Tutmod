package coffee.ccg.tutmod.init;

import coffee.ccg.tutmod.Tutmod;
import coffee.ccg.tutmod.Tutmod.TutItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Tutmod.MOD_ID, bus = Bus.MOD)
@ObjectHolder(Tutmod.MOD_ID)
public class Blockinit{
	

	   public static final Block example_block = null;
	   
	  
	   
	   public static final Block example_ore = null;
	
	@SubscribeEvent
	public static void RegisterBlocks(final RegistryEvent.Register<Block> Event) {
		
		Event.getRegistry().registerAll(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.SNOW)).setRegistryName("example_block"),
										new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).harvestLevel(2).hardnessAndResistance(4.0F,6.0F).sound(SoundType.STONE)).setRegistryName("example_ore"));
		
	}
	@SubscribeEvent
	public static void RegisterItemBlocks(final RegistryEvent.Register<Item> Event) 
	{
		Event.getRegistry().registerAll(new BlockItem(example_block, new Item.Properties().group(TutItemGroup.instance)).setRegistryName("example_block"),
										new BlockItem(example_ore, new Item.Properties().group(TutItemGroup.instance)).setRegistryName("example_ore"));
	}
	
}