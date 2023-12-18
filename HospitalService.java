package com.marolix.service;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.marolix.dto.HospitalDTO;
import com.marolix.entity.Hospital;
import com.marolix.exceptions.HospitalException;

public interface HospitalService {

    String addHospital(HospitalDTO dto) throws HospitalException;

    HospitalDTO viewHospitalDetails(Integer hospitalId) throws HospitalException;

    ResponseEntity<String> updateHospitalInfo(Integer hospitalId, String updatedInfo) throws HospitalException;

    List<Hospital> findAllHospitals() throws HospitalException;

    String deleteHospital(Integer hospitalId) throws HospitalException;

    ResponseEntity<String> admitPatient(Integer hospitalId, String patientName) throws HospitalException;

    ResponseEntity<String> dischargePatient(Integer hospitalId, String patientName) throws HospitalException;

    List<String> getAdmittedPatients(Integer hospitalId) throws HospitalException;

}
