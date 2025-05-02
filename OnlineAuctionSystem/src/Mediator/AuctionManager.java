package Mediator;

import Colleague.IColleague;

import java.util.ArrayList;
import java.util.List;

public class AuctionManager implements IMediator{

    List<IColleague> bidderList = new ArrayList<>();
    @Override
    public void addBidder(IColleague bidder) {
        bidderList.add(bidder);
    }

    @Override
    public void placeBid(IColleague bidder, int bidAmount) {
        for(IColleague b : bidderList) {
            if(b != bidder) {
                b.recieveBidNotification(bidAmount);
            }
        }
    }
}
