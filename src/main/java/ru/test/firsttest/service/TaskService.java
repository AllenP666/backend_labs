package ru.test.firsttest.service;

import ru.test.firsttest.DTO.ContentDTO;
import ru.test.firsttest.DTO.ResponseDTO;
import ru.test.firsttest.DTO.StatusDTO;
import ru.test.firsttest.Exception.DeleteTaskException;
import ru.test.firsttest.Exception.SaveTaskException;
import ru.test.firsttest.Exception.UpdateStatusException;
import ru.test.firsttest.Exception.UpdateTaskException;
import ru.test.firsttest.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAllTasks();
    ResponseDTO saveTask(Task task) throws SaveTaskException;
    ResponseDTO updateTask(ContentDTO contentDTO) throws UpdateTaskException;
    ResponseDTO updateStatus(StatusDTO statusDTO) throws UpdateStatusException;
    void deleteTask(Long id) throws DeleteTaskException;
}
