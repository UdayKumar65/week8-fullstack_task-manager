package service;

import java.util.List;

import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.stereotype.Service;

import model.entity.Task;

@Service
public class TaskService {

 private final CsrfTokenRepository repo;

 public TaskService(CsrfTokenRepository repo){
  this.repo = repo;
 }

 public List<Task> getTasks(){
  return ((Object) repo).findAll();
 }

 public Task save(Task task){
  return ((TaskService) repo).save(task);
 }

 public void delete(Long id){
  ((Object) repo).deleteById(id);
 }

}