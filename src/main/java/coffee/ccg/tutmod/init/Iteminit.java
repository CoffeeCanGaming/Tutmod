package coffee.ccg.tutmod.init;

import java.util.function.Supplier;

import coffee.ccg.tutmod.Tutmod;
import coffee.ccg.tutmod.Tutmod.TutItemGroup;
import coffee.ccg.tutmod.objects.items.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;


@Mod.EventBusSubscriber(modid = Tutmod.MOD_ID, bus = Bus.MOD)
@ObjectHolder(Tutmod.MOD_ID)
public class Iteminit {
	
	public static final Item example_item = null;
	public static final Item example_item2 = null;
	
	public static final Item special_item = null;
	public static final Item fuel_item = null;
	
	
	public static final Item example_axe = null;
	public static final Item example_pickaxe = null;
	public static final Item example_hoe = null;
	public static final Item example_sword = null;
	public static final Item example_shovel = null;
	
	public static final Item example_helmet =null;
	public static final Item example_chestplate =null;
	public static final Item example_leggings =null;
	public static final Item example_boots =null;
	
	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void RegisterItems(final RegistryEvent.Register<Item> event) 
	{
		event.getRegistry().registerAll(new Item(new Item.Properties().group(TutItemGroup.instance)).setRegistryName("example_item"),
									   (new Item(new Item.Properties().group(TutItemGroup.instance).food(new Food.Builder().hunger(6).saturation(1.5F).effect(new EffectInstance(Effects.ABSORPTION, 600, 5) ,1).build())).setRegistryName("example_item2")),
									   (new SpecialItem(new Item.Properties().group(TutItemGroup.instance))),
									   (new FuelItem(new Item.Properties().group(TutItemGroup.instance))));
	
		//tools
		event.getRegistry().registerAll(new SwordItem(ModItemTier.EXAMPLE, 7, 16.0F, new Item.Properties().group(TutItemGroup.instance)).setRegistryName("example_sword"),
										new PickaxeItem(ModItemTier.EXAMPLE, 4, 16.0F, new Item.Properties().group(TutItemGroup.instance)).setRegistryName("example_pickaxe"),
										new AxeItem(ModItemTier.EXAMPLE, 4, 16.0F, new Item.Properties().group(TutItemGroup.instance)).setRegistryName("example_axe"),
										new HoeItem(ModItemTier.EXAMPLE, 16.0F, new Item.Properties().group(TutItemGroup.instance)).setRegistryName("example_hoe"),
										new ShovelItem(ModItemTier.EXAMPLE, 4, 16.0F, new Item.Properties().group(TutItemGroup.instance)).setRegistryName("example_shovel"));
		//armor
		event.getRegistry().registerAll(new ArmorItem(ModArmorMaterial.TEST,EquipmentSlotType.HEAD,new Item.Properties().group(TutItemGroup.instance)).setRegistryName("example_helmet"),
										new ArmorItem(ModArmorMaterial.TEST,EquipmentSlotType.CHEST,new Item.Properties().group(TutItemGroup.instance)).setRegistryName("example_chestplate"),
										new ArmorItem(ModArmorMaterial.TEST,EquipmentSlotType.LEGS,new Item.Properties().group(TutItemGroup.instance)).setRegistryName("example_leggings"),
										new ArmorItem(ModArmorMaterial.TEST,EquipmentSlotType.FEET,new Item.Properties().group(TutItemGroup.instance)).setRegistryName("example_boots"));
	}
	
	public enum ModItemTier implements IItemTier{
		EXAMPLE(5,6000,20.0F,7.0F,250, () -> {
			return Ingredient.fromItems(Iteminit.example_item);
		});
		
		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
			
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.enchantability = enchantability;
			this.repairMaterial = new LazyValue<>(repairMaterial);
			
		}

		@Override
		public int getMaxUses() {
			return maxUses;
		}

		@Override
		public float getEfficiency() {
			return efficiency;
		}

		@Override
		public float getAttackDamage() {
			return attackDamage;
		}

		@Override
		public int getHarvestLevel() {
			return harvestLevel;
		}

		@Override
		public int getEnchantability() {
			return enchantability;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}
	}
	public enum ModArmorMaterial implements IArmorMaterial{
		TEST(Tutmod.MOD_ID + ":test", 5, new int[] {7,9,11,7}, 420, SoundEvents.field_226142_fM_, 6.9F,() -> {return Ingredient.fromItems(Iteminit.example_item);
	});
		public static final int[] MAX_DAMAGE_ARRAY = new int[] {16,16,16,16};
		private final String name;
		private final int maxDamageFactor;
		private final int[] damageReductionAmountArray;
		private final int enchantability;
		private final SoundEvent soundEvent;
		private final float toughness;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn,
				int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn,
				Supplier<Ingredient> repairMaterialIn) {
			this.name = nameIn;
			this.maxDamageFactor = maxDamageFactorIn;
			this.damageReductionAmountArray = damageReductionAmountIn;
			this.enchantability = enchantabilityIn;
			this.soundEvent = soundEventIn;
			this.toughness = toughnessIn;
			this.repairMaterial = new LazyValue<>(repairMaterialIn);
		}
		@Override
		public int getDurability(EquipmentSlotType slotIn) {
			return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
		}
		@Override
		public int getDamageReductionAmount(EquipmentSlotType slotIn) {
			return this.damageReductionAmountArray[slotIn.getIndex()];
		}
		@Override
		public int getEnchantability() {
			return this.enchantability;
		}
		@Override
		public SoundEvent getSoundEvent() {
			return this.soundEvent;
		}
		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}
		@OnlyIn(Dist.CLIENT)
		@Override
		public String getName() {
			return this.name;
		}
		@Override
		public float getToughness() {
			return this.toughness;
		}
	}
}
