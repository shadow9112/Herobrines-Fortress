package net.mcreator.herobrines_fortress;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.BlockState;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorSkeletonhorsespawneggbecauseMcreatorisbad extends Elementsherobrines_fortress.ModElement {
	@ObjectHolder("herobrines_fortress:skeletonhorsespawneggbecausemcreatorisbad")
	public static final Item block = null;

	public MCreatorSkeletonhorsespawneggbecauseMcreatorisbad(Elementsherobrines_fortress instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(MCreatorCustomelements.tab).maxStackSize(64));
			setRegistryName("skeletonhorsespawneggbecausemcreatorisbad");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
			ActionResultType retval = super.onItemUse(context);
			World world = context.getWorld();
			BlockPos pos = context.getPos();
			PlayerEntity entity = context.getPlayer();
			Direction direction = context.getFace();
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			ItemStack itemstack = context.getItem();
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				MCreatorSkeletonhorsespawneggbecauseMcreatorisbadRightClickedOnBlock.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
