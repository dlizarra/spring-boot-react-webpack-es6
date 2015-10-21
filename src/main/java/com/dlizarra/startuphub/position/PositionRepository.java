package com.dlizarra.startuphub.position;

import org.springframework.stereotype.Repository;

import com.dlizarra.startuphub.support.jpa.ReadOnlyRepository;

@Repository
public interface PositionRepository extends ReadOnlyRepository<Position, Integer> {

}
