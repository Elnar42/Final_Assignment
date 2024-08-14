package enums;

public enum Gender {
    MALE("m"), FEMALE("f");

    private final String define;

    Gender(String define) {
        this.define = define;
    }

    public String getDefine() {
        return define;
    }
}
