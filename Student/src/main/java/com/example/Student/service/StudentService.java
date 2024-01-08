package com.example.Student.service;

import com.example.Student.Repository.StudentRepository;
import com.example.Student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class StudentService {
@Autowired
    private StudentRepository studentRepository;
    // Get all students
    public Iterable<Student> getAll(){
        return studentRepository.findAll();
    }
    // Get a student by ID
    public Optional<Student> getSpecificStudent(@PathVariable("id") final Long id){
        return studentRepository.findById(id);
    }
    //Delete a Student
    public ResponseEntity<String> deleteStudent(@PathVariable("id") final Long id){
        try {
            studentRepository.deleteById(id);
            return ResponseEntity.ok("l'etudiant est supprimé avec succès");
        } catch (Exception e) {
            // Log l'erreur pour le débogage
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Une erreur s'est produite lors de la suppression de l'etudiant.");
        }
        //Add a student
        public Student addNewStudent(Student s) {
            return studentRepository.save(s);
        }
        //update a student
        public ResponseEntity<String> updateStudent( Long id,Student s){
            Optional<Student> existingStudentOptional= studentRepository.findById(id);
            if(existingStudentOptional.isPresent()){
                Student existingStudent = existingStudentOptional.get();
                if (s.getNom!=null) existingStudent.setNom(s.getNom());
                if (s.getPrenom!=null) existingStudent.setPrenom(s.getPrenom());
                if (s.getCne!=null) existingStudent.setCne(s.getCne());
                if (s.getEmail!=null) existingStudent.setEmail(s.getEmail());
            }
        }
    }
}
