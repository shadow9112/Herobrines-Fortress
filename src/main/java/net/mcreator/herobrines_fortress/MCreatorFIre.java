package net.mcreator.herobrines_fortress;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.feature.TwoFeatureChoiceConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.GrassFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.block.Blocks;

import com.google.common.collect.Lists;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorFIre extends Elementsherobrines_fortress.ModElement {
	@ObjectHolder("herobrines_fortress:fire")
	public static final CustomBiome biome = null;

	public MCreatorFIre(Elementsherobrines_fortress instance) {
		super(instance, 50);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}

	static class CustomBiome extends Biome {
		public CustomBiome() {
			super(new Biome.Builder()
					.downfall(0f)
					.depth(0.1f)
					.scale(0.5f)
					.temperature(2f)
					.precipitation(Biome.RainType.NONE)
					.category(Biome.Category.NONE)
					.waterColor(-3407872)
					.waterFogColor(-3407872)
					.surfaceBuilder(
							SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(MCreatorFiredirt.block.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.STONE
									.getDefaultState())));
			setRegistryName("fire");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.DEFAULT_FLOWER,
					IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(10)));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.GRASS,
					new GrassFeatureConfig(Blocks.GRASS.getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(10)));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.DEAD_BUSH,
					IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(3)));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR,
					new MultipleRandomFeatureConfig(new Feature[]{Feature.SAVANNA_TREE}, new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG},
							new float[]{0.8F}, Feature.NORMAL_TREE, IFeatureConfig.NO_FEATURE_CONFIG), Placement.COUNT_EXTRA_HEIGHTMAP,
					new AtSurfaceWithExtraConfig(3, 0.1F, 1)));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_BOOLEAN_SELECTOR,
					new TwoFeatureChoiceConfig(Feature.HUGE_RED_MUSHROOM, new BigMushroomFeatureConfig(false), Feature.HUGE_BROWN_MUSHROOM,
							new BigMushroomFeatureConfig(false)), Placement.COUNT_HEIGHTMAP, new FrequencyConfig(2)));
			addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(
					Feature.DISK,
					new SphereReplaceConfig(Blocks.SAND.getDefaultState(), 7, 2, Lists.newArrayList(Blocks.DIRT.getDefaultState(),
							Blocks.GRASS_BLOCK.getDefaultState())), Placement.COUNT_TOP_SOLID, new FrequencyConfig(3)));
			addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(
					Feature.DISK,
					new SphereReplaceConfig(Blocks.GRAVEL.getDefaultState(), 6, 2, Lists.newArrayList(Blocks.DIRT.getDefaultState(),
							Blocks.GRASS_BLOCK.getDefaultState())), Placement.COUNT_TOP_SOLID, new FrequencyConfig(3)));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.CREEPER, 15, 1, 5));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.BLAZE, 15, 1, 5));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.CAVE_SPIDER, 15, 1, 5));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.GIANT, 15, 1, 5));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.GHAST, 15, 1, 5));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.HUSK, 15, 1, 5));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.MAGMA_CUBE, 15, 1, 5));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.WITHER_SKELETON, 15, 1, 5));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.WITCH, 15, 1, 5));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.SKELETON, 15, 1, 5));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.SHEEP, 15, 1, 5));
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getGrassColor(BlockPos pos) {
			return -26368;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getFoliageColor(BlockPos pos) {
			return -26368;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getSkyColorByTemp(float currentTemperature) {
			return -5916161;
		}
	}
}
