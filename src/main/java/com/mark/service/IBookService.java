package com.mark.service;

import com.mark.entity.BookVO;
import java.util.List;

public interface IBookService {
    public void saveOrUpdateBook(BookVO book);

    public List<BookVO> getBooks();

    public List<BookVO> getSearchBook();

    public BookVO getBookById(int id);

    public void deleteBookById(int id);
}
