package net.mcreator.herobrines_fortress;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Potion;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effect;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.List;
import java.util.ArrayList;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorNethered extends Elementsherobrines_fortress.ModElement {
	@ObjectHolder("herobrines_fortress:nethered")
	public static final Effect potion = null;
	@ObjectHolder("herobrines_fortress:nethered")
	public static final Potion potionType = null;

	public MCreatorNethered(Elementsherobrines_fortress instance) {
		super(instance, 53);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerEffect(RegistryEvent.Register<Effect> event) {
		event.getRegistry().register(new EffectCustom());
	}

	@SubscribeEvent
	public void registerPotion(RegistryEvent.Register<Potion> event) {
		event.getRegistry().register(new PotionCustom());
	}

	public static class PotionCustom extends Potion {
		public PotionCustom() {
			super(new EffectInstance(potion, 3600));
			setRegistryName("nethered");
		}
	}

	public static class EffectCustom extends Effect {
		private final ResourceLocation potionIcon;

		public EffectCustom() {
			super(EffectType.HARMFUL, -16711732);
			setRegistryName("nethered");
			potionIcon = new ResourceLocation("herobrines_fortress:textures/71sfjf5loll._sy355_.png");
		}

		@Override
		public String getName() {
			return "effect.nethered";
		}

		@Override
		public boolean isBeneficial() {
			return false;
		}

		@Override
		public boolean isInstant() {
			return true;
		}

		@Override
		public List<ItemStack> getCurativeItems() {
			List<ItemStack> ret = new ArrayList<>();
			ret.add(new ItemStack(Items.MILK_BUCKET, (int) (1)));
			return ret;
		}

		@Override
		public boolean shouldRenderInvText(EffectInstance effect) {
			return true;
		}

		@Override
		public boolean shouldRenderHUD(EffectInstance effect) {
			return true;
		}

		@Override
		public void affectEntity(Entity source, Entity indirectSource, LivingEntity entity, int amplifier, double health) {
			World world = entity.world;
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				MCreatorNetheredPotionStartedapplied.executeProcedure($_dependencies);
			}
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}
	}
}
