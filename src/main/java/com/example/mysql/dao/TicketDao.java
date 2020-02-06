package com.example.mysql.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mysql.model.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Integer> {

}