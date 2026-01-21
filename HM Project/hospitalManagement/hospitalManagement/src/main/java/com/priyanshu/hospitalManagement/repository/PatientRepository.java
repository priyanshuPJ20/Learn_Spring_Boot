package com.priyanshu.hospitalManagement.repository;

import com.priyanshu.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.priyanshu.hospitalManagement.entity.Patient;
import com.priyanshu.hospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByName(String name);
    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    @Query("select p from Patient p where p.bloodGroup=?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup")BloodGroupType bloodGroup);

    @Query("select new com.priyanshu.hospitalManagement.dto.BloodGroupCountResponseEntity(p.bloodGroup ,"+
            "Count(p)) from Patient p group by p.bloodGroup")

        // List<Object[]> countEachBloodGroupType();

    List<BloodGroupCountResponseEntity> countEachBloodGroupType();

    @Query(value = "select * from patient" , nativeQuery = true)
    List<Patient> findAllPatients();

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name where p.id = :id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);
}
