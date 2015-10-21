package com.dlizarra.startuphub.position;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlizarra.startuphub.support.orika.OrikaBeanMapper;

/**
 * Service providing {@link Position}-related operations.
 *
 * @author dlizarra
 */
@Service
public class PositionServiceImpl implements PositionService {

	@Autowired
	private PositionRepository positionRepository;
	@Autowired
	private OrikaBeanMapper mapper;

	@Override
	public List<PositionDto> findAll() {
		final List<PositionDto> allPositionDtos = new ArrayList<PositionDto>();
		final List<Position> allPositions = positionRepository.findAll();
		allPositions.forEach(x -> allPositionDtos.add(mapper.map(x, PositionDto.class)));

		return allPositionDtos;
	}

	@Override
	public PositionDto getPosition(final Position.ID id) {
		final Position position = positionRepository.findOne(id.getId());
		return mapper.map(position, PositionDto.class);
	}

}
