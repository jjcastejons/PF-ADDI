package com.itacadam.myapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itacadam.myapp.models.User;



public interface UserRepository extends JpaRepository<User, Long> {
    // QUERY METHODS - Es una caracteristica únicamente de Spring Data JPA
    List<User> findByNombreContaining(String nombre);   // Buscar por nombre que contenga una cadena
    User findByNombre(String nombre);        // Buscar por nombre exacto
    User findByEdad(int edad); // Buscar por edad
    List<User> findByEdadBetween(Integer minEdad, Integer maxEdad); // Buscar por edad entre dos valores
    List<User> findByAdministradorTrue();  // Buscar solo administradores
    List<User> findByAdministrador(Boolean administrador);  // Buscar por administrador (true/false)
    List<User> findByNombreContainingAndEdadBetweenAndAdministrador(String nombre, Integer minEdad, Integer maxEdad, Boolean activo);  // Criterio multiple


}