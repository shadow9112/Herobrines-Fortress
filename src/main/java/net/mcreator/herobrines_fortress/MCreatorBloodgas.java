package net.mcreator.herobrines_fortress;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Items;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BucketItem;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.block.material.Material;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.Block;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorBloodgas extends Elementsherobrines_fortress.ModElement {
	@ObjectHolder("herobrines_fortress:bloodgas")
	public static final FlowingFluidBlock block = null;
	@ObjectHolder("herobrines_fortress:bloodgas_bucket")
	public static final Item bucket = null;
	private FlowingFluid flowing = null;
	private FlowingFluid still = null;
	private ForgeFlowingFluid.Properties fluidproperties = null;

	public MCreatorBloodgas(Elementsherobrines_fortress instance) {
		super(instance, 106);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerFluids(RegistryEvent.Register<Fluid> event) {
		event.getRegistry().register(still);
		event.getRegistry().register(flowing);
	}

	@Override
	public void initElements() {
		fluidproperties = new ForgeFlowingFluid.Properties(() -> still, () -> flowing, FluidAttributes
				.builder(new ResourceLocation("herobrines_fortress:blocks/blood_gas"), new ResourceLocation("herobrines_fortress:blocks/blood_gas"))
				.luminosity(2).density(-10).viscosity(1000).gaseous()).bucket(() -> bucket).block(() -> block);
		still = (FlowingFluid) new ForgeFlowingFluid.Source(fluidproperties).setRegistryName("bloodgas");
		flowing = (FlowingFluid) new ForgeFlowingFluid.Flowing(fluidproperties).setRegistryName("bloodgas_flowing");
		elements.blocks.add(() -> new FlowingFluidBlock(still, Block.Properties.create(Material.WATER)) {
		}.setRegistryName("bloodgas"));
		elements.items.add(() -> new BucketItem(still, new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ItemGroup.MISC))
				.setRegistryName("bloodgas_bucket"));
	}
}
