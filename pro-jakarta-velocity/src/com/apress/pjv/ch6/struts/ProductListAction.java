/*
 * Created on Apr 2, 2004
 */
package com.apress.pjv.ch6.struts;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.apress.pjv.ch6.Category;
import com.apress.pjv.ch6.StoreManager;
import com.apress.pjv.ch6.StoreManagerFactory;

/**
 * @author robh
 *  
 */
public class ProductListAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        Category c = null;
        if (request.getParameter("category") != null) {
            int id = Integer.parseInt(request.getParameter("category"));

            if (id >= 0) c = Category.fromInt(id);
        }

        StoreManager mgr = StoreManagerFactory.getInstance().getStoreManager();
        List products = mgr.getProductList(c);

        request.setAttribute("categories", Category.ALL_CATEGORIES);
        request.setAttribute("products", products);

        return mapping.findForward("success");
    }
}