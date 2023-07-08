package sparta.hikers.common.exception;

import lombok.Getter;

@Getter
public enum CommonExceptionEnum {
    MENU_NOT_FOUND("메뉴가 없습니다."),
    USER_NOT_FOUND("사용자가 없습니다."),
    RANK_NOT_FOUND("인기메뉴 정보가 없습니다."),
    NOT_ENOUGH_POINTS("포인트가 충분하지 않습니다.");

    private final String msg;

    CommonExceptionEnum(String msg) {
        this.msg = msg;
    }
}
