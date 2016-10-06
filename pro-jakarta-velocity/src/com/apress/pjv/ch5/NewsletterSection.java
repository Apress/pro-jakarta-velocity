/*
 * Created on Mar 25, 2004
 */
package com.apress.pjv.ch5;


/**
 * @author robh
 */
public class NewsletterSection {

    private Category category = null;
    private String content = null;
    
    public NewsletterSection(Category category, String content) {
        this.category = category;
        this.content = content;
    }
    
    
    /**
     * @return Returns the category.
     */
    public Category getCategory() {
        return category;
    }
    /**
     * @param category The category to set.
     */
    public void setCategory(Category category) {
        this.category = category;
    }
    /**
     * @return Returns the content.
     */
    public String getContent() {
        return content;
    }
    /**
     * @param content The content to set.
     */
    public void setContent(String content) {
        this.content = content;
    }
}
