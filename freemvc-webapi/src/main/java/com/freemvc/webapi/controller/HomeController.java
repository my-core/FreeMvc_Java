package com.freemvc.webapi.controller;

import com.freemvc.datacontract.request.GetUserListRequest;
import com.freemvc.datacontract.response.BaseResponse;
import com.freemvc.datacontract.response.GetUserListResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yangliangbin on 2016/9/22.
 */
@RestController
@RequestMapping("/")
public class HomeController extends  BaseController {
    @RequestMapping("/test")
    public BaseResponse<List<GetUserListResponse>> index(GetUserListRequest request) {
        BaseResponse<List<GetUserListResponse>> response = new BaseResponse<List<GetUserListResponse>>();
        response = getUserService().getUserList(request);
        return response;
    }
}
