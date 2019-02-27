package app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.ArrayList;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue
    private Integer Id = null;
    @NotNull
    @OneToMany
    private List<BuddyInfo> buddies;
    private static final AddressBook INSTANCE = new AddressBook();

    private AddressBook() {
        this.buddies = new ArrayList<>();
    }

    public void addBuddy(BuddyInfo bi) {
        if (bi != null) {
            this.buddies.add(bi);
        }
    }

    public BuddyInfo removeBuddy(int index) {
        if (index >= 0 && index < this.buddies.size()) {
            return this.buddies.remove(index);
        }
        return null;
    }

    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public int size() {
        return buddies.size();
    }

    public void clear() {
        buddies = new ArrayList<>();
    }

    public static AddressBook getInstance() {
        return INSTANCE;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!AddressBook.class.isAssignableFrom(o.getClass())) {
            return false;
        }

        final AddressBook other = (AddressBook) o;

        if (this.buddies.size() != other.buddies.size()) {
            return false;
        }

        for (int i = 0; i < this.buddies.size(); i++) {
            if (!this.buddies.get(i).equals(other.buddies.get(i))) {
                System.out.println("a buddy differed: " + i);
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (BuddyInfo bi : buddies) {
            sb.append(bi.toString());
        }
        return sb.toString();
    }
}
