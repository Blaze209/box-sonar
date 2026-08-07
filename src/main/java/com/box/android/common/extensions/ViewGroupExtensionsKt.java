package com.box.android.common.extensions;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: ViewGroupExtensions.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003¨\u0006\u0004"}, d2 = {"recursiveChildren", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "Landroid/view/ViewGroup;", "common_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ViewGroupExtensionsKt {

    /* JADX INFO: renamed from: com.box.android.common.extensions.ViewGroupExtensionsKt$recursiveChildren$1, reason: invalid class name */
    /* JADX INFO: compiled from: ViewGroupExtensions.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Landroid/view/View;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.common.extensions.ViewGroupExtensionsKt$recursiveChildren$1", f = "ViewGroupExtensions.kt", i = {0, 0, 0, 1, 1, 1}, l = {12, 14}, m = "invokeSuspend", n = {"$this$sequence", "child", "i", "$this$sequence", "child", "i"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0"}, v = 1)
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super View>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ViewGroup $this_recursiveChildren;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ViewGroup viewGroup, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_recursiveChildren = viewGroup;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_recursiveChildren, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super View> sequenceScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:12:0x003e  */
        /* JADX WARN: Code duplicated, block: B:15:0x005b  */
        /* JADX WARN: Code duplicated, block: B:18:0x0061  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005f -> B:21:0x0080). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x007d -> B:21:0x0080). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = r8.L$0
                kotlin.sequences.SequenceScope r0 = (kotlin.sequences.SequenceScope) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r8.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L32
                if (r2 == r4) goto L26
                if (r2 != r3) goto L1e
                int r2 = r8.I$1
                int r5 = r8.I$0
                java.lang.Object r6 = r8.L$1
                android.view.View r6 = (android.view.View) r6
                kotlin.ResultKt.throwOnFailure(r9)
                goto L80
            L1e:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L26:
                int r2 = r8.I$1
                int r5 = r8.I$0
                java.lang.Object r6 = r8.L$1
                android.view.View r6 = (android.view.View) r6
                kotlin.ResultKt.throwOnFailure(r9)
                goto L5d
            L32:
                kotlin.ResultKt.throwOnFailure(r9)
                android.view.ViewGroup r9 = r8.$this_recursiveChildren
                int r9 = r9.getChildCount()
                r2 = 0
            L3c:
                if (r2 >= r9) goto L84
                android.view.ViewGroup r5 = r8.$this_recursiveChildren
                android.view.View r6 = r5.getChildAt(r2)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
                r5 = r8
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r8.L$0 = r0
                r8.L$1 = r6
                r8.I$0 = r2
                r8.I$1 = r9
                r8.label = r4
                java.lang.Object r5 = r0.yield(r6, r5)
                if (r5 != r1) goto L5b
                goto L7f
            L5b:
                r5 = r2
                r2 = r9
            L5d:
                boolean r9 = r6 instanceof android.view.ViewGroup
                if (r9 == 0) goto L80
                r9 = r6
                android.view.ViewGroup r9 = (android.view.ViewGroup) r9
                kotlin.sequences.Sequence r9 = com.box.android.common.extensions.ViewGroupExtensionsKt.recursiveChildren(r9)
                r7 = r8
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r8.L$0 = r0
                java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
                r8.L$1 = r6
                r8.I$0 = r5
                r8.I$1 = r2
                r8.label = r3
                java.lang.Object r9 = r0.yieldAll(r9, r7)
                if (r9 != r1) goto L80
            L7f:
                return r1
            L80:
                r9 = r2
                int r2 = r5 + 1
                goto L3c
            L84:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.common.extensions.ViewGroupExtensionsKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final Sequence<View> recursiveChildren(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        return SequencesKt.sequence(new AnonymousClass1(viewGroup, null));
    }
}
