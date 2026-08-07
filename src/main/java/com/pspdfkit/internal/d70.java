package com.pspdfkit.internal;

import android.util.LruCache;
import com.pspdfkit.datastructures.Range;
import com.pspdfkit.internal.jni.NativeCompareOptionsFlags;
import com.pspdfkit.internal.jni.NativeUnicodeService;
import com.pspdfkit.utils.PdfLog;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class d70 extends NativeUnicodeService {
    public final Pattern a = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    public final LruCache<String, Pattern> b = new LruCache<>(3);
    public int c = 0;

    @Override // com.pspdfkit.internal.jni.NativeUnicodeService
    public final String foldString(String str) {
        return str.toLowerCase(Locale.getDefault()).toUpperCase(Locale.getDefault());
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0091  */
    @Override // com.pspdfkit.internal.jni.NativeUnicodeService
    public final ArrayList<Range> regexSearch(String str, String str2, EnumSet<NativeCompareOptionsFlags> enumSet) {
        int i = enumSet.contains(NativeCompareOptionsFlags.CASE_INSENSITIVE) ? 66 : 0;
        if (enumSet.contains(NativeCompareOptionsFlags.DIACRITIC_INSENSITIVE)) {
            Pattern pattern = this.a;
            Normalizer.Form form = Normalizer.Form.NFD;
            String strReplaceAll = pattern.matcher(Normalizer.normalize(str2, form)).replaceAll("");
            String strReplaceAll2 = this.a.matcher(Normalizer.normalize(str, form)).replaceAll("");
            if (strReplaceAll2.length() == str.length() && strReplaceAll.length() == str2.length()) {
                str2 = strReplaceAll;
                str = strReplaceAll2;
            }
        }
        if (!enumSet.contains(NativeCompareOptionsFlags.REGULAR_EXPRESSION) && !enumSet.contains(NativeCompareOptionsFlags.SMART_SEARCH)) {
            StringBuilder sb = new StringBuilder(str2.length());
            for (int i2 = 0; i2 < str2.length(); i2++) {
                char cCharAt = str2.charAt(i2);
                if (cCharAt != '$' && cCharAt != '.' && cCharAt != '?' && cCharAt != '^' && cCharAt != '{' && cCharAt != '[' && cCharAt != '\\') {
                    switch (cCharAt) {
                        case '(':
                        case ')':
                        case '*':
                        case '+':
                            sb.append("\\").append(cCharAt);
                            break;
                        default:
                            sb.append(cCharAt);
                            break;
                    }
                } else {
                    sb.append("\\").append(cCharAt);
                }
            }
            str2 = sb.toString();
        }
        if (this.c != i) {
            this.b.evictAll();
            this.c = i;
        }
        Pattern patternCompile = this.b.get(str2);
        if (patternCompile == null) {
            PdfLog.v("Nutri.UnicodeServImpl", "Creating a new pattern for searchTerm: %s", str2);
            patternCompile = Pattern.compile(str2, i);
            this.b.put(str2, patternCompile);
        }
        Matcher matcher = patternCompile.matcher(str);
        ArrayList<Range> arrayList = new ArrayList<>();
        while (matcher.find()) {
            arrayList.add(new Range(matcher.start(), matcher.end() - matcher.start()));
        }
        return arrayList;
    }
}
