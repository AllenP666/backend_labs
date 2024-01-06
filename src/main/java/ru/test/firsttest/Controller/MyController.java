package ru.test.firsttest.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.test.firsttest.DTO.ContentDTO;
import ru.test.firsttest.DTO.StatusDTO;
import ru.test.firsttest.model.Task;
import ru.test.firsttest.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/testapi")
@AllArgsConstructor

public class MyController {

    private final TaskService service;

    @GetMapping
    public List<Task> findAllTasks()
    {
        return service.findAllTasks();
    }

    @PostMapping("save")
    public Task saveTask(@RequestBody Task task){
        return service.saveTask(task);
    }

    @PutMapping("update_task")
    public ContentDTO updateContent(@RequestBody ContentDTO contentDTO){
        return service.updateTask(contentDTO);
    }

    @PutMapping("update_status")
    public StatusDTO updateStatus(@RequestBody StatusDTO statusDTO){
        return service.updateStatus(statusDTO);
    }

    @DeleteMapping("delete_task/{id}")
    public void deleteTask(@PathVariable Long id){
        service.deleteTask(id);
    }
}
