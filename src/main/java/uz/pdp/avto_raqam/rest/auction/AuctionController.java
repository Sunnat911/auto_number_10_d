package uz.pdp.avto_raqam.rest.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.avto_raqam.model.response.auction.AuctionResponseModel;
import uz.pdp.avto_raqam.service.aution.AuctionService;

import java.util.List;

@RestController
@RequestMapping("/api/auto/number/auction")
public class AuctionController {

    private final AuctionService auctionService;

    @Autowired
    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @GetMapping("/list")
    public List<AuctionResponseModel> getAuctionList(){

        return auctionService.getAuctionDbList();
    }

}
