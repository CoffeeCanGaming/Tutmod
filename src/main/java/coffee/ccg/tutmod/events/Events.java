package coffee.ccg.tutmod.events;

import coffee.ccg.tutmod.Tutmod;
import coffee.ccg.tutmod.util.helpers.KeyboardHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Tutmod.MOD_ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class Events {

	
	@SubscribeEvent
	public static void onJumpEvent(LivingJumpEvent event) {
		Entity entity = event.getEntity();

		if (entity instanceof PlayerEntity) {
			
		}
	}

	@SubscribeEvent
	public static void onKeyPress(LivingEvent event) {
		Entity entity = event.getEntity();

		if (KeyboardHelper.isHoldingShift() == true) {
			if (entity.getEntity() instanceof PlayerEntity) {
				Tutmod.LOGGER.info("update");
			}
		}
	}
}
