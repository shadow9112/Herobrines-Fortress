package net.mcreator.herobrines_fortress;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorSickdustItemInHandTick extends Elementsherobrines_fortress.ModElement {
	public MCreatorSickdustItemInHandTick(Elementsherobrines_fortress instance) {
		super(instance, 171);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorSickdustItemInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 2, (int) 0.5));
	}
}
