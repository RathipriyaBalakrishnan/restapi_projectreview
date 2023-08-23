package com.portal.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.exercise.model.EventDetails;

public interface EventRepo extends JpaRepository<EventDetails, Integer> {

}
