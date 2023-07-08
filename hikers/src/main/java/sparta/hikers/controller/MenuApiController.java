package sparta.hikers.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sparta.hikers.common.response.SuccessResponse;
import sparta.hikers.controller.request.SaveOrderRequest;
import sparta.hikers.service.MenuService;

@RequiredArgsConstructor
@RequestMapping("/menu")
@RestController
public class MenuApiController {

	private final MenuService menuService;

	@GetMapping("/list")
	public ResponseEntity<?> getMenuList() {
		return new ResponseEntity<>(SuccessResponse.builder()
			.msg("메뉴 조회 성공")
			.data(menuService.getMenuList())
			.build(), HttpStatus.OK);
	}

	@PostMapping("/order")
	public ResponseEntity<?> saveOrder(HttpServletRequest request, @RequestBody SaveOrderRequest saveOrderRequest) {
		return new ResponseEntity<>(SuccessResponse.builder()
			.msg("주문 성공")
			.data(menuService.saveOrder(Long.valueOf(request.getHeader("userId")), saveOrderRequest.getMenuId()))
			.build(), HttpStatus.OK);
	}

	@GetMapping("/rank")
	public ResponseEntity<?> getRank() {
		return new ResponseEntity<>(SuccessResponse.builder()
			.msg("인기메뉴 조회 성공")
			.data(menuService.findRank())
			.build(), HttpStatus.OK);
	}

}
