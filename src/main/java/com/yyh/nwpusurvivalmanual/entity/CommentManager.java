package com.yyh.nwpusurvivalmanual.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentManager {
    private String cno;

    private int cid;

    private String time;

    private String detail;

    private int isselect;

    private float sscore;

    private int visible;
}
