package uz.pdp.avto_raqam.admin.controller.region;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.avto_raqam.entity.region.RegionDatabase;
import uz.pdp.avto_raqam.repository.RegionRepository;

import java.util.List;

@Controller
@RequestMapping("/api/admin/region")
public class RegionController {

    @Autowired
    RegionRepository regionRepository;

    @GetMapping("/list")// @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getRegionList(Model model){
        List<RegionDatabase> regionList = regionRepository.findAll(); //db borinb olib keladi hammasini
        model.addAttribute("regionList",regionList);
        model.addAttribute("region", new RegionDatabase());
        return "admin/region/list";
    }

    @PostMapping("/add")
    public String addRegion(
            @ModelAttribute RegionDatabase region,
            Model model
    ){
        regionRepository.save(region);
        return "redirect:/api/admin/region/list";
    }
}
