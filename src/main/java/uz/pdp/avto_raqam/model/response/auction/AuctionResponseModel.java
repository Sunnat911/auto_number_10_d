package uz.pdp.avto_raqam.model.response.auction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import uz.pdp.avto_raqam.entity.autoNumber.AutoNumberDatabase;
import uz.pdp.avto_raqam.entity.user.UserType;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class AuctionResponseModel {

    @JsonIgnore
    @Autowired
    private SimpleDateFormat simpleDateFormat;

    private int id;
    @JsonProperty("start_price")
    private BigDecimal startPrice;
    @JsonProperty("end_price")
    private BigDecimal endPrice;

    @JsonProperty("auto_number")
    private AutoNumberDatabase autoNumberDatabase;
    @JsonProperty("user_type")
    private UserType userType;
    @JsonProperty("current_price")
    private BigDecimal currentPrice;
    @JsonIgnore
    private Double discount;
    @JsonIgnore
    private Date startedDate;
    @JsonIgnore
    private Date endDate;

    @JsonProperty("discount_price")
    private BigDecimal getDiscountPrice(){
        BigDecimal disCountPrice = startPrice
                .multiply(BigDecimal.valueOf(discount))
                .divide(BigDecimal.valueOf(100));
        return startPrice.add(disCountPrice);
    }

    @JsonProperty("start_date")
    private String startDate(){
        return simpleDateFormat.format(startedDate);
    }

    @JsonProperty("end_date")
    private String endDate(){
        return simpleDateFormat.format(endDate);
    }

    @JsonIgnore
    @Bean
    public SimpleDateFormat getDateFormat(){
        return new SimpleDateFormat("yyyy/MM/dd");
    }

}
