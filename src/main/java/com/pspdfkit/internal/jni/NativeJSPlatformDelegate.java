package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeJSPlatformDelegate {
    public abstract NativeJSButtonImportIconResult buttonImportIcon(NativeJavaScriptAPI nativeJavaScriptAPI, String str, NativeJSButtonImportIconParams nativeJSButtonImportIconParams, NativeJSButtonImportIconFormElementInfo nativeJSButtonImportIconFormElementInfo);

    public abstract int getPageNumber(NativeJavaScriptAPI nativeJavaScriptAPI, String str);

    public abstract void launchUrl(NativeJavaScriptAPI nativeJavaScriptAPI, String str, String str2, boolean z);

    public abstract void mailDoc(NativeJavaScriptAPI nativeJavaScriptAPI, String str, NativeJSMail nativeJSMail);

    public abstract void print(NativeJSPrintParams nativeJSPrintParams);

    public abstract void setPageNumber(NativeJavaScriptAPI nativeJavaScriptAPI, String str, int i);

    public abstract NativeJSAlertResult showAlert(NativeJavaScriptAPI nativeJavaScriptAPI, String str, NativeJSAlert nativeJSAlert);
}
