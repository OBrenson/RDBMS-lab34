package org.example.api;

import org.example.crud.CrudMongoService;
import org.example.model.mongo.MAuthor;
import org.example.model.mongo.MBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mongo")
public class MongoController implements ControllerApi<MBook, MAuthor> {

    @Autowired
    private CrudMongoService crudMongoService;

    @PutMapping("/book/create")
    public String saveBook(@RequestBody MBook book) {
        return crudMongoService.saveBook(book).getId();
    }

    @PutMapping("/author/create")
    @Override
    public String saveAuthor(@RequestBody MAuthor author) {
        return crudMongoService.saveAuthor(author).toString();
    }

    @DeleteMapping("/book/delete")
    @Override
    public String deleteBook(@RequestParam(name = "id") String id) {
        return crudMongoService.deleteBook(id);
    }

    @DeleteMapping("/author/delete")
    @Override
    public String deleteAuthor(@RequestParam(name = "id") String id) {
        return crudMongoService.deleteAuthor(id);
    }

    @GetMapping("/book/find")
    @Override
    public MBook findBook(@RequestParam(name = "id") String id) {
        return crudMongoService.getBook(id);
    }

    @GetMapping("/author/find")
    @Override
    public MAuthor findAuthor(@RequestParam(name = "id") String id) {
        return crudMongoService.getAuthor(id);
    }

    @GetMapping("/book/getByAuthor")
    @Override
    public List<MBook> getBooksByAuthor(@RequestParam(name = "id") String id) {
        return crudMongoService.getBooksByAuthor(id);
    }

    @Override
    @GetMapping("/book/all")
    public List<MBook> findAllBooks() {
        return crudMongoService.findAllBooks();
    }

    @Override
    @GetMapping("/author/all")
    public List<MAuthor> findAllUsers() {
        return crudMongoService.findAllAuthors();
    }
}
