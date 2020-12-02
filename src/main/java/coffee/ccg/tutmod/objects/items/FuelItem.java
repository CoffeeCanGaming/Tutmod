package coffee.ccg.tutmod.objects.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FuelItem extends Item{

	public FuelItem(Properties properties) {
		super(properties);
		this.setRegistryName("fuelitem");
	}
	@Override
	public int getBurnTime(ItemStack itemStack) {
		
		return 1600;
	}
}
