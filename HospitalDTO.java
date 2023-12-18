package com.marolix.dto;
import jakarta.persistence.Lob;

public class HospitalDTO {
	
	 private Integer hospitalId;

	    //@Column(unique = true)
	    private String hospitalName;

	    @Lob
	    private String description;

	    private String location;

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

		public HospitalDTO(Integer hospitalId, String hospitalName, String description, String location) {
			super();
			this.hospitalId = hospitalId;
			this.hospitalName = hospitalName;
			this.description = description;
			this.location = location;
		}

		public HospitalDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "HospitalDTO [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", description="
					+ description + ", location=" + location + "]";
		}
	    
}