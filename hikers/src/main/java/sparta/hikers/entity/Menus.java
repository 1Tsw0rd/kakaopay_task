package sparta.hikers.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Menus {

	@Column(name = "menu_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long menuId;

	@Column(nullable = false, length = 50, name = "menu_name")
	private String menuName;

	@Column(nullable = false)
	private Long price;

	@Column(name = "insertion_date", nullable = false)
	@CreatedDate
	private LocalDateTime insertionDate;

	@Column(name = "modification_date", nullable = false)
	@LastModifiedDate
	private LocalDateTime modificationDate;

	@Builder
	public Menus(Long menuId, String menuName, Long price, LocalDateTime now) {
		this.menuId = menuId;
		this.menuName = menuName;
		this.price = price;
	}
}
