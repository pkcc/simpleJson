package Bean;

import java.util.List;

public class Book {
    private String name;
    private Double price;
    private Boolean onSale;
    private List<Comment> comments;

    public Book() {
    }

    public Book(String name, Double price, Boolean onSale, List<Comment> comments) {
        this.name = name;
        this.price = price;
        this.onSale = onSale;
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", onSale=" + onSale +
                ", comments=" + comments +
                '}';
    }
}
