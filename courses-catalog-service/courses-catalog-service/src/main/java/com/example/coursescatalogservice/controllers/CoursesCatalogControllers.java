package com.example.coursescatalogservice.controllers;

import com.example.coursescatalogservice.models.CoursesCatalog;
import com.example.coursescatalogservice.repositories.CoursesCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
public class CoursesCatalogControllers {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CoursesCatalogRepository coursesCatalogRepository;

    @GetMapping("/get-courses")
    public Iterable<CoursesCatalog> getCoursesCatalogs(Model model){
        Iterable<CoursesCatalog> courses = coursesCatalogRepository.findAll();
        model.addAttribute("courses", courses);
        return courses;
    }

//    @RequestMapping("/{userId}")
//    public List<CoursesCatalog> getCourses(@PathVariable String userId){
//        CoursesCatalog course = restTemplate.getForObject("http://8081/courses", CoursesCatalog.class);
//            return new CoursesCatalog(course.getName(), "Desc", rating.getRating());
//        })
//                .collect(Collectors.toList());
//    }

    @PostMapping("/add-course")
    public String personAdd(@RequestParam String name, @RequestParam String description, @RequestParam Integer limit, @RequestParam String professor, Model model) {
        CoursesCatalog newCourse = new CoursesCatalog(name, description, limit, professor);
        coursesCatalogRepository.save(newCourse);
        return "successfully added";
    }

//    @RequestMapping("/{courseId}")
//    public String getMovieDesc(@PathVariable("courseId") Long id){
//        return CoursesCatalog;
//    }

}
