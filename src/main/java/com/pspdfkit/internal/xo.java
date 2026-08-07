package com.pspdfkit.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.ShareCompat;
import androidx.core.net.MailTo;
import androidx.fragment.app.FragmentActivity;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.pspdfkit.document.sharing.DefaultDocumentSharingController;
import com.pspdfkit.document.sharing.DocumentSharingIntentHelper;
import java.util.List;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class xo extends DefaultDocumentSharingController {
    public final cn a;

    public xo(FragmentActivity fragmentActivity, cn cnVar) {
        super(fragmentActivity);
        this.a = cnVar;
    }

    @Override // com.pspdfkit.document.sharing.DefaultDocumentSharingController, com.pspdfkit.document.sharing.DocumentSharingController
    public final void onDocumentPrepared(Uri uri) {
        Activity activityA;
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        List listSplit$default;
        List listSplit$default2;
        List listSplit$default3;
        uri.getClass();
        Context context = getContext();
        if (context == null || (activityA = a80.a(context)) == null) {
            return;
        }
        ShareCompat.IntentBuilder intentBuilderAddStream = new ShareCompat.IntentBuilder(activityA).setType(DocumentSharingIntentHelper.MIME_TYPE_PDF).addStream(uri);
        String str = this.a.a;
        if (str == null || (listSplit$default3 = StringsKt.split$default((CharSequence) str, new String[]{AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER}, false, 0, 6, (Object) null)) == null || (strArr = (String[]) listSplit$default3.toArray(new String[0])) == null) {
            strArr = new String[0];
        }
        ShareCompat.IntentBuilder intentBuilderAddEmailTo = intentBuilderAddStream.addEmailTo(strArr);
        String str2 = this.a.c;
        if (str2 == null || (listSplit$default2 = StringsKt.split$default((CharSequence) str2, new String[]{AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER}, false, 0, 6, (Object) null)) == null || (strArr2 = (String[]) listSplit$default2.toArray(new String[0])) == null) {
            strArr2 = new String[0];
        }
        ShareCompat.IntentBuilder intentBuilderAddEmailBcc = intentBuilderAddEmailTo.addEmailBcc(strArr2);
        String str3 = this.a.b;
        if (str3 == null || (listSplit$default = StringsKt.split$default((CharSequence) str3, new String[]{AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER}, false, 0, 6, (Object) null)) == null || (strArr3 = (String[]) listSplit$default.toArray(new String[0])) == null) {
            strArr3 = new String[0];
        }
        ShareCompat.IntentBuilder intentBuilderAddEmailCc = intentBuilderAddEmailBcc.addEmailCc(strArr3);
        String str4 = this.a.d;
        if (str4 == null) {
            str4 = "";
        }
        ShareCompat.IntentBuilder subject = intentBuilderAddEmailCc.setSubject(str4);
        String str5 = this.a.e;
        Intent intent = subject.setText(str5 != null ? str5 : "").getIntent();
        intent.getClass();
        intent.setAction("android.intent.action.SENDTO");
        intent.setData(Uri.parse(MailTo.MAILTO_SCHEME));
        context.startActivity(Intent.createChooser(intent, null));
    }
}
