package com.Test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Test.entity.Student;
import com.Test.entity.Subject;
import com.Test.repository.StudentRepository;
import com.Test.repository.SubjectRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    
    @Autowired
    private StudentRepository studentRepository;
    
    public Student addSubjectsToStudent(Long studentId, List<Long> subjectIds) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (!optionalStudent.isPresent()) {
            throw new RuntimeException("Student not found with id: " + studentId);
        }

        Student student = optionalStudent.get();
        for (Long subjectId : subjectIds) {
            Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
            if (!optionalSubject.isPresent()) {
                throw new RuntimeException("Subject not found with id: " + subjectId);
            }
            Subject subject = optionalSubject.get();
            student.getSubjects().add(subject);
            subject.getStudents().add(student); // Ensure inverse relationship is maintained
        }

        return studentRepository.save(student);
    }


    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Optional<Subject> getSubjectById(Long id) {
        return subjectRepository.findById(id);
    }

    public Subject updateSubject(Long id, Subject subjectDetails) {
        Subject subject = subjectRepository.findById(id).orElseThrow();
        subject.setName(subjectDetails.getName());
        return subjectRepository.save(subject);
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}