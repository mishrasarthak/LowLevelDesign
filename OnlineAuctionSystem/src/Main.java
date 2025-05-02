import Colleague.Bidder;
import Colleague.IColleague;
import Mediator.AuctionManager;
import Mediator.IMediator;

public class Main {
    public static void main(String[] args) {
        IMediator auctionManager = new AuctionManager();
        IColleague bidder1 = new Bidder("Bidder 1", auctionManager);
        IColleague bidder2 = new Bidder("Bidder 2", auctionManager);

        // Simulate placing bids
        bidder1.placeBid(5000);
        bidder2.placeBid(4000);

    }
}