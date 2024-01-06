package ru.test.firsttest.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.test.firsttest.DTO.ContentDTO;
import ru.test.firsttest.DTO.ResponseDTO;
import ru.test.firsttest.DTO.StatusDTO;
import ru.test.firsttest.Exception.DeleteTaskException;
import ru.test.firsttest.Exception.SaveTaskException;
import ru.test.firsttest.Exception.UpdateStatusException;
import ru.test.firsttest.Exception.UpdateTaskException;
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
    public ResponseDTO saveTask(Task task) throws SaveTaskException {

        if (task.getTitle().isEmpty()) {
            throw new SaveTaskException("400", "Task name must be not empty");
        }
        repository.save(task);

        ResponseDTO response = new ResponseDTO();
        response.setData(task);
        response.setStatus("Task saved");
        return response;
    }

    @Override
    public ResponseDTO updateTask(ContentDTO contentDTO) throws UpdateTaskException {
        Task task = repository.findById(contentDTO.getId()).orElseThrow(()->
                new UpdateTaskException("404", "Task: '" + contentDTO.getTitle() + "' does not exists"));

        if (contentDTO.getDescription().isEmpty() || contentDTO.getTitle().isEmpty()) {
            throw new UpdateTaskException("400", "Description or title must be not empty!");
        }

        task.setTitle(contentDTO.getTitle());
        task.setDescription(contentDTO.getDescription());
        repository.save(task);

        ResponseDTO response = new ResponseDTO();
        response.setData(contentDTO);
        response.setStatus("Content was updated");
        return response;
    }

    @Override
    public ResponseDTO updateStatus(StatusDTO statusDTO) throws UpdateStatusException {
        Task task = repository.findById(statusDTO.getId()).orElseThrow(()->
                new UpdateStatusException("404", "Task with id " + statusDTO.getId() + " does not exists"));

        if (statusDTO.getStatus() == null) {
            throw new UpdateStatusException("400", "Status must be not empty!");
        }

        task.setStatus(statusDTO.getStatus());
        repository.save(task);

        ResponseDTO response = new ResponseDTO();
        response.setData(statusDTO);
        response.setStatus("Status was updated");
        return response;
    }

    @Override
    @Transactional
    public void deleteTask(Long id) throws DeleteTaskException {
        Task task = repository.findById(id).orElseThrow(()->
                new DeleteTaskException("404", "Task with id: " + id + " does not exists"));

        if (task != null){
            repository.delete(task);
        }
    }
}
