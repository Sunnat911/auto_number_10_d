package uz.pdp.avto_raqam.admin.controller.auto_number;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.avto_raqam.entity.autoNumber.AutoNumberDatabase;
import uz.pdp.avto_raqam.repository.AutoNumberRepository;
import uz.pdp.avto_raqam.repository.RegionRepository;
import uz.pdp.avto_raqam.service.AutoNumberService;

@Controller
@RequestMapping("/api/admin/auto/number")
public class AutoNumberAdminController {

    private final AutoNumberRepository autoNumberRepository;
    private final RegionRepository regionRepository;
    private final AutoNumberService autoNumberService;

    @Autowired
    public AutoNumberAdminController(AutoNumberRepository autoNumberRepository, RegionRepository regionRepository, AutoNumberService autoNumberService) {
        this.autoNumberRepository = autoNumberRepository;
        this.regionRepository = regionRepository;
        this.autoNumberService = autoNumberService;
    }


    @GetMapping("/list")
    public String getAutoNumberList(Model model){
        model.addAttribute("autoNumberList", autoNumberService.getAutoNumberList());
        model.addAttribute("regionList", regionRepository.findAll());
        model.addAttribute("autoNumber", new AutoNumberDatabase());
        return "admin/auto_number/list";
    }

    @PostMapping("/add")
    public String addAutoNumber(
            @ModelAttribute AutoNumberDatabase autoNumberDatabase){
        autoNumberService.addAutoNumber(autoNumberDatabase);
        return "redirect:/api/admin/auto/number/list";
    }
}
