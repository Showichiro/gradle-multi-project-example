package gradle.multi.project.example.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gradle.multi.project.example.repository.Todo;
import gradle.multi.project.example.service.TodoService;
import jakarta.validation.Valid;

@RestController
@Validated
public class TodoController {
    @Autowired
    private TodoService service;

    @GetMapping("/todo")
    public List<Todo> getAll() {
        return service.getAll();
    }

    @GetMapping("/todo/{id}")
    public Optional<Todo> getById(@Valid @PathVariable long id) {
        return service.findById(id);
    }

    @PostMapping("/todo")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Todo createTodo(@Valid @RequestBody Todo todo) {
        return service.createTodo(todo);
    }

    @DeleteMapping("/todo/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteTodo(@Valid @PathVariable long id) {
        service.deleteTodo(id);
    }
}
