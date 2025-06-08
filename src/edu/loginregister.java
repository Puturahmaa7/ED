package edu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File; 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class loginregister {
    static final String NAMA_FILE ="DataLoginRegisterPomoFocus.txt";
    static DataPengguna[] DaftarPengguna = new DataPengguna[100];
    static int TotalPengguna = 0;
    
    
    static class DataPengguna {
        String username;
        String password;
        
        public DataPengguna(String username, String password){
            this.username = username;
            this.password = password;
        } 
    }
    

    public static boolean UserExists(String username) {
        for (int i = 0; i < TotalPengguna; i++) {
            if (DaftarPengguna[i].username.equals(username)) {
                return true; 
            }
        }
        return false; 
    }


    public static void UserRegister(String username, String password) {
        DaftarPengguna[TotalPengguna] = new DataPengguna(username, password);
        TotalPengguna++;
        try {
            FileSave(); 
        } catch (IOException e) {
            System.out.println("Gagal menyimpan file: " + e.getMessage());
        }
    }
    

    public static boolean ValidasiUser(String username, String password) {
        for (int i = 0; i < TotalPengguna; i++) {
            if (DaftarPengguna[i] != null && DaftarPengguna[i].username.equals(username) && DaftarPengguna[i].password.equals(password)) {
                return true; 
            }
        }
        return false; 
    }
    
    
    public static void FileOpen() throws IOException{
        File file1 = new File(NAMA_FILE);
        try{
            if(!file1.exists()){
                file1.createNewFile();
            }
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        String line;
        
        reader.readLine();
        reader.readLine();
        
        while ((line = reader.readLine()) != null) {
            String[] DataLoginRegister = line.split("\\|");
            if (DataLoginRegister.length == 2) { 
                String username = DataLoginRegister[0].trim();
                String password = DataLoginRegister[1].trim();
                DaftarPengguna[TotalPengguna] = new DataPengguna(username, password);
                TotalPengguna++;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Gagal membuka file: " + e.getMessage());
        }
    }
    
    
    public static void FileSave() throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(NAMA_FILE))){
            writer.write("Username             | Password");
            writer.newLine();
            writer.write("------------------------------------------");
            writer.newLine();
            
            for (int i = 0; i < TotalPengguna; i++){
                DataPengguna pengguna = DaftarPengguna[i];
                if (pengguna != null ){
                    String row = String.format("%-20s | %-20s", pengguna.username, pengguna.password);
                    writer.write(row);
                    writer.newLine();
                    
                }
            }
        }catch (IOException e){
            System.out.println("Gagal menyimpan file: " + e.getMessage());
        }
    }
}
 
