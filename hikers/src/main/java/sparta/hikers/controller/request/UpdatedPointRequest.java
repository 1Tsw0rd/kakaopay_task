package sparta.hikers.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class UpdatedPointRequest {
	@JsonProperty("point")
	private Long Point;
}
