package vttp5.paf.day21ws.model;

import java.util.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Book {
    private String title;
    private String asin;
    private String author;
    private String soldBy;
    private String img;
    private String url;
    private Float stars;
    private Integer reviews;
    private Float price;
    private Date publishedDate;
    private String catName;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAsin() {
        return asin;
    }
    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getSoldBy() {
        return soldBy;
    }
    public void setSoldBy(String soldBy) {
        this.soldBy = soldBy;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Float getStars() {
        return stars;
    }
    public void setStars(Float stars) {
        this.stars = stars;
    }
    public Integer getReviews() {
        return reviews;
    }
    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public Date getPublishedDate() {
        return publishedDate;
    }
    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
    public String getCatName() {
        return catName;
    }
    public void setCatName(String catName) {
        this.catName = catName;
    }
    public static Book toBook(SqlRowSet rs) {
        Book b = new Book();
        b.setTitle(rs.getString("title"));
        b.setAsin(rs.getString("asin"));
        b.setAuthor(rs.getString("author"));
        b.setSoldBy(rs.getString("soldby"));
        b.setImg(rs.getString("imgurl"));
        b.setUrl(rs.getString("producturl"));
        b.setStars(rs.getFloat("stars"));
        b.setReviews(rs.getInt("reviews"));
        b.setPrice(rs.getFloat("price"));
        b.setPublishedDate(rs.getDate("publisheddate"));
        b.setCatName(rs.getString("category_name"));

        return b;
    }
}
