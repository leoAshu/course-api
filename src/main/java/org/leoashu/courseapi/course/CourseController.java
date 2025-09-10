package org.leoashu.courseapi.course;

import org.leoashu.courseapi.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id) {
        return courseService.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String topicId, @PathVariable String id) {
        return courseService.getCourse(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
    public void addCourse(@PathVariable String topicId, @RequestBody Course course) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
    public void updateTopic(@PathVariable String topicId, @PathVariable String id, @RequestBody Course course) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(id, course);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
    public void deleteTopic(@PathVariable String id) {
        courseService.deleteCourse(id);
    }

}
