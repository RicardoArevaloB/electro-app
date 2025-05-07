package com.electroapp.electro_app.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "proveedor")
@Entity
public class Proveedor {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String diasplazo;

    @Column(length = 50, nullable = false)
    private String porcentajeprontopago;

    @OneToOne
    @JoinColumn(name = "Terceros_Id")
    @JsonBackReference
    Terceros TercerosId;

    @OneToOne
    @JoinColumn(name = "Tipo_documento_Id")
    @JsonBackReference
    TypeDocument TipoDocumentoId;


}
