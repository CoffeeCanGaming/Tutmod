package coffee.ccg.tutmod.world;

import coffee.ccg.tutmod.init.Blockinit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class TutOreGen {

	public static void generateOre() {
		for(Biome biome : ForgeRegistries.BIOMES) {
			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 5, 5, 255));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blockinit.example_ore.getDefaultState(), 8)).withPlacement(customConfig));
		}
	}
}
