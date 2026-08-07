package com.microsoft.identity.common.internal.fido;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.util.Base64;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.google.android.gms.fido.Fido;
import com.google.android.gms.fido.fido2.api.common.AuthenticatorAssertionResponse;
import com.google.android.gms.fido.fido2.api.common.AuthenticatorErrorResponse;
import com.google.android.gms.fido.fido2.api.common.AuthenticatorResponse;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredential;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.logging.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: LegacyFidoActivityResultContract.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\bX\u0082\u000e¢\u0006\u0002\n\u0000R)\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\f0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/microsoft/identity/common/internal/fido/LegacyFidoActivityResultContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Lcom/microsoft/identity/common/internal/fido/LegacyFido2ApiObject;", "Ljava/lang/Void;", "()V", "TAG", "", "assertionCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "", "errorCallback", "Lcom/microsoft/identity/common/internal/fido/LegacyFido2ApiException;", "exception", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LegacyFidoActivityResultContract extends ActivityResultContract<LegacyFido2ApiObject, Void> {
    private final String TAG = String.valueOf(Reflection.getOrCreateKotlinClass(LegacyFidoActivityResultContract.class).getSimpleName());
    private Function1<? super String, Unit> assertionCallback = new Function1<String, Unit>() { // from class: com.microsoft.identity.common.internal.fido.LegacyFidoActivityResultContract$assertionCallback$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            Logger.info(this.this$0.TAG, "Assertion callback not set.");
        }
    };
    private Function1<? super LegacyFido2ApiException, Unit> errorCallback = new Function1<LegacyFido2ApiException, Unit>() { // from class: com.microsoft.identity.common.internal.fido.LegacyFidoActivityResultContract$errorCallback$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LegacyFido2ApiException legacyFido2ApiException) {
            invoke2(legacyFido2ApiException);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LegacyFido2ApiException it) {
            Intrinsics.checkNotNullParameter(it, "it");
            Logger.info(this.this$0.TAG, "Error callback not set.");
        }
    };

    @Override // androidx.activity.result.contract.ActivityResultContract
    public Intent createIntent(Context context, LegacyFido2ApiObject input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        this.assertionCallback = input.getAssertionCallback();
        this.errorCallback = input.getErrorCallback();
        Intent intent = new Intent(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST);
        IntentSender intentSender = input.getPendingIntent().getIntentSender();
        Intrinsics.checkNotNullExpressionValue(intentSender, "input.pendingIntent.intentSender");
        Intent intentPutExtra = intent.putExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST, new IntentSenderRequest.Builder(intentSender).build());
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent(ActivityResultCon…  ).build()\n            )");
        return intentPutExtra;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public Void parseResult(int resultCode, Intent intent) {
        if (intent == null) {
            this.errorCallback.invoke(new LegacyFido2ApiException("null_object", "Result intent from legacy FIDO2 API was null."));
            return null;
        }
        if (resultCode != -1) {
            this.errorCallback.invoke(new LegacyFido2ApiException("bad_activity_result_code", "Activity closed with result code: " + resultCode));
            return null;
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra(Fido.FIDO2_KEY_CREDENTIAL_EXTRA);
        if (byteArrayExtra == null) {
            this.errorCallback.invoke(new LegacyFido2ApiException("null_object", "Credential result from Intent is null."));
            return null;
        }
        PublicKeyCredential publicKeyCredentialDeserializeFromBytes = PublicKeyCredential.deserializeFromBytes(byteArrayExtra);
        Intrinsics.checkNotNullExpressionValue(publicKeyCredentialDeserializeFromBytes, "deserializeFromBytes(bytes)");
        AuthenticatorResponse response = publicKeyCredentialDeserializeFromBytes.getResponse();
        Intrinsics.checkNotNullExpressionValue(response, "credential.response");
        if (response instanceof AuthenticatorErrorResponse) {
            AuthenticatorErrorResponse authenticatorErrorResponse = (AuthenticatorErrorResponse) response;
            String errorMessage = authenticatorErrorResponse.getErrorMessage();
            String string = authenticatorErrorResponse.getErrorCode().toString();
            Function1<? super LegacyFido2ApiException, Unit> function1 = this.errorCallback;
            if (StringUtil.isNullOrEmpty(errorMessage)) {
                errorMessage = "AuthenticatorResponse has a null error message.";
            }
            function1.invoke(new LegacyFido2ApiException(string, errorMessage));
            return null;
        }
        if (response instanceof AuthenticatorAssertionResponse) {
            AuthenticatorAssertionResponse authenticatorAssertionResponse = (AuthenticatorAssertionResponse) response;
            if (authenticatorAssertionResponse.getUserHandle() == null) {
                this.errorCallback.invoke(new LegacyFido2ApiException("null_object", "UserHandle value in AuthenticatorAssertionResponse is null."));
                return null;
            }
            Function1<? super String, Unit> function2 = this.assertionCallback;
            WebAuthnJsonUtil.Companion companion = WebAuthnJsonUtil.INSTANCE;
            String strEncodeToString = Base64.encodeToString(response.getClientDataJSON(), 11);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(\n        …ING\n                    )");
            String strEncodeToString2 = Base64.encodeToString(authenticatorAssertionResponse.getAuthenticatorData(), 11);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString2, "encodeToString(\n        …ING\n                    )");
            String strEncodeToString3 = Base64.encodeToString(authenticatorAssertionResponse.getSignature(), 11);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString3, "encodeToString(\n        …ING\n                    )");
            String strEncodeToString4 = Base64.encodeToString(authenticatorAssertionResponse.getUserHandle(), 11);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString4, "encodeToString(\n        …ING\n                    )");
            String id = publicKeyCredentialDeserializeFromBytes.getId();
            Intrinsics.checkNotNullExpressionValue(id, "credential.id");
            function2.invoke(companion.createAssertionString(strEncodeToString, strEncodeToString2, strEncodeToString3, strEncodeToString4, id));
            return null;
        }
        this.errorCallback.invoke(new LegacyFido2ApiException("unknown_error", "The legacy FIDO2 API response value is something unexpected which we currently cannot handle."));
        return null;
    }
}
