package com.example.demo.Repository;

import com.example.demo.Entities.ImageModel;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepo extends CrudRepository<ImageModel,Long> {
}
