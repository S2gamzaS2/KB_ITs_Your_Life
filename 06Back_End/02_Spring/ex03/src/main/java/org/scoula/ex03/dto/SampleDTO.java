package org.scoula.ex03.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //기본생성자, "Getter/Setter", toString
@AllArgsConstructor
public class SampleDTO {
    private String name;
    private int age;
}
