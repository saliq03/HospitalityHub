package backend;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "hotel.db";
    private static final int DATABASE_VERSION = 1;
    Object GuestContract,RoomContract;

    public DatabaseHelper() {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(RoomContract.RoomEntry.SQL_CREATE_TABLE);
        db.execSQL(GuestContract.GuestEntry.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(RoomContract.RoomEntry.SQL_DROP_TABLE);

        db.execSQL(GuestContract.GuestEntry.SQL_DROP_TABLE);
        onCreate(db);
    }

    // Room CRUD Operations

    public long addRoom(String roomName, String roomType, String acType, int roomNumber, double roomRate, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RoomContract.RoomEntry.COLUMN_ROOM_NAME, roomName);
        values.put(RoomContract.RoomEntry.COLUMN_ROOM_TYPE, roomType);
        values.put(RoomContract.RoomEntry.COLUMN_AC_TYPE, acType);
        values.put(RoomContract.RoomEntry.COLUMN_ROOM_NUMBER, roomNumber);
        values.put(RoomContract.RoomEntry.COLUMN_ROOM_RATE, roomRate);
        values.put(RoomContract.RoomEntry.COLUMN_DATE, date);
        return db.insert(RoomContract.RoomEntry.TABLE_NAME, null, values);
    }

    public Cursor getAllRooms() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(
                RoomContract.RoomEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    public int deleteRoom(int roomNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = RoomContract.RoomEntry.COLUMN_ROOM_NUMBER + " = ?";
        String[] selectionArgs = { String.valueOf(roomNumber) };
        return db.delete(RoomContract.RoomEntry.TABLE_NAME, selection, selectionArgs);
    }

    // Guest CRUD Operations

   public long addGuest(String guestName, String roomType, String acType, int availableRooms, double actualRoomRate,
                         String mobile, String checkInDate, String checkOutDate, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(GuestContract.GuestEntry.COLUMN_GUEST_NAME, guestName);
        values.put(GuestContract.GuestEntry.COLUMN_ROOM_TYPE, roomType);
        values.put(GuestContract.GuestEntry.COLUMN_AC_TYPE, acType);
        values.put(GuestContract.GuestEntry.COLUMN_AVAILABLE_ROOMS, availableRooms);
        values.put(GuestContract.GuestEntry.COLUMN_ACTUAL_ROOM_RATE, actualRoomRate);
        values.put(GuestContract.GuestEntry.COLUMN_MOBILE, mobile);
        values.put(GuestContract.GuestEntry.COLUMN_CHECK_IN_DATE, checkInDate);
        values.put(GuestContract.GuestEntry.COLUMN_CHECK_OUT_DATE, checkOutDate);
        values.put(GuestContract.GuestEntry.COLUMN_DATE, date);
        return db.insert(GuestContract.GuestEntry.TABLE_NAME, null, values);
    }

    public Cursor getAllGuests() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(
                GuestContract.GuestEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    public int deleteGuest(String guestName) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = GuestContract.GuestEntry.COLUMN_GUEST_NAME + " = ?";
        String[] selectionArgs = { guestName };
        return db.delete(GuestContract.GuestEntry.TABLE_NAME, selection, selectionArgs);
    }
}
