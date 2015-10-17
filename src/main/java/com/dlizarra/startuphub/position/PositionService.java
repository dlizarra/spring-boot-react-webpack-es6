package com.dlizarra.startuphub.position;

import java.util.List;

/**
 * Service providing {@link Position}-related operations.
 *
 * @author dlizarra
 */
public interface PositionService {

	/**
	 * Retrieves all the Positions in the corresponding lookup table.
	 *
	 * @return all Positions in the database.
	 */
	List<PositionDto> findAll();

	PositionDto getPosition(Position.ID id);

}
