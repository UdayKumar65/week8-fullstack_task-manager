package controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.entity.Task;
import service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

 private final TaskService service;

 public TaskController(TaskService service){
  this.service = service;
 }

 @GetMapping
 public List<Task> getAll(){
  return service.getTasks();
 }

 @PostMapping
 public Task create(@RequestBody Task task){
  return service.save(task);
 }

 @DeleteMapping("/{id}")
 public void delete(@PathVariable Long id){
  service.delete(id);
 }

}