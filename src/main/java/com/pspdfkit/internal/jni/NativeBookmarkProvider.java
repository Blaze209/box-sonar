package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeBookmarkProvider {

    public static final class CppProxy extends NativeBookmarkProvider {
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

        private native boolean native_addBookmark(long j, NativeBookmark nativeBookmark);

        private native ArrayList<NativeBookmark> native_getBookmarks(long j);

        private native boolean native_removeBookmark(long j, NativeBookmark nativeBookmark);

        private native boolean native_save(long j);

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

        @Override // com.pspdfkit.internal.jni.NativeBookmarkProvider
        public boolean addBookmark(NativeBookmark nativeBookmark) {
            return native_addBookmark(this.nativeRef, nativeBookmark);
        }

        @Override // com.pspdfkit.internal.jni.NativeBookmarkProvider
        public ArrayList<NativeBookmark> getBookmarks() {
            return native_getBookmarks(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeBookmarkProvider
        public boolean removeBookmark(NativeBookmark nativeBookmark) {
            return native_removeBookmark(this.nativeRef, nativeBookmark);
        }

        @Override // com.pspdfkit.internal.jni.NativeBookmarkProvider
        public boolean save() {
            return native_save(this.nativeRef);
        }
    }

    public abstract boolean addBookmark(NativeBookmark nativeBookmark);

    public abstract ArrayList<NativeBookmark> getBookmarks();

    public abstract boolean removeBookmark(NativeBookmark nativeBookmark);

    public abstract boolean save();
}
