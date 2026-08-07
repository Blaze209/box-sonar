package com.margelo.nitro.boxcontext;

import com.facebook.react.modules.dialog.AlertFragment;
import com.margelo.nitro.core.Promise;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: HostNavigationService.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001H\n"}, d2 = {"<anonymous>", "", "Lcom/margelo/nitro/boxcontext/ItemStatus;", "selected", "Lcom/margelo/nitro/boxcontext/ItemIdentifier;", AlertFragment.ARG_ITEMS}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.margelo.nitro.boxcontext.HostNavigationService$openContentPicker$1$items$1", f = "HostNavigationService.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
final class HostNavigationService$openContentPicker$1$items$1 extends SuspendLambda implements Function3<List<? extends ItemIdentifier>, List<? extends ItemIdentifier>, Continuation<? super List<? extends ItemStatus>>, Object> {
    final /* synthetic */ Function2<ItemIdentifier[], ItemIdentifier[], Promise<ItemStatus[]>> $getItemsStatus;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    HostNavigationService$openContentPicker$1$items$1(Function2<? super ItemIdentifier[], ? super ItemIdentifier[], Promise<ItemStatus[]>> function2, Continuation<? super HostNavigationService$openContentPicker$1$items$1> continuation) {
        super(3, continuation);
        this.$getItemsStatus = function2;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(List<? extends ItemIdentifier> list, List<? extends ItemIdentifier> list2, Continuation<? super List<? extends ItemStatus>> continuation) {
        return invoke2((List<ItemIdentifier>) list, (List<ItemIdentifier>) list2, (Continuation<? super List<ItemStatus>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<ItemIdentifier> list, List<ItemIdentifier> list2, Continuation<? super List<ItemStatus>> continuation) {
        HostNavigationService$openContentPicker$1$items$1 hostNavigationService$openContentPicker$1$items$1 = new HostNavigationService$openContentPicker$1$items$1(this.$getItemsStatus, continuation);
        hostNavigationService$openContentPicker$1$items$1.L$0 = list;
        hostNavigationService$openContentPicker$1$items$1.L$1 = list2;
        return hostNavigationService$openContentPicker$1$items$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            List list = (List) this.L$0;
            List list2 = (List) this.L$1;
            this.L$0 = null;
            this.label = 1;
            obj = ((Promise) this.$getItemsStatus.invoke(list.toArray(new ItemIdentifier[0]), list2.toArray(new ItemIdentifier[0]))).await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return ArraysKt.toList((Object[]) obj);
    }
}
