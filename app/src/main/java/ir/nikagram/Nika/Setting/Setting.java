package ir.nikagram.Nika.Setting;

/**
 * Created by Pouya on 12/20/2015.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import ir.nikagram.messenger.ApplicationLoader;
import ir.nikagram.messenger.LocaleController;
import ir.nikagram.messenger.R;

public class Setting {
    static SharedPreferences pref;
    static Editor editor;
    static Context _context;
    static int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "Stors";

    private static void setupSetting() {
        if (pref == null) {
            _context = ApplicationLoader.applicationContext;
            pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
            editor = pref.edit();
        }
    }

    public static void setTabletMode(Boolean on) {
        setupSetting();
        editor.putBoolean("tabletmode", on);
        editor.commit();
    }

    public static boolean getTabletMode() {
        setupSetting();
        return pref.getBoolean("tabletmode", false);
    }

    public static void setGhostMode(Boolean on) {
        setupSetting();
        editor.putBoolean("ghostmode", on);
        editor.commit();
    }

    public static boolean getGhostMode() {
        setupSetting();
        return pref.getBoolean("ghostmode", false);
    }

    public static void setAnsweringmachineText(String answer) {
        setupSetting();
        editor.putString("answeringmachineanswer", answer);
        editor.commit();
    }

    public static String getAnsweringmachineText() {
        setupSetting();
        return pref.getString("answeringmachineanswer", LocaleController.getString("AnsweringmachineDefaulttext", R.string.AnsweringmachineDefaulttext));
    }

    public static void setTheme(int id) {
        setupSetting();
        editor.putInt("themeid", id);
        editor.commit();
    }

    public static int getTheme() {
        setupSetting();
        return pref.getInt("themeid", 19);
    }

    public static void setSendTyping(Boolean on) {
        setupSetting();
        editor.putBoolean("sendtype", on);
        editor.commit();
    }

    public static String getFavorList() {
        setupSetting();
        return pref.getString("favors", "");
    }

    public static void setFavorList(String list) {
        setupSetting();
        editor.putString("favors", list);
        editor.commit();
    }

    public static String getHiddenList() {
        setupSetting();
        return pref.getString("hidden", "");
    }

    public static void setHiddenList(String list) {
        setupSetting();
        editor.putString("hidden", list);
        editor.commit();
    }

    public static boolean getSendTyping() {
        setupSetting();
        return pref.getBoolean("sendtype", false);
    }

    public static void setAnsweringMachine(Boolean on) {
        setupSetting();
        editor.putBoolean("answeringmachine", on);
        editor.commit();
    }

    public static boolean getAnsweringMachine() {
        setupSetting();
        return pref.getBoolean("answeringmachine", false);
    }

    public static boolean getShowTimeAgo() {
        setupSetting();
        return pref.getBoolean("showtimeago", true);
    }

    public static void setShowTimeAgo(Boolean on) {
        setupSetting();
        editor.putBoolean("showtimeago", on);
        editor.commit();
    }

    public static void setDatePersian(Boolean on) {
        setupSetting();
        editor.putBoolean("dateispersian", on);
        editor.commit();
    }

    public static boolean getDatePersian() {
        setupSetting();
        return pref.getBoolean("dateispersian", true);
    }

    public static void setisfirsttime(Boolean on) {
        setupSetting();
        editor.putBoolean("isfirsttime", on);
        editor.commit();
    }

    public static boolean isfirsttime() {
        setupSetting();
        return pref.getBoolean("isfirsttime", true);
    }
}
