package com.atguigu.mapper;

import com.atguigu.bean.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//使用配置文件配置
@Mapper
public interface EmployeeMapper {
    @Select("select * from employee where id=#{id}")
    public Employee getEmployeeById(Integer id);

    @Insert("insert into employee(last_name,email,gender,d_id}) values(#{lastName},#{email},#{gender},#{dId})")
    public void insertEmployee(Employee employee);
}
