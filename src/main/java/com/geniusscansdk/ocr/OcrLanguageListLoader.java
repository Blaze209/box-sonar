package com.geniusscansdk.ocr;

import android.content.Context;
import com.geniusscansdk.R;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: OcrLanguageListLoader.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/geniusscansdk/ocr/OcrLanguageListLoader;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "loadLanguages", "", "Lcom/geniusscansdk/ocr/OcrLanguage;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OcrLanguageListLoader {
    private final Context context;

    public OcrLanguageListLoader(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:36:0x0103  */
    public final List<OcrLanguage> loadLanguages() {
        MLKitScript mLKitScript;
        InputStream inputStreamOpenRawResource = this.context.getResources().openRawResource(R.raw.ocr_languages);
        Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "openRawResource(...)");
        Reader inputStreamReader = new InputStreamReader(inputStreamOpenRawResource, Charsets.UTF_8);
        List<String> lines = TextStreamsKt.readLines(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(lines, 10));
        for (String str : lines) {
            List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{"|"}, false, 0, 6, (Object) null);
            if (listSplit$default.size() < 6) {
                throw new IllegalArgumentException(("This language does not have enough columns: " + str).toString());
            }
            String str2 = (String) listSplit$default.get(0);
            Object obj = listSplit$default.get(5);
            Object obj2 = null;
            if (((String) obj).length() == 0) {
                obj = null;
            }
            String str3 = (String) obj;
            if (str3 != null) {
                MLKitScript[] mLKitScriptArrValues = MLKitScript.values();
                int length = mLKitScriptArrValues.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        MLKitScript mLKitScript2 = mLKitScriptArrValues[i];
                        if (Intrinsics.areEqual(mLKitScript2.getCode(), str3)) {
                            mLKitScript = mLKitScript2;
                            break;
                        }
                        i++;
                    } else {
                        throw new NoSuchElementException("Array contains no element matching the predicate.");
                    }
                }
            } else {
                mLKitScript = null;
            }
            String displayLanguage = Locale.forLanguageTag(str2).getDisplayLanguage();
            if (Intrinsics.areEqual(displayLanguage, str2)) {
                displayLanguage = null;
            } else {
                Intrinsics.checkNotNull(displayLanguage);
                if (displayLanguage.length() == 0) {
                    displayLanguage = null;
                }
            }
            if (displayLanguage != null) {
                if (displayLanguage.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    char cCharAt = displayLanguage.charAt(0);
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                    StringBuilder sbAppend = sb.append((Object) CharsKt.titlecase(cCharAt, locale));
                    String strSubstring = displayLanguage.substring(1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    displayLanguage = sbAppend.append(strSubstring).toString();
                }
                if (displayLanguage == null) {
                    displayLanguage = (String) listSplit$default.get(3);
                }
            } else {
                displayLanguage = (String) listSplit$default.get(3);
            }
            String str4 = displayLanguage;
            Object obj3 = listSplit$default.get(2);
            if (((String) obj3).length() == 0) {
                obj3 = null;
            }
            String str5 = (String) obj3;
            Object obj4 = listSplit$default.get(4);
            if (((String) obj4).length() != 0) {
                obj2 = obj4;
            }
            arrayList.add(new OcrLanguage(str2, str4, str5, (String) obj2, mLKitScript));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj5 : arrayList) {
            OcrLanguage ocrLanguage = (OcrLanguage) obj5;
            if (ocrLanguage.getTesseractCode$gssdk_release() != null || ocrLanguage.getMlKitScript$gssdk_release() != null) {
                arrayList2.add(obj5);
            }
        }
        return arrayList2;
    }
}
