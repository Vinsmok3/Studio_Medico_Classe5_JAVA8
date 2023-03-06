package it.studiomedico.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table( name = "Patient")

    public class Patient {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "idPatient")
        private long idPatient;

        @Column(name="Name", nullable = false)
        private String Name;

        @Column(name="Surname", nullable = false)
        private String Surname;

        @Column(name="Email", nullable = false, unique = true)
        private String Email;

        @Column(name="PhoneNumber", nullable = false)
        private String PhoneNumber;

        @Column(name="Fiscal_Code", nullable = false)
        private String Fiscal_Code;

        @Column(name="Gender", nullable = false)
        private GenderENUM Gender;


        public long getIdPatient() {
            return idPatient;
        }

        public void setIdPatient(long idPatient) {
            this.idPatient = idPatient;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getSurname() {
            return Surname;
        }

        public void setSurname(String surname) {
            Surname = surname;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String email) {
            Email = email;
        }

        public String getPhoneNumber() {
            return PhoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            PhoneNumber = phoneNumber;
        }

        public String getFiscal_Code() {
            return Fiscal_Code;
        }

        public void setFiscal_Code(String fiscal_Code) {
            Fiscal_Code = fiscal_Code;
        }

        public GenderENUM getGender() {
            return Gender;
        }

        public void setGender(GenderENUM gender) {
            Gender = gender;
        }


        public Patient() {
        }

        public Patient(String name, String surname, String email, String phoneNumber, String fiscal_Code, GenderENUM gender) {
            Name = name;
            Surname = surname;
            Email = email;
            PhoneNumber = phoneNumber;
            Fiscal_Code = fiscal_Code;
            Gender = gender;
        }

        @ManyToOne
        @JoinColumn(name = "idDoctor")
        private Doctor doctor;

        @OneToMany
        private List<Prenotation> prenotationList;








    }


