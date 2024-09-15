package edu.mum.cs.cs425.studentmgmt.Controller;


import edu.mum.cs.cs425.studentmgmt.entity.Student;
import edu.mum.cs.cs425.studentmgmt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/search")
    public String searchStudents(@RequestParam("searchTerm") String searchTerm, Model model) {
        List<Student> students = studentService.searchStudents(searchTerm);
        model.addAttribute("students", students);
        return "student/list";
    }

    @GetMapping("/list")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student/list";
    }

    @GetMapping("/new")
    public String showNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/new";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students/list";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student/edit";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students/list";
    }
}
