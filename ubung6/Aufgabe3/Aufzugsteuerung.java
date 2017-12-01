import IntQueue.java;
public class Aufzugsteuerung{
    int currentFloor;
    int minFloor;
    int MaxFloor;
    //door is open
    int door=1;
    Aufzugsteuerung(int a,int b,int c){
        this.currentFloor=a;
        this.minFloor=b;
        this.MaxFloor=c;    
    }
    void Aufzugup(){
        currentFloor++;
    }
    void Aufzugdown(){
        currentFloor--;
    }
    void doorauf(){
        door=1;
    }
    void doorzu(){
        door=0;
    }

    void request(int floor){
       int k=floor-currentFloor;
       if(isEmpty()){enqueue(0);}
       if(k>0){
           enqueue(4);
           doorzu();
           for(int i=0;i<k;k++){
           enqueue(1);
           Aufzugup();
           }
           enqueue(3);
           doorauf();
       }else if(k==0){
          enqueue(0);
       }else{
           enqueue(4);
           doorzu();
           for(int i=k;i<=0;k++){
            enqueue(2);
            Augzugdown();
            }
            enqueue(3);
            doorauf();
       }


    }
    int action(){
        dequeue();
    }
    
}