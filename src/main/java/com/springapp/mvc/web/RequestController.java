package com.springapp.mvc.web;

import com.springapp.mvc.model.Request;
import com.springapp.mvc.service.ReqStatusService;
import com.springapp.mvc.service.RequestService;
import com.springapp.mvc.service.SecurityService;
import com.springapp.mvc.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequestController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private RequestService requestService;
    
    @Autowired
    private ReqStatusService reqStatusService;


    @RequestMapping(value = {"/", "/req_all"}, method = RequestMethod.GET)
    public ModelAndView welcome(@RequestParam(value = "status", required = false) String status,                                   
                                HttpSession session ) {
        ModelAndView mv = new ModelAndView("req_all");
        if(status == null) {
            mv.addObject("listRequests", requestService.findAll());
        }else{
            mv.addObject("listRequests", reqStatusService.findByName(status).getRequests());
        }
        mv.addObject("listReqStatus", reqStatusService.findAll());
        session.setAttribute("search", "request"); // for search
        return mv;
    }
    
/*    @RequestMapping(value = "/book-{url}", method = RequestMethod.GET)
    public ModelAndView book_one(@PathVariable ("url") String url, HttpSession session) {                 
        ModelAndView mv = new ModelAndView("book_one");               
        Book book = bookService.getBookByUrl(url);
        Author author = book.getAuthors().iterator().next();
        mv.addObject("book", book);
        mv.addObject("author", author);
        session.setAttribute("search", "book"); // for search       
        session.setAttribute("currentpagewithpage", "/book-" + url);       
        return mv;
    }
*/    
    @RequestMapping(value = "/request/add", method = RequestMethod.GET)
    public ModelAndView book_add(HttpSession session) {       
        ModelAndView mv = new ModelAndView("req_add");                     
        return mv;       
    }
 /*   
    @RequestMapping(value="/book/add", method = RequestMethod.POST)
    public ModelAndView book_add( @RequestParam(value = "addBook", required = false) String addBook,
                                  @RequestParam(value = "bookName") String bookName,
                                  @RequestParam(value = "author") String authorName,
                                  @RequestParam(value = "lang") String lang,
                                  @RequestParam(value = "publisher") String publisher,
                                  @RequestParam(value = "volume") String volume,
                                  @RequestParam(value = "yearOfPublication") String yearOfPublication,
                                  @RequestParam(value = "cityOfPublication") String cityOfPublication,
                                  @RequestParam(value = "description") String description,
                                  HttpSession session ) {                            
            bookService.add(bookName, authorName, lang, publisher, volume, yearOfPublication, cityOfPublication, description);
            Book book = bookService.getBookByName(bookName);           
            return book_one(book.getUrl(), session);                                                    
    } 
    
    @RequestMapping(value = "/book-{url}/update", method = RequestMethod.GET)
    public ModelAndView book_update(@PathVariable ("url") String url, HttpSession session) {        
        ModelAndView mv = new ModelAndView("book_update");       
        Book book = bookService.getBookByUrl(url);
        Author author = book.getAuthors().iterator().next();
        mv.addObject("book", book);
        mv.addObject("author", author);
        return mv;       
    }
    
    @RequestMapping(value="/book-{url}/update", method = RequestMethod.POST)
    public ModelAndView book_update( @PathVariable ("url") String url,
                                  @RequestParam(value = "bookName") String bookName,
                                  @RequestParam(value = "author") String authorName,
                                  @RequestParam(value = "lang") String lang,
                                  @RequestParam(value = "publisher") String publisher,
                                  @RequestParam(value = "volume") String volume,
                                  @RequestParam(value = "yearOfPublication") String yearOfPublication,
                                  @RequestParam(value = "cityOfPublication") String cityOfPublication,
                                  @RequestParam(value = "description") String description,
                                  HttpSession session ) {
        if(bookName=="" && authorName=="" && lang=="" && publisher=="" && volume=="" && yearOfPublication=="" && cityOfPublication=="" && description==""){                     
            return book_one(url, session);
        } else {
            Book book = bookService.getBookByUrl(url);
            bookService.update(bookName, url, authorName, lang, publisher, volume, yearOfPublication, cityOfPublication, description);
            book = bookService.getBookById(book.getId());           
            return book_one(book.getUrl(), session);
        }                                                               
    } 
    
    @RequestMapping(value = "/book-{url}/delete", method = RequestMethod.GET)
    public ModelAndView book_delete(@PathVariable ("url") String url, HttpSession session) {       
        ModelAndView mv = new ModelAndView("book_delete");
        Book book = bookService.getBookByUrl(url);       
        mv.addObject("book", book);
        return mv;       
    }
    
    @RequestMapping(value="/book-{url}/delete", method = RequestMethod.POST)
    public String book_delete_yes( @PathVariable ("url") String url, 
                                   @RequestParam(value = "submit", required = false) String submit,
                                   HttpSession session ) {                
        if(submit!=null && submit!=""){
            bookService.delete(url);
        }                          
        return "redirect:/book";                                                                      
    } 
    */
}
