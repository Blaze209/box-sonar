package com.geniusscansdk.structureddata.data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BaseData.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0004¨\u0006\b"}, d2 = {"Lcom/geniusscansdk/structureddata/data/BaseData;", "", "<init>", "()V", "loadDataFromResources", "", "", "resourcePath", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseData {
    protected final List<String> loadDataFromResources(String resourcePath) {
        InputStream resourceAsStream;
        List listSplit$default;
        Intrinsics.checkNotNullParameter(resourcePath, "resourcePath");
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader != null && (resourceAsStream = classLoader.getResourceAsStream(resourcePath)) != null) {
            Reader inputStreamReader = new InputStreamReader(resourceAsStream, Charsets.UTF_8);
            String text = TextStreamsKt.readText(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192));
            if (text != null && (listSplit$default = StringsKt.split$default((CharSequence) text, new String[]{"\n"}, false, 0, 6, (Object) null)) != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : listSplit$default) {
                    if (!StringsKt.isBlank((String) obj)) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
        }
        return CollectionsKt.emptyList();
    }
}
