package com.electroapp.electro_app.domain.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "cliente")
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column(name = "fecha_compra")
    private LocalDate fechaCompra;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @OneToOne
    @JoinColumn(name = "Terceros_Id")
    @JsonBackReference
    Terceros TercerosId;

    @OneToOne
    @JoinColumn(name = "Tipo_documento_Id")
    @JsonBackReference
    TypeDocument TipoDocumentoId;
    
}
