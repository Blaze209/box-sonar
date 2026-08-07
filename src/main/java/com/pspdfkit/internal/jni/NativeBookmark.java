package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeBookmark {

    public static final class CppProxy extends NativeBookmark {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeBookmark createBookmark(String str, int i, String str2, Integer num);

        private native void nativeDestroy(long j);

        private native String native_getId(long j);

        private native String native_getName(long j);

        private native Integer native_getPageIndex(long j);

        private native Integer native_getSortKey(long j);

        private native boolean native_isDirty(long j);

        private native void native_setDirty(long j, boolean z);

        private native void native_setName(long j, String str);

        private native void native_setSortKey(long j, Integer num);

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

        @Override // com.pspdfkit.internal.jni.NativeBookmark
        public String getId() {
            return native_getId(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeBookmark
        public String getName() {
            return native_getName(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeBookmark
        public Integer getPageIndex() {
            return native_getPageIndex(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeBookmark
        public Integer getSortKey() {
            return native_getSortKey(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeBookmark
        public boolean isDirty() {
            return native_isDirty(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeBookmark
        public void setDirty(boolean z) {
            native_setDirty(this.nativeRef, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeBookmark
        public void setName(String str) {
            native_setName(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeBookmark
        public void setSortKey(Integer num) {
            native_setSortKey(this.nativeRef, num);
        }
    }

    public static NativeBookmark createBookmark(String str, int i, String str2, Integer num) {
        return CppProxy.createBookmark(str, i, str2, num);
    }

    public abstract String getId();

    public abstract String getName();

    public abstract Integer getPageIndex();

    public abstract Integer getSortKey();

    public abstract boolean isDirty();

    public abstract void setDirty(boolean z);

    public abstract void setName(String str);

    public abstract void setSortKey(Integer num);
}
