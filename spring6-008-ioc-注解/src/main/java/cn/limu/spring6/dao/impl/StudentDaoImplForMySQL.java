package cn.limu.spring6.dao.impl;

import cn.limu.spring6.dao.StudentDao;
import org.springframework.stereotype.Repository;

@Repository("studentDao")
public class StudentDaoImplForMySQL implements StudentDao {

    @Override
    public void deleteById() {
        System.out.println("mysql数据库正在删除学生信息...");
    }
}
