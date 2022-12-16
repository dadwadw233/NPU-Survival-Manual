package com.yyh.nwpusurvivalmanual.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private String cno;

    private String cname;

    private String tname;

    private String dname;

    private String cclf;

    private int credit;

    private String csche;

    private String exam;

    private int length;

    private int slimit;

    private String campus;

    private String description;
}
