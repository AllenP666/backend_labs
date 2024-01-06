package ru.test.firsttest.service;

import jakarta.persistence.Id;
import ru.test.firsttest.DTO.ContentDTO;
import ru.test.firsttest.DTO.IdDTO;
import ru.test.firsttest.DTO.StatusDTO;
import ru.test.firsttest.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAllTasks();
    Task saveTask(Task task);
    ContentDTO updateTask(ContentDTO contentDTO);
    StatusDTO updateStatus(StatusDTO statusDTO);
    void deleteTask(Long id);
}
