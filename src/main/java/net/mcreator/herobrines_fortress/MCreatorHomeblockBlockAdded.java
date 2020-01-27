package net.mcreator.herobrines_fortress;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.block.state.IBlockState;

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
		if ((new Object() {
			public boolean blockEquals(IBlockState a, IBlockState b) {
				try {
					return (a.getBlock() == b.getBlock()) && (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
				} catch (Exception e) {
					return (a.getBlock() == b.getBlock());
				}
			}
		}.blockEquals((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))), Blocks.IRON_BLOCK.getDefaultState()))) {
			if ((new Object() {
				public boolean blockEquals(IBlockState a, IBlockState b) {
					try {
						return (a.getBlock() == b.getBlock()) && (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
					} catch (Exception e) {
						return (a.getBlock() == b.getBlock());
					}
				}
			}.blockEquals((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))), Blocks.IRON_BLOCK.getDefaultState()))) {
				if ((new Object() {
					public boolean blockEquals(IBlockState a, IBlockState b) {
						try {
							return (a.getBlock() == b.getBlock()) && (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
						} catch (Exception e) {
							return (a.getBlock() == b.getBlock());
						}
					}
				}.blockEquals((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 1)))), Blocks.IRON_BLOCK.getDefaultState()))) {
					if ((new Object() {
						public boolean blockEquals(IBlockState a, IBlockState b) {
							try {
								return (a.getBlock() == b.getBlock()) && (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
							} catch (Exception e) {
								return (a.getBlock() == b.getBlock());
							}
						}
					}.blockEquals((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1)))), Blocks.IRON_BLOCK.getDefaultState()))) {
						if ((new Object() {
							public boolean blockEquals(IBlockState a, IBlockState b) {
								try {
									return (a.getBlock() == b.getBlock()) && (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
								} catch (Exception e) {
									return (a.getBlock() == b.getBlock());
								}
							}
						}.blockEquals((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))), Blocks.IRON_BLOCK.getDefaultState()))) {
							if ((new Object() {
								public boolean blockEquals(IBlockState a, IBlockState b) {
									try {
										return (a.getBlock() == b.getBlock())
												&& (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
									} catch (Exception e) {
										return (a.getBlock() == b.getBlock());
									}
								}
							}.blockEquals((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))), Blocks.IRON_BLOCK.getDefaultState()))) {
								if ((new Object() {
									public boolean blockEquals(IBlockState a, IBlockState b) {
										try {
											return (a.getBlock() == b.getBlock())
													&& (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
										} catch (Exception e) {
											return (a.getBlock() == b.getBlock());
										}
									}
								}.blockEquals((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 1)))),
										Blocks.IRON_BLOCK.getDefaultState()))) {
									if ((new Object() {
										public boolean blockEquals(IBlockState a, IBlockState b) {
											try {
												return (a.getBlock() == b.getBlock())
														&& (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
											} catch (Exception e) {
												return (a.getBlock() == b.getBlock());
											}
										}
									}.blockEquals((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))),
											Blocks.IRON_BLOCK.getDefaultState()))) {
										herobrines_fortressVariables.MapVariables.get(world).Home_item_give = (double) 0;
										herobrines_fortressVariables.MapVariables.get(world).syncData(world);
									} else {
										world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
										if (!world.isRemote) {
											EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(MCreatorHomeblock.block,
													(int) (1)));
											entityToSpawn.setPickupDelay(10);
											world.spawnEntity(entityToSpawn);
										}
									}
								} else {
									world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
									if (!world.isRemote) {
										EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
										entityToSpawn.setPickupDelay(10);
										world.spawnEntity(entityToSpawn);
									}
								}
							} else {
								world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
								if (!world.isRemote) {
									EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
									entityToSpawn.setPickupDelay(10);
									world.spawnEntity(entityToSpawn);
								}
							}
						} else {
							world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
							if (!world.isRemote) {
								EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
								entityToSpawn.setPickupDelay(10);
								world.spawnEntity(entityToSpawn);
							}
						}
					} else {
						world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
						if (!world.isRemote) {
							EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
							entityToSpawn.setPickupDelay(10);
							world.spawnEntity(entityToSpawn);
						}
					}
				} else {
					world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
					if (!world.isRemote) {
						EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
						entityToSpawn.setPickupDelay(10);
						world.spawnEntity(entityToSpawn);
					}
				}
			} else {
				world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
				if (!world.isRemote) {
					EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.spawnEntity(entityToSpawn);
				}
			}
		} else if ((new Object() {
			public boolean blockEquals(IBlockState a, IBlockState b) {
				try {
					return (a.getBlock() == b.getBlock()) && (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
				} catch (Exception e) {
					return (a.getBlock() == b.getBlock());
				}
			}
		}.blockEquals((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))), MCreatorGoldbrickblock.block.getDefaultState()))) {
			if ((new Object() {
				public boolean blockEquals(IBlockState a, IBlockState b) {
					try {
						return (a.getBlock() == b.getBlock()) && (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
					} catch (Exception e) {
						return (a.getBlock() == b.getBlock());
					}
				}
			}.blockEquals((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))), MCreatorGoldbrickblock.block.getDefaultState()))) {
				if ((new Object() {
					public boolean blockEquals(IBlockState a, IBlockState b) {
						try {
							return (a.getBlock() == b.getBlock()) && (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
						} catch (Exception e) {
							return (a.getBlock() == b.getBlock());
						}
					}
				}.blockEquals((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 1)))),
						MCreatorDiamondbrickblock.block.getDefaultState()))) {
					if ((new Object() {
						public boolean blockEquals(IBlockState a, IBlockState b) {
							try {
								return (a.getBlock() == b.getBlock()) && (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
							} catch (Exception e) {
								return (a.getBlock() == b.getBlock());
							}
						}
					}.blockEquals((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1)))),
							MCreatorDiamondbrickblock.block.getDefaultState()))) {
						if ((new Object() {
							public boolean blockEquals(IBlockState a, IBlockState b) {
								try {
									return (a.getBlock() == b.getBlock()) && (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
								} catch (Exception e) {
									return (a.getBlock() == b.getBlock());
								}
							}
						}.blockEquals((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))),
								MCreatorGoldbrickblock.block.getDefaultState()))) {
							if ((new Object() {
								public boolean blockEquals(IBlockState a, IBlockState b) {
									try {
										return (a.getBlock() == b.getBlock())
												&& (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
									} catch (Exception e) {
										return (a.getBlock() == b.getBlock());
									}
								}
							}.blockEquals((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))),
									MCreatorGoldbrickblock.block.getDefaultState()))) {
								if ((new Object() {
									public boolean blockEquals(IBlockState a, IBlockState b) {
										try {
											return (a.getBlock() == b.getBlock())
													&& (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
										} catch (Exception e) {
											return (a.getBlock() == b.getBlock());
										}
									}
								}.blockEquals((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 1)))),
										MCreatorDiamondbrickblock.block.getDefaultState()))) {
									if ((new Object() {
										public boolean blockEquals(IBlockState a, IBlockState b) {
											try {
												return (a.getBlock() == b.getBlock())
														&& (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
											} catch (Exception e) {
												return (a.getBlock() == b.getBlock());
											}
										}
									}.blockEquals((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))),
											MCreatorDiamondbrickblock.block.getDefaultState()))) {
										herobrines_fortressVariables.MapVariables.get(world).Home_item_give = (double) 0;
										herobrines_fortressVariables.MapVariables.get(world).syncData(world);
									} else {
										world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
										if (!world.isRemote) {
											EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(MCreatorHomeblock.block,
													(int) (1)));
											entityToSpawn.setPickupDelay(10);
											world.spawnEntity(entityToSpawn);
										}
									}
								} else {
									world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
									if (!world.isRemote) {
										EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
										entityToSpawn.setPickupDelay(10);
										world.spawnEntity(entityToSpawn);
									}
								}
							} else {
								world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
								if (!world.isRemote) {
									EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
									entityToSpawn.setPickupDelay(10);
									world.spawnEntity(entityToSpawn);
								}
							}
						} else {
							world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
							if (!world.isRemote) {
								EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
								entityToSpawn.setPickupDelay(10);
								world.spawnEntity(entityToSpawn);
							}
						}
					} else {
						world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
						if (!world.isRemote) {
							EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
							entityToSpawn.setPickupDelay(10);
							world.spawnEntity(entityToSpawn);
						}
					}
				} else {
					world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
					if (!world.isRemote) {
						EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
						entityToSpawn.setPickupDelay(10);
						world.spawnEntity(entityToSpawn);
					}
				}
			} else {
				world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
				if (!world.isRemote) {
					EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.spawnEntity(entityToSpawn);
				}
			}
		} else if ((new Object() {
			public boolean blockEquals(IBlockState a, IBlockState b) {
				try {
					return (a.getBlock() == b.getBlock()) && (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
				} catch (Exception e) {
					return (a.getBlock() == b.getBlock());
				}
			}
		}.blockEquals((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))), MCreatorDiamondbrickblock.block.getDefaultState()))) {
			if ((new Object() {
				public boolean blockEquals(IBlockState a, IBlockState b) {
					try {
						return (a.getBlock() == b.getBlock()) && (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
					} catch (Exception e) {
						return (a.getBlock() == b.getBlock());
					}
				}
			}.blockEquals((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))), MCreatorDiamondbrickblock.block.getDefaultState()))) {
				if ((new Object() {
					public boolean blockEquals(IBlockState a, IBlockState b) {
						try {
							return (a.getBlock() == b.getBlock()) && (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
						} catch (Exception e) {
							return (a.getBlock() == b.getBlock());
						}
					}
				}.blockEquals((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 1)))),
						MCreatorGoldbrickblock.block.getDefaultState()))) {
					if ((new Object() {
						public boolean blockEquals(IBlockState a, IBlockState b) {
							try {
								return (a.getBlock() == b.getBlock()) && (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
							} catch (Exception e) {
								return (a.getBlock() == b.getBlock());
							}
						}
					}.blockEquals((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1)))),
							MCreatorGoldbrickblock.block.getDefaultState()))) {
						if ((new Object() {
							public boolean blockEquals(IBlockState a, IBlockState b) {
								try {
									return (a.getBlock() == b.getBlock()) && (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
								} catch (Exception e) {
									return (a.getBlock() == b.getBlock());
								}
							}
						}.blockEquals((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))),
								MCreatorDiamondbrickblock.block.getDefaultState()))) {
							if ((new Object() {
								public boolean blockEquals(IBlockState a, IBlockState b) {
									try {
										return (a.getBlock() == b.getBlock())
												&& (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
									} catch (Exception e) {
										return (a.getBlock() == b.getBlock());
									}
								}
							}.blockEquals((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))),
									MCreatorDiamondbrickblock.block.getDefaultState()))) {
								if ((new Object() {
									public boolean blockEquals(IBlockState a, IBlockState b) {
										try {
											return (a.getBlock() == b.getBlock())
													&& (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
										} catch (Exception e) {
											return (a.getBlock() == b.getBlock());
										}
									}
								}.blockEquals((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 1)))),
										MCreatorGoldbrickblock.block.getDefaultState()))) {
									if ((new Object() {
										public boolean blockEquals(IBlockState a, IBlockState b) {
											try {
												return (a.getBlock() == b.getBlock())
														&& (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
											} catch (Exception e) {
												return (a.getBlock() == b.getBlock());
											}
										}
									}.blockEquals((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))),
											MCreatorGoldbrickblock.block.getDefaultState()))) {
										herobrines_fortressVariables.MapVariables.get(world).Home_item_give = (double) 0;
										herobrines_fortressVariables.MapVariables.get(world).syncData(world);
									} else {
										world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
										if (!world.isRemote) {
											EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(MCreatorHomeblock.block,
													(int) (1)));
											entityToSpawn.setPickupDelay(10);
											world.spawnEntity(entityToSpawn);
										}
									}
								} else {
									world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
									if (!world.isRemote) {
										EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
										entityToSpawn.setPickupDelay(10);
										world.spawnEntity(entityToSpawn);
									}
								}
							} else {
								world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
								if (!world.isRemote) {
									EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
									entityToSpawn.setPickupDelay(10);
									world.spawnEntity(entityToSpawn);
								}
							}
						} else {
							world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
							if (!world.isRemote) {
								EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
								entityToSpawn.setPickupDelay(10);
								world.spawnEntity(entityToSpawn);
							}
						}
					} else {
						world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
						if (!world.isRemote) {
							EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
							entityToSpawn.setPickupDelay(10);
							world.spawnEntity(entityToSpawn);
						}
					}
				} else {
					world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
					if (!world.isRemote) {
						EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
						entityToSpawn.setPickupDelay(10);
						world.spawnEntity(entityToSpawn);
					}
				}
			} else {
				world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
				if (!world.isRemote) {
					EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.spawnEntity(entityToSpawn);
				}
			}
		} else {
			world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
			if (!world.isRemote) {
				EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(MCreatorHomeblock.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.spawnEntity(entityToSpawn);
			}
		}
	}
}
