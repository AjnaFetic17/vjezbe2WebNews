/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author koriisnik
 */
public class News {

  
    public Integer newsID;
    private String newsTitle;
    private String content;
    private String publicationDate;
    private String newsType;
    private int userID;
    private ArrayList<CommentDTO> comments;
    private User user;

    public Integer getNewsID() {
        return newsID;
    }

    public void setNewsID(Integer newsID) {
        this.newsID = newsID;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public ArrayList<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(ArrayList<CommentDTO> comments) {
        this.comments = comments;
    }

    public void addKomentar(CommentDTO k) {
        this.comments.add(k);
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public News(Integer newsID, String newsTitle, String content, String publicationDate, String newsType) {
        this.newsID = newsID;
        this.newsTitle = newsTitle;
        this.content = content;
        this.publicationDate = publicationDate;
        this.newsType = newsType;
    }

    public News(String newsTitle, String content) {
        this.newsTitle = newsTitle;
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public News() {
    }
}
