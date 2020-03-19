package learn.oop.jpdppp.bank;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SavedBankInfo {
    private final String path;
    private Map<Integer, BankAccount> accounts;
    private int nextAccount;

    @SuppressWarnings("unchecked")
    public SavedBankInfo(String path) {
        this.path = path;
        File file = new File(path);
        if (!(file.exists())) {
            accounts = new HashMap<>();
            nextAccount = 0;
        } else {
            try (InputStream is = new FileInputStream(file)) {
                ObjectInput ois = new ObjectInputStream(is);
                accounts = (Map<Integer, BankAccount>) ois.readObject();
                nextAccount = ois.readInt();
            } catch (Exception e) {
                throw new RuntimeException("File read exception", e);
            }
        }
    }

    public Map<Integer, BankAccount> getAccounts() {
        return accounts;
    }

    public int nextAcctNum() {
        return nextAccount;
    }

    public void saveMap(Map<Integer, BankAccount> map, int nextAcctNum) {
        try (OutputStream out = new FileOutputStream(path)) {
            ObjectOutput oos = new ObjectOutputStream(out);
            oos.writeObject(map);
            oos.writeInt(nextAcctNum);
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException("File write exception", e);
        }
    }
}
