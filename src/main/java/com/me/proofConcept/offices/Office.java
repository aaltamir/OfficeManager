package com.me.proofConcept.offices;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "OFFICE")
public class Office {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer officeId;
	
	@Column(name = "openfrom")
	String openFrom;
	@Column(name = "openUntil")
	String openUntil;
	
	/**
	 * Time difference in hours from UTC
	 */
	@Column(name = "timeDifference")
	Integer timeDifference;
	@Column(name = "location")
	String location;
	
	public Integer getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Integer officeId) {
		this.officeId = officeId;
	}
	
	public String getOpenFrom() {
		return openFrom;
	}

	public void setOpenFrom(String openFrom) {
		this.openFrom = openFrom;
	}

	public String getOpenUntil() {
		return openUntil;
	}

	public void setOpenUntil(String openUntil) {
		this.openUntil = openUntil;
	}

	public int getTimeDifference() {
		return timeDifference;
	}

	public void setTimeDifference(int timeDifference) {
		this.timeDifference = timeDifference;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result
				+ ((officeId == null) ? 0 : officeId.hashCode());
		result = prime * result
				+ ((openFrom == null) ? 0 : openFrom.hashCode());
		result = prime * result
				+ ((openUntil == null) ? 0 : openUntil.hashCode());
		result = prime * result
				+ ((timeDifference == null) ? 0 : timeDifference.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Office other = (Office) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (officeId == null) {
			if (other.officeId != null)
				return false;
		} else if (!officeId.equals(other.officeId))
			return false;
		if (openFrom == null) {
			if (other.openFrom != null)
				return false;
		} else if (!openFrom.equals(other.openFrom))
			return false;
		if (openUntil == null) {
			if (other.openUntil != null)
				return false;
		} else if (!openUntil.equals(other.openUntil))
			return false;
		if (timeDifference == null) {
			if (other.timeDifference != null)
				return false;
		} else if (!timeDifference.equals(other.timeDifference))
			return false;
		return true;
	}

}
