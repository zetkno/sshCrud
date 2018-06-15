package com.mark.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.mark.entity.BookVO;
import com.mark.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @RequestMapping(value= {"/bookList","/"}, method = RequestMethod.GET)
    public ModelAndView listAllBooks(ModelAndView model) {
        List<BookVO> books = bookService.getBooks();

        model.addObject("bookList", books);
        model.setViewName("books");

        return model;
    }

    //另一种写法
//  @RequestMapping(value= {"/bookList","/"}, method = RequestMethod.GET)
//  public String listAllBooks(Model model) {
//      List<BookVO> books = bookService.getBooks();
//
//      model.addAttribute("bookList", books);
//
//      return "books";
//  }

    @RequestMapping(value = "/newBook", method = RequestMethod.GET)
    public ModelAndView newBook(ModelAndView model) {
        BookVO book = new BookVO();
        model.addObject("book", book);
        model.setViewName("addOrUpdateBook");
        return model;
    }

    @RequestMapping(value = "saveOrUpdateBook", method = RequestMethod.POST)
    public ModelAndView saveOrUpdateBook(@ModelAttribute BookVO book) {
        bookService.saveOrUpdateBook(book);
        return new ModelAndView("operationSuccess");
    }

    @RequestMapping(value = "modifyBook", method = RequestMethod.GET)
    public ModelAndView modifyBook(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        BookVO book = bookService.getBookById(id);
        ModelAndView model = new ModelAndView("addOrUpdateBook");
        model.addObject("book", book);

        return model;
    }

    @RequestMapping(value = "deleteBook", method = RequestMethod.GET)
    public ModelAndView deleteBook(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        bookService.deleteBookById(id);

        return new ModelAndView("operationSuccess");
    }
}