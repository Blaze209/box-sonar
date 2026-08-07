package com.microsoft.identity.common.internal.providers.oauth2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.java.providers.RawAuthorizationResult;
import com.microsoft.identity.common.logging.Logger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: SilentWebViewAuthorizationFragment.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u001a\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0016R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/microsoft/identity/common/internal/providers/oauth2/SilentWebViewAuthorizationFragment;", "Lcom/microsoft/identity/common/internal/providers/oauth2/WebViewAuthorizationFragment;", "()V", "value", "", "webViewSilentAuthorizationFlowTimeOut", "setWebViewSilentAuthorizationFlowTimeOut", "(J)V", "cancelAuthorizationOnTimeOut", "Lkotlinx/coroutines/Job;", "timeOutInMs", "extractState", "", "state", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "onSaveInstanceState", "outState", "onViewCreated", "view", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SilentWebViewAuthorizationFragment extends WebViewAuthorizationFragment {
    private static final long DEFAULT_WEB_VIEW_SILENT_AUTHORIZATION_FLOW_TIME_OUT = 5000;
    private static final long MAX_WEB_VIEW_SILENT_AUTHORIZATION_FLOW_TIMEOUT = 20000;
    private static final long MIN_WEB_VIEW_SILENT_AUTHORIZATION_FLOW_TIMEOUT = 1000;
    private static final String TAG = "SilentWebViewAuthorizationFragment";
    private long webViewSilentAuthorizationFlowTimeOut = 5000;

    private final void setWebViewSilentAuthorizationFlowTimeOut(long j) {
        this.webViewSilentAuthorizationFlowTimeOut = RangesKt.coerceIn(j, 1000L, 20000L);
    }

    @Override // com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewOnCreateView = super.onCreateView(inflater, container, savedInstanceState);
        if (viewOnCreateView == null) {
            return null;
        }
        viewOnCreateView.setVisibility(8);
        viewOnCreateView.setBackgroundColor(0);
        return viewOnCreateView;
    }

    @Override // com.microsoft.identity.common.internal.providers.oauth2.AuthorizationFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        cancelAuthorizationOnTimeOut(this.webViewSilentAuthorizationFlowTimeOut);
    }

    @Override // com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putLong(AuthenticationConstants.AuthorizationIntentKey.WEB_VIEW_SILENT_AUTHORIZATION_FLOW_TIMEOUT, this.webViewSilentAuthorizationFlowTimeOut);
    }

    @Override // com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment, com.microsoft.identity.common.internal.providers.oauth2.AuthorizationFragment
    protected void extractState(Bundle state) {
        Intrinsics.checkNotNullParameter(state, "state");
        super.extractState(state);
        setWebViewSilentAuthorizationFlowTimeOut(state.getLong(AuthenticationConstants.AuthorizationIntentKey.WEB_VIEW_SILENT_AUTHORIZATION_FLOW_TIMEOUT, 5000L));
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.providers.oauth2.SilentWebViewAuthorizationFragment$cancelAuthorizationOnTimeOut$1, reason: invalid class name */
    /* JADX INFO: compiled from: SilentWebViewAuthorizationFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.common.internal.providers.oauth2.SilentWebViewAuthorizationFragment$cancelAuthorizationOnTimeOut$1", f = "SilentWebViewAuthorizationFragment.kt", i = {0}, l = {89}, m = "invokeSuspend", n = {"methodTag"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $timeOutInMs;
        Object L$0;
        int label;
        final /* synthetic */ SilentWebViewAuthorizationFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(long j, SilentWebViewAuthorizationFragment silentWebViewAuthorizationFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$timeOutInMs = j;
            this.this$0 = silentWebViewAuthorizationFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$timeOutInMs, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = "SilentWebViewAuthorizationFragment:cancelAuthorizationOnTimeOut";
                this.label = 1;
                if (DelayKt.delay(this.$timeOutInMs, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = "SilentWebViewAuthorizationFragment:cancelAuthorizationOnTimeOut";
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            Logger.info(str, "Received Authorization flow cancel request from SDK");
            this.this$0.sendResult(RawAuthorizationResult.ResultCode.TIMED_OUT);
            this.this$0.finish();
            return Unit.INSTANCE;
        }
    }

    private final Job cancelAuthorizationOnTimeOut(long timeOutInMs) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        return BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(timeOutInMs, this, null), 3, null);
    }
}
