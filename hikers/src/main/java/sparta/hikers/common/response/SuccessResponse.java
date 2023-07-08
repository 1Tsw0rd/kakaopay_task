package sparta.hikers.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class SuccessResponse<T> {

	private final String result;
	private final String msg;
	private final T data;

	@Builder
	public SuccessResponse(String result, String msg, T data) {
		this.result = "Success";
		this.msg = msg;
		this.data = data;
	}
}
