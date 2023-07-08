package sparta.hikers.common.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FailResponse {
	private final String result;
	private final String msg;

	@Builder
	public FailResponse(String result, String msg) {
		this.result = "Fail";
		this.msg = msg;
	}
}
