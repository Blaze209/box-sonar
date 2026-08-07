package com.pspdfkit.ui.signatures;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.pspdfkit.configuration.signatures.SignatureSavingStrategy;
import com.pspdfkit.internal.fi;
import com.pspdfkit.internal.h60;
import com.pspdfkit.internal.pf;
import com.pspdfkit.internal.qf;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.x10;
import com.pspdfkit.internal.yz;
import com.pspdfkit.signatures.Signature;
import com.pspdfkit.signatures.listeners.OnSignaturePickedListener;
import com.pspdfkit.signatures.storage.SignatureStorage;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public class ElectronicSignatureFragment extends Fragment {
    public static final String FRAGMENT_TAG = "com.pspdfkit.ui.signatures.ElectronicSignatureFragment.FRAGMENT_TAG";
    private static final String LOG_TAG = "Nutri.ElectronicSignFrag";
    private static final String STATE_SIGNATURE_OPTIONS = "STATE_SIGNATURE_OPTIONS";
    private static final String STATE_SIGNATURE_STORAGE_AVAILABILITY = "STATE_SIGNATURE_STORAGE_AVAILABILITY";
    private static final String STATE_WAITING_FOR_SIGNATURE_PICKER_DIALOG = "STATE_WAITING_FOR_SIGNATURE_PICKER_DIALOG";
    private Disposable deletingSignaturesDisposable;
    private pf electronicSignatureDialog;
    private OnSignaturePickedListener listener;
    private ElectronicSignatureOptions signatureOptions;
    private Disposable signatureRetrievalDisposable;
    private SignatureStorage signatureStorage;
    private Disposable storingSignaturesDisposable;
    private final x10 signatureDialogListener = new InternalListener();
    private boolean isSignatureStorageAvailable = false;
    private boolean waitingForSignatureToBePicked = true;

    public class InternalListener implements x10 {
        private InternalListener() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSignatureCreated$0(boolean z, Signature signature) throws Exception {
            if (z) {
                ElectronicSignatureFragment.this.getSignatureStorage().addSignature(signature);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSignatureCreated$1(boolean z, Signature signature) throws Throwable {
            if (z) {
                PdfLog.d(ElectronicSignatureFragment.LOG_TAG, "Successfully added signature to the signature storage: " + signature, new Object[0]);
            }
            onSignaturePicked(signature);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSignaturesDeleted$3(List list) throws Exception {
            ElectronicSignatureFragment.this.getSignatureStorage().removeSignatures(list);
        }

        @Override // com.pspdfkit.signatures.listeners.OnSignaturePickedListener
        public void onDismiss() {
            OnSignaturePickedListener onSignaturePickedListener;
            ElectronicSignatureFragment electronicSignatureFragment = ElectronicSignatureFragment.this;
            if (electronicSignatureFragment.waitingForSignatureToBePicked && (onSignaturePickedListener = electronicSignatureFragment.listener) != null) {
                onSignaturePickedListener.onDismiss();
                ElectronicSignatureFragment.this.listener = null;
            }
            ElectronicSignatureFragment electronicSignatureFragment2 = ElectronicSignatureFragment.this;
            yz.a(electronicSignatureFragment2.signatureRetrievalDisposable);
            electronicSignatureFragment2.signatureRetrievalDisposable = null;
            ElectronicSignatureFragment electronicSignatureFragment3 = ElectronicSignatureFragment.this;
            electronicSignatureFragment3.waitingForSignatureToBePicked = false;
            electronicSignatureFragment3.electronicSignatureDialog = null;
            electronicSignatureFragment3.finish();
        }

        @Override // com.pspdfkit.signatures.listeners.OnSignaturePickedListener
        public void onSignatureCreated(final Signature signature, boolean z) {
            ElectronicSignatureFragment electronicSignatureFragment = ElectronicSignatureFragment.this;
            if (electronicSignatureFragment.signatureOptions == null) {
                electronicSignatureFragment.createAndEvaluateSignatureOptions();
            }
            SignatureSavingStrategy signatureSavingStrategy = ElectronicSignatureFragment.this.signatureOptions.getSignatureSavingStrategy();
            final boolean z2 = signatureSavingStrategy == SignatureSavingStrategy.ALWAYS_SAVE || (signatureSavingStrategy == SignatureSavingStrategy.SAVE_IF_SELECTED && z);
            OnSignaturePickedListener onSignaturePickedListener = ElectronicSignatureFragment.this.listener;
            if (onSignaturePickedListener != null) {
                onSignaturePickedListener.onSignatureCreated(signature, z2);
            }
            ElectronicSignatureFragment.this.storingSignaturesDisposable = Completable.fromAction(new Action() { // from class: com.pspdfkit.ui.signatures.ElectronicSignatureFragment$InternalListener$$ExternalSyntheticLambda3
                @Override // io.reactivex.rxjava3.functions.Action
                public final void run() throws Exception {
                    this.f$0.lambda$onSignatureCreated$0(z2, signature);
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action() { // from class: com.pspdfkit.ui.signatures.ElectronicSignatureFragment$InternalListener$$ExternalSyntheticLambda4
                @Override // io.reactivex.rxjava3.functions.Action
                public final void run() throws Throwable {
                    this.f$0.lambda$onSignatureCreated$1(z2, signature);
                }
            }, new Consumer() { // from class: com.pspdfkit.ui.signatures.ElectronicSignatureFragment$InternalListener$$ExternalSyntheticLambda5
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Object obj) {
                    PdfLog.e(ElectronicSignatureFragment.LOG_TAG, (Throwable) obj, "Failed to add signature to the signature storage.", new Object[0]);
                }
            });
            ElectronicSignatureFragment.this.waitingForSignatureToBePicked = false;
        }

        @Override // com.pspdfkit.signatures.listeners.OnSignaturePickedListener
        public void onSignaturePicked(Signature signature) {
            OnSignaturePickedListener onSignaturePickedListener = ElectronicSignatureFragment.this.listener;
            if (onSignaturePickedListener != null) {
                onSignaturePickedListener.onSignaturePicked(signature);
            }
            ElectronicSignatureFragment electronicSignatureFragment = ElectronicSignatureFragment.this;
            electronicSignatureFragment.waitingForSignatureToBePicked = false;
            electronicSignatureFragment.finish();
        }

        @Override // com.pspdfkit.signatures.listeners.OnSignaturePickedListener
        public void onSignatureUiDataCollected(Signature signature, SignatureUiData signatureUiData) {
            OnSignaturePickedListener onSignaturePickedListener = ElectronicSignatureFragment.this.listener;
            if (onSignaturePickedListener != null) {
                onSignaturePickedListener.onSignatureUiDataCollected(signature, signatureUiData);
            }
        }

        @Override // com.pspdfkit.internal.x10
        public void onSignaturesDeleted(final List<Signature> list) {
            ElectronicSignatureFragment.this.deletingSignaturesDisposable = Completable.fromAction(new Action() { // from class: com.pspdfkit.ui.signatures.ElectronicSignatureFragment$InternalListener$$ExternalSyntheticLambda0
                @Override // io.reactivex.rxjava3.functions.Action
                public final void run() throws Exception {
                    this.f$0.lambda$onSignaturesDeleted$3(list);
                }
            }).subscribeOn(Schedulers.io()).subscribe(new Action() { // from class: com.pspdfkit.ui.signatures.ElectronicSignatureFragment$InternalListener$$ExternalSyntheticLambda1
                @Override // io.reactivex.rxjava3.functions.Action
                public final void run() {
                    PdfLog.d(ElectronicSignatureFragment.LOG_TAG, "Successfully removed signatures from the signature storage: " + list, new Object[0]);
                }
            }, new Consumer() { // from class: com.pspdfkit.ui.signatures.ElectronicSignatureFragment$InternalListener$$ExternalSyntheticLambda2
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Object obj) {
                    PdfLog.e(ElectronicSignatureFragment.LOG_TAG, (Throwable) obj, "Failed to remove signatures from the signature storage: " + list, new Object[0]);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ElectronicSignatureOptions createAndEvaluateSignatureOptions() {
        if (this.signatureOptions == null) {
            this.signatureOptions = new ElectronicSignatureOptions();
        }
        this.isSignatureStorageAvailable = this.signatureStorage != null;
        SignatureSavingStrategy signatureSavingStrategy = this.signatureOptions.getSignatureSavingStrategy();
        SignatureSavingStrategy signatureSavingStrategy2 = SignatureSavingStrategy.NEVER_SAVE;
        if (signatureSavingStrategy != signatureSavingStrategy2 && !this.isSignatureStorageAvailable) {
            PdfLog.d(LOG_TAG, "`SignatureSavingStrategy` set to save signatures, but there is no `SignatureStorage` available. Please create one if you wish to save signatures.", new Object[0]);
            this.signatureOptions = new ElectronicSignatureOptions(signatureSavingStrategy2, this.signatureOptions.getSignatureColorOptions(), this.signatureOptions.getSignatureCreationModes());
        }
        return this.signatureOptions;
    }

    public static void dismiss(FragmentManager fragmentManager) {
        ElectronicSignatureFragment electronicSignatureFragmentFindFragment = findFragment(fragmentManager);
        if (electronicSignatureFragmentFindFragment != null) {
            electronicSignatureFragmentFindFragment.finish();
        }
    }

    private static ElectronicSignatureFragment findFragment(FragmentManager fragmentManager) {
        return (ElectronicSignatureFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SignatureStorage getSignatureStorage() {
        return this.signatureStorage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$finish$0() {
        try {
            fi.a(getParentFragmentManager(), this);
        } catch (IllegalStateException e) {
            PdfLog.e(LOG_TAG, "Dodged IllegalstateException in finish()", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$showSignatureEditorFragment$1(List list) throws Throwable {
        pf pfVar = this.electronicSignatureDialog;
        if (list == null) {
            pfVar.b = list;
            return;
        }
        qf qfVar = pfVar.d;
        if (qfVar != null) {
            qfVar.setItems(list);
        } else {
            pfVar.b = list;
        }
    }

    private void onRestoreInstanceState(Bundle bundle) {
        this.waitingForSignatureToBePicked = bundle.getBoolean(STATE_WAITING_FOR_SIGNATURE_PICKER_DIALOG, false);
        ElectronicSignatureOptions electronicSignatureOptions = (ElectronicSignatureOptions) bundle.getParcelable(STATE_SIGNATURE_OPTIONS);
        if (electronicSignatureOptions != null) {
            this.signatureOptions = electronicSignatureOptions;
        }
        this.isSignatureStorageAvailable = bundle.getBoolean(STATE_SIGNATURE_STORAGE_AVAILABILITY, false);
    }

    public static void restore(FragmentManager fragmentManager, OnSignaturePickedListener onSignaturePickedListener, SignatureStorage signatureStorage) {
        ElectronicSignatureFragment electronicSignatureFragmentFindFragment;
        uw.a(fragmentManager, "fragmentManager", null);
        if (onSignaturePickedListener == null || (electronicSignatureFragmentFindFragment = findFragment(fragmentManager)) == null) {
            return;
        }
        electronicSignatureFragmentFindFragment.setOnSignaturePickedListener(onSignaturePickedListener);
        electronicSignatureFragmentFindFragment.setSignatureStorage(signatureStorage);
    }

    private void setSignatureStorage(SignatureStorage signatureStorage) {
        this.signatureStorage = signatureStorage;
    }

    public static void show(FragmentManager fragmentManager, OnSignaturePickedListener onSignaturePickedListener, ElectronicSignatureOptions electronicSignatureOptions, SignatureStorage signatureStorage) {
        uw.a(fragmentManager, "fragmentManager", null);
        ElectronicSignatureFragment electronicSignatureFragmentFindFragment = findFragment(fragmentManager);
        if (electronicSignatureFragmentFindFragment == null) {
            electronicSignatureFragmentFindFragment = new ElectronicSignatureFragment();
        }
        electronicSignatureFragmentFindFragment.setOnSignaturePickedListener(onSignaturePickedListener);
        electronicSignatureFragmentFindFragment.setSignatureStorage(signatureStorage);
        Bundle bundle = new Bundle();
        bundle.putParcelable(STATE_SIGNATURE_OPTIONS, electronicSignatureOptions);
        electronicSignatureFragmentFindFragment.setArguments(bundle);
        if (electronicSignatureFragmentFindFragment.isAdded()) {
            return;
        }
        fi.a(fragmentManager, electronicSignatureFragmentFindFragment, FRAGMENT_TAG);
    }

    private void showSignatureEditorFragment() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        x10 x10Var = this.signatureDialogListener;
        ElectronicSignatureOptions electronicSignatureOptionsCreateAndEvaluateSignatureOptions = createAndEvaluateSignatureOptions();
        int i = pf.e;
        parentFragmentManager.getClass();
        x10Var.getClass();
        electronicSignatureOptionsCreateAndEvaluateSignatureOptions.getClass();
        pf pfVar = (pf) parentFragmentManager.findFragmentByTag("com.pspdfkit.ui.dialog.signatures.ElectronicSignatureDialog.FRAGMENT_TAG");
        if (pfVar == null) {
            pfVar = new pf();
        }
        pfVar.a = x10Var;
        pfVar.c = electronicSignatureOptionsCreateAndEvaluateSignatureOptions;
        if (!pfVar.isAdded()) {
            pfVar.show(parentFragmentManager, "com.pspdfkit.ui.dialog.signatures.ElectronicSignatureDialog.FRAGMENT_TAG");
        }
        this.electronicSignatureDialog = pfVar;
        this.waitingForSignatureToBePicked = true;
        yz.a(this.signatureRetrievalDisposable);
        this.signatureRetrievalDisposable = null;
        final SignatureStorage signatureStorage = getSignatureStorage();
        if (signatureStorage != null && this.signatureOptions.getSignatureSavingStrategy() != SignatureSavingStrategy.NEVER_SAVE) {
            this.signatureRetrievalDisposable = Observable.fromCallable(new Callable() { // from class: com.pspdfkit.ui.signatures.ElectronicSignatureFragment$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return signatureStorage.getSignatures();
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.pspdfkit.ui.signatures.ElectronicSignatureFragment$$ExternalSyntheticLambda2
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Object obj) throws Throwable {
                    this.f$0.lambda$showSignatureEditorFragment$1((List) obj);
                }
            }, new Consumer() { // from class: com.pspdfkit.ui.signatures.ElectronicSignatureFragment$$ExternalSyntheticLambda3
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Object obj) {
                    PdfLog.e(ElectronicSignatureFragment.LOG_TAG, (Throwable) obj, "Failed to retrieve signatures from the signature storage.", new Object[0]);
                }
            });
            return;
        }
        pf pfVar2 = this.electronicSignatureDialog;
        List<Signature> list = Collections.EMPTY_LIST;
        if (list == null) {
            pfVar2.b = list;
            return;
        }
        qf qfVar = pfVar2.d;
        if (qfVar != null) {
            qfVar.setItems(list);
        } else {
            pfVar2.b = list;
        }
    }

    public void finish() {
        pf pfVar = this.electronicSignatureDialog;
        if (pfVar != null) {
            pfVar.dismiss();
            this.electronicSignatureDialog = null;
        }
        h60.a(new Runnable() { // from class: com.pspdfkit.ui.signatures.ElectronicSignatureFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$finish$0();
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        ElectronicSignatureOptions electronicSignatureOptions;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && (electronicSignatureOptions = (ElectronicSignatureOptions) arguments.getParcelable(STATE_SIGNATURE_OPTIONS)) != null) {
            this.signatureOptions = electronicSignatureOptions;
        }
        if (bundle != null) {
            onRestoreInstanceState(bundle);
        }
        FragmentManager parentFragmentManager = getParentFragmentManager();
        x10 x10Var = this.signatureDialogListener;
        ElectronicSignatureOptions electronicSignatureOptionsCreateAndEvaluateSignatureOptions = createAndEvaluateSignatureOptions();
        int i = pf.e;
        parentFragmentManager.getClass();
        x10Var.getClass();
        electronicSignatureOptionsCreateAndEvaluateSignatureOptions.getClass();
        pf pfVar = (pf) parentFragmentManager.findFragmentByTag("com.pspdfkit.ui.dialog.signatures.ElectronicSignatureDialog.FRAGMENT_TAG");
        if (pfVar != null) {
            pfVar.a = x10Var;
            pfVar.c = electronicSignatureOptionsCreateAndEvaluateSignatureOptions;
        }
        this.electronicSignatureDialog = pfVar;
        if (pfVar == null && this.waitingForSignatureToBePicked) {
            showSignatureEditorFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        yz.a(this.storingSignaturesDisposable);
        yz.a(this.deletingSignaturesDisposable);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(STATE_WAITING_FOR_SIGNATURE_PICKER_DIALOG, this.waitingForSignatureToBePicked);
        bundle.putParcelable(STATE_SIGNATURE_OPTIONS, this.signatureOptions);
        bundle.putBoolean(STATE_SIGNATURE_STORAGE_AVAILABILITY, this.isSignatureStorageAvailable);
    }

    public void setOnSignaturePickedListener(OnSignaturePickedListener onSignaturePickedListener) {
        this.listener = onSignaturePickedListener;
    }

    public static void restore(FragmentManager fragmentManager, OnSignaturePickedListener onSignaturePickedListener) {
        restore(fragmentManager, onSignaturePickedListener, null);
    }

    public static void show(FragmentManager fragmentManager, OnSignaturePickedListener onSignaturePickedListener) {
        show(fragmentManager, onSignaturePickedListener, null, null);
    }
}
