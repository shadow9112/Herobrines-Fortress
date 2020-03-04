package net.mcreator.herobrines_fortress;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorCustomelements extends Elementsherobrines_fortress.ModElement {
	public MCreatorCustomelements(Elementsherobrines_fortress instance) {
		super(instance, 118);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabcustomelements") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MCreatorFiresword.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
