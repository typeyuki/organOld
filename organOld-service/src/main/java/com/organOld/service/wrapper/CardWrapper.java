package com.organOld.service.wrapper;

import com.organOld.dao.entity.Card;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.contract.CardRequest;
import com.organOld.service.enumModel.CardStatusEnum;
import com.organOld.service.model.CardModel;
import com.organOld.service.util.Tool;
import org.springframework.beans.BeanUtils;

public class CardWrapper implements Wrapper<Card,CardModel,CardRequest> {

    @Override
    public CardModel wrap(Card card) {
        CardModel cardModel=new CardModel();
        BeanUtils.copyProperties(card,cardModel);
        cardModel.setTime(Tool.dateToString(card.getTime(), TimeConstant.DATA_FORMAT_YMD));
        cardModel.setStatus(CardStatusEnum.getValue(card.getStatus()));
        cardModel.setIsCreate((card.getIsCreate()==1)?"是":"否");
        return cardModel;
    }

    @Override
    public Card unwrap(CardRequest cardRequest) {
        Card card=new Card();
        BeanUtils.copyProperties(cardRequest,card);
        return card;
    }
}
