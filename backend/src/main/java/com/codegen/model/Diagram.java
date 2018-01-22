package com.codegen.model;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Diagram {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;

    @ManyToOne
    private User user;

    @ManyToOne
    private DiagramType diagramType;

    @OneToOne(mappedBy = "diagram")
    private Code code;

    @OneToMany(mappedBy = "diagram", fetch = FetchType.LAZY)
    private Set<Block> blocks;
}
