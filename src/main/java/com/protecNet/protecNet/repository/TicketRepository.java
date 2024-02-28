package com.protecNet.protecNet.repository;
import com.protecNet.protecNet.entities.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket, String> {
}
