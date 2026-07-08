package utils;

import com.microsoft.playwright.Page;

public class DriverManager {

    private static ThreadLocal<Page> page = new ThreadLocal<>();

    public static void setPage(Page pageRef) {
        page.set(pageRef);
    }

    public static Page getPage() {
        return page.get();
    }

    public static void unload() {
        page.remove();
    }
}