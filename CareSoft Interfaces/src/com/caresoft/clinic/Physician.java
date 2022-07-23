package com.caresoft.clinic;

import java.util.ArrayList;
import java.util.Date;

import com.caresoft.clinicapp.HIPAACompliantUser;

public class Physician extends User implements HIPAACompliantUser {
	
//... imports class definition...
    
    // Inside class:    
    private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
    public Physician(Integer id) {
		super(id);
	}
    // TO DO: Implement HIPAACompliantUser!
	
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}

	public Physician(int id) {
		 super(id);
	}

	public void newPatientNotes(String notes, String patientName, Date date) {
        
		String report = String.format("Datetime Submitted: %s \n", date);
        
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
    // TO DO: Setters & Getters


	@Override
	public boolean assignPin(int pin) {
		String pinStr = Integer.toString(pin);
		if(pinStr.length()==4) {
			this.pin = pin;
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (this.id.equals(confirmedAuthID)) {
            return true;
        }
        else {
            return false;
	}

	}
}
