package enums;

public enum Gender {
    MALE("M"), FEMALE("F");

    private final String define;

    Gender(String define) {
        this.define = define;
    }

    public String getDefine() {
        return define;
    }
}
