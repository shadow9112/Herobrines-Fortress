package net.mcreator.herobrines_fortress;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.List;
import java.util.Collections;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorSpawnsicknessvillageStructure2 extends Elementsherobrines_fortress.ModElement {
	@ObjectHolder("herobrines_fortress:spawnsicknessvillagestructure2")
	public static final Block block = null;

	public MCreatorSpawnsicknessvillageStructure2(Elementsherobrines_fortress instance) {
		super(instance, 165);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(MCreatorCustomelements.tab)).setRegistryName(block
				.getRegistryName()));
	}

	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(1f, 10f).lightValue(0));
			setRegistryName("spawnsicknessvillagestructure2");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@Override
		public void neighborChanged(BlockState state, World world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
			super.neighborChanged(state, world, pos, neighborBlock, fromPos, moving);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			Block block = this;
			if (world.getRedstonePowerFromNeighbors(new BlockPos(x, y, z)) > 0) {
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					MCreatorSpawnsicknessvillageStructure2BlockAdded.executeProcedure($_dependencies);
				}
			} else {
			}
		}
	}
}
