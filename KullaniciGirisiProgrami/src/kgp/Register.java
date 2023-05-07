package kgp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Register {

	public Register() {

	}

	public void newUser() {
		String userID = createUserId();
		String password = createPassword();

		Scanner sc = new Scanner(System.in);

		System.out.println("Adınızı giriniz: ");
		String name = sc.nextLine();

		System.out.println("Yaşınızı giriniz: ");
		int age = sc.nextInt();
		sc.nextLine();

		System.out.println("Mezun olduğunuz okulun adını giriniz: ");
		String school = sc.nextLine();

		System.out.println("Bitirdiğiniz bölümün adını giriniz: ");
		String department = sc.nextLine();

		User user = new User(userID, password, name, age, school, department);

		saveUser(user);

	}

	public void saveUser(User user) {
		try (BufferedWriter wr = new BufferedWriter(new FileWriter("user.txt", true))) {

			wr.write(user.getUserId() + "," + user.getPassword() + "," + user.getName() + "," + user.getAge() + ","
					+ user.getSchool() + "," + user.getDepartment() + "\n");

			System.out.println("Kullanıcı başarılı bir şekilde oluşturuldu...");

		} catch (IOException e) {
			System.out.println("saveUser Hatası");
			e.printStackTrace();
		}

	}

	public String createPassword() {

		while (true) {
			Scanner sc = new Scanner(System.in);

			System.out.println("Parolanızı oluşturunuz: \n" + "Parolanız en az 8 karakter içermelidir!\n"
					+ "Parolanız en az bir büyük harf, bir küçük harf ve bir rakam içermelidir!");

			String password = sc.nextLine();

			while (true) {
				if (!checkPassword(password)) {
					System.out.println("Parola uygun değil.Tekrar deneyiniz! ");
					password = sc.nextLine();
				} else {
					System.out.println("Parola oluşturuldu...");
					return password;
				}
			}

		}
	}

	public boolean checkPassword(String password) {

		if (password.length() < 8) {
			return false;
		}

		for (int i = 0; i < password.length(); i++) {

			if (47 < password.charAt(i) && password.charAt(i) < 58) {
				for (int j = 0; j < password.length(); j++) {
					if (64 < password.charAt(j) && password.charAt(j) < 91) {
						for (int k = 0; k < password.length(); k++) {
							if (96 < password.charAt(k) && password.charAt(k) < 123) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	public String createUserId() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Kullanıcı adı oluşturunuz: ");
		String userId = sc.nextLine();

		while (true) {

			if (!checkUserId(userId)) {
				System.out.println("Kullanıcı adı alınmış. Farklı bir ad giriniz: ");
				userId = sc.nextLine();
			} else {
				System.out.println("Kullanıcı adı oluşturuldu.");
				return userId;
			}
		}
	}

	public boolean checkUserId(String id) {

		try {

			Scanner userSc = new Scanner(new BufferedReader(new FileReader("user.txt")));

			while (userSc.hasNext()) {
				String userInfo = userSc.nextLine();
				String[] userInfoArray = userInfo.split(",");
				String user = userInfoArray[0];

				if (user.equals(id)) {
					return false;
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("userIdCheck Hatası");
			e.printStackTrace();
		}
		return true;
	}

}
