package gradle.multi.project.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gradle.multi.project.example.repository.Todo;
import gradle.multi.project.example.repository.TodoRepository;

@Service
public class TodoService {
    @Autowired
    private TodoRepository repository;

    public List<Todo> getAll() {
        return repository.findAll();
    }

    public Optional<Todo> findById(long id) {
        return repository.findById(id);
    }

    public Todo createTodo(Todo entity) {
        return repository.save(entity);
    }

    public void deleteTodo(long id) {
        repository.deleteById(id);
    }
}
