package com.Mesh_TestSuites;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;

public class NewTest {
	@Test
	public void f() {
		
		try {
			Files.walk(Paths.get(System.getProperty("user.dir") + "\\src\\test\\resources\\data\\FilesDownload"))
			.filter(Files::isRegularFile)
			.map(Path::toFile)
			.forEach(File::delete);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	
	}
}
