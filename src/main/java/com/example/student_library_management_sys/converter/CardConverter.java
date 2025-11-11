package com.example.student_library_management_sys.converter;

import com.example.student_library_management_sys.model.Card;
import com.example.student_library_management_sys.requestDTO.CardRequestDto;

public class CardConverter {


    //private CARD_STATUS card_status;
    //    private String genre;
    //    private String language;
    //    private int studentId; (NOT CONSIDERED)

    //***- NO NEED TO CONSIDER FOREIGN KEYS IN CONVERTER


    public static Card convertCardRequestDtoToCard(CardRequestDto cardRequestDto){
        Card card = new Card();
        card.setCard_status(cardRequestDto.getCard_status());
        card.setExpiry_date(cardRequestDto.getExpiry_date());
        return card;

    }

}
