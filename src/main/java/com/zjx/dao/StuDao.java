package com.zjx.dao;

import com.zjx.po.Student;

import java.util.List;

/**
 * @author zjx
 * @create 2019-11-21-${TIMR}
 */
public interface StuDao {
    List<Student> selectAll();
}
