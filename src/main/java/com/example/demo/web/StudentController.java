package com.example.demo.web;


import com.example.demo.model.Student;
import com.example.demo.model.Subject;
import com.example.demo.model.Teacher;
import com.example.demo.model.TeacherSubjectEnlistedCount;
import com.example.demo.repository.StudentCreditsRepo;
import com.example.demo.repository.TSECountRepo;
import com.example.demo.service.StudentService;
import com.example.demo.service.SubjectService;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private StudentCreditsRepo repo;
    @Autowired
    private TSECountRepo countRepo;


    @GetMapping({"/"})
    public String homeShort() {


        return "home";
    }

    @GetMapping({"/teacher_subject_enlisted_count"})
    public String teacherSubjectEnlistedCount(Model model) {
        model.addAttribute("records", countRepo.findAll());



        return "teacherSubjectEnlistedCount";
    }

    @GetMapping({"/teachers_and_students_list"})
    public String teachersAndStudentsList(Model model) {
        model.addAttribute("studentRecords", studentService.findAllStudentsAndTheirYearInCollege());
        model.addAttribute("teacherRecords", teacherService.getAllTeachersAndSubjectsCount());


        return "teachersAndStudentsList";
    }

    @GetMapping({"/student"})
    public String enterStudent(Model model) {
        model.addAttribute("studentForm", new Student());
        return "studentForm";
    }

    @PostMapping({"/addStudent"})
    public String addStudent(Student student) {
        studentService.save(student);
        return "home";
    }

    @GetMapping({"/teacher"})
    public String enterTeacher(Model model) {
        model.addAttribute("teacherForm", new Teacher());
        return "teacherForm";
    }

    @PostMapping({"/addTeacher"})
    public String addTeacher(Teacher teacher) {
        teacherService.save(teacher);
        return "home";
    }

    @GetMapping({"/subject"})
    public String enterSubject(Model model) {
        model.addAttribute("subjectForm", new Subject());
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "subjectForm";
    }

    @PostMapping({"/addSubject"})
    public String addSubject(Subject subject) {
        subjectService.save(subject);
        return "home";
    }


}
