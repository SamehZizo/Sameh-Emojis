package hani.momanii.supernova_emoji_library.Models;

public class Emoji {

    private int drawable;
    private int code;

    public Emoji(int drawable, int code) {
        this.drawable = drawable;
        this.code = code;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
