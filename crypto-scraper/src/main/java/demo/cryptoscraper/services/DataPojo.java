package demo.cryptoscraper.services;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DataPojo {
    private int id;
    private String name;
    private String symbol;
    private QuotePojo quote;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public QuotePojo getQuote() {
        return quote;
    }

    public void setQuote(QuotePojo quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "DataPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", quote=" + quote.getUsd().getPrice() +
                '}';
    }




}
