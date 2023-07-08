package sparta.hikers.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.hikers.common.exception.CommonException;
import sparta.hikers.common.exception.CommonExceptionEnum;
import sparta.hikers.controller.response.FindMenuResponse;
import sparta.hikers.controller.response.FindRankResponse;
import sparta.hikers.controller.response.UpdatePointResponse;
import sparta.hikers.entity.*;
import sparta.hikers.mapper.MenuMapper;
import sparta.hikers.mapper.PointMapper;
import sparta.hikers.mapper.RankMapper;
import sparta.hikers.repository.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final PointRepository pointRepository;
    private final RankRepository rankRepository;
    private final MenuMapper menuMapper;
    private final PointMapper pointMapper;
    private final RankMapper rankMapper;

    @Transactional(readOnly = true)
    public List<FindMenuResponse> getMenuList() {

        //1. 메뉴 조회
        List<Menus> menus = menuRepository.findAll();

        if (menus.isEmpty()) {
            throw new CommonException(CommonExceptionEnum.MENU_NOT_FOUND);
        }

        //2. Entity -> Dto
        List<FindMenuResponse> menuListDto = new ArrayList<>();

        for (Menus menu : menus) {
            menuListDto.add(menuMapper.toMenuDto(menu));
        }

        //3. 결과 반환
        return menuListDto;
    }

    // @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Transactional
    public UpdatePointResponse saveOrder(Long userId, Long menuId) {
        //1. 사용자 및 메뉴 검색
        Users user = userRepository.findByUserId(userId).orElseThrow(
                () -> new CommonException(CommonExceptionEnum.USER_NOT_FOUND)
        );

        Menus menu = menuRepository.findById(menuId).orElseThrow(
                () -> new CommonException(CommonExceptionEnum.MENU_NOT_FOUND)
        );

        //2. 여유 포인트 검사
        if (user.getPoint() < menu.getPrice()) {
            throw new CommonException(CommonExceptionEnum.NOT_ENOUGH_POINTS);
        }

        //3. 주문내역 추가
        orderRepository.save(new Orders(userId, menuId));

        //4. 포인트 차감
        user.updatePoint(menu.getPrice() * -1L);

        //5. 포인트 사용내역 추가
        pointRepository.save(new Points(userId, menu.getPrice() * -1));

        //6. Entity -> Dto 및 결과 반환
        return pointMapper.toPointDto(user.getPoint());
    }

    @Cacheable(value = "ranks") //ranks는 캐시이름
    @Transactional(readOnly = true)
    public List<FindRankResponse> findRank() {
        //1. 조회
        List<Ranks> rankWeekly = rankRepository.findAll();

        if (rankWeekly.isEmpty()) {
            throw new CommonException(CommonExceptionEnum.RANK_NOT_FOUND);
        }

        // 2. Entity -> Dto
        List<FindRankResponse> rankListDto = new ArrayList<>();

        for (Ranks ranks : rankWeekly) {
            if (ranks.getRanking() > 3) break;
            rankListDto.add(rankMapper.toRankDto(ranks));
        }

        // 3. 결과반환
        return rankListDto;
    }

    @Scheduled(cron = "0 0 0,1,2 * * *") //매일 0,1,2시 초기화, 에러 대비하여 3번 초기화로 구성
    @CacheEvict(value = "ranks")
    public void initRank() {
        log.info("캐시 초기화 진행" + LocalDateTime.now().withNano(0));
    }
}
