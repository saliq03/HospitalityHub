package backend;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CombinedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_ROOM = 1;
    private static final int VIEW_TYPE_GUEST = 2;

    private Context mContext;
    private Cursor mRoomCursor;
    private Cursor mGuestCursor;

    public CombinedAdapter(Context context, Cursor roomCursor, Cursor guestCursor) {
        mContext = context;
        mRoomCursor = roomCursor;
        mGuestCursor = guestCursor;
    }

    @Override
    public int getItemViewType(int position) {
        if (position < mRoomCursor.getCount()) {
            return VIEW_TYPE_ROOM;
        } else {
            return VIEW_TYPE_GUEST;
        }
    }
   DatabaseHelper a=new DatabaseHelper();
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view;
        RecyclerView.ViewHolder viewHolder;
        if (viewType == VIEW_TYPE_ROOM) {
            view = inflater.inflate(R.layout.room_item, parent, false);
            viewHolder = new RoomViewHolder(view);
        } else {
            view = inflater.inflate(R.layout.guest_item, parent, false);
            viewHolder = new GuestViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_ROOM) {
            if (!mRoomCursor.moveToPosition(position)) {
                return;
            }

            Object RoomContract;
            Object RoomEntry;
            @SuppressWarnings("Range") String roomName = mRoomCursor.getString(mRoomCursor.getColumnIndex(RoomContract.RoomEntry.COLUMN_ROOM_NAME));
            @SuppressWarnings("Range")String roomType = mRoomCursor.getString(mRoomCursor.getColumnIndex(RoomContract.RoomEntry.COLUMN_ROOM_TYPE));
            @SuppressWarnings("Range")int roomNumber = mRoomCursor.getInt(mRoomCursor.getColumnIndex(RoomContract.RoomEntry.COLUMN_ROOM_NUMBER));
            @SuppressWarnings("Range")double roomRate = mRoomCursor.getDouble(mRoomCursor.getColumnIndex(RoomContract.RoomEntry.COLUMN_ROOM_RATE));

            ((RoomViewHolder) holder).roomNameTextView.setText(roomName);
            ((RoomViewHolder) holder).roomTypeTextView.setText(roomType);
            ((RoomViewHolder) holder).roomNumberTextView.setText(String.valueOf(roomNumber));
            ((RoomViewHolder) holder).roomRateTextView.setText(String.valueOf(roomRate));
        } else {
            int guestPosition = position - mRoomCursor.getCount(); // Adjusting position for guests
            if (!mGuestCursor.moveToPosition(guestPosition)) {
                return;
            }

            Object GuestContract = null;
            @SuppressLint("Range") String guestName = mGuestCursor.getString(mGuestCursor.getColumnIndex(GuestContract.GuestEntry.COLUMN_GUEST_NAME));
            @SuppressLint("Range") String roomType = mGuestCursor.getString(mGuestCursor.getColumnIndex(GuestContract.GuestEntry.COLUMN_ROOM_TYPE));
            @SuppressLint("Range") int availableRooms = mGuestCursor.getInt(mGuestCursor.getColumnIndex(GuestContract.GuestEntry.COLUMN_AVAILABLE_ROOMS));
            @SuppressLint("Range") double actualRoomRate = mGuestCursor.getDouble(mGuestCursor.getColumnIndex(GuestContract.GuestEntry.COLUMN_ACTUAL_ROOM_RATE));

            ((GuestViewHolder) holder).guestNameTextView.setText(guestName);
            ((GuestViewHolder) holder).roomTypeTextView.setText(roomType);
            ((GuestViewHolder) holder).availableRoomsTextView.setText(String.valueOf(availableRooms));
            ((GuestViewHolder) holder).actualRoomRateTextView.setText(String.valueOf(actualRoomRate));
        }
    }

    @Override
    public int getItemCount() {
        return mRoomCursor.getCount() + mGuestCursor.getCount();
    }

    public void swapRoomCursor(Cursor newCursor) {
        if (mRoomCursor != null) {
            mRoomCursor.close();
        }

        mRoomCursor = newCursor;

        if (newCursor != null) {
            notifyDataSetChanged();
        }
    }

    public void swapGuestCursor(Cursor newCursor) {
        if (mGuestCursor != null) {
            mGuestCursor.close();
        }

        mGuestCursor = newCursor;

        if (newCursor != null) {
            notifyDataSetChanged();
        }
    }

    static class RoomViewHolder extends RecyclerView.ViewHolder {
        TextView roomNameTextView;
        TextView roomTypeTextView;
        TextView roomNumberTextView;
        TextView roomRateTextView;

        RoomViewHolder(@NonNull View itemView) {
            super(itemView);
            roomNameTextView = itemView.findViewById(R.id.room_name_textview);
            roomTypeTextView = itemView.findViewById(R.id.room_type_textview);
            roomNumberTextView = itemView.findViewById(R.id.room_number_textview);
            roomRateTextView = itemView.findViewById(R.id.room_rate_textview);
        }
    }

    static class GuestViewHolder extends RecyclerView.ViewHolder {
        TextView guestNameTextView;
        TextView roomTypeTextView;
        TextView availableRoomsTextView;
        TextView actualRoomRateTextView;

        GuestViewHolder(@NonNull View itemView) {
            super(itemView);
            guestNameTextView = itemView.findViewById(R.id.guest_name_textview);
            roomTypeTextView = itemView.findViewById(R.id.room_type_textview);
            availableRoomsTextView = itemView.findViewById(R.id.available_rooms_textview);
            actualRoomRateTextView = itemView.findViewById(R.id.actual_room_rate_textview);
        }
    }
}
