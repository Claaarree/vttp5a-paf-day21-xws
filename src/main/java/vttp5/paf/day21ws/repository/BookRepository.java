package vttp5.paf.day21ws.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp5.paf.day21ws.model.Book;

@Repository
public class BookRepository {
    
    @Autowired
    JdbcTemplate template;

    public List<Book> getBooks(String author, int limit) {
        List<Book> bookList = new LinkedList<>();

        // Chuk's method
        // first % is the escape character for the second % then %s is for the format then the last % is the same as the first 2
        // result would be %author% only
        // String.format("%%%s%%", author)
        SqlRowSet rs = template.queryForRowSet(Queries.SQL_SELECT_BOOKS, author, limit);

        while(rs.next()) {
            bookList.add(Book.toBook(rs));
        }

        return bookList;
    }

    public Book getBookByAsin (String asin) {
        SqlRowSet rs = template.queryForRowSet(Queries.SQL_SELECT_ASIN, asin);
        // moving the cursor down to the row
        rs.next();
        Book b = Book.toBook(rs);

        return b;
    }
}
