package com.ifsc.ctds.my_med_api.models;

import com.ifsc.ctds.my_med_api.dto.response.ResponseDTO;

public interface ConvertibleModel extends BaseModel {

    ResponseDTO convert();
}
