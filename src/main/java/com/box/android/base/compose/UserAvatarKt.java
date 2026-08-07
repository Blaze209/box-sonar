package com.box.android.base.compose;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.box.androidsdk.content.auth.OAuthActivity;
import com.box.androidsdk.content.views.BoxAvatarView;
import com.box.androidsdk.content.views.DefaultAvatarController;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserAvatar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"UserAvatar", "", OAuthActivity.USER_ID, "", "userName", "avatarController", "Lcom/box/androidsdk/content/views/DefaultAvatarController;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/androidsdk/content/views/DefaultAvatarController;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "userAvatarUIModel", "Lcom/box/android/base/compose/UserAvatarUIModel;", "(Lcom/box/android/base/compose/UserAvatarUIModel;Lcom/box/androidsdk/content/views/DefaultAvatarController;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UserAvatarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserAvatar$lambda$0(String str, String str2, DefaultAvatarController defaultAvatarController, Modifier modifier, int i, int i2, Composer composer, int i3) {
        UserAvatar(str, str2, defaultAvatarController, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserAvatar$lambda$3(UserAvatarUIModel userAvatarUIModel, DefaultAvatarController defaultAvatarController, Modifier modifier, int i, int i2, Composer composer, int i3) {
        UserAvatar(userAvatarUIModel, defaultAvatarController, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void UserAvatar(final String userId, final String str, DefaultAvatarController avatarController, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        DefaultAvatarController defaultAvatarController;
        final Modifier modifier2;
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(avatarController, "avatarController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2142901337);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(UserAvatar)N(userId,userName,avatarController,modifier)20@627L105:UserAvatar.kt#vejmn0");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(userId) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(avatarController) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            defaultAvatarController = avatarController;
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier3 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2142901337, i3, -1, "com.box.android.base.compose.UserAvatar (UserAvatar.kt:19)");
            }
            defaultAvatarController = avatarController;
            UserAvatar(new UserAvatarUIModel(userId, str), defaultAvatarController, modifier3, composerStartRestartGroup, (i3 >> 3) & 1008, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final DefaultAvatarController defaultAvatarController2 = defaultAvatarController;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.UserAvatarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return UserAvatarKt.UserAvatar$lambda$0(userId, str, defaultAvatarController2, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void UserAvatar(final UserAvatarUIModel userAvatarUIModel, final DefaultAvatarController avatarController, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(userAvatarUIModel, "userAvatarUIModel");
        Intrinsics.checkNotNullParameter(avatarController, "avatarController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1161156692);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(UserAvatar)N(userAvatarUIModel,avatarController,modifier)30@912L280,39@1274L98,29@881L491:UserAvatar.kt#vejmn0");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(userAvatarUIModel) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(avatarController) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1161156692, i3, -1, "com.box.android.base.compose.UserAvatar (UserAvatar.kt:28)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 819921476, "CC(remember):UserAvatar.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.compose.UserAvatarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return UserAvatarKt.UserAvatar$lambda$1$0((Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierTestTag = TestTagKt.testTag(modifier, "activityItemUserImage");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 819932878, "CC(remember):UserAvatar.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(userAvatarUIModel) | composerStartRestartGroup.changedInstance(avatarController);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.UserAvatarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return UserAvatarKt.UserAvatar$lambda$2$0(userAvatarUIModel, avatarController, (BoxAvatarView) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidView_androidKt.AndroidView(function1, modifierTestTag, (Function1) objRememberedValue2, composerStartRestartGroup, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.UserAvatarKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return UserAvatarKt.UserAvatar$lambda$3(userAvatarUIModel, avatarController, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoxAvatarView UserAvatar$lambda$1$0(Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BoxAvatarView boxAvatarView = new BoxAvatarView(it);
        boxAvatarView.setImportantForAccessibility(4);
        return boxAvatarView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserAvatar$lambda$2$0(UserAvatarUIModel userAvatarUIModel, DefaultAvatarController defaultAvatarController, BoxAvatarView it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.loadUser(userAvatarUIModel, defaultAvatarController);
        return Unit.INSTANCE;
    }
}
