package sparta.hikers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Users {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long userId;

	@Column(nullable = false, length = 50)
	private String userName;

	@Column(nullable = false)
	private Long point = 1000L;

	public void updatePoint(Long point) {
		this.point += point;
	}

	public Users(Long userId, String userName, Long point) {
		this.userId = userId;
		this.userName = userName;
		this.point = point;
	}
}
