package com.box.android.capture.imagecapture.logic;

import android.location.Location;
import androidx.camera.core.ImageCapture;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ImageMetadataHelper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\tH\u0087@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/capture/imagecapture/logic/ImageMetadataHelper;", "", "<init>", "()V", "getMetadata", "Landroidx/camera/core/ImageCapture$Metadata;", "saveGpsLocation", "", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "(ZLcom/google/android/gms/location/FusedLocationProviderClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocationSync", "Landroid/location/Location;", "(Lcom/google/android/gms/location/FusedLocationProviderClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImageMetadataHelper {
    public static final int $stable = 0;
    public static final ImageMetadataHelper INSTANCE = new ImageMetadataHelper();

    /* JADX INFO: renamed from: com.box.android.capture.imagecapture.logic.ImageMetadataHelper$getMetadata$1, reason: invalid class name */
    /* JADX INFO: compiled from: ImageMetadataHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.imagecapture.logic.ImageMetadataHelper", f = "ImageMetadataHelper.kt", i = {0, 0, 0}, l = {16}, m = "getMetadata", n = {"fusedLocationClient", "metadata", "saveGpsLocation"}, s = {"L$0", "L$1", "Z$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ImageMetadataHelper.this.getMetadata(false, null, this);
        }
    }

    private ImageMetadataHelper() {
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getMetadata(boolean z, FusedLocationProviderClient fusedLocationProviderClient, Continuation<? super ImageCapture.Metadata> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z2 = anonymousClass1.Z$0;
            ImageCapture.Metadata metadata = (ImageCapture.Metadata) anonymousClass1.L$1;
            ResultKt.throwOnFailure(obj);
            return metadata;
        }
        ResultKt.throwOnFailure(obj);
        ImageCapture.Metadata metadata2 = new ImageCapture.Metadata();
        if (z) {
            CoroutineDispatcher io2 = Dispatchers.getIO();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(metadata2, fusedLocationProviderClient, null);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(fusedLocationProviderClient);
            anonymousClass1.L$1 = metadata2;
            anonymousClass1.Z$0 = z;
            anonymousClass1.label = 1;
            if (BuildersKt.withContext(io2, anonymousClass2, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return metadata2;
    }

    /* JADX INFO: renamed from: com.box.android.capture.imagecapture.logic.ImageMetadataHelper$getMetadata$2, reason: invalid class name */
    /* JADX INFO: compiled from: ImageMetadataHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/camera/core/ImageCapture$Metadata;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.imagecapture.logic.ImageMetadataHelper$getMetadata$2", f = "ImageMetadataHelper.kt", i = {0, 0}, l = {18}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u240", "$i$a$-apply-ImageMetadataHelper$getMetadata$2$1"}, s = {"L$1", "I$0"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageCapture.Metadata>, Object> {
        final /* synthetic */ FusedLocationProviderClient $fusedLocationClient;
        final /* synthetic */ ImageCapture.Metadata $metadata;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ImageCapture.Metadata metadata, FusedLocationProviderClient fusedLocationProviderClient, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$metadata = metadata;
            this.$fusedLocationClient = fusedLocationProviderClient;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$metadata, this.$fusedLocationClient, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImageCapture.Metadata> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ImageCapture.Metadata metadata;
            ImageCapture.Metadata metadata2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ImageCapture.Metadata metadata3 = this.$metadata;
                FusedLocationProviderClient fusedLocationProviderClient = this.$fusedLocationClient;
                ImageMetadataHelper imageMetadataHelper = ImageMetadataHelper.INSTANCE;
                this.L$0 = metadata3;
                this.L$1 = SpillingKt.nullOutSpilledVariable(metadata3);
                this.L$2 = metadata3;
                this.I$0 = 0;
                this.label = 1;
                Object locationSync = imageMetadataHelper.getLocationSync(fusedLocationProviderClient, this);
                if (locationSync == coroutine_suspended) {
                    return coroutine_suspended;
                }
                metadata = metadata3;
                obj = locationSync;
                metadata2 = metadata;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                metadata = (ImageCapture.Metadata) this.L$2;
                metadata2 = (ImageCapture.Metadata) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            metadata.setLocation((Location) obj);
            return metadata2;
        }
    }

    public final Object getLocationSync(FusedLocationProviderClient fusedLocationProviderClient, Continuation<? super Location> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        Task<Location> lastLocation = fusedLocationProviderClient.getLastLocation();
        final Function1<Location, Unit> function1 = new Function1<Location, Unit>() { // from class: com.box.android.capture.imagecapture.logic.ImageMetadataHelper$getLocationSync$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Location location) {
                invoke2(location);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Location location) {
                Continuation<Location> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m14780constructorimpl(location));
            }
        };
        lastLocation.addOnSuccessListener(new OnSuccessListener(function1) { // from class: com.box.android.capture.imagecapture.logic.ImageMetadataHelper$sam$com_google_android_gms_tasks_OnSuccessListener$0
            private final /* synthetic */ Function1 function;

            {
                Intrinsics.checkNotNullParameter(function1, "function");
                this.function = function1;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final /* synthetic */ void onSuccess(Object obj) {
                this.function.invoke(obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.box.android.capture.imagecapture.logic.ImageMetadataHelper$getLocationSync$2$2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Continuation<Location> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m14780constructorimpl(null));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
