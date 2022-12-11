package tn.esprit.firstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.firstproject.entities.Notification;

public interface INotificationRepository extends JpaRepository<Notification, Integer> {


}

