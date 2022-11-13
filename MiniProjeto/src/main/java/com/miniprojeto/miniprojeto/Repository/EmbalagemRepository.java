package com.miniprojeto.miniprojeto.Repository;

import com.miniprojeto.miniprojeto.Model.EmbalagemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmbalagemRepository extends JpaRepository<EmbalagemModel, Long> {
}
