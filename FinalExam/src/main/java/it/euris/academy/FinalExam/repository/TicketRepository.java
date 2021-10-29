package it.euris.academy.FinalExam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.FinalExam.data.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

  //Boolean applyDiscount();
  
  //Double calculateChildrenDiscount();
}
