package com.gym.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "membresia", nullable = false)
    private Membresia membresia;

    @Column(nullable = false)
    private LocalDateTime fecha_pago;
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal monto;
    @Column(nullable = false)
    private String metodo;
    @Column(nullable = false)
    private String estado;


}
