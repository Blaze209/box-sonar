package com.geniusscansdk.scanflow;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.IntentCompat;
import androidx.core.os.BundleCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.media3.common.MimeTypes;
import com.box.android.data.api.models.annotations.Location;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.geniusscansdk.R;
import com.geniusscansdk.core.GeniusScanSDK;
import com.geniusscansdk.core.LicenseException;
import com.geniusscansdk.core.LicenseKeyInitializer;
import com.geniusscansdk.core.LicenseKeyRefresher;
import com.geniusscansdk.core.LicenseKeySetter;
import com.geniusscansdk.core.Logger;
import com.geniusscansdk.core.SessionLicenseKeyHolder;
import com.geniusscansdk.ocr.OcrLanguage;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: ScanActivity.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010&\u001a\u00020$H\u0002J\u0012\u0010'\u001a\u00020 2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020\"H\u0016J\b\u0010,\u001a\u00020 H\u0002J\b\u0010-\u001a\u00020 H\u0002J\b\u0010.\u001a\u00020 H\u0002J\u0018\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020\fH\u0080@¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\u0015H\u0000¢\u0006\u0002\b4J\r\u00105\u001a\u00020 H\u0000¢\u0006\u0002\b6J\u0010\u0010;\u001a\u00020 2\u0006\u00100\u001a\u00020\fH\u0002J\u0018\u0010<\u001a\u00020 2\u0006\u00100\u001a\u00020\fH\u0080@¢\u0006\u0004\b=\u00102J\u0010\u0010>\u001a\u00020 2\u0006\u00100\u001a\u00020\fH\u0002J\u001f\u0010?\u001a\u00020 2\u0006\u00100\u001a\u00020\f2\b\b\u0002\u0010>\u001a\u00020\u0015H\u0000¢\u0006\u0002\b@J\b\u0010A\u001a\u00020$H\u0002J\b\u0010B\u001a\u00020 H\u0002J\b\u0010C\u001a\u00020$H\u0002J\b\u0010D\u001a\u00020 H\u0002J\n\u0010E\u001a\u0004\u0018\u00010FH\u0002J\r\u0010G\u001a\u00020 H\u0000¢\u0006\u0002\bHJ\b\u0010I\u001a\u00020 H\u0002J\u0012\u0010J\u001a\u00020 2\b\u0010K\u001a\u0004\u0018\u00010LH\u0002J\u0015\u0010M\u001a\u00020 2\u0006\u0010N\u001a\u00020OH\u0000¢\u0006\u0002\bPR\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\u0002088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006R"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "scanConfiguration", "Lcom/geniusscansdk/scanflow/ScanConfiguration;", "getScanConfiguration", "()Lcom/geniusscansdk/scanflow/ScanConfiguration;", "scanConfiguration$delegate", "Lkotlin/Lazy;", SupportedFileExtensions.PAGES_EXTENSION, "", "Lcom/geniusscansdk/scanflow/Page;", "imageStore", "Lcom/geniusscansdk/scanflow/ImageStore;", "ocrBackgroundProcessor", "Lcom/geniusscansdk/scanflow/OcrBackgroundProcessor;", "pickMediaLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroidx/activity/result/PickVisualMediaRequest;", "scanInProgress", "", "progressBar", "Landroid/widget/ProgressBar;", "pageProcessor", "Lcom/geniusscansdk/scanflow/PageProcessor;", "getPageProcessor", "()Lcom/geniusscansdk/scanflow/PageProcessor;", "pageProcessor$delegate", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "refreshLicenseKey", "Lkotlinx/coroutines/Job;", "checkValidConfiguration", "preloadStructuredDataOCRModel", "onPhotoPicked", "uri", "Landroid/net/Uri;", "onSaveInstanceState", "outState", "setJpegQuality", "applyCustomStyle", "displayCameraFragment", "onPageScanned", Location.TYPE_PAGE, "onPageScanned$gssdk_release", "(Lcom/geniusscansdk/scanflow/Page;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canAddPage", "canAddPage$gssdk_release", "onScanFlowValidated", "onScanFlowValidated$gssdk_release", "pageCount", "", "getPageCount$gssdk_release", "()I", "displayPostProcessingFragment", "processPage", "processPage$gssdk_release", "addPage", "onPostProcessingFragmentFinished", "onPostProcessingFragmentFinished$gssdk_release", "scanFromImageUrl", "scanFromPhotoPicker", "finishScanFlow", "handleBackPress", "getCameraFragment", "Lcom/geniusscansdk/scanflow/CameraFragment;", "confirmDiscard", "confirmDiscard$gssdk_release", "discardPages", "finishWithResult", "scanResult", "Lcom/geniusscansdk/scanflow/ScanResult;", "finishWithError", "t", "", "finishWithError$gssdk_release", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScanActivity extends AppCompatActivity {
    private static final String PAGES = "PAGES";
    private static final String SCAN_IN_PROGRESS = "SCAN_IN_PROGRESS";
    private ImageStore imageStore;
    private OcrBackgroundProcessor ocrBackgroundProcessor;
    private ActivityResultLauncher<PickVisualMediaRequest> pickMediaLauncher;
    private ProgressBar progressBar;
    private boolean scanInProgress;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<String> SUPPORTED_IMAGE_MIME_TYPES = CollectionsKt.listOf((Object[]) new String[]{MimeTypes.IMAGE_JPEG, MimeTypes.IMAGE_PNG});

    /* JADX INFO: renamed from: scanConfiguration$delegate, reason: from kotlin metadata */
    private final Lazy scanConfiguration = LazyKt.lazy(new Function0() { // from class: com.geniusscansdk.scanflow.ScanActivity$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ScanActivity.scanConfiguration_delegate$lambda$0(this.f$0);
        }
    });
    private List<Page> pages = new ArrayList();

    /* JADX INFO: renamed from: pageProcessor$delegate, reason: from kotlin metadata */
    private final Lazy pageProcessor = LazyKt.lazy(new Function0() { // from class: com.geniusscansdk.scanflow.ScanActivity$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ScanActivity.pageProcessor_delegate$lambda$1(this.f$0);
        }
    });
    private final CoroutineExceptionHandler exceptionHandler = new ScanActivity$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this);

    /* JADX INFO: compiled from: ScanActivity.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScanConfiguration.Source.values().length];
            try {
                iArr[ScanConfiguration.Source.CAMERA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScanConfiguration.Source.IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScanConfiguration.Source.GALLERY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScanConfiguration getScanConfiguration() {
        return (ScanConfiguration) this.scanConfiguration.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScanConfiguration scanConfiguration_delegate$lambda$0(ScanActivity scanActivity) {
        ScanConfiguration scanConfiguration = (ScanConfiguration) IntentCompat.getSerializableExtra(scanActivity.getIntent(), ScanFlow.SCAN_CONFIGURATION_KEY, ScanConfiguration.class);
        if (scanConfiguration != null) {
            return scanConfiguration;
        }
        throw new NullPointerException("Impossible to retrieve scan scanConfiguration");
    }

    private final PageProcessor getPageProcessor() {
        return (PageProcessor) this.pageProcessor.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PageProcessor pageProcessor_delegate$lambda$1(ScanActivity scanActivity) {
        return new PageProcessor(scanActivity, scanActivity.getScanConfiguration());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        EdgeToEdge.enable$default(this, null, null, 3, null);
        try {
            GeniusScanSDK.checkInitialization();
        } catch (LicenseException e) {
            finishWithError$gssdk_release(e);
        }
        refreshLicenseKey();
        ActivityExtKt.lockOrientationToPortraitOnPhones(this);
        checkValidConfiguration(getScanConfiguration());
        OnBackPressedDispatcherKt.addCallback$default(getOnBackPressedDispatcher(), null, false, new Function1() { // from class: com.geniusscansdk.scanflow.ScanActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScanActivity.onCreate$lambda$3(this.f$0, (OnBackPressedCallback) obj);
            }
        }, 3, null);
        if (bundle != null) {
            ArrayList parcelableArrayList = BundleCompat.getParcelableArrayList(bundle, PAGES, Page.class);
            Intrinsics.checkNotNull(parcelableArrayList);
            this.pages = parcelableArrayList;
            this.scanInProgress = bundle.getBoolean(SCAN_IN_PROGRESS);
        }
        ScanActivity scanActivity = this;
        this.imageStore = new ImageStore(scanActivity);
        setContentView(R.layout.scan_activity);
        applyCustomStyle();
        setJpegQuality();
        this.progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        ScanConfiguration.OcrConfiguration ocrConfiguration = getScanConfiguration().ocrConfiguration;
        if (ocrConfiguration != null) {
            this.ocrBackgroundProcessor = new OcrBackgroundProcessor(scanActivity, ocrConfiguration, LifecycleOwnerKt.getLifecycleScope(this));
        }
        preloadStructuredDataOCRModel();
        this.pickMediaLauncher = registerForActivityResult(new CustomPickImageContract(SUPPORTED_IMAGE_MIME_TYPES), new ActivityResultCallback() { // from class: com.geniusscansdk.scanflow.ScanActivity$$ExternalSyntheticLambda1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.f$0.onPhotoPicked((Uri) obj);
            }
        });
        View viewFindViewById = findViewById(R.id.container);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.FrameLayout");
        if (((FrameLayout) viewFindViewById).getChildCount() <= 1 && !this.scanInProgress) {
            this.scanInProgress = true;
            int i = WhenMappings.$EnumSwitchMapping$0[getScanConfiguration().source.ordinal()];
            if (i == 1) {
                displayCameraFragment();
            } else if (i == 2) {
                scanFromImageUrl();
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                scanFromPhotoPicker();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$3(ScanActivity scanActivity, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        scanActivity.handleBackPress();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.ScanActivity$refreshLicenseKey$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScanActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.ScanActivity$refreshLicenseKey$1", f = "ScanActivity.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
    static final class C17951 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C17951(Continuation<? super C17951> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ScanActivity.this.new C17951(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C17951) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LicenseKeySetter licenseKeySetter = null;
                Logger logger = null;
                LicenseKeyRefresher licenseKeyRefresher = null;
                CoroutineScope coroutineScope = null;
                SessionLicenseKeyHolder sessionLicenseKeyHolder = null;
                this.label = 1;
                if (new LicenseKeyInitializer(ScanActivity.this, licenseKeySetter, logger, licenseKeyRefresher, coroutineScope, sessionLicenseKeyHolder, 62, null).refreshAndInitializeInScanFlow(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final Job refreshLicenseKey() {
        return BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C17951(null), 3, null);
    }

    private final void checkValidConfiguration(ScanConfiguration scanConfiguration) {
        List<String> list;
        if (scanConfiguration.ocrConfiguration == null) {
            return;
        }
        List<OcrLanguage> allLanguages = OcrLanguage.INSTANCE.getAllLanguages(this);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(allLanguages, 10));
        Iterator<T> it = allLanguages.iterator();
        while (it.hasNext()) {
            arrayList.add(((OcrLanguage) it.next()).getTag());
        }
        HashSet hashSet = CollectionsKt.toHashSet(arrayList);
        ScanConfiguration.OcrConfiguration ocrConfiguration = scanConfiguration.ocrConfiguration;
        if (ocrConfiguration == null || (list = ocrConfiguration.languages) == null) {
            return;
        }
        for (String str : list) {
            if (!hashSet.contains(str)) {
                finishWithError$gssdk_release(new IllegalArgumentException(str + " is not a valid tag. Please refer to the documentation for valid language tags."));
            }
        }
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.ScanActivity$preloadStructuredDataOCRModel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScanActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.ScanActivity$preloadStructuredDataOCRModel$1", f = "ScanActivity.kt", i = {}, l = {129}, m = "invokeSuspend", n = {}, s = {})
    static final class C17941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C17941(Continuation<? super C17941> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ScanActivity.this.new C17941(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C17941) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ScanActivity scanActivity = ScanActivity.this;
                this.label = 1;
                if (new StructuredDataProcessor(scanActivity, scanActivity.getScanConfiguration()).preloadModelsIfNeeded(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final Job preloadStructuredDataOCRModel() {
        return BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C17941(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPhotoPicked(Uri uri) {
        if (uri != null) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), this.exceptionHandler, null, new C17931(uri, null), 2, null);
        } else {
            setResult(0, new Intent());
            finish();
        }
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.ScanActivity$onPhotoPicked$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScanActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.ScanActivity$onPhotoPicked$1", f = "ScanActivity.kt", i = {}, l = {Token.SET_REF_OP, Token.DOTDOT, 150}, m = "invokeSuspend", n = {}, s = {})
    static final class C17931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Uri $uri;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C17931(Uri uri, Continuation<? super C17931> continuation) {
            super(2, continuation);
            this.$uri = uri;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ScanActivity.this.new C17931(this.$uri, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C17931) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x007a, code lost:
        
            if (r1.onPageScanned$gssdk_release((com.geniusscansdk.scanflow.Page) r10, r9) == r0) goto L23;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                java.lang.String r2 = "progressBar"
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                if (r1 == 0) goto L29
                if (r1 == r5) goto L25
                if (r1 == r4) goto L21
                if (r1 != r3) goto L19
                kotlin.ResultKt.throwOnFailure(r10)
                goto L7d
            L19:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L21:
                kotlin.ResultKt.throwOnFailure(r10)
                goto L6d
            L25:
                kotlin.ResultKt.throwOnFailure(r10)
                goto L50
            L29:
                kotlin.ResultKt.throwOnFailure(r10)
                com.geniusscansdk.scanflow.ScanActivity r10 = com.geniusscansdk.scanflow.ScanActivity.this
                android.widget.ProgressBar r10 = com.geniusscansdk.scanflow.ScanActivity.access$getProgressBar$p(r10)
                if (r10 != 0) goto L38
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
                r10 = r6
            L38:
                r1 = 0
                r10.setVisibility(r1)
                com.geniusscansdk.scanflow.ImageImporter r10 = com.geniusscansdk.scanflow.ImageImporter.INSTANCE
                android.net.Uri r1 = r9.$uri
                com.geniusscansdk.scanflow.ScanActivity r7 = com.geniusscansdk.scanflow.ScanActivity.this
                android.content.Context r7 = (android.content.Context) r7
                r8 = r9
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r9.label = r5
                java.lang.Object r10 = r10.copyImageToFile(r1, r7, r8)
                if (r10 != r0) goto L50
                goto L7c
            L50:
                java.io.File r10 = (java.io.File) r10
                kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()
                kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
                com.geniusscansdk.scanflow.ScanActivity$onPhotoPicked$1$page$1 r5 = new com.geniusscansdk.scanflow.ScanActivity$onPhotoPicked$1$page$1
                com.geniusscansdk.scanflow.ScanActivity r7 = com.geniusscansdk.scanflow.ScanActivity.this
                r5.<init>(r10, r7, r6)
                kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
                r10 = r9
                kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
                r9.label = r4
                java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r1, r5, r10)
                if (r10 != r0) goto L6d
                goto L7c
            L6d:
                com.geniusscansdk.scanflow.Page r10 = (com.geniusscansdk.scanflow.Page) r10
                com.geniusscansdk.scanflow.ScanActivity r1 = com.geniusscansdk.scanflow.ScanActivity.this
                r4 = r9
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r9.label = r3
                java.lang.Object r10 = r1.onPageScanned$gssdk_release(r10, r4)
                if (r10 != r0) goto L7d
            L7c:
                return r0
            L7d:
                com.geniusscansdk.scanflow.ScanActivity r9 = com.geniusscansdk.scanflow.ScanActivity.this
                android.widget.ProgressBar r9 = com.geniusscansdk.scanflow.ScanActivity.access$getProgressBar$p(r9)
                if (r9 != 0) goto L89
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
                goto L8a
            L89:
                r6 = r9
            L8a:
                r9 = 8
                r6.setVisibility(r9)
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.geniusscansdk.scanflow.ScanActivity.C17931.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onMAMSaveInstanceState(outState);
        outState.putParcelableArrayList(PAGES, new ArrayList<>(this.pages));
        outState.putBoolean(SCAN_IN_PROGRESS, this.scanInProgress);
    }

    private final void setJpegQuality() {
        int i = getScanConfiguration().jpegQuality;
        if (i < 0 || i > 100) {
            finishWithError$gssdk_release(new IllegalArgumentException("JPEG quality must be between 0 and 100"));
        } else {
            GeniusScanSDK.setJPGQuality(i);
        }
    }

    private final void applyCustomStyle() {
        getWindow().getDecorView().setBackgroundColor(getScanConfiguration().backgroundColor);
        boolean z = !ViewUtils.INSTANCE.isColorDark(getScanConfiguration().backgroundColor);
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        windowInsetsControllerCompat.setAppearanceLightStatusBars(z);
        windowInsetsControllerCompat.setAppearanceLightNavigationBars(z);
    }

    private final void displayCameraFragment() {
        getSupportFragmentManager().popBackStack((String) null, 1);
        if (getSupportFragmentManager().findFragmentByTag("cameraFragment") == null) {
            CameraFragment cameraFragmentNewInstance = CameraFragment.INSTANCE.newInstance(getScanConfiguration());
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
            fragmentTransactionBeginTransaction.replace(R.id.container, cameraFragmentNewInstance, "cameraFragment");
            fragmentTransactionBeginTransaction.commit();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object onPageScanned$gssdk_release(Page page, Continuation<? super Unit> continuation) {
        ScanActivity$onPageScanned$1 scanActivity$onPageScanned$1;
        if (continuation instanceof ScanActivity$onPageScanned$1) {
            scanActivity$onPageScanned$1 = (ScanActivity$onPageScanned$1) continuation;
            if ((scanActivity$onPageScanned$1.label & Integer.MIN_VALUE) != 0) {
                scanActivity$onPageScanned$1.label -= Integer.MIN_VALUE;
            } else {
                scanActivity$onPageScanned$1 = new ScanActivity$onPageScanned$1(this, continuation);
            }
        } else {
            scanActivity$onPageScanned$1 = new ScanActivity$onPageScanned$1(this, continuation);
        }
        Object obj = scanActivity$onPageScanned$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = scanActivity$onPageScanned$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            scanActivity$onPageScanned$1.L$0 = this;
            scanActivity$onPageScanned$1.L$1 = page;
            scanActivity$onPageScanned$1.label = 1;
            if (processPage$gssdk_release(page, scanActivity$onPageScanned$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            page = (Page) scanActivity$onPageScanned$1.L$1;
            this = (ScanActivity) scanActivity$onPageScanned$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (!this.getScanConfiguration().skipPostProcessingScreen) {
            this.displayPostProcessingFragment(page);
            return Unit.INSTANCE;
        }
        this.addPage(page);
        if (this.canAddPage$gssdk_release()) {
            CameraFragment cameraFragment = this.getCameraFragment();
            if (cameraFragment == null) {
                throw new NullPointerException("Impossible to retrieve camera fragment");
            }
            cameraFragment.resetCamera$gssdk_release();
            return Unit.INSTANCE;
        }
        this.finishScanFlow();
        return Unit.INSTANCE;
    }

    public final boolean canAddPage$gssdk_release() {
        return getScanConfiguration().source == ScanConfiguration.Source.CAMERA && getScanConfiguration().multiPage;
    }

    public final void onScanFlowValidated$gssdk_release() {
        finishScanFlow();
    }

    public final int getPageCount$gssdk_release() {
        return this.pages.size();
    }

    private final void displayPostProcessingFragment(Page page) {
        PostProcessingFragment postProcessingFragmentNewInstance = PostProcessingFragment.Companion.newInstance(page, getScanConfiguration());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.container, postProcessingFragmentNewInstance);
        if (getScanConfiguration().source == ScanConfiguration.Source.CAMERA) {
            fragmentTransactionBeginTransaction.addToBackStack(null);
        }
        fragmentTransactionBeginTransaction.commit();
    }

    public final Object processPage$gssdk_release(Page page, Continuation<? super Unit> continuation) {
        Object objProcessPage = getPageProcessor().processPage(page, continuation);
        return objProcessPage == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessPage : Unit.INSTANCE;
    }

    private final void addPage(Page page) {
        this.pages.add(page);
        OcrBackgroundProcessor ocrBackgroundProcessor = this.ocrBackgroundProcessor;
        if (ocrBackgroundProcessor != null) {
            ocrBackgroundProcessor.addPage(page);
        }
    }

    public static /* synthetic */ void onPostProcessingFragmentFinished$gssdk_release$default(ScanActivity scanActivity, Page page, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        scanActivity.onPostProcessingFragmentFinished$gssdk_release(page, z);
    }

    public final void onPostProcessingFragmentFinished$gssdk_release(Page page, boolean addPage) {
        Intrinsics.checkNotNullParameter(page, "page");
        addPage(page);
        if (canAddPage$gssdk_release() && addPage) {
            displayCameraFragment();
        } else {
            finishScanFlow();
        }
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.ScanActivity$scanFromImageUrl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScanActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.ScanActivity$scanFromImageUrl$1", f = "ScanActivity.kt", i = {}, l = {256, 263}, m = "invokeSuspend", n = {}, s = {})
    static final class C17961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C17961(Continuation<? super C17961> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ScanActivity.this.new C17961(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C17961) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0067, code lost:
        
            if (r1.onPageScanned$gssdk_release((com.geniusscansdk.scanflow.Page) r9, r8) == r0) goto L20;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                java.lang.String r2 = "progressBar"
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L22
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                kotlin.ResultKt.throwOnFailure(r9)
                goto L6a
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L1e:
                kotlin.ResultKt.throwOnFailure(r9)
                goto L5a
            L22:
                kotlin.ResultKt.throwOnFailure(r9)
                com.geniusscansdk.scanflow.ScanActivity r9 = com.geniusscansdk.scanflow.ScanActivity.this
                android.widget.ProgressBar r9 = com.geniusscansdk.scanflow.ScanActivity.access$getProgressBar$p(r9)
                if (r9 != 0) goto L31
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
                r9 = r5
            L31:
                r1 = 0
                r9.setVisibility(r1)
                com.geniusscansdk.scanflow.ScanActivity r9 = com.geniusscansdk.scanflow.ScanActivity.this
                com.geniusscansdk.scanflow.ScanConfiguration r9 = com.geniusscansdk.scanflow.ScanActivity.access$getScanConfiguration(r9)
                java.io.File r9 = r9.sourceImage
                if (r9 == 0) goto L7f
                kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()
                kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
                com.geniusscansdk.scanflow.ScanActivity$scanFromImageUrl$1$page$1 r6 = new com.geniusscansdk.scanflow.ScanActivity$scanFromImageUrl$1$page$1
                com.geniusscansdk.scanflow.ScanActivity r7 = com.geniusscansdk.scanflow.ScanActivity.this
                r6.<init>(r7, r9, r5)
                kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
                r9 = r8
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                r8.label = r4
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r1, r6, r9)
                if (r9 != r0) goto L5a
                goto L69
            L5a:
                com.geniusscansdk.scanflow.Page r9 = (com.geniusscansdk.scanflow.Page) r9
                com.geniusscansdk.scanflow.ScanActivity r1 = com.geniusscansdk.scanflow.ScanActivity.this
                r4 = r8
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r8.label = r3
                java.lang.Object r9 = r1.onPageScanned$gssdk_release(r9, r4)
                if (r9 != r0) goto L6a
            L69:
                return r0
            L6a:
                com.geniusscansdk.scanflow.ScanActivity r8 = com.geniusscansdk.scanflow.ScanActivity.this
                android.widget.ProgressBar r8 = com.geniusscansdk.scanflow.ScanActivity.access$getProgressBar$p(r8)
                if (r8 != 0) goto L76
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
                goto L77
            L76:
                r5 = r8
            L77:
                r8 = 8
                r5.setVisibility(r8)
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            L7f:
                java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                java.lang.String r9 = "A source image must be provided in the configuration when source=IMAGE"
                r8.<init>(r9)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.geniusscansdk.scanflow.ScanActivity.C17961.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Job scanFromImageUrl() {
        return BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), this.exceptionHandler, null, new C17961(null), 2, null);
    }

    private final void scanFromPhotoPicker() {
        ActivityResultLauncher<PickVisualMediaRequest> activityResultLauncher = this.pickMediaLauncher;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickMediaLauncher");
            activityResultLauncher = null;
        }
        activityResultLauncher.launch(CustomPickImageContract.INSTANCE.createRequest());
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.ScanActivity$finishScanFlow$1, reason: invalid class name */
    /* JADX INFO: compiled from: ScanActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.ScanActivity$finishScanFlow$1", f = "ScanActivity.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ScanActivity.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ScanActivity scanActivity = ScanActivity.this;
                ScanActivity scanActivity2 = scanActivity;
                OcrBackgroundProcessor ocrBackgroundProcessor = scanActivity.ocrBackgroundProcessor;
                ImageStore imageStore = ScanActivity.this.imageStore;
                if (imageStore == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageStore");
                    imageStore = null;
                }
                this.label = 1;
                obj = new ResultPreparation(scanActivity2, ocrBackgroundProcessor, imageStore, ScanActivity.this.getScanConfiguration()).prepareResult(ScanActivity.this.pages, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ScanActivity.this.finishWithResult((ScanResult) obj);
            return Unit.INSTANCE;
        }
    }

    private final Job finishScanFlow() {
        return BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), this.exceptionHandler, null, new AnonymousClass1(null), 2, null);
    }

    private final void handleBackPress() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getOnBackPressedDispatcher().onBackPressed();
        } else {
            confirmDiscard$gssdk_release();
        }
    }

    private final CameraFragment getCameraFragment() {
        return (CameraFragment) getSupportFragmentManager().findFragmentByTag("cameraFragment");
    }

    public final void confirmDiscard$gssdk_release() {
        CameraFragment cameraFragment = getCameraFragment();
        if (cameraFragment != null) {
            cameraFragment.setRealTimeDetectionEnabled$gssdk_release(false);
        }
        if (this.pages.isEmpty()) {
            finish();
        } else {
            new MaterialAlertDialogBuilder(this).setMessage((CharSequence) getResources().getQuantityString(R.plurals.gssdk_flow_confirm_cancellation, this.pages.size(), Integer.valueOf(this.pages.size()))).setNegativeButton(R.string.gssdk_action_cancel, new DialogInterface.OnClickListener() { // from class: com.geniusscansdk.scanflow.ScanActivity$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ScanActivity.confirmDiscard$lambda$10(this.f$0, dialogInterface, i);
                }
            }).setPositiveButton(R.string.gssdk_action_discard, new DialogInterface.OnClickListener() { // from class: com.geniusscansdk.scanflow.ScanActivity$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ScanActivity.confirmDiscard$lambda$11(this.f$0, dialogInterface, i);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void confirmDiscard$lambda$10(ScanActivity scanActivity, DialogInterface dialogInterface, int i) {
        CameraFragment cameraFragment = scanActivity.getCameraFragment();
        if (cameraFragment != null) {
            cameraFragment.setRealTimeDetectionEnabled$gssdk_release(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void confirmDiscard$lambda$11(ScanActivity scanActivity, DialogInterface dialogInterface, int i) {
        scanActivity.discardPages();
        scanActivity.finish();
    }

    private final void discardPages() {
        Iterator<T> it = this.pages.iterator();
        while (it.hasNext()) {
            ((Page) it.next()).deleteImages();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishWithResult(ScanResult scanResult) {
        this.scanInProgress = false;
        Intent intent = new Intent();
        intent.putExtra(ScanFlow.SCAN_RESULT_KEY, scanResult);
        setResult(-1, intent);
        finish();
    }

    public final void finishWithError$gssdk_release(Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        this.scanInProgress = false;
        Intent intent = new Intent();
        intent.putExtra(ScanFlow.ERROR_KEY, t);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: compiled from: ScanActivity.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanActivity$Companion;", "", "<init>", "()V", ScanActivity.SCAN_IN_PROGRESS, "", ScanActivity.PAGES, "SUPPORTED_IMAGE_MIME_TYPES", "", "getSUPPORTED_IMAGE_MIME_TYPES", "()Ljava/util/List;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<String> getSUPPORTED_IMAGE_MIME_TYPES() {
            return ScanActivity.SUPPORTED_IMAGE_MIME_TYPES;
        }
    }
}
