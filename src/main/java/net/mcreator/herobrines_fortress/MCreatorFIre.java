package net.mcreator.herobrines_fortress;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntitySpellcasterIllager;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityBlaze;

import java.util.Random;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorFIre extends Elementsherobrines_fortress.ModElement {
	@GameRegistry.ObjectHolder("herobrines_fortress:fire")
	public static final BiomeGenCustom biome = null;

	public MCreatorFIre(Elementsherobrines_fortress instance) {
		super(instance, 50);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
	}

	static class BiomeGenCustom extends Biome {
		public BiomeGenCustom() {
			super(new Biome.BiomeProperties("Fire").setRainfall(0F).setBaseHeight(0.1F).setWaterColor(-3407872).setHeightVariation(0.5F)
					.setTemperature(2F));
			setRegistryName("fire");
			topBlock = MCreatorFiredirt.block.getDefaultState();
			fillerBlock = Blocks.STONE.getStateFromMeta(0);
			decorator.generateFalls = false;
			decorator.treesPerChunk = 3;
			decorator.flowersPerChunk = 10;
			decorator.grassPerChunk = 10;
			decorator.deadBushPerChunk = 3;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 2;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 3;
			decorator.gravelPatchesPerChunk = 3;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
			this.spawnableCreatureList.add(new SpawnListEntry(EntityCreeper.class, 40, 1, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityBlaze.class, 40, 1, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityCaveSpider.class, 40, 1, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityGiantZombie.class, 40, 1, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityGhast.class, 40, 1, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityHusk.class, 40, 1, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntitySpellcasterIllager.class, 40, 1, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityMagmaCube.class, 40, 1, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityWitherSkeleton.class, 40, 1, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityWitch.class, 40, 1, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntitySkeleton.class, 40, 1, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 40, 1, 5));
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getGrassColorAtPos(BlockPos pos) {
			return -26368;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getFoliageColorAtPos(BlockPos pos) {
			return -26368;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getSkyColorByTemp(float currentTemperature) {
			return -5916161;
		}

		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return new WorldGenSavannaTree(false);
		}
	}
}
