package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeJSDocumentScriptExecutor {

    public static final class CppProxy extends NativeJSDocumentScriptExecutor {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeJSDocumentScriptExecutor create(String str, NativeDocumentProvider nativeDocumentProvider);

        private native void nativeDestroy(long j);

        private native NativeJSResult native_executeJavascriptAction(long j, String str, NativeJSEventType nativeJSEventType, NativeJSEventName nativeJSEventName, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSPlatformDelegate native_getPlatformDelegate(long j);

        private native NativeJSResult native_onAppInitEvent(long j);

        private native NativeJSResult native_onBatchExecEvent(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onBookmarkMouseUpEvent(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onConsoleExecEvent(long j);

        private native NativeJSResult native_onDocDidPrint(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onDocDidSave(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onDocOpen(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onDocWillClose(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onDocWillPrint(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onDocWillSave(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onExternalExec(long j);

        private native NativeJSResult native_onFieldBlur(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onFieldCalculate(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onFieldFocus(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onFieldFormat(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onFieldKeystroke(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo, boolean z, String str, String str2, int i, int i2);

        private native NativeJSResult native_onFieldMouseDown(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onFieldMouseEnter(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onFieldMouseExit(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onFieldMouseUp(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onFieldValidate(long j, NativeFormValue nativeFormValue, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onLinkMouseUp(long j, int i, long j2, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onMenuExec(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onPageClose(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onPageOpen(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onScreenBlur(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onScreenClose(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onScreenFocus(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onScreenInview(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onScreenMouseDown(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onScreenMouseEnter(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onScreenMouseExit(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onScreenMouseUp(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onScreenOpen(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native NativeJSResult native_onScreenOutview(long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

        private native void native_setPlatformDelegate(long j, NativeJSPlatformDelegate nativeJSPlatformDelegate);

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

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult executeJavascriptAction(String str, NativeJSEventType nativeJSEventType, NativeJSEventName nativeJSEventName, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_executeJavascriptAction(this.nativeRef, str, nativeJSEventType, nativeJSEventName, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSPlatformDelegate getPlatformDelegate() {
            return native_getPlatformDelegate(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onAppInitEvent() {
            return native_onAppInitEvent(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onBatchExecEvent(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onBatchExecEvent(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onBookmarkMouseUpEvent(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onBookmarkMouseUpEvent(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onConsoleExecEvent() {
            return native_onConsoleExecEvent(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onDocDidPrint(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onDocDidPrint(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onDocDidSave(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onDocDidSave(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onDocOpen(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onDocOpen(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onDocWillClose(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onDocWillClose(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onDocWillPrint(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onDocWillPrint(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onDocWillSave(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onDocWillSave(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onExternalExec() {
            return native_onExternalExec(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onFieldBlur(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onFieldBlur(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onFieldCalculate(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onFieldCalculate(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onFieldFocus(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onFieldFocus(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onFieldFormat(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onFieldFormat(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onFieldKeystroke(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo, boolean z, String str, String str2, int i, int i2) {
            return native_onFieldKeystroke(this.nativeRef, nativeJSEventSourceTargetInfo, z, str, str2, i, i2);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onFieldMouseDown(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onFieldMouseDown(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onFieldMouseEnter(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onFieldMouseEnter(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onFieldMouseExit(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onFieldMouseExit(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onFieldMouseUp(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onFieldMouseUp(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onFieldValidate(NativeFormValue nativeFormValue, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onFieldValidate(this.nativeRef, nativeFormValue, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onLinkMouseUp(int i, long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onLinkMouseUp(this.nativeRef, i, j, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onMenuExec(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onMenuExec(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onPageClose(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onPageClose(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onPageOpen(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onPageOpen(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onScreenBlur(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onScreenBlur(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onScreenClose(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onScreenClose(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onScreenFocus(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onScreenFocus(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onScreenInview(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onScreenInview(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onScreenMouseDown(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onScreenMouseDown(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onScreenMouseEnter(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onScreenMouseEnter(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onScreenMouseExit(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onScreenMouseExit(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onScreenMouseUp(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onScreenMouseUp(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onScreenOpen(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onScreenOpen(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public NativeJSResult onScreenOutview(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo) {
            return native_onScreenOutview(this.nativeRef, nativeJSEventSourceTargetInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor
        public void setPlatformDelegate(NativeJSPlatformDelegate nativeJSPlatformDelegate) {
            native_setPlatformDelegate(this.nativeRef, nativeJSPlatformDelegate);
        }
    }

    public static NativeJSDocumentScriptExecutor create(String str, NativeDocumentProvider nativeDocumentProvider) {
        return CppProxy.create(str, nativeDocumentProvider);
    }

    public abstract NativeJSResult executeJavascriptAction(String str, NativeJSEventType nativeJSEventType, NativeJSEventName nativeJSEventName, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSPlatformDelegate getPlatformDelegate();

    public abstract NativeJSResult onAppInitEvent();

    public abstract NativeJSResult onBatchExecEvent(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onBookmarkMouseUpEvent(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onConsoleExecEvent();

    public abstract NativeJSResult onDocDidPrint(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onDocDidSave(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onDocOpen(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onDocWillClose(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onDocWillPrint(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onDocWillSave(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onExternalExec();

    public abstract NativeJSResult onFieldBlur(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onFieldCalculate(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onFieldFocus(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onFieldFormat(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onFieldKeystroke(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo, boolean z, String str, String str2, int i, int i2);

    public abstract NativeJSResult onFieldMouseDown(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onFieldMouseEnter(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onFieldMouseExit(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onFieldMouseUp(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onFieldValidate(NativeFormValue nativeFormValue, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onLinkMouseUp(int i, long j, NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onMenuExec(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onPageClose(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onPageOpen(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onScreenBlur(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onScreenClose(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onScreenFocus(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onScreenInview(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onScreenMouseDown(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onScreenMouseEnter(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onScreenMouseExit(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onScreenMouseUp(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onScreenOpen(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract NativeJSResult onScreenOutview(NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo);

    public abstract void setPlatformDelegate(NativeJSPlatformDelegate nativeJSPlatformDelegate);
}
