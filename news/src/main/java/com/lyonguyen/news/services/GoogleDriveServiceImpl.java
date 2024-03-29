//package com.lyonguyen.news.services;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.UrlResource;
//import org.springframework.stereotype.Service;
//
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//
//
//@Service
//public class GoogleDriveServiceImpl implements StorageService {
//
//	@Value("${webapp.uploadfolder}")
//	private String FOLDER;
//
//	public Resource write(String name, InputStream file) throws IOException {
//		// Load the file from a specific location (e.g., "images" directory)
//		String uploadDir = FOLDER;
//		Path filePath = Path.of(uploadDir).resolve(fileName);
//		Resource resource = new UrlResource(filePath.toUri());
//
//		if (resource.exists() && resource.isReadable()) {
//			return resource;
//		} else {
//			throw new FileNotFoundException("File not found: " + fileName);
//		}
//	}
//
//	@Override
//	public Resource read(String name) {
//		return null;
//	}
//
//}
