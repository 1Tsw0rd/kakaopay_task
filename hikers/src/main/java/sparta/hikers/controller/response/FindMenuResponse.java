package sparta.hikers.controller.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FindMenuResponse {

	private Long menuId;
	private String menuName;
	private Long price;

	public FindMenuResponse(Long menuId, String menuName, Long price) {
		this.menuId = menuId;
		this.menuName = menuName;
		this.price = price;
	}
}
