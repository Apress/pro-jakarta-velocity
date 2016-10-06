/*
 * Created on Apr 2, 2004
 */
package com.apress.pjv.ch6.spring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.RequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.apress.pjv.ch6.Cart;
import com.apress.pjv.ch6.Category;
import com.apress.pjv.ch6.Product;
import com.apress.pjv.ch6.StoreManager;

/**
 * @author robh
 *  
 */
public class StoreActionController extends MultiActionController {

    private StoreManager storeManager = null;

    public void setStoreManager(StoreManager storeManager) {
        this.storeManager = storeManager;
    }

    private Map getModel() {
        Map model = new HashMap();
        return model;
    }

    public ModelAndView handleProductList(HttpServletRequest request,
            HttpServletResponse response) throws ServletException {

        Category c = null;
        int id = RequestUtils.getIntParameter(request, "category", -1);

        if (id >= 0) c = Category.fromInt(id);

        List products = storeManager.getProductList(c);

        Map model = getModel();
        model.put("categories", Category.ALL_CATEGORIES);
        model.put("products", products);

        return new ModelAndView("productList.vm", model);
    }

    public ModelAndView handleAddToCart(HttpServletRequest request,
            HttpServletResponse response) throws ServletException {

        Product p = null;

        int id = RequestUtils.getIntParameter(request, "pID", -1);

        if (id >= 0) p = storeManager.getProduct(id);

        Cart cart = Cart.fromSession(request.getSession());
        cart.addItem(p, 1);
        Cart.storeInSession(request.getSession(), cart);

        return handleShowCart(request, response);
    }

    public ModelAndView handleRemoveFromCart(HttpServletRequest request,
            HttpServletResponse response) throws ServletException {
        int id = RequestUtils.getIntParameter(request, "pID", -1);

        Cart cart = Cart.fromSession(request.getSession());
        cart.removeItem(id);
        Cart.storeInSession(request.getSession(), cart);

        return handleShowCart(request, response);
    }

    public ModelAndView handleProductDetail(HttpServletRequest request,
            HttpServletResponse response) throws ServletException {
        return handleProductDetailInternal(request, response,
                "productDetail.vm");
    }

    public ModelAndView handlePrintFriendlyProductDetail(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        return handleProductDetailInternal(request, response,
                "pfProductDetail.vm");
    }

    private ModelAndView handleProductDetailInternal(
            HttpServletRequest request, HttpServletResponse response,
            String viewName) throws ServletException {

        int id = RequestUtils.getIntParameter(request, "pID", -1);

        Product p = null;

        if (id >= 0) p = storeManager.getProduct(id);

        return new ModelAndView(viewName, "product", p);
    }

    public ModelAndView handleShowCart(HttpServletRequest request,
            HttpServletResponse response) throws ServletException {
        Cart cart = Cart.fromSession(request.getSession());

        Map model = getModel();
        model.put("cart", cart);

        return new ModelAndView("cart.vm", model);
    }
}