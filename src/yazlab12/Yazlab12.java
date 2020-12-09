
package yazlab12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author balpe
 */
public class Yazlab12 {

    ArrayList<Integer> elevators = new ArrayList<Integer>(); // Asansorleri tutacak.
    Vector elevatorVector = new Vector();
    HashMap<Integer,Integer> userHashMap = new HashMap<Integer,Integer>(); // Gelen musterileri tutacak HashMap
    HashMap<Integer,Integer> FloorZeroCostumerHashMap = new HashMap<Integer,Integer>(); // 0.katin musterilerini tutacak HashMap
    HashMap<Integer,Integer> FloorOneCostumerHashMap = new HashMap<Integer,Integer>(); // 1.katin musterilerini tutacak HashMap
    HashMap<Integer,Integer> FloorTwoCostumerHashMap = new HashMap<Integer,Integer>(); // 2.katin musterilerini  tutacak HashMap
    HashMap<Integer,Integer> FloorThreeCostumerHashMap = new HashMap<Integer,Integer>(); // 3.katin musterilerini tutacak HashMap
    HashMap<Integer,Integer> FloorFourCostumerHashMap = new HashMap<Integer,Integer>(); // 4.katin musterilerini tutacak HashMap
    
    
    private int thIstek = 0;
    
    private int yogunluk = 0;
    int zaman = 0;
    int tempCount = 0;
    int elevatorCount = 0;
    
    public synchronized int getTh1istek() {
        return thIstek;
    }

    public synchronized void setTh1istek(int thIstek) {
        this.thIstek = thIstek;
    }
    
    public synchronized int getYogunluk(){
        return yogunluk;
    }
    
    public synchronized void setYogunluk(int yogunluk){
        this.yogunluk = yogunluk;
    }
    
    // Musteri olusturuyoruz.
    public void musteriOlustur(){
        Random r = new Random();
        int x = r.nextInt(11);
        int tempFloor=0;
        if(getYogunluk() + x < 20){ // Toplam musteri sayisi 20nin altinda olmali
            
            for(int i = 0;i<x;i++){ // Musterilerin gidecegi kat bilgisini atiyor.
                
                tempFloor = r.nextInt(5);
                
                if(tempFloor == 0){ // Eger gelen kat sayisi 0 ise 1.kat olarak atiyor.
                    tempFloor +=1;
                }
                userHashMap.put(tempCount,tempFloor); // i.musteri uretilen rastgele kata gidecek.
                FloorZeroCostumerHashMap.put(tempCount,tempFloor);
                tempCount++;
            }
            System.out.println("Gelen kisi sayisi: "+ x);
            System.out.println("Yuklendi.");
            //System.out.println("Yeni gelen musteri : "+ x);
            setYogunluk(getYogunluk() + x);
            System.out.println("Yogunluk: "+getYogunluk());
            elevatorCount = 1; // Yogunluk 20den az ise 1 asansor olacak dusuncesi ile.
        }else {
            // 1.asansor kapasitesi asıldi asansor olustur fonksiyonu calisacak.
        }
    } // musteriOlustur()
    
    public void musteriCikisi(){
        
        // Cikis olurken tempCount-- olacak.
        
    } // musteriCikisi()
    
    public static void main(String[] args) {
        
        Yazlab12 mainController = new Yazlab12();
        mainController.elevators.add(mainController.thIstek);
        
        Elevator mainElevator = new Elevator(); // Ana asansoru olusturduk.
        mainElevator.setActive(true); // Asansor aktif bigisii gonderdik.
        mainElevator.setElevatorID(1);// Id degerini gonderdik.
        
        Elevator secondElevator = new Elevator(); // 2.asansoru olusturduk.
        secondElevator.setActive(false); // Asansor aktif bigisii gonderdik.
        secondElevator.setElevatorID(2); // Id degerini gonderdik.
        
        
        Elevator thirdElevator = new Elevator(); // 3.asansoru olusturduk.
        thirdElevator.setActive(false); // Asansor aktif bigisii gonderdik.
        thirdElevator.setElevatorID(3); // Id degerini gonderdik.
        
        Elevator fourthElevator = new Elevator(); // 4.asansoru olusturduk.
        fourthElevator.setActive(false); // Asansor aktif bigisii gonderdik.
        fourthElevator.setElevatorID(4); // Id degerini gonderdik.
        
        Elevator fifthElevator = new Elevator(); // 5.asansoru olusturduk.
        fifthElevator.setActive(false); // Asansor aktif bigisii gonderdik.
        fifthElevator.setElevatorID(5); // Id degerini gonderdik.
        
        // Olusturulan asansorleri takip kolayligi icin vektorde tuttuk.
        mainController.elevatorVector.add(mainElevator);
        mainController.elevatorVector.add(secondElevator);
        mainController.elevatorVector.add(thirdElevator);
        mainController.elevatorVector.add(fourthElevator);
        mainController.elevatorVector.add(fifthElevator);
        
        while(true){
            try {
                Thread.sleep(100); // 100ms bekle
                mainController.zaman += 100;
                System.out.println("Geçen zaman: " + mainController.zaman);
                if (mainController.zaman % 500 == 0) { // AVM giris, yani musteri olustur fonksiyonu cagrilir.
                    
                    mainController.musteriOlustur();
                    //System.out.println("İstek sayısı: " + mainElevator.getIstek());
                }
                if (mainController.zaman % 1000 == 0) { // AVM cikis, yani musteri cikisini gerceklestiren fonksiyon cagrilir.
                    
                    //mainElevator.musteriCikisi();
                    
                }
                for(int i = 0;i<mainController.userHashMap.size();i++){
                    System.out.println("kisi: "+i+" hedef kat: "+mainController.userHashMap.get(i));
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Yazlab12.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void createElevator(){
        
        
    }
    
}
