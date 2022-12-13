package com.example.demo.Repository;

import com.example.demo.Entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface INotificationRepo extends JpaRepository<Notification, Integer> {
}
