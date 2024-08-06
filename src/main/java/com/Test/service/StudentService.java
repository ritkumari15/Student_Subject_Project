package com.Test.service;

import com.Test.entity.Student;
import com.Test.entity.Subject;
import com.Test.repository.StudentRepository;
import com.Test.repository.SubjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;
    
 

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id).orElseThrow();
        student.setName(studentDetails.getName());
        student.setAddress(studentDetails.getAddress());
        student.setEmail(studentDetails.getEmail());
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    

	public Student assignSubjectToStudent(Long studentId, Long subjectId) {
		Set<Subject> subjects=null;
		Student student=studentRepository.findById(studentId).get();
		Subject subject=subjectRepository.findById(subjectId).get();
		subjects=student.getSubjects();
		subjects.add(subject);
		student.setSubjects(subjects);
		return studentRepository.save(student);
		
		
	}

	
}
