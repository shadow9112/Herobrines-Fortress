package net.mcreator.herobrines_fortress;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorFiregem extends Elementsherobrines_fortress.ModElement {
	@ObjectHolder("herobrines_fortress:firegem")
	public static final Item block = null;

	public MCreatorFiregem(Elementsherobrines_fortress instance) {
		super(instance, 17);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(MCreatorCustomelements.tab).maxStackSize(64));
			setRegistryName("firegem");
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
	}
}
