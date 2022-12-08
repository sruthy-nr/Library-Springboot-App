package com.example.libraryapp_backend.controller;

import com.example.libraryapp_backend.dao.LibraryDao;
import com.example.libraryapp_backend.dao.UserDao;
import com.example.libraryapp_backend.model.Library;
import com.example.libraryapp_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class libraryController {

    @Autowired
    private UserDao udao;


    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public String Homepage(){
    return "Welcome to my website";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userreg", consumes = "application/json", produces = "application/json")
    public Map<String,String> UserReg(@RequestBody User u){
        udao.save(u);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userlogin", consumes = "application/json", produces = "application/json")
    public List<User> UserLogin(@RequestBody User u){
        return (List<User>) udao.userLogin(u.getUsername(),u.getPassword());
    }


    @Autowired
    private LibraryDao ldao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public Map<String,String> AddBook(@RequestBody Library l){
        ldao.save(l);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Library> ViewBooks(){
        return (List<Library>) ldao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search", consumes = "application/json", produces = "application/json")
    public List<Library> SearchBook(@RequestBody Library l){
        return (List<Library>) ldao.searchBook(l.getTitle());
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/edit")
    public String EditBook(){
        return "Edit book";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/delete", consumes = "application/json", produces = "application/json")
    public Map<String, String> DeleteBook(@RequestBody Library l){
        ldao.deleteBook(l.getId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
}
