package Colleague;

import Mediator.AuctionManager;
import Mediator.IMediator;

public class Bidder implements IColleague {
    String name;
    int bidAmount;

    IMediator auctionManager;

    public Bidder(String name, IMediator auctionManager ) {
        this.name = name;
        this.auctionManager = auctionManager;
        auctionManager.addBidder(this);
    }

    @Override
    public void placeBid(int bidAmount) {
        System.out.println(name + " is placing a bid of " + bidAmount);
        auctionManager.placeBid(this, bidAmount);
    }

    @Override
    public void recieveBidNotification(int bidAmount) {
        System.out.println(name + " received a notification of a new bid: " + bidAmount);
    }

    @Override
    public String getName() {
        return name;
    }

}
