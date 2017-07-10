package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("test2", ".txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

            JavaRush javaRush = new JavaRush();
            User user = new User();
           // user.setLastName("Vlad");
            user.setFirstName("Klochkov");
            user.setCountry(User.Country.RUSSIA);
            //user.setBirthDate(new Date("17/07/1988"));
           // user.setMale(true);
            javaRush.users.add(user);
            for (User u : javaRush.users) {
                System.out.println(u.getFirstName() + " " + u.getLastName() + " " + u.getCountry() + " " + u.getBirthDate() + " " + u.isMale());
            }


            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();
            System.out.println(javaRush.hashCode());

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(loadedObject.hashCode());
            for (User u : loadedObject.users) {
                System.out.println(u.getFirstName() + " " + u.getLastName() + " " + u.getCountry() + " " + u.getBirthDate() + " " + u.isMale());
            }
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();
        //DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            if (this.users != null) {
                for (User user : users) {
                    if (user.getFirstName() == null) {
                        writer.println("null");
                    } else {
                        writer.println(user.getFirstName());
                    }
                    if (user.getLastName() == null) {
                        writer.println("null");
                    } else {
                        writer.println(user.getLastName());
                    }
                    if (user.getCountry().getDisplayedName() == null) {
                        writer.println("null");
                    } else {
                        writer.println(user.getCountry().getDisplayedName());
                    }
                    if (user.isMale() == false) {
                        writer.println(false);
                    } else {
                        writer.println(user.isMale());
                    }
                    if (user.getBirthDate() == null) {
                        writer.println("null");
                    } else {
                        writer.println(user.getBirthDate().getTime());
                    }
                }
            }
            writer.flush();
            writer.close();
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                User user = new User();
                String FirstName = reader.readLine();
                if (!FirstName.equals("null")) {
                    user.setFirstName(FirstName);
                } else {
                    user.setFirstName(FirstName);
                }
                String LastName = reader.readLine();
                if (!LastName.equals("null")) {
                    user.setLastName(LastName);
                } else {
                    user.setLastName(LastName);
                }
                String Country = reader.readLine();
                if (!Country.equals("null")) {
                    if (Country.equals("Russia")) user.setCountry(User.Country.RUSSIA);
                    else if (Country.equals("Ukraine")) user.setCountry(User.Country.UKRAINE);
                } else {
                    user.setCountry(User.Country.OTHER);
                }
                Boolean mail = Boolean.valueOf(reader.readLine());
                if (mail == true) {
                    user.setMale(mail);
                } else {
                    user.setMale(mail);
                }
                String d = reader.readLine();
                if (!d.equals("null")) {
                    Date date = new Date();
                    date.setTime(Long.parseLong(d));
                    user.setBirthDate(date);
                } else {
                    Date date = new Date();
                    user.setBirthDate(date);
                }
                users.add(user);
            }
            reader.close();
            //implement this method - реализуйте этот метод
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
