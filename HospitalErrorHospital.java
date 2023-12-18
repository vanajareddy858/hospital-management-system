package com.marolix.exceptions;
import java.time.LocalDateTime;
public class HospitalErrorHospital {

	
		 private String errorMessage;
		    private Integer statusCode;
		    private LocalDateTime occurredAt;

		    public String getErrorMessage() {
		        return errorMessage;
		    }

		    public void setErrorMessage(String errorMessage) {
		        this.errorMessage = errorMessage;
		    }

		    public Integer getStatusCode() {
		        return statusCode;
		    }

		    public void setStatusCode(Integer statusCode) {
		        this.statusCode = statusCode;
		    }

		    public LocalDateTime getOccurredAt() {
		        return occurredAt;
		    }

		    public void setOccurredAt(LocalDateTime occurredAt) {
		        this.occurredAt = occurredAt;
		    }

		    @Override
		    public String toString() {
		        return "HospitalErrorInformation [errorMessage=" + errorMessage +
		               ", statusCode=" + statusCode + ", occurredAt=" + occurredAt + "]";
	}

}
