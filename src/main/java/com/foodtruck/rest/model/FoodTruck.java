/**
 * 
 */
package com.foodtruck.rest.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * A entity class for FoodTruck
 * @author winters
 *
 */
@Entity
@Table(name = "food_facility")
public class FoodTruck extends BaseEntity<Long> implements Serializable {

	private static final long serialVersionUID = -7563819768386125083L;

	@Column(name = "location_id")
	private Long locationId;

	@Column(name = "applicant")
	private String applicant;

	@Column(name = "facility_type", columnDefinition="bpchar")
	private String facilityType;

	@Column(name = "cnn")
	private Long cnn;

	@Column(name = "location_description")
	private String locationDescription;

	@Column(name = "address", columnDefinition="bpchar")
	private String address;

	@Column(name = "block_lot", columnDefinition="bpchar")
	private String blockLot;

	@Column(name = "block", columnDefinition="bpchar")
	private String block;

	@Column(name = "lot", columnDefinition="bpchar")
	private String lot;

	@Column(name = "permit", columnDefinition="bpchar")
	private String permit;

	@Column(name = "status", columnDefinition="bpchar")
	private String status;

	@Column(name = "food_items")
	private String food_items;

	@Column(name = "x")
	private Double x;

	@Column(name = "y")
	private Double y;

	@Column(name = "latitude")
	private Double latitude;

	@Column(name = "longitude")
	private Double longitude;

	@Column(name = "schedule")
	private String schedule;

	@Column(name = "noi_sent")
	private Date noiSent;

	@Column(name = "approved")
	private Date approved;

	@Column(name = "received")
	private String received;

	@Column(name = "prior_permit")
	private int priorPermit;

	@Column(name = "expiration_date")
	private Date expirationDate;

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getFacilityType() {
		return facilityType;
	}

	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}

	public Long getCnn() {
		return cnn;
	}

	public void setCnn(Long cnn) {
		this.cnn = cnn;
	}

	public String getLocationDescription() {
		return locationDescription;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBlockLot() {
		return blockLot;
	}

	public void setBlockLot(String blockLot) {
		this.blockLot = blockLot;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public String getPermit() {
		return permit;
	}

	public void setPermit(String permit) {
		this.permit = permit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFood_items() {
		return food_items;
	}

	public void setFood_items(String food_items) {
		this.food_items = food_items;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public Date getNoiSent() {
		return noiSent;
	}

	public void setNoiSent(Date noiSent) {
		this.noiSent = noiSent;
	}

	public Date getApproved() {
		return approved;
	}

	public void setApproved(Date approved) {
		this.approved = approved;
	}

	public String getReceived() {
		return received;
	}

	public void setReceived(String received) {
		this.received = received;
	}

	public int getPriorPermit() {
		return priorPermit;
	}

	public void setPriorPermit(int priorPermit) {
		this.priorPermit = priorPermit;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
	
}
