package coffee.ccg.tutmod.objects.items;

import java.util.List;

import coffee.ccg.tutmod.util.helpers.KeyboardHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class SpecialItem extends Item{

	public SpecialItem(Properties properties) {
		super(properties);
		this.setRegistryName("special_item");
		
	}
	
	@Override
	public void addInformation(ItemStack item,World world,List<ITextComponent> tooltip,ITooltipFlag flagln) 
	{
		if(KeyboardHelper.isHoldingShift()) {
			tooltip.add(new StringTextComponent("Test ToolTip"));
		}
		else {
			
			tooltip.add(new StringTextComponent("\u00A7a" + "Hold SHIFT for more Info."));
			
		}
		super.addInformation(item, world, tooltip, flagln);
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		
		player.addPotionEffect(new EffectInstance(Effects.BLINDNESS,500,255));
		
		
		return super.onItemRightClick(world, player, hand);
	}
	
}
