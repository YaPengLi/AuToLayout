package com.silent.fiveghost.tourist.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by funChen.
 */
public class Strap extends HashMap<String, Object> {
    public static Strap make() {
        return new Strap();
    }

    public String getString(String paramString) {
        String str = (String) super.get(paramString);
        if (str != null) return str;
        return "";
    }

    public boolean getBoolean(String paramString) {
        return (Boolean) super.get(paramString);
    }

    public boolean getBoolean(String paramString, boolean defaultV) {
        if (!super.containsKey(paramString))
            return defaultV;

        return (Boolean) super.get(paramString);
    }

    public int getInteger(String paramString) {
        return (Integer) super.get(paramString);
    }

    public Strap kv(String paramString, double paramDouble) {
        put(paramString, paramDouble);
        return this;
    }

    public Strap kv(String paramString, float paramFloat) {
        put(paramString, paramFloat);
        return this;
    }

    public Strap kv(String paramString, Object object) {
        put(paramString, object);
        return this;
    }

    public Strap kv(String paramString, int paramInt) {
        put(paramString, paramInt);
        return this;
    }

    public Strap kv(String paramString, long paramLong) {
        put(paramString, paramLong);
        return this;
    }

    public Strap kv(String paramString1, String paramString2) {
        put(paramString1, paramString2);
        return this;
    }

    public Strap kv(String paramString, boolean paramBoolean) {
        put(paramString, paramBoolean);
        return this;
    }

    public Strap kv(String paramString, JSONObject jsonObject) {
        put(paramString, jsonObject);
        return this;
    }

    public Strap kv(String paramString, JSONArray jsonArray) {
        put(paramString, jsonArray);
        return this;
    }

    public String toJsonString() {
        JSONObject object = new JSONObject();
        for (String key : this.keySet()) {
            try {
                object.put(key, get(key));
            } catch (Exception e) {
            }
        }
        return object.toString();
    }

    public JSONObject toJsonObject() {
        JSONObject object = new JSONObject();
        for (String key : this.keySet()) {
            try {
                object.put(key, get(key));
            } catch (Exception e) {
            }
        }
        return object;
    }
}
