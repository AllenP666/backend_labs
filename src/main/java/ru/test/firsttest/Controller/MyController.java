package ru.test.firsttest.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.test.firsttest.DTO.ContentDTO;
import ru.test.firsttest.DTO.ResponseDTO;
import ru.test.firsttest.DTO.StatusDTO;
import ru.test.firsttest.Exception.*;
import ru.test.firsttest.model.Task;
import ru.test.firsttest.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/testapi")
@AllArgsConstructor
@MyControllerExceptionHandler

public class MyController {

    private final TaskService service;

    @GetMapping
    public List<Task> findAllTasks() throws FindAllTasksException {
        return service.findAllTasks();
    }

    @PostMapping("save")
    public ResponseDTO saveTask(@RequestBody Task task) throws SaveTaskException {
        return service.saveTask(task);
    }

    @PutMapping("update_task")
    public ResponseDTO updateContent(@RequestBody ContentDTO contentDTO) throws UpdateTaskException {
        return service.updateTask(contentDTO);
    }

    @PutMapping("update_status")
    public ResponseDTO updateStatus(@RequestBody StatusDTO statusDTO) throws UpdateStatusException {
        return service.updateStatus(statusDTO);
    }

    @DeleteMapping("delete_task/{id}")
    public ResponseDTO deleteTask(@PathVariable Long id) throws DeleteTaskException {
        return service.deleteTask(id);
    }
}
