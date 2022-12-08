package com.example.libraryapp_backend.dao;

import com.example.libraryapp_backend.model.Library;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibraryDao extends CrudRepository<Library,Integer> {

    @Query(value = "SELECT `id`, `author`, `descr`, `dist`, `img`, `lang`, `price`, `publish`, `released`, `title` FROM `library` WHERE `title` LIKE %:title%",nativeQuery = true)
    public List<Library> searchBook(@Param("title") String title);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `library` WHERE `id`=:id",nativeQuery = true)
    public void deleteBook(@Param("id") Integer id);
}
