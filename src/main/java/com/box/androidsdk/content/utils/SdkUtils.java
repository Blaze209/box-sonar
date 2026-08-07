package com.box.androidsdk.content.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import android.widget.Toast;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.dataaccess.content.R;
import com.google.common.base.Ascii;
import com.yubico.yubikit.core.fido.CtapException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes13.dex */
public class SdkUtils {
    public static final int BUFFER_SIZE = 8192;
    public static final int COLLAB_NUMBER_THUMB_BG_COLOR = -14997455;
    public static final int COLLAB_NUMBER_THUMB_COLOR = -1;
    public static final long TOAST_MIN_REPEAT_DELAY = 3000;
    private static final double constGB = 1.073741824E9d;
    private static final int constKB = 1024;
    private static final int constMB = 1048576;
    private static final double constTB = 1.099511627776E12d;
    private static final double floatGB = 1.073741824E9d;
    private static final double floatKB = 1024.0d;
    private static final double floatMB = 1048576.0d;
    private static final double floatTB = 1.099511627776E12d;
    protected static final int[] THUMB_COLORS = {-4056997, -1231017, -103524, -680300, -551424, -675045, -4733409, -14237055, -15359317, -11221777, -15620865, -9467905, -12627501, -10011977, -5552196};
    private static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();
    private static HashMap<Integer, Long> LAST_TOAST_TIME = new HashMap<Integer, Long>(10) { // from class: com.box.androidsdk.content.utils.SdkUtils.2
        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Long put(Integer num, Long l) {
            Long l2 = (Long) super.put(num, l);
            if (size() > 9) {
                clean();
            }
            return l2;
        }

        private void clean() {
            long jCurrentTimeMillis = System.currentTimeMillis() - 3000;
            for (Map.Entry<Integer, Long> entry : entrySet()) {
                if (entry.getValue().longValue() < jCurrentTimeMillis) {
                    SdkUtils.LAST_TOAST_TIME.remove(entry);
                }
            }
        }
    };
    private static String SIZE_BYTES = "%4.0f B";
    private static String SIZE_KILOBYTES = "%4.1f KB";
    private static String SIZE_MEGABYTES = "%4.1f MB";
    private static String SIZE_GIGABYTES = "%4.1f GB";
    private static String SIZE_TERABYTES = "%4.1f TB";
    private static String SIZE_LANGUAGE = "";

    public static void copyStream(InputStream inputStream, OutputStream outputStream) throws InterruptedException, IOException {
        copyStream(inputStream, outputStream, null);
    }

    public static String copyStreamAndComputeSha1(InputStream inputStream, OutputStream outputStream) throws InterruptedException, NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        copyStream(inputStream, outputStream, messageDigest);
        return new String(encodeHex(messageDigest.digest()));
    }

    private static void copyStream(InputStream inputStream, OutputStream outputStream, MessageDigest messageDigest) throws InterruptedException, IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                try {
                    int i = inputStream.read(bArr);
                    if (i > 0) {
                        if (Thread.currentThread().isInterrupted()) {
                            throw new InterruptedException();
                        }
                        outputStream.write(bArr, 0, i);
                        if (messageDigest != null) {
                            messageDigest.update(bArr, 0, i);
                        }
                    } else {
                        outputStream.flush();
                        return;
                    }
                } catch (Exception e) {
                    if (e instanceof IOException) {
                        throw ((IOException) e);
                    }
                    if (e instanceof InterruptedException) {
                        throw ((InterruptedException) e);
                    }
                    return;
                }
            } catch (Throwable th) {
                if (0 == 0) {
                    outputStream.flush();
                }
                throw th;
            }
        }
    }

    public static String getAsStringSafely(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static boolean isEmptyString(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String removeFields(String str, String[] strArr) {
        for (String str2 : strArr) {
            str = str.replaceAll(str2, "");
        }
        while (str.contains(",,")) {
            str = str.replaceAll(",,", ",");
        }
        return str.replaceAll(",$", "").replaceFirst("^,", "");
    }

    public static String sha1(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i > 0) {
                messageDigest.update(bArr, 0, i);
            } else {
                inputStream.close();
                return new String(encodeHex(messageDigest.digest()));
            }
        }
    }

    private static char[] encodeHex(byte[] bArr) {
        char[] cArr = new char[bArr.length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = HEX_CHARS;
            cArr[i] = cArr2[(b & CtapException.ERR_VENDOR_FIRST) >>> 4];
            i += 2;
            cArr[i2] = cArr2[b & Ascii.SI];
        }
        return cArr;
    }

    public static String concatStringWithDelimiter(String[] strArr, String str) {
        StringBuilder sb = new StringBuilder();
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (i < i2) {
                sb.append(strArr[i]).append(str);
                i++;
            } else {
                sb.append(strArr[i2]);
                return sb.toString();
            }
        }
    }

    public static ThreadPoolExecutor createDefaultThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit) {
        return new StringMappedThreadPoolExecutor(i, i2, j, timeUnit, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.box.androidsdk.content.utils.SdkUtils.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable);
            }
        });
    }

    public static boolean deleteFolderRecursive(File file) {
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return false;
            }
            for (File file2 : fileArrListFiles) {
                deleteFolderRecursive(file2);
            }
        }
        return file.delete();
    }

    public static boolean isInternetAvailable(Context context) {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        Network activeNetwork = connectivityManager.getActiveNetwork();
        return (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || (!networkCapabilities.hasTransport(1) && !networkCapabilities.hasTransport(0))) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String getAssetFile(Context context, String str) {
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
                try {
                    StringBuilder sb = new StringBuilder();
                    boolean z = true;
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (z) {
                            z = false;
                        } else {
                            sb.append('\n');
                        }
                        sb.append(line);
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (Throwable th) {
                                th.addSuppressed(th);
                            }
                        }
                        throw th;
                    }
                    String string = sb.toString();
                    bufferedReader.close();
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                    return string;
                } catch (Throwable th2) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                throw th4;
            }
        } catch (IOException e) {
            BoxLogUtils.e("getAssetFile", str, e);
            return null;
        }
    }

    public static void toastSafely(final Context context, final int i, final int i2) {
        Long l = LAST_TOAST_TIME.get(Integer.valueOf(i));
        if (l == null || l.longValue() + 3000 <= System.currentTimeMillis()) {
            Looper mainLooper = Looper.getMainLooper();
            if (Thread.currentThread().equals(mainLooper.getThread())) {
                LAST_TOAST_TIME.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
                Toast.makeText(context, i, i2).show();
            } else {
                new Handler(mainLooper).post(new Runnable() { // from class: com.box.androidsdk.content.utils.SdkUtils.3
                    @Override // java.lang.Runnable
                    public void run() {
                        SdkUtils.LAST_TOAST_TIME.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
                        Toast.makeText(context, i, i2).show();
                    }
                });
            }
        }
    }

    public static void setInitialsThumb(Context context, TextView textView, String str) {
        char cCharAt;
        char c = 0;
        if (str != null) {
            String[] strArrSplit = str.split(" ");
            char cCharAt2 = strArrSplit[0].length() > 0 ? strArrSplit[0].charAt(0) : (char) 0;
            cCharAt = strArrSplit.length > 1 ? strArrSplit[strArrSplit.length - 1].charAt(0) : (char) 0;
            c = cCharAt2;
        } else {
            cCharAt = 0;
        }
        setColorForInitialsThumb(textView, c + cCharAt);
        textView.setText(c + "" + cCharAt);
        textView.setTextColor(-1);
    }

    public static void setCollabNumberThumb(Context context, TextView textView, int i) {
        String str = i >= 100 ? "+99" : Marker.ANY_NON_NULL_MARKER + Integer.toString(i);
        setColorForCollabNumberThumb(textView);
        textView.setTextColor(-1);
        textView.setText(str);
    }

    @Deprecated
    public static void setColorsThumb(TextView textView, int i) {
        setColorForInitialsThumb(textView, i);
    }

    public static void setColorsThumb(TextView textView, int i, int i2) {
        GradientDrawable gradientDrawable = (GradientDrawable) textView.getResources().getDrawable(R.drawable.boxsdk_thumb_background);
        gradientDrawable.setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        gradientDrawable.setStroke(3, i2);
        textView.setBackground(gradientDrawable);
    }

    public static void setColorForInitialsThumb(TextView textView, int i) {
        int[] iArr = THUMB_COLORS;
        setColorsThumb(textView, iArr[i % iArr.length], -1);
    }

    public static void setColorForCollabNumberThumb(TextView textView) {
        setColorsThumb(textView, COLLAB_NUMBER_THUMB_BG_COLOR, -1);
    }

    public static Bitmap decodeSampledBitmapFromFile(Resources resources, int i, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = calculateInSampleSize(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        int i6 = i3 / 2;
        int i7 = i4 / 2;
        while (i6 / i5 >= i2 && i7 / i5 >= i) {
            i5 *= 2;
        }
        return i5;
    }

    public static String getLocalizedFileSize(Context context, double d) {
        String language = Locale.getDefault().getLanguage();
        if (!SIZE_LANGUAGE.equals(language) && context != null && context.getResources() != null) {
            Resources resources = context.getResources();
            SIZE_BYTES = resources.getString(R.string.boxsdk_bytes);
            SIZE_KILOBYTES = resources.getString(R.string.boxsdk_kilobytes);
            SIZE_MEGABYTES = resources.getString(R.string.boxsdk_megabytes);
            SIZE_GIGABYTES = resources.getString(R.string.boxsdk_gigabytes);
            SIZE_TERABYTES = resources.getString(R.string.boxsdk_terabytes);
            SIZE_LANGUAGE = language;
        }
        if (d < floatKB) {
            return String.format(Locale.getDefault(), SIZE_BYTES, Double.valueOf(d));
        }
        if (d >= floatKB && d < floatMB) {
            return String.format(Locale.getDefault(), SIZE_KILOBYTES, Double.valueOf(d / floatKB));
        }
        if (d >= floatMB && d < 1.073741824E9d) {
            return String.format(Locale.getDefault(), SIZE_MEGABYTES, Double.valueOf(d / floatMB));
        }
        if (d >= 1.073741824E9d && d < 1.099511627776E12d) {
            return String.format(Locale.getDefault(), SIZE_GIGABYTES, Double.valueOf(d / 1.073741824E9d));
        }
        if (d >= 1.099511627776E12d) {
            return String.format(Locale.getDefault(), SIZE_TERABYTES, Double.valueOf(d / 1.099511627776E12d));
        }
        return null;
    }

    public static String getLocalizedFileSize(double d) {
        return getLocalizedFileSize(ApplicationProvider.application, d);
    }
}
