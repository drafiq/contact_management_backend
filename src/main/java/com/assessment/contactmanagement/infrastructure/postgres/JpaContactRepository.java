package com.assessment.contactmanagement.infrastructure.postgres;

import com.assessment.contactmanagement.domain.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaContactRepository extends JpaRepository<Contact, String> {
}
