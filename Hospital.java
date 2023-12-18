package com.marolix.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
public class Hospital {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer hospitalId;

	    //@Column(unique = true)
	    private String hospitalName;

	    @Lob
	    private String description;

	    private String location;

	    // Additional attributes specific to a hospital

	    public Integer getHospitalId() {
	        return hospitalId;
	    }

	    public void setHospitalId(Integer hospitalId) {
	        this.hospitalId = hospitalId;
	    }

	    public String getHospitalName() {
	        return hospitalName;
	    }
 
	    public void setHospitalName(String hospitalName) {
	        this.hospitalName = hospitalName;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getLocation() {
	        return location;
	    }

	    public void setLocation(String location) {
	        this.location = location;
	    }

	    // Additional getters and setters for other attributes

	    @Override
	    public String toString() {
	        return "Hospital [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName +
	               ", description=" + description + ", location=" + location + "]";
	
	    }

		public Hospital(Integer hospitalId, String hospitalName, String description, String location) {
			super();
			this.hospitalId = hospitalId;
			this.hospitalName = hospitalName;
			this.description = description;
			this.location = location;
		}

		public Hospital() {
			super();
			// TODO Auto-generated constructor stub
		}

}

