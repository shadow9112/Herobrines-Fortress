package net.mcreator.herobrines_fortress;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.Direction;
import net.minecraft.state.StateContainer;
import net.minecraft.state.DirectionProperty;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockItem;
import net.minecraft.fluid.IFluidState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.Random;
import java.util.List;
import java.util.Collections;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorSickWood extends Elementsherobrines_fortress.ModElement {
	@ObjectHolder("herobrines_fortress:sickwood")
	public static final Block block = null;

	public MCreatorSickWood(Elementsherobrines_fortress instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(MCreatorCustomelements.tab)).setRegistryName(block
				.getRegistryName()));
	}

	public static class CustomBlock extends Block {
		public static final DirectionProperty FACING = DirectionalBlock.FACING;

		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 10f).lightValue(0));
			this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.SOUTH));
			setRegistryName("sickwood");
		}

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(FACING);
		}

		@Override
		public BlockState rotate(BlockState state, Rotation rot) {
			if (rot == Rotation.CLOCKWISE_90 || rot == Rotation.COUNTERCLOCKWISE_90) {
				if ((Direction) state.get(FACING) == Direction.WEST || (Direction) state.get(FACING) == Direction.EAST) {
					return state.with(FACING, Direction.UP);
				} else if ((Direction) state.get(FACING) == Direction.UP || (Direction) state.get(FACING) == Direction.DOWN) {
					return state.with(FACING, Direction.WEST);
				}
			}
			return state;
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			Direction facing = context.getFace();
			if (facing == Direction.WEST || facing == Direction.EAST)
				facing = Direction.UP;
			else if (facing == Direction.NORTH || facing == Direction.SOUTH)
				facing = Direction.EAST;
			else
				facing = Direction.SOUTH;
			return this.getDefaultState().with(FACING, facing);
		}

		@Override
		public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return true;
		}

		@Override
		public MaterialColor getMaterialColor(BlockState state, IBlockReader blockAccess, BlockPos pos) {
			return MaterialColor.WOOD;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@Override
		public boolean removedByPlayer(BlockState state, World world, BlockPos pos, PlayerEntity entity, boolean willHarvest, IFluidState fluid) {
			boolean retval = super.removedByPlayer(state, world, pos, entity, willHarvest, fluid);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			Block block = this;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				MCreatorSickWoodBlockDestroyedByPlayer.executeProcedure($_dependencies);
			}
			return retval;
		}

		@Override
		public void onExplosionDestroy(World world, BlockPos pos, Explosion e) {
			super.onExplosionDestroy(world, pos, e);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			Block block = this;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				MCreatorSicktntBlockDestroyedByExplosion.executeProcedure($_dependencies);
			}
		}

		@Override
		public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
			super.onEntityCollision(state, world, pos, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			Block block = this;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				MCreatorSickWoodEntityCollidesInTheBlock.executeProcedure($_dependencies);
			}
		}
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(new OreFeature(OreFeatureConfig::deserialize) {
				@Override
				public boolean place(IWorld world, ChunkGenerator generator, Random rand, BlockPos pos, OreFeatureConfig config) {
					DimensionType dimensionType = world.getDimension().getType();
					boolean dimensionCriteria = false;
					if (dimensionType == DimensionType.OVERWORLD)
						dimensionCriteria = true;
					if (!dimensionCriteria)
						return false;
					return super.place(world, generator, rand, pos, config);
				}
			}, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create("sickwood", "sickwood", blockAt -> {
				boolean blockCriteria = false;
				return blockCriteria;
			}), block.getDefaultState(), 16), Placement.COUNT_RANGE, new CountRangeConfig(10, 10, 10, 110)));
		}
	}
}
