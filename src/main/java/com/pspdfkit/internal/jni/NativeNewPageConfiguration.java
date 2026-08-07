package com.pspdfkit.internal.jni;

import com.pspdfkit.utils.EdgeInsets;
import com.pspdfkit.utils.Size;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeNewPageConfiguration {

    public static final class CppProxy extends NativeNewPageConfiguration {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeNewPageConfiguration createEmptyPage(Size size, Integer num, Integer num2, EdgeInsets edgeInsets);

        public static native NativeNewPageConfiguration createExternalDocumentPage(NativeDocument nativeDocument, int i, Integer num, EdgeInsets edgeInsets);

        public static native NativeNewPageConfiguration createExternalDocumentProviderPage(NativeDocumentProvider nativeDocumentProvider, int i, Integer num, EdgeInsets edgeInsets);

        public static native NativeNewPageConfiguration createTiledPatternPage(Size size, Integer num, Integer num2, EdgeInsets edgeInsets, NativeDataDescriptor nativeDataDescriptor);

        private native void nativeDestroy(long j);

        private native boolean native_expandPagesOnCommit(long j);

        private native Integer native_getBackgroundColor(long j);

        private native NativeDocumentProvider native_getDocumentProvider(long j);

        private native NativeItemConfiguration native_getItem(long j);

        private native EdgeInsets native_getPageMargins(long j);

        private native Size native_getPageSize(long j);

        private native NativeNewPageType native_getPageType(long j);

        private native ArrayList<Integer> native_getPagesToExpandOnCommit(long j);

        private native Integer native_getRotation(long j);

        private native int native_getSourcePageIndex(long j);

        private native NativeDataDescriptor native_getTemplateSourcePDF(long j);

        private native void native_setExpandPagesOnCommit(long j, boolean z, ArrayList<Integer> arrayList);

        private native void native_setItem(long j, NativeItemConfiguration nativeItemConfiguration);

        private native void native_setStripWebId(long j, boolean z);

        private native boolean native_shouldStripWebId(long j);

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

        @Override // com.pspdfkit.internal.jni.NativeNewPageConfiguration
        public boolean expandPagesOnCommit() {
            return native_expandPagesOnCommit(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeNewPageConfiguration
        public Integer getBackgroundColor() {
            return native_getBackgroundColor(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeNewPageConfiguration
        public NativeDocumentProvider getDocumentProvider() {
            return native_getDocumentProvider(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeNewPageConfiguration
        public NativeItemConfiguration getItem() {
            return native_getItem(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeNewPageConfiguration
        public EdgeInsets getPageMargins() {
            return native_getPageMargins(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeNewPageConfiguration
        public Size getPageSize() {
            return native_getPageSize(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeNewPageConfiguration
        public NativeNewPageType getPageType() {
            return native_getPageType(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeNewPageConfiguration
        public ArrayList<Integer> getPagesToExpandOnCommit() {
            return native_getPagesToExpandOnCommit(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeNewPageConfiguration
        public Integer getRotation() {
            return native_getRotation(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeNewPageConfiguration
        public int getSourcePageIndex() {
            return native_getSourcePageIndex(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeNewPageConfiguration
        public NativeDataDescriptor getTemplateSourcePDF() {
            return native_getTemplateSourcePDF(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeNewPageConfiguration
        public void setExpandPagesOnCommit(boolean z, ArrayList<Integer> arrayList) {
            native_setExpandPagesOnCommit(this.nativeRef, z, arrayList);
        }

        @Override // com.pspdfkit.internal.jni.NativeNewPageConfiguration
        public void setItem(NativeItemConfiguration nativeItemConfiguration) {
            native_setItem(this.nativeRef, nativeItemConfiguration);
        }

        @Override // com.pspdfkit.internal.jni.NativeNewPageConfiguration
        public void setStripWebId(boolean z) {
            native_setStripWebId(this.nativeRef, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeNewPageConfiguration
        public boolean shouldStripWebId() {
            return native_shouldStripWebId(this.nativeRef);
        }
    }

    public static NativeNewPageConfiguration createEmptyPage(Size size, Integer num, Integer num2, EdgeInsets edgeInsets) {
        return CppProxy.createEmptyPage(size, num, num2, edgeInsets);
    }

    public static NativeNewPageConfiguration createExternalDocumentPage(NativeDocument nativeDocument, int i, Integer num, EdgeInsets edgeInsets) {
        return CppProxy.createExternalDocumentPage(nativeDocument, i, num, edgeInsets);
    }

    public static NativeNewPageConfiguration createExternalDocumentProviderPage(NativeDocumentProvider nativeDocumentProvider, int i, Integer num, EdgeInsets edgeInsets) {
        return CppProxy.createExternalDocumentProviderPage(nativeDocumentProvider, i, num, edgeInsets);
    }

    public static NativeNewPageConfiguration createTiledPatternPage(Size size, Integer num, Integer num2, EdgeInsets edgeInsets, NativeDataDescriptor nativeDataDescriptor) {
        return CppProxy.createTiledPatternPage(size, num, num2, edgeInsets, nativeDataDescriptor);
    }

    public abstract boolean expandPagesOnCommit();

    public abstract Integer getBackgroundColor();

    public abstract NativeDocumentProvider getDocumentProvider();

    public abstract NativeItemConfiguration getItem();

    public abstract EdgeInsets getPageMargins();

    public abstract Size getPageSize();

    public abstract NativeNewPageType getPageType();

    public abstract ArrayList<Integer> getPagesToExpandOnCommit();

    public abstract Integer getRotation();

    public abstract int getSourcePageIndex();

    public abstract NativeDataDescriptor getTemplateSourcePDF();

    public abstract void setExpandPagesOnCommit(boolean z, ArrayList<Integer> arrayList);

    public abstract void setItem(NativeItemConfiguration nativeItemConfiguration);

    public abstract void setStripWebId(boolean z);

    public abstract boolean shouldStripWebId();
}
