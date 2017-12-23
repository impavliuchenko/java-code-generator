package com.codegen.model;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DiagramType {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "diagramType", fetch = FetchType.LAZY)
    private Set<Diagram> diagrams;
}
