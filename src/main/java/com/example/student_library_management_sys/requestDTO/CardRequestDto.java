package com.example.student_library_management_sys.requestDTO;

import com.example.student_library_management_sys.enums.CARD_STATUS;
import jakarta.persistence.Column;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

public class CardRequestDto {

    private CARD_STATUS card_status;
    private String expiry_date;


    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    public CARD_STATUS getCard_status() {
        return card_status;
    }

    public void setCard_status(CARD_STATUS card_status) {
        this.card_status = card_status;
    }
}
