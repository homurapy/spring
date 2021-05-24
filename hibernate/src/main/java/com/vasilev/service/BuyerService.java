package com.vasilev.service;

import com.vasilev.dao.BuyerDao;
import com.vasilev.dao.BuyerDao;
import com.vasilev.model.Buyer;
import com.vasilev.model.Product;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class BuyerService {

    private BuyerDao buyerDao = new BuyerDao();

    public void save(Buyer buyer) {
        buyerDao.save(buyer);
    }

    public List<Buyer> findAll() {
        return buyerDao.findAll();
    }

    public void deleteById(Long id) {
        buyerDao.delete(buyerDao.findById(id));
    }
    public List<Product> getProductBuyer(Long id){
        Buyer buyer = buyerDao.findById(id);
        return buyer.getProducts();
    }
}
