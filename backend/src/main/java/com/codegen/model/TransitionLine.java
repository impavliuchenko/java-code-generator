package com.codegen.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TransitionLine {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Block blockOut;

    @ManyToOne
    private Block blockIn;
}
