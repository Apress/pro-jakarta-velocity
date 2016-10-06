/*
 * Created on Apr 2, 2004
 */
package com.apress.pjv.ch6.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.apress.pjv.ch6.Cart;
import com.apress.pjv.ch6.Product;
import com.apress.pjv.ch6.StoreManager;
import com.apress.pjv.ch6.StoreManagerFactory;

/**
 * @author robh
 *  
 */
public class AddToCartAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        StoreManager mgr = StoreManagerFactory.getInstance().getStoreManager();

        Product p = null;
        if (request.getParameter("pID") != null) {
            int id = Integer.parseInt(request.getParameter("pID"));

            if (id >= 0) p = mgr.getProduct(id);
        }

        Cart cart = Cart.fromSession(request.getSession());
        cart.addItem(p, 1);
        Cart.storeInSession(request.getSession(), cart);

        return mapping.findForward("success");
    }
}