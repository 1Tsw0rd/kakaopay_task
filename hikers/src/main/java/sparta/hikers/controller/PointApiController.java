package sparta.hikers.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sparta.hikers.common.response.SuccessResponse;
import sparta.hikers.controller.request.UpdatedPointRequest;
import sparta.hikers.service.PointService;

@RequiredArgsConstructor
@RequestMapping("/point")
@RestController
public class PointApiController {

	private final PointService pointService;

	@PatchMapping("/charge")
	public ResponseEntity<?> addPoint(HttpServletRequest request,
		@RequestBody UpdatedPointRequest updatedPointRequest) {
		return new ResponseEntity<>(SuccessResponse.builder().msg("포인트 충전 성공")
			.data(pointService.addPoint(Long.valueOf(request.getHeader("userId")), updatedPointRequest.getPoint()))
			.build(),
			HttpStatus.OK);
	}
}
