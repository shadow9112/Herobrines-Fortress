package net.mcreator.herobrines_fortress;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.block.Blocks;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorHomeblockBlockAdded extends Elementsherobrines_fortress.ModElement {
	public MCreatorHomeblockBlockAdded(Elementsherobrines_fortress instance) {
		super(instance, 131);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorHomeblockBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorHomeblockBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorHomeblockBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorHomeblockBlockAdded!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.IRON_BLOCK.getDefaultState().getBlock())) {
			if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.IRON_BLOCK.getDefaultState().getBlock())) {
				if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 1)))).getBlock() == Blocks.IRON_BLOCK.getDefaultState()
						.getBlock())) {
					if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1)))).getBlock() == Blocks.IRON_BLOCK.getDefaultState()
							.getBlock())) {
						if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.IRON_BLOCK.getDefaultState()
								.getBlock())) {
							if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.IRON_BLOCK
									.getDefaultState().getBlock())) {
								if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 1)))).getBlock() == Blocks.IRON_BLOCK
										.getDefaultState().getBlock())) {
									if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))).getBlock() == Blocks.IRON_BLOCK
											.getDefaultState().getBlock())) {
										herobrines_fortressVariables.MapVariables.get(world).Home_item_give = (double) 0;
										herobrines_fortressVariables.MapVariables.get(world).syncData(world);
									} else {
										world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
										if (!world.isRemote) {
											ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorHomeblock.block,
													(int) (1)));
											entityToSpawn.setPickupDelay(10);
											world.addEntity(entityToSpawn);
										}
									}
								} else {
									world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
									if (!world.isRemote) {
										ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
										entityToSpawn.setPickupDelay(10);
										world.addEntity(entityToSpawn);
									}
								}
							} else {
								world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
								if (!world.isRemote) {
									ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
									entityToSpawn.setPickupDelay(10);
									world.addEntity(entityToSpawn);
								}
							}
						} else {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
							if (!world.isRemote) {
								ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
								entityToSpawn.setPickupDelay(10);
								world.addEntity(entityToSpawn);
							}
						}
					} else {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
						if (!world.isRemote) {
							ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
							entityToSpawn.setPickupDelay(10);
							world.addEntity(entityToSpawn);
						}
					}
				} else {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
					if (!world.isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
						entityToSpawn.setPickupDelay(10);
						world.addEntity(entityToSpawn);
					}
				}
			} else {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				if (!world.isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == MCreatorGoldbrickblock.block.getDefaultState()
				.getBlock())) {
			if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == MCreatorGoldbrickblock.block.getDefaultState()
					.getBlock())) {
				if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 1)))).getBlock() == MCreatorDiamondbrickblock.block
						.getDefaultState().getBlock())) {
					if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1)))).getBlock() == MCreatorDiamondbrickblock.block
							.getDefaultState().getBlock())) {
						if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == MCreatorGoldbrickblock.block
								.getDefaultState().getBlock())) {
							if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == MCreatorGoldbrickblock.block
									.getDefaultState().getBlock())) {
								if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 1)))).getBlock() == MCreatorDiamondbrickblock.block
										.getDefaultState().getBlock())) {
									if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))).getBlock() == MCreatorDiamondbrickblock.block
											.getDefaultState().getBlock())) {
										herobrines_fortressVariables.MapVariables.get(world).Home_item_give = (double) 0;
										herobrines_fortressVariables.MapVariables.get(world).syncData(world);
									} else {
										world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
										if (!world.isRemote) {
											ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorHomeblock.block,
													(int) (1)));
											entityToSpawn.setPickupDelay(10);
											world.addEntity(entityToSpawn);
										}
									}
								} else {
									world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
									if (!world.isRemote) {
										ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
										entityToSpawn.setPickupDelay(10);
										world.addEntity(entityToSpawn);
									}
								}
							} else {
								world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
								if (!world.isRemote) {
									ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
									entityToSpawn.setPickupDelay(10);
									world.addEntity(entityToSpawn);
								}
							}
						} else {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
							if (!world.isRemote) {
								ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
								entityToSpawn.setPickupDelay(10);
								world.addEntity(entityToSpawn);
							}
						}
					} else {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
						if (!world.isRemote) {
							ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
							entityToSpawn.setPickupDelay(10);
							world.addEntity(entityToSpawn);
						}
					}
				} else {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
					if (!world.isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
						entityToSpawn.setPickupDelay(10);
						world.addEntity(entityToSpawn);
					}
				}
			} else {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				if (!world.isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == MCreatorDiamondbrickblock.block
				.getDefaultState().getBlock())) {
			if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == MCreatorDiamondbrickblock.block.getDefaultState()
					.getBlock())) {
				if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 1)))).getBlock() == MCreatorGoldbrickblock.block
						.getDefaultState().getBlock())) {
					if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1)))).getBlock() == MCreatorGoldbrickblock.block
							.getDefaultState().getBlock())) {
						if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == MCreatorDiamondbrickblock.block
								.getDefaultState().getBlock())) {
							if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == MCreatorDiamondbrickblock.block
									.getDefaultState().getBlock())) {
								if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 1)))).getBlock() == MCreatorGoldbrickblock.block
										.getDefaultState().getBlock())) {
									if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))).getBlock() == MCreatorGoldbrickblock.block
											.getDefaultState().getBlock())) {
										herobrines_fortressVariables.MapVariables.get(world).Home_item_give = (double) 0;
										herobrines_fortressVariables.MapVariables.get(world).syncData(world);
									} else {
										world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
										if (!world.isRemote) {
											ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorHomeblock.block,
													(int) (1)));
											entityToSpawn.setPickupDelay(10);
											world.addEntity(entityToSpawn);
										}
									}
								} else {
									world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
									if (!world.isRemote) {
										ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
										entityToSpawn.setPickupDelay(10);
										world.addEntity(entityToSpawn);
									}
								}
							} else {
								world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
								if (!world.isRemote) {
									ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
									entityToSpawn.setPickupDelay(10);
									world.addEntity(entityToSpawn);
								}
							}
						} else {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
							if (!world.isRemote) {
								ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
								entityToSpawn.setPickupDelay(10);
								world.addEntity(entityToSpawn);
							}
						}
					} else {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
						if (!world.isRemote) {
							ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
							entityToSpawn.setPickupDelay(10);
							world.addEntity(entityToSpawn);
						}
					}
				} else {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
					if (!world.isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
						entityToSpawn.setPickupDelay(10);
						world.addEntity(entityToSpawn);
					}
				}
			} else {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				if (!world.isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
			}
		} else {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			if (!world.isRemote) {
				ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
