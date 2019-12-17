import javax.swing.*;
import java.awt.*;

public class BusTicket extends Ticket {

    protected String launchStation;
    protected String destinationStation;
    protected String launchTime;

    public BusTicket(String id, double ticketPrice, String launchStation, String destinationStation, String launchTime) {
        super(id, ticketPrice);
        this.launchStation = launchStation;
        this.destinationStation = destinationStation;
        this.launchTime = launchTime;
    }

    public String getLaunchStation() {
        return launchStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public String getLaunchTime() {
        return launchTime;
    }

    public void setLaunchStation(String launchStation) {
        this.launchStation = launchStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    public void setLaunchTime(String launchTime) {
        this.launchTime = launchTime;
    }

    public void paint(Graphics g) {
        g.drawRoundRect(10, 10, 100, 100, 30, 30);
        g.drawString(id, 20, 35);
        g.drawString(""+price+ " грн.", 20, 55);
        g.drawString(launchStation + " - " + destinationStation, 20, 75);
        g.drawString(launchTime, 20, 95);
    }

    public String getFullInfo() {
        return "TicketPrice: " + price + "\n" + "LaunchStation: " + launchStation + "\n" + "DestinationStation: " + "\n" + "LaunchTime: " + "\n";
    }
}
