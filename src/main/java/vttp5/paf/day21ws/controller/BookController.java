package vttp5.paf.day21ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vttp5.paf.day21ws.model.Book;
import vttp5.paf.day21ws.service.BookService;

@Controller
@RequestMapping
public class BookController {
    
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ModelAndView getBooks(@RequestParam String author, @RequestParam (defaultValue = "10") int limit) {
        ModelAndView mav = new ModelAndView("books");
        List<Book> booksList = bookService.getBooks(author, limit);
        mav.addObject("books", booksList);
        mav.setStatus(HttpStatusCode.valueOf(200));

        return mav;
    }

    @GetMapping("/books/{asin}")
    public ModelAndView getBookDetails(@PathVariable String asin) {
        ModelAndView mav = new ModelAndView("details");
        Book b = bookService.getBookByAsin(asin);
        mav.addObject("book", b);

        return mav;
    }
}
