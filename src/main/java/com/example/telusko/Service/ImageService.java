package com.example.telusko.Service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.telusko.Repository.ImageRepo;
import com.example.telusko.Util.ImageUtils;
import com.example.telusko.entity.ImageData;

@Service
public class ImageService {

	
	@Autowired
	private ImageRepo repo;
	
	public String uploadImage(MultipartFile file) throws IOException {
		ImageData img= repo.save(ImageData.builder()
				.name(file.getOriginalFilename())
				.type(file.getContentType())
				.imageData(ImageUtils.compressImage(file.getBytes())).build());
		
		if(img !=null) {
			return"File Uploaded Successfully :"+file.getOriginalFilename();
		}
		return null;
	}
	
	public byte[] downloadImage(String fileName) {
		Optional<ImageData> img2 = repo.findByName(fileName);
		byte[] images=ImageUtils.decompressImage(img2.get().getImageData());
		return images;
	}
	
}
