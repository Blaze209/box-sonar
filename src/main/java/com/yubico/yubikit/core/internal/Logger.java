package com.yubico.yubikit.core.internal;

import javax.annotation.Nullable;
import org.slf4j.event.Level;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: loaded from: classes3.dex */
public final class Logger {

    @Nullable
    private static com.yubico.yubikit.core.Logger instance;

    public static void setLogger(@Nullable com.yubico.yubikit.core.Logger logger) {
        instance = logger;
    }

    public static void trace(org.slf4j.Logger logger, String str) {
        log(Level.TRACE, logger, str);
    }

    public static void trace(org.slf4j.Logger logger, String str, Object obj) {
        log(Level.TRACE, logger, str, obj);
    }

    public static void trace(org.slf4j.Logger logger, String str, Object obj, Object obj2) {
        log(Level.TRACE, logger, str, obj, obj2);
    }

    public static void trace(org.slf4j.Logger logger, String str, Object... objArr) {
        log(Level.TRACE, logger, str, objArr);
    }

    public static void debug(org.slf4j.Logger logger, String str) {
        log(Level.DEBUG, logger, str);
    }

    public static void debug(org.slf4j.Logger logger, String str, Object obj) {
        log(Level.DEBUG, logger, str, obj);
    }

    public static void debug(org.slf4j.Logger logger, String str, Object obj, Object obj2) {
        log(Level.DEBUG, logger, str, obj, obj2);
    }

    public static void debug(org.slf4j.Logger logger, String str, Object... objArr) {
        log(Level.DEBUG, logger, str, objArr);
    }

    public static void info(org.slf4j.Logger logger, String str) {
        log(Level.INFO, logger, str);
    }

    public static void info(org.slf4j.Logger logger, String str, Object obj) {
        log(Level.INFO, logger, str, obj);
    }

    public static void info(org.slf4j.Logger logger, String str, Object obj, Object obj2) {
        log(Level.INFO, logger, str, obj, obj2);
    }

    public static void info(org.slf4j.Logger logger, String str, Object... objArr) {
        log(Level.INFO, logger, str, objArr);
    }

    public static void warn(org.slf4j.Logger logger, String str) {
        log(Level.WARN, logger, str);
    }

    public static void warn(org.slf4j.Logger logger, String str, Object obj) {
        log(Level.WARN, logger, str, obj);
    }

    public static void warn(org.slf4j.Logger logger, String str, Object obj, Object obj2) {
        log(Level.WARN, logger, str, obj, obj2);
    }

    public static void warn(org.slf4j.Logger logger, String str, Object... objArr) {
        log(Level.WARN, logger, str, objArr);
    }

    public static void error(org.slf4j.Logger logger, String str) {
        log(Level.ERROR, logger, str);
    }

    public static void error(org.slf4j.Logger logger, String str, Object obj) {
        log(Level.ERROR, logger, str, obj);
    }

    public static void error(org.slf4j.Logger logger, String str, Object obj, Object obj2) {
        log(Level.ERROR, logger, str, obj, obj2);
    }

    public static void error(org.slf4j.Logger logger, String str, Object... objArr) {
        log(Level.ERROR, logger, str, objArr);
    }

    private static void log(Level level, org.slf4j.Logger logger, String str) {
        if (instance != null) {
            if (Level.ERROR == level) {
                com.yubico.yubikit.core.Logger.e(str, new Exception("Throwable missing in logger.error"));
                return;
            } else {
                com.yubico.yubikit.core.Logger.d(str);
                return;
            }
        }
        int i = AnonymousClass1.$SwitchMap$org$slf4j$event$Level[level.ordinal()];
        if (i == 1) {
            logger.trace(str);
            return;
        }
        if (i == 2) {
            logger.debug(str);
            return;
        }
        if (i == 3) {
            logger.info(str);
        } else if (i == 4) {
            logger.warn(str);
        } else {
            if (i != 5) {
                return;
            }
            logger.error(str);
        }
    }

    /* JADX INFO: renamed from: com.yubico.yubikit.core.internal.Logger$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$slf4j$event$Level;

        static {
            int[] iArr = new int[Level.values().length];
            $SwitchMap$org$slf4j$event$Level = iArr;
            try {
                iArr[Level.TRACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$slf4j$event$Level[Level.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$slf4j$event$Level[Level.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$slf4j$event$Level[Level.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$slf4j$event$Level[Level.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static void log(Level level, org.slf4j.Logger logger, String str, Object obj) {
        if (instance != null) {
            logToInstance(level, MessageFormatter.format(str, obj));
            return;
        }
        int i = AnonymousClass1.$SwitchMap$org$slf4j$event$Level[level.ordinal()];
        if (i == 1) {
            logger.trace(str, obj);
            return;
        }
        if (i == 2) {
            logger.debug(str, obj);
            return;
        }
        if (i == 3) {
            logger.info(str, obj);
        } else if (i == 4) {
            logger.warn(str, obj);
        } else {
            if (i != 5) {
                return;
            }
            logger.error(str, obj);
        }
    }

    private static void log(Level level, org.slf4j.Logger logger, String str, Object obj, Object obj2) {
        if (instance != null) {
            logToInstance(level, MessageFormatter.format(str, obj, obj2));
            return;
        }
        int i = AnonymousClass1.$SwitchMap$org$slf4j$event$Level[level.ordinal()];
        if (i == 1) {
            logger.trace(str, obj, obj2);
            return;
        }
        if (i == 2) {
            logger.debug(str, obj, obj2);
            return;
        }
        if (i == 3) {
            logger.info(str, obj, obj2);
        } else if (i == 4) {
            logger.warn(str, obj, obj2);
        } else {
            if (i != 5) {
                return;
            }
            logger.error(str, obj, obj2);
        }
    }

    private static void log(Level level, org.slf4j.Logger logger, String str, Object... objArr) {
        if (instance != null) {
            logToInstance(level, MessageFormatter.arrayFormat(str, objArr));
            return;
        }
        int i = AnonymousClass1.$SwitchMap$org$slf4j$event$Level[level.ordinal()];
        if (i == 1) {
            logger.trace(str, objArr);
            return;
        }
        if (i == 2) {
            logger.debug(str, objArr);
            return;
        }
        if (i == 3) {
            logger.info(str, objArr);
        } else if (i == 4) {
            logger.warn(str, objArr);
        } else {
            if (i != 5) {
                return;
            }
            logger.error(str, objArr);
        }
    }

    private static void logToInstance(Level level, FormattingTuple formattingTuple) {
        if (instance != null) {
            Throwable throwable = formattingTuple.getThrowable();
            String message = formattingTuple.getMessage();
            if (Level.ERROR == level) {
                if (throwable != null) {
                    com.yubico.yubikit.core.Logger.e(message, throwable);
                    return;
                } else {
                    com.yubico.yubikit.core.Logger.e(message, new Throwable("Throwable missing in logger.error"));
                    return;
                }
            }
            if (throwable != null) {
                com.yubico.yubikit.core.Logger.d(message + " Throwable: " + throwable.getMessage());
            } else {
                com.yubico.yubikit.core.Logger.d(message);
            }
        }
    }
}
