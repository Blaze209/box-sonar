package com.box.android.domain.configuration;

import com.box.android.domain.identity.IUserContextManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IFeatureFlip.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/box/android/domain/configuration/FeatureFlipEvaluator;", "", "splitConfiguration", "Lcom/box/android/domain/configuration/ISplitConfiguration;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Lcom/box/android/domain/configuration/ISplitConfiguration;Lcom/box/android/domain/identity/IUserContextManager;)V", "evaluate", "", "rule", "Lcom/box/android/domain/configuration/FeatureFlipRule;", "(Lcom/box/android/domain/configuration/FeatureFlipRule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FeatureFlipEvaluator {
    private final ISplitConfiguration splitConfiguration;
    private final IUserContextManager userContextManager;

    /* JADX INFO: renamed from: com.box.android.domain.configuration.FeatureFlipEvaluator$evaluate$1, reason: invalid class name */
    /* JADX INFO: compiled from: IFeatureFlip.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.configuration.FeatureFlipEvaluator", f = "IFeatureFlip.kt", i = {0, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {78, 80, 92, 94}, m = "evaluate", n = {"rule", "rule", "rule", "$this$all$iv", "element$iv", "it", "$i$f$all", "$i$a$-all-FeatureFlipEvaluator$evaluate$2", "rule", "$this$any$iv", "element$iv", "it", "$i$f$any", "$i$a$-any-FeatureFlipEvaluator$evaluate$3"}, s = {"L$0", "L$0", "L$0", "L$1", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$3", "L$4", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FeatureFlipEvaluator.this.evaluate(null, this);
        }
    }

    @Inject
    public FeatureFlipEvaluator(ISplitConfiguration splitConfiguration, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(splitConfiguration, "splitConfiguration");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.splitConfiguration = splitConfiguration;
        this.userContextManager = userContextManager;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:107:0x0221  */
    /* JADX WARN: Code duplicated, block: B:111:0x022f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:107:0x0221 -> B:15:0x004d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x01b7 -> B:19:0x0076). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object evaluate(com.box.android.domain.configuration.FeatureFlipRule r12, kotlin.coroutines.Continuation<? super java.lang.Boolean> r13) {
        /*
            Method dump skipped, instruction units count: 575
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.configuration.FeatureFlipEvaluator.evaluate(com.box.android.domain.configuration.FeatureFlipRule, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
