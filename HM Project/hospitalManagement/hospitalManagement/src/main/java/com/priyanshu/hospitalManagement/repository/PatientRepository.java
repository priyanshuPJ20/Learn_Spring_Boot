package com.priyanshu.hospitalManagement.repository;

import com.priyanshu.hospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
