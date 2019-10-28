package models;

import java.util.Objects;

public class News {

private String title;
private String newsContent;
private int id;
private String writtenBy;

    public News(String title, String newsContent, String writtenBy) {
        this.title = title;
        this.newsContent = newsContent;
        this.writtenBy = writtenBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return title.equals(news.title) &&
                newsContent.equals(news.newsContent) &&
                writtenBy.equals(news.writtenBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, newsContent, writtenBy);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWrittenBy() {
        return writtenBy;
    }

    public void setWrittenBy(String writtenBy) {
        this.writtenBy = writtenBy;
    }
}
