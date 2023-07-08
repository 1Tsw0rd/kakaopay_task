package sparta.hikers.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import sparta.hikers.common.exception.CommonException;
import sparta.hikers.common.exception.CommonExceptionEnum;
import sparta.hikers.controller.response.UpdatePointResponse;
import sparta.hikers.entity.Points;
import sparta.hikers.entity.Users;
import sparta.hikers.mapper.PointMapper;
import sparta.hikers.repository.PointRepository;
import sparta.hikers.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class PointService {
	private final UserRepository userRepository;
	private final PointRepository pointRepository;

	private final PointMapper pointMapper;

	@Transactional
	public UpdatePointResponse addPoint(Long userId, Long point) {
		//1. 사용자 검색
		Users user = userRepository.findByUserId(userId).orElseThrow(
			() -> new CommonException(CommonExceptionEnum.USER_NOT_FOUND)
		);

		//2. 포인트 충전
		user.updatePoint(point);

		//3. 포인트 내역 추가
		pointRepository.save(new Points(user.getUserId(), point));

		//4. Entity -> Dto 및 결과 반환
		return pointMapper.toPointDto(user.getPoint());
	}
}
