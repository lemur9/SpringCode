package cn.limu.spring6.service;

import cn.limu.spring6.dao.StudentDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentService {

//    @Resource(name = "studentDaoImplForMySQL")
    @Resource
    private StudentDao studentDao;

    /*@Resource(name = "studentDaoImplForMySQL")
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }*/

    public void deleteStudent() {
        studentDao.deleteById();
    }
}
