package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = true)

public class Smartphone extends Product {
    private String vendor;

    public Smartphone() {
    }

    public Smartphone(int id, String name, int price, String vendor) {
        super(id, name, price);
        this.vendor = vendor;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (getVendor() == search) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return vendor.equals(that.vendor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vendor);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "manufacturingCompany='" + vendor + '\'' +
                '}';
    }
}