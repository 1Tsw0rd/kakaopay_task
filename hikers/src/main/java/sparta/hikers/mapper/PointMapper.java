package sparta.hikers.mapper;

import org.springframework.stereotype.Component;

import sparta.hikers.controller.response.UpdatePointResponse;

@Component
public class PointMapper {
	public UpdatePointResponse toPointDto(Long point) {
		return UpdatePointResponse.builder()
			.point(point)
			.build();
	}
}
