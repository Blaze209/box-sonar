package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.exifinterface.media.ExifInterface;
import com.box.android.common.utilities.BoxCommonConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: ButtonGroup.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.EnlargeOnPressNode$launchCollectionJob$1", f = "ButtonGroup.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class EnlargeOnPressNode$launchCollectionJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EnlargeOnPressNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EnlargeOnPressNode$launchCollectionJob$1(EnlargeOnPressNode enlargeOnPressNode, Continuation<? super EnlargeOnPressNode$launchCollectionJob$1> continuation) {
        super(2, continuation);
        this.this$0 = enlargeOnPressNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        EnlargeOnPressNode$launchCollectionJob$1 enlargeOnPressNode$launchCollectionJob$1 = new EnlargeOnPressNode$launchCollectionJob$1(this.this$0, continuation);
        enlargeOnPressNode$launchCollectionJob$1.L$0 = obj;
        return enlargeOnPressNode$launchCollectionJob$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EnlargeOnPressNode$launchCollectionJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, null, null, new AnonymousClass1(this.this$0, new ArrayList(), null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.material3.EnlargeOnPressNode$launchCollectionJob$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: ButtonGroup.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.EnlargeOnPressNode$launchCollectionJob$1$1", f = "ButtonGroup.kt", i = {}, l = {1129}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<PressInteraction.Press> $pressInteractions;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ EnlargeOnPressNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(EnlargeOnPressNode enlargeOnPressNode, List<PressInteraction.Press> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = enlargeOnPressNode;
            this.$pressInteractions = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$pressInteractions, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                final Flow<Interaction> interactions = this.this$0.getInteractionSource().getInteractions();
                final List<PressInteraction.Press> list = this.$pressInteractions;
                this.label = 1;
                if (FlowKt.collectLatest(FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: androidx.compose.material3.EnlargeOnPressNode$launchCollectionJob$1$1$invokeSuspend$$inlined$map$1
                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                        Object objCollect = interactions.collect(new AnonymousClass2(flowCollector, list), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: androidx.compose.material3.EnlargeOnPressNode$launchCollectionJob$1$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ List $pressInteractions$inlined;
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: androidx.compose.material3.EnlargeOnPressNode$launchCollectionJob$1$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.EnlargeOnPressNode$launchCollectionJob$1$1$invokeSuspend$$inlined$map$1$2", f = "ButtonGroup.kt", i = {}, l = {BoxCommonConstants.REQUEST_INVITE_COLLABORATORS}, m = "emit", n = {}, s = {}, v = 1)
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector, List list) {
                            this.$this_unsafeFlow = flowCollector;
                            this.$pressInteractions$inlined = list;
                        }

                        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object obj, Continuation continuation) {
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
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = anonymousClass1.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                Interaction interaction = (Interaction) obj;
                                if (interaction instanceof PressInteraction.Press) {
                                    this.$pressInteractions$inlined.add(interaction);
                                } else if (interaction instanceof PressInteraction.Release) {
                                    this.$pressInteractions$inlined.remove(((PressInteraction.Release) interaction).getPress());
                                } else if (interaction instanceof PressInteraction.Cancel) {
                                    this.$pressInteractions$inlined.remove(((PressInteraction.Cancel) interaction).getPress());
                                }
                                Boolean boolBoxBoolean = Boxing.boxBoolean(!this.$pressInteractions$inlined.isEmpty());
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(boolBoxBoolean, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }), new AnonymousClass2(coroutineScope, this.this$0, null), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: androidx.compose.material3.EnlargeOnPressNode$launchCollectionJob$1$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: ButtonGroup.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "pressed", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material3.EnlargeOnPressNode$launchCollectionJob$1$1$2", f = "ButtonGroup.kt", i = {}, l = {1133, 1134}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$launch;
            /* synthetic */ boolean Z$0;
            int label;
            final /* synthetic */ EnlargeOnPressNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(CoroutineScope coroutineScope, EnlargeOnPressNode enlargeOnPressNode, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$$this$launch = coroutineScope;
                this.this$0 = enlargeOnPressNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$$this$launch, this.this$0, continuation);
                anonymousClass2.Z$0 = ((Boolean) obj).booleanValue();
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
                return invoke(bool.booleanValue(), continuation);
            }

            public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:17:0x006d, code lost:
            
                if (androidx.compose.animation.core.Animatable.animateTo$default(r11.this$0.pressedAnimatable, kotlin.coroutines.jvm.internal.Boxing.boxFloat(0.0f), r11.this$0.getAnimationSpec(), null, null, r11, 12, null) == r0) goto L18;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                /*
                    r11 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r11.label
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L1f
                    if (r1 == r3) goto L1b
                    if (r1 != r2) goto L12
                    kotlin.ResultKt.throwOnFailure(r12)
                    goto L70
                L12:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r12)
                    throw r11
                L1b:
                    kotlin.ResultKt.throwOnFailure(r12)
                    goto L4e
                L1f:
                    kotlin.ResultKt.throwOnFailure(r12)
                    boolean r12 = r11.Z$0
                    if (r12 == 0) goto L3b
                    kotlinx.coroutines.CoroutineScope r4 = r11.$$this$launch
                    androidx.compose.material3.EnlargeOnPressNode$launchCollectionJob$1$1$2$1 r12 = new androidx.compose.material3.EnlargeOnPressNode$launchCollectionJob$1$1$2$1
                    androidx.compose.material3.EnlargeOnPressNode r11 = r11.this$0
                    r0 = 0
                    r12.<init>(r11, r0)
                    r7 = r12
                    kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
                    r8 = 3
                    r9 = 0
                    r5 = 0
                    r6 = 0
                    kotlinx.coroutines.BuildersKt.launch$default(r4, r5, r6, r7, r8, r9)
                    goto L70
                L3b:
                    androidx.compose.material3.EnlargeOnPressNode r12 = r11.this$0
                    androidx.compose.material3.EnlargeOnPressNode$launchCollectionJob$1$1$2$$ExternalSyntheticLambda0 r1 = new androidx.compose.material3.EnlargeOnPressNode$launchCollectionJob$1$1$2$$ExternalSyntheticLambda0
                    r1.<init>()
                    r12 = r11
                    kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
                    r11.label = r3
                    java.lang.Object r12 = androidx.compose.material3.ButtonGroupKt.access$waitUntil(r1, r12)
                    if (r12 != r0) goto L4e
                    goto L6f
                L4e:
                    androidx.compose.material3.EnlargeOnPressNode r12 = r11.this$0
                    androidx.compose.animation.core.Animatable r3 = androidx.compose.material3.EnlargeOnPressNode.access$getPressedAnimatable$p(r12)
                    r12 = 0
                    java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r12)
                    androidx.compose.material3.EnlargeOnPressNode r12 = r11.this$0
                    androidx.compose.animation.core.AnimationSpec r5 = r12.getAnimationSpec()
                    r8 = r11
                    kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                    r11.label = r2
                    r6 = 0
                    r7 = 0
                    r9 = 12
                    r10 = 0
                    java.lang.Object r11 = androidx.compose.animation.core.Animatable.animateTo$default(r3, r4, r5, r6, r7, r8, r9, r10)
                    if (r11 != r0) goto L70
                L6f:
                    return r0
                L70:
                    kotlin.Unit r11 = kotlin.Unit.INSTANCE
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.EnlargeOnPressNode$launchCollectionJob$1.AnonymousClass1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            /* JADX INFO: renamed from: androidx.compose.material3.EnlargeOnPressNode$launchCollectionJob$1$1$2$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: ButtonGroup.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.EnlargeOnPressNode$launchCollectionJob$1$1$2$1", f = "ButtonGroup.kt", i = {}, l = {1131}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class C00561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ EnlargeOnPressNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00561(EnlargeOnPressNode enlargeOnPressNode, Continuation<? super C00561> continuation) {
                    super(2, continuation);
                    this.this$0 = enlargeOnPressNode;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00561(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (Animatable.animateTo$default(this.this$0.pressedAnimatable, Boxing.boxFloat(1.0f), this.this$0.getAnimationSpec(), null, null, this, 12, null) == coroutine_suspended) {
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

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean invokeSuspend$lambda$0(EnlargeOnPressNode enlargeOnPressNode) {
                return ((Number) enlargeOnPressNode.pressedAnimatable.getValue()).floatValue() > 0.75f;
            }
        }
    }
}
