package com.box.android.common.utilities;

import androidx.documentfile.provider.DocumentFile;
import com.box.android.common.R;
import java.text.DecimalFormat;
import java.util.Locale;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: classes10.dex */
public class FileSizeUtils {
    private static final int CONST_GB = 1073741824;
    private static final int CONST_KB = 1024;
    private static final int CONST_MB = 1048576;
    private static final float FLOAT_GB = 1.0737418E9f;
    private static final float FLOAT_KB = 1024.0f;
    private static final float FLOAT_MB = 1048576.0f;
    private static final DecimalFormat SINGLE_DECIMAL_FORMATTER = new DecimalFormat("###,###.#");

    private FileSizeUtils() {
    }

    public static String getFileSize(String str) {
        return getFileSize(Long.valueOf(CommonBoxUtil.parseLong(str)));
    }

    public static String getFileSize(Double d) {
        if (d == null) {
            return "0";
        }
        return getFileSize(Long.valueOf(d.longValue()));
    }

    public static String getFileSize(Long l) {
        String strLS = CommonBoxUtil.LS(R.string.LS_0_byte);
        if (l != null) {
            String string = Long.toString(l.longValue());
            if (l.longValue() < 1024) {
                return string + " " + CommonBoxUtil.LS(R.string.bytes);
            }
            if (l.longValue() >= 1024 && l.longValue() < 1048576) {
                return String.format(Locale.getDefault(), "%4.1f ", Float.valueOf(l.longValue() / FLOAT_KB)) + CommonBoxUtil.LS(R.string.kilobytes);
            }
            if (l.longValue() >= 1048576 && l.longValue() < FileUtils.ONE_GB) {
                return String.format(Locale.getDefault(), "%4.1f ", Float.valueOf(l.longValue() / FLOAT_MB)) + CommonBoxUtil.LS(R.string.megabytes);
            }
            if (l.longValue() >= FileUtils.ONE_GB) {
                return String.format(Locale.getDefault(), "%4.1f ", Float.valueOf(l.longValue() / FLOAT_GB)) + CommonBoxUtil.LS(R.string.gigabytes);
            }
        }
        return strLS;
    }

    public static String getFileSizeOutOfTotal(long j, long j2) {
        String strLS = CommonBoxUtil.LS(R.string.LS_0_byte);
        if (j2 < 1024) {
            return String.format(CommonBoxUtil.LS(R.string.x_of_y_no_colon_string), Long.toString(j), Long.toString(j2)) + " " + CommonBoxUtil.LS(R.string.bytes);
        }
        if (j2 >= 1024 && j2 < 1048576) {
            return String.format(CommonBoxUtil.LS(R.string.x_of_y_no_colon_string), Integer.valueOf(Math.round(j / FLOAT_KB)), Integer.valueOf(Math.round(j2 / FLOAT_KB))) + " " + CommonBoxUtil.LS(R.string.kilobytes);
        }
        if (j2 >= 1048576 && j2 < FileUtils.ONE_GB) {
            float f = j2 / FLOAT_MB;
            float f2 = j / FLOAT_MB;
            StringBuilder sb = new StringBuilder();
            String strLS2 = CommonBoxUtil.LS(R.string.x_of_y_no_colon_string);
            DecimalFormat decimalFormat = SINGLE_DECIMAL_FORMATTER;
            return sb.append(String.format(strLS2, decimalFormat.format(f2), decimalFormat.format(f))).append(" ").append(CommonBoxUtil.LS(R.string.megabytes)).toString();
        }
        if (j2 < FileUtils.ONE_GB) {
            return strLS;
        }
        float f3 = j2 / FLOAT_GB;
        float f4 = j / FLOAT_GB;
        StringBuilder sb2 = new StringBuilder();
        String strLS3 = CommonBoxUtil.LS(R.string.x_of_y_no_colon_string);
        DecimalFormat decimalFormat2 = SINGLE_DECIMAL_FORMATTER;
        return sb2.append(String.format(strLS3, decimalFormat2.format(f4), decimalFormat2.format(f3))).append(" ").append(CommonBoxUtil.LS(R.string.gigabytes)).toString();
    }

    public static long sizeOf(DocumentFile documentFile) {
        if (documentFile == null) {
            return -1L;
        }
        try {
            if (documentFile.isDirectory()) {
                long jSizeOf = 0;
                for (DocumentFile documentFile2 : documentFile.listFiles()) {
                    jSizeOf += sizeOf(documentFile2);
                }
                return jSizeOf;
            }
            return documentFile.length();
        } catch (Exception unused) {
            return -1L;
        }
    }
}
