package coffee.ccg.tutmod;

import coffee.ccg.tutmod.init.Iteminit;
import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class Tagtest {
	public Tagtest() {
		ResourceLocation testtagitem = new ResourceLocation(Tutmod.MOD_ID, "testagitem");
		Item item = Iteminit.example_item;

		boolean isinTag = ItemTags.getCollection().get(testtagitem).contains(item);

		if (isinTag) {
			Tutmod.LOGGER.info(item.getRegistryName() + " is in Item Tag");
		}
	}
}