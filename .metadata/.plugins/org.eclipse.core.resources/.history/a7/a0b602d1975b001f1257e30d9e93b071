package com.demo.curd.controller;

import com.demo.curd.dto.BookDTO;
import com.demo.curd.entity.BookEntity;
import com.demo.curd.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
//@Validated
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/save")
    public ResponseEntity<BookDTO> saveBook(@RequestBody @Valid BookDTO bookDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        BookDTO savedBook = bookService.saveBook(bookDTO);
//        bookService.saveBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/delete/{bookid}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookid") Integer bookid) {
        bookService.deleteByBookId(bookid);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{bookid}")
    public ResponseEntity<BookDTO> getById(@PathVariable("bookid") Integer bookid) {
        BookDTO book = bookService.getById(bookid);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/update/{bookid}")
    public ResponseEntity<BookDTO> updateById(@PathVariable("bookid") Integer bookid, @RequestBody BookDTO bookDTO) {
        BookDTO updatedBook = bookService.updateById(bookid, bookDTO);
        return ResponseEntity.ok(updatedBook);
    }

    @GetMapping("/book-name")
    public ResponseEntity<BookDTO> findByBookName(@RequestParam String bookName) {
        BookDTO book = bookService.findByBookName(bookName);
        return ResponseEntity.ok(book);
    }
    @PostMapping("/save-all")
    public void saveAll(@RequestBody List<BookEntity> bookEntityList){
        bookService.saveAll(bookEntityList);
    }

    @GetMapping("/get-paging")
    public List<BookDTO> getBooksWithPaging(@RequestParam Integer pageNo, @RequestParam(defaultValue = "5") Integer pageSize){
        return bookService.getBooksWithPaging(pageNo, pageSize);
    }

}

