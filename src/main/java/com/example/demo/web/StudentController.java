package com.example.demo.web;


import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping({"/"})
    public String homeShort() {

        return "home";
    }

    @GetMapping({"/student"})
    public String enterStudent(Model model) {
        model.addAttribute("studentForm", new Student());
        return "registration";
    }

    @PostMapping({"/addStudent"})
    public String addStudent(Student student) {
        studentService.save(student);
        return "home";
    }
}
