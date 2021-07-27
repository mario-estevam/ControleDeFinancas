package com.example.controledefinancas.controledefinancas.model;


import java.time.LocalDate;
        import java.util.Date;

        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;
        import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.GenerationType;
        import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Financa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    double amount;
    String category;
    String Data;




}