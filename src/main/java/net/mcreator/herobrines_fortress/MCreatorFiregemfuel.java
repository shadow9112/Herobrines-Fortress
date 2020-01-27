package net.mcreator.herobrines_fortress;

import net.minecraft.item.ItemStack;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorFiregemfuel extends Elementsherobrines_fortress.ModElement {
	public MCreatorFiregemfuel(Elementsherobrines_fortress instance) {
		super(instance, 97);
	}

	@Override
	public int addFuel(ItemStack fuel) {
		if (fuel.getItem() == new ItemStack(MCreatorFiregem.block, (int) (1)).getItem())
			return 5000;
		return 0;
	}
}
