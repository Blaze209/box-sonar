package com.box.android.domain.models;

import com.box.android.domain.jobs.JobConstants;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.androidsdk.content.SizeUtils;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: DisplayableJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eH¦@¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0012H&¢\u0006\u0002\u0010\u0013R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/models/IJobDisplayInfoProvider;", "", "getName", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getItemDescription", "iconResId", "", "getIconResId", "()I", "jobType", "getJobType", "()Ljava/lang/String;", "getItemModel", "Lcom/box/android/domain/models/item/ItemModel;", "getServerId", "errorStringRes", "error", "Lcom/box/android/domain/models/DomainError;", "(Lcom/box/android/domain/models/DomainError;)Ljava/lang/Integer;", JobConstants.SHOW_NOTIFICATION, "", "getShowNotification", "()Z", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IJobDisplayInfoProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String DEFAULT_JOB_DESCRIPTION_TEMPLATE = "%s • %s";

    /* JADX INFO: renamed from: com.box.android.domain.models.IJobDisplayInfoProvider$getItemDescription$1, reason: invalid class name */
    /* JADX INFO: compiled from: DisplayableJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.models.IJobDisplayInfoProvider", f = "DisplayableJob.kt", i = {0}, l = {20}, m = "getItemDescription$suspendImpl", n = {"$this"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IJobDisplayInfoProvider.getItemDescription$suspendImpl(IJobDisplayInfoProvider.this, this);
        }
    }

    Integer errorStringRes(DomainError error);

    int getIconResId();

    default Object getItemDescription(Continuation<? super String> continuation) {
        return getItemDescription$suspendImpl(this, continuation);
    }

    Object getItemModel(Continuation<? super ItemModel> continuation);

    String getJobType();

    Object getName(Continuation<? super String> continuation);

    Object getServerId(Continuation<? super String> continuation);

    default boolean getShowNotification() {
        return false;
    }

    /* JADX INFO: compiled from: DisplayableJob.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/box/android/domain/models/IJobDisplayInfoProvider$Companion;", "", "<init>", "()V", "DEFAULT_JOB_DESCRIPTION_TEMPLATE", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String DEFAULT_JOB_DESCRIPTION_TEMPLATE = "%s • %s";

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: DisplayableJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Object getItemDescription(IJobDisplayInfoProvider iJobDisplayInfoProvider, Continuation<? super String> continuation) {
            return IJobDisplayInfoProvider.super.getItemDescription(continuation);
        }

        @Deprecated
        public static boolean getShowNotification(IJobDisplayInfoProvider iJobDisplayInfoProvider) {
            return IJobDisplayInfoProvider.super.getShowNotification();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object getItemDescription$suspendImpl(IJobDisplayInfoProvider iJobDisplayInfoProvider, Continuation<? super String> continuation) {
        AnonymousClass1 anonymousClass1;
        String formattedSize;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = iJobDisplayInfoProvider.new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = iJobDisplayInfoProvider.new AnonymousClass1(continuation);
        }
        Object itemModel = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(itemModel);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(iJobDisplayInfoProvider);
            anonymousClass1.label = 1;
            itemModel = iJobDisplayInfoProvider.getItemModel(anonymousClass1);
            if (itemModel == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(itemModel);
        }
        ItemModel itemModel2 = (ItemModel) itemModel;
        String str = "";
        if (itemModel2 == null) {
            return "";
        }
        String strParentConsideringRootFolder = ItemModelKt.parentConsideringRootFolder(itemModel2);
        Long size = itemModel2.getSize();
        if (size != null && (formattedSize = SizeUtils.INSTANCE.toFormattedSize(size.longValue())) != null) {
            str = formattedSize;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = String.format(Locale.ENGLISH, "%s • %s", Arrays.copyOf(new Object[]{strParentConsideringRootFolder, str}, 2));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }
}
