package com.atguigu.bean;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class Department implements Serializable {
    private Integer id;
    @NotEmpty(message = "机构名不允许为空")
    private String departmentName;
}
