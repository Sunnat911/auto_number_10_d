package uz.pdp.avto_raqam.service.aution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.avto_raqam.entity.auksion.AuctionState;
import uz.pdp.avto_raqam.model.response.auction.AuctionResponseModel;
import uz.pdp.avto_raqam.repository.AuctionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuctionService {

    private final AuctionRepository auctionRepository;

    @Autowired
    public AuctionService(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    public List<AuctionResponseModel> getAuctionDbList() {
        List<AuctionResponseModel> list = auctionRepository.findAllByStateId(AuctionState.IN_PROCESS.getStateId())
                .stream()
                .map((auctionDatabase) -> {

                    AuctionResponseModel auctionResponseModel = new AuctionResponseModel();
                    auctionResponseModel.setId(auctionDatabase.getId());
                    auctionResponseModel.setAutoNumberDatabase(auctionDatabase.getAutoNumberDatabase());
                    auctionResponseModel.setCurrentPrice(auctionDatabase.getCurrentPrice());
                    auctionResponseModel.setStartPrice(auctionDatabase.getStartPrice());
                    auctionResponseModel.setDiscount(auctionDatabase.getDisCount());
                    auctionResponseModel.setStartedDate(auctionDatabase.getStartedDate());
                    auctionResponseModel.setEndDate(auctionDatabase.getEndDate());
                    auctionResponseModel.setUserType(auctionDatabase.getUserType());

                    return auctionResponseModel;

                }).collect(Collectors.toList());

        return list;
    }
}
