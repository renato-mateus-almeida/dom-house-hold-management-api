package io.github.renato_mateus_almeida.dom_house_management.utils;

import java.util.Objects;

public class DoubleUtils {
    public static boolean isZero(Double target){
        return Objects.isNull(target) || 0 == target;
    }

    public static boolean isNegative(Double target) {
        return 0 > target;
    }
}
