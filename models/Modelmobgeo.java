//Made with Blockbench
//Paste this code into your mod.

public static class Modelmobgeo extends ModelBase {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone18;
	private final ModelRenderer bone20;
	private final ModelRenderer bone4;
	private final ModelRenderer bone6;
	private final ModelRenderer bone8;
	private final ModelRenderer bone10;
	private final ModelRenderer bone5;
	private final ModelRenderer bone7;
	private final ModelRenderer bone9;
	private final ModelRenderer bone11;
	private final ModelRenderer bone12;
	private final ModelRenderer bone13;
	private final ModelRenderer bone14;
	private final ModelRenderer bone15;
	private final ModelRenderer bone16;
	private final ModelRenderer bone17;
	private final ModelRenderer bone19;
	private final ModelRenderer bone21;
	private final ModelRenderer bone22;
	private final ModelRenderer bone23;
	private final ModelRenderer bone24;
	private final ModelRenderer bone25;
	private final ModelRenderer bone26;

	public Modelmobgeo() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone, 0.5236F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, 3.0F, -10.0F, 2.0F, 5, 11,
				5, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone2, 0.5236F, 0.0F, 0.0F);
		bone2.cubeList.add(new ModelBox(bone2, 0, 0, -8.0F, -10.0F, 2.0F, 5,
				11, 5, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 0, 0, -8.0F, -19.0F, -16.0F, 5,
				11, 5, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 0, 0, 3.0F, -19.0F, -16.0F, 5,
				11, 5, 0.0F, false));

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone3.cubeList.add(new ModelBox(bone3, 14, 33, -2.0F, -13.0F, 0.0F, 4,
				4, 18, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 12, 38, -2.0F, -13.0F, -45.0F,
				4, 4, 22, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 30, 0, -4.0F, -16.0F, -54.0F, 8,
				7, 11, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 14, 33, -2.0F, -13.0F, 19.0F, 4,
				4, 18, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 14, 33, -1.0F, -12.0F, 30.0F, 2,
				2, 12, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 14, 33, -2.0F, -12.0F, 11.0F, 4,
				4, 15, 0.0F, false));

		bone18 = new ModelRenderer(this);
		bone18.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone18, 0.0F, 0.1745F, 0.0F);
		bone3.addChild(bone18);
		bone18.cubeList.add(new ModelBox(bone18, 0, 25, -29.0F, -14.0F, -25.0F,
				29, 3, 3, 0.0F, false));

		bone20 = new ModelRenderer(this);
		bone20.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone20, 0.0F, 0.1745F, 0.0F);
		bone3.addChild(bone20);
		bone20.cubeList.add(new ModelBox(bone20, 0, 25, -50.0F, -14.0F, -24.0F,
				29, 3, 3, 0.0F, false));

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone4.cubeList.add(new ModelBox(bone4, 0, 16, -0.5F, -15.0F, 3.0F, 1,
				2, 3, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 0, 16, -0.5F, -16.0F, 4.0F, 1,
				1, 2, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 0, 16, -0.5F, -17.0F, 4.0F, 1,
				1, 1, 0.0F, false));

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone6.cubeList.add(new ModelBox(bone6, 0, 16, -0.5F, -14.0F, 14.0F, 1,
				2, 3, 0.0F, false));
		bone6.cubeList.add(new ModelBox(bone6, 0, 16, -0.5F, -15.0F, 15.0F, 1,
				1, 2, 0.0F, false));
		bone6.cubeList.add(new ModelBox(bone6, 0, 16, -0.5F, -16.0F, 15.0F, 1,
				1, 1, 0.0F, false));

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone8.cubeList.add(new ModelBox(bone8, 0, 16, -0.5F, -15.0F, 25.0F, 1,
				2, 3, 0.0F, false));
		bone8.cubeList.add(new ModelBox(bone8, 0, 16, -0.5F, -16.0F, 26.0F, 1,
				1, 2, 0.0F, false));
		bone8.cubeList.add(new ModelBox(bone8, 0, 16, -0.5F, -17.0F, 26.0F, 1,
				1, 1, 0.0F, false));

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone10.cubeList.add(new ModelBox(bone10, 0, 21, -0.5F, -13.0F, 31.0F,
				1, 1, 2, 0.0F, false));
		bone10.cubeList.add(new ModelBox(bone10, 0, 0, -0.5F, -14.0F, 31.0F, 1,
				1, 1, 0.0F, false));

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone5.cubeList.add(new ModelBox(bone5, 0, 33, -5.0F, -14.0F, -27.0F,
				10, 6, 27, 0.0F, false));

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone7.cubeList.add(new ModelBox(bone7, 0, 16, -0.5F, -16.0F, -4.0F, 1,
				2, 3, 0.0F, false));
		bone7.cubeList.add(new ModelBox(bone7, 0, 16, -0.5F, -17.0F, -3.0F, 1,
				1, 2, 0.0F, false));
		bone7.cubeList.add(new ModelBox(bone7, 0, 16, -0.5F, -18.0F, -3.0F, 1,
				1, 1, 0.0F, false));

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone9.cubeList.add(new ModelBox(bone9, 0, 16, -0.5F, -16.0F, -12.0F, 1,
				2, 3, 0.0F, false));
		bone9.cubeList.add(new ModelBox(bone9, 0, 16, -0.5F, -17.0F, -11.0F, 1,
				1, 2, 0.0F, false));
		bone9.cubeList.add(new ModelBox(bone9, 0, 16, -0.5F, -18.0F, -11.0F, 1,
				1, 1, 0.0F, false));

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone11.cubeList.add(new ModelBox(bone11, 0, 16, -0.5F, -16.0F, -20.0F,
				1, 2, 3, 0.0F, false));
		bone11.cubeList.add(new ModelBox(bone11, 0, 16, -0.5F, -17.0F, -19.0F,
				1, 1, 2, 0.0F, false));
		bone11.cubeList.add(new ModelBox(bone11, 0, 16, -0.5F, -18.0F, -19.0F,
				1, 1, 1, 0.0F, false));

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone12.cubeList.add(new ModelBox(bone12, 0, 16, -0.5F, -16.0F, -27.0F,
				1, 2, 3, 0.0F, false));
		bone12.cubeList.add(new ModelBox(bone12, 0, 16, -0.5F, -17.0F, -26.0F,
				1, 1, 2, 0.0F, false));
		bone12.cubeList.add(new ModelBox(bone12, 0, 16, -0.5F, -18.0F, -26.0F,
				1, 1, 1, 0.0F, false));

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone13, -0.0349F, 0.0F, 0.0F);
		bone13.cubeList.add(new ModelBox(bone13, 0, 44, -3.0F, -11.5812F,
				-59.9927F, 6, 2, 6, 0.0F, false));

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone14, 0.0175F, 0.0F, 0.0F);
		bone14.cubeList.add(new ModelBox(bone14, 0, 52, -3.0F, -12.2094F,
				-58.9982F, 6, 2, 6, 0.0F, false));

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone15.cubeList.add(new ModelBox(bone15, 0, 16, -0.5F, -15.0F, -34.0F,
				1, 2, 3, 0.0F, false));
		bone15.cubeList.add(new ModelBox(bone15, 0, 16, -0.5F, -16.0F, -33.0F,
				1, 1, 2, 0.0F, false));
		bone15.cubeList.add(new ModelBox(bone15, 0, 16, -0.5F, -17.0F, -33.0F,
				1, 1, 1, 0.0F, false));

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone16.cubeList.add(new ModelBox(bone16, 0, 16, -0.5F, -15.0F, -42.0F,
				1, 2, 3, 0.0F, false));
		bone16.cubeList.add(new ModelBox(bone16, 0, 16, -0.5F, -16.0F, -41.0F,
				1, 1, 2, 0.0F, false));
		bone16.cubeList.add(new ModelBox(bone16, 0, 16, -0.5F, -17.0F, -41.0F,
				1, 1, 1, 0.0F, false));

		bone17 = new ModelRenderer(this);
		bone17.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone17.cubeList.add(new ModelBox(bone17, 0, 16, -0.5F, -18.0F, -51.0F,
				1, 2, 3, 0.0F, false));
		bone17.cubeList.add(new ModelBox(bone17, 0, 16, -0.5F, -19.0F, -50.0F,
				1, 1, 2, 0.0F, false));
		bone17.cubeList.add(new ModelBox(bone17, 0, 16, -0.5F, -20.0F, -50.0F,
				1, 1, 1, 0.0F, false));

		bone19 = new ModelRenderer(this);
		bone19.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone19, 0.0F, -0.1745F, 0.0F);
		bone19.cubeList.add(new ModelBox(bone19, 0, 25, 0.0F, -14.0F, -25.0F,
				29, 3, 3, 0.0F, true));
		bone19.cubeList.add(new ModelBox(bone19, 0, 25, 20.0F, -14.0F, -24.0F,
				29, 3, 3, 0.0F, true));

		bone21 = new ModelRenderer(this);
		bone21.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone21.cubeList.add(new ModelBox(bone21, 0, 33, -24.0F, -13.0F, -21.0F,
				19, 1, 20, 0.0F, false));
		bone21.cubeList.add(new ModelBox(bone21, 0, 33, -43.0F, -13.0F, -17.0F,
				19, 1, 16, 0.0F, false));
		bone21.cubeList.add(new ModelBox(bone21, 0, 33, -50.0F, -13.0F, -15.0F,
				19, 1, 14, 0.0F, false));

		bone22 = new ModelRenderer(this);
		bone22.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone22.cubeList.add(new ModelBox(bone22, 0, 33, 5.0F, -13.0F, -21.0F,
				19, 1, 20, 0.0F, true));
		bone22.cubeList.add(new ModelBox(bone22, 0, 33, 24.0F, -13.0F, -17.0F,
				19, 1, 16, 0.0F, true));
		bone22.cubeList.add(new ModelBox(bone22, 0, 33, 31.0F, -13.0F, -15.0F,
				19, 1, 14, 0.0F, true));

		bone23 = new ModelRenderer(this);
		bone23.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone23, 0.0F, -0.8727F, 0.0F);
		bone23.cubeList.add(new ModelBox(bone23, 0, 25, -13.0F, -14.0F, -19.0F,
				29, 3, 3, 0.0F, true));

		bone24 = new ModelRenderer(this);
		bone24.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone24, 0.0F, -0.5236F, 0.0F);
		bone24.cubeList.add(new ModelBox(bone24, 0, 25, -4.0F, -14.0F, -25.0F,
				43, 3, 3, 0.0F, true));

		bone25 = new ModelRenderer(this);
		bone25.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone25, 0.0F, 0.8727F, 0.0F);
		bone25.cubeList.add(new ModelBox(bone25, 0, 25, -16.0F, -14.0F, -20.0F,
				29, 3, 3, 0.0F, false));

		bone26 = new ModelRenderer(this);
		bone26.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone26, 0.0F, 0.5236F, 0.0F);
		bone26.cubeList.add(new ModelBox(bone26, 0, 25, -41.0F, -14.0F, -25.0F,
				43, 3, 3, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		bone.render(f5);
		bone2.render(f5);
		bone3.render(f5);
		bone4.render(f5);
		bone6.render(f5);
		bone8.render(f5);
		bone10.render(f5);
		bone5.render(f5);
		bone7.render(f5);
		bone9.render(f5);
		bone11.render(f5);
		bone12.render(f5);
		bone13.render(f5);
		bone14.render(f5);
		bone15.render(f5);
		bone16.render(f5);
		bone17.render(f5);
		bone19.render(f5);
		bone21.render(f5);
		bone22.render(f5);
		bone23.render(f5);
		bone24.render(f5);
		bone25.render(f5);
		bone26.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y,
			float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}