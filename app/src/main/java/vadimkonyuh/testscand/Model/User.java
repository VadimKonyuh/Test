package vadimkonyuh.testscand.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.UUID;

@DatabaseTable(tableName = "users")
public class User {

    @DatabaseField(generatedId = true)
    private UUID mID;

    @DatabaseField
    private int mRole; //  0 user, 1 = admim

    public User(UUID ID, int role) {
        mID = ID;
        mRole = role;
    }

    public UUID getID() {

        return mID;
    }

    public void setID(UUID ID) {
        mID = ID;
    }

    public int getRole() {
        return mRole;
    }

    public void setRole(int role) {
        mRole = role;
    }
}
