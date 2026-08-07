package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeLabelParser {

    public static final class CppProxy extends NativeLabelParser {
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

        private native ArrayList<NativeLabelParseResult> native_getLabels(long j);

        private native Integer native_getPageForPageLabel(long j, String str, boolean z);

        private native String native_getPageLabel(long j, int i);

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

        @Override // com.pspdfkit.internal.jni.NativeLabelParser
        public ArrayList<NativeLabelParseResult> getLabels() {
            return native_getLabels(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeLabelParser
        public Integer getPageForPageLabel(String str, boolean z) {
            return native_getPageForPageLabel(this.nativeRef, str, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeLabelParser
        public String getPageLabel(int i) {
            return native_getPageLabel(this.nativeRef, i);
        }
    }

    public abstract ArrayList<NativeLabelParseResult> getLabels();

    public abstract Integer getPageForPageLabel(String str, boolean z);

    public abstract String getPageLabel(int i);
}
