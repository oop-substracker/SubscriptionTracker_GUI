package model.DefaultEntries;

import javax.swing.ImageIcon;

public class Entry {
    private String platform;
    private ImageIcon image;

    public Entry(String platform, ImageIcon image) {
        this.platform = platform;
        this.image = image;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
}
