package hani.momanii.supernova_emoji_library.Models;

public class TabIcon {

    private int icon;
    private boolean isSelected;

    public TabIcon(int icon) {
        this.icon = icon;
        this.isSelected = false;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
