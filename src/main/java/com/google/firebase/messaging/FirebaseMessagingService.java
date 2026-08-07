package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.zzad;
import com.google.firebase.iid.zzaz;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@20.1.1 */
/* JADX INFO: loaded from: classes14.dex */
public class FirebaseMessagingService extends zzc {
    private static final Queue<String> zza = new ArrayDeque(10);

    public void onDeletedMessages() {
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    public void onMessageSent(String str) {
    }

    public void onNewToken(String str) {
    }

    public void onSendError(String str, Exception exc) {
    }

    @Override // com.google.firebase.messaging.zzc
    protected final Intent zza(Intent intent) {
        return zzaz.zza().zzb();
    }

    @Override // com.google.firebase.messaging.zzc
    public final boolean zzb(Intent intent) {
        if (!"com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            return false;
        }
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("FirebaseMessaging", "Notification pending intent canceled");
            }
        }
        if (!zzo.zzd(intent)) {
            return true;
        }
        zzo.zza(intent);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:110:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:112:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:52:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:53:0x00de  */
    /* JADX WARN: Code duplicated, block: B:56:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:65:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:67:0x0109  */
    /* JADX WARN: Code duplicated, block: B:68:0x010e  */
    /* JADX WARN: Code duplicated, block: B:70:0x0118  */
    /* JADX WARN: Code duplicated, block: B:71:0x0121  */
    /* JADX WARN: Code duplicated, block: B:73:0x0127  */
    /* JADX WARN: Code duplicated, block: B:75:0x013d  */
    /* JADX WARN: Code duplicated, block: B:77:0x0143  */
    /* JADX WARN: Code duplicated, block: B:80:0x014c  */
    /* JADX WARN: Code duplicated, block: B:82:0x0150  */
    /* JADX WARN: Code duplicated, block: B:83:0x0164  */
    /* JADX WARN: Code duplicated, block: B:86:0x016f  */
    /* JADX WARN: Code duplicated, block: B:89:0x017f  */
    /* JADX WARN: Code duplicated, block: B:92:0x0193  */
    /* JADX WARN: Code duplicated, block: B:93:0x0197  */
    /* JADX WARN: Code duplicated, block: B:95:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:99:0x01a9  */
    @Override // com.google.firebase.messaging.zzc
    public final void zzc(Intent intent) {
        Task<Void> taskZza;
        String stringExtra;
        Bundle extras;
        zzn zznVar;
        ExecutorService executorServiceNewSingleThreadExecutor;
        TransportFactory transportFactory;
        String stringExtra2;
        String strValueOf;
        String str;
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.RECEIVE".equals(action) || "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(action)) {
            String stringExtra3 = intent.getStringExtra("google.message_id");
            if (TextUtils.isEmpty(stringExtra3)) {
                taskZza = Tasks.forResult(null);
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("google.message_id", stringExtra3);
                taskZza = zzad.zza(this).zza(2, bundle);
            }
            if (!TextUtils.isEmpty(stringExtra3)) {
                Queue<String> queue = zza;
                if (queue.contains(stringExtra3)) {
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                        String strValueOf2 = String.valueOf(stringExtra3);
                        Log.d("FirebaseMessaging", strValueOf2.length() != 0 ? "Received duplicate message: ".concat(strValueOf2) : new String("Received duplicate message: "));
                    }
                } else {
                    if (queue.size() >= 10) {
                        queue.remove();
                    }
                    queue.add(stringExtra3);
                    stringExtra = intent.getStringExtra("message_type");
                    if (stringExtra == null) {
                        stringExtra = "gcm";
                    }
                    stringExtra.hashCode();
                    switch (stringExtra) {
                        case "deleted_messages":
                            onDeletedMessages();
                            break;
                        case "gcm":
                            if (zzo.zzd(intent)) {
                                zzo.zza(intent, (Transport<String>) null);
                            }
                            if (zzo.zze(intent)) {
                                transportFactory = FirebaseMessaging.zza;
                                if (transportFactory != null) {
                                    zzo.zza(intent, (Transport<String>) transportFactory.getTransport("FCM_CLIENT_EVENT_LOGGING", String.class, Encoding.of("json"), zzk.zza));
                                } else {
                                    Log.e("FirebaseMessaging", "TransportFactory is null. Skip exporting message delivery metrics to Big Query");
                                }
                            }
                            extras = intent.getExtras();
                            if (extras == null) {
                                extras = new Bundle();
                            }
                            extras.remove("androidx.contentpager.content.wakelockid");
                            if (zzn.zza(extras)) {
                                zznVar = new zzn(extras);
                                executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                                if (new zzd(this, zznVar, executorServiceNewSingleThreadExecutor).zza()) {
                                    executorServiceNewSingleThreadExecutor.shutdown();
                                } else {
                                    executorServiceNewSingleThreadExecutor.shutdown();
                                    if (zzo.zzd(intent)) {
                                        zzo.zzc(intent);
                                    }
                                    onMessageReceived(new RemoteMessage(extras));
                                }
                                break;
                            } else {
                                onMessageReceived(new RemoteMessage(extras));
                                break;
                            }
                            break;
                        case "send_error":
                            stringExtra2 = intent.getStringExtra("google.message_id");
                            if (stringExtra2 == null) {
                                stringExtra2 = intent.getStringExtra("message_id");
                            }
                            onSendError(stringExtra2, new SendException(intent.getStringExtra("error")));
                            break;
                        case "send_event":
                            onMessageSent(intent.getStringExtra("google.message_id"));
                            break;
                        default:
                            strValueOf = String.valueOf(stringExtra);
                            if (strValueOf.length() != 0) {
                                str = "Received message with unknown type: ".concat(strValueOf);
                            } else {
                                str = new String("Received message with unknown type: ");
                            }
                            Log.w("FirebaseMessaging", str);
                            break;
                    }
                }
            } else {
                stringExtra = intent.getStringExtra("message_type");
                if (stringExtra == null) {
                    stringExtra = "gcm";
                }
                stringExtra.hashCode();
                switch (stringExtra) {
                    case -2062414158:
                        if (stringExtra.equals("deleted_messages")) {
                        }
                        break;
                    case 102161:
                        if (stringExtra.equals("gcm")) {
                        }
                        break;
                    case 814694033:
                        if (!stringExtra.equals("send_error")) {
                        }
                        break;
                    case 814800675:
                        if (stringExtra.equals("send_event")) {
                        }
                        break;
                    default:
                        break;
                }
                /*  JADX ERROR: Method code generation error
                    java.lang.NullPointerException: Switch insn not found in header
                    	at java.base/java.util.Objects.requireNonNull(Objects.java:246)
                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
                    	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                    	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                    	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                    	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                    */
                /*
                    Method dump skipped, instruction units count: 520
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.zzc(android.content.Intent):void");
            }
        }
