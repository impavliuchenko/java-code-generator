package com.codegen.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Code {
    @Id
    @GeneratedValue
    private Long id;
    private String content;

    @OneToOne
    Diagram diagram;
}
