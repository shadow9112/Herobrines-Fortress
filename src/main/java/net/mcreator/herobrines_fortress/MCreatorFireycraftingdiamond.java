package net.mcreator.herobrines_fortress;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorFireycraftingdiamond extends Elementsherobrines_fortress.ModElement {
	public MCreatorFireycraftingdiamond(Elementsherobrines_fortress instance) {
		super(instance, 64);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(MCreatorFireore.block, (int) (1)), new ItemStack(MCreatorFiregem.block, (int) (1)), 1F);
	}
}
