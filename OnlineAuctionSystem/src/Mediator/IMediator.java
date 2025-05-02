package Mediator;

import Colleague.IColleague;

public interface IMediator {

    void addBidder(IColleague bidder);
    void placeBid(IColleague bidder, int bidAmount);
}
