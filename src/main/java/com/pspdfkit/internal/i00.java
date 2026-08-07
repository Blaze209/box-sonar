package com.pspdfkit.internal;

import android.app.Activity;
import android.content.DialogInterface;
import com.microsoft.intune.mam.client.app.MAMAlertDialogBuilder;
import com.pspdfkit.R;
import com.pspdfkit.internal.jni.NativeLicense;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.ui.dialog.SdkInfoDialog$showSdkInfoDialog$1", f = "SdkInfoDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class i00 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Activity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i00(Activity activity, Continuation<? super i00> continuation) {
        super(2, continuation);
        this.a = activity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new i00(this.a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new i00(this.a, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        new MAMAlertDialogBuilder(this.a).setTitle("Nutrient for Android 11.3.0").setMessage(NativeLicense.rawJsonString()).setPositiveButton(this.a.getText(R.string.pspdf__ok), (DialogInterface.OnClickListener) null).create().show();
        return Unit.INSTANCE;
    }
}
