package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeRichMediaCommand {
    final String mCommand;
    final NativePDFObject mObject;

    public NativeRichMediaCommand(String str, NativePDFObject nativePDFObject) {
        this.mCommand = str;
        this.mObject = nativePDFObject;
    }

    public String getCommand() {
        return this.mCommand;
    }

    public NativePDFObject getObject() {
        return this.mObject;
    }

    public String toString() {
        return "NativeRichMediaCommand{mCommand=" + this.mCommand + ",mObject=" + this.mObject + "}";
    }
}
