package com.marolix.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.marolix.dto.HospitalDTO;
import com.marolix.entity.Hospital;
import com.marolix.exceptions.HospitalException;
import com.marolix.repository.HospitalRepository;

@Service(value = "hospitalAdminService")
public class HospitalAdminServiceImpl implements HospitalService{

	
	 @Autowired
	    private HospitalRepository hospitalRepo;

	    @Override
	    public String addHospital(HospitalDTO dto) throws HospitalException {
	        Hospital existingHospital = hospitalRepo.findByHospitalName(dto.getHospitalName());
	        if (existingHospital != null)
	            throw new HospitalException("Hospital already exists with name: " + dto.getHospitalName());

	        Hospital hospital = new Hospital();
	        hospital.setHospitalName(dto.getHospitalName());
	        hospital.setLocation(dto.getLocation());
	        hospital.setDescription(dto.getDescription());
	        // Set other attributes as needed

	        Hospital savedHospital = hospitalRepo.save(hospital);
	        return "Hospital added successfully with ID " + savedHospital.getHospitalId();
	    }

	    @Override
	    public HospitalDTO viewHospitalDetails(Integer hospitalId) throws HospitalException {
	        Optional<Hospital> opt = hospitalRepo.findById(hospitalId);
	        Hospital hospital = opt.orElseThrow(() -> new HospitalException("No hospital found with ID " + hospitalId));
	        HospitalDTO dto = new HospitalDTO();
	        dto.setHospitalId(hospital.getHospitalId());
	        dto.setHospitalName(hospital.getHospitalName());
	        dto.setLocation(hospital.getLocation());
	        // Set other attributes as needed
	        return dto;
	    }

	    @Override
	    public ResponseEntity<String> updateHospitalInfo(Integer hospitalId, String description)
	            throws HospitalException {
	        Optional<Hospital> opt = hospitalRepo.findById(hospitalId);
	        if (opt.isPresent()) {
	            Hospital hospital = opt.get();
	           
	            hospital.setDescription(description);

	            hospitalRepo.save(hospital);
	            return ResponseEntity.ok("Hospital information updated successfully");
	        } else {
	            throw new HospitalException("Hospital not found with ID " + hospitalId);
	        }
	    }

	    @Override
	    public List<Hospital> findAllHospitals() throws HospitalException {
	        Iterable<Hospital> itr = hospitalRepo.findAll();
	        Iterator<Hospital> itr1 = itr.iterator();
	        List<Hospital> list = new ArrayList<>();
	        while (itr1.hasNext()) {
	            list.add(itr1.next());
	        }
	        if (list.isEmpty())
	            throw new HospitalException("No hospitals found to view");
	        return list;
	    }

	    @Override
	    public String deleteHospital(Integer hospitalId) throws HospitalException {
	        Optional<Hospital> opt = hospitalRepo.findById(hospitalId);
	        Hospital hospital = opt.orElseThrow(() -> new HospitalException("No hospital found with ID " + hospitalId));
	        hospitalRepo.deleteById(hospitalId);
	        return "Deleted hospital with ID " + hospitalId;
	    }

	    @Override
	    public ResponseEntity<String> admitPatient(Integer hospitalId, String patientName) throws HospitalException {
	        // Implement logic to admit a patient to the hospital
	        return ResponseEntity.ok("Patient " + patientName + " admitted to hospital with ID " + hospitalId);
	    }

	    @Override
	    public ResponseEntity<String> dischargePatient(Integer hospitalId, String patientName) throws HospitalException {
	        // Implement logic to discharge a patient from the hospital
	        return ResponseEntity.ok("Patient " + patientName + " discharged from hospital with ID " + hospitalId);
	    }

	    @Override
	    public List<String> getAdmittedPatients(Integer hospitalId) throws HospitalException {
	        // Implement logic to retrieve the list of admitted patients in a hospital
	        return new ArrayList<>();
	    }
	}


