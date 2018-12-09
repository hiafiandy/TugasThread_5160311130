package trit;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;


class Prosesor implements Runnable{
    private int id;
    public Prosesor(int id){
    this.id = id;
    }

    public void run(){
        System.out.println("memulai Task"+id);
    for (int i = 0; i < 100; i++) {
            if(i%2!=0){
                System.out.println(" -> " + i);
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Selesai Task"+id);
        System.out.println("\n");
    }
}

public class Trit{
    public static void main(String[] args){
        ExecutorService service = Executors.newFixedThreadPool(1);
        for (int i=1; i<=5; i++){
            service.submit(new Prosesor(i));
        }
        service.isShutdown();
        try{
            service.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}