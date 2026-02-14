package com.priyanshu.hospitalManagement.service;

import com.priyanshu.hospitalManagement.entity.Appointment;
import com.priyanshu.hospitalManagement.entity.Doctor;
import com.priyanshu.hospitalManagement.entity.Patient;
import com.priyanshu.hospitalManagement.repository.AppointmentRepository;
import com.priyanshu.hospitalManagement.repository.DoctorRepository;
import com.priyanshu.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment,Long doctorId,Long patientId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId() != null) throw new IllegalArgumentException("Appointment should not have been given");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);

         return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId,Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);//this will automatically call the update ,because it is dirty now

        doctor.getAppointments().add(appointment);//just for bidirectional consistency

        return appointment;
    }
}
