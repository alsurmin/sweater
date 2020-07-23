package com.example.domain.dto;

import com.example.domain.Message;
import com.example.domain.User;
import com.example.domain.util.MessageHelper;

public class MessageDto {
    private Long id;
    private String text;
    private String tag;
    private User author;
    private String filename;
    private Long likes;
    private boolean meLiked;

    public MessageDto(Message message, Long likes, boolean meLiked) {
        this.likes = likes;
        this.meLiked = meLiked;
        this.author = message.getAuthor();
        this.filename = message.getFilename();
        this.tag = message.getTag();
        this.text = message.getText();
        this.id = message.getId();
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "id=" + id +
                ", author=" + author +
                ", likes=" + likes +
                ", meLiked=" + meLiked +
                '}';
    }

    public String getAuthorName() {
        return MessageHelper.getAuthorName(author);
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getTag() {
        return tag;
    }

    public User getAuthor() {
        return author;
    }

    public String getFilename() {
        return filename;
    }

    public Long getLikes() {
        return likes;
    }

    public boolean isMeLiked() {
        return meLiked;
    }
}
