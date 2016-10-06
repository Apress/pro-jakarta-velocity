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

/**
 * @author robh
 *  
 */
public class RemoveFromCartAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        int id = Integer.parseInt(request.getParameter("pID"));

        Cart cart = Cart.fromSession(request.getSession());
        cart.removeItem(id);
        Cart.storeInSession(request.getSession(), cart);

        return mapping.findForward("success");
    }
}