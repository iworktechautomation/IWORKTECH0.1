package com.iworktech.test.Framework.Screenshot;


import java.util.HashMap;
import java.util.Map;

class ScreenshotHelper {


    private static final ThreadLocal<Map<String, Object>> SCREEN_SHOTS = new ThreadLocal<Map<String, Object>>() {
        @Override
        protected Map<String, Object> initialValue() {
            System.out.println("ScreenshotHookHELPER YASH");
            return new HashMap<>();
        }
    };

    public static void add(String name, byte[] image) {
        SCREEN_SHOTS.get().put(name, image.clone());
    }

    public static Map<String, Object> getScreenShotsForCurrentTest() {
        System.out.println("ScreenshotHook HELPER ADDED YASH");
        return SCREEN_SHOTS.get();
    }

    public static void tidyUpAfterTestRun() {
        SCREEN_SHOTS.remove();
    }


}
