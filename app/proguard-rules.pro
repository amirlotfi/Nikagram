-keep public class com.google.android.gms.* { public *; }
-keepnames @com.google.android.gms.common.annotation.KeepName class *
-keepclassmembernames class * {
    @com.google.android.gms.common.annotation.KeepName *;
}
-dontwarn com.google.android.gms.**
-dontwarn com.google.common.cache.**
-dontwarn com.google.common.primitives.**

#Ronash proguard
-keep public class co.ronash.pushe.Pushe {
public static void initialize(android.content.Context, boolean);
public static void subscribe(android.content.Context, java.lang.String);
public static void unsubscribe(android.content.Context, java.lang.String);
public static void setNotificationOff(android.content.Context);
public static void setNotificationOn(android.content.Context);
public static boolean isPusheInitialized(android.content.Context);
}

-keep public class co.ronash.pushe.PusheListenerService {
public void onMessageReceived(org.json.JSONObject, org.json.JSONObject);
}

-keep public class co.ronash.pushe.receiver.UpdateReceiver

-dontwarn com.evernote.android.job.gcm.**
-dontwarn com.evernote.android.job.v24.**
-dontwarn com.evernote.android.job.util.GcmAvailableHelper

-keep public class com.evernote.android.job.v21.PlatformJobService
-keep public class com.evernote.android.job.v14.PlatformAlarmService
-keep public class com.evernote.android.job.v14.PlatformAlarmReceiver
-keep public class com.evernote.android.job.JobBootReceive


# google gms proguard
-keep public class com.google.android.gms.**
-dontwarn com.google.android.gms.**

# google paly services proguard
-keep class * extends java.util.ListResourceBundle {
protected Object[][] getContents();
}

-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
public static final *** NULL;
}

-keepnames @com.google.android.gms.common.annotation.KeepName class *
-keepclassmembernames class * {
@com.google.android.gms.common.annotation.KeepName *;
}

-keepnames class * implements android.os.Parcelable {
public static final ** CREATOR;}

-keep public class co.ronash.pushe.log.handlers.** { *; }
-keep class org.json.** { *; }
-keep interface org.json.** { *; }

-keep class **.R
-keep class **.R$* {
<fields>;
}

-dontwarn com.evernote.android.job.gcm.**
-dontwarn com.evernote.android.job.util.GcmAvailableHelper

-keep public class com.evernote.android.job.v21.PlatformJobService
-keep public class com.evernote.android.job.v14.PlatformAlarmService
-keep public class com.evernote.android.job.v14.PlatformAlarmReceiver
-keep public class com.evernote.android.job.JobBootReceiver

-dontwarn com.evernote.android.job.v24.**
-dontwarn com.evernote.android.job.v14.JobProxy14
-dontwarn com.evernote.android.job.util.Device