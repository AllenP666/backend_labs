package ru.test.firsttest.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.test.firsttest.DTO.ContentDTO;
import ru.test.firsttest.DTO.StatusDTO;
import ru.test.firsttest.model.Task;
import ru.test.firsttest.repository.TaskRepository;
import ru.test.firsttest.service.TaskService;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    @Override
    public List<Task> findAllTasks() {
        return repository.findAll();
    }

    @Override
    public Task saveTask(Task task) {
        return repository.save(task);
    }

    @Override
    public ContentDTO updateTask(ContentDTO contentDTO) {
        Task task = repository.findById(contentDTO.getId()).orElseThrow(()->
                new IllegalStateException("Task: '" + contentDTO.getTitle() + "' does not exists"));

        if (contentDTO.getDescription().isEmpty() || contentDTO.getTitle().isEmpty()) {
            throw new IllegalStateException("Description or title must be not empty!");
        }

        task.setTitle(contentDTO.getTitle());
        task.setDescription(contentDTO.getDescription());
        repository.save(task);
        return contentDTO;
    }

    @Override
    public StatusDTO updateStatus(StatusDTO statusDTO) {
        Task task = repository.findById(statusDTO.getId()).orElseThrow(()->
                new IllegalStateException("Task with id " + statusDTO.getId() + " does not exists"));

        if (statusDTO.getStatus() == null) {
            throw new IllegalStateException("Status must be not empty!");
        }

        task.setStatus(statusDTO.getStatus());
        repository.save(task);
        return statusDTO;
    }

    @Override
    @Transactional
    public void deleteTask(Long id) {
        Task task = repository.findById(id).orElseThrow(()->
                new IllegalStateException("Task with id: " + id + " does not exists"));

        if (task != null){
            repository.delete(task);
        }
    }
}
