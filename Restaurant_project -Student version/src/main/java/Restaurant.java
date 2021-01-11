import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        //return true;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        LocalTime curTime = getCurrTime();
        if ( curTime.isAfter(this.openingTime) && curTime.isBefore(this.closingTime) ){
            //System.out.println(curTime + "  " + this.openingTime + " " + this.closingTime);
            return true;
        }else{
            //System.out.println( curTime + "  " + this.openingTime + " " + this.closingTime);
            return false;
        }
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public LocalTime getCurrTime(){ return getCurrentTime(); }

    public List<Item> getMenu() {
       // return null;
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
        // private List<Item> menu = new ArrayList<Item>();
        List<Item> sample= new ArrayList<>();
        for (int i = 0; i < menu.size(); i++) {
            sample.add(menu.get(i));
        }
        return sample;
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }


    public int checkPrice(String... menu){
        int sum = 0;
        for (int i =0 ; i < menu.length; i++){
            sum += findPriceByName(menu[i]);
        }
        return sum;
    }

    private int findPriceByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item.getPrice();
        }
        return 0;
    }


}
