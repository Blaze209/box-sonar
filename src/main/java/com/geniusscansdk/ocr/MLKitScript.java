package com.geniusscansdk.ocr;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: OcrLanguage.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/geniusscansdk/ocr/MLKitScript;", "", "code", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "Latin", "Chinese", "Japanese", "Korean", "Devanagari", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum MLKitScript {
    Latin("Latn"),
    Chinese("Hans/Hant"),
    Japanese("Jpan"),
    Korean("Kore"),
    Devanagari("Deva");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String code;

    public static EnumEntries<MLKitScript> getEntries() {
        return $ENTRIES;
    }

    MLKitScript(String str) {
        this.code = str;
    }

    public final String getCode() {
        return this.code;
    }
}
