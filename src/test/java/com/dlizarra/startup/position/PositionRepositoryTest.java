package com.dlizarra.startup.position;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dlizarra.startuphub.position.Position;
import com.dlizarra.startuphub.position.PositionRepository;
import com.dlizarra.startuphub.support.AbstractIntegrationTest;

public class PositionRepositoryTest extends AbstractIntegrationTest {
	@Autowired
	private PositionRepository positionRepository;

	@Test
	public void findOne_ExisitingIdGiven_ShouldReturnPosition() {
		// act
		final Position position = positionRepository.findOne(Position.ID.CREATOR.getId());
		// assert
		assertThat(position.getName().equals("Creator"));
	}

	@Test
	public void findAll_TwoPositionsInDb_ShouldReturnTwoPositions() {
		// act
		final List<Position> allPositions = positionRepository.findAll();
		// assert
		assertThat(allPositions.size()).isEqualTo(2);
	}

}
