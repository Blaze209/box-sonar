package com.box.android.services;

import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.firebase.iid.FirebaseInstanceId;
import javax.inject.Inject;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes13.dex */
public class FirebaseTokenHandlerService extends Hilt_FirebaseTokenHandlerService {

    @Inject
    protected FirebaseTokenRegistration firebaseTokenRegistration;

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        super.onNewToken(str);
        String token = FirebaseInstanceId.getInstance().getToken();
        BoxLogUtils.v("New token: " + (token != null ? "***(" + token.length() + " chars)" : AbstractJsonLexerKt.NULL));
        this.firebaseTokenRegistration.register();
    }
}
