package com.demo.curd.service;

import com.demo.curd.dto.BookDTO;
import com.demo.curd.entity.BookEntity;
import com.demo.curd.exception.BookNotFoundException;
import com.demo.curd.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper mapper;

    public BookDTO saveBook( BookDTO bookDTO) {

        BookEntity bookEntity = mapper.map(bookDTO, BookEntity.class);
        BookEntity book = bookRepository.save(bookEntity);
        return mapper.map(book, BookDTO.class);
    }

    public List<BookDTO> getAllBooks() {
//        List<BookEntity> bookEntities = bookRepository.findAll();
//        List<BookDTO> bookDTOS = new ArrayList<>();
//        for (BookEntity bookEntity: bookEntities){
//            BookDTO bookDTO = mapper.map(bookEntity, BookDTO.class);
//            bookDTOS.add(bookDTO);
//        }
//        return bookDTOS;
        return bookRepository.findAll().stream()
                .map(bookEntity -> mapper.map(bookEntity, BookDTO.class))
                .toList();
    }

    public void deleteByBookId(Integer id) {
        bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found for id: " + id));
        bookRepository.deleteById(id);
    }

    public BookDTO getById(Integer bookId) {
        BookEntity entity = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book not found for id: " + bookId));
        return mapper.map(entity, BookDTO.class);
    }


    public BookDTO updateById(Integer bookId, BookDTO bookDTO) {
        BookEntity entity = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book not found for id: " + bookId));
        BookEntity book;
//        if(optionalBookEntity.isPresent()){
//            updatedBookEntity = optionalBookEntity.get();
              book = entity;
              book.setBookName(bookDTO.getBookName());
              book.setBookAuthor(bookDTO.getBookAuthor());
              book.setBookPrice(bookDTO.getBookPrice());
              book.setDescription(bookDTO.getDescription());
              bookRepository.save(book);
              return mapper.map(book, BookDTO.class);

//        }
//        return null;
    }

    public BookDTO findByBookName(String bookName) {
        Optional<BookEntity> bookEntity = bookRepository.findByBookName(bookName);
        return bookEntity.map(entity -> mapper.map(entity, BookDTO.class)).orElse(null);
    }

    public void saveAll(List<BookEntity> bookEntityList) {
        bookEntityList.forEach(bookEntity -> bookRepository.save(bookEntity));
    }

    public List<BookDTO> getBooksWithPaging(Integer pageNo, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by("bookPrice"));
        Page<BookEntity> bookEntityPage = bookRepository.findAll(pageRequest);
        return bookEntityPage.getContent()
                .stream()
                .map(bookEntity -> mapper.map(bookEntity, BookDTO.class))
                .toList();
    }
}