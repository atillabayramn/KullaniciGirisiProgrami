package kgp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Login {

	public Login() {

	}

	public void logIn() {

		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Kullanıcı adınızı giriniz: ");
			String userId = sc.nextLine();
			System.out.println("Şifrenizi giriniz: ");
			String password = sc.nextLine();
			
			if(checkLoginId(userId) && checkLoginPassword(password)) {
				System.out.println("Kullanıcı girişi başarılı...");
				showProfile(userId);
				return;
			} else {
				System.out.println("YANLIŞ Kullanıcı adı veya Şifre!!! Tekrar Deneyiniz...");
			}
		}
	}

	
	public void showProfile(String userId) {
		
		try {
			Scanner userSc = new Scanner(new BufferedReader(new FileReader("user.txt")));
			while(userSc.hasNext()) {
				
				String userInfo = userSc.nextLine();
				
				if(userInfo.startsWith(userId)) {
					String[] userInfoArray = userInfo.split(",");
					
					String name = userInfoArray[2];
					int age = Integer.valueOf(userInfoArray[3]);
					String school = userInfoArray[4];
					String department = userInfoArray[5];
					
					System.out.println("------------------------------------------");
					System.out.println("------------------------------------------");
					System.out.println("*******"+ userId + " Profili" + "*******");
					System.out.println();
					System.out.println("Ad-Soyad: " + name);
					System.out.println("Yaş: " + age);
					System.out.println("Okul: " + school);
					System.out.println("Bölüm: " +department);
					System.out.println();
					System.out.println("------------------------------------------");
					System.out.println("------------------------------------------");
				} 
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("showProfil Hatası");
			e.printStackTrace();
		}
	}
	
	
	
	
	public boolean checkLoginId(String id) {

		try {

			Scanner userSc = new Scanner(new BufferedReader(new FileReader("user.txt")));

			while (userSc.hasNext()) {
				String userInfo = userSc.nextLine();
				String[] userInfoArray = userInfo.split(",");
				String user = userInfoArray[0];

				if (user.equals(id)) {
					return true;
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("checkLoginId Hatası");
			e.printStackTrace();
		}

		return false;
	}
	
	
	public boolean checkLoginPassword(String pass) {
		
		try {

			Scanner userSc = new Scanner(new BufferedReader(new FileReader("user.txt")));

			while (userSc.hasNext()) {
				String userInfo = userSc.nextLine();
				String[] userInfoArray = userInfo.split(",");
				String user = userInfoArray[1];

				if (user.equals(pass)) {
					return true;
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("checkLoginPassword Hatası");
			e.printStackTrace();
		}
		
		
		return false;
	}
}
