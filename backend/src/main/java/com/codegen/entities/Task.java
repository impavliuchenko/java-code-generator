package com.codegen.entities;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    private String content;

    @ManyToOne
    private Block block;

    @ManyToOne
    private TaskType taskType;
}
