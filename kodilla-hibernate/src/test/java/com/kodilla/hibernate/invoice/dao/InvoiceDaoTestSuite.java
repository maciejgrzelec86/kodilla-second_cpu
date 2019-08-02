package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.transaction.Transactional;
import java.math.BigDecimal;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Invoice invoice = new Invoice("22");
        Product product1 = new Product("telephone1");
        Product product2 = new Product("telephone2");
        Product product3 = new Product("computer1");
        Item item1 = new Item(product1,new BigDecimal(2),10);
        Item item2 = new Item(product2,new BigDecimal(3),11);
        Item item3 = new Item(product3,new BigDecimal(4),12);
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();
        //Then
        Assert.assertNotEquals(0, invoiceId);
        //CleanUp
        try {
            invoiceDao.deleteById(invoiceId);
        } catch (Exception e){
            System.out.println("Exception: " + e);
        }
    }
}
