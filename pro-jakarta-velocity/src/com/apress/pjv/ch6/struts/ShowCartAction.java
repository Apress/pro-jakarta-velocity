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
public class ShowCartAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        Cart cart = Cart.fromSession(request.getSession());
        request.setAttribute("cart", cart);

        return mapping.findForward("success");
    }
}