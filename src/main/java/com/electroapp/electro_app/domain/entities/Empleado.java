package com.electroapp.electro_app.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "empleado")
@Getter
@Setter
public class Empleado {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_contratacion", nullable = false)
    private java.time.LocalDate fechaContratacion;

    @Column(length = 50, nullable = false)
    private int salarioBase;

    @OneToOne
    @JoinColumn(name = "tercero_id")
    @JsonBackReference
    Terceros terceros;

    @ManyToOne
    @JoinColumn(name = "eps_id")
    @JsonBackReference
    Eps eps;

    @ManyToOne
    @JoinColumn(name = "arl_id")
    @JsonBackReference
    Arl arl;

    @OneToOne
    @JoinColumn(name = "tipo_documento_id")
    @JsonBackReference
    TypeDocument tipoDocumento;




    

}
