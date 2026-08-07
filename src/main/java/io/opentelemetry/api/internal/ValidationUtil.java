package io.opentelemetry.api.internal;

import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class ValidationUtil {
    public static final String API_USAGE_LOGGER_NAME = "io.opentelemetry.ApiUsageLogging";
    private static final Logger API_USAGE_LOGGER = Logger.getLogger(API_USAGE_LOGGER_NAME);
    private static final Pattern VALID_INSTRUMENT_NAME_PATTERN = Pattern.compile("([A-Za-z]){1}([A-Za-z0-9\\_\\-\\.]){0,62}");

    public static void log(String str) {
        log(str, Level.FINEST);
    }

    public static void log(String str, Level level) {
        Logger logger = API_USAGE_LOGGER;
        if (logger.isLoggable(level)) {
            logger.log(level, str, (Throwable) new AssertionError());
        }
    }

    public static boolean checkValidInstrumentName(String str) {
        return checkValidInstrumentName(str, "");
    }

    public static boolean checkValidInstrumentName(String str, String str2) {
        if (str != null && VALID_INSTRUMENT_NAME_PATTERN.matcher(str).matches()) {
            return true;
        }
        log("Instrument name \"" + str + "\" is invalid, returning noop instrument. Instrument names must consist of 63 or fewer characters including alphanumeric, _, ., -, and start with a letter." + str2, Level.WARNING);
        return false;
    }

    public static boolean checkValidInstrumentUnit(String str) {
        return checkValidInstrumentUnit(str, "");
    }

    public static boolean checkValidInstrumentUnit(String str, String str2) {
        if (str != null && !str.equals("") && str.length() < 64 && StandardCharsets.US_ASCII.newEncoder().canEncode(str)) {
            return true;
        }
        log("Unit \"" + str + "\" is invalid. Instrument unit must be 63 or fewer ASCII characters." + str2, Level.WARNING);
        return false;
    }

    private ValidationUtil() {
    }
}
