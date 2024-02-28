package com.protecNet.protecNet.services;

import com.protecNet.protecNet.entities.Ticket;
import com.protecNet.protecNet.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket saveTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }
}
