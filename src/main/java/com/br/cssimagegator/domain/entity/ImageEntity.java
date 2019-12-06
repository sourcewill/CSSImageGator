package com.br.cssimagegator.domain.entity;

public class ImageEntity {

	private String imgName;
	private String imgPath;
	private int scaleX;
	private int scaleY;
	private int blurRadius;
	private int spreadRadius;

	public ImageEntity(String imgName, String imgPath, int scaleX, int scaleY, int blurRadius, int spreadRadius) {

		if (imgName == null) {
			throw new RuntimeException("imgName cannot be null.");
		}

		if (imgPath == null) {
			throw new RuntimeException("imgPath cannot be null.");
		}

		this.imgName = imgName;
		this.imgPath = imgPath;
		this.scaleX = scaleX;
		this.scaleY = scaleY;
		this.blurRadius = blurRadius;
		this.spreadRadius = spreadRadius;

	}

	public String getImgName() {
		return imgName;
	}

	public String getImgPath() {
		return imgPath;
	}

	public int getBlurRadius() {
		return blurRadius;
	}

	public int getSpreadRadius() {
		return spreadRadius;
	}

	public int getScaleX() {
		return scaleX;
	}

	public int getScaleY() {
		return scaleY;
	}

}
