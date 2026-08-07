package io.split.android.grammar;

/* JADX INFO: loaded from: classes4.dex */
public class Treatments {
    public static final String CONTROL = "control";
    public static final String OFF = "off";
    public static final String ON = "on";

    public static boolean isControl(String treatment) {
        return CONTROL.equals(treatment) || "off".equals(treatment);
    }

    public static String controlSynonym(String treatment) {
        if (!isControl(treatment)) {
            throw new IllegalArgumentException("Not a control treatment: " + treatment);
        }
        if (!"off".equals(treatment)) {
            return "off";
        }
        return CONTROL;
    }
}
