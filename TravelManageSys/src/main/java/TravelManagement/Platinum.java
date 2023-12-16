/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TravelManagement;

import AccountManagement.RandIDGenerator;

/**
 *
 * @author bmood
 */
public class Platinum extends Ticket {
    private int Pcounter;

    public Platinum(String TicketID, String TicketType, int TicketCounter) {
        ticketId = TicketID;
        type = TicketType;
        Pcounter = TicketCounter;
    }

    public Platinum() {
        // super.ticketExpiration=; the date the user will choose from the bookoing
        // function
        RandIDGenerator generator = new RandIDGenerator();
        generator.setItemCount(3);
        generator.generateRandID();
        ticketId = generator.getRandID();
    }

    @Override
    public double Ticket_Price(double price) {
        return (0.6 * price) + price;
    }

    public void Add() {
        ticketTypeheader("Platinum");
        System.out.println("how many Platinum tickets you want?");
        addeddTicket = in.nextInt();
        in.nextLine();
        if (addeddTicket > 0) {
            Pcounter += addeddTicket;
            System.out.println("Done! " + addeddTicket + " Platinum tickets added to your cart");
        }
        // else if(addeddTicket > tirpcapacity) {
        // System.out.println("too many tickets entered! avalibale tickerts is"+
        // avalibale);
        // }
        else {
            System.out.println("invalid number of tickets entered! Please try again.");
            Add();
        }

    }

    public void Delete() {
        System.out.println("how many Platinum tickets you want to delete?");
        deletedTicket = in.nextInt();
        in.nextLine();
        if (deletedTicket > 0) {
            if (deletedTicket > Pcounter) {
                System.out.println("you entered more tickets than you have! please tyr again...");
                Delete();
            } else {
                Pcounter -= deletedTicket;
                System.out.println("Done! " + deletedTicket + " Platinum tickets deleted from your cart");
            }
        } else {
            System.out.println("invalid number of tickets entered! Please try again.");
            Delete();
        }
    }

    @Override
    public void setType() {
        this.type = "platinum";
    }

    public String getType() {
        return type;
    }

    @Override
    public int getCounter() {
        return Pcounter;
    }

}
