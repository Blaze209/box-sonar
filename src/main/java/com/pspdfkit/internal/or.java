package com.pspdfkit.internal;

import com.pspdfkit.datastructures.Range;
import com.pspdfkit.internal.jni.NativeJSAlert;
import com.pspdfkit.internal.jni.NativeJSAlertResult;
import com.pspdfkit.internal.jni.NativeJSButtonImportIconFormElementInfo;
import com.pspdfkit.internal.jni.NativeJSButtonImportIconParams;
import com.pspdfkit.internal.jni.NativeJSButtonImportIconResult;
import com.pspdfkit.internal.jni.NativeJSMail;
import com.pspdfkit.internal.jni.NativeJSPlatformDelegate;
import com.pspdfkit.internal.jni.NativeJSPrintParams;
import com.pspdfkit.internal.jni.NativeJavaScriptAPI;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class or extends NativeJSPlatformDelegate {
    public final go<dn> a = new go<>();

    @Override // com.pspdfkit.internal.jni.NativeJSPlatformDelegate
    public final NativeJSButtonImportIconResult buttonImportIcon(NativeJavaScriptAPI nativeJavaScriptAPI, String str, NativeJSButtonImportIconParams nativeJSButtonImportIconParams, NativeJSButtonImportIconFormElementInfo nativeJSButtonImportIconFormElementInfo) {
        nativeJavaScriptAPI.getClass();
        str.getClass();
        nativeJSButtonImportIconParams.getClass();
        nativeJSButtonImportIconFormElementInfo.getClass();
        Iterator<dn> it = this.a.iterator();
        it.getClass();
        while (it.hasNext()) {
            if (it.next().a(nativeJSButtonImportIconFormElementInfo.getFormPageIndex(), nativeJSButtonImportIconFormElementInfo.getFormAnnotationId())) {
                return NativeJSButtonImportIconResult.NO_ERROR;
            }
        }
        return NativeJSButtonImportIconResult.CANCELLED;
    }

    @Override // com.pspdfkit.internal.jni.NativeJSPlatformDelegate
    public final int getPageNumber(NativeJavaScriptAPI nativeJavaScriptAPI, String str) {
        nativeJavaScriptAPI.getClass();
        str.getClass();
        Iterator<dn> it = this.a.iterator();
        it.getClass();
        while (it.hasNext()) {
            Integer numA = it.next().a();
            if (numA != null) {
                return numA.intValue();
            }
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.pspdfkit.internal.jni.NativeJSPlatformDelegate
    public final void launchUrl(NativeJavaScriptAPI nativeJavaScriptAPI, String str, String str2, boolean z) {
        nativeJavaScriptAPI.getClass();
        str.getClass();
        str2.getClass();
        Iterator<dn> it = this.a.iterator();
        it.getClass();
        while (it.hasNext() && !it.next().a(str2)) {
        }
    }

    @Override // com.pspdfkit.internal.jni.NativeJSPlatformDelegate
    public final void mailDoc(NativeJavaScriptAPI nativeJavaScriptAPI, String str, NativeJSMail nativeJSMail) {
        nativeJavaScriptAPI.getClass();
        str.getClass();
        nativeJSMail.getClass();
        cn cnVar = new cn(nativeJSMail.getTo(), nativeJSMail.getCc(), nativeJSMail.getBcc(), nativeJSMail.getSubject(), nativeJSMail.getMessage());
        Iterator<dn> it = this.a.iterator();
        it.getClass();
        while (it.hasNext() && !it.next().a(cnVar)) {
        }
    }

    @Override // com.pspdfkit.internal.jni.NativeJSPlatformDelegate
    public final void print(NativeJSPrintParams nativeJSPrintParams) {
        Range range;
        nativeJSPrintParams.getClass();
        Integer start = nativeJSPrintParams.getStart();
        Integer end = nativeJSPrintParams.getEnd();
        if (end == null || end.intValue() == 0) {
            range = new Range(start != null ? start.intValue() : 0, Integer.MAX_VALUE);
        } else {
            range = new Range(start != null ? start.intValue() : 0, end.intValue() - (start != null ? start.intValue() : 0));
        }
        Boolean ui = nativeJSPrintParams.getUi();
        en enVar = new en(range, ui != null ? ui.booleanValue() : true, nativeJSPrintParams.getPrintAnnotations());
        Iterator<dn> it = this.a.iterator();
        it.getClass();
        while (it.hasNext() && !it.next().a(enVar)) {
        }
    }

    @Override // com.pspdfkit.internal.jni.NativeJSPlatformDelegate
    public final void setPageNumber(NativeJavaScriptAPI nativeJavaScriptAPI, String str, int i) {
        nativeJavaScriptAPI.getClass();
        str.getClass();
        Iterator<dn> it = this.a.iterator();
        it.getClass();
        while (it.hasNext() && !it.next().a(i)) {
        }
    }

    @Override // com.pspdfkit.internal.jni.NativeJSPlatformDelegate
    public final NativeJSAlertResult showAlert(NativeJavaScriptAPI nativeJavaScriptAPI, String str, NativeJSAlert nativeJSAlert) {
        nativeJavaScriptAPI.getClass();
        str.getClass();
        nativeJSAlert.getClass();
        Iterator<dn> it = this.a.iterator();
        it.getClass();
        while (it.hasNext()) {
            dn next = it.next();
            String title = nativeJSAlert.getTitle();
            title.getClass();
            String message = nativeJSAlert.getMessage();
            message.getClass();
            bn bnVarA = next.a(title, message);
            if (bnVarA != null) {
                return pr.a(bnVarA);
            }
        }
        return NativeJSAlertResult.CANCEL;
    }
}
