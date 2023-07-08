package sparta.hikers.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(indexes = {
	@Index(name = "idx_orders_user_id", columnList = "user_id"),
	@Index(name = "idx_orders_menu_id", columnList = "menu_id")
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Orders {

	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long orderId;

	@Column(nullable = false, name = "user_id")
	private Long userId;

	@Column(nullable = false, name = "menu_id")
	private Long menuId;

	@Column(name = "ordered_date", nullable = false)
	@CreatedDate
	private LocalDateTime orderedDate;

	@PrePersist
	private void onPrePersist() {
		this.orderedDate = LocalDateTime.now().withNano(0); //나노초 9자 제거
	}

	public Orders(Long userId, Long menuId) {
		this.userId = userId;
		this.menuId = menuId;
	}
}
