public class ClsTamago {
    //atributs
    private String name;

    private int energy;
    private int hunger;
    private int happiness;

    private int age;

    private int score;
    private String[] statHistory = new String[100];  
    private String code="0-0-0"; // code = (trend(0,5)+"-"+trend(5,20)+"-"+trend(20,65));

    //setters 
    public void setScore(int score){
        this.score=score;
    }
    
    public void setAge(int age){
        this.age=age;
    }

    public void setEnergy(int energy){
        this.energy=energy;
    }
    public void setHunger(int hunger){
        this.hunger=hunger;
    }
    public void setHappiness(int happiness){
        this.happiness=happiness;
    }
    public void setName(String name){
        this.name=name;
    }

    
    //getters
    public int getScore(){
        return this.score;
    }   

    public int getAge(){
        return this.age;
    }
    public int getEnergy(){
        return this.energy;
    }
    public int getHunger(){
        return this.hunger;
    }
    public int getHappiness(){
        return this.happiness;
    }
    public String getName(){
        return this.name;
    }

    //constructeurs
    public ClsTamago(String name){
        setName(name);
        setEnergy(100);
        setHunger(0);
        setHappiness(100);
        setAge(0);
    }




    //methodes
    ///////////////////////////comparaison des status et sauvegarde//////////////////////
    public String stat(int hunger, int energy, int happiness){
        int faim=100-hunger;
        String status="";
        if (faim <= energy && faim<= happiness) status= "hungry";
        else if ( energy<=faim && energy<= happiness) status= "tired";
        else if (happiness <= energy && happiness<= faim) status= "sad";

        return status;
    }
    public void saveStat(){
        statHistory[age] = stat(hunger, energy, happiness);            
        }

    /////////////////// calcule des tandences pour evolution ////////////////////////////////////////
    public String trend(int start, int end){
        String resp="";
        int A=0,B=0,C=0;
        for (int i=start;i<end;i++){
            if("hungry".equals(statHistory[i])){A++;} // statHistory[i]=="hungry" ne marche pas en java
            else if ("tired".equals(statHistory[i]) ){B++;}
            else if ("sad".equals(statHistory[i])){C++;}
         }
         if (A>=B && A>=C) {resp= "A";}
         else if (B>=A && B>=C) {resp= "B";}
         else if (C>=A && C>=B) {resp= "C";}
         return resp;
        }

    public String trendByPeriode(){   
        if(getAge()==5){code = (trend(0,5)+"-0-0");}
        else if(getAge()==20){code = (trend(0,5)+"-"+trend(5,20)+"-0");}
        else if(getAge()==65){code = (trend(0,5)+"-"+trend(5,20)+"-"+trend(20,65));} 
        return code;
        }
    ///////////////////algo encryption///////////////////////////////////////////
    // code = (trend(0,5)+"-"+trend(5,20)+"-"+trend(20,65));


    /////////////////definition des periodes /////////////////////////////////
    public String growing(){
        if (age > 0 && age < 5) return "Baby";
        else if (age >= 5 && age < 20) return "Childhood";
        else if (age >= 20 && age < 65) return "Adulthood";
        else if (age >= 65 && age < 100) return "Elder";
        else return "Dust";   
    }
    ////////////////// table de scoring (a garder??)/////////////////////////////////

    public int scoreTable(String growing, int energy, int hunger, int happiness){
        int point=0;
        if (growing.equals("Baby"))
            {
            if (energy>=70){point+=15;}
                else if  (energy>=50){point+=5;}
                else if (energy>=30){point+=0;}
                else {point-=5;}

            if (hunger<=30){point+=15;}
                else if  (hunger<=50){point+=5;}
                else if (hunger<=70){point+=0;}
                else {point-=5;}

            if (happiness>=70){point+=15;}
                else if  (happiness>=50){point+=5;}
                else if (happiness>=30){point+=0;}
                else {point-=5;}
        
            return point;}


        else if (growing.equals("Childhood"))
            {
            if (energy>=70){point+=20;}
                else if  (energy>=50){point+=10;}
                else if (energy>=30){point+=0;}
                else {point-=10;}

            if (hunger<=30){point+=20;}
                else if  (hunger<=50){point+=10;}
                else if (hunger<=70){point+=0;}
                else {point-=10;}

            if (happiness>=70){point+=20;}
                else if  (happiness>=50){point+=10;}
                else if (happiness>=30){point+=0;}
                else {point-=10;}
      
            return point;}

        else if (growing.equals("Adulthood"))
            {
            if (energy>=70){point+=20;}
                else if  (energy>=50){point+=10;}
                else if (energy>=30){point+=0;}
                else {point-=15;}

            if (hunger<=30){point+=20;}
                else if  (hunger<=50){point+=10;}
                else if (hunger<=70){point+=0;}
                else {point-=15;}

            if (happiness>=70){point+=20;}
                else if  (happiness>=50){point+=10;}
                else if (happiness>=30){point+=0;}
                else {point-=15;}
        
            return point;}

        else if (growing.equals("Elder"))
            {
            if (energy>=80){point+=20;}
                else if  (energy>=50){point+=10;}
                else if (energy>=30){point+=0;}
                else {point-=15;}

            if (hunger<=20){point+=20;}
                else if  (hunger<=50){point+=10;}
                else if (hunger<=70){point+=0;}
                else {point-=15;}

            if (happiness>=80){point+=20;}
                else if  (happiness>=50){point+=10;}
                else if (happiness>=30){point+=0;}
                else {point-=15;}
        
            return point;}

        else return 0;
                                           
    }

    public void updScore(){
        int point=scoreTable(growing(), getEnergy(), getHunger(), getHappiness());
        this.score+=point;
    }
     /////////////////////redefinition des priorité pour chaque periodes//////////////////////////////////////////////////  
    public void timeLapse(){
        if (growing().equals("Baby")) 
            {
            hunger+=7;
            energy-=7;
            happiness-=3;}
        else if (growing().equals("Childhood"))
            {
            hunger+=5;
            energy-=6;
            happiness-=6;}
        else if (growing().equals("Adulthood"))
            {
            hunger+=4;
            energy-=8;
            happiness-=5;}
        else if (growing().equals("Elder"))
            {
            hunger+=6;    
            energy-=5;
            happiness-=6;}


       

        if(energy<0)energy=0;
        if(hunger>100)hunger=100;
        if(happiness<0)happiness=0;

        updScore();
        saveStat();
        age+=1;
        trendByPeriode(); 
        
    }

     //////////////////////action de bases /////////////////////////////////////////////////  

    public void eat(){
        hunger-=10;
        energy+=5;
        happiness+=3;


        if(hunger<0)hunger=0;
        if(happiness>100)happiness=100;
        if(energy>100)energy=100;

        /*System.out.println("ClsTamago func " +getName()+".eat  :OK");*/
        System.out.println("°.O");

    }
    public void sleep(){
        hunger+=3;
        energy+=10;
        happiness+=5;
        

        if(energy>100)energy=100;
        if(hunger>100)hunger=100;
        if(happiness>100)happiness=100;


        /*System.out.println("ClsTamago func " +getName()+".sleep  :OK");*/ 
        System.out.println("*.+");


    }
    public void play(){
        hunger+=5;
        energy-=3;
        happiness+=10;
        


        if(hunger<0)hunger=0;
        if(happiness>100)happiness=100;
        if(energy<0)energy=0;
       
        /*System.out.println("ClsTamago func " +getName()+".play  :OK");*/
        System.out.println("<3");


    }

    public Boolean isAlive(){
        if(energy<=0 || hunger>=100 || happiness<=0 || age>=100){
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("  YOUR TAMAGOCHI "+getName()+" is DEAD!!.");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            return false;
        }
        return true;
        
    }   

    public void status(){
        /*System.out.println("ClsTamago func " +getName()+".status  :OK");*/
        System.out.println(" Name: "+getName()+" - Age: "+getAge()+" - Periode: "+growing()+ " - Score: "+getScore()+ " - Code: "+ code);
        System.out.println(" Hunger: "+getHunger()+ " - Energy: "+getEnergy()+" - Happiness: "+getHappiness()+" - Status: "+stat(getHunger(), getEnergy(), getHappiness()));
    }
}
