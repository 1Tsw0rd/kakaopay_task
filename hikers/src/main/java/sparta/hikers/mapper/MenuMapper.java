package sparta.hikers.mapper;

import org.springframework.stereotype.Component;

import sparta.hikers.controller.response.FindMenuResponse;
import sparta.hikers.entity.Menus;

@Component
public class MenuMapper {

	public FindMenuResponse toMenuDto(Menus menus) {
		return FindMenuResponse.builder()
			.menuId(menus.getMenuId())
			.menuName(menus.getMenuName())
			.price(menus.getPrice())
			.build();
	}
}
