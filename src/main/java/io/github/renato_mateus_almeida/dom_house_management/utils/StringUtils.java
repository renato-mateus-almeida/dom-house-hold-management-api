package io.github.renato_mateus_almeida.dom_house_management.utils;

import java.util.Objects;

public class StringUtils {
    public static boolean isEmpty(String target){
        return Objects.isNull(target) || 0 == target.length();
    }

    public static String emptyIfNull(String target) {
        return Objects.isNull(target) ? "" : target;
    }
}
