package com.codegen.model;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Block {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Diagram diagram;

    @ManyToOne
    private BlockType blockType;

    @OneToMany(mappedBy = "blockOut", fetch = FetchType.LAZY)
    private Set<TransitionLine> transitionOutLines;

    @OneToMany(mappedBy = "blockIn", fetch = FetchType.LAZY)
    private Set<TransitionLine> transitionInLines;

    @OneToMany(mappedBy = "block", fetch = FetchType.LAZY)
    private Set<Task> tasks;
}
