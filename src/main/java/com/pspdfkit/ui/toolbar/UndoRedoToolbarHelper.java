package com.pspdfkit.ui.toolbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import com.pspdfkit.BuildConfig;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.internal.c70;
import com.pspdfkit.internal.jni.NativeFormNotifications;
import com.pspdfkit.internal.no;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.undo.OnUndoHistoryChangeListener;
import com.pspdfkit.undo.UndoManager;
import com.pspdfkit.undo.exceptions.RedoEditFailedException;
import com.pspdfkit.undo.exceptions.UndoEditFailedException;
import com.pspdfkit.utils.PdfLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006*\u0001H\b\u0007\u0018\u0000 K2\u00020\u0001:\u0002KLB'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJO\u0010\u0018\u001a\u00020\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u00102\"\u0010\u0015\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0011¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\r¢\u0006\u0004\b!\u0010\"J]\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u0010$\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\b\b\u0001\u0010)\u001a\u00020\u00042\b\b\u0001\u0010*\u001a\u00020\u00042\b\b\u0001\u0010+\u001a\u00020\u00042\b\b\u0001\u0010,\u001a\u00020\u0004¢\u0006\u0004\b/\u00100JI\u00106\u001a\u00020\r2:\b\u0002\u00105\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110\n¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\r\u0018\u00010\u0013¢\u0006\u0004\b6\u00107J\r\u00108\u001a\u00020\n¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020\n¢\u0006\u0004\b:\u00109R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010;R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010<R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010<R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010<R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010FR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006M"}, d2 = {"Lcom/pspdfkit/ui/toolbar/UndoRedoToolbarHelper;", "", "Lcom/pspdfkit/ui/toolbar/UndoRedoToolbarHelper$UndoRedoToolbarHost;", "host", "", "groupId", "undoItemId", "redoItemId", "<init>", "(Lcom/pspdfkit/ui/toolbar/UndoRedoToolbarHelper$UndoRedoToolbarHost;III)V", "", "undoEnabled", "redoEnabled", "", "applyButtonState", "(ZZ)V", "Lkotlin/Function1;", "Lcom/pspdfkit/ui/toolbar/UndoProvider;", "canExecute", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", SerializedNames.OPERATION, "", "operationName", "executeUndoRedoOperation", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Ljava/lang/String;)Z", "Lcom/pspdfkit/ui/PdfFragment;", "pdfFragment", "bindUndoManager", "(Lcom/pspdfkit/ui/PdfFragment;)V", NativeFormNotifications.PROVIDER_INDEX_INFO_KEY, "bindProvider", "(Lcom/pspdfkit/ui/toolbar/UndoProvider;)V", "unbindUndoManager", "()V", "Landroid/content/Context;", "context", "Lcom/pspdfkit/configuration/PdfConfiguration;", "configuration", "undoStringId", "redoStringId", "undoIcon", "redoIcon", "iconColor", "iconColorActivated", "", "Lcom/pspdfkit/ui/toolbar/ContextualToolbarMenuItem;", "addUndoRedoMenuItems", "(Landroid/content/Context;Lcom/pspdfkit/configuration/PdfConfiguration;IIIIII)Ljava/util/List;", "Lkotlin/ParameterName;", "name", "canUndo", "canRedo", "onStateUpdated", "updateUndoRedoButtons", "(Lkotlin/jvm/functions/Function2;)V", "executeUndo", "()Z", "executeRedo", "Lcom/pspdfkit/ui/toolbar/UndoRedoToolbarHelper$UndoRedoToolbarHost;", "I", "Lcom/pspdfkit/ui/toolbar/UndoProvider;", "Lcom/pspdfkit/undo/UndoManager;", "undoManager", "Lcom/pspdfkit/undo/UndoManager;", "Lcom/pspdfkit/internal/c70;", "undoRedoDrawable", "Lcom/pspdfkit/internal/c70;", "Lkotlinx/coroutines/Job;", "undoRedoCheckJob", "Lkotlinx/coroutines/Job;", "undoRedoExecutionJob", "com/pspdfkit/ui/toolbar/UndoRedoToolbarHelper$undoHistoryChangeListener$1", "undoHistoryChangeListener", "Lcom/pspdfkit/ui/toolbar/UndoRedoToolbarHelper$undoHistoryChangeListener$1;", "Companion", "UndoRedoToolbarHost", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UndoRedoToolbarHelper {
    private static final String LOG_TAG = "Nutri.UndoRedoHelper";
    private final int groupId;
    private final UndoRedoToolbarHost host;
    private UndoProvider provider;
    private final int redoItemId;
    private final UndoRedoToolbarHelper$undoHistoryChangeListener$1 undoHistoryChangeListener;
    private final int undoItemId;
    private UndoManager undoManager;
    private Job undoRedoCheckJob;
    private c70 undoRedoDrawable;
    private Job undoRedoExecutionJob;
    public static final int $stable = 8;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH&J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0001\u0010\f\u001a\u00020\rH&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/pspdfkit/ui/toolbar/UndoRedoToolbarHelper$UndoRedoToolbarHost;", "", BuildConfig.FLAVOR, "Lcom/pspdfkit/ui/PdfFragment;", "getFragment", "()Lcom/pspdfkit/ui/PdfFragment;", "configuration", "Lcom/pspdfkit/configuration/PdfConfiguration;", "getConfiguration", "()Lcom/pspdfkit/configuration/PdfConfiguration;", "setMenuItemEnabled", "", "id", "", "enabled", "findItemById", "Lcom/pspdfkit/ui/toolbar/ContextualToolbarMenuItem;", "getLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface UndoRedoToolbarHost {
        ContextualToolbarMenuItem findItemById(int id);

        PdfConfiguration getConfiguration();

        PdfFragment getFragment();

        LifecycleOwner getLifecycleOwner();

        boolean setMenuItemEnabled(int id, boolean enabled);
    }

    /* JADX INFO: renamed from: com.pspdfkit.ui.toolbar.UndoRedoToolbarHelper$executeRedo$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/pspdfkit/ui/toolbar/UndoProvider;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.ui.toolbar.UndoRedoToolbarHelper$executeRedo$2", f = "UndoRedoToolbarHelper.kt", i = {0}, l = {326}, m = "invokeSuspend", n = {"it"}, nl = {-1}, s = {"L$0"}, v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<UndoProvider, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(UndoProvider undoProvider, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(undoProvider, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            UndoProvider undoProvider = (UndoProvider) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = SpillingKt.nullOutSpilledVariable(undoProvider);
                this.label = 1;
                if (undoProvider.redo(this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.pspdfkit.ui.toolbar.UndoRedoToolbarHelper$executeUndo$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/pspdfkit/ui/toolbar/UndoProvider;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.ui.toolbar.UndoRedoToolbarHelper$executeUndo$2", f = "UndoRedoToolbarHelper.kt", i = {0}, l = {311}, m = "invokeSuspend", n = {"it"}, nl = {-1}, s = {"L$0"}, v = 2)
    public static final class C18642 extends SuspendLambda implements Function2<UndoProvider, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public C18642(Continuation<? super C18642> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C18642 c18642 = new C18642(continuation);
            c18642.L$0 = obj;
            return c18642;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(UndoProvider undoProvider, Continuation<? super Unit> continuation) {
            return ((C18642) create(undoProvider, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            UndoProvider undoProvider = (UndoProvider) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = SpillingKt.nullOutSpilledVariable(undoProvider);
                this.label = 1;
                if (undoProvider.undo(this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.pspdfkit.ui.toolbar.UndoRedoToolbarHelper$executeUndoRedoOperation$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.ui.toolbar.UndoRedoToolbarHelper$executeUndoRedoOperation$1", f = "UndoRedoToolbarHelper.kt", i = {0}, l = {357}, m = "invokeSuspend", n = {"$this$launch"}, nl = {378}, s = {"L$0"}, v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<UndoProvider, Boolean> $canExecute;
        final /* synthetic */ Function2<UndoProvider, Continuation<? super Unit>, Object> $operation;
        final /* synthetic */ String $operationName;
        final /* synthetic */ UndoProvider $provider;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.pspdfkit.ui.toolbar.UndoRedoToolbarHelper$executeUndoRedoOperation$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.pspdfkit.ui.toolbar.UndoRedoToolbarHelper$executeUndoRedoOperation$1$1", f = "UndoRedoToolbarHelper.kt", i = {}, l = {365}, m = "invokeSuspend", n = {}, nl = {366}, s = {}, v = 2)
        public static final class C03001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<UndoProvider, Boolean> $canExecute;
            final /* synthetic */ Function2<UndoProvider, Continuation<? super Unit>, Object> $operation;
            final /* synthetic */ String $operationName;
            final /* synthetic */ UndoProvider $provider;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C03001(Function1<? super UndoProvider, Boolean> function1, UndoProvider undoProvider, String str, Function2<? super UndoProvider, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C03001> continuation) {
                super(2, continuation);
                this.$canExecute = function1;
                this.$provider = undoProvider;
                this.$operationName = str;
                this.$operation = function2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C03001(this.$canExecute, this.$provider, this.$operationName, this.$operation, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!this.$canExecute.invoke(this.$provider).booleanValue()) {
                        PdfLog.d(UndoRedoToolbarHelper.LOG_TAG, "Skipping " + this.$operationName + ": operation not available", new Object[0]);
                        return Unit.INSTANCE;
                    }
                    Function2<UndoProvider, Continuation<? super Unit>, Object> function2 = this.$operation;
                    UndoProvider undoProvider = this.$provider;
                    this.label = 1;
                    if (function2.invoke(undoProvider, this) == coroutine_suspended) {
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
                return ((C03001) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super UndoProvider, Boolean> function1, UndoProvider undoProvider, String str, Function2<? super UndoProvider, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$canExecute = function1;
            this.$provider = undoProvider;
            this.$operationName = str;
            this.$operation = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = UndoRedoToolbarHelper.this.new AnonymousClass1(this.$canExecute, this.$provider, this.$operationName, this.$operation, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code duplicated, block: B:27:0x0099  */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str = "Redo operation skipped: ";
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            CoroutineDispatcher io2 = Dispatchers.getIO();
                            C03001 c03001 = new C03001(this.$canExecute, this.$provider, this.$operationName, this.$operation, null);
                            this.L$0 = coroutineScope;
                            this.label = 1;
                            Object objWithContext = BuildersKt.withContext(io2, c03001, this);
                            str = objWithContext;
                            if (objWithContext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            str = str;
                        }
                        UndoRedoToolbarHelper.this.undoRedoExecutionJob = null;
                        if (CoroutineScopeKt.isActive(coroutineScope)) {
                            UndoRedoToolbarHelper.updateUndoRedoButtons$default(UndoRedoToolbarHelper.this, null, 1, null);
                        }
                    } catch (RedoEditFailedException e) {
                        PdfLog.d(UndoRedoToolbarHelper.LOG_TAG, str + e.getMessage(), new Object[0]);
                        UndoRedoToolbarHelper.this.undoRedoExecutionJob = null;
                        if (CoroutineScopeKt.isActive(coroutineScope)) {
                            UndoRedoToolbarHelper.updateUndoRedoButtons$default(UndoRedoToolbarHelper.this, null, 1, null);
                        }
                    }
                } catch (UndoEditFailedException e2) {
                    PdfLog.d(UndoRedoToolbarHelper.LOG_TAG, "Undo operation skipped: " + e2.getMessage(), new Object[0]);
                    UndoRedoToolbarHelper.this.undoRedoExecutionJob = null;
                    if (CoroutineScopeKt.isActive(coroutineScope)) {
                        UndoRedoToolbarHelper.updateUndoRedoButtons$default(UndoRedoToolbarHelper.this, null, 1, null);
                    }
                }
                return Unit.INSTANCE;
            } catch (Throwable th) {
                UndoRedoToolbarHelper.this.undoRedoExecutionJob = null;
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    UndoRedoToolbarHelper.updateUndoRedoButtons$default(UndoRedoToolbarHelper.this, null, 1, null);
                }
                throw th;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.ui.toolbar.UndoRedoToolbarHelper$updateUndoRedoButtons$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.ui.toolbar.UndoRedoToolbarHelper$updateUndoRedoButtons$1", f = "UndoRedoToolbarHelper.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {266, 267}, m = "invokeSuspend", n = {"$this$launch", "canUndoDeferred", "canRedoDeferred", "timeoutJob", "$this$launch", "canUndoDeferred", "canRedoDeferred", "timeoutJob", "undoState"}, nl = {267, 270}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 2)
    public static final class C18651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isRedoEnabled;
        final /* synthetic */ boolean $isUndoEnabled;
        final /* synthetic */ Function2<Boolean, Boolean, Unit> $onStateUpdated;
        final /* synthetic */ UndoProvider $provider;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ UndoRedoToolbarHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C18651(boolean z, boolean z2, UndoRedoToolbarHelper undoRedoToolbarHelper, Function2<? super Boolean, ? super Boolean, Unit> function2, UndoProvider undoProvider, Continuation<? super C18651> continuation) {
            super(2, continuation);
            this.$isUndoEnabled = z;
            this.$isRedoEnabled = z2;
            this.this$0 = undoRedoToolbarHelper;
            this.$onStateUpdated = function2;
            this.$provider = undoProvider;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C18651 c18651 = new C18651(this.$isUndoEnabled, this.$isRedoEnabled, this.this$0, this.$onStateUpdated, this.$provider, continuation);
            c18651.L$0 = obj;
            return c18651;
        }

        /* JADX WARN: Code duplicated, block: B:37:0x00f0  */
        /* JADX WARN: Code duplicated, block: B:40:0x00fa  */
        /* JADX WARN: Code duplicated, block: B:42:0x00fe  */
        /* JADX WARN: Code duplicated, block: B:43:0x0100  */
        /* JADX WARN: Code duplicated, block: B:46:0x0108 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:47:0x010a  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Deferred deferredAsync$default;
            Job jobLaunch$default;
            Object objAwait;
            Deferred deferred;
            Object objAwait2;
            int i;
            boolean z;
            boolean z2;
            Function2<Boolean, Boolean, Unit> function2;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                Deferred deferredAsync$default2 = this.$isUndoEnabled ? BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO(), null, new UndoRedoToolbarHelper$updateUndoRedoButtons$1$canUndoDeferred$1(this.$provider, null), 2, null) : CompletableDeferredKt.CompletableDeferred(Boxing.boxBoolean(false));
                deferredAsync$default = this.$isRedoEnabled ? BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO(), null, new UndoRedoToolbarHelper$updateUndoRedoButtons$1$canRedoDeferred$1(this.$provider, null), 2, null) : CompletableDeferredKt.CompletableDeferred(Boxing.boxBoolean(false));
                jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new UndoRedoToolbarHelper$updateUndoRedoButtons$1$timeoutJob$1(deferredAsync$default2, deferredAsync$default, this.this$0, this.$onStateUpdated, null), 3, null);
                this.L$0 = coroutineScope;
                this.L$1 = SpillingKt.nullOutSpilledVariable(deferredAsync$default2);
                this.L$2 = deferredAsync$default;
                this.L$3 = jobLaunch$default;
                this.label = 1;
                objAwait = deferredAsync$default2.await(this);
                if (objAwait != coroutine_suspended) {
                    deferred = deferredAsync$default2;
                }
                return coroutine_suspended;
            }
            if (i2 == 1) {
                jobLaunch$default = (Job) this.L$3;
                Deferred deferred2 = (Deferred) this.L$2;
                deferred = (Deferred) this.L$1;
                ResultKt.throwOnFailure(obj);
                deferredAsync$default = deferred2;
                objAwait = obj;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.I$0;
                jobLaunch$default = (Job) this.L$3;
                ResultKt.throwOnFailure(obj);
                objAwait2 = obj;
            }
            if (((Boolean) objAwait2).booleanValue() || !this.$isRedoEnabled) {
                z = false;
            } else {
                z = true;
            }
            Job.DefaultImpls.cancel$default(jobLaunch$default, (CancellationException) null, 1, (Object) null);
            if (CoroutineScopeKt.isActive(coroutineScope)) {
                UndoRedoToolbarHelper undoRedoToolbarHelper = this.this$0;
                if (i != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                undoRedoToolbarHelper.applyButtonState(z2, z);
                function2 = this.$onStateUpdated;
                if (function2 != null) {
                    function2.invoke(Boxing.boxBoolean(i != 0), Boxing.boxBoolean(z));
                }
            }
            return Unit.INSTANCE;
            int i3 = (((Boolean) objAwait).booleanValue() && this.$isUndoEnabled) ? 1 : 0;
            this.L$0 = coroutineScope;
            this.L$1 = SpillingKt.nullOutSpilledVariable(deferred);
            this.L$2 = SpillingKt.nullOutSpilledVariable(deferredAsync$default);
            this.L$3 = jobLaunch$default;
            this.I$0 = i3;
            this.label = 2;
            objAwait2 = deferredAsync$default.await(this);
            if (objAwait2 != coroutine_suspended) {
                i = i3;
                if (((Boolean) objAwait2).booleanValue()) {
                    z = false;
                } else {
                    z = false;
                }
                Job.DefaultImpls.cancel$default(jobLaunch$default, (CancellationException) null, 1, (Object) null);
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    UndoRedoToolbarHelper undoRedoToolbarHelper2 = this.this$0;
                    if (i != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    undoRedoToolbarHelper2.applyButtonState(z2, z);
                    function2 = this.$onStateUpdated;
                    if (function2 != null) {
                        function2.invoke(Boxing.boxBoolean(i != 0), Boxing.boxBoolean(z));
                    }
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.pspdfkit.ui.toolbar.UndoRedoToolbarHelper$undoHistoryChangeListener$1] */
    public UndoRedoToolbarHelper(UndoRedoToolbarHost undoRedoToolbarHost, int i, int i2, int i3) {
        undoRedoToolbarHost.getClass();
        this.host = undoRedoToolbarHost;
        this.groupId = i;
        this.undoItemId = i2;
        this.redoItemId = i3;
        this.undoHistoryChangeListener = new OnUndoHistoryChangeListener() { // from class: com.pspdfkit.ui.toolbar.UndoRedoToolbarHelper$undoHistoryChangeListener$1
            @Override // com.pspdfkit.undo.OnUndoHistoryChangeListener
            public void onUndoHistoryChanged(UndoManager undoManager) {
                undoManager.getClass();
                UndoRedoToolbarHelper.updateUndoRedoButtons$default(this.this$0, null, 1, null);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyButtonState(boolean undoEnabled, boolean redoEnabled) {
        this.host.setMenuItemEnabled(this.groupId, undoEnabled || redoEnabled);
        this.host.setMenuItemEnabled(this.undoItemId, undoEnabled);
        this.host.setMenuItemEnabled(this.redoItemId, redoEnabled);
        c70 c70Var = this.undoRedoDrawable;
        if (c70Var != null) {
            Drawable drawable = c70Var.a;
            if (drawable != null) {
                drawable.setAlpha(undoEnabled ? 255 : 128);
                c70Var.invalidateSelf();
            }
            Drawable drawable2 = c70Var.b;
            if (drawable2 != null) {
                drawable2.setAlpha(redoEnabled ? 255 : 128);
                c70Var.invalidateSelf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean executeRedo$lambda$0(UndoProvider undoProvider) {
        undoProvider.getClass();
        return undoProvider.canRedo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean executeUndo$lambda$0(UndoProvider undoProvider) {
        undoProvider.getClass();
        return undoProvider.canUndo();
    }

    private final boolean executeUndoRedoOperation(Function1<? super UndoProvider, Boolean> canExecute, Function2<? super UndoProvider, ? super Continuation<? super Unit>, ? extends Object> operation, String operationName) {
        LifecycleOwner lifecycleOwner;
        LifecycleCoroutineScope lifecycleScope;
        UndoProvider undoProvider = this.provider;
        if (undoProvider == null || (lifecycleOwner = this.host.getLifecycleOwner()) == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) == null) {
            return false;
        }
        Job job = this.undoRedoExecutionJob;
        if (job != null && job.isActive()) {
            return false;
        }
        this.undoRedoExecutionJob = BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new AnonymousClass1(canExecute, undoProvider, operationName, operation, null), 3, null);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateUndoRedoButtons$default(UndoRedoToolbarHelper undoRedoToolbarHelper, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = null;
        }
        undoRedoToolbarHelper.updateUndoRedoButtons(function2);
    }

    public final List<ContextualToolbarMenuItem> addUndoRedoMenuItems(Context context, PdfConfiguration configuration, int undoStringId, int redoStringId, int undoIcon, int redoIcon, int iconColor, int iconColorActivated) {
        context.getClass();
        ArrayList arrayList = new ArrayList();
        boolean z = configuration == null || configuration.isUndoEnabled();
        if (z) {
            int i = this.undoItemId;
            Drawable drawable = AppCompatResources.getDrawable(context, undoIcon);
            drawable.getClass();
            String strA = no.a(context, undoStringId, null);
            ContextualToolbarMenuItem.Position position = ContextualToolbarMenuItem.Position.END;
            ContextualToolbarMenuItem contextualToolbarMenuItemCreateSingleItem = ContextualToolbarMenuItem.createSingleItem(context, i, drawable, strA, iconColor, iconColorActivated, position, false);
            contextualToolbarMenuItemCreateSingleItem.getClass();
            arrayList.add(contextualToolbarMenuItemCreateSingleItem);
            boolean z2 = configuration == null || configuration.isRedoEnabled();
            if (z2) {
                int i2 = this.redoItemId;
                Drawable drawable2 = AppCompatResources.getDrawable(context, redoIcon);
                drawable2.getClass();
                ContextualToolbarMenuItem contextualToolbarMenuItemCreateSingleItem2 = ContextualToolbarMenuItem.createSingleItem(context, i2, drawable2, no.a(context, redoStringId, null), iconColor, iconColorActivated, position, false);
                contextualToolbarMenuItemCreateSingleItem2.getClass();
                arrayList.add(contextualToolbarMenuItemCreateSingleItem2);
            }
            c70 c70Var = new c70(context, z, z2, undoIcon, redoIcon);
            this.undoRedoDrawable = c70Var;
            ContextualToolbarMenuItem contextualToolbarMenuItemCreateGroupItem = ContextualToolbarMenuItem.createGroupItem(this.groupId, position, false, new ArrayList(), ContextualToolbarMenuItem.createSingleItem(context, this.undoItemId, c70Var, no.a(context, undoStringId, null), iconColor, iconColorActivated, position, false));
            contextualToolbarMenuItemCreateGroupItem.setOpenSubmenuOnClick(false);
            contextualToolbarMenuItemCreateGroupItem.setCloseSubmenuOnItemClick(false);
            arrayList.add(contextualToolbarMenuItemCreateGroupItem);
            updateUndoRedoButtons$default(this, null, 1, null);
        }
        return arrayList;
    }

    public final void bindProvider(UndoProvider provider) {
        provider.getClass();
        this.provider = provider;
    }

    public final void bindUndoManager(PdfFragment pdfFragment) {
        pdfFragment.getClass();
        if (pdfFragment.getConfiguration().isUndoEnabled()) {
            this.undoManager = pdfFragment.getUndoManager();
            UndoManager undoManager = pdfFragment.getUndoManager();
            undoManager.getClass();
            this.provider = new UndoManagerUndoProvider(undoManager);
            UndoManager undoManager2 = this.undoManager;
            if (undoManager2 != null) {
                undoManager2.addOnUndoHistoryChangeListener(this.undoHistoryChangeListener);
            }
        }
    }

    public final boolean executeRedo() {
        return executeUndoRedoOperation(new Function1() { // from class: com.pspdfkit.ui.toolbar.UndoRedoToolbarHelper$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UndoRedoToolbarHelper.executeRedo$lambda$0((UndoProvider) obj));
            }
        }, new AnonymousClass2(null), "redo");
    }

    public final boolean executeUndo() {
        return executeUndoRedoOperation(new Function1() { // from class: com.pspdfkit.ui.toolbar.UndoRedoToolbarHelper$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UndoRedoToolbarHelper.executeUndo$lambda$0((UndoProvider) obj));
            }
        }, new C18642(null), "undo");
    }

    public final void unbindUndoManager() {
        Job job = this.undoRedoCheckJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.undoRedoCheckJob = null;
        Job job2 = this.undoRedoExecutionJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.undoRedoExecutionJob = null;
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.removeOnUndoHistoryChangeListener(this.undoHistoryChangeListener);
        }
        this.undoManager = null;
        this.provider = null;
    }

    public final void updateUndoRedoButtons(Function2<? super Boolean, ? super Boolean, Unit> onStateUpdated) {
        LifecycleCoroutineScope lifecycleScope;
        UndoProvider undoProvider = this.provider;
        if (undoProvider == null) {
            return;
        }
        PdfConfiguration configuration = this.host.getConfiguration();
        boolean z = true;
        boolean z2 = false;
        if (configuration != null && !configuration.isUndoEnabled()) {
            z = false;
        }
        if (configuration == null || configuration.isRedoEnabled()) {
            z2 = z;
        }
        if (!z && !z2) {
            applyButtonState(false, z2);
            if (onStateUpdated != null) {
                Boolean bool = Boolean.FALSE;
                onStateUpdated.invoke(bool, bool);
                return;
            }
            return;
        }
        Job job = this.undoRedoExecutionJob;
        if (job != null && job.isActive()) {
            applyButtonState(z2, z2);
            if (onStateUpdated != null) {
                Boolean bool2 = Boolean.FALSE;
                onStateUpdated.invoke(bool2, bool2);
                return;
            }
            return;
        }
        Job job2 = this.undoRedoCheckJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, (int) z, (Object) null);
        }
        LifecycleOwner lifecycleOwner = this.host.getLifecycleOwner();
        if (lifecycleOwner == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) == null) {
            return;
        }
        this.undoRedoCheckJob = BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new C18651(z, z2, this, onStateUpdated, undoProvider, null), 3, null);
    }
}
