package ru.test.firsttest.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.test.firsttest.model.Task;

import java.util.List;


@Service
@AllArgsConstructor
public class InMemoryTaskDAO {
    private final TaskRepository taskRepository;

    public List<Task> findAllTasks() {
        return (List<Task>) taskRepository;
    }

    public Task saveTask(Task task) {
        taskRepository.save(task);
        return task;
    }

    public Task updateTask(Task task) {
        Task task_ = taskRepository.findById(task.getId()).orElseThrow(()->
                new IllegalStateException("Task: " + task.getTitle() + " does not exists"));

        taskRepository.save(task_);
        return task_;
    }

    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(()->
                new IllegalStateException("Task with id: " + id + " does not exists"));

        if (task != null){
            taskRepository.delete(task);
        }
    }
}
