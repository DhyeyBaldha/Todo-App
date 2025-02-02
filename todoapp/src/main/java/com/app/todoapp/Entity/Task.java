package com.app.todoapp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Todo-Tasks")
public class Task {
    private Long id;
    private String title;
    private Boolean completed;
}
