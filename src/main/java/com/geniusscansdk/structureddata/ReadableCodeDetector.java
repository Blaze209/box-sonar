package com.geniusscansdk.structureddata;

import android.content.Context;
import android.net.Uri;
import com.geniusscansdk.core.GeniusScanSDK;
import com.google.android.gms.common.moduleinstall.ModuleInstall;
import com.google.android.gms.common.moduleinstall.ModuleInstallRequest;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.tasks.TasksKt;

/* JADX INFO: compiled from: ReadableCodeDetector.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/geniusscansdk/structureddata/ReadableCodeDetector;", "", "context", "Landroid/content/Context;", "codeTypes", "", "Lcom/geniusscansdk/structureddata/ReadableCode$Type;", "<init>", "(Landroid/content/Context;Ljava/util/Collection;)V", "barcodeScanner", "Lcom/google/mlkit/vision/barcode/BarcodeScanner;", "preloadModels", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detect", "", "Lcom/geniusscansdk/structureddata/ReadableCode;", "imageFile", "Ljava/io/File;", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReadableCodeDetector {
    private final BarcodeScanner barcodeScanner;
    private final Context context;

    /* JADX INFO: renamed from: com.geniusscansdk.structureddata.ReadableCodeDetector$detect$1, reason: invalid class name */
    /* JADX INFO: compiled from: ReadableCodeDetector.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.structureddata.ReadableCodeDetector", f = "ReadableCodeDetector.kt", i = {}, l = {45}, m = "detect", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReadableCodeDetector.this.detect(null, this);
        }
    }

    /* JADX INFO: renamed from: com.geniusscansdk.structureddata.ReadableCodeDetector$preloadModels$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReadableCodeDetector.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.structureddata.ReadableCodeDetector", f = "ReadableCodeDetector.kt", i = {}, l = {34}, m = "preloadModels", n = {}, s = {})
    static final class C17971 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C17971(Continuation<? super C17971> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReadableCodeDetector.this.preloadModels(this);
        }
    }

    public ReadableCodeDetector(Context context, Collection<? extends ReadableCode.Type> collection) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        BarcodeScannerOptions.Builder builder = new BarcodeScannerOptions.Builder();
        if (collection != null && !collection.isEmpty()) {
            Collection<? extends ReadableCode.Type> collection2 = collection;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection2, 10));
            Iterator<T> it = collection2.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((ReadableCode.Type) it.next()).getMlkitFormat()));
            }
            ArrayList arrayList2 = arrayList;
            int iIntValue = ((Number) CollectionsKt.first((List) arrayList2)).intValue();
            int[] intArray = CollectionsKt.toIntArray(CollectionsKt.drop(arrayList2, 1));
            builder.setBarcodeFormats(iIntValue, Arrays.copyOf(intArray, intArray.length));
        }
        this.barcodeScanner = BarcodeScanning.getClient(builder.build());
    }

    public /* synthetic */ ReadableCodeDetector(Context context, Collection collection, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : collection);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object preloadModels(Continuation<? super Unit> continuation) {
        C17971 c17971;
        if (continuation instanceof C17971) {
            c17971 = (C17971) continuation;
            if ((c17971.label & Integer.MIN_VALUE) != 0) {
                c17971.label -= Integer.MIN_VALUE;
            } else {
                c17971 = new C17971(continuation);
            }
        } else {
            c17971 = new C17971(continuation);
        }
        Object objAwait = c17971.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c17971.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwait);
            GeniusScanSDK.getLogger().debug("Making install request for Barcode MLKit module");
            ModuleInstallRequest moduleInstallRequestBuild = ModuleInstallRequest.newBuilder().addApi(this.barcodeScanner).build();
            Intrinsics.checkNotNullExpressionValue(moduleInstallRequestBuild, "build(...)");
            Task<ModuleInstallResponse> taskInstallModules = ModuleInstall.getClient(this.context).installModules(moduleInstallRequestBuild);
            Intrinsics.checkNotNullExpressionValue(taskInstallModules, "installModules(...)");
            c17971.label = 1;
            objAwait = TasksKt.await(taskInstallModules, c17971);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objAwait);
        }
        if (((ModuleInstallResponse) objAwait).areModulesAlreadyInstalled()) {
            GeniusScanSDK.getLogger().debug("Barcode MLKit module is already installed");
        } else {
            GeniusScanSDK.getLogger().debug("Barcode MLKit module install has been requested");
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object detect(File file, Continuation<? super List<ReadableCode>> continuation) throws IOException {
        AnonymousClass1 anonymousClass1;
        ReadableCode.Type next;
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
        Object objAwait = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwait);
            InputImage inputImageFromFilePath = InputImage.fromFilePath(this.context, Uri.fromFile(file));
            Intrinsics.checkNotNullExpressionValue(inputImageFromFilePath, "fromFilePath(...)");
            Task<List<Barcode>> taskProcess = this.barcodeScanner.process(inputImageFromFilePath);
            Intrinsics.checkNotNullExpressionValue(taskProcess, "process(...)");
            anonymousClass1.label = 1;
            objAwait = TasksKt.await(taskProcess, anonymousClass1);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objAwait);
        }
        List<Barcode> list = (List) objAwait;
        Intrinsics.checkNotNull(list);
        ArrayList arrayList = new ArrayList();
        for (Barcode barcode : list) {
            String rawValue = barcode.getRawValue();
            ReadableCode readableCode = null;
            if (rawValue != null) {
                Iterator<ReadableCode.Type> it = ReadableCode.Type.getEntries().iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (next.getMlkitFormat() != barcode.getFormat());
                ReadableCode.Type type = next;
                if (type != null) {
                    readableCode = new ReadableCode(rawValue, type);
                }
            }
            if (readableCode != null) {
                arrayList.add(readableCode);
            }
        }
        return arrayList;
    }
}
