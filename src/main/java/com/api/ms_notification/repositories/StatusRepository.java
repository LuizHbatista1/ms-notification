package com.api.ms_notification.repositories;

import com.api.ms_notification.domain.status.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
