package org.next.airxelerate.enums;

public enum AuthorizationEnum {
    USER("USER"), ADMIN("ADMIN");
    private String text;

    AuthorizationEnum(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static AuthorizationEnum fromString(String text) {
        for (AuthorizationEnum auth : AuthorizationEnum.values()) {
            if (auth.text.equalsIgnoreCase(text)) {
                return auth;
            }
        }
        return null;
    }
}
