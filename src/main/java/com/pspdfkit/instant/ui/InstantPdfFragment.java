package com.pspdfkit.instant.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microsoft.intune.mam.client.app.MAMAlertDialogBuilder;
import com.pspdfkit.Nutrient;
import com.pspdfkit.R;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.defaults.AnnotationPreferencesManager;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.annotations.AnnotationReplyFeatures;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.exceptions.NutrientNotInitializedException;
import com.pspdfkit.instant.client.InstantClient;
import com.pspdfkit.instant.client.InstantDocumentDescriptor;
import com.pspdfkit.instant.client.InstantProgress;
import com.pspdfkit.instant.document.InstantDocumentState;
import com.pspdfkit.instant.document.InstantPdfDocument;
import com.pspdfkit.instant.exceptions.InstantErrorCode;
import com.pspdfkit.instant.exceptions.InstantException;
import com.pspdfkit.instant.listeners.InstantDocumentListener;
import com.pspdfkit.internal.a70;
import com.pspdfkit.internal.c5;
import com.pspdfkit.internal.el;
import com.pspdfkit.internal.go;
import com.pspdfkit.internal.j00;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.o3;
import com.pspdfkit.internal.ul;
import com.pspdfkit.internal.uv;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.internal.vk;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.rendering.AnnotationOverlayRenderStrategy;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.undo.UndoManager;
import com.pspdfkit.utils.BundleExtensions;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 ~2\u00020\u00012\u00020\u0002:\u0001~B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\nH\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010#\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\nH\u0016¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\nH\u0016¢\u0006\u0004\b&\u0010\u0004J\u000f\u0010'\u001a\u00020\nH\u0016¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\nH\u0016¢\u0006\u0004\b(\u0010\u0004J\u001b\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0)H\u0014¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\n\u0012\u0006\b\u0001\u0012\u00020/0.H\u0014¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0005H\u0014¢\u0006\u0004\b2\u0010\u0007J\u000f\u00103\u001a\u00020\u0005H\u0016¢\u0006\u0004\b3\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u0011\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u00020\n2\u0006\u00107\u001a\u00020/H\u0017¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020\n¢\u0006\u0004\b:\u0010\u0004J\u0015\u0010<\u001a\u00020\n2\u0006\u0010;\u001a\u00020\u0002¢\u0006\u0004\b<\u0010=J\u0015\u0010>\u001a\u00020\n2\u0006\u0010;\u001a\u00020\u0002¢\u0006\u0004\b>\u0010=J\u001f\u0010@\u001a\u00020\n2\u0006\u0010?\u001a\u0002042\u0006\u0010\u000e\u001a\u00020\rH\u0017¢\u0006\u0004\b@\u0010AJ\u001f\u0010D\u001a\u00020\n2\u0006\u0010?\u001a\u0002042\u0006\u0010C\u001a\u00020BH\u0017¢\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001a\u00020\n2\u0006\u0010?\u001a\u000204H\u0017¢\u0006\u0004\bF\u0010GJ\u001f\u0010H\u001a\u00020\n2\u0006\u0010?\u001a\u0002042\u0006\u0010\u000e\u001a\u00020\rH\u0017¢\u0006\u0004\bH\u0010AJ\u0017\u0010I\u001a\u00020\n2\u0006\u0010?\u001a\u000204H\u0017¢\u0006\u0004\bI\u0010GJ\u001f\u0010L\u001a\u00020\n2\u0006\u0010?\u001a\u0002042\u0006\u0010K\u001a\u00020JH\u0016¢\u0006\u0004\bL\u0010MJ\u0017\u0010N\u001a\u00020\n2\u0006\u0010?\u001a\u000204H\u0017¢\u0006\u0004\bN\u0010GJ\u0017\u0010O\u001a\u00020\n2\u0006\u0010?\u001a\u000204H\u0017¢\u0006\u0004\bO\u0010GJ\u0015\u0010Q\u001a\u00020\n2\u0006\u0010P\u001a\u00020\u0005¢\u0006\u0004\bQ\u0010RJ\u0015\u0010T\u001a\u00020\n2\u0006\u0010S\u001a\u00020\u0005¢\u0006\u0004\bT\u0010RJ\u000f\u0010V\u001a\u00020UH\u0016¢\u0006\u0004\bV\u0010WJ\u001d\u0010[\u001a\u00020\n2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020Y0XH\u0016¢\u0006\u0004\b[\u0010\\J\u0017\u0010_\u001a\u00020\n2\u0006\u0010^\u001a\u00020]H\u0014¢\u0006\u0004\b_\u0010`J\u0017\u0010c\u001a\u00020\n2\u0006\u0010b\u001a\u00020aH\u0016¢\u0006\u0004\bc\u0010dJ\u001d\u0010g\u001a\u00020\n2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020a0eH\u0016¢\u0006\u0004\bg\u0010hR\u0018\u0010j\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u001e\u0010m\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u001c\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00020o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR0\u0010t\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002 s*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010o0o0r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010P\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010vR\u0018\u0010x\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010z\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010vR\u0018\u0010|\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}¨\u0006\u007f"}, d2 = {"Lcom/pspdfkit/instant/ui/InstantPdfFragment;", "Lcom/pspdfkit/ui/PdfFragment;", "Lcom/pspdfkit/instant/listeners/InstantDocumentListener;", "<init>", "()V", "", "isUiThread", "()Z", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "saveAsync", "(Lkotlinx/coroutines/CoroutineScope;)V", "Lcom/pspdfkit/instant/exceptions/InstantException;", "error", "handleInstantError", "(Lcom/pspdfkit/instant/exceptions/InstantException;)V", "disableAutomaticSyncOnCriticalErrors", "refreshListenToServerChangesWhenVisible", "Lcom/pspdfkit/annotations/defaults/AnnotationPreferencesManager;", "getAnnotationPreferences", "()Lcom/pspdfkit/annotations/defaults/AnnotationPreferencesManager;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", TtmlNode.RUBY_CONTAINER, "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onStop", "onDestroy", "onDetach", "", "Lio/reactivex/rxjava3/core/Flowable;", "", "getDocumentLoadingProgressObservables", "()Ljava/util/List;", "Lio/reactivex/rxjava3/core/Single;", "Lcom/pspdfkit/document/PdfDocument;", "openDocumentAsync", "()Lio/reactivex/rxjava3/core/Single;", "shouldReloadDocument", "save", "Lcom/pspdfkit/instant/document/InstantPdfDocument;", "getDocument", "()Lcom/pspdfkit/instant/document/InstantPdfDocument;", "document", "onDocumentLoaded", "(Lcom/pspdfkit/document/PdfDocument;)V", "syncAnnotations", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addInstantDocumentListener", "(Lcom/pspdfkit/instant/listeners/InstantDocumentListener;)V", "removeInstantDocumentListener", "instantDocument", "onAuthenticationFailed", "(Lcom/pspdfkit/instant/document/InstantPdfDocument;Lcom/pspdfkit/instant/exceptions/InstantException;)V", "", "validJwt", "onAuthenticationFinished", "(Lcom/pspdfkit/instant/document/InstantPdfDocument;Ljava/lang/String;)V", "onSyncStarted", "(Lcom/pspdfkit/instant/document/InstantPdfDocument;)V", "onSyncError", "onSyncFinished", "Lcom/pspdfkit/instant/document/InstantDocumentState;", "state", "onDocumentStateChanged", "(Lcom/pspdfkit/instant/document/InstantPdfDocument;Lcom/pspdfkit/instant/document/InstantDocumentState;)V", "onDocumentCorrupted", "onDocumentInvalidated", "listenToServerChangesWhenVisible", "setListenToServerChangesWhenVisible", "(Z)V", "showCriticalErrors", "setHandleCriticalInstantErrors", "Lcom/pspdfkit/undo/UndoManager;", "getUndoManager", "()Lcom/pspdfkit/undo/UndoManager;", "Ljava/util/EnumSet;", "Lcom/pspdfkit/annotations/AnnotationType;", "overlayAnnotationTypes", "setOverlaidAnnotationTypes", "(Ljava/util/EnumSet;)V", "Lcom/pspdfkit/internal/o3;", "annotationProvider", "setEditListenerForAnnotationProvider", "(Lcom/pspdfkit/internal/o3;)V", "Lcom/pspdfkit/document/DocumentSource;", "source", "setCustomPdfSource", "(Lcom/pspdfkit/document/DocumentSource;)V", "", "sources", "setCustomPdfSources", "(Ljava/util/List;)V", "Lcom/pspdfkit/internal/ul;", "documentSource", "Lcom/pspdfkit/internal/ul;", "Lio/reactivex/rxjava3/subjects/PublishSubject;", "loadingProgressSubject", "Lio/reactivex/rxjava3/subjects/PublishSubject;", "Lcom/pspdfkit/internal/go;", "instantDocumentListeners", "Lcom/pspdfkit/internal/go;", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "weakInstantDocumentListeners", "Ljava/lang/ref/WeakReference;", "Z", "Landroid/net/ConnectivityManager$NetworkCallback;", "networkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "handleCriticalErrors", "Landroid/app/AlertDialog;", "errorDialog", "Landroid/app/AlertDialog;", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class InstantPdfFragment extends PdfFragment implements InstantDocumentListener {
    public static final String PARAM_INSTANT_DOCUMENT_SOURCE = "Instant.InstantDocumentSource";
    private ul documentSource;
    private AlertDialog errorDialog;
    private PublishSubject<Double> loadingProgressSubject;
    private ConnectivityManager.NetworkCallback networkCallback;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private go<InstantDocumentListener> instantDocumentListeners = new go<>();
    private WeakReference<go<InstantDocumentListener>> weakInstantDocumentListeners = new WeakReference<>(this.instantDocumentListeners);
    private boolean listenToServerChangesWhenVisible = true;
    private boolean handleCriticalErrors = true;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000eJ\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/pspdfkit/instant/ui/InstantPdfFragment$Companion;", "", "<init>", "()V", "", "serverUrl", "jwt", "Lcom/pspdfkit/configuration/PdfConfiguration;", "configuration", "Lcom/pspdfkit/instant/ui/InstantPdfFragment;", "newInstance", "(Ljava/lang/String;Ljava/lang/String;Lcom/pspdfkit/configuration/PdfConfiguration;)Lcom/pspdfkit/instant/ui/InstantPdfFragment;", "Lcom/pspdfkit/internal/ul;", "documentSource", "(Lcom/pspdfkit/internal/ul;Lcom/pspdfkit/configuration/PdfConfiguration;)Lcom/pspdfkit/instant/ui/InstantPdfFragment;", "Lcom/pspdfkit/instant/document/InstantPdfDocument;", "document", "(Lcom/pspdfkit/instant/document/InstantPdfDocument;Lcom/pspdfkit/configuration/PdfConfiguration;)Lcom/pspdfkit/instant/ui/InstantPdfFragment;", "validatedPdfConfiguration", "(Lcom/pspdfkit/configuration/PdfConfiguration;)Lcom/pspdfkit/configuration/PdfConfiguration;", "PARAM_INSTANT_DOCUMENT_SOURCE", "Ljava/lang/String;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final InstantPdfFragment newInstance(String serverUrl, String jwt, PdfConfiguration configuration) {
            serverUrl.getClass();
            jwt.getClass();
            configuration.getClass();
            return newInstance(new ul(serverUrl, jwt), configuration);
        }

        @JvmStatic
        public final PdfConfiguration validatedPdfConfiguration(PdfConfiguration configuration) {
            configuration.getClass();
            List listListOf = CollectionsKt.listOf((Object[]) new AnnotationType[]{AnnotationType.FREETEXT, AnnotationType.NOTE, AnnotationType.INK, AnnotationType.LINE, AnnotationType.SQUARE, AnnotationType.CIRCLE, AnnotationType.POLYLINE, AnnotationType.POLYGON, AnnotationType.HIGHLIGHT, AnnotationType.SQUIGGLY, AnnotationType.STRIKEOUT, AnnotationType.UNDERLINE, AnnotationType.STAMP});
            List listListOf2 = CollectionsKt.listOf((Object[]) new AnnotationTool[]{AnnotationTool.FREETEXT, AnnotationTool.NOTE, AnnotationTool.INK, AnnotationTool.MAGIC_INK, AnnotationTool.SIGNATURE, AnnotationTool.LINE, AnnotationTool.SQUARE, AnnotationTool.CIRCLE, AnnotationTool.POLYLINE, AnnotationTool.POLYGON, AnnotationTool.ERASER, AnnotationTool.HIGHLIGHT, AnnotationTool.SQUIGGLY, AnnotationTool.STRIKEOUT, AnnotationTool.UNDERLINE, AnnotationTool.IMAGE, AnnotationTool.CAMERA, AnnotationTool.STAMP, AnnotationTool.INSTANT_COMMENT_MARKER, AnnotationTool.INSTANT_HIGHLIGHT_COMMENT, AnnotationTool.MEASUREMENT_DISTANCE, AnnotationTool.MEASUREMENT_PERIMETER, AnnotationTool.MEASUREMENT_AREA_ELLIPSE, AnnotationTool.MEASUREMENT_AREA_POLYGON, AnnotationTool.MEASUREMENT_AREA_RECT});
            AnnotationReplyFeatures annotationReplyFeatures = AnnotationReplyFeatures.DISABLED;
            if (!configuration.getEditableAnnotationTypes().isEmpty()) {
                listListOf = CollectionsKt.toList(CollectionsKt.intersect(listListOf, CollectionsKt.toSet(configuration.getEditableAnnotationTypes())));
            }
            List list = listListOf;
            if (!configuration.getEnabledAnnotationTools().isEmpty()) {
                listListOf2 = CollectionsKt.toList(CollectionsKt.intersect(listListOf2, CollectionsKt.toSet(configuration.getEnabledAnnotationTools())));
            }
            return PdfConfiguration.copy$default(configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, list, listListOf2, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, annotationReplyFeatures, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -406847489, -7297, 15, null);
        }

        private Companion() {
        }

        @JvmStatic
        public final InstantPdfFragment newInstance(ul documentSource, PdfConfiguration configuration) {
            documentSource.getClass();
            configuration.getClass();
            Bundle bundle = new Bundle();
            bundle.putParcelable("Instant.InstantDocumentSource", documentSource);
            bundle.putParcelable(PdfFragment.PARAM_CONFIGURATION, validatedPdfConfiguration(configuration));
            InstantPdfFragment instantPdfFragment = new InstantPdfFragment();
            instantPdfFragment.setArguments(bundle);
            return instantPdfFragment;
        }

        @JvmStatic
        public final InstantPdfFragment newInstance(InstantPdfDocument document, PdfConfiguration configuration) {
            document.getClass();
            configuration.getClass();
            String jwt = document.getInstantDocumentDescriptor().getJwt();
            if (jwt != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(PdfFragment.PARAM_CONFIGURATION, validatedPdfConfiguration(configuration));
                bundle.putParcelable("Instant.InstantDocumentSource", new ul(document.getInstantClient().getServerUrl(), jwt));
                InstantPdfFragment instantPdfFragment = new InstantPdfFragment();
                instantPdfFragment.setArguments(bundle);
                instantPdfFragment.getInternal().setDocument(document);
                return instantPdfFragment;
            }
            throw new IllegalStateException("Document JWT is not available.");
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.instant.ui.InstantPdfFragment$save$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.instant.ui.InstantPdfFragment$save$1", f = "InstantPdfFragment.kt", i = {}, l = {248}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ InstantPdfDocument $instantDocument;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InstantPdfDocument instantPdfDocument, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$instantDocument = instantPdfDocument;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$instantDocument, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                InstantPdfDocument instantPdfDocument = this.$instantDocument;
                this.label = 1;
                if (instantPdfDocument.syncAnnotations(this) == coroutine_suspended) {
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.instant.ui.InstantPdfFragment$saveAsync$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.instant.ui.InstantPdfFragment$saveAsync$1", f = "InstantPdfFragment.kt", i = {}, l = {276}, m = "invokeSuspend", n = {}, nl = {282}, s = {}, v = 2)
    public static final class C18581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ InstantPdfDocument $instantDocument;
        final /* synthetic */ go<InstantDocumentListener> $instantDocumentListeners;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C18581(InstantPdfDocument instantPdfDocument, go<InstantDocumentListener> goVar, Continuation<? super C18581> continuation) {
            super(2, continuation);
            this.$instantDocument = instantPdfDocument;
            this.$instantDocumentListeners = goVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C18581(this.$instantDocument, this.$instantDocumentListeners, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    InstantPdfDocument instantPdfDocument = this.$instantDocument;
                    this.label = 1;
                    if (instantPdfDocument.syncAnnotations(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Throwable unused) {
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.instant.ui.InstantPdfFragment$syncAnnotations$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.instant.ui.InstantPdfFragment$syncAnnotations$1", f = "InstantPdfFragment.kt", i = {}, l = {307}, m = "invokeSuspend", n = {}, nl = {308}, s = {}, v = 2)
    public static final class C18591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ InstantPdfDocument $document;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C18591(InstantPdfDocument instantPdfDocument, Continuation<? super C18591> continuation) {
            super(2, continuation);
            this.$document = instantPdfDocument;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C18591(this.$document, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    InstantPdfDocument instantPdfDocument = this.$document;
                    this.label = 1;
                    if (instantPdfDocument.syncAnnotations(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Throwable unused) {
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public InstantPdfFragment() {
        UndoManager undoManager = super.getUndoManager();
        undoManager.getClass();
        ((a70) undoManager).a(a70.a.NONE);
    }

    private final void disableAutomaticSyncOnCriticalErrors() {
        InstantPdfDocument document = getDocument();
        if (document == null) {
            return;
        }
        document.setListeningToServerChanges(false);
        document.setDelayForSyncingLocalChanges(Long.MAX_VALUE);
    }

    private final void handleInstantError(InstantException error) {
        if (this.handleCriticalErrors) {
            boolean z = true;
            boolean z2 = error.getErrorCode() == InstantErrorCode.INVALID_REQUEST;
            if (z2) {
                disableAutomaticSyncOnCriticalErrors();
            }
            InstantErrorCode errorCode = error.getErrorCode();
            InstantErrorCode instantErrorCode = InstantErrorCode.OLD_CLIENT;
            if (errorCode != instantErrorCode && error.getErrorCode() != InstantErrorCode.OLD_SERVER) {
                z = false;
            }
            if (z) {
                disableAutomaticSyncOnCriticalErrors();
            }
            if (z && error.getErrorCode() == instantErrorCode && this.errorDialog == null && isResumed()) {
                AlertDialog.Builder title = new MAMAlertDialogBuilder(getContext()).setTitle(R.string.pspdf__update_required);
                Context contextRequireContext = requireContext();
                int i = R.string.pspdf__update_required_description;
                Context contextRequireContext2 = requireContext();
                this.errorDialog = title.setMessage(no.a(contextRequireContext, i, (View) null, contextRequireContext2.getApplicationInfo().loadLabel(contextRequireContext2.getPackageManager()))).setNegativeButton(R.string.pspdf__ok, (DialogInterface.OnClickListener) null).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.pspdfkit.instant.ui.InstantPdfFragment$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.f$0.errorDialog = null;
                    }
                }).show();
                return;
            }
            if (z2 && this.errorDialog == null && isResumed()) {
                this.errorDialog = new MAMAlertDialogBuilder(getContext()).setTitle(R.string.pspdf__instant_sync_error_title).setMessage(R.string.pspdf__instant_sync_error_description).setNegativeButton(R.string.pspdf__ok, (DialogInterface.OnClickListener) null).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.pspdfkit.instant.ui.InstantPdfFragment$$ExternalSyntheticLambda4
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.f$0.errorDialog = null;
                    }
                }).show();
            }
        }
    }

    private final boolean isUiThread() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    @JvmStatic
    public static final InstantPdfFragment newInstance(InstantPdfDocument instantPdfDocument, PdfConfiguration pdfConfiguration) {
        return INSTANCE.newInstance(instantPdfDocument, pdfConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(InstantPdfFragment instantPdfFragment, DocumentView documentView) {
        documentView.getClass();
        EnumSet<AnnotationType> overlaidAnnotationTypes = instantPdfFragment.getOverlaidAnnotationTypes();
        overlaidAnnotationTypes.getClass();
        AnnotationType annotationType = AnnotationType.STAMP;
        if (overlaidAnnotationTypes.contains(annotationType)) {
            return;
        }
        overlaidAnnotationTypes.add(annotationType);
        instantPdfFragment.setOverlaidAnnotationTypes(overlaidAnnotationTypes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InstantProgress openDocumentAsync$lambda$0(InstantPdfFragment instantPdfFragment, InstantProgress instantProgress) {
        instantProgress.getClass();
        synchronized (instantPdfFragment) {
            PublishSubject<Double> publishSubject = instantPdfFragment.loadingProgressSubject;
            if (publishSubject != null) {
                publishSubject.onNext(Double.valueOf(((double) instantProgress.getCurrentProgress()) / 100.0d));
                Unit unit = Unit.INSTANCE;
            }
        }
        return instantProgress;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openDocumentAsync$lambda$1(InstantPdfFragment instantPdfFragment) {
        synchronized (instantPdfFragment) {
            PublishSubject<Double> publishSubject = instantPdfFragment.loadingProgressSubject;
            if (publishSubject != null) {
                publishSubject.onComplete();
            }
            instantPdfFragment.loadingProgressSubject = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void refreshListenToServerChangesWhenVisible() {
        InstantPdfDocument document = getDocument();
        if (document == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        ConnectivityManager connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(contextRequireContext, ConnectivityManager.class);
        if (connectivityManager == null) {
            return;
        }
        if (this.listenToServerChangesWhenVisible && isResumed()) {
            if (this.networkCallback == null) {
                ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.pspdfkit.instant.ui.InstantPdfFragment$refreshListenToServerChangesWhenVisible$callback$1
                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onAvailable(Network network) {
                        network.getClass();
                        InstantPdfDocument document2 = this.this$0.getDocument();
                        if (document2 != null) {
                            document2.notifyConnectivityChanged(true);
                        }
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onLost(Network network) {
                        network.getClass();
                        InstantPdfDocument document2 = this.this$0.getDocument();
                        if (document2 != null) {
                            document2.notifyConnectivityChanged(false);
                        }
                    }
                };
                this.networkCallback = networkCallback;
                connectivityManager.registerDefaultNetworkCallback(networkCallback);
            }
            document.setListeningToServerChanges(true);
            return;
        }
        ConnectivityManager.NetworkCallback networkCallback2 = this.networkCallback;
        if (networkCallback2 != null) {
            try {
                connectivityManager.unregisterNetworkCallback(networkCallback2);
            } catch (Throwable unused) {
            }
            this.networkCallback = null;
        }
        document.setListeningToServerChanges(false);
    }

    @JvmStatic
    public static final PdfConfiguration validatedPdfConfiguration(PdfConfiguration pdfConfiguration) {
        return INSTANCE.validatedPdfConfiguration(pdfConfiguration);
    }

    public final void addInstantDocumentListener(InstantDocumentListener listener) {
        listener.getClass();
        this.instantDocumentListeners.a(listener);
    }

    @Override // com.pspdfkit.ui.PdfFragment
    public AnnotationPreferencesManager getAnnotationPreferences() {
        AnnotationPreferencesManager annotationPreferences = super.getAnnotationPreferences();
        annotationPreferences.getClass();
        InstantPdfDocument document = getDocument();
        return new vk(annotationPreferences, document != null ? document.getInstantDocumentDescriptor() : null);
    }

    @Override // com.pspdfkit.ui.PdfFragment
    public List<Flowable<Double>> getDocumentLoadingProgressObservables() {
        List<Flowable<Double>> listMutableListOf;
        synchronized (this) {
            PublishSubject<Double> publishSubjectCreate = PublishSubject.create();
            this.loadingProgressSubject = publishSubjectCreate;
            if (publishSubjectCreate == null) {
                throw new IllegalStateException("Loading progress subject was not initialized!");
            }
            Flowable<Double> flowableStartWithItem = publishSubjectCreate.toFlowable(BackpressureStrategy.LATEST).startWithItem(Double.valueOf(0.0d));
            flowableStartWithItem.getClass();
            listMutableListOf = CollectionsKt.mutableListOf(flowableStartWithItem);
        }
        return listMutableListOf;
    }

    @Override // com.pspdfkit.ui.PdfFragment
    public UndoManager getUndoManager() {
        throw new UnsupportedOperationException("Instant does not support undo!");
    }

    @Override // com.pspdfkit.ui.PdfFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        context.getClass();
        super.onAttach(context);
        this.weakInstantDocumentListeners = new WeakReference<>(this.instantDocumentListeners);
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onAuthenticationFailed(InstantPdfDocument instantDocument, InstantException error) {
        instantDocument.getClass();
        error.getClass();
        handleInstantError(error);
        go<InstantDocumentListener> goVar = this.weakInstantDocumentListeners.get();
        if (goVar == null) {
            return;
        }
        Iterator<InstantDocumentListener> it = goVar.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().onAuthenticationFailed(instantDocument, error);
        }
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onAuthenticationFinished(InstantPdfDocument instantDocument, String validJwt) {
        instantDocument.getClass();
        validJwt.getClass();
        go<InstantDocumentListener> goVar = this.weakInstantDocumentListeners.get();
        if (goVar == null) {
            return;
        }
        Iterator<InstantDocumentListener> it = goVar.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().onAuthenticationFinished(instantDocument, validJwt);
        }
    }

    @Override // com.pspdfkit.ui.PdfFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        List<String> list = j00.a;
        if (!Nutrient.isInitialized()) {
            j00.a(contextRequireContext).onErrorComplete().blockingAwait();
            if (!Nutrient.isInitialized()) {
                throw new NutrientNotInitializedException("Nutrient is not initialized!");
            }
        }
        if (this.documentSource == null) {
            if (getArguments() != null) {
                Bundle bundleRequireArguments = requireArguments();
                bundleRequireArguments.getClass();
                this.documentSource = (ul) BundleExtensions.getSupportParcelable(bundleRequireArguments, "Instant.InstantDocumentSource", ul.class);
            }
            if (this.documentSource == null) {
                throw new IllegalArgumentException("Document descriptor is missing.");
            }
        }
    }

    @Override // com.pspdfkit.ui.PdfFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        inflater.getClass();
        uv viewCoordinator = getInternal().getViewCoordinator();
        Context context = inflater.getContext();
        context.getClass();
        PdfConfiguration configuration = getConfiguration();
        configuration.getClass();
        el elVar = new el(context, this, configuration);
        synchronized (viewCoordinator) {
            if (viewCoordinator.n != null) {
                throw new IllegalStateException("Custom annotation views factory must be injected before calling createViews()");
            }
            viewCoordinator.f = elVar;
            AnnotationOverlayRenderStrategy annotationOverlayRenderStrategy = viewCoordinator.g;
            if (annotationOverlayRenderStrategy != null) {
                elVar.e = annotationOverlayRenderStrategy;
            } else {
                elVar.e = c5.t;
            }
        }
        View viewOnCreateView = super.onCreateView(inflater, container, savedInstanceState);
        getInternal().getViewCoordinator().a(new uv.c() { // from class: com.pspdfkit.instant.ui.InstantPdfFragment$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                InstantPdfFragment.onCreateView$lambda$0(this.f$0, documentView);
            }
        }, false);
        return viewOnCreateView;
    }

    @Override // com.pspdfkit.ui.PdfFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        InstantPdfDocument document = getDocument();
        if (document != null) {
            document.removeInstantDocumentListener(this);
        }
        super.onDestroy();
    }

    @Override // com.pspdfkit.ui.PdfFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.instantDocumentListeners = new go<>();
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onDocumentCorrupted(InstantPdfDocument instantDocument) {
        instantDocument.getClass();
        go<InstantDocumentListener> goVar = this.weakInstantDocumentListeners.get();
        if (goVar == null) {
            return;
        }
        Iterator<InstantDocumentListener> it = goVar.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().onDocumentCorrupted(instantDocument);
        }
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onDocumentInvalidated(InstantPdfDocument instantDocument) {
        instantDocument.getClass();
        go<InstantDocumentListener> goVar = this.weakInstantDocumentListeners.get();
        if (goVar == null) {
            return;
        }
        Iterator<InstantDocumentListener> it = goVar.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().onDocumentInvalidated(instantDocument);
        }
    }

    @Override // com.pspdfkit.ui.PdfFragment, com.pspdfkit.listeners.DocumentListener
    public void onDocumentLoaded(PdfDocument document) {
        document.getClass();
        super.onDocumentLoaded(document);
        InstantPdfDocument document2 = getDocument();
        if (document2 != null) {
            document2.addInstantDocumentListener(this);
        }
        refreshListenToServerChangesWhenVisible();
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onDocumentStateChanged(InstantPdfDocument instantDocument, InstantDocumentState state) {
        instantDocument.getClass();
        state.getClass();
        go<InstantDocumentListener> goVar = this.weakInstantDocumentListeners.get();
        if (goVar == null) {
            return;
        }
        Iterator<InstantDocumentListener> it = goVar.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().onDocumentStateChanged(instantDocument, state);
        }
    }

    @Override // com.pspdfkit.ui.PdfFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        refreshListenToServerChangesWhenVisible();
    }

    @Override // com.pspdfkit.ui.PdfFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        refreshListenToServerChangesWhenVisible();
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onSyncError(InstantPdfDocument instantDocument, InstantException error) {
        instantDocument.getClass();
        error.getClass();
        handleInstantError(error);
        go<InstantDocumentListener> goVar = this.weakInstantDocumentListeners.get();
        if (goVar == null) {
            return;
        }
        Iterator<InstantDocumentListener> it = goVar.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().onSyncError(instantDocument, error);
        }
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onSyncFinished(InstantPdfDocument instantDocument) {
        instantDocument.getClass();
        go<InstantDocumentListener> goVar = this.weakInstantDocumentListeners.get();
        if (goVar == null) {
            return;
        }
        Iterator<InstantDocumentListener> it = goVar.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().onSyncFinished(instantDocument);
        }
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onSyncStarted(InstantPdfDocument instantDocument) {
        instantDocument.getClass();
        go<InstantDocumentListener> goVar = this.weakInstantDocumentListeners.get();
        if (goVar == null) {
            return;
        }
        Iterator<InstantDocumentListener> it = goVar.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().onSyncStarted(instantDocument);
        }
    }

    @Override // com.pspdfkit.ui.PdfFragment
    public Single<? extends PdfDocument> openDocumentAsync() {
        ul ulVar = this.documentSource;
        if (ulVar == null) {
            Single<? extends PdfDocument> singleError = Single.error(new IllegalStateException("Document source was not initialized!"));
            singleError.getClass();
            return singleError;
        }
        InstantClient instantClientCreate = InstantClient.create(requireContext(), ulVar.a);
        instantClientCreate.getClass();
        String str = ulVar.d;
        str.getClass();
        InstantDocumentDescriptor instantDocumentDescriptorForJwt = instantClientCreate.getInstantDocumentDescriptorForJwt(str);
        instantDocumentDescriptorForJwt.getClass();
        Single<? extends PdfDocument> singleAndThen = instantDocumentDescriptorForJwt.downloadDocumentAsync(ulVar.d).map(new Function() { // from class: com.pspdfkit.instant.ui.InstantPdfFragment$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return InstantPdfFragment.openDocumentAsync$lambda$0(this.f$0, (InstantProgress) obj);
            }
        }).ignoreElements().doFinally(new Action() { // from class: com.pspdfkit.instant.ui.InstantPdfFragment$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                InstantPdfFragment.openDocumentAsync$lambda$1(this.f$0);
            }
        }).andThen(instantDocumentDescriptorForJwt.openDocumentAsync(ulVar.d));
        singleAndThen.getClass();
        return singleAndThen;
    }

    public final void removeInstantDocumentListener(InstantDocumentListener listener) {
        listener.getClass();
        this.instantDocumentListeners.b(listener);
    }

    @Override // com.pspdfkit.ui.PdfFragment
    public boolean save() {
        InstantPdfDocument document = getDocument();
        if (document == null) {
            return false;
        }
        InstantDocumentState documentState = document.getDocumentState();
        InstantDocumentState instantDocumentState = InstantDocumentState.CLEAN;
        if (documentState == instantDocumentState) {
            return false;
        }
        if (isUiThread()) {
            saveAsync(LifecycleOwnerKt.getLifecycleScope(ProcessLifecycleOwner.INSTANCE.get()));
            return true;
        }
        try {
            BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(document, null), 1, null);
            return document.getDocumentState() == instantDocumentState;
        } catch (Exception e) {
            PdfLog.w("Nutri.InstantPdfFrag", "Annotation sync timed out or failed during save, continuing asynchronously", e);
            return false;
        }
    }

    @Override // com.pspdfkit.ui.PdfFragment
    public void saveAsync() {
        saveAsync(LifecycleOwnerKt.getLifecycleScope(this));
    }

    @Override // com.pspdfkit.ui.PdfFragment
    public void setCustomPdfSource(DocumentSource source) {
        source.getClass();
        throw new UnsupportedOperationException("InstantPdfFragment does not support setting custom PDF source.");
    }

    @Override // com.pspdfkit.ui.PdfFragment
    public void setCustomPdfSources(List<DocumentSource> sources) {
        sources.getClass();
        throw new UnsupportedOperationException("InstantPdfFragment does not support setting custom PDF sources.");
    }

    @Override // com.pspdfkit.ui.PdfFragment
    public void setEditListenerForAnnotationProvider(o3 annotationProvider) {
        annotationProvider.getClass();
    }

    public final void setHandleCriticalInstantErrors(boolean showCriticalErrors) {
        this.handleCriticalErrors = showCriticalErrors;
    }

    public final void setListenToServerChangesWhenVisible(boolean listenToServerChangesWhenVisible) {
        if (this.listenToServerChangesWhenVisible == listenToServerChangesWhenVisible) {
            return;
        }
        this.listenToServerChangesWhenVisible = listenToServerChangesWhenVisible;
        refreshListenToServerChangesWhenVisible();
    }

    @Override // com.pspdfkit.ui.PdfFragment
    public void setOverlaidAnnotationTypes(EnumSet<AnnotationType> overlayAnnotationTypes) {
        overlayAnnotationTypes.getClass();
        AnnotationType annotationType = AnnotationType.STAMP;
        if (!overlayAnnotationTypes.contains(annotationType)) {
            overlayAnnotationTypes.add(annotationType);
            PdfLog.e("Nutri.InstantPdfFrag", "Forcing overlay for stamp annotations in InstantPdfFragment", new Object[0]);
        }
        super.setOverlaidAnnotationTypes(overlayAnnotationTypes);
    }

    @Override // com.pspdfkit.ui.PdfFragment
    public boolean shouldReloadDocument() {
        ul ulVar;
        InstantPdfDocument document = getDocument();
        return (document != null && (ulVar = this.documentSource) != null && Intrinsics.areEqual(ulVar.a, document.getInstantClient().getServerUrl()) && Intrinsics.areEqual(ulVar.b, document.getInstantDocumentDescriptor().getDocumentId()) && Intrinsics.areEqual(ulVar.c, document.getInstantDocumentDescriptor().getLayerName())) ? false : true;
    }

    public final void syncAnnotations() {
        InstantPdfDocument document = getDocument();
        if (document == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C18591(document, null), 3, null);
    }

    @JvmStatic
    public static final InstantPdfFragment newInstance(ul ulVar, PdfConfiguration pdfConfiguration) {
        return INSTANCE.newInstance(ulVar, pdfConfiguration);
    }

    private final void saveAsync(CoroutineScope scope) {
        InstantPdfDocument document = getDocument();
        if (document == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C18581(document, this.weakInstantDocumentListeners.get(), null), 3, null);
    }

    @Override // com.pspdfkit.ui.PdfFragment
    public InstantPdfDocument getDocument() {
        PdfDocument document = super.getDocument();
        if (document == null) {
            return null;
        }
        if (document instanceof InstantPdfDocument) {
            return (InstantPdfDocument) document;
        }
        throw new IllegalStateException("Wrong document type loaded in instant fragment. InstantPdfDocument was expected!");
    }
}
