package com.Test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Test.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	Optional<Student> findById(Long id);
}
