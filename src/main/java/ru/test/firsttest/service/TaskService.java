package ru.test.firsttest.service;

import ru.test.firsttest.DTO.ContentDTO;
import ru.test.firsttest.DTO.ResponseDTO;
import ru.test.firsttest.DTO.StatusDTO;
import ru.test.firsttest.Exception.*;
import ru.test.firsttest.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAllTasks() throws FindAllTasksException;
    ResponseDTO saveTask(Task task) throws SaveTaskException;
    ResponseDTO updateTask(ContentDTO contentDTO) throws UpdateTaskException;
    ResponseDTO updateStatus(StatusDTO statusDTO) throws UpdateStatusException;
    ResponseDTO deleteTask(Long id) throws DeleteTaskException;
}
