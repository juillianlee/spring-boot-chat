package br.com.estudos.chat.action;

import br.com.estudos.chat.action.Action;
import br.com.estudos.chat.action.LoginAction;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ActionFactory {

    @Autowired
    ObjectMapper mapper;


    public Action fromJSON(String json) throws JSONException, IOException {
        JSONObject obj = new JSONObject(json);
        String code = obj.optString("code").toUpperCase();
        switch (code) {
            case ActionCode.LOGIN:
                return mapper.readValue(json, LoginAction.class);
            case ActionCode.MSG:
                return mapper.readValue(json, MessageAction.class);
        }
        return null;
    }

}
