package coffee.ccg.tutmod;

import coffee.ccg.tutmod.init.Iteminit;
import coffee.ccg.tutmod.world.TutOreGen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

 import org.apache.logging.log4j.LogManager;
 import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

//The value here should match an entry in the META-INF/mods.toml file
@Mod("tutmod")
@Mod.EventBusSubscriber(modid = Tutmod.MOD_ID,bus = Bus.MOD)
public class Tutmod
{
 // Directly reference a log4j logger.
 public static final Logger LOGGER = LogManager.getLogger();
 public static final String MOD_ID = "tutmod";
 public static Tutmod instance;
 
 
 public Tutmod() {
	 
	 final IEventBus Event = FMLJavaModLoadingContext.get().getModEventBus();
	 
     // Register the setup method for modloading
     Event.addListener(this::setup);
     
     // Register the doClientStuff method for modloading
     Event.addListener(this::doClientStuff);

     // Register ourselves for server and other game events we are interested in
     MinecraftForge.EVENT_BUS.register(this);
     instance = this;
 }

 private void setup(final FMLCommonSetupEvent event){
     // some preinit code
	 
 }

 private void doClientStuff(final FMLClientSetupEvent event) {
     // do something that can only be done on the client
 }
 @SubscribeEvent
 public void onServerStarting(FMLServerStartingEvent event) {
     // do something when the server starts
 }
 @SubscribeEvent
 public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
	 TutOreGen.generateOre();
 }
 
 public static class TutItemGroup extends ItemGroup{
	 
	 public static final TutItemGroup instance = new TutItemGroup(ItemGroup.GROUPS.length,"TutGroup");
	 
	 private TutItemGroup(int index ,String label) {
		 super(index,label);
	 }

	@Override
	public ItemStack createIcon() {
		return new ItemStack(Iteminit.example_item);
	}
	 
 }
}
