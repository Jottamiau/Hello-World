package com.atguigu.mapper;

import com.atguigu.bean.Department;
import org.apache.ibatis.annotations.*;

//@Mapper  使用MapperScan扫描指定包下的所有mapper
@Mapper
public interface DepartmentMapper {

    //需要开启驼峰命名映射功能
    @Insert("inset into department(department_name) value(departmentName)")
    public int insertDepartment(Department department);

    @Select("select * from department where id=#{id}")
    public Department getDepartmentById(Integer id);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    public int updateDepartment(Department department);

    @Delete("delete from department where id=#{id}")
    public int deleteDepartmentById(Integer id);
}
