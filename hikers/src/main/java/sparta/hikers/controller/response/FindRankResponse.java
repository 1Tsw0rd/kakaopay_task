package sparta.hikers.controller.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FindRankResponse {
    private Long ranking;
    private Long menuId;
    private String menuName;
    private Long price;
    private Long orderCount;

    public FindRankResponse(Long ranking, Long menuId, String menuName, Long price, Long orderCount) {
        this.ranking = ranking;
        this.menuId = menuId;
        this.menuName = menuName;
        this.price = price;
        this.orderCount = orderCount;
    }
}
