package vttp5.paf.day21ws.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp5.paf.day21ws.model.Book;
import vttp5.paf.day21ws.repository.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks(String author, int limit) {
        return bookRepository.getBooks(author, limit);
    }

    public Optional<Book> getBookByAsin(String asin) {
        return bookRepository.getBookByAsin(asin);
    }
}
