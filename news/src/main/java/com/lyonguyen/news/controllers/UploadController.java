package com.lyonguyen.news.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lyonguyen.news.models.CKEditorUploadResponse;
import com.lyonguyen.news.services.StorageService;

@RestController
public class UploadController {

	@PostMapping("/api/upload")
	public String upload(@RequestParam("upload") MultipartFile file) throws IOException {
		if (file.isEmpty()) {
			return "No file was selected for upload.";
		}

		try {
			// Get the file name
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());

			// Define the upload directory relative to the application's current directory
			String uploadDir = "images";

			// Get the absolute path of the upload directory
			String uploadPath = System.getProperty("user.dir") + File.separator + uploadDir;

			// Create the upload directory if it doesn't exist
			Path directory = Path.of(uploadPath);
			if (!Files.exists(directory)) {
				Files.createDirectories(directory);
			}

			// Save the uploaded file to the specified location
			Path filePath = directory.resolve(fileName);
			Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

			return "File uploaded successfully.";
		} catch (IOException e) {
			return "Failed to upload the file: " + e.getMessage();
		}
	}

}
