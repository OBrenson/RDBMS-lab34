package org.example.api;

import org.example.crud.CrudNeo4jService;
import org.example.model.neo4j.NAuthor;
import org.example.model.neo4j.NBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("neo4j")
public class Neo4jController implements ControllerApi<NBook, NAuthor> {

    @Autowired
    private CrudNeo4jService crudNeo4jService;

    @PutMapping("/book/create")
    public String saveBook(@RequestBody NBook book) {
        return crudNeo4jService.saveBook(book).getId();
    }

    @PutMapping("/author/create")
    @Override
    public String saveAuthor(@RequestBody NAuthor author) {
        return crudNeo4jService.saveAuthor(author).toString();
    }

    @DeleteMapping("/book/delete")
    @Override
    public String deleteBook(@RequestParam(name = "id") String id) {
        return crudNeo4jService.deleteBook(id);
    }

    @DeleteMapping("/author/delete")
    @Override
    public String deleteAuthor(@RequestParam(name = "id") String id) {
        return crudNeo4jService.deleteAuthor(id);
    }

    @GetMapping("/book/find")
    @Override
    public NBook findBook(@RequestParam(name = "id") String id) {
        return crudNeo4jService.getBook(id);
    }

    @GetMapping("/author/find")
    @Override
    public NAuthor findAuthor(@RequestParam(name = "id") String id) {
        return crudNeo4jService.getAuthor(id);
    }

    @GetMapping("/book/getByAuthor")
    @Override
    public List<NBook> getBooksByAuthor(@RequestParam(name = "id") String id) {
        return crudNeo4jService.getBooksByAuthor(id);
    }
}
