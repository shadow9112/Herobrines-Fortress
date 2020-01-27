//Made with Blockbench
//Paste this code into your mod.

public static class ModelHuman extends ModelBase {
	private final ModelRenderer bone;

	public ModelHuman() {
		textureWidth = 16;
		textureHeight = 16;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone, 0.9599F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 8, -5.0F, -6.0F, 0.0F, 2, 6, 2,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 8, -2.0F, -6.0F, 0.0F, 2, 6, 2,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 2, 2, -5.0F, -13.0F, 0.0F, 5, 7,
				2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 4, -4.0F, -16.0F, -1.0F, 3, 3,
				3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 8, 12, -3.0F, -17.0F, -1.0F, 1, 1,
				3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 0.0F, -13.0F, 1.0F, 1, 2, 1,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -6.0F, -13.0F, 1.0F, 1, 2,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 1.0F, -14.0F, 1.0F, 1, 1, 1,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 2.0F, -14.0F, 1.0F, 1, 1, 1,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -8.0F, -14.0F, 1.0F, 2, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 3.0F, -15.0F, 1.0F, 1, 1, 1,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -14.0F, -15.0F, 1.0F, 6, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 4.0F, -15.0F, 1.0F, 1, 1, 1,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 3.0F, -14.0F, 2.0F, 1, 1, 0,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, 3.0F, -14.0F, 2.0F, 1, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, 4.0F, -14.0F, 2.0F, 1, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, 5.0F, -14.0F, 2.0F, 1, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, 6.0F, -14.0F, 2.0F, 1, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, 6.0F, -13.0F, 2.0F, 1, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, 5.0F, -13.0F, 2.0F, 1, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, 4.0F, -13.0F, 2.0F, 1, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, 3.0F, -13.0F, 2.0F, 1, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, 2.0F, -13.0F, 2.0F, 1, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, 1.0F, -13.0F, 2.0F, 1, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, 1.0F, -12.0F, 2.0F, 1, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, 2.0F, -12.0F, 2.0F, 1, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, 3.0F, -12.0F, 2.0F, 1, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, 4.0F, -12.0F, 2.0F, 1, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, 5.0F, -12.0F, 2.0F, 1, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, 5.0F, -11.0F, 2.0F, 1, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, 4.0F, -11.0F, 2.0F, 1, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, 4.0F, -10.0F, 2.0F, 1, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, 1.0F, -7.0F, 2.0F, 2, 1, 0,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, -8.0F, -7.0F, 2.0F, 2, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, 0.0F, -11.0F, 2.0F, 4, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, 0.0F, -10.0F, 2.0F, 4, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, 0.0F, -9.0F, 2.0F, 4, 1, 0,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, 0.0F, -8.0F, 2.0F, 4, 1, 0,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, -9.0F, -8.0F, 2.0F, 4, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, -9.0F, -9.0F, 2.0F, 4, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, -11.0F, -12.0F, 2.0F, 5, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, -12.0F, -14.0F, 2.0F, 5, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, -12.0F, -13.0F, 2.0F, 6, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, -10.0F, -10.0F, 2.0F, 5, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, -11.0F, -11.0F, 2.0F, 6, 1,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 5.0F, -15.0F, 1.0F, 1, 1, 1,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 6.0F, -15.0F, 1.0F, 1, 1, 1,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 7.0F, -15.0F, 1.0F, 1, 1, 1,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 8.0F, -15.0F, 1.0F, 1, 1, 1,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 7.0F, -14.0F, 1.0F, 1, 1, 1,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -13.0F, -14.0F, 1.0F, 1, 2,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -12.0F, -12.0F, 1.0F, 1, 2,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -10.0F, -9.0F, 1.0F, 1, 2,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -11.0F, -10.0F, 1.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -9.0F, -7.0F, 1.0F, 1, 1, 1,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 7.0F, -13.0F, 1.0F, 1, 1, 1,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 6.0F, -12.0F, 1.0F, 1, 1, 1,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 6.0F, -11.0F, 1.0F, 1, 1, 1,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 5.0F, -10.0F, 1.0F, 1, 1, 1,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 4.0F, -9.0F, 1.0F, 1, 2, 1,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 3.0F, -7.0F, 1.0F, 1, 1, 1,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 0.0F, -7.0F, 1.0F, 1, 1, 1,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -6.0F, -7.0F, 1.0F, 1, 1, 1,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -8.0F, -6.0F, 1.0F, 2, 1, 1,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 1.0F, -6.0F, 1.0F, 2, 1, 1,
				0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		bone.render(f5);
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
		this.bone.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.bone.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}