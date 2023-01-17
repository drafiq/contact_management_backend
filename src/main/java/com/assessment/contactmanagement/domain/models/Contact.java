package com.assessment.contactmanagement.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name="contact")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contact {
   @Id
   @Column(name = "email")
    private String email;
    @Column(name = "name")
    private String name;

}
