package hani.momanii.supernova_emoji_library.Helper;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

import hani.momanii.supernova_emoji_library.Models.TabIcon;
import hani.momanii.supernova_emoji_library.R;

public class EmojisTabIconsAdapter extends RecyclerView.Adapter<EmojisTabIconsAdapter.MyViewHolder> {

    private Context context;
    private List<TabIcon> icons;
    private ViewPager emojisPager;
    private int iconPressedColor;
    private int mEmojiTabLastSelectedIndex;
    private EmojiconRecentsManager mRecentsManager;

    public EmojisTabIconsAdapter(Context context, List<TabIcon> icons, ViewPager emojisPager, int iconPressedColor,
                                 int mEmojiTabLastSelectedIndex, EmojiconRecentsManager mRecentsManager) {
        this.context = context;
        this.icons = icons;
        this.emojisPager = emojisPager;
        this.iconPressedColor = iconPressedColor;
        this.mEmojiTabLastSelectedIndex = mEmojiTabLastSelectedIndex;
        this.mRecentsManager = mRecentsManager;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.emojicon_tab_icon, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        TabIcon icon = this.icons.get(position);

        holder.imageButton.setImageDrawable(context.getResources().getDrawable(icon.getIcon()));
        holder.imageButton.setColorFilter(iconPressedColor);

        holder.imageButton.setSelected(icon.isSelected());

        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emojisPager.setCurrentItem(holder.getAdapterPosition());

                mRecentsManager.setRecentPage(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return icons.size();
    }

    void activePosition(int position) {
        if (mEmojiTabLastSelectedIndex >= 0 && mEmojiTabLastSelectedIndex < icons.size()) {
            this.icons.get(mEmojiTabLastSelectedIndex).setSelected(false);
        }

        this.icons.get(position).setSelected(true);
        mEmojiTabLastSelectedIndex = position;
        notifyDataSetChanged();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageButton imageButton;

        MyViewHolder(View itemView) {
            super(itemView);
            imageButton = itemView.findViewById(R.id.emojis_tab);
        }
    }
}
