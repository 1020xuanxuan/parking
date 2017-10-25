package com.parking.dao.test;

import com.parking.dao.BaseDao;
import com.parking.entity.test.QStudent;
import com.parking.entity.test.Student;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by BaoCai on 17/10/21.
 * Description:
 */
@Repository
public class StudentDao extends BaseDao<Student, QStudent> {
    public StudentDao() {
        this.setQEntity(QStudent.student);
    }

    public List<Student> listStudnet() {
        return this.getEntities(null, null);
    }

    @Transactional(readOnly = false)
    public void save() {
        Student student = new Student();
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        student.setName("大头");
        student.setSex(1);
        this.save(student);
    }

}
