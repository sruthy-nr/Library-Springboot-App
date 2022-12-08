package com.example.libraryapp_backend.dao;

import com.example.libraryapp_backend.model.Library;
import org.springframework.data.repository.CrudRepository;

public interface LibraryDao extends CrudRepository<Library,Integer> {
}
