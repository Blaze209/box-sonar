package androidx.fragment.compose;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: AndroidFragment.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\n\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u000bH\u0087\b¢\u0006\u0002\u0010\f\u001aY\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000e2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"AndroidFragment", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/fragment/app/Fragment;", "modifier", "Landroidx/compose/ui/Modifier;", "fragmentState", "Landroidx/fragment/compose/FragmentState;", "arguments", "Landroid/os/Bundle;", "onUpdate", "Lkotlin/Function1;", "(Landroidx/compose/ui/Modifier;Landroidx/fragment/compose/FragmentState;Landroid/os/Bundle;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;Landroidx/compose/ui/Modifier;Landroidx/fragment/compose/FragmentState;Landroid/os/Bundle;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "fragment-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidFragmentKt {
    public static final /* synthetic */ <T extends Fragment> void AndroidFragment(Modifier modifier, FragmentState fragmentState, Bundle bundle, Function1<? super T, Unit> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1765406104);
        ComposerKt.sourceInformation(composer, "CC(AndroidFragment)P(2,1)54@2199L23,58@2311L84:AndroidFragment.kt#dnbm1l");
        if ((i2 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        Modifier modifier2 = modifier;
        if ((i2 & 2) != 0) {
            fragmentState = FragmentStateKt.rememberFragmentState(composer, 0);
        }
        FragmentState fragmentState2 = fragmentState;
        if ((i2 & 4) != 0) {
            bundle = Bundle.EMPTY;
        }
        Bundle bundle2 = bundle;
        if ((i2 & 8) != 0) {
            Intrinsics.needClassReification();
            function1 = AnonymousClass1.INSTANCE;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        AndroidFragment(Fragment.class, modifier2, fragmentState2, bundle2, function1, composer, (i << 3) & 65520, 0);
        composer.endReplaceableGroup();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0182  */
    /* JADX WARN: Code duplicated, block: B:103:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:105:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:111:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:115:0x0201  */
    /* JADX WARN: Code duplicated, block: B:118:0x0226  */
    /* JADX WARN: Code duplicated, block: B:122:0x0235  */
    /* JADX WARN: Code duplicated, block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    /* JADX WARN: Code duplicated, block: B:28:0x004d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x0058  */
    /* JADX WARN: Code duplicated, block: B:34:0x005e  */
    /* JADX WARN: Code duplicated, block: B:37:0x0064  */
    /* JADX WARN: Code duplicated, block: B:39:0x0068  */
    /* JADX WARN: Code duplicated, block: B:41:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x0073  */
    /* JADX WARN: Code duplicated, block: B:45:0x0079  */
    /* JADX WARN: Code duplicated, block: B:48:0x007f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0082  */
    /* JADX WARN: Code duplicated, block: B:51:0x0086  */
    /* JADX WARN: Code duplicated, block: B:53:0x008e  */
    /* JADX WARN: Code duplicated, block: B:54:0x0091  */
    /* JADX WARN: Code duplicated, block: B:59:0x009d  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:81:0x00de  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:86:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:92:0x0108  */
    /* JADX WARN: Code duplicated, block: B:95:0x0146  */
    /* JADX WARN: Code duplicated, block: B:97:0x014e  */
    public static final <T extends Fragment> void AndroidFragment(final Class<T> cls, Modifier modifier, FragmentState fragmentState, Bundle bundle, Function1<? super T, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final FragmentState fragmentState2;
        final Bundle bundle2;
        int i4;
        Function1<? super T, Unit> function2;
        int i5;
        Modifier.Companion companion;
        FragmentState fragmentStateRememberFragmentState;
        Bundle bundle3;
        int i6;
        FragmentState fragmentState3;
        Function1<? super T, Unit> function3;
        Bundle bundle4;
        final State stateRememberUpdatedState;
        final int currentCompositeKeyHash;
        View view;
        boolean zChanged;
        Object objRememberedValue;
        final FragmentManager fragmentManager;
        final Context context;
        Object objRememberedValue2;
        final FragmentContainerViewFactory fragmentContainerViewFactory;
        boolean zChangedInstance;
        Object objRememberedValue3;
        Composer composer2;
        final Function1<? super T, Unit> function4;
        final Modifier modifier3;
        final FragmentState fragmentState4;
        final Bundle bundle5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1012439764);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AndroidFragment)P(1,3,2)81@3256L23,85@3380L30,86@3429L23,87@3478L7,88@3512L72,91@3616L7,92@3651L50,93@3706L49,95@3835L2822,95@3761L2896:AndroidFragment.kt#dnbm1l");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(cls) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    fragmentState2 = fragmentState;
                    int i8 = composerStartRestartGroup.changed(fragmentState2) ? 256 : 128;
                    i3 |= i8;
                } else {
                    fragmentState2 = fragmentState;
                }
                i3 |= i8;
            } else {
                fragmentState2 = fragmentState;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    bundle2 = bundle;
                    int i9 = composerStartRestartGroup.changedInstance(bundle2) ? 2048 : 1024;
                    i3 |= i9;
                } else {
                    bundle2 = bundle;
                }
                i3 |= i9;
            } else {
                bundle2 = bundle;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    function2 = function1;
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((i3 & 9363) == 9362 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            fragmentStateRememberFragmentState = FragmentStateKt.rememberFragmentState(composerStartRestartGroup, 0);
                            i3 &= -897;
                        } else {
                            fragmentStateRememberFragmentState = fragmentState2;
                        }
                        if ((i2 & 8) != 0) {
                            bundle3 = Bundle.EMPTY;
                            i3 &= -7169;
                        } else {
                            bundle3 = bundle2;
                        }
                        if (i4 != 0) {
                            i6 = i3;
                            fragmentState3 = fragmentStateRememberFragmentState;
                            bundle4 = bundle3;
                            function3 = new Function1<T, Unit>() { // from class: androidx.fragment.compose.AndroidFragmentKt.AndroidFragment.2
                                /* JADX WARN: Incorrect types in method signature: (TT;)V */
                                public final void invoke(Fragment fragment) {
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                                    invoke((Fragment) obj);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            i6 = i3;
                            fragmentState3 = fragmentStateRememberFragmentState;
                            function3 = function2;
                            bundle4 = bundle3;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        i6 = i3;
                        companion = modifier2;
                        fragmentState3 = fragmentState2;
                        function3 = function2;
                        bundle4 = bundle2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1012439764, i6, -1, "androidx.fragment.compose.AndroidFragment (AndroidFragment.kt:84)");
                    }
                    stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function3, composerStartRestartGroup, (i6 >> 12) & 14);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localView);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    view = (View) objConsume;
                    composerStartRestartGroup.startReplaceableGroup(485393906);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AndroidFragment.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(view);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = FragmentManager.findFragmentManager(view);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    fragmentManager = (FragmentManager) objRememberedValue;
                    composerStartRestartGroup.endReplaceableGroup();
                    ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localContext);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    context = (Context) objConsume2;
                    composerStartRestartGroup.startReplaceableGroup(485398332);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AndroidFragment.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new FragmentContainerViewFactory(currentCompositeKeyHash);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    fragmentContainerViewFactory = (FragmentContainerViewFactory) objRememberedValue2;
                    composerStartRestartGroup.endReplaceableGroup();
                    Function1<? super T, Unit> function5 = function3;
                    AndroidView_androidKt.AndroidView(fragmentContainerViewFactory, companion, null, composerStartRestartGroup, i6 & 112, 4);
                    Modifier modifier4 = companion;
                    Object[] objArr = {fragmentManager, fragmentContainerViewFactory, cls, fragmentState3};
                    composerStartRestartGroup.startReplaceableGroup(485406992);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AndroidFragment.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(fragmentManager) | composerStartRestartGroup.changedInstance(fragmentContainerViewFactory) | composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(cls) | ((((i6 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(fragmentState3)) || (i6 & 384) == 256) | composerStartRestartGroup.changedInstance(bundle4) | composerStartRestartGroup.changed(currentCompositeKeyHash) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        composer2 = composerStartRestartGroup;
                        fragmentState2 = fragmentState3;
                        bundle2 = bundle4;
                        objRememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                                final Fragment fragmentFindFragmentById = fragmentManager.findFragmentById(fragmentContainerViewFactory.getContainer().getId());
                                if (fragmentFindFragmentById == null) {
                                    fragmentFindFragmentById = fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), cls.getName());
                                    FragmentState fragmentState5 = fragmentState2;
                                    Bundle bundle6 = bundle2;
                                    FragmentManager fragmentManager2 = fragmentManager;
                                    FragmentContainerViewFactory fragmentContainerViewFactory2 = fragmentContainerViewFactory;
                                    int i10 = currentCompositeKeyHash;
                                    fragmentFindFragmentById.setInitialSavedState(fragmentState5.getState$fragment_compose_release().getValue());
                                    fragmentFindFragmentById.setArguments(bundle6);
                                    FragmentTransaction fragmentTransactionAdd = fragmentManager2.beginTransaction().setReorderingAllowed(true).add(fragmentContainerViewFactory2.getContainer(), fragmentFindFragmentById, String.valueOf(i10));
                                    if (fragmentManager2.isStateSaved()) {
                                        booleanRef.element = true;
                                        fragmentFindFragmentById.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$fragment$1$1
                                            @Override // androidx.lifecycle.DefaultLifecycleObserver
                                            public void onStart(LifecycleOwner owner) {
                                                booleanRef.element = false;
                                                fragmentFindFragmentById.getLifecycle().removeObserver(this);
                                            }
                                        });
                                        fragmentTransactionAdd.commitNowAllowingStateLoss();
                                    } else {
                                        fragmentTransactionAdd.commitNow();
                                    }
                                }
                                fragmentManager.onContainerAvailable(fragmentContainerViewFactory.getContainer());
                                Function1 function6 = (Function1) stateRememberUpdatedState.getValue();
                                Intrinsics.checkNotNull(fragmentFindFragmentById, "null cannot be cast to non-null type T of androidx.fragment.compose.AndroidFragmentKt.AndroidFragment$lambda$2");
                                function6.invoke(fragmentFindFragmentById);
                                final FragmentManager fragmentManager3 = fragmentManager;
                                final FragmentState fragmentState6 = fragmentState2;
                                return new DisposableEffectResult() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        fragmentState6.getState$fragment_compose_release().setValue(fragmentManager3.saveFragmentInstanceState(fragmentFindFragmentById));
                                        if (booleanRef.element) {
                                            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager3.beginTransaction();
                                            fragmentTransactionBeginTransaction.remove(fragmentFindFragmentById);
                                            fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                                        } else {
                                            if (fragmentManager3.isStateSaved()) {
                                                return;
                                            }
                                            FragmentTransaction fragmentTransactionBeginTransaction2 = fragmentManager3.beginTransaction();
                                            fragmentTransactionBeginTransaction2.remove(fragmentFindFragmentById);
                                            fragmentTransactionBeginTransaction2.commitNow();
                                        }
                                    }
                                };
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        composer2 = composerStartRestartGroup;
                        fragmentState2 = fragmentState3;
                        bundle2 = bundle4;
                    }
                    composer2.endReplaceableGroup();
                    EffectsKt.DisposableEffect(objArr, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function4 = function5;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    composer2 = composerStartRestartGroup;
                    function4 = function2;
                }
                fragmentState4 = fragmentState2;
                bundle5 = bundle2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.fragment.compose.AndroidFragmentKt.AndroidFragment.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i10) {
                            AndroidFragmentKt.AndroidFragment(cls, modifier3, fragmentState4, bundle5, function4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            function2 = function1;
            if ((i3 & 9363) == 9362) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        fragmentStateRememberFragmentState = FragmentStateKt.rememberFragmentState(composerStartRestartGroup, 0);
                        i3 &= -897;
                    } else {
                        fragmentStateRememberFragmentState = fragmentState2;
                    }
                    if ((i2 & 8) != 0) {
                        bundle3 = Bundle.EMPTY;
                        i3 &= -7169;
                    } else {
                        bundle3 = bundle2;
                    }
                    if (i4 != 0) {
                        i6 = i3;
                        fragmentState3 = fragmentStateRememberFragmentState;
                        bundle4 = bundle3;
                        function3 = new Function1<T, Unit>() { // from class: androidx.fragment.compose.AndroidFragmentKt.AndroidFragment.2
                            /* JADX WARN: Incorrect types in method signature: (TT;)V */
                            public final void invoke(Fragment fragment) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                                invoke((Fragment) obj);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        i6 = i3;
                        fragmentState3 = fragmentStateRememberFragmentState;
                        function3 = function2;
                        bundle4 = bundle3;
                    }
                } else {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        fragmentStateRememberFragmentState = FragmentStateKt.rememberFragmentState(composerStartRestartGroup, 0);
                        i3 &= -897;
                    } else {
                        fragmentStateRememberFragmentState = fragmentState2;
                    }
                    if ((i2 & 8) != 0) {
                        bundle3 = Bundle.EMPTY;
                        i3 &= -7169;
                    } else {
                        bundle3 = bundle2;
                    }
                    if (i4 != 0) {
                        i6 = i3;
                        fragmentState3 = fragmentStateRememberFragmentState;
                        bundle4 = bundle3;
                        function3 = new Function1<T, Unit>() { // from class: androidx.fragment.compose.AndroidFragmentKt.AndroidFragment.2
                            /* JADX WARN: Incorrect types in method signature: (TT;)V */
                            public final void invoke(Fragment fragment) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                                invoke((Fragment) obj);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        i6 = i3;
                        fragmentState3 = fragmentStateRememberFragmentState;
                        function3 = function2;
                        bundle4 = bundle3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1012439764, i6, -1, "androidx.fragment.compose.AndroidFragment (AndroidFragment.kt:84)");
                }
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function3, composerStartRestartGroup, (i6 >> 12) & 14);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                ProvidableCompositionLocal<View> localView2 = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localView2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                view = (View) objConsume3;
                composerStartRestartGroup.startReplaceableGroup(485393906);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AndroidFragment.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(view);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = FragmentManager.findFragmentManager(view);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = FragmentManager.findFragmentManager(view);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                fragmentManager = (FragmentManager) objRememberedValue;
                composerStartRestartGroup.endReplaceableGroup();
                ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume4 = composerStartRestartGroup.consume(localContext2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume4;
                composerStartRestartGroup.startReplaceableGroup(485398332);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AndroidFragment.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new FragmentContainerViewFactory(currentCompositeKeyHash);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                fragmentContainerViewFactory = (FragmentContainerViewFactory) objRememberedValue2;
                composerStartRestartGroup.endReplaceableGroup();
                Function1<? super T, Unit> function6 = function3;
                AndroidView_androidKt.AndroidView(fragmentContainerViewFactory, companion, null, composerStartRestartGroup, i6 & 112, 4);
                Modifier modifier5 = companion;
                Object[] objArr2 = {fragmentManager, fragmentContainerViewFactory, cls, fragmentState3};
                composerStartRestartGroup.startReplaceableGroup(485406992);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AndroidFragment.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(fragmentManager) | composerStartRestartGroup.changedInstance(fragmentContainerViewFactory) | composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(cls) | ((((i6 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(fragmentState3)) || (i6 & 384) == 256) | composerStartRestartGroup.changedInstance(bundle4) | composerStartRestartGroup.changed(currentCompositeKeyHash) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    composer2 = composerStartRestartGroup;
                    fragmentState2 = fragmentState3;
                    bundle2 = bundle4;
                    objRememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                            final Fragment fragmentFindFragmentById = fragmentManager.findFragmentById(fragmentContainerViewFactory.getContainer().getId());
                            if (fragmentFindFragmentById == null) {
                                fragmentFindFragmentById = fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), cls.getName());
                                FragmentState fragmentState5 = fragmentState2;
                                Bundle bundle6 = bundle2;
                                FragmentManager fragmentManager2 = fragmentManager;
                                FragmentContainerViewFactory fragmentContainerViewFactory2 = fragmentContainerViewFactory;
                                int i10 = currentCompositeKeyHash;
                                fragmentFindFragmentById.setInitialSavedState(fragmentState5.getState$fragment_compose_release().getValue());
                                fragmentFindFragmentById.setArguments(bundle6);
                                FragmentTransaction fragmentTransactionAdd = fragmentManager2.beginTransaction().setReorderingAllowed(true).add(fragmentContainerViewFactory2.getContainer(), fragmentFindFragmentById, String.valueOf(i10));
                                if (fragmentManager2.isStateSaved()) {
                                    booleanRef.element = true;
                                    fragmentFindFragmentById.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$fragment$1$1
                                        @Override // androidx.lifecycle.DefaultLifecycleObserver
                                        public void onStart(LifecycleOwner owner) {
                                            booleanRef.element = false;
                                            fragmentFindFragmentById.getLifecycle().removeObserver(this);
                                        }
                                    });
                                    fragmentTransactionAdd.commitNowAllowingStateLoss();
                                } else {
                                    fragmentTransactionAdd.commitNow();
                                }
                            }
                            fragmentManager.onContainerAvailable(fragmentContainerViewFactory.getContainer());
                            Function1 function7 = (Function1) stateRememberUpdatedState.getValue();
                            Intrinsics.checkNotNull(fragmentFindFragmentById, "null cannot be cast to non-null type T of androidx.fragment.compose.AndroidFragmentKt.AndroidFragment$lambda$2");
                            function7.invoke(fragmentFindFragmentById);
                            final FragmentManager fragmentManager3 = fragmentManager;
                            final FragmentState fragmentState6 = fragmentState2;
                            return new DisposableEffectResult() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    fragmentState6.getState$fragment_compose_release().setValue(fragmentManager3.saveFragmentInstanceState(fragmentFindFragmentById));
                                    if (booleanRef.element) {
                                        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager3.beginTransaction();
                                        fragmentTransactionBeginTransaction.remove(fragmentFindFragmentById);
                                        fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                                    } else {
                                        if (fragmentManager3.isStateSaved()) {
                                            return;
                                        }
                                        FragmentTransaction fragmentTransactionBeginTransaction2 = fragmentManager3.beginTransaction();
                                        fragmentTransactionBeginTransaction2.remove(fragmentFindFragmentById);
                                        fragmentTransactionBeginTransaction2.commitNow();
                                    }
                                }
                            };
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    composer2 = composerStartRestartGroup;
                    fragmentState2 = fragmentState3;
                    bundle2 = bundle4;
                    objRememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                            final Fragment fragmentFindFragmentById = fragmentManager.findFragmentById(fragmentContainerViewFactory.getContainer().getId());
                            if (fragmentFindFragmentById == null) {
                                fragmentFindFragmentById = fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), cls.getName());
                                FragmentState fragmentState5 = fragmentState2;
                                Bundle bundle6 = bundle2;
                                FragmentManager fragmentManager2 = fragmentManager;
                                FragmentContainerViewFactory fragmentContainerViewFactory2 = fragmentContainerViewFactory;
                                int i10 = currentCompositeKeyHash;
                                fragmentFindFragmentById.setInitialSavedState(fragmentState5.getState$fragment_compose_release().getValue());
                                fragmentFindFragmentById.setArguments(bundle6);
                                FragmentTransaction fragmentTransactionAdd = fragmentManager2.beginTransaction().setReorderingAllowed(true).add(fragmentContainerViewFactory2.getContainer(), fragmentFindFragmentById, String.valueOf(i10));
                                if (fragmentManager2.isStateSaved()) {
                                    booleanRef.element = true;
                                    fragmentFindFragmentById.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$fragment$1$1
                                        @Override // androidx.lifecycle.DefaultLifecycleObserver
                                        public void onStart(LifecycleOwner owner) {
                                            booleanRef.element = false;
                                            fragmentFindFragmentById.getLifecycle().removeObserver(this);
                                        }
                                    });
                                    fragmentTransactionAdd.commitNowAllowingStateLoss();
                                } else {
                                    fragmentTransactionAdd.commitNow();
                                }
                            }
                            fragmentManager.onContainerAvailable(fragmentContainerViewFactory.getContainer());
                            Function1 function7 = (Function1) stateRememberUpdatedState.getValue();
                            Intrinsics.checkNotNull(fragmentFindFragmentById, "null cannot be cast to non-null type T of androidx.fragment.compose.AndroidFragmentKt.AndroidFragment$lambda$2");
                            function7.invoke(fragmentFindFragmentById);
                            final FragmentManager fragmentManager3 = fragmentManager;
                            final FragmentState fragmentState6 = fragmentState2;
                            return new DisposableEffectResult() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    fragmentState6.getState$fragment_compose_release().setValue(fragmentManager3.saveFragmentInstanceState(fragmentFindFragmentById));
                                    if (booleanRef.element) {
                                        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager3.beginTransaction();
                                        fragmentTransactionBeginTransaction.remove(fragmentFindFragmentById);
                                        fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                                    } else {
                                        if (fragmentManager3.isStateSaved()) {
                                            return;
                                        }
                                        FragmentTransaction fragmentTransactionBeginTransaction2 = fragmentManager3.beginTransaction();
                                        fragmentTransactionBeginTransaction2.remove(fragmentFindFragmentById);
                                        fragmentTransactionBeginTransaction2.commitNow();
                                    }
                                }
                            };
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                composer2.endReplaceableGroup();
                EffectsKt.DisposableEffect(objArr2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function6;
                modifier3 = modifier5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        fragmentStateRememberFragmentState = FragmentStateKt.rememberFragmentState(composerStartRestartGroup, 0);
                        i3 &= -897;
                    } else {
                        fragmentStateRememberFragmentState = fragmentState2;
                    }
                    if ((i2 & 8) != 0) {
                        bundle3 = Bundle.EMPTY;
                        i3 &= -7169;
                    } else {
                        bundle3 = bundle2;
                    }
                    if (i4 != 0) {
                        i6 = i3;
                        fragmentState3 = fragmentStateRememberFragmentState;
                        bundle4 = bundle3;
                        function3 = new Function1<T, Unit>() { // from class: androidx.fragment.compose.AndroidFragmentKt.AndroidFragment.2
                            /* JADX WARN: Incorrect types in method signature: (TT;)V */
                            public final void invoke(Fragment fragment) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                                invoke((Fragment) obj);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        i6 = i3;
                        fragmentState3 = fragmentStateRememberFragmentState;
                        function3 = function2;
                        bundle4 = bundle3;
                    }
                } else {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        fragmentStateRememberFragmentState = FragmentStateKt.rememberFragmentState(composerStartRestartGroup, 0);
                        i3 &= -897;
                    } else {
                        fragmentStateRememberFragmentState = fragmentState2;
                    }
                    if ((i2 & 8) != 0) {
                        bundle3 = Bundle.EMPTY;
                        i3 &= -7169;
                    } else {
                        bundle3 = bundle2;
                    }
                    if (i4 != 0) {
                        i6 = i3;
                        fragmentState3 = fragmentStateRememberFragmentState;
                        bundle4 = bundle3;
                        function3 = new Function1<T, Unit>() { // from class: androidx.fragment.compose.AndroidFragmentKt.AndroidFragment.2
                            /* JADX WARN: Incorrect types in method signature: (TT;)V */
                            public final void invoke(Fragment fragment) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                                invoke((Fragment) obj);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        i6 = i3;
                        fragmentState3 = fragmentStateRememberFragmentState;
                        function3 = function2;
                        bundle4 = bundle3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1012439764, i6, -1, "androidx.fragment.compose.AndroidFragment (AndroidFragment.kt:84)");
                }
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function3, composerStartRestartGroup, (i6 >> 12) & 14);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                ProvidableCompositionLocal<View> localView3 = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume5 = composerStartRestartGroup.consume(localView3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                view = (View) objConsume5;
                composerStartRestartGroup.startReplaceableGroup(485393906);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AndroidFragment.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(view);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = FragmentManager.findFragmentManager(view);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = FragmentManager.findFragmentManager(view);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                fragmentManager = (FragmentManager) objRememberedValue;
                composerStartRestartGroup.endReplaceableGroup();
                ProvidableCompositionLocal<Context> localContext3 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume6 = composerStartRestartGroup.consume(localContext3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume6;
                composerStartRestartGroup.startReplaceableGroup(485398332);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AndroidFragment.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new FragmentContainerViewFactory(currentCompositeKeyHash);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                fragmentContainerViewFactory = (FragmentContainerViewFactory) objRememberedValue2;
                composerStartRestartGroup.endReplaceableGroup();
                Function1<? super T, Unit> function7 = function3;
                AndroidView_androidKt.AndroidView(fragmentContainerViewFactory, companion, null, composerStartRestartGroup, i6 & 112, 4);
                Modifier modifier6 = companion;
                Object[] objArr3 = {fragmentManager, fragmentContainerViewFactory, cls, fragmentState3};
                composerStartRestartGroup.startReplaceableGroup(485406992);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AndroidFragment.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(fragmentManager) | composerStartRestartGroup.changedInstance(fragmentContainerViewFactory) | composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(cls) | ((((i6 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(fragmentState3)) || (i6 & 384) == 256) | composerStartRestartGroup.changedInstance(bundle4) | composerStartRestartGroup.changed(currentCompositeKeyHash) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    composer2 = composerStartRestartGroup;
                    fragmentState2 = fragmentState3;
                    bundle2 = bundle4;
                    objRememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                            final Fragment fragmentFindFragmentById = fragmentManager.findFragmentById(fragmentContainerViewFactory.getContainer().getId());
                            if (fragmentFindFragmentById == null) {
                                fragmentFindFragmentById = fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), cls.getName());
                                FragmentState fragmentState5 = fragmentState2;
                                Bundle bundle6 = bundle2;
                                FragmentManager fragmentManager2 = fragmentManager;
                                FragmentContainerViewFactory fragmentContainerViewFactory2 = fragmentContainerViewFactory;
                                int i10 = currentCompositeKeyHash;
                                fragmentFindFragmentById.setInitialSavedState(fragmentState5.getState$fragment_compose_release().getValue());
                                fragmentFindFragmentById.setArguments(bundle6);
                                FragmentTransaction fragmentTransactionAdd = fragmentManager2.beginTransaction().setReorderingAllowed(true).add(fragmentContainerViewFactory2.getContainer(), fragmentFindFragmentById, String.valueOf(i10));
                                if (fragmentManager2.isStateSaved()) {
                                    booleanRef.element = true;
                                    fragmentFindFragmentById.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$fragment$1$1
                                        @Override // androidx.lifecycle.DefaultLifecycleObserver
                                        public void onStart(LifecycleOwner owner) {
                                            booleanRef.element = false;
                                            fragmentFindFragmentById.getLifecycle().removeObserver(this);
                                        }
                                    });
                                    fragmentTransactionAdd.commitNowAllowingStateLoss();
                                } else {
                                    fragmentTransactionAdd.commitNow();
                                }
                            }
                            fragmentManager.onContainerAvailable(fragmentContainerViewFactory.getContainer());
                            Function1 function8 = (Function1) stateRememberUpdatedState.getValue();
                            Intrinsics.checkNotNull(fragmentFindFragmentById, "null cannot be cast to non-null type T of androidx.fragment.compose.AndroidFragmentKt.AndroidFragment$lambda$2");
                            function8.invoke(fragmentFindFragmentById);
                            final FragmentManager fragmentManager3 = fragmentManager;
                            final FragmentState fragmentState6 = fragmentState2;
                            return new DisposableEffectResult() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    fragmentState6.getState$fragment_compose_release().setValue(fragmentManager3.saveFragmentInstanceState(fragmentFindFragmentById));
                                    if (booleanRef.element) {
                                        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager3.beginTransaction();
                                        fragmentTransactionBeginTransaction.remove(fragmentFindFragmentById);
                                        fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                                    } else {
                                        if (fragmentManager3.isStateSaved()) {
                                            return;
                                        }
                                        FragmentTransaction fragmentTransactionBeginTransaction2 = fragmentManager3.beginTransaction();
                                        fragmentTransactionBeginTransaction2.remove(fragmentFindFragmentById);
                                        fragmentTransactionBeginTransaction2.commitNow();
                                    }
                                }
                            };
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    composer2 = composerStartRestartGroup;
                    fragmentState2 = fragmentState3;
                    bundle2 = bundle4;
                    objRememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                            final Fragment fragmentFindFragmentById = fragmentManager.findFragmentById(fragmentContainerViewFactory.getContainer().getId());
                            if (fragmentFindFragmentById == null) {
                                fragmentFindFragmentById = fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), cls.getName());
                                FragmentState fragmentState5 = fragmentState2;
                                Bundle bundle6 = bundle2;
                                FragmentManager fragmentManager2 = fragmentManager;
                                FragmentContainerViewFactory fragmentContainerViewFactory2 = fragmentContainerViewFactory;
                                int i10 = currentCompositeKeyHash;
                                fragmentFindFragmentById.setInitialSavedState(fragmentState5.getState$fragment_compose_release().getValue());
                                fragmentFindFragmentById.setArguments(bundle6);
                                FragmentTransaction fragmentTransactionAdd = fragmentManager2.beginTransaction().setReorderingAllowed(true).add(fragmentContainerViewFactory2.getContainer(), fragmentFindFragmentById, String.valueOf(i10));
                                if (fragmentManager2.isStateSaved()) {
                                    booleanRef.element = true;
                                    fragmentFindFragmentById.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$fragment$1$1
                                        @Override // androidx.lifecycle.DefaultLifecycleObserver
                                        public void onStart(LifecycleOwner owner) {
                                            booleanRef.element = false;
                                            fragmentFindFragmentById.getLifecycle().removeObserver(this);
                                        }
                                    });
                                    fragmentTransactionAdd.commitNowAllowingStateLoss();
                                } else {
                                    fragmentTransactionAdd.commitNow();
                                }
                            }
                            fragmentManager.onContainerAvailable(fragmentContainerViewFactory.getContainer());
                            Function1 function8 = (Function1) stateRememberUpdatedState.getValue();
                            Intrinsics.checkNotNull(fragmentFindFragmentById, "null cannot be cast to non-null type T of androidx.fragment.compose.AndroidFragmentKt.AndroidFragment$lambda$2");
                            function8.invoke(fragmentFindFragmentById);
                            final FragmentManager fragmentManager3 = fragmentManager;
                            final FragmentState fragmentState6 = fragmentState2;
                            return new DisposableEffectResult() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    fragmentState6.getState$fragment_compose_release().setValue(fragmentManager3.saveFragmentInstanceState(fragmentFindFragmentById));
                                    if (booleanRef.element) {
                                        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager3.beginTransaction();
                                        fragmentTransactionBeginTransaction.remove(fragmentFindFragmentById);
                                        fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                                    } else {
                                        if (fragmentManager3.isStateSaved()) {
                                            return;
                                        }
                                        FragmentTransaction fragmentTransactionBeginTransaction2 = fragmentManager3.beginTransaction();
                                        fragmentTransactionBeginTransaction2.remove(fragmentFindFragmentById);
                                        fragmentTransactionBeginTransaction2.commitNow();
                                    }
                                }
                            };
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                composer2.endReplaceableGroup();
                EffectsKt.DisposableEffect(objArr3, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function7;
                modifier3 = modifier6;
            }
            fragmentState4 = fragmentState2;
            bundle5 = bundle2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.fragment.compose.AndroidFragmentKt.AndroidFragment.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i10) {
                        AndroidFragmentKt.AndroidFragment(cls, modifier3, fragmentState4, bundle5, function4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                fragmentState2 = fragmentState;
                if (composerStartRestartGroup.changed(fragmentState2)) {
                }
                i3 |= i8;
            } else {
                fragmentState2 = fragmentState;
            }
            i3 |= i8;
        } else {
            fragmentState2 = fragmentState;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                bundle2 = bundle;
                if (composerStartRestartGroup.changedInstance(bundle2)) {
                }
                i3 |= i9;
            } else {
                bundle2 = bundle;
            }
            i3 |= i9;
        } else {
            bundle2 = bundle;
        }
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                function2 = function1;
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((i3 & 9363) == 9362) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        fragmentStateRememberFragmentState = FragmentStateKt.rememberFragmentState(composerStartRestartGroup, 0);
                        i3 &= -897;
                    } else {
                        fragmentStateRememberFragmentState = fragmentState2;
                    }
                    if ((i2 & 8) != 0) {
                        bundle3 = Bundle.EMPTY;
                        i3 &= -7169;
                    } else {
                        bundle3 = bundle2;
                    }
                    if (i4 != 0) {
                        i6 = i3;
                        fragmentState3 = fragmentStateRememberFragmentState;
                        bundle4 = bundle3;
                        function3 = new Function1<T, Unit>() { // from class: androidx.fragment.compose.AndroidFragmentKt.AndroidFragment.2
                            /* JADX WARN: Incorrect types in method signature: (TT;)V */
                            public final void invoke(Fragment fragment) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                                invoke((Fragment) obj);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        i6 = i3;
                        fragmentState3 = fragmentStateRememberFragmentState;
                        function3 = function2;
                        bundle4 = bundle3;
                    }
                } else {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        fragmentStateRememberFragmentState = FragmentStateKt.rememberFragmentState(composerStartRestartGroup, 0);
                        i3 &= -897;
                    } else {
                        fragmentStateRememberFragmentState = fragmentState2;
                    }
                    if ((i2 & 8) != 0) {
                        bundle3 = Bundle.EMPTY;
                        i3 &= -7169;
                    } else {
                        bundle3 = bundle2;
                    }
                    if (i4 != 0) {
                        i6 = i3;
                        fragmentState3 = fragmentStateRememberFragmentState;
                        bundle4 = bundle3;
                        function3 = new Function1<T, Unit>() { // from class: androidx.fragment.compose.AndroidFragmentKt.AndroidFragment.2
                            /* JADX WARN: Incorrect types in method signature: (TT;)V */
                            public final void invoke(Fragment fragment) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                                invoke((Fragment) obj);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        i6 = i3;
                        fragmentState3 = fragmentStateRememberFragmentState;
                        function3 = function2;
                        bundle4 = bundle3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1012439764, i6, -1, "androidx.fragment.compose.AndroidFragment (AndroidFragment.kt:84)");
                }
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function3, composerStartRestartGroup, (i6 >> 12) & 14);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                ProvidableCompositionLocal<View> localView4 = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume7 = composerStartRestartGroup.consume(localView4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                view = (View) objConsume7;
                composerStartRestartGroup.startReplaceableGroup(485393906);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AndroidFragment.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(view);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = FragmentManager.findFragmentManager(view);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = FragmentManager.findFragmentManager(view);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                fragmentManager = (FragmentManager) objRememberedValue;
                composerStartRestartGroup.endReplaceableGroup();
                ProvidableCompositionLocal<Context> localContext4 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume8 = composerStartRestartGroup.consume(localContext4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume8;
                composerStartRestartGroup.startReplaceableGroup(485398332);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AndroidFragment.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new FragmentContainerViewFactory(currentCompositeKeyHash);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                fragmentContainerViewFactory = (FragmentContainerViewFactory) objRememberedValue2;
                composerStartRestartGroup.endReplaceableGroup();
                Function1<? super T, Unit> function8 = function3;
                AndroidView_androidKt.AndroidView(fragmentContainerViewFactory, companion, null, composerStartRestartGroup, i6 & 112, 4);
                Modifier modifier7 = companion;
                Object[] objArr4 = {fragmentManager, fragmentContainerViewFactory, cls, fragmentState3};
                composerStartRestartGroup.startReplaceableGroup(485406992);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AndroidFragment.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(fragmentManager) | composerStartRestartGroup.changedInstance(fragmentContainerViewFactory) | composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(cls) | ((((i6 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(fragmentState3)) || (i6 & 384) == 256) | composerStartRestartGroup.changedInstance(bundle4) | composerStartRestartGroup.changed(currentCompositeKeyHash) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    composer2 = composerStartRestartGroup;
                    fragmentState2 = fragmentState3;
                    bundle2 = bundle4;
                    objRememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                            final Fragment fragmentFindFragmentById = fragmentManager.findFragmentById(fragmentContainerViewFactory.getContainer().getId());
                            if (fragmentFindFragmentById == null) {
                                fragmentFindFragmentById = fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), cls.getName());
                                FragmentState fragmentState5 = fragmentState2;
                                Bundle bundle6 = bundle2;
                                FragmentManager fragmentManager2 = fragmentManager;
                                FragmentContainerViewFactory fragmentContainerViewFactory2 = fragmentContainerViewFactory;
                                int i10 = currentCompositeKeyHash;
                                fragmentFindFragmentById.setInitialSavedState(fragmentState5.getState$fragment_compose_release().getValue());
                                fragmentFindFragmentById.setArguments(bundle6);
                                FragmentTransaction fragmentTransactionAdd = fragmentManager2.beginTransaction().setReorderingAllowed(true).add(fragmentContainerViewFactory2.getContainer(), fragmentFindFragmentById, String.valueOf(i10));
                                if (fragmentManager2.isStateSaved()) {
                                    booleanRef.element = true;
                                    fragmentFindFragmentById.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$fragment$1$1
                                        @Override // androidx.lifecycle.DefaultLifecycleObserver
                                        public void onStart(LifecycleOwner owner) {
                                            booleanRef.element = false;
                                            fragmentFindFragmentById.getLifecycle().removeObserver(this);
                                        }
                                    });
                                    fragmentTransactionAdd.commitNowAllowingStateLoss();
                                } else {
                                    fragmentTransactionAdd.commitNow();
                                }
                            }
                            fragmentManager.onContainerAvailable(fragmentContainerViewFactory.getContainer());
                            Function1 function9 = (Function1) stateRememberUpdatedState.getValue();
                            Intrinsics.checkNotNull(fragmentFindFragmentById, "null cannot be cast to non-null type T of androidx.fragment.compose.AndroidFragmentKt.AndroidFragment$lambda$2");
                            function9.invoke(fragmentFindFragmentById);
                            final FragmentManager fragmentManager3 = fragmentManager;
                            final FragmentState fragmentState6 = fragmentState2;
                            return new DisposableEffectResult() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    fragmentState6.getState$fragment_compose_release().setValue(fragmentManager3.saveFragmentInstanceState(fragmentFindFragmentById));
                                    if (booleanRef.element) {
                                        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager3.beginTransaction();
                                        fragmentTransactionBeginTransaction.remove(fragmentFindFragmentById);
                                        fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                                    } else {
                                        if (fragmentManager3.isStateSaved()) {
                                            return;
                                        }
                                        FragmentTransaction fragmentTransactionBeginTransaction2 = fragmentManager3.beginTransaction();
                                        fragmentTransactionBeginTransaction2.remove(fragmentFindFragmentById);
                                        fragmentTransactionBeginTransaction2.commitNow();
                                    }
                                }
                            };
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    composer2 = composerStartRestartGroup;
                    fragmentState2 = fragmentState3;
                    bundle2 = bundle4;
                    objRememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                            final Fragment fragmentFindFragmentById = fragmentManager.findFragmentById(fragmentContainerViewFactory.getContainer().getId());
                            if (fragmentFindFragmentById == null) {
                                fragmentFindFragmentById = fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), cls.getName());
                                FragmentState fragmentState5 = fragmentState2;
                                Bundle bundle6 = bundle2;
                                FragmentManager fragmentManager2 = fragmentManager;
                                FragmentContainerViewFactory fragmentContainerViewFactory2 = fragmentContainerViewFactory;
                                int i10 = currentCompositeKeyHash;
                                fragmentFindFragmentById.setInitialSavedState(fragmentState5.getState$fragment_compose_release().getValue());
                                fragmentFindFragmentById.setArguments(bundle6);
                                FragmentTransaction fragmentTransactionAdd = fragmentManager2.beginTransaction().setReorderingAllowed(true).add(fragmentContainerViewFactory2.getContainer(), fragmentFindFragmentById, String.valueOf(i10));
                                if (fragmentManager2.isStateSaved()) {
                                    booleanRef.element = true;
                                    fragmentFindFragmentById.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$fragment$1$1
                                        @Override // androidx.lifecycle.DefaultLifecycleObserver
                                        public void onStart(LifecycleOwner owner) {
                                            booleanRef.element = false;
                                            fragmentFindFragmentById.getLifecycle().removeObserver(this);
                                        }
                                    });
                                    fragmentTransactionAdd.commitNowAllowingStateLoss();
                                } else {
                                    fragmentTransactionAdd.commitNow();
                                }
                            }
                            fragmentManager.onContainerAvailable(fragmentContainerViewFactory.getContainer());
                            Function1 function9 = (Function1) stateRememberUpdatedState.getValue();
                            Intrinsics.checkNotNull(fragmentFindFragmentById, "null cannot be cast to non-null type T of androidx.fragment.compose.AndroidFragmentKt.AndroidFragment$lambda$2");
                            function9.invoke(fragmentFindFragmentById);
                            final FragmentManager fragmentManager3 = fragmentManager;
                            final FragmentState fragmentState6 = fragmentState2;
                            return new DisposableEffectResult() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    fragmentState6.getState$fragment_compose_release().setValue(fragmentManager3.saveFragmentInstanceState(fragmentFindFragmentById));
                                    if (booleanRef.element) {
                                        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager3.beginTransaction();
                                        fragmentTransactionBeginTransaction.remove(fragmentFindFragmentById);
                                        fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                                    } else {
                                        if (fragmentManager3.isStateSaved()) {
                                            return;
                                        }
                                        FragmentTransaction fragmentTransactionBeginTransaction2 = fragmentManager3.beginTransaction();
                                        fragmentTransactionBeginTransaction2.remove(fragmentFindFragmentById);
                                        fragmentTransactionBeginTransaction2.commitNow();
                                    }
                                }
                            };
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                composer2.endReplaceableGroup();
                EffectsKt.DisposableEffect(objArr4, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function8;
                modifier3 = modifier7;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        fragmentStateRememberFragmentState = FragmentStateKt.rememberFragmentState(composerStartRestartGroup, 0);
                        i3 &= -897;
                    } else {
                        fragmentStateRememberFragmentState = fragmentState2;
                    }
                    if ((i2 & 8) != 0) {
                        bundle3 = Bundle.EMPTY;
                        i3 &= -7169;
                    } else {
                        bundle3 = bundle2;
                    }
                    if (i4 != 0) {
                        i6 = i3;
                        fragmentState3 = fragmentStateRememberFragmentState;
                        bundle4 = bundle3;
                        function3 = new Function1<T, Unit>() { // from class: androidx.fragment.compose.AndroidFragmentKt.AndroidFragment.2
                            /* JADX WARN: Incorrect types in method signature: (TT;)V */
                            public final void invoke(Fragment fragment) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                                invoke((Fragment) obj);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        i6 = i3;
                        fragmentState3 = fragmentStateRememberFragmentState;
                        function3 = function2;
                        bundle4 = bundle3;
                    }
                } else {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        fragmentStateRememberFragmentState = FragmentStateKt.rememberFragmentState(composerStartRestartGroup, 0);
                        i3 &= -897;
                    } else {
                        fragmentStateRememberFragmentState = fragmentState2;
                    }
                    if ((i2 & 8) != 0) {
                        bundle3 = Bundle.EMPTY;
                        i3 &= -7169;
                    } else {
                        bundle3 = bundle2;
                    }
                    if (i4 != 0) {
                        i6 = i3;
                        fragmentState3 = fragmentStateRememberFragmentState;
                        bundle4 = bundle3;
                        function3 = new Function1<T, Unit>() { // from class: androidx.fragment.compose.AndroidFragmentKt.AndroidFragment.2
                            /* JADX WARN: Incorrect types in method signature: (TT;)V */
                            public final void invoke(Fragment fragment) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                                invoke((Fragment) obj);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        i6 = i3;
                        fragmentState3 = fragmentStateRememberFragmentState;
                        function3 = function2;
                        bundle4 = bundle3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1012439764, i6, -1, "androidx.fragment.compose.AndroidFragment (AndroidFragment.kt:84)");
                }
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function3, composerStartRestartGroup, (i6 >> 12) & 14);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                ProvidableCompositionLocal<View> localView5 = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume9 = composerStartRestartGroup.consume(localView5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                view = (View) objConsume9;
                composerStartRestartGroup.startReplaceableGroup(485393906);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AndroidFragment.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(view);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = FragmentManager.findFragmentManager(view);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = FragmentManager.findFragmentManager(view);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                fragmentManager = (FragmentManager) objRememberedValue;
                composerStartRestartGroup.endReplaceableGroup();
                ProvidableCompositionLocal<Context> localContext5 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume10 = composerStartRestartGroup.consume(localContext5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume10;
                composerStartRestartGroup.startReplaceableGroup(485398332);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AndroidFragment.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new FragmentContainerViewFactory(currentCompositeKeyHash);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                fragmentContainerViewFactory = (FragmentContainerViewFactory) objRememberedValue2;
                composerStartRestartGroup.endReplaceableGroup();
                Function1<? super T, Unit> function9 = function3;
                AndroidView_androidKt.AndroidView(fragmentContainerViewFactory, companion, null, composerStartRestartGroup, i6 & 112, 4);
                Modifier modifier8 = companion;
                Object[] objArr5 = {fragmentManager, fragmentContainerViewFactory, cls, fragmentState3};
                composerStartRestartGroup.startReplaceableGroup(485406992);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AndroidFragment.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(fragmentManager) | composerStartRestartGroup.changedInstance(fragmentContainerViewFactory) | composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(cls) | ((((i6 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(fragmentState3)) || (i6 & 384) == 256) | composerStartRestartGroup.changedInstance(bundle4) | composerStartRestartGroup.changed(currentCompositeKeyHash) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    composer2 = composerStartRestartGroup;
                    fragmentState2 = fragmentState3;
                    bundle2 = bundle4;
                    objRememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                            final Fragment fragmentFindFragmentById = fragmentManager.findFragmentById(fragmentContainerViewFactory.getContainer().getId());
                            if (fragmentFindFragmentById == null) {
                                fragmentFindFragmentById = fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), cls.getName());
                                FragmentState fragmentState5 = fragmentState2;
                                Bundle bundle6 = bundle2;
                                FragmentManager fragmentManager2 = fragmentManager;
                                FragmentContainerViewFactory fragmentContainerViewFactory2 = fragmentContainerViewFactory;
                                int i10 = currentCompositeKeyHash;
                                fragmentFindFragmentById.setInitialSavedState(fragmentState5.getState$fragment_compose_release().getValue());
                                fragmentFindFragmentById.setArguments(bundle6);
                                FragmentTransaction fragmentTransactionAdd = fragmentManager2.beginTransaction().setReorderingAllowed(true).add(fragmentContainerViewFactory2.getContainer(), fragmentFindFragmentById, String.valueOf(i10));
                                if (fragmentManager2.isStateSaved()) {
                                    booleanRef.element = true;
                                    fragmentFindFragmentById.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$fragment$1$1
                                        @Override // androidx.lifecycle.DefaultLifecycleObserver
                                        public void onStart(LifecycleOwner owner) {
                                            booleanRef.element = false;
                                            fragmentFindFragmentById.getLifecycle().removeObserver(this);
                                        }
                                    });
                                    fragmentTransactionAdd.commitNowAllowingStateLoss();
                                } else {
                                    fragmentTransactionAdd.commitNow();
                                }
                            }
                            fragmentManager.onContainerAvailable(fragmentContainerViewFactory.getContainer());
                            Function1 function10 = (Function1) stateRememberUpdatedState.getValue();
                            Intrinsics.checkNotNull(fragmentFindFragmentById, "null cannot be cast to non-null type T of androidx.fragment.compose.AndroidFragmentKt.AndroidFragment$lambda$2");
                            function10.invoke(fragmentFindFragmentById);
                            final FragmentManager fragmentManager3 = fragmentManager;
                            final FragmentState fragmentState6 = fragmentState2;
                            return new DisposableEffectResult() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    fragmentState6.getState$fragment_compose_release().setValue(fragmentManager3.saveFragmentInstanceState(fragmentFindFragmentById));
                                    if (booleanRef.element) {
                                        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager3.beginTransaction();
                                        fragmentTransactionBeginTransaction.remove(fragmentFindFragmentById);
                                        fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                                    } else {
                                        if (fragmentManager3.isStateSaved()) {
                                            return;
                                        }
                                        FragmentTransaction fragmentTransactionBeginTransaction2 = fragmentManager3.beginTransaction();
                                        fragmentTransactionBeginTransaction2.remove(fragmentFindFragmentById);
                                        fragmentTransactionBeginTransaction2.commitNow();
                                    }
                                }
                            };
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    composer2 = composerStartRestartGroup;
                    fragmentState2 = fragmentState3;
                    bundle2 = bundle4;
                    objRememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                            final Fragment fragmentFindFragmentById = fragmentManager.findFragmentById(fragmentContainerViewFactory.getContainer().getId());
                            if (fragmentFindFragmentById == null) {
                                fragmentFindFragmentById = fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), cls.getName());
                                FragmentState fragmentState5 = fragmentState2;
                                Bundle bundle6 = bundle2;
                                FragmentManager fragmentManager2 = fragmentManager;
                                FragmentContainerViewFactory fragmentContainerViewFactory2 = fragmentContainerViewFactory;
                                int i10 = currentCompositeKeyHash;
                                fragmentFindFragmentById.setInitialSavedState(fragmentState5.getState$fragment_compose_release().getValue());
                                fragmentFindFragmentById.setArguments(bundle6);
                                FragmentTransaction fragmentTransactionAdd = fragmentManager2.beginTransaction().setReorderingAllowed(true).add(fragmentContainerViewFactory2.getContainer(), fragmentFindFragmentById, String.valueOf(i10));
                                if (fragmentManager2.isStateSaved()) {
                                    booleanRef.element = true;
                                    fragmentFindFragmentById.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$fragment$1$1
                                        @Override // androidx.lifecycle.DefaultLifecycleObserver
                                        public void onStart(LifecycleOwner owner) {
                                            booleanRef.element = false;
                                            fragmentFindFragmentById.getLifecycle().removeObserver(this);
                                        }
                                    });
                                    fragmentTransactionAdd.commitNowAllowingStateLoss();
                                } else {
                                    fragmentTransactionAdd.commitNow();
                                }
                            }
                            fragmentManager.onContainerAvailable(fragmentContainerViewFactory.getContainer());
                            Function1 function10 = (Function1) stateRememberUpdatedState.getValue();
                            Intrinsics.checkNotNull(fragmentFindFragmentById, "null cannot be cast to non-null type T of androidx.fragment.compose.AndroidFragmentKt.AndroidFragment$lambda$2");
                            function10.invoke(fragmentFindFragmentById);
                            final FragmentManager fragmentManager3 = fragmentManager;
                            final FragmentState fragmentState6 = fragmentState2;
                            return new DisposableEffectResult() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    fragmentState6.getState$fragment_compose_release().setValue(fragmentManager3.saveFragmentInstanceState(fragmentFindFragmentById));
                                    if (booleanRef.element) {
                                        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager3.beginTransaction();
                                        fragmentTransactionBeginTransaction.remove(fragmentFindFragmentById);
                                        fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                                    } else {
                                        if (fragmentManager3.isStateSaved()) {
                                            return;
                                        }
                                        FragmentTransaction fragmentTransactionBeginTransaction2 = fragmentManager3.beginTransaction();
                                        fragmentTransactionBeginTransaction2.remove(fragmentFindFragmentById);
                                        fragmentTransactionBeginTransaction2.commitNow();
                                    }
                                }
                            };
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                composer2.endReplaceableGroup();
                EffectsKt.DisposableEffect(objArr5, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function9;
                modifier3 = modifier8;
            }
            fragmentState4 = fragmentState2;
            bundle5 = bundle2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.fragment.compose.AndroidFragmentKt.AndroidFragment.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i10) {
                        AndroidFragmentKt.AndroidFragment(cls, modifier3, fragmentState4, bundle5, function4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 24576;
        function2 = function1;
        if ((i3 & 9363) == 9362) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    fragmentStateRememberFragmentState = FragmentStateKt.rememberFragmentState(composerStartRestartGroup, 0);
                    i3 &= -897;
                } else {
                    fragmentStateRememberFragmentState = fragmentState2;
                }
                if ((i2 & 8) != 0) {
                    bundle3 = Bundle.EMPTY;
                    i3 &= -7169;
                } else {
                    bundle3 = bundle2;
                }
                if (i4 != 0) {
                    i6 = i3;
                    fragmentState3 = fragmentStateRememberFragmentState;
                    bundle4 = bundle3;
                    function3 = new Function1<T, Unit>() { // from class: androidx.fragment.compose.AndroidFragmentKt.AndroidFragment.2
                        /* JADX WARN: Incorrect types in method signature: (TT;)V */
                        public final void invoke(Fragment fragment) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                            invoke((Fragment) obj);
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    i6 = i3;
                    fragmentState3 = fragmentStateRememberFragmentState;
                    function3 = function2;
                    bundle4 = bundle3;
                }
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    fragmentStateRememberFragmentState = FragmentStateKt.rememberFragmentState(composerStartRestartGroup, 0);
                    i3 &= -897;
                } else {
                    fragmentStateRememberFragmentState = fragmentState2;
                }
                if ((i2 & 8) != 0) {
                    bundle3 = Bundle.EMPTY;
                    i3 &= -7169;
                } else {
                    bundle3 = bundle2;
                }
                if (i4 != 0) {
                    i6 = i3;
                    fragmentState3 = fragmentStateRememberFragmentState;
                    bundle4 = bundle3;
                    function3 = new Function1<T, Unit>() { // from class: androidx.fragment.compose.AndroidFragmentKt.AndroidFragment.2
                        /* JADX WARN: Incorrect types in method signature: (TT;)V */
                        public final void invoke(Fragment fragment) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                            invoke((Fragment) obj);
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    i6 = i3;
                    fragmentState3 = fragmentStateRememberFragmentState;
                    function3 = function2;
                    bundle4 = bundle3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1012439764, i6, -1, "androidx.fragment.compose.AndroidFragment (AndroidFragment.kt:84)");
            }
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function3, composerStartRestartGroup, (i6 >> 12) & 14);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            ProvidableCompositionLocal<View> localView6 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume11 = composerStartRestartGroup.consume(localView6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            view = (View) objConsume11;
            composerStartRestartGroup.startReplaceableGroup(485393906);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AndroidFragment.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(view);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = FragmentManager.findFragmentManager(view);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = FragmentManager.findFragmentManager(view);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            fragmentManager = (FragmentManager) objRememberedValue;
            composerStartRestartGroup.endReplaceableGroup();
            ProvidableCompositionLocal<Context> localContext6 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume12 = composerStartRestartGroup.consume(localContext6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            context = (Context) objConsume12;
            composerStartRestartGroup.startReplaceableGroup(485398332);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AndroidFragment.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new FragmentContainerViewFactory(currentCompositeKeyHash);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            fragmentContainerViewFactory = (FragmentContainerViewFactory) objRememberedValue2;
            composerStartRestartGroup.endReplaceableGroup();
            Function1<? super T, Unit> function10 = function3;
            AndroidView_androidKt.AndroidView(fragmentContainerViewFactory, companion, null, composerStartRestartGroup, i6 & 112, 4);
            Modifier modifier9 = companion;
            Object[] objArr6 = {fragmentManager, fragmentContainerViewFactory, cls, fragmentState3};
            composerStartRestartGroup.startReplaceableGroup(485406992);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AndroidFragment.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(fragmentManager) | composerStartRestartGroup.changedInstance(fragmentContainerViewFactory) | composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(cls) | ((((i6 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(fragmentState3)) || (i6 & 384) == 256) | composerStartRestartGroup.changedInstance(bundle4) | composerStartRestartGroup.changed(currentCompositeKeyHash) | composerStartRestartGroup.changed(stateRememberUpdatedState);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                composer2 = composerStartRestartGroup;
                fragmentState2 = fragmentState3;
                bundle2 = bundle4;
                objRememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                        final Fragment fragmentFindFragmentById = fragmentManager.findFragmentById(fragmentContainerViewFactory.getContainer().getId());
                        if (fragmentFindFragmentById == null) {
                            fragmentFindFragmentById = fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), cls.getName());
                            FragmentState fragmentState5 = fragmentState2;
                            Bundle bundle6 = bundle2;
                            FragmentManager fragmentManager2 = fragmentManager;
                            FragmentContainerViewFactory fragmentContainerViewFactory2 = fragmentContainerViewFactory;
                            int i10 = currentCompositeKeyHash;
                            fragmentFindFragmentById.setInitialSavedState(fragmentState5.getState$fragment_compose_release().getValue());
                            fragmentFindFragmentById.setArguments(bundle6);
                            FragmentTransaction fragmentTransactionAdd = fragmentManager2.beginTransaction().setReorderingAllowed(true).add(fragmentContainerViewFactory2.getContainer(), fragmentFindFragmentById, String.valueOf(i10));
                            if (fragmentManager2.isStateSaved()) {
                                booleanRef.element = true;
                                fragmentFindFragmentById.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$fragment$1$1
                                    @Override // androidx.lifecycle.DefaultLifecycleObserver
                                    public void onStart(LifecycleOwner owner) {
                                        booleanRef.element = false;
                                        fragmentFindFragmentById.getLifecycle().removeObserver(this);
                                    }
                                });
                                fragmentTransactionAdd.commitNowAllowingStateLoss();
                            } else {
                                fragmentTransactionAdd.commitNow();
                            }
                        }
                        fragmentManager.onContainerAvailable(fragmentContainerViewFactory.getContainer());
                        Function1 function11 = (Function1) stateRememberUpdatedState.getValue();
                        Intrinsics.checkNotNull(fragmentFindFragmentById, "null cannot be cast to non-null type T of androidx.fragment.compose.AndroidFragmentKt.AndroidFragment$lambda$2");
                        function11.invoke(fragmentFindFragmentById);
                        final FragmentManager fragmentManager3 = fragmentManager;
                        final FragmentState fragmentState6 = fragmentState2;
                        return new DisposableEffectResult() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                fragmentState6.getState$fragment_compose_release().setValue(fragmentManager3.saveFragmentInstanceState(fragmentFindFragmentById));
                                if (booleanRef.element) {
                                    FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager3.beginTransaction();
                                    fragmentTransactionBeginTransaction.remove(fragmentFindFragmentById);
                                    fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                                } else {
                                    if (fragmentManager3.isStateSaved()) {
                                        return;
                                    }
                                    FragmentTransaction fragmentTransactionBeginTransaction2 = fragmentManager3.beginTransaction();
                                    fragmentTransactionBeginTransaction2.remove(fragmentFindFragmentById);
                                    fragmentTransactionBeginTransaction2.commitNow();
                                }
                            }
                        };
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            } else {
                composer2 = composerStartRestartGroup;
                fragmentState2 = fragmentState3;
                bundle2 = bundle4;
                objRememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                        final Fragment fragmentFindFragmentById = fragmentManager.findFragmentById(fragmentContainerViewFactory.getContainer().getId());
                        if (fragmentFindFragmentById == null) {
                            fragmentFindFragmentById = fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), cls.getName());
                            FragmentState fragmentState5 = fragmentState2;
                            Bundle bundle6 = bundle2;
                            FragmentManager fragmentManager2 = fragmentManager;
                            FragmentContainerViewFactory fragmentContainerViewFactory2 = fragmentContainerViewFactory;
                            int i10 = currentCompositeKeyHash;
                            fragmentFindFragmentById.setInitialSavedState(fragmentState5.getState$fragment_compose_release().getValue());
                            fragmentFindFragmentById.setArguments(bundle6);
                            FragmentTransaction fragmentTransactionAdd = fragmentManager2.beginTransaction().setReorderingAllowed(true).add(fragmentContainerViewFactory2.getContainer(), fragmentFindFragmentById, String.valueOf(i10));
                            if (fragmentManager2.isStateSaved()) {
                                booleanRef.element = true;
                                fragmentFindFragmentById.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$fragment$1$1
                                    @Override // androidx.lifecycle.DefaultLifecycleObserver
                                    public void onStart(LifecycleOwner owner) {
                                        booleanRef.element = false;
                                        fragmentFindFragmentById.getLifecycle().removeObserver(this);
                                    }
                                });
                                fragmentTransactionAdd.commitNowAllowingStateLoss();
                            } else {
                                fragmentTransactionAdd.commitNow();
                            }
                        }
                        fragmentManager.onContainerAvailable(fragmentContainerViewFactory.getContainer());
                        Function1 function11 = (Function1) stateRememberUpdatedState.getValue();
                        Intrinsics.checkNotNull(fragmentFindFragmentById, "null cannot be cast to non-null type T of androidx.fragment.compose.AndroidFragmentKt.AndroidFragment$lambda$2");
                        function11.invoke(fragmentFindFragmentById);
                        final FragmentManager fragmentManager3 = fragmentManager;
                        final FragmentState fragmentState6 = fragmentState2;
                        return new DisposableEffectResult() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                fragmentState6.getState$fragment_compose_release().setValue(fragmentManager3.saveFragmentInstanceState(fragmentFindFragmentById));
                                if (booleanRef.element) {
                                    FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager3.beginTransaction();
                                    fragmentTransactionBeginTransaction.remove(fragmentFindFragmentById);
                                    fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                                } else {
                                    if (fragmentManager3.isStateSaved()) {
                                        return;
                                    }
                                    FragmentTransaction fragmentTransactionBeginTransaction2 = fragmentManager3.beginTransaction();
                                    fragmentTransactionBeginTransaction2.remove(fragmentFindFragmentById);
                                    fragmentTransactionBeginTransaction2.commitNow();
                                }
                            }
                        };
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            }
            composer2.endReplaceableGroup();
            EffectsKt.DisposableEffect(objArr6, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function4 = function10;
            modifier3 = modifier9;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    fragmentStateRememberFragmentState = FragmentStateKt.rememberFragmentState(composerStartRestartGroup, 0);
                    i3 &= -897;
                } else {
                    fragmentStateRememberFragmentState = fragmentState2;
                }
                if ((i2 & 8) != 0) {
                    bundle3 = Bundle.EMPTY;
                    i3 &= -7169;
                } else {
                    bundle3 = bundle2;
                }
                if (i4 != 0) {
                    i6 = i3;
                    fragmentState3 = fragmentStateRememberFragmentState;
                    bundle4 = bundle3;
                    function3 = new Function1<T, Unit>() { // from class: androidx.fragment.compose.AndroidFragmentKt.AndroidFragment.2
                        /* JADX WARN: Incorrect types in method signature: (TT;)V */
                        public final void invoke(Fragment fragment) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                            invoke((Fragment) obj);
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    i6 = i3;
                    fragmentState3 = fragmentStateRememberFragmentState;
                    function3 = function2;
                    bundle4 = bundle3;
                }
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    fragmentStateRememberFragmentState = FragmentStateKt.rememberFragmentState(composerStartRestartGroup, 0);
                    i3 &= -897;
                } else {
                    fragmentStateRememberFragmentState = fragmentState2;
                }
                if ((i2 & 8) != 0) {
                    bundle3 = Bundle.EMPTY;
                    i3 &= -7169;
                } else {
                    bundle3 = bundle2;
                }
                if (i4 != 0) {
                    i6 = i3;
                    fragmentState3 = fragmentStateRememberFragmentState;
                    bundle4 = bundle3;
                    function3 = new Function1<T, Unit>() { // from class: androidx.fragment.compose.AndroidFragmentKt.AndroidFragment.2
                        /* JADX WARN: Incorrect types in method signature: (TT;)V */
                        public final void invoke(Fragment fragment) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                            invoke((Fragment) obj);
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    i6 = i3;
                    fragmentState3 = fragmentStateRememberFragmentState;
                    function3 = function2;
                    bundle4 = bundle3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1012439764, i6, -1, "androidx.fragment.compose.AndroidFragment (AndroidFragment.kt:84)");
            }
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function3, composerStartRestartGroup, (i6 >> 12) & 14);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            ProvidableCompositionLocal<View> localView7 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume13 = composerStartRestartGroup.consume(localView7);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            view = (View) objConsume13;
            composerStartRestartGroup.startReplaceableGroup(485393906);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AndroidFragment.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(view);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = FragmentManager.findFragmentManager(view);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = FragmentManager.findFragmentManager(view);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            fragmentManager = (FragmentManager) objRememberedValue;
            composerStartRestartGroup.endReplaceableGroup();
            ProvidableCompositionLocal<Context> localContext7 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume14 = composerStartRestartGroup.consume(localContext7);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            context = (Context) objConsume14;
            composerStartRestartGroup.startReplaceableGroup(485398332);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AndroidFragment.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new FragmentContainerViewFactory(currentCompositeKeyHash);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            fragmentContainerViewFactory = (FragmentContainerViewFactory) objRememberedValue2;
            composerStartRestartGroup.endReplaceableGroup();
            Function1<? super T, Unit> function11 = function3;
            AndroidView_androidKt.AndroidView(fragmentContainerViewFactory, companion, null, composerStartRestartGroup, i6 & 112, 4);
            Modifier modifier10 = companion;
            Object[] objArr7 = {fragmentManager, fragmentContainerViewFactory, cls, fragmentState3};
            composerStartRestartGroup.startReplaceableGroup(485406992);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AndroidFragment.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(fragmentManager) | composerStartRestartGroup.changedInstance(fragmentContainerViewFactory) | composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(cls) | ((((i6 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(fragmentState3)) || (i6 & 384) == 256) | composerStartRestartGroup.changedInstance(bundle4) | composerStartRestartGroup.changed(currentCompositeKeyHash) | composerStartRestartGroup.changed(stateRememberUpdatedState);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                composer2 = composerStartRestartGroup;
                fragmentState2 = fragmentState3;
                bundle2 = bundle4;
                objRememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                        final Fragment fragmentFindFragmentById = fragmentManager.findFragmentById(fragmentContainerViewFactory.getContainer().getId());
                        if (fragmentFindFragmentById == null) {
                            fragmentFindFragmentById = fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), cls.getName());
                            FragmentState fragmentState5 = fragmentState2;
                            Bundle bundle6 = bundle2;
                            FragmentManager fragmentManager2 = fragmentManager;
                            FragmentContainerViewFactory fragmentContainerViewFactory2 = fragmentContainerViewFactory;
                            int i10 = currentCompositeKeyHash;
                            fragmentFindFragmentById.setInitialSavedState(fragmentState5.getState$fragment_compose_release().getValue());
                            fragmentFindFragmentById.setArguments(bundle6);
                            FragmentTransaction fragmentTransactionAdd = fragmentManager2.beginTransaction().setReorderingAllowed(true).add(fragmentContainerViewFactory2.getContainer(), fragmentFindFragmentById, String.valueOf(i10));
                            if (fragmentManager2.isStateSaved()) {
                                booleanRef.element = true;
                                fragmentFindFragmentById.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$fragment$1$1
                                    @Override // androidx.lifecycle.DefaultLifecycleObserver
                                    public void onStart(LifecycleOwner owner) {
                                        booleanRef.element = false;
                                        fragmentFindFragmentById.getLifecycle().removeObserver(this);
                                    }
                                });
                                fragmentTransactionAdd.commitNowAllowingStateLoss();
                            } else {
                                fragmentTransactionAdd.commitNow();
                            }
                        }
                        fragmentManager.onContainerAvailable(fragmentContainerViewFactory.getContainer());
                        Function1 function12 = (Function1) stateRememberUpdatedState.getValue();
                        Intrinsics.checkNotNull(fragmentFindFragmentById, "null cannot be cast to non-null type T of androidx.fragment.compose.AndroidFragmentKt.AndroidFragment$lambda$2");
                        function12.invoke(fragmentFindFragmentById);
                        final FragmentManager fragmentManager3 = fragmentManager;
                        final FragmentState fragmentState6 = fragmentState2;
                        return new DisposableEffectResult() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                fragmentState6.getState$fragment_compose_release().setValue(fragmentManager3.saveFragmentInstanceState(fragmentFindFragmentById));
                                if (booleanRef.element) {
                                    FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager3.beginTransaction();
                                    fragmentTransactionBeginTransaction.remove(fragmentFindFragmentById);
                                    fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                                } else {
                                    if (fragmentManager3.isStateSaved()) {
                                        return;
                                    }
                                    FragmentTransaction fragmentTransactionBeginTransaction2 = fragmentManager3.beginTransaction();
                                    fragmentTransactionBeginTransaction2.remove(fragmentFindFragmentById);
                                    fragmentTransactionBeginTransaction2.commitNow();
                                }
                            }
                        };
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            } else {
                composer2 = composerStartRestartGroup;
                fragmentState2 = fragmentState3;
                bundle2 = bundle4;
                objRememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                        final Fragment fragmentFindFragmentById = fragmentManager.findFragmentById(fragmentContainerViewFactory.getContainer().getId());
                        if (fragmentFindFragmentById == null) {
                            fragmentFindFragmentById = fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), cls.getName());
                            FragmentState fragmentState5 = fragmentState2;
                            Bundle bundle6 = bundle2;
                            FragmentManager fragmentManager2 = fragmentManager;
                            FragmentContainerViewFactory fragmentContainerViewFactory2 = fragmentContainerViewFactory;
                            int i10 = currentCompositeKeyHash;
                            fragmentFindFragmentById.setInitialSavedState(fragmentState5.getState$fragment_compose_release().getValue());
                            fragmentFindFragmentById.setArguments(bundle6);
                            FragmentTransaction fragmentTransactionAdd = fragmentManager2.beginTransaction().setReorderingAllowed(true).add(fragmentContainerViewFactory2.getContainer(), fragmentFindFragmentById, String.valueOf(i10));
                            if (fragmentManager2.isStateSaved()) {
                                booleanRef.element = true;
                                fragmentFindFragmentById.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$fragment$1$1
                                    @Override // androidx.lifecycle.DefaultLifecycleObserver
                                    public void onStart(LifecycleOwner owner) {
                                        booleanRef.element = false;
                                        fragmentFindFragmentById.getLifecycle().removeObserver(this);
                                    }
                                });
                                fragmentTransactionAdd.commitNowAllowingStateLoss();
                            } else {
                                fragmentTransactionAdd.commitNow();
                            }
                        }
                        fragmentManager.onContainerAvailable(fragmentContainerViewFactory.getContainer());
                        Function1 function12 = (Function1) stateRememberUpdatedState.getValue();
                        Intrinsics.checkNotNull(fragmentFindFragmentById, "null cannot be cast to non-null type T of androidx.fragment.compose.AndroidFragmentKt.AndroidFragment$lambda$2");
                        function12.invoke(fragmentFindFragmentById);
                        final FragmentManager fragmentManager3 = fragmentManager;
                        final FragmentState fragmentState6 = fragmentState2;
                        return new DisposableEffectResult() { // from class: androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                fragmentState6.getState$fragment_compose_release().setValue(fragmentManager3.saveFragmentInstanceState(fragmentFindFragmentById));
                                if (booleanRef.element) {
                                    FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager3.beginTransaction();
                                    fragmentTransactionBeginTransaction.remove(fragmentFindFragmentById);
                                    fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                                } else {
                                    if (fragmentManager3.isStateSaved()) {
                                        return;
                                    }
                                    FragmentTransaction fragmentTransactionBeginTransaction2 = fragmentManager3.beginTransaction();
                                    fragmentTransactionBeginTransaction2.remove(fragmentFindFragmentById);
                                    fragmentTransactionBeginTransaction2.commitNow();
                                }
                            }
                        };
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            }
            composer2.endReplaceableGroup();
            EffectsKt.DisposableEffect(objArr7, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function4 = function11;
            modifier3 = modifier10;
        }
        fragmentState4 = fragmentState2;
        bundle5 = bundle2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.fragment.compose.AndroidFragmentKt.AndroidFragment.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i10) {
                    AndroidFragmentKt.AndroidFragment(cls, modifier3, fragmentState4, bundle5, function4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
