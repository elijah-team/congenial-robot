package tripleo.elijah.lang.impl;

import tripleo.elijah.lang.i.OS_ElementName;

public class OS_ElementName_ {
    public static OS_ElementName empty() {
        return () -> "";
    }

    public static OS_ElementName ofString(String text) {
        return () -> text;
    }
}
