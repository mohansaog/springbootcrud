package com.example.mysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysql.dao.TicketDao;
import com.example.mysql.model.Ticket;

@RestController
@CrossOrigin
@RequestMapping(value = "/ticket")
public class TicketController {
	@Autowired
	private TicketDao dao;

	@PostMapping("/bookTickets")
	//(path="/bookTickets", consumes="application/json",produces="application/json")
	public String bookTicket(@RequestBody Ticket ticket1) {
		dao.save(ticket1);
		return "ticket booked";
	}

	@GetMapping("/getTickets")
	public List<Ticket> getTickets() {
		return (List<Ticket>) dao.findAll();
	}
}
