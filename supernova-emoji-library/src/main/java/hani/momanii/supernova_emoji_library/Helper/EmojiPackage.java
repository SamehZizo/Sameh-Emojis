package hani.momanii.supernova_emoji_library.Helper;


import hani.momanii.supernova_emoji_library.Models.Emoji;
import hani.momanii.supernova_emoji_library.emoji.Emojicon;

public class EmojiPackage {

    Emoji[] ICONS;
    int iconRes;

    public EmojiPackage(Emoji[] ICONS, int iconRes) {
        this.ICONS = ICONS;
        this.iconRes = iconRes;
    }

    public Emojicon[] getEmojicons() {
        Emojicon[] emojicons = new Emojicon[this.ICONS.length];
        for (int i = 0; i < this.ICONS.length; i++) {
            emojicons[i] = Emojicon.fromCodePoint(ICONS[i].getCode());
        }

        return emojicons;
    }

    public Emoji[] getICONS() {
        return ICONS;
    }

    public void setICONS(Emoji[] ICONS) {
        this.ICONS = ICONS;
    }

    public int getIconRes() {
        return iconRes;
    }

    public void setIconRes(int iconRes) {
        this.iconRes = iconRes;
    }
}
