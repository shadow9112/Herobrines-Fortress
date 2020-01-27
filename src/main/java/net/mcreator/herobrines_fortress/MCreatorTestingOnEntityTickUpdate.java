package net.mcreator.herobrines_fortress;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.block.state.IBlockState;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorTestingOnEntityTickUpdate extends Elementsherobrines_fortress.ModElement {
	public MCreatorTestingOnEntityTickUpdate(Elementsherobrines_fortress instance) {
		super(instance, 129);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorTestingOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorTestingOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorTestingOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorTestingOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorTestingOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
				entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100, entity.getLook(1f).z * 100), false,
				false, true).getBlockPos().getX()) == Math.max(20, 80))) {
			if ((new Object() {
				public boolean blockEquals(IBlockState a, IBlockState b) {
					try {
						return (a.getBlock() == b.getBlock()) && (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
					} catch (Exception e) {
						return (a.getBlock() == b.getBlock());
					}
				}
			}.blockEquals((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 2), (int) z))), Blocks.AIR.getDefaultState()))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 2), (int) z), MCreatorTestingprojectile.block.getDefaultState(), 3);
				if ((new Object() {
					public boolean blockEquals(IBlockState a, IBlockState b) {
						try {
							return (a.getBlock() == b.getBlock()) && (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
						} catch (Exception e) {
							return (a.getBlock() == b.getBlock());
						}
					}
				}.blockEquals((world.getBlockState(new BlockPos((int) (x + 2), (int) (y + 1), (int) z))), Blocks.AIR.getDefaultState()))) {
					world.setBlockState(new BlockPos((int) (x + 2), (int) (y + 1), (int) z), MCreatorTestingprojectile.block.getDefaultState(), 3);
					if ((new Object() {
						public boolean blockEquals(IBlockState a, IBlockState b) {
							try {
								return (a.getBlock() == b.getBlock()) && (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
							} catch (Exception e) {
								return (a.getBlock() == b.getBlock());
							}
						}
					}.blockEquals((world.getBlockState(new BlockPos((int) (x + 3), (int) y, (int) z))), Blocks.AIR.getDefaultState()))) {
						world.setBlockState(new BlockPos((int) (x + 3), (int) y, (int) z), MCreatorTestingprojectile.block.getDefaultState(), 3);
						if ((new Object() {
							public boolean blockEquals(IBlockState a, IBlockState b) {
								try {
									return (a.getBlock() == b.getBlock()) && (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
								} catch (Exception e) {
									return (a.getBlock() == b.getBlock());
								}
							}
						}.blockEquals((world.getBlockState(new BlockPos((int) (x + 4), (int) y, (int) z))), Blocks.AIR.getDefaultState()))) {
							world.setBlockState(new BlockPos((int) (x + 4), (int) y, (int) z), MCreatorTestingprojectile.block.getDefaultState(), 3);
							if ((new Object() {
								public boolean blockEquals(IBlockState a, IBlockState b) {
									try {
										return (a.getBlock() == b.getBlock())
												&& (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
									} catch (Exception e) {
										return (a.getBlock() == b.getBlock());
									}
								}
							}.blockEquals((world.getBlockState(new BlockPos((int) (x + 5), (int) (y - 1), (int) z))), Blocks.AIR.getDefaultState()))) {
								world.setBlockState(new BlockPos((int) (x + 5), (int) (y - 1), (int) z),
										MCreatorTestingprojectile.block.getDefaultState(), 3);
								if ((new Object() {
									public boolean blockEquals(IBlockState a, IBlockState b) {
										try {
											return (a.getBlock() == b.getBlock())
													&& (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
										} catch (Exception e) {
											return (a.getBlock() == b.getBlock());
										}
									}
								}.blockEquals((world.getBlockState(new BlockPos((int) (x + 6), (int) (y - 2), (int) z))),
										Blocks.AIR.getDefaultState()))) {
									world.setBlockState(new BlockPos((int) (x + 6), (int) (y - 2), (int) z),
											MCreatorTestingprojectile.block.getDefaultState(), 3);
									if ((new Object() {
										public boolean blockEquals(IBlockState a, IBlockState b) {
											try {
												return (a.getBlock() == b.getBlock())
														&& (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
											} catch (Exception e) {
												return (a.getBlock() == b.getBlock());
											}
										}
									}.blockEquals((world.getBlockState(new BlockPos((int) (x + 7), (int) (y - 3), (int) z))),
											Blocks.AIR.getDefaultState()))) {
										world.setBlockState(new BlockPos((int) (x + 7), (int) (y - 3), (int) z),
												MCreatorTestingprojectile.block.getDefaultState(), 3);
										if ((new Object() {
											public boolean blockEquals(IBlockState a, IBlockState b) {
												try {
													return (a.getBlock() == b.getBlock())
															&& (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
												} catch (Exception e) {
													return (a.getBlock() == b.getBlock());
												}
											}
										}.blockEquals((world.getBlockState(new BlockPos((int) (x + 8), (int) (y - 3), (int) z))),
												Blocks.AIR.getDefaultState()))) {
											world.setBlockState(new BlockPos((int) (x + 8), (int) (y - 3), (int) z),
													MCreatorTestingprojectile.block.getDefaultState(), 3);
											if ((new Object() {
												public boolean blockEquals(IBlockState a, IBlockState b) {
													try {
														return (a.getBlock() == b.getBlock())
																&& (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
													} catch (Exception e) {
														return (a.getBlock() == b.getBlock());
													}
												}
											}.blockEquals((world.getBlockState(new BlockPos((int) (x + 9), (int) (y - 4), (int) z))),
													Blocks.AIR.getDefaultState()))) {
												world.setBlockState(new BlockPos((int) (x + 9), (int) (y - 4), (int) z),
														MCreatorTestingprojectile.block.getDefaultState(), 3);
												if ((new Object() {
													public boolean blockEquals(IBlockState a, IBlockState b) {
														try {
															return (a.getBlock() == b.getBlock())
																	&& (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
														} catch (Exception e) {
															return (a.getBlock() == b.getBlock());
														}
													}
												}.blockEquals((world.getBlockState(new BlockPos((int) (x + 10), (int) (y - 5), (int) z))),
														Blocks.AIR.getDefaultState()))) {
													world.setBlockState(new BlockPos((int) (x + 10), (int) (y - 5), (int) z),
															MCreatorTestingprojectile.block.getDefaultState(), 3);
													if ((new Object() {
														public boolean blockEquals(IBlockState a, IBlockState b) {
															try {
																return (a.getBlock() == b.getBlock())
																		&& (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
															} catch (Exception e) {
																return (a.getBlock() == b.getBlock());
															}
														}
													}.blockEquals((world.getBlockState(new BlockPos((int) (x + 11), (int) (y - 6), (int) z))),
															Blocks.AIR.getDefaultState()))) {
														world.setBlockState(new BlockPos((int) (x + 10), (int) (y - 6), (int) z),
																MCreatorTestingprojectile.block.getDefaultState(), 3);
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} else if (((entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
				entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100, entity.getLook(1f).z * 100), false,
				false, true).getBlockPos().getX()) == Math.max(-80, -20))) {
			if ((new Object() {
				public boolean blockEquals(IBlockState a, IBlockState b) {
					try {
						return (a.getBlock() == b.getBlock()) && (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
					} catch (Exception e) {
						return (a.getBlock() == b.getBlock());
					}
				}
			}.blockEquals((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 2), (int) z))), Blocks.AIR.getDefaultState()))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 2), (int) z), MCreatorTestingprojectile.block.getDefaultState(), 3);
				if ((new Object() {
					public boolean blockEquals(IBlockState a, IBlockState b) {
						try {
							return (a.getBlock() == b.getBlock()) && (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
						} catch (Exception e) {
							return (a.getBlock() == b.getBlock());
						}
					}
				}.blockEquals((world.getBlockState(new BlockPos((int) (x - 2), (int) (y + 1), (int) z))), Blocks.AIR.getDefaultState()))) {
					world.setBlockState(new BlockPos((int) (x - 2), (int) (y + 1), (int) z), MCreatorTestingprojectile.block.getDefaultState(), 3);
					if ((new Object() {
						public boolean blockEquals(IBlockState a, IBlockState b) {
							try {
								return (a.getBlock() == b.getBlock()) && (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
							} catch (Exception e) {
								return (a.getBlock() == b.getBlock());
							}
						}
					}.blockEquals((world.getBlockState(new BlockPos((int) (x - 3), (int) y, (int) z))), Blocks.AIR.getDefaultState()))) {
						world.setBlockState(new BlockPos((int) (x - 3), (int) y, (int) z), MCreatorTestingprojectile.block.getDefaultState(), 3);
						if ((new Object() {
							public boolean blockEquals(IBlockState a, IBlockState b) {
								try {
									return (a.getBlock() == b.getBlock()) && (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
								} catch (Exception e) {
									return (a.getBlock() == b.getBlock());
								}
							}
						}.blockEquals((world.getBlockState(new BlockPos((int) (x - 4), (int) y, (int) z))), Blocks.AIR.getDefaultState()))) {
							world.setBlockState(new BlockPos((int) (x - 4), (int) y, (int) z), MCreatorTestingprojectile.block.getDefaultState(), 3);
							if ((new Object() {
								public boolean blockEquals(IBlockState a, IBlockState b) {
									try {
										return (a.getBlock() == b.getBlock())
												&& (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
									} catch (Exception e) {
										return (a.getBlock() == b.getBlock());
									}
								}
							}.blockEquals((world.getBlockState(new BlockPos((int) (x - 5), (int) (y - 1), (int) z))), Blocks.AIR.getDefaultState()))) {
								world.setBlockState(new BlockPos((int) (x - 5), (int) (y - 1), (int) z),
										MCreatorTestingprojectile.block.getDefaultState(), 3);
								if ((new Object() {
									public boolean blockEquals(IBlockState a, IBlockState b) {
										try {
											return (a.getBlock() == b.getBlock())
													&& (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
										} catch (Exception e) {
											return (a.getBlock() == b.getBlock());
										}
									}
								}.blockEquals((world.getBlockState(new BlockPos((int) (x - 6), (int) (y - 2), (int) z))),
										Blocks.AIR.getDefaultState()))) {
									world.setBlockState(new BlockPos((int) (x - 6), (int) (y - 2), (int) z),
											MCreatorTestingprojectile.block.getDefaultState(), 3);
									if ((new Object() {
										public boolean blockEquals(IBlockState a, IBlockState b) {
											try {
												return (a.getBlock() == b.getBlock())
														&& (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
											} catch (Exception e) {
												return (a.getBlock() == b.getBlock());
											}
										}
									}.blockEquals((world.getBlockState(new BlockPos((int) (x - 7), (int) (y - 3), (int) z))),
											Blocks.AIR.getDefaultState()))) {
										world.setBlockState(new BlockPos((int) (x - 7), (int) (y - 3), (int) z),
												MCreatorTestingprojectile.block.getDefaultState(), 3);
										if ((new Object() {
											public boolean blockEquals(IBlockState a, IBlockState b) {
												try {
													return (a.getBlock() == b.getBlock())
															&& (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
												} catch (Exception e) {
													return (a.getBlock() == b.getBlock());
												}
											}
										}.blockEquals((world.getBlockState(new BlockPos((int) (x - 8), (int) (y - 3), (int) z))),
												Blocks.AIR.getDefaultState()))) {
											world.setBlockState(new BlockPos((int) (x - 8), (int) (y - 3), (int) z),
													MCreatorTestingprojectile.block.getDefaultState(), 3);
											if ((new Object() {
												public boolean blockEquals(IBlockState a, IBlockState b) {
													try {
														return (a.getBlock() == b.getBlock())
																&& (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
													} catch (Exception e) {
														return (a.getBlock() == b.getBlock());
													}
												}
											}.blockEquals((world.getBlockState(new BlockPos((int) (x - 9), (int) (y - 4), (int) z))),
													Blocks.AIR.getDefaultState()))) {
												world.setBlockState(new BlockPos((int) (x - 9), (int) (y - 4), (int) z),
														MCreatorTestingprojectile.block.getDefaultState(), 3);
												if ((new Object() {
													public boolean blockEquals(IBlockState a, IBlockState b) {
														try {
															return (a.getBlock() == b.getBlock())
																	&& (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
														} catch (Exception e) {
															return (a.getBlock() == b.getBlock());
														}
													}
												}.blockEquals((world.getBlockState(new BlockPos((int) (x - 10), (int) (y - 5), (int) z))),
														Blocks.AIR.getDefaultState()))) {
													world.setBlockState(new BlockPos((int) (x - 10), (int) (y - 5), (int) z),
															MCreatorTestingprojectile.block.getDefaultState(), 3);
													if ((new Object() {
														public boolean blockEquals(IBlockState a, IBlockState b) {
															try {
																return (a.getBlock() == b.getBlock())
																		&& (a.getBlock().getMetaFromState(a) == b.getBlock().getMetaFromState(b));
															} catch (Exception e) {
																return (a.getBlock() == b.getBlock());
															}
														}
													}.blockEquals((world.getBlockState(new BlockPos((int) (x - 11), (int) (y - 6), (int) z))),
															Blocks.AIR.getDefaultState()))) {
														world.setBlockState(new BlockPos((int) (x - 10), (int) (y - 6), (int) z),
																MCreatorTestingprojectile.block.getDefaultState(), 3);
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
