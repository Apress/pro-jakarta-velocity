/*
 * Created on Mar 25, 2004
 */
package com.apress.pjv.ch5;

/**
 * @author robh
 */
public class Category {

    public static final Category JAVA = new Category("Java",
            "http://www.apress.com/category.html?nID=32");

    public static final Category OPEN_SOURCE = new Category("Open Source",
            "http://www.apress.com/category.html?nID=28");

    public static final Category DATABASE_SQL = new Category("Database/SQL",
            "http://www.apress.com/category.html?nID=42");

    public static final Category LEGO_MINDSTORMS = new Category(
            "Lego Mindstorms", "http://www.apress.com/category.html?nID=46");

    private String name = null;

    private String webLink = null;

    private Category(String name, String webLink) {
        this.name = name;
        this.webLink = webLink;
    }
    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }
    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return Returns the webLink.
     */
    public String getWebLink() {
        return webLink;
    }
    /**
     * @param webLink The webLink to set.
     */
    public void setWebLink(String webLink) {
        this.webLink = webLink;
    }
    
    public String toString() {
        return name;
    }
    
    public static Category[] getAllCategories() {
        return new Category[]{Category.DATABASE_SQL, Category.JAVA, Category.LEGO_MINDSTORMS, Category.OPEN_SOURCE};
    }
}
