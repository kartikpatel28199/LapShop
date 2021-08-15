package net.in.lapshop.lapshop.notification;

/**
 * Created by Nikunj Ramani on 04/08/18.
 */

public class showNotification {
    int id;
    String email,title,message,image;

    public showNotification(int id, String title, String message,String image) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.image=image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
