package net.mcreator.herobrines_fortress;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorCustomelements extends Elementsherobrines_fortress.ModElement {
	public MCreatorCustomelements(Elementsherobrines_fortress instance) {
		super(instance, 118);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabcustomelements") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(MCreatorFiresword.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
