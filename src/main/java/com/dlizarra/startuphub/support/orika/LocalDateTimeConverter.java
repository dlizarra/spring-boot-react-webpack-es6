package com.dlizarra.startuphub.support.orika;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

@Component
public class LocalDateTimeConverter extends BidirectionalConverter<LocalDateTime, LocalDateTime> {

	@Override
	public LocalDateTime convertTo(final LocalDateTime source, final Type<LocalDateTime> destinationType) {
		return LocalDateTime.from(source);
	}

	@Override
	public LocalDateTime convertFrom(final LocalDateTime source, final Type<LocalDateTime> destinationType) {
		return LocalDateTime.from(source);
	}

}
