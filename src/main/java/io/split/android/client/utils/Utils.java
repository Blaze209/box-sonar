package io.split.android.client.utils;

import androidx.collection.SieveCacheKt;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class Utils {
    public static int getAsInt(long value) {
        if (value > SieveCacheKt.NodeLinkMask) {
            return Integer.MAX_VALUE;
        }
        return (int) value;
    }

    public static <T> T getOrDefault(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }

    private static String sanitizeForFolderName(String string) {
        return string == null ? "" : string.replaceAll("[^a-zA-Z0-9]", "");
    }

    public static String convertApiKeyToFolder(String apiKey) throws CloneNotSupportedException {
        String strSanitizeForFolderName = sanitizeForFolderName(apiKey);
        StringBuilder sb = new StringBuilder("$2a$10$");
        if (strSanitizeForFolderName.length() >= 29 - "$2a$10$".length()) {
            sb.append(strSanitizeForFolderName.substring(0, 29 - "$2a$10$".length()));
        } else {
            sb.append(strSanitizeForFolderName);
            sb.append(repeat(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, (29 - "$2a$10$".length()) - strSanitizeForFolderName.length()));
        }
        String strHashpw = BCrypt.hashpw(strSanitizeForFolderName, sb.toString().substring(0, 29));
        if (strHashpw != null) {
            return sanitizeForFolderName(strHashpw);
        }
        return null;
    }

    public static <T> T checkNotNull(T t) {
        return (T) Objects.requireNonNull(t);
    }

    public static <T> T checkNotNull(T reference, Object errorMessage) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(String.valueOf(errorMessage));
    }

    public static void checkArgument(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> List<List<T>> partition(List<T> list, int size) {
        if (list == null) {
            return new ArrayList();
        }
        if (size <= 0) {
            return Collections.singletonList(list);
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < list.size()) {
            int i2 = i + size;
            arrayList.add(new ArrayList(list.subList(i, Math.min(i2, list.size()))));
            i = i2;
        }
        return arrayList;
    }

    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        HashSet hashSet = new HashSet(set1);
        hashSet.retainAll(set2);
        return hashSet;
    }

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static String repeat(String str, int count) {
        if (str == null) {
            return null;
        }
        if (count < 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() * count);
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
