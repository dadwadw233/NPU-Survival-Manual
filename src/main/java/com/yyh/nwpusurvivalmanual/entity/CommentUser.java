package com.yyh.nwpusurvivalmanual.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentUser {
    private String cno;

    private int cid;

    private String sno;


    private String time;

    private String detail;

    private int visible;
}
