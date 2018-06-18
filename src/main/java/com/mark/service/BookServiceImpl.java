package com.mark.service;
import java.util.List;

import com.mark.DAO.IBookDao;
import com.mark.entity.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookDao bookDao;

    @Override
    public void saveOrUpdateBook(BookVO book) {
        bookDao.saveOrUpdateBook(book);
    }

    @Override
    public List<BookVO> getBooks() {
        return bookDao.getBooks();
    }

    @Override
    public List<BookVO> getSearchBook() {

        return bookDao.getSearchBook();
    }

    @Override
    public BookVO getBookById(int id) {
        return bookDao.getBookById(id);
    }

    @Override
    public void deleteBookById(int id) {
        bookDao.deleteBookById(id);
    }
}