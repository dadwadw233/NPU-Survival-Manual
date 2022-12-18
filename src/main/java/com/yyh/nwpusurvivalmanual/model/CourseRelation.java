package com.yyh.nwpusurvivalmanual.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRelation {
    private String first;

    private String second;

    private int value;
}
