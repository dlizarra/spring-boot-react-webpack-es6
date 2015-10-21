package com.dlizarra.startup.position;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dlizarra.startuphub.AppConfig;
import com.dlizarra.startuphub.DatabaseConfig;
import com.dlizarra.startuphub.position.Position;
import com.dlizarra.startuphub.position.PositionDto;
import com.dlizarra.startuphub.position.PositionRepository;
import com.dlizarra.startuphub.position.PositionServiceImpl;
import com.dlizarra.startuphub.support.orika.OrikaBeanMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { AppConfig.class, DatabaseConfig.class })
public class PositionServiceTest {

	@Mock
	private PositionRepository positionRepository;

	@Autowired
	@Spy
	private OrikaBeanMapper mapper;

	@InjectMocks
	private PositionServiceImpl positionService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		final List<Position> positions = new ArrayList<Position>();
		final Position p1 = new Position();
		p1.setId(Position.ID.CREATOR.getId());
		p1.setName("Creator");
		final Position p2 = new Position();
		p2.setId(Position.ID.DEVELOPER.getId());
		p2.setName("Developer");
		positions.add(p1);
		positions.add(p2);
		when(positionRepository.findAll()).thenReturn(positions);
		when(positionRepository.findOne(1)).thenReturn(p1);
	}

	@Test
	public void testFindAll_TwoPositionsInDb_ShouldReturnTwoPositions() {
		// act
		final List<PositionDto> positions = positionService.findAll();
		// assert
		assertThat(positions.size()).isEqualTo(2);
	}

	@Test
	public void testGetPosition_ExistingIdGiven_ShouldReturnOnePosition() {
		// act
		final PositionDto p = positionService.getPosition(Position.ID.CREATOR);
		// assert
		assertThat(p.getName()).isEqualTo("Creator");
	}

}
