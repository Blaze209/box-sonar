package com.pspdfkit.internal.jni;

import com.pspdfkit.datastructures.Range;
import java.util.ArrayList;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeUnicodeService {
    public abstract String foldString(String str);

    public abstract ArrayList<Range> regexSearch(String str, String str2, EnumSet<NativeCompareOptionsFlags> enumSet);
}
