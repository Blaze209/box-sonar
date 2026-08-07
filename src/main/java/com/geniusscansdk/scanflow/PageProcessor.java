package com.geniusscansdk.scanflow;

import android.content.Context;
import android.graphics.Bitmap;
import com.box.android.data.api.models.annotations.Location;
import com.facebook.react.uimanager.ViewProps;
import com.geniusscansdk.core.GeniusScanSDK;
import com.geniusscansdk.core.LicenseException;
import com.geniusscansdk.core.ProcessingException;
import com.geniusscansdk.core.Quadrangle;
import com.geniusscansdk.core.RotationAngle;
import com.geniusscansdk.core.ScanProcessor;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: PageProcessor.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/geniusscansdk/scanflow/PageProcessor;", "", "imageStore", "Lcom/geniusscansdk/scanflow/ImageStore;", "scanProcessor", "Lcom/geniusscansdk/core/ScanProcessor;", "scanConfiguration", "Lcom/geniusscansdk/scanflow/ScanConfiguration;", "<init>", "(Lcom/geniusscansdk/scanflow/ImageStore;Lcom/geniusscansdk/core/ScanProcessor;Lcom/geniusscansdk/scanflow/ScanConfiguration;)V", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lcom/geniusscansdk/scanflow/ScanConfiguration;)V", "processPage", "", Location.TYPE_PAGE, "Lcom/geniusscansdk/scanflow/Page;", "(Lcom/geniusscansdk/scanflow/Page;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processImageWithFilter", "Landroid/graphics/Bitmap;", ViewProps.FILTER, "Lcom/geniusscansdk/scanflow/ScanConfiguration$Filter;", "inBitmap", "(Lcom/geniusscansdk/scanflow/Page;Lcom/geniusscansdk/scanflow/ScanConfiguration$Filter;Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PageProcessor {
    private final ImageStore imageStore;
    private final ScanConfiguration scanConfiguration;
    private final ScanProcessor scanProcessor;

    public PageProcessor(ImageStore imageStore, ScanProcessor scanProcessor, ScanConfiguration scanConfiguration) {
        Intrinsics.checkNotNullParameter(imageStore, "imageStore");
        Intrinsics.checkNotNullParameter(scanProcessor, "scanProcessor");
        Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
        this.imageStore = imageStore;
        this.scanProcessor = scanProcessor;
        this.scanConfiguration = scanConfiguration;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PageProcessor(Context context, ScanConfiguration scanConfiguration) {
        this(new ImageStore(context), new ScanProcessor(context), scanConfiguration);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.PageProcessor$processPage$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PageProcessor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.PageProcessor$processPage$2", f = "PageProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C17852 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Page $page;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C17852(Page page, Continuation<? super C17852> continuation) {
            super(2, continuation);
            this.$page = page;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PageProcessor.this.new C17852(this.$page, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C17852) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws LicenseException, ProcessingException, IOException {
            ScanProcessor.Rotation rotationNone;
            ScanProcessor.Readability readabilityDisabled;
            ScanProcessor.PerspectiveCorrection perspectiveCorrectionAutomatic;
            Quadrangle quadrangleRotate;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                File imageFolder = PageProcessor.this.imageStore.getImageFolder();
                if (this.$page.getEnhancedImage() == null) {
                    rotationNone = PageProcessor.this.scanConfiguration.defaultScanOrientation.toRotationConfiguration();
                } else {
                    rotationNone = ScanProcessor.Rotation.INSTANCE.none();
                }
                ScanProcessor.Rotation rotation = rotationNone;
                if (PageProcessor.this.scanConfiguration.requiredReadabilityLevel != ScanProcessor.ReadabilityLevel.Lowest && this.$page.getReadabilityLevel() == null) {
                    readabilityDisabled = ScanProcessor.Readability.INSTANCE.enabled();
                } else {
                    readabilityDisabled = ScanProcessor.Readability.INSTANCE.disabled();
                }
                ScanProcessor.Readability readability = readabilityDisabled;
                Quadrangle quadrangle = this.$page.getQuadrangle();
                if (quadrangle == null || (perspectiveCorrectionAutomatic = ScanProcessor.PerspectiveCorrection.INSTANCE.withQuadrangle(quadrangle)) == null) {
                    perspectiveCorrectionAutomatic = ScanProcessor.PerspectiveCorrection.INSTANCE.automatic();
                }
                ScanProcessor.Result<File> resultProcess = PageProcessor.this.scanProcessor.process(this.$page.getOriginalImage(), new ScanProcessor.Configuration<>(perspectiveCorrectionAutomatic, this.$page.getCurvatureCorrectionMode().toCurvatureCorrectionConfiguration(), this.$page.getFilter().toEnhancement(), rotation, readability, ScanProcessor.OutputConfiguration.INSTANCE.file(imageFolder)));
                this.$page.setReadabilityLevel(resultProcess.readabilityLevel);
                this.$page.setEnhancedImage(resultProcess.output);
                RotationAngle rotationAngle = resultProcess.appliedRotation;
                Page page = this.$page;
                if (rotationAngle != RotationAngle.ROTATION_0) {
                    String absolutePath = this.$page.getOriginalImage().getAbsolutePath();
                    Intrinsics.checkNotNull(absolutePath);
                    GeniusScanSDK.rotateImage$default(absolutePath, absolutePath, rotationAngle, false, 8, null);
                    quadrangleRotate = resultProcess.appliedQuadrangle.rotate(rotationAngle);
                } else {
                    quadrangleRotate = resultProcess.appliedQuadrangle;
                }
                page.setQuadrangle(quadrangleRotate);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object processPage(Page page, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new C17852(page, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.PageProcessor$processImageWithFilter$2, reason: invalid class name */
    /* JADX INFO: compiled from: PageProcessor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.PageProcessor$processImageWithFilter$2", f = "PageProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
        final /* synthetic */ ScanConfiguration.Filter $filter;
        final /* synthetic */ Bitmap $inBitmap;
        final /* synthetic */ Page $page;
        int label;
        final /* synthetic */ PageProcessor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Page page, ScanConfiguration.Filter filter, PageProcessor pageProcessor, Bitmap bitmap, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$page = page;
            this.$filter = filter;
            this.this$0 = pageProcessor;
            this.$inBitmap = bitmap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$page, this.$filter, this.this$0, this.$inBitmap, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ScanProcessor.PerspectiveCorrection perspectiveCorrectionNone;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Quadrangle quadrangle = this.$page.getQuadrangle();
            if (quadrangle == null || (perspectiveCorrectionNone = ScanProcessor.PerspectiveCorrection.INSTANCE.withQuadrangle(quadrangle)) == null) {
                perspectiveCorrectionNone = ScanProcessor.PerspectiveCorrection.INSTANCE.none();
            }
            return this.this$0.scanProcessor.process(this.$inBitmap, new ScanProcessor.Configuration<>(perspectiveCorrectionNone, this.$page.getCurvatureCorrectionMode().toCurvatureCorrectionConfiguration(), this.$filter.toEnhancement(), ScanProcessor.Rotation.INSTANCE.none(), null, ScanProcessor.OutputConfiguration.INSTANCE.bitmap(), 16, null)).output;
        }
    }

    public final Object processImageWithFilter(Page page, ScanConfiguration.Filter filter, Bitmap bitmap, Continuation<? super Bitmap> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(page, filter, this, bitmap, null), continuation);
    }
}
