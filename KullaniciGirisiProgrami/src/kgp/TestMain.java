package kgp;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		while (true) {
			
			System.out.println("***************Hoşgeldiniz!***************");
			System.out.println();
			System.out.println(
					"1. Giriş Yap\n" + "2. Kayıt Ol\n" + "3. Çıkış Yap\n" + "Lütfen Yapmak İstediğiniz İşlemi Seçiniz: ");
			System.out.println();
			System.out.println("******************************************");

			int choise = scan.nextInt();
			scan.nextLine();

			switch (choise) {
			case 1: {

				Login lg = new Login();
				lg.logIn();
				break;
			}
			case 2: {

				Register rg = new Register();
				rg.newUser();
				break;
			}
			case 3: {

				System.out.println("Çıkış yapılıyor...");
				System.exit(0);
			}
			default:
				System.out.println("Geçerli bir işlem giriniz: ");
				
			}
		}
	}
}
