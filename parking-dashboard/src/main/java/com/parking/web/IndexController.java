package com.parking.web;

import com.parking.dao.test.StudentDao;
import com.parking.entity.test.Student;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by BaoCai on 17/10/18.
 * Description:
 */
@Controller
public class IndexController {

    @Autowired
    private StudentDao studentDao;

    @RequestMapping("/index")
    public String index(ModelMap map){

        studentDao.save();
        List<Student> studnets = studentDao.listStudnet();
        map.put("name",studnets.get(0).getName());
        return "index";
    }

}
