package org.example.api;

import org.example.crud.CrudService;
import org.example.model.redis.RAuthor;
import org.example.model.redis.RBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("redis")
public class RedisController implements ControllerApi<RBook, RAuthor> {

    @Autowired
    private CrudService<RBook, RAuthor> crudRedisService;

    @PutMapping("/book/create")
    public String saveBook(@RequestBody RBook book) {
        return crudRedisService.saveBook(book).getId();
    }

    @PutMapping("/author/create")
    @Override
    public String saveAuthor(@RequestBody RAuthor author) {
        return crudRedisService.saveAuthor(author).getId();
    }

    @DeleteMapping("/book/delete")
    @Override
    public String deleteBook(@RequestParam(name = "id") String id) {
        return crudRedisService.deleteBook(id);
    }

    @DeleteMapping("/author/delete")
    @Override
    public String deleteAuthor(@RequestParam(name = "id") String id) {
        return crudRedisService.deleteAuthor(id);
    }

    @GetMapping("/book/find")
    public RBook findBook(@RequestParam(name = "id") String id) {
        return crudRedisService.getBook(id);
    }

    @GetMapping("/author/find")
    @Override
    public RAuthor findAuthor(@RequestParam(name = "id") String id) {
        return crudRedisService.getAuthor(id);
    }

    @GetMapping("/book/getByAuthor")
    public List<RBook> getBooksByAuthor(@RequestParam(name = "id") String id) {
        return crudRedisService.getBooksByAuthor(id);
    }
}
