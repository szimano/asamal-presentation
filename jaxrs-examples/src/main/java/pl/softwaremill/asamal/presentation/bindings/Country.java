package pl.softwaremill.asamal.presentation.bindings;

import java.util.Locale;

public class Country {

    private String code;

    private String name;

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static Country valueOf(String countryCode) {
        for (Locale locale : Locale.getAvailableLocales()) {
            if (locale.getCountry().equals(countryCode.toUpperCase())) {
                return new Country(countryCode, locale.getDisplayCountry());
            }
        }

        return null;
    }
}
