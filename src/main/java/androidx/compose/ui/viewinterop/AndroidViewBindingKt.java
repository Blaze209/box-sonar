package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.viewbinding.R;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ViewKt;
import androidx.viewbinding.ViewBinding;
import com.pspdfkit.analytics.Analytics;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidViewBinding.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u001a\u0089\u0001\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032K\u0010\u0004\u001aG\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u0002H\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0019\b\u0002\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001aÁ\u0001\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032K\u0010\u0004\u001aG\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u0002H\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u001b\b\u0002\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011¢\u0006\u0002\b\u00122\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u00122\u0019\b\u0002\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0016\u001a#\u0010\u0017\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00182\u0006\u0010\u0019\u001a\u0002H\u0002H\u0002¢\u0006\u0002\u0010\u001a\u001a\u001b\u0010\u001b\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0018H\u0002¢\u0006\u0002\u0010\u001c\u001a$\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00010\u0011H\u0002¨\u0006!"}, d2 = {"AndroidViewBinding", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/viewbinding/ViewBinding;", "factory", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Lkotlin/ParameterName;", "name", "inflater", "Landroid/view/ViewGroup;", "parent", "", "attachToParent", "modifier", "Landroidx/compose/ui/Modifier;", "update", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "onReset", "onRelease", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "setBinding", "Landroid/view/View;", "binding", "(Landroid/view/View;Landroidx/viewbinding/ViewBinding;)V", "getBinding", "(Landroid/view/View;)Landroidx/viewbinding/ViewBinding;", "forEachFragmentContainerView", "viewGroup", Analytics.Data.ACTION, "Landroidx/fragment/app/FragmentContainerView;", "ui-viewbinding"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidViewBindingKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidViewBinding$lambda$1(Function3 function3, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        AndroidViewBinding(function3, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidViewBinding$lambda$9(Function3 function3, Modifier modifier, Function1 function1, Function1 function2, Function1 function4, int i, int i2, Composer composer, int i3) {
        AndroidViewBinding(function3, modifier, function1, function2, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidViewBinding$lambda$0$0(ViewBinding viewBinding) {
        return Unit.INSTANCE;
    }

    public static final <T extends ViewBinding> void AndroidViewBinding(final Function3<? super LayoutInflater, ? super ViewGroup, ? super Boolean, ? extends T> function3, Modifier modifier, Function1<? super T, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        final Function1<? super T, Unit> function2;
        Function1<? super T, Unit> function4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1985291610);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AndroidViewBinding)N(factory,modifier,update)76@4010L2,78@4022L91:AndroidViewBinding.kt#z33iqn");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            function2 = function1;
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier3 = modifier;
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -899751576, "CC(remember):AndroidViewBinding.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$0$0((ViewBinding) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function4 = (Function1) objRememberedValue;
            } else {
                function4 = function1;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1985291610, i3, -1, "androidx.compose.ui.viewinterop.AndroidViewBinding (AndroidViewBinding.kt:77)");
            }
            AndroidViewBinding(function3, modifier3, null, null, function4, composerStartRestartGroup, (i3 & 14) | 384 | (i3 & 112) | (57344 & (i3 << 6)), 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            function2 = function4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AndroidViewBindingKt.AndroidViewBinding$lambda$1(function3, modifier2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidViewBinding$lambda$2$0(ViewBinding viewBinding) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidViewBinding$lambda$3$0(ViewBinding viewBinding) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0190  */
    /* JADX WARN: Code duplicated, block: B:103:0x019a  */
    /* JADX WARN: Code duplicated, block: B:105:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:107:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:111:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:112:0x01da  */
    /* JADX WARN: Code duplicated, block: B:115:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:117:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:120:0x020f  */
    /* JADX WARN: Code duplicated, block: B:123:0x0217  */
    /* JADX WARN: Code duplicated, block: B:125:0x021f  */
    /* JADX WARN: Code duplicated, block: B:128:0x023d  */
    /* JADX WARN: Code duplicated, block: B:130:0x0244  */
    /* JADX WARN: Code duplicated, block: B:133:0x0252  */
    /* JADX WARN: Code duplicated, block: B:135:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0043  */
    /* JADX WARN: Code duplicated, block: B:24:0x0046  */
    /* JADX WARN: Code duplicated, block: B:26:0x004a  */
    /* JADX WARN: Code duplicated, block: B:28:0x0052  */
    /* JADX WARN: Code duplicated, block: B:29:0x0055  */
    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0062  */
    /* JADX WARN: Code duplicated, block: B:37:0x0066  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:45:0x007b  */
    /* JADX WARN: Code duplicated, block: B:46:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0082  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:51:0x008d  */
    /* JADX WARN: Code duplicated, block: B:56:0x009e  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ab A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:73:0x00df  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:81:0x0108  */
    /* JADX WARN: Code duplicated, block: B:84:0x0136  */
    /* JADX WARN: Code duplicated, block: B:92:0x016d  */
    /* JADX WARN: Code duplicated, block: B:93:0x0170  */
    /* JADX WARN: Code duplicated, block: B:96:0x0179  */
    /* JADX WARN: Code duplicated, block: B:98:0x0181  */
    public static final <T extends ViewBinding> void AndroidViewBinding(final Function3<? super LayoutInflater, ? super ViewGroup, ? super Boolean, ? extends T> function3, Modifier modifier, Function1<? super T, Unit> function1, Function1<? super T, Unit> function2, Function1<? super T, Unit> function4, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        int i6;
        Function1<? super T, Unit> function5;
        int i7;
        int i8;
        final Function1<? super T, Unit> function6;
        int i9;
        boolean z;
        final Function1<? super T, Unit> function7;
        final Modifier modifier3;
        final Function1<? super T, Unit> function8;
        final Function1<? super T, Unit> function9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Function1 function10;
        final Function1<? super T, Unit> function11;
        final Function1<? super T, Unit> function12;
        View view;
        boolean zChanged;
        Object objRememberedValue;
        final Fragment fragment;
        final Context context;
        boolean z2;
        boolean z3;
        Object objRememberedValue2;
        boolean zChanged2;
        Object objRememberedValue3;
        boolean z4;
        boolean zChangedInstance;
        Object objRememberedValue4;
        boolean z5;
        Object objRememberedValue5;
        Object objRememberedValue6;
        Object objRememberedValue7;
        Composer composerStartRestartGroup = composer.startRestartGroup(509101952);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AndroidViewBinding)N(factory,modifier,onReset,onRelease,update)146@8940L2,147@8971L2,149@9009L7,154@9284L254,163@9576L7,165@9619L383,174@10139L1062,194@11220L41,164@9588L1680:AndroidViewBinding.kt#z33iqn");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        function5 = function2;
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((i & 24576) == 0) {
                            function6 = function4;
                            if (composerStartRestartGroup.changedInstance(function6)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        if ((i3 & 9363) != 9362) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            function7 = function1;
                            modifier3 = modifier2;
                            function8 = function5;
                        } else {
                            if (i10 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            function10 = null;
                            if (i4 != 0) {
                                function11 = null;
                            } else {
                                function11 = function1;
                            }
                            if (i6 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379288382, "CC(remember):AndroidViewBinding.kt#9igjgp");
                                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue7 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return AndroidViewBindingKt.AndroidViewBinding$lambda$2$0((ViewBinding) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                                }
                                function12 = (Function1) objRememberedValue7;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function12 = function5;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379287390, "CC(remember):AndroidViewBinding.kt#9igjgp");
                                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue6 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return AndroidViewBindingKt.AndroidViewBinding$lambda$3$0((ViewBinding) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function6 = (Function1) objRememberedValue6;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(509101952, i3, -1, "androidx.compose.ui.viewinterop.AndroidViewBinding (AndroidViewBinding.kt:148)");
                            }
                            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localView);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            view = (View) objConsume;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379277122, "CC(remember):AndroidViewBinding.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(view);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                try {
                                    objRememberedValue = ViewKt.findFragment(view);
                                } catch (IllegalStateException unused) {
                                    objRememberedValue = null;
                                }
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            fragment = (Fragment) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composerStartRestartGroup.consume(localContext);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            context = (Context) objConsume2;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379266273, "CC(remember):AndroidViewBinding.kt#9igjgp");
                            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(fragment);
                            if ((i3 & 14) == 4) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            z3 = z2 | zChangedInstance2;
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            Function1 function13 = (Function1) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (function11 == null) {
                                composerStartRestartGroup.startReplaceGroup(1128074793);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*173@10075L40");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1209739933, "CC(remember):AndroidViewBinding.kt#9igjgp");
                                zChanged2 = composerStartRestartGroup.changed(function11);
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                function10 = (Function1) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1128074792);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379248954, "CC(remember):AndroidViewBinding.kt#9igjgp");
                            if ((i3 & 7168) == 2048) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            zChangedInstance = z4 | composerStartRestartGroup.changedInstance(fragment) | composerStartRestartGroup.changedInstance(context);
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            Function1 function14 = (Function1) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379215383, "CC(remember):AndroidViewBinding.kt#9igjgp");
                            z5 = (57344 & i3) == 16384;
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (!z5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Function1<? super T, Unit> function15 = function12;
                            AndroidView_androidKt.AndroidView(function13, modifier4, function10, function14, (Function1) objRememberedValue5, composerStartRestartGroup, i3 & 112, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function8 = function15;
                            function7 = function11;
                            modifier3 = modifier4;
                        }
                        function9 = function6;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$9(function3, modifier3, function7, function8, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 24576;
                    function6 = function4;
                    if ((i3 & 9363) != 9362) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        function7 = function1;
                        modifier3 = modifier2;
                        function8 = function5;
                    } else {
                        if (i10 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        function10 = null;
                        if (i4 != 0) {
                            function11 = null;
                        } else {
                            function11 = function1;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379288382, "CC(remember):AndroidViewBinding.kt#9igjgp");
                            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue7 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AndroidViewBindingKt.AndroidViewBinding$lambda$2$0((ViewBinding) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                            }
                            function12 = (Function1) objRememberedValue7;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function12 = function5;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379287390, "CC(remember):AndroidViewBinding.kt#9igjgp");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AndroidViewBindingKt.AndroidViewBinding$lambda$3$0((ViewBinding) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function6 = (Function1) objRememberedValue6;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(509101952, i3, -1, "androidx.compose.ui.viewinterop.AndroidViewBinding (AndroidViewBinding.kt:148)");
                        }
                        ProvidableCompositionLocal<View> localView2 = AndroidCompositionLocals_androidKt.getLocalView();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume3 = composerStartRestartGroup.consume(localView2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        view = (View) objConsume3;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379277122, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(view);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = ViewKt.findFragment(view);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = ViewKt.findFragment(view);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        fragment = (Fragment) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume4 = composerStartRestartGroup.consume(localContext2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        context = (Context) objConsume4;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379266273, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(fragment);
                        if ((i3 & 14) == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z3 = z2 | zChangedInstance3;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z3) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        Function1 function16 = (Function1) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (function11 == null) {
                            composerStartRestartGroup.startReplaceGroup(1128074793);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*173@10075L40");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1209739933, "CC(remember):AndroidViewBinding.kt#9igjgp");
                            zChanged2 = composerStartRestartGroup.changed(function11);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2) {
                                objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            function10 = (Function1) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1128074792);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379248954, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        if ((i3 & 7168) == 2048) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        zChangedInstance = z4 | composerStartRestartGroup.changedInstance(fragment) | composerStartRestartGroup.changedInstance(context);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance) {
                            objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        Function1 function17 = (Function1) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379215383, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        if ((57344 & i3) == 16384) {
                        }
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Function1<? super T, Unit> function18 = function12;
                        AndroidView_androidKt.AndroidView(function16, modifier4, function10, function17, (Function1) objRememberedValue5, composerStartRestartGroup, i3 & 112, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function8 = function18;
                        function7 = function11;
                        modifier3 = modifier4;
                    }
                    function9 = function6;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$9(function3, modifier3, function7, function8, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                function5 = function2;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        function6 = function4;
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i3 & 9363) != 9362) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        function7 = function1;
                        modifier3 = modifier2;
                        function8 = function5;
                    } else {
                        if (i10 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        function10 = null;
                        if (i4 != 0) {
                            function11 = null;
                        } else {
                            function11 = function1;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379288382, "CC(remember):AndroidViewBinding.kt#9igjgp");
                            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue7 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AndroidViewBindingKt.AndroidViewBinding$lambda$2$0((ViewBinding) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                            }
                            function12 = (Function1) objRememberedValue7;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function12 = function5;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379287390, "CC(remember):AndroidViewBinding.kt#9igjgp");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AndroidViewBindingKt.AndroidViewBinding$lambda$3$0((ViewBinding) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function6 = (Function1) objRememberedValue6;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(509101952, i3, -1, "androidx.compose.ui.viewinterop.AndroidViewBinding (AndroidViewBinding.kt:148)");
                        }
                        ProvidableCompositionLocal<View> localView3 = AndroidCompositionLocals_androidKt.getLocalView();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume5 = composerStartRestartGroup.consume(localView3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        view = (View) objConsume5;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379277122, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(view);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = ViewKt.findFragment(view);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = ViewKt.findFragment(view);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        fragment = (Fragment) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Context> localContext3 = AndroidCompositionLocals_androidKt.getLocalContext();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume6 = composerStartRestartGroup.consume(localContext3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        context = (Context) objConsume6;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379266273, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(fragment);
                        if ((i3 & 14) == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z3 = z2 | zChangedInstance4;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z3) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        Function1 function19 = (Function1) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (function11 == null) {
                            composerStartRestartGroup.startReplaceGroup(1128074793);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*173@10075L40");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1209739933, "CC(remember):AndroidViewBinding.kt#9igjgp");
                            zChanged2 = composerStartRestartGroup.changed(function11);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2) {
                                objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            function10 = (Function1) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1128074792);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379248954, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        if ((i3 & 7168) == 2048) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        zChangedInstance = z4 | composerStartRestartGroup.changedInstance(fragment) | composerStartRestartGroup.changedInstance(context);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance) {
                            objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        Function1 function110 = (Function1) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379215383, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        if ((57344 & i3) == 16384) {
                        }
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Function1<? super T, Unit> function111 = function12;
                        AndroidView_androidKt.AndroidView(function19, modifier4, function10, function110, (Function1) objRememberedValue5, composerStartRestartGroup, i3 & 112, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function8 = function111;
                        function7 = function11;
                        modifier3 = modifier4;
                    }
                    function9 = function6;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$9(function3, modifier3, function7, function8, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                function6 = function4;
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function7 = function1;
                    modifier3 = modifier2;
                    function8 = function5;
                } else {
                    if (i10 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    function10 = null;
                    if (i4 != 0) {
                        function11 = null;
                    } else {
                        function11 = function1;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379288382, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$2$0((ViewBinding) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        function12 = (Function1) objRememberedValue7;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function12 = function5;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379287390, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$3$0((ViewBinding) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function6 = (Function1) objRememberedValue6;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(509101952, i3, -1, "androidx.compose.ui.viewinterop.AndroidViewBinding (AndroidViewBinding.kt:148)");
                    }
                    ProvidableCompositionLocal<View> localView4 = AndroidCompositionLocals_androidKt.getLocalView();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume7 = composerStartRestartGroup.consume(localView4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    view = (View) objConsume7;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379277122, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(view);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = ViewKt.findFragment(view);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = ViewKt.findFragment(view);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    fragment = (Fragment) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Context> localContext4 = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume8 = composerStartRestartGroup.consume(localContext4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    context = (Context) objConsume8;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379266273, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    boolean zChangedInstance5 = composerStartRestartGroup.changedInstance(fragment);
                    if ((i3 & 14) == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z2 | zChangedInstance5;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function112 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (function11 == null) {
                        composerStartRestartGroup.startReplaceGroup(1128074793);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*173@10075L40");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1209739933, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(function11);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function10 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1128074792);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379248954, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    zChangedInstance = z4 | composerStartRestartGroup.changedInstance(fragment) | composerStartRestartGroup.changedInstance(context);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function113 = (Function1) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379215383, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    if ((57344 & i3) == 16384) {
                    }
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Function1<? super T, Unit> function114 = function12;
                    AndroidView_androidKt.AndroidView(function112, modifier4, function10, function113, (Function1) objRememberedValue5, composerStartRestartGroup, i3 & 112, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function8 = function114;
                    function7 = function11;
                    modifier3 = modifier4;
                }
                function9 = function6;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$9(function3, modifier3, function7, function8, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    function5 = function2;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        function6 = function4;
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i3 & 9363) != 9362) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        function7 = function1;
                        modifier3 = modifier2;
                        function8 = function5;
                    } else {
                        if (i10 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        function10 = null;
                        if (i4 != 0) {
                            function11 = null;
                        } else {
                            function11 = function1;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379288382, "CC(remember):AndroidViewBinding.kt#9igjgp");
                            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue7 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AndroidViewBindingKt.AndroidViewBinding$lambda$2$0((ViewBinding) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                            }
                            function12 = (Function1) objRememberedValue7;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function12 = function5;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379287390, "CC(remember):AndroidViewBinding.kt#9igjgp");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AndroidViewBindingKt.AndroidViewBinding$lambda$3$0((ViewBinding) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function6 = (Function1) objRememberedValue6;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(509101952, i3, -1, "androidx.compose.ui.viewinterop.AndroidViewBinding (AndroidViewBinding.kt:148)");
                        }
                        ProvidableCompositionLocal<View> localView5 = AndroidCompositionLocals_androidKt.getLocalView();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume9 = composerStartRestartGroup.consume(localView5);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        view = (View) objConsume9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379277122, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(view);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = ViewKt.findFragment(view);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = ViewKt.findFragment(view);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        fragment = (Fragment) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Context> localContext5 = AndroidCompositionLocals_androidKt.getLocalContext();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume10 = composerStartRestartGroup.consume(localContext5);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        context = (Context) objConsume10;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379266273, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        boolean zChangedInstance6 = composerStartRestartGroup.changedInstance(fragment);
                        if ((i3 & 14) == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z3 = z2 | zChangedInstance6;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z3) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        Function1 function115 = (Function1) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (function11 == null) {
                            composerStartRestartGroup.startReplaceGroup(1128074793);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*173@10075L40");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1209739933, "CC(remember):AndroidViewBinding.kt#9igjgp");
                            zChanged2 = composerStartRestartGroup.changed(function11);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2) {
                                objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            function10 = (Function1) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1128074792);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379248954, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        if ((i3 & 7168) == 2048) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        zChangedInstance = z4 | composerStartRestartGroup.changedInstance(fragment) | composerStartRestartGroup.changedInstance(context);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance) {
                            objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        Function1 function116 = (Function1) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379215383, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        if ((57344 & i3) == 16384) {
                        }
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Function1<? super T, Unit> function117 = function12;
                        AndroidView_androidKt.AndroidView(function115, modifier4, function10, function116, (Function1) objRememberedValue5, composerStartRestartGroup, i3 & 112, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function8 = function117;
                        function7 = function11;
                        modifier3 = modifier4;
                    }
                    function9 = function6;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$9(function3, modifier3, function7, function8, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                function6 = function4;
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function7 = function1;
                    modifier3 = modifier2;
                    function8 = function5;
                } else {
                    if (i10 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    function10 = null;
                    if (i4 != 0) {
                        function11 = null;
                    } else {
                        function11 = function1;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379288382, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$2$0((ViewBinding) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        function12 = (Function1) objRememberedValue7;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function12 = function5;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379287390, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$3$0((ViewBinding) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function6 = (Function1) objRememberedValue6;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(509101952, i3, -1, "androidx.compose.ui.viewinterop.AndroidViewBinding (AndroidViewBinding.kt:148)");
                    }
                    ProvidableCompositionLocal<View> localView6 = AndroidCompositionLocals_androidKt.getLocalView();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume11 = composerStartRestartGroup.consume(localView6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    view = (View) objConsume11;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379277122, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(view);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = ViewKt.findFragment(view);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = ViewKt.findFragment(view);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    fragment = (Fragment) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Context> localContext6 = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume12 = composerStartRestartGroup.consume(localContext6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    context = (Context) objConsume12;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379266273, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    boolean zChangedInstance7 = composerStartRestartGroup.changedInstance(fragment);
                    if ((i3 & 14) == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z2 | zChangedInstance7;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function118 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (function11 == null) {
                        composerStartRestartGroup.startReplaceGroup(1128074793);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*173@10075L40");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1209739933, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(function11);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function10 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1128074792);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379248954, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    zChangedInstance = z4 | composerStartRestartGroup.changedInstance(fragment) | composerStartRestartGroup.changedInstance(context);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function119 = (Function1) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379215383, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    if ((57344 & i3) == 16384) {
                    }
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Function1<? super T, Unit> function1110 = function12;
                    AndroidView_androidKt.AndroidView(function118, modifier4, function10, function119, (Function1) objRememberedValue5, composerStartRestartGroup, i3 & 112, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function8 = function1110;
                    function7 = function11;
                    modifier3 = modifier4;
                }
                function9 = function6;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$9(function3, modifier3, function7, function8, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            function5 = function2;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    function6 = function4;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function7 = function1;
                    modifier3 = modifier2;
                    function8 = function5;
                } else {
                    if (i10 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    function10 = null;
                    if (i4 != 0) {
                        function11 = null;
                    } else {
                        function11 = function1;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379288382, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$2$0((ViewBinding) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        function12 = (Function1) objRememberedValue7;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function12 = function5;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379287390, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$3$0((ViewBinding) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function6 = (Function1) objRememberedValue6;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(509101952, i3, -1, "androidx.compose.ui.viewinterop.AndroidViewBinding (AndroidViewBinding.kt:148)");
                    }
                    ProvidableCompositionLocal<View> localView7 = AndroidCompositionLocals_androidKt.getLocalView();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume13 = composerStartRestartGroup.consume(localView7);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    view = (View) objConsume13;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379277122, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(view);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = ViewKt.findFragment(view);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = ViewKt.findFragment(view);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    fragment = (Fragment) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Context> localContext7 = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume14 = composerStartRestartGroup.consume(localContext7);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    context = (Context) objConsume14;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379266273, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    boolean zChangedInstance8 = composerStartRestartGroup.changedInstance(fragment);
                    if ((i3 & 14) == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z2 | zChangedInstance8;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function1111 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (function11 == null) {
                        composerStartRestartGroup.startReplaceGroup(1128074793);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*173@10075L40");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1209739933, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(function11);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function10 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1128074792);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379248954, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    zChangedInstance = z4 | composerStartRestartGroup.changedInstance(fragment) | composerStartRestartGroup.changedInstance(context);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function1112 = (Function1) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379215383, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    if ((57344 & i3) == 16384) {
                    }
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Function1<? super T, Unit> function1113 = function12;
                    AndroidView_androidKt.AndroidView(function1111, modifier4, function10, function1112, (Function1) objRememberedValue5, composerStartRestartGroup, i3 & 112, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function8 = function1113;
                    function7 = function11;
                    modifier3 = modifier4;
                }
                function9 = function6;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$9(function3, modifier3, function7, function8, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function6 = function4;
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                function7 = function1;
                modifier3 = modifier2;
                function8 = function5;
            } else {
                if (i10 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                function10 = null;
                if (i4 != 0) {
                    function11 = null;
                } else {
                    function11 = function1;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379288382, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$2$0((ViewBinding) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    function12 = (Function1) objRememberedValue7;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function12 = function5;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379287390, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$3$0((ViewBinding) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function6 = (Function1) objRememberedValue6;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(509101952, i3, -1, "androidx.compose.ui.viewinterop.AndroidViewBinding (AndroidViewBinding.kt:148)");
                }
                ProvidableCompositionLocal<View> localView8 = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume15 = composerStartRestartGroup.consume(localView8);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                view = (View) objConsume15;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379277122, "CC(remember):AndroidViewBinding.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(view);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = ViewKt.findFragment(view);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = ViewKt.findFragment(view);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                fragment = (Fragment) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Context> localContext8 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume16 = composerStartRestartGroup.consume(localContext8);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume16;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379266273, "CC(remember):AndroidViewBinding.kt#9igjgp");
                boolean zChangedInstance9 = composerStartRestartGroup.changedInstance(fragment);
                if ((i3 & 14) == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = z2 | zChangedInstance9;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function1 function1114 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (function11 == null) {
                    composerStartRestartGroup.startReplaceGroup(1128074793);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*173@10075L40");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1209739933, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(function11);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    function10 = (Function1) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1128074792);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379248954, "CC(remember):AndroidViewBinding.kt#9igjgp");
                if ((i3 & 7168) == 2048) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                zChangedInstance = z4 | composerStartRestartGroup.changedInstance(fragment) | composerStartRestartGroup.changedInstance(context);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                Function1 function1115 = (Function1) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379215383, "CC(remember):AndroidViewBinding.kt#9igjgp");
                if ((57344 & i3) == 16384) {
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Function1<? super T, Unit> function1116 = function12;
                AndroidView_androidKt.AndroidView(function1114, modifier4, function10, function1115, (Function1) objRememberedValue5, composerStartRestartGroup, i3 & 112, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function8 = function1116;
                function7 = function11;
                modifier3 = modifier4;
            }
            function9 = function6;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidViewBindingKt.AndroidViewBinding$lambda$9(function3, modifier3, function7, function8, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    function5 = function2;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        function6 = function4;
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i3 & 9363) != 9362) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        function7 = function1;
                        modifier3 = modifier2;
                        function8 = function5;
                    } else {
                        if (i10 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        function10 = null;
                        if (i4 != 0) {
                            function11 = null;
                        } else {
                            function11 = function1;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379288382, "CC(remember):AndroidViewBinding.kt#9igjgp");
                            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue7 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AndroidViewBindingKt.AndroidViewBinding$lambda$2$0((ViewBinding) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                            }
                            function12 = (Function1) objRememberedValue7;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function12 = function5;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379287390, "CC(remember):AndroidViewBinding.kt#9igjgp");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AndroidViewBindingKt.AndroidViewBinding$lambda$3$0((ViewBinding) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function6 = (Function1) objRememberedValue6;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(509101952, i3, -1, "androidx.compose.ui.viewinterop.AndroidViewBinding (AndroidViewBinding.kt:148)");
                        }
                        ProvidableCompositionLocal<View> localView9 = AndroidCompositionLocals_androidKt.getLocalView();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume17 = composerStartRestartGroup.consume(localView9);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        view = (View) objConsume17;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379277122, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(view);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = ViewKt.findFragment(view);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = ViewKt.findFragment(view);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        fragment = (Fragment) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Context> localContext9 = AndroidCompositionLocals_androidKt.getLocalContext();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume18 = composerStartRestartGroup.consume(localContext9);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        context = (Context) objConsume18;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379266273, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        boolean zChangedInstance10 = composerStartRestartGroup.changedInstance(fragment);
                        if ((i3 & 14) == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z3 = z2 | zChangedInstance10;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z3) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        Function1 function1117 = (Function1) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (function11 == null) {
                            composerStartRestartGroup.startReplaceGroup(1128074793);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*173@10075L40");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1209739933, "CC(remember):AndroidViewBinding.kt#9igjgp");
                            zChanged2 = composerStartRestartGroup.changed(function11);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2) {
                                objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            function10 = (Function1) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1128074792);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379248954, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        if ((i3 & 7168) == 2048) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        zChangedInstance = z4 | composerStartRestartGroup.changedInstance(fragment) | composerStartRestartGroup.changedInstance(context);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance) {
                            objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        Function1 function1118 = (Function1) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379215383, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        if ((57344 & i3) == 16384) {
                        }
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Function1<? super T, Unit> function1119 = function12;
                        AndroidView_androidKt.AndroidView(function1117, modifier4, function10, function1118, (Function1) objRememberedValue5, composerStartRestartGroup, i3 & 112, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function8 = function1119;
                        function7 = function11;
                        modifier3 = modifier4;
                    }
                    function9 = function6;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$9(function3, modifier3, function7, function8, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                function6 = function4;
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function7 = function1;
                    modifier3 = modifier2;
                    function8 = function5;
                } else {
                    if (i10 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    function10 = null;
                    if (i4 != 0) {
                        function11 = null;
                    } else {
                        function11 = function1;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379288382, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$2$0((ViewBinding) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        function12 = (Function1) objRememberedValue7;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function12 = function5;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379287390, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$3$0((ViewBinding) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function6 = (Function1) objRememberedValue6;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(509101952, i3, -1, "androidx.compose.ui.viewinterop.AndroidViewBinding (AndroidViewBinding.kt:148)");
                    }
                    ProvidableCompositionLocal<View> localView10 = AndroidCompositionLocals_androidKt.getLocalView();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume19 = composerStartRestartGroup.consume(localView10);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    view = (View) objConsume19;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379277122, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(view);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = ViewKt.findFragment(view);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = ViewKt.findFragment(view);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    fragment = (Fragment) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Context> localContext10 = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume110 = composerStartRestartGroup.consume(localContext10);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    context = (Context) objConsume110;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379266273, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    boolean zChangedInstance11 = composerStartRestartGroup.changedInstance(fragment);
                    if ((i3 & 14) == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z2 | zChangedInstance11;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function11110 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (function11 == null) {
                        composerStartRestartGroup.startReplaceGroup(1128074793);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*173@10075L40");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1209739933, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(function11);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function10 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1128074792);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379248954, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    zChangedInstance = z4 | composerStartRestartGroup.changedInstance(fragment) | composerStartRestartGroup.changedInstance(context);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function11111 = (Function1) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379215383, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    if ((57344 & i3) == 16384) {
                    }
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Function1<? super T, Unit> function11112 = function12;
                    AndroidView_androidKt.AndroidView(function11110, modifier4, function10, function11111, (Function1) objRememberedValue5, composerStartRestartGroup, i3 & 112, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function8 = function11112;
                    function7 = function11;
                    modifier3 = modifier4;
                }
                function9 = function6;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$9(function3, modifier3, function7, function8, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            function5 = function2;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    function6 = function4;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function7 = function1;
                    modifier3 = modifier2;
                    function8 = function5;
                } else {
                    if (i10 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    function10 = null;
                    if (i4 != 0) {
                        function11 = null;
                    } else {
                        function11 = function1;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379288382, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$2$0((ViewBinding) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        function12 = (Function1) objRememberedValue7;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function12 = function5;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379287390, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$3$0((ViewBinding) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function6 = (Function1) objRememberedValue6;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(509101952, i3, -1, "androidx.compose.ui.viewinterop.AndroidViewBinding (AndroidViewBinding.kt:148)");
                    }
                    ProvidableCompositionLocal<View> localView11 = AndroidCompositionLocals_androidKt.getLocalView();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume111 = composerStartRestartGroup.consume(localView11);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    view = (View) objConsume111;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379277122, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(view);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = ViewKt.findFragment(view);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = ViewKt.findFragment(view);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    fragment = (Fragment) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Context> localContext11 = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume112 = composerStartRestartGroup.consume(localContext11);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    context = (Context) objConsume112;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379266273, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    boolean zChangedInstance12 = composerStartRestartGroup.changedInstance(fragment);
                    if ((i3 & 14) == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z2 | zChangedInstance12;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function11113 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (function11 == null) {
                        composerStartRestartGroup.startReplaceGroup(1128074793);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*173@10075L40");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1209739933, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(function11);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function10 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1128074792);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379248954, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    zChangedInstance = z4 | composerStartRestartGroup.changedInstance(fragment) | composerStartRestartGroup.changedInstance(context);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function11114 = (Function1) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379215383, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    if ((57344 & i3) == 16384) {
                    }
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Function1<? super T, Unit> function11115 = function12;
                    AndroidView_androidKt.AndroidView(function11113, modifier4, function10, function11114, (Function1) objRememberedValue5, composerStartRestartGroup, i3 & 112, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function8 = function11115;
                    function7 = function11;
                    modifier3 = modifier4;
                }
                function9 = function6;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$9(function3, modifier3, function7, function8, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function6 = function4;
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                function7 = function1;
                modifier3 = modifier2;
                function8 = function5;
            } else {
                if (i10 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                function10 = null;
                if (i4 != 0) {
                    function11 = null;
                } else {
                    function11 = function1;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379288382, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$2$0((ViewBinding) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    function12 = (Function1) objRememberedValue7;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function12 = function5;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379287390, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$3$0((ViewBinding) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function6 = (Function1) objRememberedValue6;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(509101952, i3, -1, "androidx.compose.ui.viewinterop.AndroidViewBinding (AndroidViewBinding.kt:148)");
                }
                ProvidableCompositionLocal<View> localView12 = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume113 = composerStartRestartGroup.consume(localView12);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                view = (View) objConsume113;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379277122, "CC(remember):AndroidViewBinding.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(view);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = ViewKt.findFragment(view);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = ViewKt.findFragment(view);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                fragment = (Fragment) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Context> localContext12 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume114 = composerStartRestartGroup.consume(localContext12);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume114;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379266273, "CC(remember):AndroidViewBinding.kt#9igjgp");
                boolean zChangedInstance13 = composerStartRestartGroup.changedInstance(fragment);
                if ((i3 & 14) == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = z2 | zChangedInstance13;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function1 function11116 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (function11 == null) {
                    composerStartRestartGroup.startReplaceGroup(1128074793);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*173@10075L40");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1209739933, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(function11);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    function10 = (Function1) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1128074792);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379248954, "CC(remember):AndroidViewBinding.kt#9igjgp");
                if ((i3 & 7168) == 2048) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                zChangedInstance = z4 | composerStartRestartGroup.changedInstance(fragment) | composerStartRestartGroup.changedInstance(context);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                Function1 function11117 = (Function1) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379215383, "CC(remember):AndroidViewBinding.kt#9igjgp");
                if ((57344 & i3) == 16384) {
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Function1<? super T, Unit> function11118 = function12;
                AndroidView_androidKt.AndroidView(function11116, modifier4, function10, function11117, (Function1) objRememberedValue5, composerStartRestartGroup, i3 & 112, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function8 = function11118;
                function7 = function11;
                modifier3 = modifier4;
            }
            function9 = function6;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidViewBindingKt.AndroidViewBinding$lambda$9(function3, modifier3, function7, function8, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                function5 = function2;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    function6 = function4;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function7 = function1;
                    modifier3 = modifier2;
                    function8 = function5;
                } else {
                    if (i10 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    function10 = null;
                    if (i4 != 0) {
                        function11 = null;
                    } else {
                        function11 = function1;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379288382, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$2$0((ViewBinding) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        function12 = (Function1) objRememberedValue7;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function12 = function5;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379287390, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$3$0((ViewBinding) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function6 = (Function1) objRememberedValue6;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(509101952, i3, -1, "androidx.compose.ui.viewinterop.AndroidViewBinding (AndroidViewBinding.kt:148)");
                    }
                    ProvidableCompositionLocal<View> localView13 = AndroidCompositionLocals_androidKt.getLocalView();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume115 = composerStartRestartGroup.consume(localView13);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    view = (View) objConsume115;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379277122, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(view);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = ViewKt.findFragment(view);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = ViewKt.findFragment(view);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    fragment = (Fragment) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Context> localContext13 = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume116 = composerStartRestartGroup.consume(localContext13);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    context = (Context) objConsume116;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379266273, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    boolean zChangedInstance14 = composerStartRestartGroup.changedInstance(fragment);
                    if ((i3 & 14) == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z2 | zChangedInstance14;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function11119 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (function11 == null) {
                        composerStartRestartGroup.startReplaceGroup(1128074793);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*173@10075L40");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1209739933, "CC(remember):AndroidViewBinding.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(function11);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function10 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1128074792);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379248954, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    zChangedInstance = z4 | composerStartRestartGroup.changedInstance(fragment) | composerStartRestartGroup.changedInstance(context);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function111110 = (Function1) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379215383, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    if ((57344 & i3) == 16384) {
                    }
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Function1<? super T, Unit> function111111 = function12;
                    AndroidView_androidKt.AndroidView(function11119, modifier4, function10, function111110, (Function1) objRememberedValue5, composerStartRestartGroup, i3 & 112, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function8 = function111111;
                    function7 = function11;
                    modifier3 = modifier4;
                }
                function9 = function6;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$9(function3, modifier3, function7, function8, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function6 = function4;
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                function7 = function1;
                modifier3 = modifier2;
                function8 = function5;
            } else {
                if (i10 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                function10 = null;
                if (i4 != 0) {
                    function11 = null;
                } else {
                    function11 = function1;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379288382, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$2$0((ViewBinding) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    function12 = (Function1) objRememberedValue7;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function12 = function5;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379287390, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$3$0((ViewBinding) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function6 = (Function1) objRememberedValue6;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(509101952, i3, -1, "androidx.compose.ui.viewinterop.AndroidViewBinding (AndroidViewBinding.kt:148)");
                }
                ProvidableCompositionLocal<View> localView14 = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume117 = composerStartRestartGroup.consume(localView14);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                view = (View) objConsume117;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379277122, "CC(remember):AndroidViewBinding.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(view);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = ViewKt.findFragment(view);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = ViewKt.findFragment(view);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                fragment = (Fragment) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Context> localContext14 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume118 = composerStartRestartGroup.consume(localContext14);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume118;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379266273, "CC(remember):AndroidViewBinding.kt#9igjgp");
                boolean zChangedInstance15 = composerStartRestartGroup.changedInstance(fragment);
                if ((i3 & 14) == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = z2 | zChangedInstance15;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function1 function111112 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (function11 == null) {
                    composerStartRestartGroup.startReplaceGroup(1128074793);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*173@10075L40");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1209739933, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(function11);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    function10 = (Function1) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1128074792);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379248954, "CC(remember):AndroidViewBinding.kt#9igjgp");
                if ((i3 & 7168) == 2048) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                zChangedInstance = z4 | composerStartRestartGroup.changedInstance(fragment) | composerStartRestartGroup.changedInstance(context);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                Function1 function111113 = (Function1) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379215383, "CC(remember):AndroidViewBinding.kt#9igjgp");
                if ((57344 & i3) == 16384) {
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Function1<? super T, Unit> function111114 = function12;
                AndroidView_androidKt.AndroidView(function111112, modifier4, function10, function111113, (Function1) objRememberedValue5, composerStartRestartGroup, i3 & 112, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function8 = function111114;
                function7 = function11;
                modifier3 = modifier4;
            }
            function9 = function6;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidViewBindingKt.AndroidViewBinding$lambda$9(function3, modifier3, function7, function8, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        function5 = function2;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((i & 24576) == 0) {
                function6 = function4;
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                function7 = function1;
                modifier3 = modifier2;
                function8 = function5;
            } else {
                if (i10 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                function10 = null;
                if (i4 != 0) {
                    function11 = null;
                } else {
                    function11 = function1;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379288382, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$2$0((ViewBinding) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    function12 = (Function1) objRememberedValue7;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function12 = function5;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379287390, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$3$0((ViewBinding) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function6 = (Function1) objRememberedValue6;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(509101952, i3, -1, "androidx.compose.ui.viewinterop.AndroidViewBinding (AndroidViewBinding.kt:148)");
                }
                ProvidableCompositionLocal<View> localView15 = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume119 = composerStartRestartGroup.consume(localView15);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                view = (View) objConsume119;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379277122, "CC(remember):AndroidViewBinding.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(view);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = ViewKt.findFragment(view);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = ViewKt.findFragment(view);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                fragment = (Fragment) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Context> localContext15 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume1110 = composerStartRestartGroup.consume(localContext15);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume1110;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379266273, "CC(remember):AndroidViewBinding.kt#9igjgp");
                boolean zChangedInstance16 = composerStartRestartGroup.changedInstance(fragment);
                if ((i3 & 14) == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = z2 | zChangedInstance16;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function1 function111115 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (function11 == null) {
                    composerStartRestartGroup.startReplaceGroup(1128074793);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*173@10075L40");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1209739933, "CC(remember):AndroidViewBinding.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(function11);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    function10 = (Function1) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1128074792);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379248954, "CC(remember):AndroidViewBinding.kt#9igjgp");
                if ((i3 & 7168) == 2048) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                zChangedInstance = z4 | composerStartRestartGroup.changedInstance(fragment) | composerStartRestartGroup.changedInstance(context);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                Function1 function111116 = (Function1) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379215383, "CC(remember):AndroidViewBinding.kt#9igjgp");
                if ((57344 & i3) == 16384) {
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Function1<? super T, Unit> function111117 = function12;
                AndroidView_androidKt.AndroidView(function111115, modifier4, function10, function111116, (Function1) objRememberedValue5, composerStartRestartGroup, i3 & 112, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function8 = function111117;
                function7 = function11;
                modifier3 = modifier4;
            }
            function9 = function6;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidViewBindingKt.AndroidViewBinding$lambda$9(function3, modifier3, function7, function8, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function6 = function4;
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            function7 = function1;
            modifier3 = modifier2;
            function8 = function5;
        } else {
            if (i10 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            function10 = null;
            if (i4 != 0) {
                function11 = null;
            } else {
                function11 = function1;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379288382, "CC(remember):AndroidViewBinding.kt#9igjgp");
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$2$0((ViewBinding) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                function12 = (Function1) objRememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                function12 = function5;
            }
            if (i8 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379287390, "CC(remember):AndroidViewBinding.kt#9igjgp");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$3$0((ViewBinding) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function6 = (Function1) objRememberedValue6;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(509101952, i3, -1, "androidx.compose.ui.viewinterop.AndroidViewBinding (AndroidViewBinding.kt:148)");
            }
            ProvidableCompositionLocal<View> localView16 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume1111 = composerStartRestartGroup.consume(localView16);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            view = (View) objConsume1111;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379277122, "CC(remember):AndroidViewBinding.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(view);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = ViewKt.findFragment(view);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = ViewKt.findFragment(view);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            fragment = (Fragment) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<Context> localContext16 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume1112 = composerStartRestartGroup.consume(localContext16);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            context = (Context) objConsume1112;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379266273, "CC(remember):AndroidViewBinding.kt#9igjgp");
            boolean zChangedInstance17 = composerStartRestartGroup.changedInstance(fragment);
            if ((i3 & 14) == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = z2 | zChangedInstance17;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z3) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AndroidViewBindingKt.AndroidViewBinding$lambda$5$0(fragment, function3, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function111118 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (function11 == null) {
                composerStartRestartGroup.startReplaceGroup(1128074793);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*173@10075L40");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1209739933, "CC(remember):AndroidViewBinding.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(function11);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidViewBindingKt.AndroidViewBinding$lambda$6$0$0(function11, (View) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                function10 = (Function1) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                composerStartRestartGroup.startReplaceGroup(1128074792);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379248954, "CC(remember):AndroidViewBinding.kt#9igjgp");
            if ((i3 & 7168) == 2048) {
                z4 = true;
            } else {
                z4 = false;
            }
            zChangedInstance = z4 | composerStartRestartGroup.changedInstance(fragment) | composerStartRestartGroup.changedInstance(context);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0(function12, fragment, context, (View) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function1 function111119 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -379215383, "CC(remember):AndroidViewBinding.kt#9igjgp");
            if ((57344 & i3) == 16384) {
            }
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (!z5) {
                objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AndroidViewBindingKt.AndroidViewBinding$lambda$8$0(function6, (View) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Function1<? super T, Unit> function1111110 = function12;
            AndroidView_androidKt.AndroidView(function111118, modifier4, function10, function111119, (Function1) objRememberedValue5, composerStartRestartGroup, i3 & 112, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function8 = function1111110;
            function7 = function11;
            modifier3 = modifier4;
        }
        function9 = function6;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AndroidViewBindingKt.AndroidViewBinding$lambda$9(function3, modifier3, function7, function8, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View AndroidViewBinding$lambda$5$0(Fragment fragment, Function3 function3, Context context) {
        LayoutInflater layoutInflaterFrom;
        if (fragment == null || (layoutInflaterFrom = fragment.getLayoutInflater()) == null) {
            layoutInflaterFrom = LayoutInflater.from(context);
        }
        ViewBinding viewBinding = (ViewBinding) function3.invoke(layoutInflaterFrom, new FrameLayout(context), false);
        View root = viewBinding.getRoot();
        setBinding(root, viewBinding);
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidViewBinding$lambda$6$0$0(Function1 function1, View view) {
        function1.invoke(getBinding(view));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidViewBinding$lambda$7$0(Function1 function1, Fragment fragment, Context context, View view) {
        FragmentManager childFragmentManager;
        function1.invoke(getBinding(view));
        final FragmentManager supportFragmentManager = null;
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup != null) {
            if (fragment == null || (childFragmentManager = fragment.getChildFragmentManager()) == null) {
                FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
                if (fragmentActivity != null) {
                    supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                }
            } else {
                supportFragmentManager = childFragmentManager;
            }
            forEachFragmentContainerView(viewGroup, new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AndroidViewBindingKt.AndroidViewBinding$lambda$7$0$0$0(supportFragmentManager, (FragmentContainerView) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidViewBinding$lambda$7$0$0$0(FragmentManager fragmentManager, FragmentContainerView fragmentContainerView) {
        Fragment fragmentFindFragmentById = fragmentManager != null ? fragmentManager.findFragmentById(fragmentContainerView.getId()) : null;
        if (fragmentFindFragmentById != null && !fragmentManager.isStateSaved()) {
            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction()");
            fragmentTransactionBeginTransaction.remove(fragmentFindFragmentById);
            fragmentTransactionBeginTransaction.commitNow();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidViewBinding$lambda$8$0(Function1 function1, View view) {
        function1.invoke(getBinding(view));
        return Unit.INSTANCE;
    }

    private static final <T extends ViewBinding> void setBinding(View view, T t) {
        view.setTag(R.id.binding_reference, t);
    }

    private static final <T extends ViewBinding> T getBinding(View view) {
        Object tag = view.getTag(R.id.binding_reference);
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type T of androidx.compose.ui.viewinterop.AndroidViewBindingKt.getBinding");
        return (T) tag;
    }

    private static final void forEachFragmentContainerView(ViewGroup viewGroup, Function1<? super FragmentContainerView, Unit> function1) {
        if (viewGroup instanceof FragmentContainerView) {
            function1.invoke(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(index)");
            if (childAt instanceof ViewGroup) {
                forEachFragmentContainerView((ViewGroup) childAt, function1);
            }
        }
    }
}
