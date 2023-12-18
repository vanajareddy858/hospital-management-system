package com.marolix.controller;



import com.marolix.dto.HospitalDTO;
import com.marolix.entity.Hospital;
import com.marolix.exceptions.HospitalException;
import com.marolix.service.HospitalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/hospital")
@Validated
public class HospitalController {
	 @Autowired
	    private HospitalService hospitalService;

	    @PostMapping("/add-hospital")
	    public ResponseEntity<String> addPatientDetails( @RequestBody HospitalDTO dto) throws HospitalException {
	        String result = hospitalService.addHospital(dto);
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    }

	    @GetMapping("/get-hospital")
	    public ResponseEntity<HospitalDTO> viewHospital(@RequestParam("hospitalId") Integer hospitalId) throws HospitalException {
	        HospitalDTO patientDTO = hospitalService.viewHospitalDetails(hospitalId);
	        return new ResponseEntity<HospitalDTO>(patientDTO, HttpStatus.OK);
	    }

	    @PutMapping("/update-details")
	    public ResponseEntity<String> updateInfo(@RequestParam(value="hospitalId") Integer hospitalId, @RequestParam(value="description")String description) throws HospitalException {
	        return hospitalService.updateHospitalInfo(hospitalId, description);
	    }



	    @DeleteMapping("/delete-hospital")
	    public ResponseEntity<String> deletehospitalDetails(@RequestParam(value = "hospitalId") Integer HospitalId) throws HospitalException {
	        String deleteMessage = hospitalService.deleteHospital(HospitalId);
	        return new ResponseEntity<>(deleteMessage, HttpStatus.OK);
	    }

@GetMapping(value = "/get-hospitals")
public List<Hospital> findAllHospitals() throws HospitalException {
	List<Hospital> details = hospitalService.findAllHospitals();
	return details;

}
}
