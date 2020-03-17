package learn.oop.jpdppp.bank;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class SavedBankInfo {
    private final String path;
    private final Map<Integer, BankAccount> accounts = new HashMap<>();
    private int nextAccount = 0;
    private final ByteBuffer byteBuffer = ByteBuffer.allocate(16);

    public SavedBankInfo(String path) {
        this.path = path;
        if (!(new File(path).exists())) {
            return;
        }
        try (InputStream is = new BufferedInputStream(new FileInputStream(path))) {
            readMap(is);
        } catch (IOException e) {
            throw new RuntimeException("File read exception", e);
        }
    }

    public Map<Integer, BankAccount> getAccounts() {
        return accounts;
    }

    public int nextAcctNum() {
        return nextAccount;
    }

    public void saveMap(Map<Integer, BankAccount> map, int nextAcctNum) {
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(path))) {
            writeMap(out, map, nextAcctNum);
        } catch (IOException e) {
            throw new RuntimeException("File write exception", e);
        }
    }

    private void readMap(InputStream in) throws IOException {
        nextAccount = readInt(in);
        BankAccount account = readAccount(in);
        while (account != null) {
            accounts.put(account.getAcctNum(), account);
            account = readAccount(in);
        }
    }

    private void writeMap(OutputStream out, Map<Integer, BankAccount> map, int nextAcctNum) throws IOException {
        writeInt(out, nextAcctNum);
        for (BankAccount account : map.values()) {
            writeAccount(out, account);
        }
    }

    private BankAccount readAccount(InputStream in) throws IOException {
        BankAccount account = null;
        int n = in.read(byteBuffer.array());
        if (n != -1) {
            int num = byteBuffer.getInt(0);
            int type = byteBuffer.getInt(4);
            int balance = byteBuffer.getInt(8);
            int isForeign = byteBuffer.getInt(12);
            TypeStrategy typeStrategy;
            if (type == 1) {
                typeStrategy = new SavingsAccount();
            } else if (type == 2) {
                typeStrategy = new RegularChecking();
            } else {
                typeStrategy = new InterestChecking();
            }
            account = new AbstractBankAccount(num, typeStrategy);
            account.deposit(balance);
            account.setForeign(isForeign == 1);
        }
        return account;
    }

    private void writeAccount(OutputStream out, BankAccount account) throws IOException {
        TypeStrategy typeStrategy = ((AbstractBankAccount) account).getTypeStrategy();
        int type = (typeStrategy instanceof SavingsAccount) ? 1
                : ((typeStrategy instanceof RegularChecking) ? 2 : 3);
        byteBuffer.putInt(0, account.getAcctNum());
        byteBuffer.putInt(4, type);
        byteBuffer.putInt(8, account.getBalance());
        byteBuffer.putInt(12, account.isForeign() ? 1 : 2);
        out.write(byteBuffer.array());
    }

    private void writeInt(OutputStream os, int n) throws IOException {
        byteBuffer.putInt(0, n);
        os.write(byteBuffer.array(), 0, 4);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private int readInt(InputStream in) throws IOException {
        in.read(byteBuffer.array(), 0, 4);
        return byteBuffer.getInt(0);
    }
}
