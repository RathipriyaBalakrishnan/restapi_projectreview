package com.portal.exercise.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.exercise.model.EventDetails;
import com.portal.exercise.repository.EventRepo;

@Service
public class EventService {
	

	@Autowired
	public EventRepo erepo;
	
	//post the data
	public String saveEvent(EventDetails e)
	{
		erepo.save(e);
		return "Data is saved to the database";
	}
	
	//get the data
	public List<EventDetails> getEvent()
	{
		return erepo.findAll();
	}
	
	
	//getUserById
	public Optional<EventDetails> getEventId(int userId)
	{
		Optional<EventDetails> event = erepo.findById(userId);
		if(event.isPresent()) {
			return event;
		}
		return null;
	}
	
	//update the data(put)
	public EventDetails updateEvent(EventDetails em)
	{
		return erepo.saveAndFlush(em);
	}
	
	//update the data if id present
	public boolean updateEventif(int eventId,EventDetails em)
	{
		if(erepo.existsById(eventId)) {
			erepo.save(em);
			return true;
		}
		return false;
	}
	
	//delete if id is present
	public boolean deleteEventif(int eventId) 
	{
		if(erepo.existsById(eventId)) {
			erepo.deleteById(eventId);
			return true;
		}
		return false;
	}
	
	
	//delete the data
	public void deleteEvent(int event_id)
	{
		System.out.println("Deleted");
		erepo.deleteById(event_id);
	}
	
	

}
