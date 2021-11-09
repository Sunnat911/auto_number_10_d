package uz.pdp.avto_raqam.admin.controller.auction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uz.pdp.avto_raqam.model.response.auction.AuctionAutoNumberAndRegionResponseModel;
import uz.pdp.avto_raqam.repository.AutoNumberRepository;
import uz.pdp.avto_raqam.repository.RegionRepository;

@Controller
@RequestMapping("/api/admin/auction")
public class AuctionAdminController {

    private final RegionRepository regionRepository;
    private final AutoNumberRepository autoNumberRepository;

    public AuctionAdminController(RegionRepository regionRepository, AutoNumberRepository autoNumberRepository) {
        this.regionRepository = regionRepository;
        this.autoNumberRepository = autoNumberRepository;
    }

    @ResponseBody
    @GetMapping("/region_number/list")
    public AuctionAutoNumberAndRegionResponseModel getAuctionAutoNumberAndRegionResponseModel(){
        AuctionAutoNumberAndRegionResponseModel obj = new AuctionAutoNumberAndRegionResponseModel();
        obj.setAutoNumberDatabaseList(autoNumberRepository.findAll());
        obj.setRegionDatabaseList(regionRepository.findAll());

        return obj;
    }

    @GetMapping("/add")
    public String addAuction(
    ){

        return "admin/auction/list";
    }
}

