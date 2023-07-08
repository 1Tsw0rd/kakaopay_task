package sparta.hikers.service;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import sparta.hikers.entity.Menus;
import sparta.hikers.entity.Users;
import sparta.hikers.repository.MenuRepository;
import sparta.hikers.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class MenuServiceTest {
	@InjectMocks
	private MenuService menuService;

	@Mock
	private MenuRepository menuRepository;
	@Mock
	private UserRepository userRepository;

	@BeforeEach
	void setMenus() {
		menuRepository.save(new Menus(1L, "테스트카노", 5000L, LocalDateTime.now().withNano(0)));
		menuRepository.save(new Menus(2L, "테스트라떼", 7000L, LocalDateTime.now().withNano(0)));
		userRepository.save(new Users(1L, "유저1", 20000L));
	}

	@DisplayName("주문 포인트 테스트")
	@Test
	void saveOrderTest() {
		//given

		//stub

		//when

		//then
		menuService.saveOrder(1L, 1L);
		menuService.saveOrder(1L, 1L);
		menuService.saveOrder(1L, 2L);

	}

}
