package com.example.telusko.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.telusko.Service.ImageService;

@RestController
public class ImageController {
	
	@Autowired
	private ImageService is;

	@PostMapping("/saveimage")
	public ResponseEntity<?> saveimage(@RequestParam("image") MultipartFile file) throws IOException {
		String uploadImage = is.uploadImage(file);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}
	
	@GetMapping("/{fileName}")
	public ResponseEntity<?> downloadimage(@PathVariable String fileName) {
		byte[] imageData = is.downloadImage(fileName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);
	}
	
}
