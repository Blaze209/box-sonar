package com.pspdfkit.internal;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import io.nutrient.data.models.AdditionalContext;
import io.nutrient.data.models.AiAssistantEvents;
import io.nutrient.data.models.CompletionResponse;
import io.nutrient.data.models.DocumentErrorStates;
import io.nutrient.data.models.Issuer;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.nutrient.internal.ui.ai.AiAssistantViewModel$2", f = "AiAssistantViewModel.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, nl = {206}, s = {}, v = 2)
public final class d0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ f0 b;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ f0 a;

        public a(f0 f0Var) {
            this.a = f0Var;
        }

        /* JADX WARN: Code duplicated, block: B:60:0x019e  */
        /* JADX WARN: Code duplicated, block: B:62:0x01a4  */
        /* JADX WARN: Code duplicated, block: B:63:0x01be  */
        /* JADX WARN: Code duplicated, block: B:65:0x01d0  */
        /* JADX WARN: Code duplicated, block: B:83:0x0283  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, Continuation continuation) {
            b0 value;
            b0 value2;
            b0 b0Var;
            b0 value3;
            b0 b0Var2;
            b0 b0Var3;
            CompletionResponse completionResponse;
            b0 b0VarA;
            MutableStateFlow<b0> mutableStateFlow;
            b0 b0Var4;
            b0 b0Var5;
            List list;
            b0 value4;
            b0 b0Var6;
            CompletionResponse completionResponse2;
            b0 value5;
            Object objEmitSelectedText;
            b0 value6;
            b0 b0Var7;
            CompletionResponse completionResponseCopy$default = (CompletionResponse) obj;
            if (completionResponseCopy$default == null) {
                return Unit.INSTANCE;
            }
            AiAssistantEvents state = completionResponseCopy$default.getState();
            if (state instanceof AiAssistantEvents.Error) {
                CompletionResponse completionResponse3 = (CompletionResponse) CollectionsKt.lastOrNull((List) this.a.h.getValue().e);
                if (completionResponse3 != null && Intrinsics.areEqual(completionResponse3.getContent(), completionResponseCopy$default.getContent())) {
                    return Unit.INSTANCE;
                }
                MutableStateFlow<b0> mutableStateFlow2 = this.a.g;
                do {
                    value6 = mutableStateFlow2.getValue();
                    b0Var7 = value6;
                    b0Var7.getClass();
                } while (!mutableStateFlow2.compareAndSet(value6, b0.a(b0Var7, false, false, false, false, ExtensionsKt.toPersistentList(CollectionsKt.plus((Collection<? extends CompletionResponse>) b0Var7.e, completionResponseCopy$default)), null, 34)));
            } else if (state instanceof AiAssistantEvents.SocketConnected) {
                MutableStateFlow<b0> mutableStateFlow3 = this.a.g;
                do {
                    value5 = mutableStateFlow3.getValue();
                } while (!mutableStateFlow3.compareAndSet(value5, b0.a(value5, false, false, false, true, null, null, 50)));
                if (this.a.f.length() > 0) {
                    f0 f0Var = this.a;
                    String str = this.a.f;
                    TextFieldValue textFieldValue = new TextFieldValue(str, TextRangeKt.TextRange(str.length()), (TextRange) null, 4, (DefaultConstructorMarker) null);
                    f0Var.e.setValue(new f0.a(textFieldValue.getText(), TextRange.m9091getStartimpl(textFieldValue.getSelection())));
                    f0Var.c.set("message_query", (f0.a) f0Var.e.getValue());
                    f0 f0Var2 = this.a;
                    f0Var2.f = "";
                    f0Var2.a();
                }
                f0 f0Var3 = this.a;
                String str2 = f0Var3.b;
                if (str2 != null && (objEmitSelectedText = f0Var3.a.emitSelectedText(str2, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return objEmitSelectedText;
                }
            } else if (state instanceof AiAssistantEvents.SocketDisconnected) {
                CompletionResponse completionResponse4 = (CompletionResponse) CollectionsKt.lastOrNull((List) this.a.h.getValue().e);
                if (completionResponse4 != null && Intrinsics.areEqual(completionResponse4.getContent(), completionResponseCopy$default.getContent())) {
                    return Unit.INSTANCE;
                }
                MutableStateFlow<b0> mutableStateFlow4 = this.a.g;
                do {
                    value4 = mutableStateFlow4.getValue();
                    b0Var6 = value4;
                    String content = completionResponseCopy$default.getContent();
                    if (content == null) {
                        content = "Socket Disconnected";
                    }
                    completionResponse2 = new CompletionResponse((String) null, (String) null, (List) null, 0L, 0, (String) null, true, (List) null, (AdditionalContext) null, (List) null, (AiAssistantEvents) new AiAssistantEvents.Error(content, DocumentErrorStates.INTERNET_NOT_AVAILABLE, false, 4, null), 959, (DefaultConstructorMarker) null);
                    b0Var6.getClass();
                } while (!mutableStateFlow4.compareAndSet(value4, b0.a(b0Var6, false, false, false, false, ExtensionsKt.toPersistentList(CollectionsKt.plus((Collection<? extends CompletionResponse>) b0Var6.e, completionResponse2)), null, 34)));
            } else if (state instanceof AiAssistantEvents.Chat) {
                MutableStateFlow<b0> mutableStateFlow5 = this.a.g;
                while (true) {
                    b0 value7 = mutableStateFlow5.getValue();
                    b0 b0Var8 = value7;
                    if (completionResponseCopy$default.getSender().length() != 0) {
                        if (Intrinsics.areEqual(completionResponseCopy$default.getSender(), Issuer.INSTANCE.value(Issuer.AI)) || !completionResponseCopy$default.getEnd()) {
                            b0Var3 = value7;
                            completionResponse = completionResponseCopy$default;
                            mutableStateFlow5 = mutableStateFlow5;
                            b0VarA = b0.a(b0Var8, false, false, false, false, b0Var8.a(completionResponse), null, 46);
                        } else {
                            CompletionResponse completionResponse5 = (CompletionResponse) CollectionsKt.lastOrNull((List) b0Var8.e);
                            if (Intrinsics.areEqual(completionResponse5 != null ? completionResponse5.getRequestId() : null, "evaluation-license") || completionResponse5 == null) {
                                b0Var3 = value7;
                                completionResponse = completionResponseCopy$default;
                                mutableStateFlow5 = mutableStateFlow5;
                                b0VarA = b0.a(b0Var8, false, false, false, true, ExtensionsKt.toPersistentList(CollectionsKt.plus((Collection<? extends CompletionResponse>) b0Var8.e, completionResponse)), null, 34);
                            } else {
                                ImmutableList<CompletionResponse> immutableList = b0Var8.e;
                                String content2 = immutableList.get(immutableList.size() - 1).getContent();
                                List mutableList = CollectionsKt.toMutableList((Collection) b0Var8.e);
                                int size = b0Var8.e.size() - 1;
                                String content3 = completionResponseCopy$default.getContent();
                                if (content3 == null || content3.length() == 0) {
                                    CompletionResponse completionResponse6 = completionResponseCopy$default;
                                    b0Var5 = b0Var8;
                                    b0Var3 = value7;
                                    list = mutableList;
                                    completionResponseCopy$default = CompletionResponse.copy$default(completionResponse6, null, null, null, 0L, 0, content2, false, null, null, null, null, 2015, null);
                                    completionResponse = completionResponse6;
                                    size = size;
                                } else {
                                    b0Var3 = value7;
                                    completionResponse = completionResponseCopy$default;
                                    b0Var5 = b0Var8;
                                    list = mutableList;
                                }
                                list.set(size, completionResponseCopy$default);
                                b0VarA = b0.a(b0Var5, false, false, false, true, ExtensionsKt.toPersistentList(list), null, 34);
                            }
                        }
                        mutableStateFlow = mutableStateFlow5;
                        b0Var4 = b0Var3;
                    } else if (!b0Var8.e.isEmpty()) {
                        CompletionResponse completionResponse7 = (CompletionResponse) CollectionsKt.lastOrNull((List) b0Var8.e);
                        if ((completionResponse7 != null ? completionResponse7.getState() : null) instanceof AiAssistantEvents.Chat) {
                            if (Intrinsics.areEqual(completionResponseCopy$default.getSender(), Issuer.INSTANCE.value(Issuer.AI))) {
                                b0Var3 = value7;
                                completionResponse = completionResponseCopy$default;
                                mutableStateFlow5 = mutableStateFlow5;
                                b0VarA = b0.a(b0Var8, false, false, false, false, b0Var8.a(completionResponse), null, 46);
                            } else {
                                b0Var3 = value7;
                                completionResponse = completionResponseCopy$default;
                                mutableStateFlow5 = mutableStateFlow5;
                                b0VarA = b0.a(b0Var8, false, false, false, false, b0Var8.a(completionResponse), null, 46);
                            }
                            mutableStateFlow = mutableStateFlow5;
                            b0Var4 = b0Var3;
                        } else if (completionResponseCopy$default.getEnd()) {
                            if (Intrinsics.areEqual(completionResponseCopy$default.getSender(), Issuer.INSTANCE.value(Issuer.AI))) {
                                b0Var3 = value7;
                                completionResponse = completionResponseCopy$default;
                                mutableStateFlow5 = mutableStateFlow5;
                                b0VarA = b0.a(b0Var8, false, false, false, false, b0Var8.a(completionResponse), null, 46);
                            } else {
                                b0Var3 = value7;
                                completionResponse = completionResponseCopy$default;
                                mutableStateFlow5 = mutableStateFlow5;
                                b0VarA = b0.a(b0Var8, false, false, false, false, b0Var8.a(completionResponse), null, 46);
                            }
                            mutableStateFlow = mutableStateFlow5;
                            b0Var4 = b0Var3;
                        } else {
                            b0VarA = b0.a(b0Var8, false, false, false, false, ExtensionsKt.toPersistentList(CollectionsKt.plus((Collection<? extends CompletionResponse>) b0Var8.e, completionResponseCopy$default)), null, 46);
                            b0Var4 = value7;
                            completionResponse = completionResponseCopy$default;
                            mutableStateFlow = mutableStateFlow5;
                        }
                    } else if (completionResponseCopy$default.getEnd()) {
                        b0VarA = b0.a(b0Var8, false, false, false, false, ExtensionsKt.toPersistentList(CollectionsKt.plus((Collection<? extends CompletionResponse>) b0Var8.e, completionResponseCopy$default)), null, 46);
                        b0Var4 = value7;
                        completionResponse = completionResponseCopy$default;
                        mutableStateFlow = mutableStateFlow5;
                    } else {
                        if (Intrinsics.areEqual(completionResponseCopy$default.getSender(), Issuer.INSTANCE.value(Issuer.AI))) {
                            b0Var3 = value7;
                            completionResponse = completionResponseCopy$default;
                            mutableStateFlow5 = mutableStateFlow5;
                            b0VarA = b0.a(b0Var8, false, false, false, false, b0Var8.a(completionResponse), null, 46);
                        } else {
                            b0Var3 = value7;
                            completionResponse = completionResponseCopy$default;
                            mutableStateFlow5 = mutableStateFlow5;
                            b0VarA = b0.a(b0Var8, false, false, false, false, b0Var8.a(completionResponse), null, 46);
                        }
                        mutableStateFlow = mutableStateFlow5;
                        b0Var4 = b0Var3;
                    }
                    if (mutableStateFlow.compareAndSet(b0Var4, b0VarA)) {
                        break;
                    }
                    mutableStateFlow5 = mutableStateFlow;
                    completionResponseCopy$default = completionResponse;
                }
            } else if (state instanceof AiAssistantEvents.Success) {
                MutableStateFlow<b0> mutableStateFlow6 = this.a.g;
                do {
                    value3 = mutableStateFlow6.getValue();
                    b0Var2 = value3;
                    b0Var2.getClass();
                } while (!mutableStateFlow6.compareAndSet(value3, b0.a(b0Var2, false, false, false, false, ExtensionsKt.toPersistentList(CollectionsKt.plus((Collection<? extends CompletionResponse>) b0Var2.e, completionResponseCopy$default)), null, 42)));
            } else {
                if (!(state instanceof AiAssistantEvents.Loading)) {
                    throw new NoWhenBranchMatchedException();
                }
                boolean zAreEqual = Intrinsics.areEqual(completionResponseCopy$default.getSender(), Issuer.INSTANCE.value(Issuer.HUMAN));
                MutableStateFlow<b0> mutableStateFlow7 = this.a.g;
                if (zAreEqual) {
                    do {
                        value2 = mutableStateFlow7.getValue();
                        b0Var = value2;
                        b0Var.getClass();
                    } while (!mutableStateFlow7.compareAndSet(value2, b0.a(b0Var, false, false, true, false, ExtensionsKt.toPersistentList(CollectionsKt.plus((Collection<? extends CompletionResponse>) b0Var.e, completionResponseCopy$default)), null, 35)));
                } else {
                    do {
                        value = mutableStateFlow7.getValue();
                    } while (!mutableStateFlow7.compareAndSet(value, b0.a(value, true, false, false, false, null, null, 62)));
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(f0 f0Var, Continuation<? super d0> continuation) {
        super(2, continuation);
        this.b = f0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new d0(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new d0(this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<CompletionResponse> responseState = this.b.a.getResponseState();
            a aVar = new a(this.b);
            this.a = 1;
            if (responseState.collect(aVar, this) == coroutine_suspended) {
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
