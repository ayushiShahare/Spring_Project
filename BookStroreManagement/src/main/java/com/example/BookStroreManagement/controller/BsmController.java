package com.example.BookStroreManagement.controller;

import com.example.BookStroreManagement.model.Book;
import com.example.BookStroreManagement.model.User;
import com.example.BookStroreManagement.service.BsmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BsmController {


    @Autowired
     BsmService service;


    @PostMapping("/bookEntry")
    public Book createBookEntry(@RequestBody Book book){
        return service.saveBookEntry(book);
    }
    @GetMapping
    public List<Book> getAllBook(){
        return service.getAllBook();
    }
    @PostMapping("/userEntry")
    public User createUserEntry(@RequestBody User user){
        return service.saveUserEntry(user);
    }
    @PostMapping("/update/{userId}")
    public User updateUserEntry(@PathVariable long userId, @RequestBody User user){
        user.setUserId(userId);
        return service.updateUserEntry(user);
    }

    @PostMapping ("/Suspend/{UserId}")
    public HttpStatus suspendUser(@PathVariable long UserId) {
        service.suspendUserByStatus(UserId);
        return HttpStatus.OK;
    }

    @GetMapping("/book/{bookId}")
    public Book getBookById(@PathVariable long bookId){
        return  service.getBookById(bookId);
    }

    @PostMapping("/addMoney/{userId}/{amount}")
    private HttpStatus addMoneyToWallet(@PathVariable long userId,@PathVariable long amount){
        service.addMoneyToWallet(userId,amount);
        return HttpStatus.OK;
    }
    @GetMapping("/listAvailableBooks")
    private List<Book> getAllAvailableBooks(){
        return service.getAllAvailableBooks();
    }
    @GetMapping("/sortedBooksByDate")
    private  List<Book> sortedBooksByDate(){
        return service.sortedBooksByDate();
    }
    @GetMapping("/sortedBooksByLikes")
    private  List<Book> sortedBooksByLikes(){
        return service.sortedBooksByLikes();
    }
    @GetMapping("/borrow/{userId}/{bookId}")
    private HttpStatus borrowedBook(@PathVariable long userId,@PathVariable long bookId){
        service.borrowedBook(userId,bookId);
        return HttpStatus.OK;
    }
}
