package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeBookmarkManager {

    public static final class CppProxy extends NativeBookmarkManager {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        private native void nativeDestroy(long j);

        private native NativeResult native_addBookmark(long j, NativeBookmark nativeBookmark);

        private native ArrayList<NativeBookmark> native_getBookmarks(long j);

        private native ArrayList<NativeBookmarkProvider> native_getProviders(long j);

        private native NativeResult native_removeBookmark(long j, NativeBookmark nativeBookmark);

        private native ArrayList<NativeBookmark> native_removeBookmarksForPage(long j, int i);

        private native boolean native_save(long j);

        private native void native_setProviders(long j, ArrayList<NativeBookmarkProvider> arrayList);

        public void _djinni_private_destroy() {
            if (this.destroyed.getAndSet(true)) {
                return;
            }
            nativeDestroy(this.nativeRef);
        }

        public void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.pspdfkit.internal.jni.NativeBookmarkManager
        public NativeResult addBookmark(NativeBookmark nativeBookmark) {
            return native_addBookmark(this.nativeRef, nativeBookmark);
        }

        @Override // com.pspdfkit.internal.jni.NativeBookmarkManager
        public ArrayList<NativeBookmark> getBookmarks() {
            return native_getBookmarks(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeBookmarkManager
        public ArrayList<NativeBookmarkProvider> getProviders() {
            return native_getProviders(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeBookmarkManager
        public NativeResult removeBookmark(NativeBookmark nativeBookmark) {
            return native_removeBookmark(this.nativeRef, nativeBookmark);
        }

        @Override // com.pspdfkit.internal.jni.NativeBookmarkManager
        public ArrayList<NativeBookmark> removeBookmarksForPage(int i) {
            return native_removeBookmarksForPage(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeBookmarkManager
        public boolean save() {
            return native_save(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeBookmarkManager
        public void setProviders(ArrayList<NativeBookmarkProvider> arrayList) {
            native_setProviders(this.nativeRef, arrayList);
        }
    }

    public abstract NativeResult addBookmark(NativeBookmark nativeBookmark);

    public abstract ArrayList<NativeBookmark> getBookmarks();

    public abstract ArrayList<NativeBookmarkProvider> getProviders();

    public abstract NativeResult removeBookmark(NativeBookmark nativeBookmark);

    public abstract ArrayList<NativeBookmark> removeBookmarksForPage(int i);

    public abstract boolean save();

    public abstract void setProviders(ArrayList<NativeBookmarkProvider> arrayList);
}
