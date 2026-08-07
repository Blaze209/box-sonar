package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDocumentLibraryQueryResultHandler {
    public abstract void previewHandler(NativeDocumentLibraryQuery nativeDocumentLibraryQuery, ArrayList<NativeDocumentLibraryPreviewResult> arrayList);

    public abstract void successHandler(NativeDocumentLibraryQuery nativeDocumentLibraryQuery, HashMap<String, HashSet<Long>> map);
}
