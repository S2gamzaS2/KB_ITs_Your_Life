package org.scoula.ex03.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //기본생성자, "Getter/Setter", toString
@AllArgsConstructor
@NoArgsConstructor
public class SampleDTO {
    private String name;
    private int age;
}
