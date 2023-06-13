package com.example.telusko.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.telusko.entity.ImageData;

public interface ImageRepo extends JpaRepository<ImageData, Long>{

	 Optional<ImageData>findByName(String fileName);
	 
	
}
