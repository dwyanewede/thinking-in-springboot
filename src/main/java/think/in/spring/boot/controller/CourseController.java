package think.in.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import think.in.spring.boot.mapper.CourseMapper;
import think.in.spring.boot.model.Course;

import java.util.Collection;

/**
 * @ClassName: CourseController
 * @Description: Course数据测试
 * @Author: 尚先生
 * @CreateDate: 2019/5/22 17:29
 * @Version: 1.0
 */
@RestController
public class CourseController {

    @Autowired
    private CourseMapper courseMapper;


    @GetMapping("/find-all-courses")
    @Transactional
    public Collection<Course> findAllCourses(){

        Collection<Course> courses1 = courseMapper.findAllCourses();

        for (Course course : courses1){
            course.setCurrentThreadName(Thread.currentThread().getName());
        }


        Collection<Course> courses2 = courseMapper.findAllCourses();

        courses1.addAll(courses2);
        return courses1;
    }

}
