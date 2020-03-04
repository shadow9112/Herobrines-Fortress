package net.mcreator.herobrines_fortress;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorSicktntOnBlockRightClicked2 extends Elementsherobrines_fortress.ModElement {
	public MCreatorSicktntOnBlockRightClicked2(Elementsherobrines_fortress instance) {
		super(instance, 43);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorSicktntOnBlockRightClicked2!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 10, (int) 2));
	}
}
