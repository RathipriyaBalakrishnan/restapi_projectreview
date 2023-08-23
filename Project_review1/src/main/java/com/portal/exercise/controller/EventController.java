package com.portal.exercise.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portal.exercise.model.EventDetails;
import com.portal.exercise.service.EventService;

@RestController
public class EventController {
	
	
	@Autowired
	public EventService eserv;
	
	//post
	@PostMapping("/postEvent")
	public String postEvent(@RequestBody EventDetails er)
	{
		eserv.saveEvent(er);
		return "Date saved";
	}
	
	//get mapping
	@GetMapping("/getEvent")
	public List<EventDetails> getEventInfo()
	{
		return eserv.getEvent();
	}
	
	//getUserById
	@GetMapping("/users/{userId}")
	public ResponseEntity<?> getEventById(@PathVariable int userId)
	{
		Optional <EventDetails> event = eserv.getEventId(userId);
		if(event!= null)
		{
			return ResponseEntity.ok(event);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not available with Id");
		}
	}
	
	//put mapping
	@PutMapping("/updateEvent")
	public EventDetails updateEventInfo(@RequestBody EventDetails ea)
	{
		return eserv.updateEvent(ea);
	}
	
	//put mapping using path and request param
	@PutMapping("/updateEventif/{id}")
	public ResponseEntity<String> updateEventinfor(@PathVariable int id, @RequestBody EventDetails ea)
	{
		boolean updated = eserv.updateEventif(id, ea);
		if(updated)
		{
			return ResponseEntity.ok("Event with ID "+id+" is updated successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event with ID "+id+" not found");
		}
	}
	
	//delete mapping
	@DeleteMapping("/deleteEvent/{id}")
	public String removeEvent(@PathVariable("id") int eid)
	{
		eserv.deleteEvent(eid);
		return "Hotel with Id "+eid+" is deleted";
	}
	
	
	//delete mapping using request param
	@DeleteMapping("/byReqParm")
	public String removeByRequestPam(@RequestParam("id") int id)
	{
		eserv.deleteEvent(id);
		return "Event with Id "+id+" is deleted";
	}
	
	
	@DeleteMapping("/deleteEventif/{id}")
	public ResponseEntity<String> deleteEventInfo(@PathVariable int id)
	{
		boolean deleted=eserv.deleteEventif(id);
		if(deleted)
		{
			return ResponseEntity.ok("Event with ID "+id+" deleted");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event with ID "+id+" not found");
		}
	}
	

}
