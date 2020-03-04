package net.mcreator.herobrines_fortress;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorCustommusicdisks extends Elementsherobrines_fortress.ModElement {
	public MCreatorCustommusicdisks(Elementsherobrines_fortress instance) {
		super(instance, 142);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorCustommusicdisks!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorCustommusicdisks!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorCustommusicdisks!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorCustommusicdisks!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.JUKEBOX.getDefaultState().getBlock())) {
			if (((herobrines_fortressVariables.MapVariables.get(world).Dragon_hearted_Variable) == 1)) {
				if (!world.isRemote && world.getServer() != null) {
					world.getServer()
							.getCommandManager()
							.handleCommand(
									new CommandSource(ICommandSource.field_213139_a_, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), world.getServer(), null).withFeedbackDisabled(),
									"stopsound @p master herobrines_fortress:Dragon_hearted");
				}
				world.playSound((PlayerEntity) null, x, y, z, (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
						.getValue(new ResourceLocation("herobrines_fortress:Battlefield")), SoundCategory.NEUTRAL, (float) 0, (float) 0);
				if (!world.isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world, x, (y + 2), z, new ItemStack(MCreatorDragonheartedmusicdisk.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
				herobrines_fortressVariables.MapVariables.get(world).Stop_music = (double) 1;
				herobrines_fortressVariables.MapVariables.get(world).syncData(world);
				herobrines_fortressVariables.MapVariables.get(world).Dragon_hearted_Variable = (double) 0;
				herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			}
		}
	}

	@SubscribeEvent
	public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		PlayerEntity entity = event.getPlayer();
		int i = event.getPos().getX();
		int j = event.getPos().getY();
		int k = event.getPos().getZ();
		World world = event.getWorld();
		java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
