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

@Table(indexes = @Index(name = "idx_points_user_id", columnList = "user_id"))
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Points {

	@Column(name = "point_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long pointId;

	@Column(nullable = false, name = "user_id")
	private Long userId;

	@Column(nullable = false)
	private Long point;

	@Column(name = "insertion_date", nullable = false)
	@CreatedDate
	private LocalDateTime insertionDate;

	@PrePersist
	private void onPrePersist() {
		this.insertionDate = LocalDateTime.now().withNano(0); //나노초 9자 제거
	}

	public Points(Long userId, Long point) {
		this.userId = userId;
		this.point = point;
	}
}
