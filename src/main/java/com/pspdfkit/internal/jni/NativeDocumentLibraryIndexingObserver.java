package com.pspdfkit.internal.jni;

import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDocumentLibraryIndexingObserver {
    public abstract void didFinishIndexingDocument(NativeDocumentLibrary nativeDocumentLibrary, String str, boolean z);

    public abstract void didIndexPage(NativeDocumentLibrary nativeDocumentLibrary, String str, int i, String str2);

    public abstract EnumSet<NativeObservingEvents> getSubscribedEvents();

    public abstract void willStartIndexingDocument(NativeDocumentLibrary nativeDocumentLibrary, String str);
}
