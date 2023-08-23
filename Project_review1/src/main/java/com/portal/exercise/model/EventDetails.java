package com.portal.exercise.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="eventdetails")
public class EventDetails {
    

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="eventid")
	private int eventId;
	
    @Column(name="organizerid")
	private int organizerId;
    
    @Column(name ="eventname")
	private String eventName;
    
    @Column(name="description")
	private String eventDescription;
    
    @Column(name="status")
    private String eventStatus;
    
    @Column(name="Date")
	private LocalDateTime eventDate;
    
    @Column(name="location")
	private String eventLocation;
    
    @Column(name="category")
	private String eventCategory;
    
    @Column(name="price")
	private long eventPrice;
    
    @Column(name="capacity")
    private int eventCapacity;

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getOrganizerId() {
		return organizerId;
	}

	public void setOrganizerId(int organizerId) {
		this.organizerId = organizerId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}

	public LocalDateTime getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDateTime eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getEventCategory() {
		return eventCategory;
	}

	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}

	public long getEventPrice() {
		return eventPrice;
	}

	public void setEventPrice(long eventPrice) {
		this.eventPrice = eventPrice;
	}

	public int getEventCapacity() {
		return eventCapacity;
	}

	public void setEventCapacity(int eventCapacity) {
		this.eventCapacity = eventCapacity;
	}
    
	
}
