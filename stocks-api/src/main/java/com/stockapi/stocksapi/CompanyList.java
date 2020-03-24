package com.stockapi.stocksapi;

import java.util.List;

public class CompanyList {
    private String symbols_requested;
    private String symbols_returned;
    private List<Company> data;

    public CompanyList() {
    }

    public CompanyList(String symbols_requested, String symbols_returned, List<Company> data) {
        this.data = data;
        this.symbols_requested = symbols_requested;
        this.symbols_returned = symbols_returned;
    }

    public List<Company> getCompanies() {
        return data;
    }
}