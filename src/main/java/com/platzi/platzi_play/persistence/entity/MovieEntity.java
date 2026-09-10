package com.platzi.platzi_play.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity 
@Table(name = "platzi_play_peliculas")
@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Builder 
@ToString 
public class MovieEntity {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150, unique = true)
    private String titulo;
    @Column(nullable = false, precision = 3)
    private Integer duracion;
    @Column(nullable = false, length = 20)
    private String genero;
    @Column(nullable = true, name = "fecha_estreno")
    private LocalDate fechaEstreno;
    @Column(nullable = true, precision = 3, scale = 2)
    private BigDecimal calificacion;
    @Column(nullable = false, length = 1)
    private String estado;
    
}
