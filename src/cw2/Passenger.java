package cw2;



public class Passenger {
    public String firstnames;
    public String lastnames;
    public int seatNumber;
    public int Seconds;
    public int secondsInQueue;


    public Passenger(String info , String info2 , int seatInfo,int info4, int info6) {
        super();
        setName(info);
        setLastName(info2);
        setSeatNo(seatInfo);
        setSeconds(info4);
        setSecondsInQueue(info6);

    }

    public Passenger() {

    }


    @Override
    public String toString (){

        return firstnames + " " + lastnames + " " + seatNumber;
    }

    public String getNames(){

        return firstnames;
    }

    public void setName(String firstnames){

        this.firstnames = firstnames;
    }


    public String getLastNames(){

        return lastnames;
    }

    public void setLastName(String lastnames){

        this.lastnames = lastnames;
    }


    public  void setSeconds(int Seconds){
        this.Seconds=Seconds;
    }

    public int getSeconds(){
        return Seconds;
    }


    public void setSecondsInQueue(int secondsInQueue){
        this.secondsInQueue= secondsInQueue;
    }


    public int getSecondsInQueue(){
        return secondsInQueue;

    }



    public int getSeatNo(){

        return seatNumber;
    }

    public void setSeatNo(int seatNumber){

        this.seatNumber = seatNumber;
    }



}
