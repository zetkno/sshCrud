package com.mark.DAO;

import java.util.List;
import com.mark.entity.BookVO;

public interface IBookDao {
        public void saveOrUpdateBook(BookVO book);

        public List<BookVO> getBooks();

        public BookVO getBookById(int id);

        public void deleteBookById(int id);
}
