//Made with Blockbench
//Paste this code into your mod.

public static class Modelfirehelmet extends ModelBase {
	private final ModelRenderer helmet;
	private final ModelRenderer left_horn;
	private final ModelRenderer right_horn;

	public Modelfirehelmet() {
		textureWidth = 128;
		textureHeight = 128;

		helmet = new ModelRenderer(this);
		helmet.setRotationPoint(0.0F, 24.0F, 0.0F);
		helmet.cubeList.add(new ModelBox(helmet, 0, 123, -4.0F, -6.0F, 2.0F, 8,
				6, 1, 0.0F, false));
		helmet.cubeList.add(new ModelBox(helmet, 0, 118, -5.0F, -6.0F, -6.0F,
				1, 6, 8, 0.0F, false));
		helmet.cubeList.add(new ModelBox(helmet, 0, 118, 4.0F, -6.0F, -6.0F, 1,
				6, 8, 0.0F, false));
		helmet.cubeList.add(new ModelBox(helmet, 0, 121, -4.0F, -7.0F, -7.0F,
				1, 1, 9, 0.0F, false));
		helmet.cubeList.add(new ModelBox(helmet, 0, 122, -3.0F, -8.0F, -7.0F,
				1, 1, 8, 0.0F, false));
		helmet.cubeList.add(new ModelBox(helmet, 0, 122, -2.0F, -9.0F, -6.0F,
				1, 1, 6, 0.0F, false));
		helmet.cubeList.add(new ModelBox(helmet, 0, 122, 1.0F, -9.0F, -6.0F, 1,
				1, 6, 0.0F, false));
		helmet.cubeList.add(new ModelBox(helmet, 0, 122, 2.0F, -8.0F, -7.0F, 1,
				1, 8, 0.0F, false));
		helmet.cubeList.add(new ModelBox(helmet, 0, 118, 3.0F, -7.0F, -7.0F, 1,
				1, 9, 0.0F, false));
		helmet.cubeList.add(new ModelBox(helmet, 0, 126, -3.0F, -7.0F, 1.0F, 6,
				1, 1, 0.0F, false));
		helmet.cubeList.add(new ModelBox(helmet, 0, 126, -2.0F, -8.0F, 0.0F, 4,
				1, 1, 0.0F, false));
		helmet.cubeList.add(new ModelBox(helmet, 0, 122, -1.0F, -9.0F, -6.0F,
				2, 1, 6, 0.0F, false));
		helmet.cubeList.add(new ModelBox(helmet, 118, 0, -2.0F, -8.0F, -7.0F,
				4, 1, 1, 0.0F, false));
		helmet.cubeList.add(new ModelBox(helmet, 118, 0, -3.0F, -7.0F, -8.0F,
				6, 1, 1, 0.0F, false));

		left_horn = new ModelRenderer(this);
		left_horn.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(left_horn, 0.3491F, 0.0F, 0.0F);
		left_horn.cubeList.add(new ModelBox(left_horn, 0, 0, -3.0F, -12.0F,
				-3.0F, 1, 3, 1, 0.0F, false));
		left_horn.cubeList.add(new ModelBox(left_horn, 0, 0, -3.0F, -17.0F,
				-3.0F, 1, 4, 1, 0.0F, false));
		left_horn.cubeList.add(new ModelBox(left_horn, 0, 0, -4.0F, -15.0F,
				-3.0F, 1, 4, 1, 0.0F, false));
		left_horn.cubeList.add(new ModelBox(left_horn, 0, 0, -4.0F, -12.0F,
				-4.0F, 1, 1, 1, 0.0F, false));
		left_horn.cubeList.add(new ModelBox(left_horn, 0, 0, -3.0F, -14.0F,
				-2.0F, 1, 1, 1, 0.0F, false));
		left_horn.cubeList.add(new ModelBox(left_horn, 0, 0, -3.0F, -15.0F,
				-4.0F, 1, 1, 1, 0.0F, false));

		right_horn = new ModelRenderer(this);
		right_horn.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(right_horn, 0.3491F, 0.0F, 0.0F);
		right_horn.cubeList.add(new ModelBox(right_horn, 0, 0, 2.0F, -12.0F,
				-3.0F, 1, 3, 1, 0.0F, true));
		right_horn.cubeList.add(new ModelBox(right_horn, 0, 0, 2.0F, -17.0F,
				-3.0F, 1, 4, 1, 0.0F, true));
		right_horn.cubeList.add(new ModelBox(right_horn, 0, 0, 3.0F, -15.0F,
				-3.0F, 1, 4, 1, 0.0F, true));
		right_horn.cubeList.add(new ModelBox(right_horn, 0, 0, 3.0F, -12.0F,
				-4.0F, 1, 1, 1, 0.0F, true));
		right_horn.cubeList.add(new ModelBox(right_horn, 0, 0, 2.0F, -14.0F,
				-2.0F, 1, 1, 1, 0.0F, true));
		right_horn.cubeList.add(new ModelBox(right_horn, 0, 0, 2.0F, -15.0F,
				-4.0F, 1, 1, 1, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		helmet.render(f5);
		left_horn.render(f5);
		right_horn.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y,
			float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}