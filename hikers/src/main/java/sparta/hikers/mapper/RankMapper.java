package sparta.hikers.mapper;

import org.springframework.stereotype.Component;
import sparta.hikers.controller.response.FindRankResponse;
import sparta.hikers.entity.Ranks;

@Component
public class RankMapper {

    public FindRankResponse toRankDto(Ranks ranks) {
        return FindRankResponse.builder()
                .ranking(ranks.getRanking())
                .menuId(ranks.getMenuId())
                .menuName(ranks.getMenuName())
                .price(ranks.getPrice())
                .orderCount(ranks.getOrderCount())
                .build();
    }
}
