package org.example.dao;

import org.example.model.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    private final String filename = "users.txt";
    private final Map<Long,User> users;

    public UserDaoImpl() {
        this.users = new HashMap<>();
        loadUsersFromFile();
    }

    @Override
    public void addUser(User user) {
        // Assign a unique ID to the user before adding them
        users.put(user.getUserId(), user);
        saveUsersToFile();
    }

    @Override
    public User getUserById(long id) {
        return users.get(id); // Returns the user associated with the given ID or null if not found
    }

    private void loadUsersFromFile() {
        try {
            File file = new File(filename);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

                String line;
                boolean isFirstLine = true;
                while ((line = reader.readLine()) != null) {

                    if (isFirstLine) {
                        isFirstLine = false;
                        continue; // Skip the header line
                    }

                    String[] parts = line.split(",");
                    long userId = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String photoID = parts[2];
                    String photoIDType = parts[3];
                    String addressBasedId = parts[4];
                    String addressBasedIdType = parts[5];
                    String userAddress = parts[6];

                    User user = new User(name, photoID, photoIDType, addressBasedId,addressBasedIdType, userAddress);
                    users.put(userId, user);
                }

                reader.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    private void saveUsersToFile() {
        try {
            File file = new File(filename);
            FileOutputStream fos = new FileOutputStream(file);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

            // Write column names
            writer.write("UserId,Name,PhotoID,PhotoIDType,AddressBasedId,AddressBasedIdType,UserAddress");
            writer.newLine();

            // Write user data
            for (Map.Entry<Long, User> entry : users.entrySet()) {
                User user = entry.getValue();
                String userLine = user.getUserId() + "," + user.getName() + "," + user.getPhotoID() + ","
                        + user.getPhotoIDType() + "," + user.getAddressBasedId() + "," + user.getAddressBasedIdType()+ "," + user.getUserAddress();
                writer.write(userLine);
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
