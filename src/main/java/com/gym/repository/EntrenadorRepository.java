package com.gym.repository;

import com.gym.entity.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenadorRepository  extends JpaRepository<Entrenador, Long> {

}
