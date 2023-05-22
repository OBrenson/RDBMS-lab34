package org.example.api;

import org.example.crud.CrudService;
import org.example.model.cassandra.CAuthor;
import org.example.model.cassandra.CBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cassandra")
public class CassandraController implements ControllerApi<CBook, CAuthor>{

    @Autowired
    private CrudService<CBook, CAuthor> crudCassandraService;

    @PutMapping("/book/create")
    public String saveBook(@RequestBody CBook book) {
        return crudCassandraService.saveBook(book).getId();
    }

    @PutMapping("/author/create")
    @Override
    public String saveAuthor(@RequestBody CAuthor author) {
        return crudCassandraService.saveAuthor(author).getId();
    }

    @DeleteMapping("/book/delete")
    @Override
    public String deleteBook(@RequestParam(name = "id") String id) {
        return crudCassandraService.deleteBook(id);
    }

    @DeleteMapping("/author/delete")
    @Override
    public String deleteAuthor(@RequestParam(name = "id") String id) {
        return crudCassandraService.deleteAuthor(id);
    }

    @GetMapping("/book/find")
    public CBook findBook(@RequestParam(name = "id") String id) {
        return crudCassandraService.getBook(id);
    }

    @GetMapping("/author/find")
    @Override
    public CAuthor findAuthor(@RequestParam(name = "id") String id) {
        return crudCassandraService.getAuthor(id);
    }

    @GetMapping("/book/getByAuthor")
    public List<CBook> getBooksByAuthor(@RequestParam(name = "id") String id) {
        return crudCassandraService.getBooksByAuthor(id);
    }

    @Override
    @GetMapping("/book/all")
    public List<CBook> findAllBooks() {
        return crudCassandraService.findAllBooks();
    }

    @Override
    @GetMapping("/author/all")
    public List<CAuthor> findAllUsers() {
        return crudCassandraService.findAllAuthors();
    }
}
