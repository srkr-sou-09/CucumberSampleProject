package enums;

public enum GlobalPropertiesEnums {
    HEADLESS_BROWSER("driverheadless");
    private String value;

    GlobalPropertiesEnums(String value) {
        this.value= value;
    }

    public String getValue(){
        return value;
    }
}
