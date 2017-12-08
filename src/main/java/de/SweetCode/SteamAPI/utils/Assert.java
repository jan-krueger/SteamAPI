package de.SweetCode.SteamAPI.utils;

import java.util.Collection;
import java.util.Map;

public class Assert {

    private Assert() {}

    public static boolean isEmpty(Object value) {

        boolean result =
            (
                (value == null) ||
                (value instanceof CharSequence && ((CharSequence)value).length() == 0) ||
                (value.getClass().isArray() && ((Object[]) value).length == 0) ||
                (value instanceof Collection && ((Collection)value).isEmpty()) ||
                (value instanceof Map && ((Map) value).isEmpty())
            );

        return result;
    }

    public static boolean isNonEmpty(Object value) {
        return (!(isEmpty(value)));
    }

    public static void isEmpty(Object value, String format, Object... args) {

        if(!(isEmpty(value))) {
            throw new AssertionError(String.format(format, args));
        }

    }

    public static void isNonEmpty(Object value, String format, Object... args) {

        if(!(isNonEmpty(value))) {
            throw new AssertionError(String.format(format, args));
        }

    }

    public static <T> void is(T expected, T value, String format, Object... args) {

        if(!((expected == value) || (expected != null && expected.equals(value)))) {
            throw new AssertionError(String.format(format, args));
        }

    }

}
