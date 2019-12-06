package com.br.cssimagegator.generator;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import com.br.cssimagegator.domain.entity.ImageEntity;

public class CSSGenerator {

	private ImageEntity imageEntity;

	public CSSGenerator(ImageEntity imageEntity) {

		if (imageEntity == null) {
			throw new RuntimeException("imageEntity cannot be null.");
		}

		this.imageEntity = imageEntity;
	}

	public void generateCSSFile() {
		Path path = Paths.get("img/" + imageEntity.getImgName() + ".css");
		String text = generateCSSImage();
		byte[] textToBytes = text.getBytes();
		try {
			Files.write(path, textToBytes);
		} catch (IOException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		System.out.println("\nCSS File created: (" + path + ")");

	}

	public String generateCSSImage() {

		String CSS = "";
		CSS = "body {\n" + "  background: black;  \n" + "}\n" + "#" + imageEntity.getImgName() + "{\n"
				+ "    position: absolute;\n" + "    top: 30px;\n" + "    left: 50%;\n" + "    margin-left: -200px;\n"
				+ "    width: 0;\n" + "    height: 0;\n" + "    box-shadow:" + generateCSSPixels() + " \n" + "}";
		return CSS;
	}

	public String generateCSSPixels() {

		File imageFile = new File(imageEntity.getImgPath());
		Color color;
		StringBuilder pixels = new StringBuilder();
		String str = "";

		try {
			BufferedImage buffer = ImageIO.read(imageFile);
			System.out.println("\nProcessing input image (" + imageEntity.getImgPath() + ")");
			for (int i = 0; i < buffer.getWidth(); i++) {
				for (int j = 0; j < buffer.getHeight(); j++) {
					color = new Color(buffer.getRGB(i, j));
					pixels.append("\n" + "    " + (i * imageEntity.getScaleX()) + "px " + (j * imageEntity.getScaleY())
							+ "px " + imageEntity.getBlurRadius() + "px " + imageEntity.getSpreadRadius() + "px "
							+ RGBtoHex(color.getRed(), color.getGreen(), color.getBlue()) + ",");
				}
				pixels.append("\n");
			}
			str = pixels.substring(0, pixels.length() - 2);
			str += ";";
		} catch (IOException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		return str;
	}

	private String RGBtoHex(int r, int g, int b) {
		return String.format("#%02x%02x%02x", r, g, b);
	}
}
