INSERT INTO patient(name,gender,birth_date,email,blood_group)
VALUES
('Aarav Sharma','Male','1990-05-10','aarav@gmail.com','O_POSITIVE'),
('Diya Patel','Female','1990-08-20','diya@gmail.com','A_POSITIVE'),
('Dishat Tiwari','Male','1988-03-15','dishat@gmail.com','A_POSITIVE'),
('Neha Iyer','Female','1992-12-10','neha@gmail.com','AB_POSITIVE'),
('Kabir Singh','Male','1993-07-11','kabir@gmail.com','O_POSITIVE');

INSERT INTO doctor (name,specialization,email)
VALUES
('Dr. Rakesh Mehta','Cardiology','rakesh.mehta@gmail.com'),
('Dr. Sneha Kapoor','Dermatology','sneha@gmail.com'),
('Dr. Arjun Nair','Orthopedics','arjun@gmail.com');

INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id)
VALUES
('2025-07-01 10:30:00', 'General Checkup', 1, 2),
('2025-07-02 11:00:00', 'Skin Rash', 2, 2),
('2025-07-03 09:45:00', 'Knee Pain', 3, 3),
('2025-07-04 14:00:00', 'Follow-up Visit', 1, 1),
('2025-07-05 16:15:00', 'Consultation', 1, 4),
('2025-07-06 08:30:00', 'Allergy Treatment', 2, 5);