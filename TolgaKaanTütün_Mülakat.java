package TolgaKaanTütün_Mülakat;
import java.util.Arrays;
import java.util.Scanner;

// Tolga Kaan Tütün Mülakat Sorusu
//Kar/Kazanç Algoritması

public class TolgaKaanTütün_Mülakat {
	public static void main(String[] args) {
		int hisse[] =new int[] {100, 50, 200, 400, 20, 60, 10, 90, 300, 200}; //Soruda Verilen Örnek Veriler Kullanıldı
		int altin[] =new int[] {20, 30, 40, 10, 5, 80, 100, 60};
		int fon[] =new int[] {20, 10, 5, 30, 60, 90, 40, 50};
		

		
		System.out.print(maxKar(hisse));
		System.out.print(maxKar(altin));
		System.out.print(maxKar(fon));
		
		
		
	
	
	}
	public static int maxKar(int hisse[]) {
		Scanner scanner = new Scanner(System.in);
		
		//Başlangıca en yakın ucuz yerden alım şartı olduğu için verileri ikiye bölerek hesaplamaya başlıyor
		
		int max=hisse[0];
		int lowest=hisse[0];
		int kar=0;
		
		int locationofMax=0;
		int locationofMin=0;
		
		int newLocation=0;
		
		for(int i=0;i<hisse.length/2;i++) { //Başlangıca en yakın ucuz yer ve en fazla kar edebilicek yer tespit ediliyor ve satış yapılıyor
			
			if(hisse[i]>max) {
				max=hisse[i];
				locationofMax=i;
			}
			
			if(hisse[i]<lowest) {
				lowest=hisse[i];
				locationofMin=i;
			}
			
			
			
			
			
		}
		
		if(locationofMin>locationofMax) { //Eğer tespit edilen en ucuz yer en fazla kar edilebilicek günden sonra ise hesaplama tekrar yapılıyor.
				lowest=hisse[0];
				for(int y=0;y<locationofMax;y++) {
					if(hisse[y]<lowest) {
						lowest=hisse[y];
						locationofMin=y;
					}
				}
			}
		
		
		kar=max-lowest; //İlk yapılan satıştan kar
		
		

		locationofMin=locationofMax+1; //1 miktar parça alma şartından sonra en ucuz ve en fazla kar yaratacak yer aranıyor
		newLocation=locationofMax+1;
		
		max=hisse[newLocation];
		lowest=hisse[newLocation];
		
		
		
		
		for(int i=newLocation;i<hisse.length;i++) {
			if(hisse[i]<lowest) {
				lowest=hisse[i];
				locationofMin=i;
			}
			if(hisse[i]>max) {
				max=hisse[i];
				locationofMax=i;
			}
			
		    
			}
		
		
		if(locationofMin>locationofMax) {
			lowest=hisse[hisse.length/2];
			for(int y=hisse.length/2;y<locationofMax;y++) {
				if(hisse[y]<lowest) {
					lowest=hisse[y];
					locationofMin=y;
				}
			}
		}
		//İlk adımdan sonra verilerin kalan kısmından kar hesaplandıktan sonra kullanıcı alacağı adeti seçiyor.
		System.out.println(" Maksimum "+max+" ve Minimum "+lowest+" Olan fiyat aralığında kaç adet altın satın alacaksınız?");

		int adet = scanner.nextInt();
		
		kar=kar+((max-lowest)*adet);
		
		System.out.println(adet+" Miktarında altın satın aldınız. Toplam karınız:"+kar); 
		
		
		
		
		
	return kar;
}
	
	


	

}

