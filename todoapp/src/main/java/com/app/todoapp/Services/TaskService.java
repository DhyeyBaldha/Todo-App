package com.app.todoapp.Services;

import com.app.todoapp.Entity.Task;
import com.app.todoapp.Repository.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TaskService {
    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepo.save(task);
    }

    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task ID: " + id));
        task.setCompleted(!task.getCompleted());
        taskRepo.save(task);
    }
}
