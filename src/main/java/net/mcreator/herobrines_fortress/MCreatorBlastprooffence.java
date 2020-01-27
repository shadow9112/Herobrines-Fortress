package net.mcreator.herobrines_fortress;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockFence;
import net.minecraft.block.Block;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorBlastprooffence extends Elementsherobrines_fortress.ModElement {
	@GameRegistry.ObjectHolder("herobrines_fortress:blastprooffence")
	public static final Block block = null;

	public MCreatorBlastprooffence(Elementsherobrines_fortress instance) {
		super(instance, 36);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom());
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("herobrines_fortress:blastprooffence",
				"inventory"));
	}

	public static class BlockCustom extends BlockFence {
		public BlockCustom() {
			super(Material.ROCK, Material.ROCK.getMaterialMapColor());
			setRegistryName("blastprooffence");
			setUnlocalizedName("blastprooffence");
			setSoundType(SoundType.STONE);
			setHardness(1000F);
			setResistance(1000F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(MCreatorCustomelements.tab);
		}

		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}

		@Override
		public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
			return false;
		}
	}
}
