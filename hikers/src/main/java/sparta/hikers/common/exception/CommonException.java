package sparta.hikers.common.exception;

import lombok.Getter;

@Getter
public class CommonException extends RuntimeException {

	private final CommonExceptionEnum errorEnum;

	public CommonException(CommonExceptionEnum errorEnum) {
		this.errorEnum = errorEnum;
	}
}
