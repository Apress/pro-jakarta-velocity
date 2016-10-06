/*
 * Created on Apr 2, 2004
 */
package com.apress.pjv.ch6;

import net.sf.hibernate.PersistentEnum;

/**
 * @author robh
 *  
 */
public class Category implements PersistentEnum {

    public static final Category WIDGET = new Category(0, "Widgets");

    public static final Category WOTSIT = new Category(1, "Wotsits");

    public static final Category THINGY = new Category(2, "Thingys");

    public static final Category[] ALL_CATEGORIES = new Category[] { WIDGET,
            WOTSIT, THINGY};

    private int categoryId;

    private String name;

    private Category(int categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public int toInt() {
        return categoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public static Category fromInt(int id) {
        switch (id) {
        case 0:
            return WIDGET;
        case 1:
            return WOTSIT;
        case 2:
            return THINGY;
        default:
            throw new RuntimeException("Unknow category code");
        }
    }
}