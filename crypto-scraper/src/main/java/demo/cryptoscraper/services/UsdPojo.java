package demo.cryptoscraper.services;

import org.springframework.stereotype.Service;

@Service
public class UsdPojo {
    private int price;
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "UsdPojo{" +
                "price=" + price +
                '}';
    }


}
