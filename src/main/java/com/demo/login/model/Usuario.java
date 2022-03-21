package com.demo.login.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author JSBM
 */
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    @Column(name = "nombre_usuario", nullable = false, length = 45)
    private String nombre;
    @NonNull
    @Column(name = "correo_usuario", nullable = false, length = 50)
    private String correo;
    @NonNull
    //como la contraseña es encriptada entonces tiene que tener un length de >= 60
    @Column(name = "password_usuario", nullable = false, length = 65)
    private String password;
}
