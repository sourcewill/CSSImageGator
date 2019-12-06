package com.br.cssimagegator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.br.cssimagegator.domain.entity.ImageEntity;
import com.br.cssimagegator.generator.CSSGenerator;

@SpringBootApplication
public class CssImageGatorApplication {

	public static void main(String[] args) {

		SpringApplication.run(CssImageGatorApplication.class, args);

		// Name, Path, Scale X, Scale Y, Blur Radius, Spread Radius
		ImageEntity imageEntity = new ImageEntity("tinbot", "img\\tinbot.png", 5, 5, 0, 2);
		CSSGenerator generator = new CSSGenerator(imageEntity);
		generator.generateCSSFile();

	}

}
