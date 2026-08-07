package org.tinylog.writers.raw;

import org.tinylog.Level;

/* JADX INFO: loaded from: classes5.dex */
public enum SyslogSeverity {
    EMERGENCY(0),
    ALERT(1),
    CRITICAL(2),
    ERROR(3),
    WARNING(4),
    NOTICE(5),
    INFORMATIONAL(6),
    DEBUG(7);

    private final int code;

    SyslogSeverity(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: org.tinylog.writers.raw.SyslogSeverity$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$tinylog$Level;

        static {
            int[] iArr = new int[Level.values().length];
            $SwitchMap$org$tinylog$Level = iArr;
            try {
                iArr[Level.TRACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$tinylog$Level[Level.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$tinylog$Level[Level.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$tinylog$Level[Level.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$tinylog$Level[Level.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$tinylog$Level[Level.OFF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static SyslogSeverity getSeverity(Level level) {
        switch (AnonymousClass1.$SwitchMap$org$tinylog$Level[level.ordinal()]) {
            case 1:
            case 2:
                return DEBUG;
            case 3:
                return INFORMATIONAL;
            case 4:
                return WARNING;
            case 5:
                return ERROR;
            case 6:
                return EMERGENCY;
            default:
                return INFORMATIONAL;
        }
    }
}
