package com.pspdfkit.ui.signatures;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microsoft.identity.common.java.constants.FidoConstants;
import com.pspdfkit.configuration.forms.SignaturePickerOrientation;
import com.pspdfkit.configuration.signatures.SignatureSavingStrategy;
import com.pspdfkit.internal.fi;
import com.pspdfkit.internal.jni.NativeLicense;
import com.pspdfkit.internal.jni.NativeSignatureFeatureAvailability;
import com.pspdfkit.internal.ui.dialog.signatures.f;
import com.pspdfkit.internal.ui.dialog.signatures.g;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.x10;
import com.pspdfkit.internal.yz;
import com.pspdfkit.signatures.Signature;
import com.pspdfkit.signatures.listeners.OnSignaturePickedListener;
import com.pspdfkit.signatures.storage.DatabaseSignatureStorage;
import com.pspdfkit.signatures.storage.SignatureStorage;
import com.pspdfkit.utils.PdfLog;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "v2024.4: Will be removed in 2025.", replaceWith = @ReplaceWith(expression = "ElectronicSignatureFragment", imports = {}))
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 (2\u00020\u0001:\u0002)(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\tJ\u0017\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0003R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b%\u0010&\u0012\u0004\b'\u0010\u0003¨\u0006*"}, d2 = {"Lcom/pspdfkit/ui/signatures/SignaturePickerFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "showSignatureEditorFragment", "Landroid/os/Bundle;", "savedInstanceState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "onCreate", "outState", "onSaveInstanceState", "Lcom/pspdfkit/signatures/listeners/OnSignaturePickedListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnSignaturePickedListener", "(Lcom/pspdfkit/signatures/listeners/OnSignaturePickedListener;)V", "finish", "Lcom/pspdfkit/internal/ui/dialog/signatures/f;", "signaturePickerDialog", "Lcom/pspdfkit/internal/ui/dialog/signatures/f;", "Lcom/pspdfkit/signatures/listeners/OnSignaturePickedListener;", "Lcom/pspdfkit/internal/x10;", "signatureDialogListener", "Lcom/pspdfkit/internal/x10;", "Lcom/pspdfkit/signatures/storage/SignatureStorage;", "signatureStorage", "Lcom/pspdfkit/signatures/storage/SignatureStorage;", "getSignatureStorage", "()Lcom/pspdfkit/signatures/storage/SignatureStorage;", "", "waitingForSignatureToBePicked", "Z", "Lio/reactivex/rxjava3/disposables/Disposable;", "signatureRetrievalDisposable", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lcom/pspdfkit/ui/signatures/SignatureOptions;", "signatureOptions", "Lcom/pspdfkit/ui/signatures/SignatureOptions;", "getSignatureOptions$annotations", "Companion", "InternalListener", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SignaturePickerFragment extends Fragment {
    private static final String FRAGMENT_TAG = "com.pspdfkit.ui.signatures.SignaturePickerFragment.FRAGMENT_TAG";
    private static final String LOG_TAG = "Nutri.SignPickerFrag";
    private static final String STATE_SIGNATURE_OPTIONS = "STATE_SIGNATURE_OPTIONS";
    private static final String STATE_WAITING_FOR_SIGNATURE_PICKER_DIALOG = "STATE_WAITING_FOR_SIGNATURE_PICKER_DIALOG";
    private OnSignaturePickedListener listener;
    private f signaturePickerDialog;
    private Disposable signatureRetrievalDisposable;
    private SignatureStorage signatureStorage;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final x10 signatureDialogListener = new InternalListener();
    private boolean waitingForSignatureToBePicked = true;
    private SignatureOptions signatureOptions = new SignatureOptions(null, null, 3, null);

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J&\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/pspdfkit/ui/signatures/SignaturePickerFragment$Companion;", "", "<init>", "()V", "LOG_TAG", "", "FRAGMENT_TAG", SignaturePickerFragment.STATE_WAITING_FOR_SIGNATURE_PICKER_DIALOG, SignaturePickerFragment.STATE_SIGNATURE_OPTIONS, "show", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/pspdfkit/signatures/listeners/OnSignaturePickedListener;", "signatureOptions", "Lcom/pspdfkit/ui/signatures/SignatureOptions;", "signatureStorage", "Lcom/pspdfkit/signatures/storage/SignatureStorage;", "restore", BoxAnalyticsParams.ACTION_DISMISS, "findFragment", "Lcom/pspdfkit/ui/signatures/SignaturePickerFragment;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final SignaturePickerFragment findFragment(FragmentManager fragmentManager) {
            return (SignaturePickerFragment) fragmentManager.findFragmentByTag(SignaturePickerFragment.FRAGMENT_TAG);
        }

        public static /* synthetic */ void restore$default(Companion companion, FragmentManager fragmentManager, OnSignaturePickedListener onSignaturePickedListener, SignatureStorage signatureStorage, int i, Object obj) {
            if ((i & 4) != 0) {
                signatureStorage = null;
            }
            companion.restore(fragmentManager, onSignaturePickedListener, signatureStorage);
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, OnSignaturePickedListener onSignaturePickedListener, SignatureOptions signatureOptions, SignatureStorage signatureStorage, int i, Object obj) {
            if ((i & 4) != 0) {
                signatureOptions = null;
            }
            if ((i & 8) != 0) {
                signatureStorage = null;
            }
            companion.show(fragmentManager, onSignaturePickedListener, signatureOptions, signatureStorage);
        }

        @JvmStatic
        public final void dismiss(FragmentManager fragmentManager) {
            fragmentManager.getClass();
            SignaturePickerFragment signaturePickerFragmentFindFragment = findFragment(fragmentManager);
            if (signaturePickerFragmentFindFragment != null) {
                signaturePickerFragmentFindFragment.finish();
            }
        }

        @JvmStatic
        public final void restore(FragmentManager fragmentManager, OnSignaturePickedListener onSignaturePickedListener) {
            fragmentManager.getClass();
            restore$default(this, fragmentManager, onSignaturePickedListener, null, 4, null);
        }

        @JvmStatic
        public final void show(FragmentManager fragmentManager, OnSignaturePickedListener onSignaturePickedListener) {
            fragmentManager.getClass();
            show$default(this, fragmentManager, onSignaturePickedListener, null, null, 12, null);
        }

        private Companion() {
        }

        @JvmStatic
        public final void restore(FragmentManager fragmentManager, OnSignaturePickedListener listener, SignatureStorage signatureStorage) {
            SignaturePickerFragment signaturePickerFragmentFindFragment;
            fragmentManager.getClass();
            uw.a(fragmentManager, "fragmentManager", null);
            if (listener == null || (signaturePickerFragmentFindFragment = findFragment(fragmentManager)) == null) {
                return;
            }
            signaturePickerFragmentFindFragment.setOnSignaturePickedListener(listener);
            signaturePickerFragmentFindFragment.signatureStorage = signatureStorage;
        }

        @JvmStatic
        public final void show(FragmentManager fragmentManager, OnSignaturePickedListener onSignaturePickedListener, SignatureOptions signatureOptions) {
            fragmentManager.getClass();
            show$default(this, fragmentManager, onSignaturePickedListener, signatureOptions, null, 8, null);
        }

        @JvmStatic
        public final void show(FragmentManager fragmentManager, OnSignaturePickedListener listener, SignatureOptions signatureOptions, SignatureStorage signatureStorage) {
            fragmentManager.getClass();
            SignaturePickerFragment signaturePickerFragmentFindFragment = findFragment(fragmentManager);
            if (signaturePickerFragmentFindFragment == null) {
                signaturePickerFragmentFindFragment = new SignaturePickerFragment();
            }
            signaturePickerFragmentFindFragment.setOnSignaturePickedListener(listener);
            signaturePickerFragmentFindFragment.signatureStorage = signatureStorage;
            Bundle bundle = new Bundle();
            bundle.putParcelable(SignaturePickerFragment.STATE_SIGNATURE_OPTIONS, signatureOptions);
            signaturePickerFragmentFindFragment.setArguments(bundle);
            if (signaturePickerFragmentFindFragment.isAdded()) {
                return;
            }
            fi.a(fragmentManager, signaturePickerFragmentFindFragment, SignaturePickerFragment.FRAGMENT_TAG);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0017¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/pspdfkit/ui/signatures/SignaturePickerFragment$InternalListener;", "Lcom/pspdfkit/internal/x10;", "<init>", "(Lcom/pspdfkit/ui/signatures/SignaturePickerFragment;)V", "Lcom/pspdfkit/signatures/Signature;", FidoConstants.WEBAUTHN_RESPONSE_SIGNATURE_JSON_KEY, "", "onSignaturePicked", "(Lcom/pspdfkit/signatures/Signature;)V", "", "storeSignatureSelected", "onSignatureCreated", "(Lcom/pspdfkit/signatures/Signature;Z)V", "Lcom/pspdfkit/ui/signatures/SignatureUiData;", "signatureUiData", "onSignatureUiDataCollected", "(Lcom/pspdfkit/signatures/Signature;Lcom/pspdfkit/ui/signatures/SignatureUiData;)V", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "()V", "", "signatures", "onSignaturesDeleted", "(Ljava/util/List;)V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class InternalListener implements x10 {
        public InternalListener() {
        }

        @Override // com.pspdfkit.signatures.listeners.OnSignaturePickedListener
        public void onDismiss() {
            if (SignaturePickerFragment.this.waitingForSignatureToBePicked && SignaturePickerFragment.this.listener != null) {
                OnSignaturePickedListener onSignaturePickedListener = SignaturePickerFragment.this.listener;
                onSignaturePickedListener.getClass();
                onSignaturePickedListener.onDismiss();
                SignaturePickerFragment.this.listener = null;
            }
            SignaturePickerFragment signaturePickerFragment = SignaturePickerFragment.this;
            yz.a(signaturePickerFragment.signatureRetrievalDisposable);
            signaturePickerFragment.signatureRetrievalDisposable = null;
            SignaturePickerFragment.this.waitingForSignatureToBePicked = false;
            SignaturePickerFragment.this.signaturePickerDialog = null;
            SignaturePickerFragment.this.finish();
        }

        @Override // com.pspdfkit.signatures.listeners.OnSignaturePickedListener
        public void onSignatureCreated(Signature signature, boolean storeSignatureSelected) {
            signature.getClass();
            boolean z = SignaturePickerFragment.this.signatureOptions.getSignatureSavingStrategy() == SignatureSavingStrategy.ALWAYS_SAVE || (SignaturePickerFragment.this.signatureOptions.getSignatureSavingStrategy() == SignatureSavingStrategy.SAVE_IF_SELECTED && storeSignatureSelected);
            if (SignaturePickerFragment.this.listener != null) {
                OnSignaturePickedListener onSignaturePickedListener = SignaturePickerFragment.this.listener;
                onSignaturePickedListener.getClass();
                onSignaturePickedListener.onSignatureCreated(signature, z);
            }
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(SignaturePickerFragment.this), Dispatchers.getIO(), null, new SignaturePickerFragment$InternalListener$onSignatureCreated$1(z, SignaturePickerFragment.this, signature, this, null), 2, null);
            SignaturePickerFragment.this.waitingForSignatureToBePicked = false;
        }

        @Override // com.pspdfkit.signatures.listeners.OnSignaturePickedListener
        public void onSignaturePicked(Signature signature) {
            signature.getClass();
            if (SignaturePickerFragment.this.listener != null) {
                OnSignaturePickedListener onSignaturePickedListener = SignaturePickerFragment.this.listener;
                onSignaturePickedListener.getClass();
                onSignaturePickedListener.onSignaturePicked(signature);
            }
            SignaturePickerFragment.this.waitingForSignatureToBePicked = false;
            SignaturePickerFragment.this.finish();
        }

        @Override // com.pspdfkit.signatures.listeners.OnSignaturePickedListener
        public void onSignatureUiDataCollected(Signature signature, SignatureUiData signatureUiData) {
            signature.getClass();
            signatureUiData.getClass();
            if (SignaturePickerFragment.this.listener != null) {
                OnSignaturePickedListener onSignaturePickedListener = SignaturePickerFragment.this.listener;
                onSignaturePickedListener.getClass();
                onSignaturePickedListener.onSignatureUiDataCollected(signature, signatureUiData);
            }
        }

        @Override // com.pspdfkit.internal.x10
        public void onSignaturesDeleted(List<Signature> signatures) {
            signatures.getClass();
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(SignaturePickerFragment.this), Dispatchers.getIO(), null, new SignaturePickerFragment$InternalListener$onSignaturesDeleted$1(SignaturePickerFragment.this, signatures, null), 2, null);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.ui.signatures.SignaturePickerFragment$finish$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.ui.signatures.SignaturePickerFragment$finish$1", f = "SignaturePickerFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SignaturePickerFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                FragmentManager parentFragmentManager = SignaturePickerFragment.this.getParentFragmentManager();
                parentFragmentManager.getClass();
                fi.a(parentFragmentManager, SignaturePickerFragment.this);
            } catch (IllegalStateException e) {
                PdfLog.e(SignaturePickerFragment.LOG_TAG, "Dodged IllegalstateException in finish()", e);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @JvmStatic
    public static final void dismiss(FragmentManager fragmentManager) {
        INSTANCE.dismiss(fragmentManager);
    }

    private static /* synthetic */ void getSignatureOptions$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SignatureStorage getSignatureStorage() {
        if (this.signatureStorage == null && NativeLicense.license().signatureFeatureAvailability() == NativeSignatureFeatureAvailability.LEGACYSIGNATURES) {
            this.signatureStorage = DatabaseSignatureStorage.withName(requireContext(), DatabaseSignatureStorage.SIGNATURE_DB_NAME);
        }
        return this.signatureStorage;
    }

    private final void onRestoreInstanceState(Bundle savedInstanceState) {
        this.waitingForSignatureToBePicked = savedInstanceState.getBoolean(STATE_WAITING_FOR_SIGNATURE_PICKER_DIALOG, false);
        SignatureOptions signatureOptions = (SignatureOptions) savedInstanceState.getParcelable(STATE_SIGNATURE_OPTIONS);
        if (signatureOptions != null) {
            this.signatureOptions = signatureOptions;
        }
    }

    @JvmStatic
    public static final void restore(FragmentManager fragmentManager, OnSignaturePickedListener onSignaturePickedListener) {
        INSTANCE.restore(fragmentManager, onSignaturePickedListener);
    }

    @JvmStatic
    public static final void show(FragmentManager fragmentManager, OnSignaturePickedListener onSignaturePickedListener) {
        INSTANCE.show(fragmentManager, onSignaturePickedListener);
    }

    private final void showSignatureEditorFragment() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        x10 x10Var = this.signatureDialogListener;
        SignaturePickerOrientation signaturePickerOrientation = this.signatureOptions.getSignaturePickerOrientation();
        SignatureSavingStrategy signatureSavingStrategy = this.signatureOptions.getSignatureSavingStrategy();
        int i = f.g;
        uw.a(parentFragmentManager, "fragmentManager", null);
        uw.a(x10Var, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        uw.a(signaturePickerOrientation, "orientation", null);
        uw.a(signatureSavingStrategy, "savingStrategy", null);
        f fVar = (f) parentFragmentManager.findFragmentByTag("com.pspdfkit.ui.dialog.signatures.SignaturePickerDialog.FRAGMENT_TAG");
        if (fVar == null) {
            fVar = new f();
        }
        fVar.c = x10Var;
        fVar.d = signaturePickerOrientation;
        fVar.e = signatureSavingStrategy;
        if (!fVar.isAdded()) {
            fVar.show(parentFragmentManager, "com.pspdfkit.ui.dialog.signatures.SignaturePickerDialog.FRAGMENT_TAG");
        }
        this.signaturePickerDialog = fVar;
        this.waitingForSignatureToBePicked = true;
        yz.a(this.signatureRetrievalDisposable);
        this.signatureRetrievalDisposable = null;
        final SignatureStorage signatureStorage = getSignatureStorage();
        if (signatureStorage != null && this.signatureOptions.getSignatureSavingStrategy() != SignatureSavingStrategy.NEVER_SAVE) {
            this.signatureRetrievalDisposable = Observable.fromCallable(new Callable() { // from class: com.pspdfkit.ui.signatures.SignaturePickerFragment$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return signatureStorage.getSignatures();
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.pspdfkit.ui.signatures.SignaturePickerFragment.showSignatureEditorFragment.2
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(List<Signature> list) {
                    f fVar2 = SignaturePickerFragment.this.signaturePickerDialog;
                    fVar2.getClass();
                    list.getClass();
                    g gVar = fVar2.f;
                    if (gVar != null) {
                        gVar.setItems(list);
                    } else {
                        fVar2.b = list;
                    }
                }
            }, new Consumer() { // from class: com.pspdfkit.ui.signatures.SignaturePickerFragment.showSignatureEditorFragment.3
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Throwable th) {
                    PdfLog.e(SignaturePickerFragment.LOG_TAG, th, "Failed to retrieve signatures from the signature storage.", new Object[0]);
                }
            });
            return;
        }
        f fVar2 = this.signaturePickerDialog;
        fVar2.getClass();
        List<Signature> listEmptyList = CollectionsKt.emptyList();
        g gVar = fVar2.f;
        if (gVar != null) {
            gVar.setItems(listEmptyList);
        } else {
            fVar2.b = listEmptyList;
        }
    }

    public final void finish() {
        f fVar = this.signaturePickerDialog;
        if (fVar != null) {
            fVar.getClass();
            fVar.dismiss();
            this.signaturePickerDialog = null;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        SignatureOptions signatureOptions;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null && (signatureOptions = (SignatureOptions) arguments.getParcelable(STATE_SIGNATURE_OPTIONS)) != null) {
            this.signatureOptions = signatureOptions;
        }
        if (savedInstanceState != null) {
            onRestoreInstanceState(savedInstanceState);
        }
        FragmentManager parentFragmentManager = getParentFragmentManager();
        x10 x10Var = this.signatureDialogListener;
        SignaturePickerOrientation signaturePickerOrientation = this.signatureOptions.getSignaturePickerOrientation();
        SignatureSavingStrategy signatureSavingStrategy = this.signatureOptions.getSignatureSavingStrategy();
        int i = f.g;
        uw.a(parentFragmentManager, "fragmentManager", null);
        uw.a(x10Var, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        uw.a(signaturePickerOrientation, "orientation", null);
        uw.a(signatureSavingStrategy, "savingStrategy", null);
        f fVar = (f) parentFragmentManager.findFragmentByTag("com.pspdfkit.ui.dialog.signatures.SignaturePickerDialog.FRAGMENT_TAG");
        if (fVar != null) {
            fVar.c = x10Var;
            fVar.d = signaturePickerOrientation;
            fVar.e = signatureSavingStrategy;
        }
        this.signaturePickerDialog = fVar;
        if (fVar == null && this.waitingForSignatureToBePicked) {
            showSignatureEditorFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        outState.getClass();
        super.onSaveInstanceState(outState);
        outState.putBoolean(STATE_WAITING_FOR_SIGNATURE_PICKER_DIALOG, this.waitingForSignatureToBePicked);
        outState.putParcelable(STATE_SIGNATURE_OPTIONS, this.signatureOptions);
    }

    public final void setOnSignaturePickedListener(OnSignaturePickedListener listener) {
        this.listener = listener;
    }

    @JvmStatic
    public static final void restore(FragmentManager fragmentManager, OnSignaturePickedListener onSignaturePickedListener, SignatureStorage signatureStorage) {
        INSTANCE.restore(fragmentManager, onSignaturePickedListener, signatureStorage);
    }

    @JvmStatic
    public static final void show(FragmentManager fragmentManager, OnSignaturePickedListener onSignaturePickedListener, SignatureOptions signatureOptions) {
        INSTANCE.show(fragmentManager, onSignaturePickedListener, signatureOptions);
    }

    @JvmStatic
    public static final void show(FragmentManager fragmentManager, OnSignaturePickedListener onSignaturePickedListener, SignatureOptions signatureOptions, SignatureStorage signatureStorage) {
        INSTANCE.show(fragmentManager, onSignaturePickedListener, signatureOptions, signatureStorage);
    }
}
