package com.pspdfkit.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import io.nutrient.domain.ai.AiAssistant;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends ViewModel {
    public static final /* synthetic */ int i = 0;
    public final AiAssistant a;
    public final String b;
    public final SavedStateHandle c;
    public final da d;
    public final MutableState e;
    public String f;
    public final MutableStateFlow<b0> g;
    public final StateFlow<b0> h;

    public static final class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new C0271a();
        public final String a;
        public final int b;

        /* JADX INFO: renamed from: com.pspdfkit.internal.f0$a$a, reason: collision with other inner class name */
        public static final class C0271a implements Parcelable.Creator<a> {
            @Override // android.os.Parcelable.Creator
            public final a createFromParcel(Parcel parcel) {
                parcel.getClass();
                return new a(parcel.readString(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            public final a[] newArray(int i) {
                return new a[i];
            }
        }

        public a(String str, int i) {
            str.getClass();
            this.a = str;
            this.b = i;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && this.b == aVar.b;
        }

        public final int hashCode() {
            return Integer.hashCode(this.b) + (this.a.hashCode() * 31);
        }

        public final String toString() {
            return "TextSelection(query=" + this.a + ", selectionIndex=" + this.b + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.getClass();
            parcel.writeString(this.a);
            parcel.writeInt(this.b);
        }
    }

    @DebugMetadata(c = "io.nutrient.internal.ui.ai.AiAssistantViewModel$onSubmitMessage$1", f = "AiAssistantViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public /* synthetic */ Object a;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = f0.this.new b(continuation);
            bVar.a = obj;
            return bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            b bVar = f0.this.new b(continuation);
            bVar.a = coroutineScope;
            return bVar.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            b0 value;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            b0.a aVar = f0.this.g.getValue().f;
            f0 f0Var = f0.this;
            AiAssistant aiAssistant = f0Var.a;
            if (aVar != null) {
                aiAssistant.emitContextSpecificMessage(((a) f0Var.e.getValue()).a, aVar.a);
                f0Var.e.setValue(new a("", 0));
                MutableStateFlow<b0> mutableStateFlow = f0Var.g;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, b0.a(value, false, false, false, false, null, null, 31)));
            } else {
                aiAssistant.emitMessage(((a) f0Var.e.getValue()).a);
                f0Var.e.setValue(new a("", 0));
            }
            return Unit.INSTANCE;
        }
    }

    public f0(AiAssistant aiAssistant, String str, SavedStateHandle savedStateHandle, da daVar) {
        aiAssistant.getClass();
        savedStateHandle.getClass();
        this.a = aiAssistant;
        this.b = str;
        this.c = savedStateHandle;
        this.d = daVar;
        a aVar = (a) savedStateHandle.get("message_query");
        int i2 = 0;
        this.e = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(aVar == null ? new a("", 0) : aVar, null, 2, null);
        this.f = "";
        MutableStateFlow<b0> MutableStateFlow = StateFlowKt.MutableStateFlow(new b0(i2));
        this.g = MutableStateFlow;
        this.h = FlowKt.asStateFlow(MutableStateFlow);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new c0(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new d0(this, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        if (((a) this.e.getValue()).a.length() == 0) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new b(null), 3, null);
    }
}
