package com.brctl.dbunit.entity;

import lombok.Data;

@Data
public class StaticResource {

    private Long staticResourceSeq;
    private String type;
    private String name;
    private String content;

}
